/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.lsystem;

/**
 * This is a wrapper class to store the results of an LSystem for use by Painter
 * @author Calvin Ashmore
 */
public class LSystemString {

    private String string;
    private double angle;

    public LSystemString(String string, double angle) {
        this.string = string;
        this.angle = angle;
    }

    public String getString() {
        return string;
    }

    public double getAngle() {
        return angle;
    }
}
