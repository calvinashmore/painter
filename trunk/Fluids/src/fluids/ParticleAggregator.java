/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids;

import java.util.ArrayList;
import java.util.List;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class ParticleAggregator<T extends Particle> {

    private static class Cell {

        ArrayList contents = null;
    }
//    private double R;
    private double invR;
    private double minX, minY, minZ;
    private double maxX, maxY, maxZ;
    private Cell[][][] cells;
    private int xSize, ySize, zSize; // call it xCells?
    private List<T> allPoints;

    ParticleAggregator(double R, LVect3d minima, LVect3d maxima, List<T> allPoints) {

//        this.R = R;
        this.invR = 1.0 / R;
        this.allPoints = allPoints;
        minX = minima.x;
        minY = minima.y;
        minZ = minima.z;
        maxX = maxima.x;
        maxY = maxima.y;
        maxZ = maxima.z;

        xSize = (int) Math.ceil((maxX - minX) / R);
        ySize = (int) Math.ceil((maxY - minY) / R);
        zSize = (int) Math.ceil((maxZ - minZ) / R);
        cells = new Cell[xSize][ySize][zSize];
    }

    private int convertX(double x) {
        int r = (int) Math.floor((x - minX) * invR);
        r = Math.max(Math.min(r, xSize - 1), 0);
        return r;
    }

    private int convertY(double y) {
        int r = (int) Math.floor((y - minY) * invR);
        r = Math.max(Math.min(r, ySize - 1), 0);
        return r;
    }

    private int convertZ(double z) {
        int r = (int) Math.floor((z - minZ) * invR);
        r = Math.max(Math.min(r, zSize - 1), 0);
        return r;
    }

    public void update() {
        // clear cells
        for (int ix = 0; ix < xSize; ix++) {
            for (int iy = 0; iy < ySize; iy++) {
                for (int iz = 0; iz < zSize; iz++) {
                    if (cells[ix][iy][iz] != null && cells[ix][iy][iz].contents != null) {
                        cells[ix][iy][iz].contents.clear();
                    }
                }
            }
        }

        int usedCells = 0;
        for (T point : allPoints) {
            int ix = convertX(point.getPosition().x);
            int iy = convertY(point.getPosition().y);
            int iz = convertZ(point.getPosition().z);
            Cell cell = cells[ix][iy][iz]; // throws an AIOOBE if point not in range

            if (cell == null) {
                cell = cells[ix][iy][iz] = new Cell();
            }

            if (cell.contents == null) {
                cell.contents = new ArrayList<T>();
            }
            if (cell.contents.isEmpty()) {
                usedCells++;
            }

            cell.contents.add(point);
        }

        System.out.println("used " + usedCells + " cells out of " + (xSize * ySize * zSize));
    }

//    public List<T> getNeighbors(T point) {
//        return getNeighbors(point.getPosition());
//    }
    public List<T> getNeighbors(LVect3d point, double radius) {
        int ix = convertX(point.x);
        int iy = convertY(point.y);
        int iz = convertZ(point.z);

        int range = (int) Math.ceil(radius * invR);

        List<T> results = new ArrayList<T>();

        for (int x = -range; x <= range; x++) {
            for (int y = -range; y <= range; y++) {
                for (int z = -range; z <= range; z++) {
                    addCell(ix + x, iy + y, iz + z, results);
                }
            }
        }

        return results;
    }

    private void addCell(int ix, int iy, int iz, List<T> results) {
        if (ix < 0 || ix >= xSize
                || iy < 0 || iy >= ySize
                || iz < 0 || iz >= zSize) {
            return;
        }
        if (cells[ix][iy][iz] != null && cells[ix][iy][iz].contents != null) {
            results.addAll(cells[ix][iy][iz].contents);
        }
    }
}
