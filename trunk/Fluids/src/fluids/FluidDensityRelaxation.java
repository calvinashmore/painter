/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids;

import java.util.List;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class FluidDensityRelaxation<T extends Particle> {

    private double restDensity = 10;
    private double stiffness = .004;
    private double nearStiffness = .01;

    public FluidDensityRelaxation() {
    }

    /**
     *
     * @param restDensity default: 10 Controls how dense the fluid wants to be, as in how many neighbors it wants to have. If a neighborhood has more points than this, it will expand. Less than this and it will contract.
     * @param stiffness default: .004 This controls the force at which the fluid expands or contracts to achieve its rest density.
     * @param nearStiffness default: .01 This value controls surface tension. The higher it is, the greater stability of the filaments and the more "stringy" the fluid will be.
     */
    public FluidDensityRelaxation(double restDensity, double stiffness, double nearStiffness) {
        this.restDensity = restDensity;
        this.stiffness = stiffness;
        this.nearStiffness = nearStiffness;
    }

    public void applyRelaxation(Fluid<T> fluid) {

        for (T particle : fluid.getAllParticles()) {
            double density = 0;
            double nearDensity = 0;
            List<T> neighbors = fluid.getNeighbors(particle);
            for (T neighbor : neighbors) {
                double q = fluid.getDistanceSquared(particle, neighbor);
                if (q >= fluid.getInteractionRadiusSquared()) {
                    continue;
                }
                q = 1 - Math.sqrt(q) / fluid.getInteractionRadius();
                density += q * q;//Math.pow(1 - q, 2);
                nearDensity += q * q * q;//Math.pow(1 - q, 3);
            }

            double pressure = stiffness * (density - restDensity);
            double nearPressure = nearStiffness * nearDensity;
            LVect3d displacement = new LVect3d();


//int usedNeighbors = 0;
            for (T neighbor : neighbors) {
                double q = fluid.getDistanceSquared(particle, neighbor);
                if (q >= fluid.getInteractionRadiusSquared()) {
                    continue;
                }
//usedNeighbors++;
                q = 1 - Math.sqrt(q) / fluid.getInteractionRadius();
                LVect3d D = neighbor.getPosition().sub(particle.getPosition());
                D.normalv();

                double pressureInfluence = .5 * fluid.getDt() * fluid.getDt() * (pressure * q + nearPressure * q * q);
                D.multv(pressureInfluence);

                displacement.subv(D);
                neighbor.getPosition().addv(D);
            }
//System.out.println("total neighbors: "+neighbors.size()+" "+usedNeighbors+" used; "+(1.0*usedNeighbors/neighbors.size()));
            particle.getPosition().addv(displacement);
        }
    }
}
