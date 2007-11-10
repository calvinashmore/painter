/*
 * FractalUtil.java
 *
 * Created on November 29, 2006, 4:29 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.cfractal;

import java.util.Random;
import utils.linear.Complex;

/**
 *
 * @author Calvin Ashmore
 */
public class FractalUtil {
    
    static boolean check_j(Complex z, Complex myC, int maxIterations, FractalFunction f, FractalBailout bail) {
        Complex c = new Complex(myC);
        Complex z0 = new Complex(z);
        Complex z1 = new Complex();
        double bailAmmount = f.getBailAmmount();
        for(int i=0;i<maxIterations;i++) {
            f.apply(z0,c,z1);
            if(!bail.test(z1,bailAmmount))
                return false;
            z0.x = z1.x;
            z0.y = z1.y;
        }
        return true;
    }
    
    static boolean check_m(Complex z, int maxIterations, FractalFunction f, FractalBailout bail) {
        Complex c = new Complex(z);
        Complex z0 = new Complex(z);
        Complex z1 = new Complex();
        double bailAmmount = f.getBailAmmount();
        for(int i=0;i<maxIterations;i++) {
            f.apply(z0,c,z1);
            if(!bail.test(z1,bailAmmount))
                return false;
            z0.x = z1.x;
            z0.y = z1.y;
        }
        return true;
    }
    
    static boolean check(Complex test, boolean j, Complex myC, int maxIterations, FractalFunction f, FractalBailout bail) {
        return j ?
            check_j(test, myC, maxIterations, f, bail) :
            check_m(test, maxIterations, f, bail);
    }
    
    public static Complex getZoomCenter(
            Complex oldCenter, double range, Random rand, boolean j,
            Complex myC, int maxIterations, FractalFunction f, FractalBailout bail) {

        Complex inside=null, outside=null;
        for(int i=0;i<200;i++) {
            Complex test = new Complex();
            test.x = oldCenter.x + range*(2*rand.nextDouble()-1);
            test.y = oldCenter.y + range*(2*rand.nextDouble()-1);
            if(check(test,j, myC, maxIterations, f, bail)) {
                inside = test;
                if(outside != null)
                    break;
            } else {
                outside = test;
                if(inside != null)
                    break;
            }
        }

        if(inside == null || outside == null) {
            if(inside == null) {
                inside = new Complex(oldCenter);
                while(!check(inside,j, myC, maxIterations, f, bail)) {
                    if(f.isZeroStable())
                        inside.multv(.9);
                    else
                        inside.multv(2.1);
                }
            }

            if(outside == null) {
                outside = new Complex(oldCenter);
                while(check(outside,j, myC, maxIterations, f, bail)) {
                    if(f.isZeroStable())
                        outside.multv(2.1);
                    else
                        outside.multv(.9);
                }
            }
        }

        // start outside and go in until reaching the inside
        for(int i=0;i<=100;i++) {
            Complex v = new Complex();
            if(f.isZeroStable()) {
                v.x = (1 - i/100.0) * outside.x + (i/100.0) * inside.x;
                v.y = (1 - i/100.0) * outside.y + (i/100.0) * inside.y;
            } else {
                v.x = (i/100.0) * outside.x + (1 - i/100.0) * inside.x;
                v.y = (i/100.0) * outside.y + (1 - i/100.0) * inside.y;
            }
            if(check(v,j, myC, maxIterations, f, bail))
                return v;
        }

        System.out.print("??? ");

        return new Complex(
            (inside.x + outside.x)/2,
            (inside.y + outside.y)/2
            );
    }
}
