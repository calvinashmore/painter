/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.brush;

import java.awt.Graphics2D;
import painter.tools.canvas.Canvas;
import utils.linear.Color;

/**
 * A very simple brush tool
 * @author Calvin Ashmore
 */
public class SimpleBrush implements Brush {

    public void paint(double x, double y, double dx, double dy, double radius, Color color, Canvas canvas) {

        //System.out.println("paint: "+x+", "+y+" ("+radius+"): "+color);
        
//        x = x % 1.0;
//        if (x < 0) {
//            x += 1.0;
//        }
//
//        y = y % 1.0;
//        if (y < 0) {
//            y += 1.0;
//        }

        drawDab(x, y, dx, dy, radius, color, canvas);
    }
    
    protected void drawDab (double x, double y, double dx, double dy, double radius, Color color, Canvas canvas) {
        
        Graphics2D graphics = canvas.getGraphics();

        graphics.setColor(new java.awt.Color(color.toARGB()));
        graphics.fillOval(
                (int)(x*canvas.getWidth()),
                (int)(y*canvas.getHeight()),
                (int)(radius*canvas.getWidth()),
                (int)(radius*canvas.getHeight()));


//        int radiusSteps = 10;
//        int thetaSteps = 30;
//
//        for (int a = 0; a < radiusSteps; a++) {
//            for (int b = 0; b < thetaSteps; b++) {
//
//                double r = radius * a / radiusSteps;
//                double theta = 2 * Math.PI * b / thetaSteps;
//
//                double x1 = x + r * Math.cos(theta);
//                double y1 = y + r * Math.sin(theta);
//                canvas.setColor(x1, y1, color);
//            }
//        }
    }
    
//    public void paintLine(double x1, double y1, double x2, double y2, double radius1, double radius2, Color color, Canvas canvas) {
//        paintLine(x1, y1, x2, y2, radius1, radius2, color, color, canvas);
//    }
//
//    public void paintLine(double x1, double y1, double x2, double y2,
//            double radius1, double radius2,
//            Color color1, Color color2, Canvas canvas) {
//
//        //System.out.println("line: "+x1+", "+y1+", "+x2+", "+y2+" ("+radius1+", "+radius2+"): "+color);
//
//        x1 = x1 % 1.0;
//        if (x1 < 0) {
//            x1 += 1.0;
//        }
//
//        y1 = y1 % 1.0;
//        if (y1 < 0) {
//            y1 += 1.0;
//        }
//
//        double xd = x1-x2;
//        double yd = y1-y2;
//
//        int lineSteps = (int) (20*Math.sqrt(xd*xd+yd*yd));
//
//        for(int i=0; i< lineSteps; i++) {
//            double t = (double)i/lineSteps;
//            double x = t*x2+(1-t)*x1;
//            double y = t*y2+(1-t)*y1;
//            double radius = t*radius2+(1-t)*radius1;
//            Color color = color2.mult(t).add(color1.mult(1-t));
//            drawDab(x, y, radius, color, canvas);
//        }
//    }
}
