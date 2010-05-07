/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.lsystem;

import java.util.List;
import utils.curves.CurveUtil.Curve_v2;
import utils.linear.LVect2d;
import utils.lsystem.LSystem;

/**
 *
 * @author Calvin Ashmore
 */
public class LSystemRenderTest {

    public static void main(String args[]) {
        LSystem lsys = new LSystem();
        lsys.addRule('F', "F+F--F+F");

        String base = lsys.apply("F", 2);
        LSystemRenderer lSystemRenderer = new LSystemRenderer();
        lSystemRenderer.setRotateSize(Math.PI / 6);
        lSystemRenderer.setInitialCoordinates(1, 1, 0);
        lSystemRenderer.setScale(2);
        //lSystemRenderer.setfDistance(Math.pow(1 / 3.7320508075688776, 2));
        List<Curve_v2> process = lSystemRenderer.process(base);

        for (Curve_v2 curve_v2 : process) {
            LVect2d value1 = curve_v2.getValue(0);
            LVect2d value2 = curve_v2.getValue(1);

            System.out.println(value1 + " -> " + value2);
        }
    }
}
