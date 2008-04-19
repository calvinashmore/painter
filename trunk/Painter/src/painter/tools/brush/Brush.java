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

        //System.out.println("paint: "+x+", "+y+" ("+radius+"): "+color);
        
        x = x % 1.0;
        if (x < 0) {
            x += 1.0;
        }

        y = y % 1.0;
        if (y < 0) {
            y += 1.0;
        }

        drawDab(x, y, radius, color, canvas);
    }
    
    private void drawDab (double x, double y, double radius, Color color, Canvas canvas) {
    
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
    
    public void paintLine(double x1, double y1, double x2, double y2, double radius1, double radius2, Color color, Canvas canvas) {

        //System.out.println("line: "+x1+", "+y1+", "+x2+", "+y2+" ("+radius1+", "+radius2+"): "+color);
        
        x1 = x1 % 1.0;
        if (x1 < 0) {
            x1 += 1.0;
        }

        y1 = y1 % 1.0;
        if (y1 < 0) {
            y1 += 1.0;
        }

        double xd = x1-x2;
        double yd = y1-y2;
        
        int lineSteps = (int) (20*Math.sqrt(xd*xd+yd*yd));
        
        for(int i=0; i< lineSteps; i++) {
            double t = (double)i/lineSteps;
            double x = t*x2+(1-t)*x1;
            double y = t*y2+(1-t)*y1;
            double radius = t*radius2+(1-t)*radius1;
            drawDab(x, y, radius, color, canvas);
        }
    }
}
