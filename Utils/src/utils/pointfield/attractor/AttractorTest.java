/*
 * AttractorTest.java
 *
 * Created on May 11, 2006, 8:47 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.pointfield.attractor;

//import geneticimage.NodeFunction;
import utils.pointfield.Point;
import utils.pointfield.Quadtree;

/**
 *
 * @author Calvin Ashmore
 */
public class AttractorTest {
    
    public static void main(String args[]) {new AttractorTest();}
    
    private int numberValues;
    private Quadtree quadtree;
    //private AttractorResult result;
    
    /** Creates a new instance of AttractorTest */
    public AttractorTest() {
        
//        Attractor attractor = new Attractor();
//
//        boolean ok = false;
//
//        APoint3d startVals = new APoint3d();
//        /*startVals.x = Math.random()-.5;
//        startVals.y = Math.random()-.5;
//        startVals.z = Math.random()-.5;*/
//        //new gen.functions.Attractors().build((Class<geneticimage.NodeFunction>)(Class.forName("gen.functions.Attractors.Quadratic3")));
//        AttractorFunction function = new Quadratic3();
//
//        // MAKE adjustParameters or whatever method
//
//        quadtree = new Attractor().makeQuadtree(function,startVals);
//        System.out.println("done?");
//        /*showPointPlot(500);
//        showPointPlot2(500);
//        showPointPlot3(500);*/
    }
    
    private static class PeterDeJong extends AttractorFunction2 {
        
        private double a,b,c,d;
        
        public PeterDeJong() {
            a = Math.random()*8 - 4;
            b = Math.random()*8 - 4;
            c = Math.random()*8 - 4;
            d = Math.random()*8 - 4;
        }
        
        public void apply(APoint2d in_val, APoint2d out_val) {
            
            out_val.x = Math.sin(a*in_val.y) - Math.cos(b*in_val.x);
            out_val.y = Math.sin(c*in_val.x) - Math.cos(d*in_val.y);
        }

        public double derivMagnitude(APoint2d in_val) {
            
            double d00 = a*Math.cos(a*in_val.y);
            double d01 = b*Math.sin(b*in_val.x);
            double d10 = c*Math.cos(c*in_val.x);
            double d11 = d*Math.sin(d*in_val.y);
            
            return Math.max(
                    Math.abs(d00) + Math.abs(d01),
                    Math.abs(d10) + Math.abs(d11)
                    );
        }
        
        public int getIdealIterations() {return super.getIdealIterations()*4;}
    }
    
    private static class Clifford extends AttractorFunction2 {
        
        private double a,b,c,d;
        
        public Clifford() {
            a = Math.random()*8 - 4;
            b = Math.random()*8 - 4;
            c = Math.random()*8 - 4;
            d = Math.random()*8 - 4;
        }
        
        public void apply(APoint2d in_val, APoint2d out_val) {
            
            out_val.x = Math.sin(a*in_val.y) + b*Math.cos(a*in_val.x);
            out_val.y = Math.sin(c*in_val.x) + d*Math.cos(c*in_val.y);
        }

        public double derivMagnitude(APoint2d in_val) {
            
            double d00 = a*Math.cos(a*in_val.y);
            double d01 = -b*a*Math.sin(a*in_val.x);
            double d10 = c*Math.cos(c*in_val.x);
            double d11 = -d*c*Math.sin(c*in_val.y);
            
            return Math.max(
                    Math.abs(d00) + Math.abs(d01),
                    Math.abs(d10) + Math.abs(d11)
                    );
        }
        
        public int getIdealIterations() {return super.getIdealIterations()*4;}
    }
    
    private static class Quadratic2_x1 extends AttractorFunction2 {
        
        private double a[];
        private double b[];
        
        public Quadratic2_x1() {
            a = new double[6];
            b = new double[6];
            for(int i=0;i<6;i++) {
                a[i] = Math.random()*3-1.5;
                b[i] = Math.random()*3-1.5;
            }
        }
        
        public void apply(APoint2d in_val, APoint2d out_val) {
            
            double x = in_val.x;
            double y = in_val.y;
            
            out_val.x = x*x*Math.sin(y)*a[0] + x*y*a[1] + y*y*a[2] + x*a[3] + y*a[4] + a[5];
            out_val.y = x*x*Math.cos(y)*b[0] + x*y*b[1] + y*y*b[2] + x*b[3] + y*b[4] + b[5];
        }

        public double derivMagnitude(APoint2d in_val) {
            
            double x = in_val.x;
            double y = in_val.y;
            
            double d00 = 2*x*Math.sin(y)*a[0] + y*a[1] + a[3];
            double d01 = 2*y*a[2] + x*a[1] + a[4] + Math.cos(y)*x*x*a[0];
            double d10 = 2*x*Math.cos(y)*b[0] + y*b[1] + b[3];
            double d11 = 2*y*b[2] + x*b[1] + b[4] + Math.cos(y)*x*x*a[0];
            
            return Math.max(
                    Math.abs(d00) + Math.abs(d01),
                    Math.abs(d10) + Math.abs(d11)
                    );
        }
        
        public int getIdealIterations() {return super.getIdealIterations()/2;}
    }
    
    private static class Quadratic2 extends AttractorFunction2 {
        
        private double a[];
        private double b[];
        
        public Quadratic2() {
            a = new double[6];
            b = new double[6];
            for(int i=0;i<6;i++) {
                a[i] = Math.random()*3-1.5;
                b[i] = Math.random()*3-1.5;
            }
        }
        
        public void apply(APoint2d in_val, APoint2d out_val) {
            
            double x = in_val.x;
            double y = in_val.y;
            
            out_val.x = x*x*a[0] + x*y*a[1] + y*y*a[2] + x*a[3] + y*a[4] + a[5];
            out_val.y = x*x*b[0] + x*y*b[1] + y*y*b[2] + x*b[3] + y*b[4] + b[5];
        }

        public double derivMagnitude(APoint2d in_val) {
            
            double x = in_val.x;
            double y = in_val.y;
            
            double d00 = 2*x*a[0] + y*a[1] + a[3];
            double d01 = 2*y*a[2] + x*a[1] + a[4];
            double d10 = 2*x*b[0] + y*b[1] + b[3];
            double d11 = 2*y*b[2] + x*b[1] + b[4];
            
            return Math.max(
                    Math.abs(d00) + Math.abs(d01),
                    Math.abs(d10) + Math.abs(d11)
                    );
        }
        
        public int getIdealIterations() {return super.getIdealIterations()/2;}
    }
    
    
    private static class Quadratic3 extends AttractorFunction3 {
        
        private double a[];
        private double b[];
        private double c[];
                
        public void adjustParameters() {
            a = new double[10];
            b = new double[10];
            c = new double[10];
            for(int i=0;i<10;i++) {
                a[i] = Math.random()*2-1;
                b[i] = Math.random()*2-1;
                c[i] = Math.random()*2-1;
            }
        }

        
        public void apply(APoint3d in_val, APoint3d out_val) {
            
            double x = in_val.x;
            double y = in_val.y;
            double z = in_val.z;
            
            out_val.x = x*x*a[0] + x*y*a[1] + x*z*a[2] + y*y*a[3] + y*z*a[4] + z*z*a[5] + x*a[6] + y*a[7] + z*a[8] + a[9];
            out_val.y = x*x*b[0] + x*y*b[1] + x*z*b[2] + y*y*b[3] + y*z*b[4] + z*z*b[5] + x*b[6] + y*b[7] + z*b[8] + b[9];
            out_val.z = x*x*c[0] + x*y*c[1] + x*z*c[2] + y*y*c[3] + y*z*c[4] + z*z*c[5] + x*c[6] + y*c[7] + z*c[8] + c[9];
        }

        public double derivMagnitude(APoint3d in_val) {
            
            double x = in_val.x;
            double y = in_val.y;
            double z = in_val.y;
            
            double d00 = 2*x*a[0] + y*a[1] + z*a[2] + a[6];
            double d01 = 2*y*a[3] + x*a[1] + z*a[4] + a[7];
            double d02 = 2*z*a[5] + x*a[2] + y*a[4] + a[8];
            double d10 = 2*x*b[0] + y*b[1] + z*b[2] + b[6];
            double d11 = 2*y*b[3] + x*b[1] + z*b[4] + b[7];
            double d12 = 2*z*b[5] + x*b[2] + y*b[4] + b[8];
            double d20 = 2*x*c[0] + y*c[1] + z*c[2] + c[6];
            double d21 = 2*y*c[3] + x*c[1] + z*c[4] + c[7];
            double d22 = 2*z*c[5] + x*c[2] + y*c[4] + c[8];
            
            return Math.max( Math.max(
                    Math.abs(d00) + Math.abs(d01) + Math.abs(d02),
                    Math.abs(d10) + Math.abs(d11) + Math.abs(d12)) , 
                    Math.abs(d20) + Math.abs(d21) + Math.abs(d22)
                    );
        }
        
        public int getIdealIterations() {return super.getIdealIterations()/2;}
    }
    
    /*
    private class Quadratic4 extends AttractorFunction4 {
        
        private double a[];
        private double b[];
        private double c[];
        private double d[];
        
        public Quadratic4() {
            a = new double[10];
            b = new double[10];
            c = new double[10];
            d = new double[10];
            for(int i=0;i<10;i++) {
                a[i] = Math.random()*2-1;
                b[i] = Math.random()*2-1;
                c[i] = Math.random()*2-1;
            }
        }
        
        public void apply(double[] in_val, double[] out_val) {
            
            double x = in_val.x;
            double y = in_val.y;
            double z = in_val[2];
            
            out_val.x = x*x*a[0] + x*y*a[1] + x*z*a[2] + y*y*a[3] + y*z*a[4] + z*z*a[5] + x*a[6] + y*a[7] + z*a[8] + a[9];
            out_val.y = x*x*b[0] + x*y*b[1] + x*z*b[2] + y*y*b[3] + y*z*b[4] + z*z*b[5] + x*b[6] + y*b[7] + z*b[8] + b[9];
            out_val[2] = x*x*c.x + x*y*c.y + x*z*c[2] + y*y*c[3] + y*z*c[4] + z*z*c[5] + x*c[6] + y*c[7] + z*c[8] + c[9];
        }

        public double derivMagnitude(double[] in_val) {
            
            double x = in_val.x;
            double y = in_val.y;
            double z = in_val.y;
            
            double d00 = 2*x*a[0] + y*a[1] + z*a[2] + a[6];
            double d01 = 2*y*a[3] + x*a[1] + z*a[4] + a[7];
            double d02 = 2*z*a[5] + x*a[2] + y*a[4] + a[8];
            double d10 = 2*x*b[0] + y*b[1] + z*b[2] + b[6];
            double d11 = 2*y*b[3] + x*b[1] + z*b[4] + b[7];
            double d12 = 2*z*b[5] + x*b[2] + y*b[4] + b[8];
            double d20 = 2*x*c.x + y*c.y + z*c[2] + c[6];
            double d21 = 2*y*c[3] + x*c.y + z*c[4] + c[7];
            double d22 = 2*z*c[5] + x*c[2] + y*c[4] + c[8];
            
            return Math.max( Math.max(
                    Math.abs(d00) + Math.abs(d01) + Math.abs(d02),
                    Math.abs(d10) + Math.abs(d11) + Math.abs(d12)) , 
                    Math.abs(d20) + Math.abs(d21) + Math.abs(d22)
                    );
        }
    }*/
    
    private static class Cubic2 extends AttractorFunction2 {
        
        private double a[];
        private double b[];
        
        public Cubic2() {
            a = new double[10];
            b = new double[10];
            for(int i=0;i<10;i++) {
                a[i] = Math.random()*3-1.5;
                b[i] = Math.random()*3-1.5;
            }
        }
        
        public void apply(APoint2d in_val, APoint2d out_val) {
            
            double x = in_val.x;
            double y = in_val.y;
            
            out_val.x = 
                    x*x*x*a[0] + x*x*y*a[1] + x*y*y*a[2] + y*y*y*a[3] +
                    x*x*a[4] + x*y*a[5] + y*y*a[6] + x*a[7] + y*a[8] + a[9];
            out_val.y = 
                    x*x*x*b[0] + x*x*y*b[1] + x*y*y*b[2] + y*y*y*b[3] +
                    x*x*b[4] + x*y*b[5] + y*y*b[6] + x*a[7] + y*b[8] + b[9];
        }

        public double derivMagnitude(APoint2d in_val) {
            
            double x = in_val.x;
            double y = in_val.y;
            
            double d00 = 3*x*x*a[0] + 2*x*y*a[1] + y*y*a[2] + 2*x*a[4] + y*a[5] + a[7];
            double d01 = x*x*a[1] + 2*x*y*a[2] + 3*y*y*a[3] + x*a[5] + 2*y*a[6] + a[8];
            double d10 = 3*x*x*b[0] + 2*x*y*b[1] + y*y*b[2] + 2*x*b[4] + y*b[5] + b[7];
            double d11 = x*x*b[1] + 2*x*y*b[2] + 3*y*y*b[3] + x*b[5] + 2*y*b[6] + b[8];
            
            return Math.max(
                    Math.abs(d00) + Math.abs(d01),
                    Math.abs(d10) + Math.abs(d11)
                    );
        }
        
        public int getIdealIterations() {return super.getIdealIterations()/2;}
    }
    
    
    /*void showPointPlot(final int res) {
        //final utils.linear.grid.ColorGrid cg = new utils.linear.grid.ColorGrid(res,res);
        
        final java.awt.image.BufferedImage img;
        img = new java.awt.image.BufferedImage(res,res, java.awt.image.BufferedImage.TYPE_INT_ARGB);
        java.awt.Graphics g = img.getGraphics();
        
        int lastix = 0;
        int lastiy = 0;
        for(int i=0;i<numberValues;i++) {
            //double x = (getValue(i)[0] - minVals[0]) / (maxVals[0] - minVals[0]);
            //double y = (getValue(i)[1] - minVals[1]) / (maxVals[1] - minVals[1]);
            
            //double z = (values[i][2] - minVals[2]) / (maxVals[2] - minVals[2]);
            double z = (double)i / numberValues;
            //double z = (values[i+1][0] - minVals[0]) / (maxVals[0] - minVals[0]);
            
            Point point = (Point) quadtree.getPoints().get(i);
            double x = (point.x - quadtree.getMinX()) / (quadtree.getMaxX() - quadtree.getMinX());
            double y = (point.y - quadtree.getMinY()) / (quadtree.getMaxY() - quadtree.getMinY());
            
            int ix = Math.max( Math.min((int)(x*res), res-1), 0);
            int iy = Math.max( Math.min((int)(y*res), res-1), 0);
            
            //cg.setValue( ix, iy, new utils.linear.Color(z,1-z,1));
            //cg.setValue( ix, iy, new utils.linear.Color(1,1,1));
            
            g.setColor( new java.awt.Color((int)(255*z),(int)(255*(1-z)),255) );
            g.drawLine(lastix, lastiy, ix,iy);
            lastix = ix;
            lastiy = iy;
        }
        
        //img = cg.makeImage();
        
        class ShowFrame extends javax.swing.JFrame {
            ShowFrame() {
                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                geneticimage.ui.ImagePanel imagePanel = new geneticimage.ui.ImagePanel();
                imagePanel.setImageSize(res);
                imagePanel.setImage(img);
                add(imagePanel);
                pack();
            }
        }
        new ShowFrame().setVisible(true);
    }*/
    
    utils.linear.Color getPlotColor(java.util.List<Point> things, double x, double y, double radius) {
        
        double pz=0;
        
        double mind = 100;
        for(int i=0;i<things.size();i++) {
            Point p = things.get(i);

            double d = //Math.hypot(x-p[0], y-p[1]);
                    Math.sqrt((x-p.x)*(x-p.x) + (y-p.y)*(y-p.y));
            if(d < mind) {
                mind = d;
                pz = ((APoint3d)p).z;
            }
        }

        double v = mind < radius ? Math.pow(radius-mind,.2) : 0;
        double ts = Math.pow(things.size()/1000.0,.3);
        return new utils.linear.Color(Math.abs(pz),v,ts);
    }
    
    /*void showPointPlot2(final int res) {
        
        final utils.linear.grid.ColorGrid cg = new utils.linear.grid.ColorGrid(res,res);
        
        double radius = .005;
        
        for(int ix=0;ix<res;ix++)
        for(int iy=0;iy<res;iy++) {
            //double x = ((double)ix/res)*(quadtree.getMaxX() - quadtree.getMinX()) + quadtree.getMinX();
            //double y = ((double)iy/res)*(quadtree.getMaxY() - quadtree.getMinY()) + quadtree.getMinY();
            double x = -1 + 2.0*ix/res;
            double y = -1 + 2.0*iy/res;
            
            java.util.List<Point> things = quadtree.getContents(x,y,radius);
            int thingsmax = things.size();
            //cg.setValue( ix, iy, new utils.linear.Color(thingsmax,1,-thingsmax));
            //double v = Math.pow(thingsmax, .5);
            //cg.setValue( ix, iy, new utils.linear.Color(v,v,v ));
            
            utils.linear.Color col = getPlotColor(things, x, y, radius);
            cg.setValue( ix, iy, col);
        }
        
        cg.balance();
        
        class ShowFrame extends javax.swing.JFrame {
            ShowFrame() {
                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                geneticimage.ui.ImagePanel imagePanel = new geneticimage.ui.ImagePanel();
                imagePanel.setImageSize(res);
                imagePanel.setImage(cg.makeImage());
                //imagePanel.setImage(img);
                add(imagePanel);
                pack();
            }
        }
        new ShowFrame().setVisible(true);
    }
    
    void showPointPlot3(final int res) {
        
        final java.awt.image.BufferedImage img = new java.awt.image.BufferedImage(res,res, java.awt.image.BufferedImage.TYPE_INT_ARGB);
        java.awt.Graphics g = img.getGraphics();
        recursiveDrawQTree(quadtree.getTreeRoot(),g,res);
        
        class ShowFrame extends javax.swing.JFrame {
            ShowFrame() {
                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                geneticimage.ui.ImagePanel imagePanel = new geneticimage.ui.ImagePanel();
                imagePanel.setImageSize(res);
                imagePanel.setImage(img);
                add(imagePanel);
                pack();
            }
        }
        new ShowFrame().setVisible(true);
    }*/

//    private void recursiveDrawQTree(Quadtree.TreeCell cell, java.awt.Graphics g, int res) {
//
//        double minx = (cell.getMinRangeX() - quadtree.getMinX()) / (quadtree.getMaxX() - quadtree.getMinX());
//        double miny = (cell.getMinRangeY() - quadtree.getMinY()) / (quadtree.getMaxY() - quadtree.getMinY());
//        double maxx = (cell.getMaxRangeX() - quadtree.getMinX()) / (quadtree.getMaxX() - quadtree.getMinX());
//        double maxy = (cell.getMaxRangeY() - quadtree.getMinY()) / (quadtree.getMaxY() - quadtree.getMinY());
//
//        int iminx = Math.max( Math.min((int)(minx*res), res-1), 0);
//        int iminy = Math.max( Math.min((int)(miny*res), res-1), 0);
//        int imaxx = Math.max( Math.min((int)(maxx*res), res-1), 0);
//        int imaxy = Math.max( Math.min((int)(maxy*res), res-1), 0);
//
//        int col = 255*cell.getDepth() / quadtree.getMaxDepth();
//
//        col = Math.min(col,255);
//        g.setColor(new java.awt.Color(col,col,col));
//        g.fillRect(iminx, iminy, imaxx-iminx, imaxy-iminy);
//
//        if(cell.getC00() != null) recursiveDrawQTree(cell.makeC00(), g, res);
//        if(cell.getC01() != null) recursiveDrawQTree(cell.makeC01(), g, res);
//        if(cell.getC10() != null) recursiveDrawQTree(cell.makeC10(), g, res);
//        if(cell.getC11() != null) recursiveDrawQTree(cell.makeC11(), g, res);
//    }
}
