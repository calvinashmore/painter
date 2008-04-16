/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.brush;

import painter.tools.canvas.Canvas;
import utils.linear.Color;

/**
 * A very simple brush tool
 * @author Calvin Ashmore
 */
public class Brush {

    public void paint(double x, double y, double radius, Color color, Canvas canvas) {

        System.out.println("paint: "+x+", "+y+" ("+radius+"): "+color);
        
        x = x % 1.0;
        if (x < 0) {
            x += 1.0;
        }

        y = y % 1.0;
        if (y < 0) {
            y += 1.0;
        }

        int radiusSteps = 10;
        int thetaSteps = 30;

        for (int a = 0; a < radiusSteps; a++) {
            for (int b = 0; b < thetaSteps; b++) {

                double r = radius * a / radiusSteps;
                double theta = 2 * Math.PI * b / thetaSteps;

                double x1 = x + r * Math.cos(theta);
                double y1 = y + r * Math.sin(theta);
                canvas.setColor(x1, y1, color);
            }
        }

    }
}
