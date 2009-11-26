/*
 * Quadtree.java
 *
 * Created on May 10, 2006, 5:00 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.pointfield;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author gtg126z
 */
public class Quadtree<PointType extends Point> implements java.io.Serializable {

    protected final int maxDepth;
    private TreeCell root;
    private double minX;
    private double maxX;
    private double minY;
    private double maxY;
    
    private int numberSmallCells;
    
    private List<PointType> points;
    
    private int maxDensity;
    public int getMaxDensity() {return maxDensity;}
    
    public Quadtree() {
        maxDepth = 8;
    }
    
    public double getRadiusEstimate() {
        double range = Math.min( maxX-minX, maxY-minY );
        return range/20;
    }
    
    public double getMinX() {return minX;}
    public double getMinY() {return minY;}
    public double getMaxX() {return maxX;}
    public double getMaxY() {return maxY;}
    
    /** Creates a new instance of Quadtree */
    public void setup(double minX, double maxX, double minY, double maxY) {
        
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        
        root = new TreeCell(
                0,
                (float)minX,
                (float)maxX,
                (float)minY,
                (float)maxY
                );
        
        numberSmallCells = 0;
    }
    
    public int getNumberSmallCells() {return numberSmallCells;}
    public List<PointType> getPoints() {return Collections.unmodifiableList(points);}
    public TreeCell getTreeRoot() {return root;}
    public int getMaxDepth() {return maxDepth;}
    
    public void setData(List<PointType> data) {
        
        for(int i=0;i<data.size();i++) {
            Point datum = data.get(i);            
            root.addPoint(datum.x, datum.y);
            //TreeCell tc = root.addPoint(datum[0],datum[1]);
            //if(tc.count == 0)
            //    System.out.println("???");
        }
        
        points = new ArrayList(data);
        Collections.sort(points,new PointComparator());
        
        root.makeIndexBounds(0);
        
        // calculate max density
        maxDensity = 0;
        calcMaxDensity(root);
    }
    
    private void calcMaxDensity(TreeCell cell) {
        if(cell.depth == maxDepth)
            maxDensity = Math.max(cell.getCount(), maxDensity);
        else {
            if(cell.c00 != null) calcMaxDensity(cell.c00);
            if(cell.c01 != null) calcMaxDensity(cell.c01);
            if(cell.c10 != null) calcMaxDensity(cell.c10);
            if(cell.c11 != null) calcMaxDensity(cell.c11);
        }
    }
    
    public List<PointType> getContents(double x, double y, double radius) {
        
        if(root == null)
            return Collections.emptyList();
        
        // transform from (-1,1) to (min,max) for use in evaluators
        //x = ((x+1)/2) * (maxX-minX) + minX;
        //y = ((y+1)/2) * (maxY-minY) + minY;
        
        List<PointType> r = new ArrayList();
        root.addContents(r,x,y,radius);
        return r;
    }
    
    public double convertXFromUnit(double x) { return ((x+1)/2) * (maxX-minX) + minX; }
    public double convertYFromUnit(double y) { return ((y+1)/2) * (maxY-minY) + minY; }
    
    public int getDepth(double x, double y) {
        
        if(root == null)
            return 0;
        
        // transform from (-1,1) to (min,max) for use in evaluators
        //x = ((x+1)/2) * (maxX-minX) + minX;
        //y = ((y+1)/2) * (maxY-minY) + minY;
        
        int depth = 0;
        TreeCell cell = root;
        while(cell != null) {
            if(x < cell.getMidRangeX()) {
                if( y < cell.getMidRangeY()) cell = cell.c00;
                else                         cell = cell.c01;
            } else {
                if( y < cell.getMidRangeY())  cell = cell.c10;
                else                     cell = cell.c11;
            }
            depth++;
        }
        return depth;
    }
    
    protected class PointComparator implements Comparator<Point> {
        public int compare(Point o1, Point o2) {
            
            return root.getOrdinal(o1.x,o1.y) - root.getOrdinal(o2.x,o2.y);
        }
    }
    
    public class TreeCell implements java.io.Serializable {
        TreeCell c00, c10, c01, c11;
        //List<Object> contents;
        //List<Object> fullContents;
        byte depth;
        int count;
        
        int minIndex;
        int maxIndex;
        
        float minRangeX;
        //double midRangeX;
        float midRangeX;
        float maxRangeX;
        float minRangeY;
        //double midRangeY;
        float midRangeY;
        float maxRangeY;
        
        public float getMinRangeX() {return minRangeX;}
        public float getMaxRangeX() {return maxRangeX;}
        public float getMidRangeX() {return midRangeX;}
        public float getMinRangeY() {return minRangeY;}
        public float getMaxRangeY() {return maxRangeY;}
        public float getMidRangeY() {return midRangeY;}
        public int getDepth() {return depth;}
        public int getCount() {return count;}
        
        public TreeCell getC00() {return c00;}
        public TreeCell getC10() {return c10;}
        public TreeCell getC01() {return c01;}
        public TreeCell getC11() {return c11;}
        
        TreeCell(int depth, float minX, float maxX, float minY, float maxY) {
            this.depth = (byte)depth;
            this.minRangeX = minX;
            this.maxRangeX = maxX;
            this.minRangeY = minY;
            this.maxRangeY = maxY;
            this.midRangeX = (minX + maxX)/2;
            this.midRangeY = (minY + maxY)/2;
            
            if( depth == maxDepth )
                numberSmallCells++;
                
        }
        
        /**
         * returns true if this cell is at the lowest level.
         * @return
         */
        public boolean isTerminal() {
            return depth == maxDepth;
        }
        
        public int getOrdinal(double x, double y) {
            if(depth == maxDepth)
                return 1;
            
            int offset = 1 << ((maxDepth-depth-1)<<1);
            //(int)Math.pow(4,maxDepth-depth-1)
            
            if(x < getMidRangeX()) {
                if( y < getMidRangeY()) return offset*0 + c00.getOrdinal(x,y);
                else                    return offset*1 + c01.getOrdinal(x,y);
            } else {
                if( y < getMidRangeY()) return offset*2 + c10.getOrdinal(x,y);
                else                    return offset*3 + c11.getOrdinal(x,y);
            }
        }

        /**
         * Adds the given point to the cell.
         * @param x
         * @param y
         */
        void addPoint(double x, double y) {
            count++;
            if(depth == maxDepth)
                return;
            
            if (x < midRangeX) {
                if (y < midRangeY) {
                    makeC00().addPoint(x, y);
                } else {
                    makeC01().addPoint(x, y);
                }
            } else {
                if (y < midRangeY) {
                    makeC10().addPoint(x, y);
                } else {
                    makeC11().addPoint(x, y);
                }
            }
        }

        /**
         * Calculates the bounds of the cell for building a sublist of the main point list.
         * @param start
         * @return
         */
        int makeIndexBounds(int start) {
            minIndex = start;
            maxIndex = (start+count);
            
            if(depth != maxDepth) {
                int lastEnd = start;
                if(c00!= null) lastEnd = c00.makeIndexBounds(lastEnd);
                if(c01!= null) lastEnd = c01.makeIndexBounds(lastEnd);
                if(c10!= null) lastEnd = c10.makeIndexBounds(lastEnd);
                if(c11!= null) lastEnd = c11.makeIndexBounds(lastEnd);
            }
            
            return maxIndex;
        }
        
        /**
         * Returns all of the points that are in this cell
         * @return
         */
        public List<PointType> getContents() {
            return points.subList(minIndex,maxIndex);
        }

        /**
         * Return all of the points that are within a certain radius of this point.
         * This fills the list provided with the contents of this cell which are around the point.
         * It does not actually affect the contents of the cell itself!
         * @param currentList
         * @param x
         * @param y
         * @param radius
         */
        public void addContents(List<PointType> currentList, double x, double y, double radius) {
            
            if(depth == maxDepth || isFullyInBubble(x,y,radius))
                currentList.addAll( points.subList(minIndex,maxIndex) ); 
            
            else {
                if(c00 != null && c00.isInBubble(x,y,radius))
                    c00.addContents(currentList,x,y,radius);
                
                if(c01 != null && c01.isInBubble(x,y,radius))
                    c01.addContents(currentList,x,y,radius);
                
                if(c10 != null && c10.isInBubble(x,y,radius))
                    c10.addContents(currentList,x,y,radius);
                
                if(c11 != null && c11.isInBubble(x,y,radius))
                    c11.addContents(currentList,x,y,radius);
            }
        }

        /**
         * Returns true if this cell is at least partially in the bubble given by the radius.
         * @param x
         * @param y
         * @param radius
         * @return
         */
        public boolean isInBubble(double x, double y, double radius) {
            return (
                    minRangeX - radius <= x && maxRangeX + radius >= x &&
                    minRangeY - radius <= y && maxRangeY + radius >= y
                    );
        }

        /**
         * returns true if this cell is entirely in the bubble given by the radius.
         * @param x
         * @param y
         * @param radius
         * @return
         */
        public boolean isFullyInBubble(double x, double y, double radius) {
            return (
                    x - radius <= minRangeX && x + radius >= maxRangeX &&
                    y - radius <= minRangeY && y + radius >= maxRangeY
                    );
        }
        
        TreeCell makeC00() {
            if(c00 == null)
                c00 = new TreeCell(
                    depth+1,
                    minRangeX,
                    getMidRangeX(),
                    minRangeY,
                    getMidRangeY()
                    );
            return c00;
        }
        
        TreeCell makeC10() {
            if(c10 == null)
                c10 = new TreeCell(
                    depth+1,
                    getMidRangeX(),
                    maxRangeX,
                    minRangeY,
                    getMidRangeY()
                    );
            return c10;
        }
        
        TreeCell makeC01() {
            if(c01 == null)
                c01 = new TreeCell(
                    depth+1,
                    minRangeX,
                    getMidRangeX(),
                    getMidRangeY(),
                    maxRangeY
                    );
            return c01;
        }
        
        TreeCell makeC11() {
            if(c11 == null)
                c11 = new TreeCell(
                    depth+1,
                    getMidRangeX(),
                    maxRangeX,
                    getMidRangeY(),
                    maxRangeY
                    );
            return c11;
        }
    }
}
