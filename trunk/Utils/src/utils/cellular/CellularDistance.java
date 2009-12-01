/*
 * CellDistance.java
 *
 * Created on October 6, 2005, 9:11 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package utils.cellular;

/**
 *
 * @author Calvin Ashmore
 */
public class CellularDistance implements java.io.Serializable {
    
    private CellularDistance() {}
    
    public static CellularDistance getEuclidean() {
        return new Euclidean();
    }
    
    public static CellularDistance getManhattan() {
        return new Manhattan();
    }
    
    public static CellularDistance getEuclideanStretched(double X, double Y, double Z) {
        return new EuclideanStretched(X,Y,Z);
    }
    
    public static CellularDistance getHyperQuadratic(double X, double Y, double Z) {
        return new HyperQuadratic(X,Y,Z);
    }
    
    public double distance(double dx, double dy, double dz) {return 0;}
    
    public static class Euclidean extends CellularDistance {
        @Override
        public double distance(double dx, double dy, double dz) {
            return dx*dx + dy*dy + dz*dz;
        }
    }
    
    public static class Manhattan extends CellularDistance {
        @Override
        public double distance(double dx, double dy, double dz) {
            return Math.abs(dx) + Math.abs(dy) + Math.abs(dz);
        }
    }
    
    public static class EuclideanStretched extends CellularDistance {
        
        private double X,Y,Z;
        
        public double getX() {return X;}
        public double getY() {return Y;}
        public double getZ() {return Z;}
        
        EuclideanStretched(double X, double Y, double Z) {
            this.X = X;
            this.Y = Y;
            this.Z = Z;
        }
        
        @Override
        public double distance(double dx, double dy, double dz) {
            return X*dx*dx + Y*dy*dy + Z*dz*dz;
        }
    }
    
    public static class HyperQuadratic extends CellularDistance {
        
        private double X,Y,Z;
        
        public double getX() {return X;}
        public double getY() {return Y;}
        public double getZ() {return Z;}
        
        HyperQuadratic(double X, double Y, double Z) {
            this.X = X;
            this.Y = Y;
            this.Z = Z;
        }
        
        @Override
        public double distance(double dx, double dy, double dz) {
            //return X*dx*dx + Y*dy*dy + Z*dz*dz;
            return Math.pow(Math.abs(dx), X) + Math.pow(Math.abs(dy), Y) + Math.pow(Math.abs(dz), Z);
        }
    }
}
