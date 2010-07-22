/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class Fluid<T extends Particle> {

    // current design: all fluid parameters are going into the fluid class, so simulation can only handle one type of fluid at a time.
    // eventually.... could have several types of fluids interacting concurrently, representable by each particle having a pointer to a
    // FluidParameters class.
    // other forces could be incorporated into this class? maybe via overriding methods?
    // parameters
    private double interactionRadius;
    private double interactionRadiusSquared;
    private double dt = 1;
    // working data
    private List<T> activeParticles = new ArrayList<T>();
    private List<T> unmodifiableActiveParticles = Collections.unmodifiableList(activeParticles);
    private ParticleAggregator aggregator;
    //= new ParticleAggregator(
    //      interactionRadius * 2, new LVect3d(-range, -range, -range), new LVect3d(range, range, range), activeParticles);
    // algorithms:
    private FluidCollisions<T> collisions;
    private FluidDensityRelaxation<T> densityRelaxation;
    private FluidForces<T> forces;
    private FluidElastics<T> elastics;
    private FluidViscosity<T> viscosity;
    private List<Emitter<T>> emitters = new ArrayList<Emitter<T>>();

    public Fluid(double interactionRadius) {
        this.interactionRadius = interactionRadius;
        this.interactionRadiusSquared = interactionRadius * interactionRadius;
        this.aggregator = new ParticleAggregator(interactionRadius, activeParticles);
    }

    public void addEmitter(Emitter<T> emitter) {
        emitters.add(emitter);
    }

    public void addParticle(T p) {
        p.index = activeParticles.size();
        activeParticles.add(p);
    }

    public FluidDensityRelaxation<T> getDensityRelaxation() {
        return densityRelaxation;
    }

    public void setDensityRelaxation(FluidDensityRelaxation<T> densityRelaxation) {
        this.densityRelaxation = densityRelaxation;
    }

    public FluidElastics<T> getElastics() {
        return elastics;
    }

    public void setElastics(FluidElastics<T> elastics) {
        this.elastics = elastics;
    }

    public FluidForces<T> getForces() {
        return forces;
    }

    public void setForces(FluidForces<T> forces) {
        this.forces = forces;
    }

    public FluidViscosity<T> getViscosity() {
        return viscosity;
    }

    public void setViscosity(FluidViscosity<T> viscosity) {
        this.viscosity = viscosity;
    }

    public void setCollisions(FluidCollisions<T> collisions) {
        this.collisions = collisions;
    }

    public FluidCollisions<T> getCollisions() {
        return collisions;
    }

    public List<Emitter<T>> getEmitters() {
        return emitters;
    }

    public List<T> getAllParticles() {
        return unmodifiableActiveParticles;
    }

    public double getInteractionRadius() {
        return interactionRadius;
    }

    public double getInteractionRadiusSquared() {
        return interactionRadiusSquared;
    }

    public double getDt() {
        return dt;
    }

    public void setDt(double dt) {
        this.dt = dt;
    }

//    public ParticleAggregator getAggregator() {
//        return aggregator;
//    }
    /**
     * This returns all living particles that are within the interaction radius of the given particle.
     * This may also return particles outside of the radius, but all particles in the radius are guaranteed to be in the resulting list.
     * The given particle is not included within the list of neighbors.
     * @param particle
     * @return
     */
    public List<T> getNeighbors(T particle) {
        List<T> neighbors = aggregator.getNeighbors(particle.getPosition(), interactionRadius);
        neighbors.remove(particle);
        return neighbors;
    }

    public List<T> getNeighbors(LVect3d position) {
        List<T> neighbors = aggregator.getNeighbors(position, interactionRadius);
        return neighbors;
    }

    public List<T> getNeighbors(T particle, double radius) {
        List<T> neighbors = aggregator.getNeighbors(particle.getPosition(), radius);
        neighbors.remove(particle);
        return neighbors;
    }

    /**
     * Returns a list of particles that are close to the hull of 3d points given
     * @param hull
     * @return
     */
    public List<T> getNeighbors(List<LVect3d> hull) {
        return aggregator.getNeighbors(hull, interactionRadius / 2);
    }

    public double getDistanceSquared(T a, T b) {

        double dx = a.getPosition().x - b.getPosition().x;
        double dy = a.getPosition().y - b.getPosition().y;
        double dz = a.getPosition().z - b.getPosition().z;

        return dx * dx + dy * dy + dz * dz;

//        return aggregator.getDistance(a, b);
    }

    public void simulateTimestep() {

        emitParticles();

        // 1: apply forces to each particle
        if (forces != null) {
            forces.applyForces(this);
        }

        // 2: apply viscosity
        if (viscosity != null) {
            viscosity.applyViscosity(this);
        }

        // 3: move particles according to velocity
        applyVelocity();

        if (elastics != null) {
            // 4: add and remove springs, apply rest lengths
            elastics.applyPlasticity(this);

            // 5: apply spring displacement
            elastics.applyElastity(this);
        }

        // 6: relaxations
        if (densityRelaxation != null) {
            densityRelaxation.applyRelaxation(this);
        }

        // 7: collisions
        if (collisions != null) {
            collisions.resolveCollisions(this);
        }

        // 8: compute next velocities
        computeNextVelocity();

        // update the aggregator
        aggregator.update();
    }

    private void applyVelocity() {
        for (T particle : activeParticles) {
            // move particle
            particle.getPreviousPosition().setTo(particle.getPosition());
            particle.getPosition().addv(particle.getVelocity().mult(dt));
        }
    }

    private void computeNextVelocity() {
        for (T particle : activeParticles) {
            LVect3d displacement = particle.getPosition().sub(particle.getPreviousPosition());
            displacement.multv(1.0 / dt);
            if (displacement.magnitude() > 10 * interactionRadius) {
                displacement.normalv();
                displacement.multv(10 * interactionRadius);
            }
            particle.getVelocity().setTo(displacement);
        }
    }

    private void emitParticles() {
        for (Emitter<T> emitter : emitters) {
            emitter.addParticles(this);
        }
    }
}
