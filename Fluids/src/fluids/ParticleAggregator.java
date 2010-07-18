/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.linear.LVect3d;
import utils.linear.LVect3i;

/**
 *
 * @author Calvin Ashmore
 */
public class ParticleAggregator<T extends Particle> {

    private final double gridWidth;
    private final double invGridWidth;
    private final List<Particle> backingArray;
    private Map<LVect3i, List<Particle>> grid;
//    private Map<UnorderedPair<Particle>, Double> distances;

    public ParticleAggregator(double gridWidth, List<Particle> backingArray) {
        this.gridWidth = gridWidth;
        invGridWidth = 1.0 / gridWidth;
        this.backingArray = backingArray;

        grid = new HashMap<LVect3i, List<Particle>>();
//        distances = new HashMap<UnorderedPair<Particle>, Double>();
    }

    private LVect3i getCell(LVect3d pos) {
        int ix = (int) Math.floor(pos.x * invGridWidth);
        int iy = (int) Math.floor(pos.y * invGridWidth);
        int iz = (int) Math.floor(pos.z * invGridWidth);
        return new LVect3i(ix, iy, iz);
    }

    private LVect3i getCell(Particle particle) {
        return getCell(particle.getPosition());
    }

    public void update() {

        for (List<Particle> list : grid.values()) {
            list.clear();
        }
//        distances.clear();

        for (Particle particle : backingArray) {
            LVect3i cell = getCell(particle);
            List<Particle> cellContents = grid.get(cell);
            if (cellContents == null) {
                cellContents = new ArrayList<Particle>();
                grid.put(cell, cellContents);
            }

            cellContents.add(particle);
        }
    }

//    public double getDistance(Particle a, Particle b) {
//        Double d = distances.get(new UnorderedPair<Particle>(a, b));
//        if (d == null) {
//            d = a.distance(b);
//            distances.put(new UnorderedPair<Particle>(a, b), d);
//        }
//        return d;
//    }
    /**
     * This returns a list including all neighbors which are at at most the gridWidth away.
     * This will also return other neighbors which may be further away, as well as the particle in question,
     * so both must be removed for a genuine neighbor search.
     * @param particle
     * @return
     */
    public List<Particle> getNeighbors(Particle particle) {
        return getNeighbors(particle.getPosition(), gridWidth);
    }

    public List<Particle> getNeighbors(LVect3d position, double radius) {
        return getNeighbors(position, radius, radius, radius);
    }

    public List<Particle> getNeighbors(LVect3d position, double dx, double dy, double dz) {
        LVect3i cell = new LVect3i();

        int x0 = (int) Math.floor((position.x - dx) * invGridWidth);
        int x1 = (int) Math.floor((position.x + dx) * invGridWidth);
        int y0 = (int) Math.floor((position.y - dy) * invGridWidth);
        int y1 = (int) Math.floor((position.y + dy) * invGridWidth);
        int z0 = (int) Math.floor((position.z - dz) * invGridWidth);
        int z1 = (int) Math.floor((position.z + dz) * invGridWidth);

//        int cellsSearched=0;
//        int populatedCells=0;

        List<Particle> r = new ArrayList<Particle>();
        for (int i = x0; i <= x1; i++) {
            for (int j = y0; j <= y1; j++) {
                for (int k = z0; k <= z1; k++) {

//                    cellsSearched++;

                    cell.x = i;
                    cell.y = j;
                    cell.z = k;
                    // add neighbors
                    List<Particle> neighborContents = grid.get(cell);
                    if (neighborContents != null) {
                        r.addAll(neighborContents);
//                        populatedCells++;
                    }
                }
            }
        }

        return r;
    }
}
