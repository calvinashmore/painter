/*
 * Attractor.java
 *
 * Created on May 10, 2006, 1:48 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package utils.pointfield.attractor;

import utils.pointfield.Quadtree;

/**
 *
 * @author gtg126z
 */
public class Attractor<Function extends AttractorFunction> {

    private int maxIterations;
    private int preIterations;
    private Function f;
    private Quadtree quadtree;
    private APoint startPoint;
    private AttractorResult result;

    public Attractor(Function f, APoint startPoint) {
        maxIterations = 2000;
        preIterations = 1000;

        this.f = f;
        this.startPoint = startPoint;
    }

    public AttractorResult getResult() {
        if (result == null) {
            result = makeResult(f, startPoint);
        }
        return result;
    }

    public Function getFunction() {
        return f;
    }

    public Quadtree getQuadtree() {
        if (quadtree == null) {
            quadtree = makeQuadtree(f, startPoint);
        }
        return quadtree;
    }

    public APoint getStartPoint() {
        return startPoint;
    }

    private AttractorResult makeResult(Function f, APoint startPoint) {

        for (int i = 0; i < 1000; i++) {

            // The function!
            //attractor.setFunction( function );
            this.f = f;
            f.adjustParameters();

            double lyapunov = getLyapunov(startPoint);

            if (lyapunov > f.getMinLyapunov() &&
                    lyapunov < f.getMaxLyapunov()) {

                result = execute(startPoint.clone());

                Quadtree qtree = f.makeQuadtree();
                result.configureQuadtree(qtree, 100);
                if (qtree.getNumberSmallCells() < f.getMinimumCells()) {
                    continue;
                }

//                System.out.println(lyapunov);
//                System.out.println(result.getMaxVals().x+", "+result.getMinVals().x);

                return result;
            }
        }

        result = execute(startPoint.clone());
        return result;
    }

    /**
     * This attempts to find a quadtree with a satisfactory Lyapunov exponent and suitable number of quadtree cells.
     * @param f
     * @param startPoint
     * @return
     */
    private Quadtree makeQuadtree(Function f, APoint startPoint) {

        for (int i = 0; i < 1000; i++) {

            // The function!
            //attractor.setFunction( function );
            this.f = f;
            f.adjustParameters();

            double lyapunov = getLyapunov(startPoint);

            if (lyapunov > f.getMinLyapunov() &&
                    lyapunov < f.getMaxLyapunov()) {

                result = execute(startPoint.clone());
                Quadtree qtree = f.makeQuadtree();
                result.configureQuadtree(qtree);
                if (qtree.getNumberSmallCells() < f.getMinimumCells()) {
                    continue;
                }

                return qtree;
            }
        }

        return makeQuadtreeRaw(f, startPoint);
    }

    /**
     * This generates a raw quadtree without any qualifications.
     * @param f
     * @param startPoint
     * @return
     */
    private Quadtree makeQuadtreeRaw(Function f, APoint startPoint) {

        this.f = f;
        result = execute(startPoint.clone());
        Quadtree qtree = f.makeQuadtree();
        result.configureQuadtree(qtree);

        return qtree;
    }

    public AttractorResult execute(APoint start) {

        AttractorResult result = new AttractorResult(f, f.getIdealIterations() - preIterations);

        APoint a = start.clone();
        APoint b = f.getNewPoint();
        APoint t = null;

        for (int i = 0; i < f.getIdealIterations(); i++) {

            // apply function
            f.apply(a, b);

            // swap
            t = b;
            b = a;
            a = t;

            // store
            if (i >= preIterations) {
                a.index = (double) (i - preIterations) / (f.getIdealIterations() - preIterations);
                result.setValue(i - preIterations, a);
            }
        }
        return result;
    }

    public double getLyapunov(APoint start) {

        double sum = 0;
        APoint a = start.clone(); //f.getNewPoint();
        APoint b = f.getNewPoint();
        APoint t = null;

        for (int i = 0; i < maxIterations; i++) {

            if (i > preIterations) {
                sum += Math.log(f.derivMagnitude(a));
            }

            // apply function
            f.apply(a, b);

            // swap
            t = b;
            b = a;
            a = t;

            // test
            if (a.bound() > 100 || a.diff(b) < .0001) {
                return -10000;
            }
        }
        return sum / (maxIterations - preIterations);
    }
}
