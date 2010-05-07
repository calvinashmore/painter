/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.lsystem;

import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import utils.curves.CurveUtil.Curve_v2;
import utils.curves.CurveUtil.Curve_v2_wrap;
import utils.curves.SegmentCurve;
import utils.linear.LVect2d;

/**
 *
 * @author Calvin Ashmore
 */
public class LSystemRenderer {

    private List<AffineTransform> stack = new ArrayList<AffineTransform>();
    private AffineTransform current = new AffineTransform();
    private double rotateSize;
    private double scale = 1;
    private double fDistance = 1;

    public void setRotateSize(double rotateSize) {
        this.rotateSize = rotateSize;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public void setInitialCoordinates(double x, double y, double theta) {
        current.translate(x, y);
        current.rotate(theta);
    }

    public List<Curve_v2> process(String system) {
        List<Curve_v2> curves = new ArrayList<Curve_v2>();

        double startX = current.getTranslateX();
        double startY = current.getTranslateY();

        AffineTransform currentCopy = new AffineTransform(current);
        // run through once to get a sense of sizes
        fDistance = 1;
        for (int i = 0; i < system.length(); i++) {
            char c = system.charAt(i);
            Curve_v2 curve = apply(c);
            if (curve != null) {
                curves.add(curve);
            }
        }

        // get scaling...
        double maxDistance = 0;
        for (Curve_v2 curve : curves) {
            LVect2d endPoint = curve.getValue(1);
            double distance = Math.sqrt(Math.pow(endPoint.x - startX, 2) + Math.pow(endPoint.y - startY, 2));
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }

        double scaling = scale / maxDistance;
        // rescale curves:
        List<Curve_v2> newCurves = new ArrayList<Curve_v2>();
        for (Curve_v2 curve : curves) {

            LVect2d start = curve.getValue(0);
            LVect2d end = curve.getValue(1);
            LVect2d newStart = new LVect2d((start.x - startX) * scaling + startX, (start.y - startY) * scaling + startY);
            LVect2d newEnd = new LVect2d((end.x - startX) * scaling + startX, (end.y - startY) * scaling + startY);
            newCurves.add(createCurve(newStart, newEnd));
        }

        // run through again with scaling information
//        current = currentCopy;
//        curves.clear();
//        fDistance = scale / maxDistance;
//        for (int i = 0; i < system.length(); i++) {
//            char c = system.charAt(i);
//            Curve_v2 curve = apply(c);
//            if (curve != null) {
//                curves.add(curve);
//            }
//        }

        return newCurves;
    }

    private Curve_v2 apply(char c) {
        switch (c) {
            case 'f':
                moveForward();
                return null;
            case 'F':
                return drawForward();
            case '+':
                turn(rotateSize);
                return null;
            case '-':
                turn(-rotateSize);
                return null;
            case '[':
                pushMatrix();
                return null;
            case ']':
                popMatrix();
                return null;
        }
        return null;
    }

    private void moveForward() {
        current.translate(0, fDistance);
    }

    private Curve_v2 drawForward() {

        LVect2d v1 = new LVect2d(current.getTranslateX(), current.getTranslateY());
        current.translate(0, fDistance);
        LVect2d v2 = new LVect2d(current.getTranslateX(), current.getTranslateY());

        return createCurve(v1, v2);
    }

    private void turn(double rotateSize) {
        current.rotate(rotateSize);
    }

    private void pushMatrix() {
        stack.add(new AffineTransform(current));
    }

    private void popMatrix() {
        current = stack.remove(stack.size() - 1);
    }

    private Curve_v2 createCurve(LVect2d v1, LVect2d v2) {
        return new Curve_v2_wrap(new SegmentCurve<LVect2d>(v1, v2));
    }
}
