/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.cellularautomata2.d2;

import java.util.Random;
import utils.cellularautomata2.CellFunction;
import utils.cellularautomata2.CellularAutomata;
import utils.cellularautomata2.Layer;
import utils.linear.LVect2d;

/**
 * Simple reaction diffusion function
 * @author Calvin Ashmore
 */
public class ReactionDiffusion implements CellFunction<LVect2d, CellCoordinate2d> {

    private double growthRate;
    private double Da, Db, s;
    private double[][] beta;
    private double dt;
    private double min = 0, max = 10;
    private int diffusionLevel = 0;

    /**
     * Default values can be: Da = .25, Db = .0625, s = .03125
     * @param Da
     * @param Db
     * @param s 
     * @param dt - represents the timestep
     */
    public ReactionDiffusion(double growthRate, double Da, double Db, double s, double dt) {
        this.growthRate = growthRate;
        this.Da = Da;
        this.Db = Db;
        this.s = s;
        this.dt = dt;
    }

    /**
     * seeds the beta values to be base +/- range.
     * Default values can be 12 +/- .05 up to 12 +/- 3
     * @param random 
     */
    public void seedBeta(int xrange, int yrange, Random random, double base, double range) {
        beta = new double[xrange][yrange];
        for (int x = 0; x < xrange; x++) {
            for (int y = 0; y < yrange; y++) {
                beta[x][y] = (2 * random.nextDouble() - 1) * range + base;
            }
        }
    }

    public void setDiffusionLevel(int diffusionLevel) {
        this.diffusionLevel = diffusionLevel;
    }

    /**
     * Set bounds for the max concentration. Defaults to 0-10
     * @param min
     * @param max 
     */
    public void setBounds(double min, double max) {
        this.min = min;
        this.max = max;
    }

    private double accessBeta(int x, int y) {
        // wrap automatically
        x = (((x % beta.length) + beta.length) % beta.length);
        y = (((y % beta[0].length) + beta[0].length) % beta[0].length);

        return beta[x][y];
    }

    private LVect2d getDiffusion(CellCoordinate2d coord, Layer<LVect2d, CellCoordinate2d> layer) {

        LVect2d cell = layer.getData(coord);

        if (diffusionLevel <= 0) {

            LVect2d diffusion = new LVect2d();
            diffusion.addv(layer.getData(new CellCoordinate2d(coord.x - 1, coord.y)));
            diffusion.addv(layer.getData(new CellCoordinate2d(coord.x + 1, coord.y)));
            diffusion.addv(layer.getData(new CellCoordinate2d(coord.x, coord.y - 1)));
            diffusion.addv(layer.getData(new CellCoordinate2d(coord.x, coord.y + 1)));
            diffusion.multv(.25);
            diffusion.subv(cell);
            return diffusion;
        }

        double amount = 0;
        LVect2d diffusion = new LVect2d();

        for (int i = -diffusionLevel; i <= diffusionLevel; i++) {
            for (int j = -diffusionLevel; j <= diffusionLevel; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                double partial = 1.0 / Math.sqrt(i + j);
                diffusion.addv(layer.getData(new CellCoordinate2d(coord.x + i, coord.y + j)).mult(partial));
                amount += partial;
            }
        }
        diffusion.multv(1.0 / amount);
        diffusion.subv(cell);
        return diffusion;
    }

    public LVect2d evaluate(CellCoordinate2d coord, CellularAutomata<LVect2d, CellCoordinate2d> data) {

        Layer<LVect2d, CellCoordinate2d> last = data.getLastLayer(0);

        LVect2d cell = last.getData(coord);

        LVect2d diffusion = getDiffusion(coord, last);
        double deltaX = s * (growthRate - cell.x * cell.y) + Da * diffusion.x;
        double deltaY = s * (cell.x * cell.y - cell.y - accessBeta(coord.x, coord.y)) + Db * diffusion.y;

        double x = cell.x + deltaX * dt;
        double y = cell.y + deltaY * dt;

        return new LVect2d(
                Math.max(Math.min(x, max), min),
                Math.max(Math.min(y, max), min));
    }
}
