package library.expressions.functions;

import genetic.component.context.Context;
import utils.*;
import utils.estimates.*;
import utils.linear.*;
import utils.linear.grid.*;
import utils.noise.*;
import utils.cellular.*;
import utils.cfractal.*;
import java.util.*;
import genetic.*;
import genetic.expression.*;

public class Algebraic implements FunctionGroup, java.io.Serializable {
   static class avg_d extends ExpressionFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         LDouble y = (LDouble)inputs[1]; 
         return new LDouble ( ( x . val + y . val ) / 2 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         return new Estimate_d ( ( x . getMinimum ( ) + y . getMinimum ( ) ) / 2 , ( x . getMaximum ( ) + y . getMaximum ( ) ) / 2 ) ;
      }

   }

   static class avg_c extends ExpressionFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         Complex y = (Complex)inputs[1]; 
         return new Complex ( x . x + y . x , x . y + y . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         Estimate_c y = (Estimate_c)inputs[1]; 
         return new Estimate_c ( ( x . getXMinimum ( ) + y . getXMinimum ( ) ) / 2 , ( x . getXMaximum ( ) + y . getXMaximum ( ) ) / 2 , ( x . getYMinimum ( ) + y . getYMinimum ( ) ) / 2 , ( x . getYMaximum ( ) + y . getYMaximum ( ) ) / 2 ) ;
      }

   }

   static class avg_v2 extends ExpressionFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         return new LVect2d ( x . x + y . x , x . y + y . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         return new Estimate_v2 ( ( x . getXMinimum ( ) + y . getXMinimum ( ) ) / 2 , ( x . getXMaximum ( ) + y . getXMaximum ( ) ) / 2 , ( x . getYMinimum ( ) + y . getYMinimum ( ) ) / 2 , ( x . getYMaximum ( ) + y . getYMaximum ( ) ) / 2 ) ;
      }

   }

   static class avg_v3 extends ExpressionFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         return new LVect3d ( ( x . x + y . x ) / 2 , ( x . y + y . y ) / 2 , ( x . z + y . z ) / 2 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         return new Estimate_v3 ( ( x . getXMinimum ( ) + y . getXMinimum ( ) ) / 2 , ( x . getXMaximum ( ) + y . getXMaximum ( ) ) / 2 , ( x . getYMinimum ( ) + y . getYMinimum ( ) ) / 2 , ( x . getYMaximum ( ) + y . getYMaximum ( ) ) / 2 , ( x . getZMinimum ( ) + y . getZMinimum ( ) ) / 2 , ( x . getZMaximum ( ) + y . getZMaximum ( ) ) / 2 ) ;
      }

   }

   static class add_col extends ExpressionFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         Color y = (Color)inputs[1]; 
         return new Color ( x . r + y . r , x . g + y . g , x . b + y . b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_col y = (Estimate_col)inputs[1]; 
         return new Estimate_col ( x . getRMinimum ( ) + y . getRMinimum ( ) , x . getRMaximum ( ) + y . getRMaximum ( ) , x . getGMinimum ( ) + y . getGMinimum ( ) , x . getGMaximum ( ) + y . getGMaximum ( ) , x . getBMinimum ( ) + y . getBMinimum ( ) , x . getBMaximum ( ) + y . getBMaximum ( ) ) ;
      }

   }

   static class add_d extends ExpressionFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         LDouble y = (LDouble)inputs[1]; 
         return new LDouble ( x . val + y . val ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         return new Estimate_d ( x . getMinimum ( ) + y . getMinimum ( ) , x . getMaximum ( ) + y . getMaximum ( ) ) ;
      }

   }

   static class add_c extends ExpressionFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         Complex y = (Complex)inputs[1]; 
         return new Complex ( x . x + y . x , x . y + y . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         Estimate_c y = (Estimate_c)inputs[1]; 
         return new Estimate_c ( x . getXMinimum ( ) + y . getXMinimum ( ) , x . getXMaximum ( ) + y . getXMaximum ( ) , x . getYMinimum ( ) + y . getYMinimum ( ) , x . getYMaximum ( ) + y . getYMaximum ( ) ) ;
      }

   }

   static class add_v2 extends ExpressionFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         return new LVect2d ( x . x + y . x , x . y + y . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         return new Estimate_v2 ( x . getXMinimum ( ) + y . getXMinimum ( ) , x . getXMaximum ( ) + y . getXMaximum ( ) , x . getYMinimum ( ) + y . getYMinimum ( ) , x . getYMaximum ( ) + y . getYMaximum ( ) ) ;
      }

   }

   static class add_v3 extends ExpressionFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         return new LVect3d ( x . x + y . x , x . y + y . y , x . z + y . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         return new Estimate_v3 ( x . getXMinimum ( ) + y . getXMinimum ( ) , x . getXMaximum ( ) + y . getXMaximum ( ) , x . getYMinimum ( ) + y . getYMinimum ( ) , x . getYMaximum ( ) + y . getYMaximum ( ) , x . getZMinimum ( ) + y . getZMinimum ( ) , x . getZMaximum ( ) + y . getZMaximum ( ) ) ;
      }

   }

   static class sub_col extends ExpressionFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         Color y = (Color)inputs[1]; 
         return new Color ( x . r - y . r , x . g - y . g , x . b - y . b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_col y = (Estimate_col)inputs[1]; 
         double ax = x . getRMaximum ( ) - y . getRMaximum ( ) ; double bx = x . getRMaximum ( ) - y . getRMinimum ( ) ; double cx = x . getRMinimum ( ) - y . getRMaximum ( ) ; double dx = x . getRMinimum ( ) - y . getRMinimum ( ) ; double ay = x . getGMaximum ( ) - y . getGMaximum ( ) ; double by = x . getGMaximum ( ) - y . getGMinimum ( ) ; double cy = x . getGMinimum ( ) - y . getGMaximum ( ) ; double dy = x . getGMinimum ( ) - y . getGMinimum ( ) ; double az = x . getBMaximum ( ) - y . getBMaximum ( ) ; double bz = x . getBMaximum ( ) - y . getBMinimum ( ) ; double cz = x . getBMinimum ( ) - y . getBMaximum ( ) ; double dz = x . getBMinimum ( ) - y . getBMinimum ( ) ; return new Estimate_col ( Math . min ( Math . min ( ax , bx ) , Math . min ( cx , dx ) ) , Math . max ( Math . max ( ax , bx ) , Math . max ( cx , dx ) ) , Math . min ( Math . min ( ay , by ) , Math . min ( cy , dy ) ) , Math . max ( Math . max ( ay , by ) , Math . max ( cy , dy ) ) , Math . min ( Math . min ( az , bz ) , Math . min ( cz , dz ) ) , Math . max ( Math . max ( az , bz ) , Math . max ( cz , dz ) ) ) ;
      }

   }

   static class sub_c extends ExpressionFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         Complex y = (Complex)inputs[1]; 
         return new Complex ( x . x - y . x , x . y - y . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         Estimate_c y = (Estimate_c)inputs[1]; 
         double ax = x . getXMaximum ( ) - y . getXMaximum ( ) ; double bx = x . getXMaximum ( ) - y . getXMinimum ( ) ; double cx = x . getXMinimum ( ) - y . getXMaximum ( ) ; double dx = x . getXMinimum ( ) - y . getXMinimum ( ) ; double ay = x . getYMaximum ( ) - y . getYMaximum ( ) ; double by = x . getYMaximum ( ) - y . getYMinimum ( ) ; double cy = x . getYMinimum ( ) - y . getYMaximum ( ) ; double dy = x . getYMinimum ( ) - y . getYMinimum ( ) ; return new Estimate_c ( Math . min ( Math . min ( ax , bx ) , Math . min ( cx , dx ) ) , Math . max ( Math . max ( ax , bx ) , Math . max ( cx , dx ) ) , Math . min ( Math . min ( ay , by ) , Math . min ( cy , dy ) ) , Math . max ( Math . max ( ay , by ) , Math . max ( cy , dy ) ) ) ;
      }

   }

   static class sub_d extends ExpressionFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         LDouble y = (LDouble)inputs[1]; 
         return new LDouble ( x . val - y . val ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         double ax = x . getMaximum ( ) - y . getMaximum ( ) ; double bx = x . getMaximum ( ) - y . getMinimum ( ) ; double cx = x . getMinimum ( ) - y . getMaximum ( ) ; double dx = x . getMinimum ( ) - y . getMinimum ( ) ; return new Estimate_d ( Math . min ( Math . min ( ax , bx ) , Math . min ( cx , dx ) ) , Math . max ( Math . max ( ax , bx ) , Math . max ( cx , dx ) ) ) ;
      }

   }

   static class sub_v2 extends ExpressionFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         return new LVect2d ( x . x - y . x , x . y - y . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         double ax = x . getXMaximum ( ) - y . getXMaximum ( ) ; double bx = x . getXMaximum ( ) - y . getXMinimum ( ) ; double cx = x . getXMinimum ( ) - y . getXMaximum ( ) ; double dx = x . getXMinimum ( ) - y . getXMinimum ( ) ; double ay = x . getYMaximum ( ) - y . getYMaximum ( ) ; double by = x . getYMaximum ( ) - y . getYMinimum ( ) ; double cy = x . getYMinimum ( ) - y . getYMaximum ( ) ; double dy = x . getYMinimum ( ) - y . getYMinimum ( ) ; return new Estimate_v2 ( Math . min ( Math . min ( ax , bx ) , Math . min ( cx , dx ) ) , Math . max ( Math . max ( ax , bx ) , Math . max ( cx , dx ) ) , Math . min ( Math . min ( ay , by ) , Math . min ( cy , dy ) ) , Math . max ( Math . max ( ay , by ) , Math . max ( cy , dy ) ) ) ;
      }

   }

   static class sub_v3 extends ExpressionFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         return new LVect3d ( x . x - y . x , x . y - y . y , x . z - y . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         double ax = x . getXMaximum ( ) - y . getXMaximum ( ) ; double bx = x . getXMaximum ( ) - y . getXMinimum ( ) ; double cx = x . getXMinimum ( ) - y . getXMaximum ( ) ; double dx = x . getXMinimum ( ) - y . getXMinimum ( ) ; double ay = x . getYMaximum ( ) - y . getYMaximum ( ) ; double by = x . getYMaximum ( ) - y . getYMinimum ( ) ; double cy = x . getYMinimum ( ) - y . getYMaximum ( ) ; double dy = x . getYMinimum ( ) - y . getYMinimum ( ) ; double az = x . getZMaximum ( ) - y . getZMaximum ( ) ; double bz = x . getZMaximum ( ) - y . getZMinimum ( ) ; double cz = x . getZMinimum ( ) - y . getZMaximum ( ) ; double dz = x . getZMinimum ( ) - y . getZMinimum ( ) ; return new Estimate_v3 ( Math . min ( Math . min ( ax , bx ) , Math . min ( cx , dx ) ) , Math . max ( Math . max ( ax , bx ) , Math . max ( cx , dx ) ) , Math . min ( Math . min ( ay , by ) , Math . min ( cy , dy ) ) , Math . max ( Math . max ( ay , by ) , Math . max ( cy , dy ) ) , Math . min ( Math . min ( az , bz ) , Math . min ( cz , dz ) ) , Math . max ( Math . max ( az , bz ) , Math . max ( cz , dz ) ) ) ;
      }

   }

   static class mult_col extends ExpressionFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         LDouble y = (LDouble)inputs[1]; 
         return new Color ( x . r * y . val , x . g * y . val , x . b * y . val ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         double ax = x . getRMaximum ( ) * y . getMaximum ( ) ; double bx = x . getRMaximum ( ) * y . getMinimum ( ) ; double cx = x . getRMinimum ( ) * y . getMaximum ( ) ; double dx = x . getRMinimum ( ) * y . getMinimum ( ) ; double ay = x . getGMaximum ( ) * y . getMaximum ( ) ; double by = x . getGMaximum ( ) * y . getMinimum ( ) ; double cy = x . getGMinimum ( ) * y . getMaximum ( ) ; double dy = x . getGMinimum ( ) * y . getMinimum ( ) ; double az = x . getBMaximum ( ) * y . getMaximum ( ) ; double bz = x . getBMaximum ( ) * y . getMinimum ( ) ; double cz = x . getBMinimum ( ) * y . getMaximum ( ) ; double dz = x . getBMinimum ( ) * y . getMinimum ( ) ; return new Estimate_col ( Math . min ( Math . min ( ax , bx ) , Math . min ( cx , dx ) ) , Math . max ( Math . max ( ax , bx ) , Math . max ( cx , dx ) ) , Math . min ( Math . min ( ay , by ) , Math . min ( cy , dy ) ) , Math . max ( Math . max ( ay , by ) , Math . max ( cy , dy ) ) , Math . min ( Math . min ( az , bz ) , Math . min ( cz , dz ) ) , Math . max ( Math . max ( az , bz ) , Math . max ( cz , dz ) ) ) ;
      }

   }

   static class mult_d extends ExpressionFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         LDouble y = (LDouble)inputs[1]; 
         return new LDouble ( x . val * y . val ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         double a = x . getMaximum ( ) * y . getMaximum ( ) ; double b = x . getMaximum ( ) * y . getMinimum ( ) ; double c = x . getMinimum ( ) * y . getMaximum ( ) ; double d = x . getMinimum ( ) * y . getMinimum ( ) ; return new Estimate_d ( Math . min ( Math . min ( a , b ) , Math . min ( c , d ) ) , Math . max ( Math . max ( a , b ) , Math . max ( c , d ) ) ) ;
      }

   }

   static class mult_c extends ExpressionFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         LDouble y = (LDouble)inputs[1]; 
         return new Complex ( x . x * y . val , x . y * y . val ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         double ax = x . getXMaximum ( ) * y . getMaximum ( ) ; double bx = x . getXMaximum ( ) * y . getMinimum ( ) ; double cx = x . getXMinimum ( ) * y . getMaximum ( ) ; double dx = x . getXMinimum ( ) * y . getMinimum ( ) ; double ay = x . getYMaximum ( ) * y . getMaximum ( ) ; double by = x . getYMaximum ( ) * y . getMinimum ( ) ; double cy = x . getYMinimum ( ) * y . getMaximum ( ) ; double dy = x . getYMinimum ( ) * y . getMinimum ( ) ; return new Estimate_c ( Math . min ( Math . min ( ax , bx ) , Math . min ( cx , dx ) ) , Math . max ( Math . max ( ax , bx ) , Math . max ( cx , dx ) ) , Math . min ( Math . min ( ay , by ) , Math . min ( cy , dy ) ) , Math . max ( Math . max ( ay , by ) , Math . max ( cy , dy ) ) ) ;
      }

   }

   static class mult_c_c extends ExpressionFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         Complex y = (Complex)inputs[1]; 
         return new Complex ( x . x * y . x , x . y * y . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         Estimate_c y = (Estimate_c)inputs[1]; 
         double ax = x . getXMaximum ( ) * y . getXMaximum ( ) ; double bx = x . getXMaximum ( ) * y . getXMinimum ( ) ; double cx = x . getXMinimum ( ) * y . getXMaximum ( ) ; double dx = x . getXMinimum ( ) * y . getXMinimum ( ) ; double ay = x . getYMaximum ( ) * y . getYMaximum ( ) ; double by = x . getYMaximum ( ) * y . getYMinimum ( ) ; double cy = x . getYMinimum ( ) * y . getYMaximum ( ) ; double dy = x . getYMinimum ( ) * y . getYMinimum ( ) ; return new Estimate_c ( Math . min ( Math . min ( ax , bx ) , Math . min ( cx , dx ) ) , Math . max ( Math . max ( ax , bx ) , Math . max ( cx , dx ) ) , Math . min ( Math . min ( ay , by ) , Math . min ( cy , dy ) ) , Math . max ( Math . max ( ay , by ) , Math . max ( cy , dy ) ) ) ;
      }

   }

   static class mult_v2 extends ExpressionFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         LDouble y = (LDouble)inputs[1]; 
         return new LVect2d ( x . x * y . val , x . y * y . val ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         double ax = x . getXMaximum ( ) * y . getMaximum ( ) ; double bx = x . getXMaximum ( ) * y . getMinimum ( ) ; double cx = x . getXMinimum ( ) * y . getMaximum ( ) ; double dx = x . getXMinimum ( ) * y . getMinimum ( ) ; double ay = x . getYMaximum ( ) * y . getMaximum ( ) ; double by = x . getYMaximum ( ) * y . getMinimum ( ) ; double cy = x . getYMinimum ( ) * y . getMaximum ( ) ; double dy = x . getYMinimum ( ) * y . getMinimum ( ) ; return new Estimate_v2 ( Math . min ( Math . min ( ax , bx ) , Math . min ( cx , dx ) ) , Math . max ( Math . max ( ax , bx ) , Math . max ( cx , dx ) ) , Math . min ( Math . min ( ay , by ) , Math . min ( cy , dy ) ) , Math . max ( Math . max ( ay , by ) , Math . max ( cy , dy ) ) ) ;
      }

   }

   static class mult_v2_v2 extends ExpressionFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         return new LVect2d ( x . x * y . x , x . y * y . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         double ax = x . getXMaximum ( ) * y . getXMaximum ( ) ; double bx = x . getXMaximum ( ) * y . getXMinimum ( ) ; double cx = x . getXMinimum ( ) * y . getXMaximum ( ) ; double dx = x . getXMinimum ( ) * y . getXMinimum ( ) ; double ay = x . getYMaximum ( ) * y . getYMaximum ( ) ; double by = x . getYMaximum ( ) * y . getYMinimum ( ) ; double cy = x . getYMinimum ( ) * y . getYMaximum ( ) ; double dy = x . getYMinimum ( ) * y . getYMinimum ( ) ; return new Estimate_v2 ( Math . min ( Math . min ( ax , bx ) , Math . min ( cx , dx ) ) , Math . max ( Math . max ( ax , bx ) , Math . max ( cx , dx ) ) , Math . min ( Math . min ( ay , by ) , Math . min ( cy , dy ) ) , Math . max ( Math . max ( ay , by ) , Math . max ( cy , dy ) ) ) ;
      }

   }

   static class mult_v3 extends ExpressionFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LDouble y = (LDouble)inputs[1]; 
         return new LVect3d ( x . x * y . val , x . y * y . val , x . z * y . val ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         double ax = x . getXMaximum ( ) * y . getMaximum ( ) ; double bx = x . getXMaximum ( ) * y . getMinimum ( ) ; double cx = x . getXMinimum ( ) * y . getMaximum ( ) ; double dx = x . getXMinimum ( ) * y . getMinimum ( ) ; double ay = x . getYMaximum ( ) * y . getMaximum ( ) ; double by = x . getYMaximum ( ) * y . getMinimum ( ) ; double cy = x . getYMinimum ( ) * y . getMaximum ( ) ; double dy = x . getYMinimum ( ) * y . getMinimum ( ) ; double az = x . getZMaximum ( ) * y . getMaximum ( ) ; double bz = x . getZMaximum ( ) * y . getMinimum ( ) ; double cz = x . getZMinimum ( ) * y . getMaximum ( ) ; double dz = x . getZMinimum ( ) * y . getMinimum ( ) ; return new Estimate_v3 ( Math . min ( Math . min ( ax , bx ) , Math . min ( cx , dx ) ) , Math . max ( Math . max ( ax , bx ) , Math . max ( cx , dx ) ) , Math . min ( Math . min ( ay , by ) , Math . min ( cy , dy ) ) , Math . max ( Math . max ( ay , by ) , Math . max ( cy , dy ) ) , Math . min ( Math . min ( az , bz ) , Math . min ( cz , dz ) ) , Math . max ( Math . max ( az , bz ) , Math . max ( cz , dz ) ) ) ;
      }

   }

   static class mult_v3_v3 extends ExpressionFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         return new LVect3d ( x . x * y . x , x . y * y . y , x . z * y . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         double ax = x . getXMaximum ( ) * y . getXMaximum ( ) ; double bx = x . getXMaximum ( ) * y . getXMinimum ( ) ; double cx = x . getXMinimum ( ) * y . getXMaximum ( ) ; double dx = x . getXMinimum ( ) * y . getXMinimum ( ) ; double ay = x . getYMaximum ( ) * y . getYMaximum ( ) ; double by = x . getYMaximum ( ) * y . getYMinimum ( ) ; double cy = x . getYMinimum ( ) * y . getYMaximum ( ) ; double dy = x . getYMinimum ( ) * y . getYMinimum ( ) ; double az = x . getZMaximum ( ) * y . getZMaximum ( ) ; double bz = x . getZMaximum ( ) * y . getZMinimum ( ) ; double cz = x . getZMinimum ( ) * y . getZMaximum ( ) ; double dz = x . getZMinimum ( ) * y . getZMinimum ( ) ; return new Estimate_v3 ( Math . min ( Math . min ( ax , bx ) , Math . min ( cx , dx ) ) , Math . max ( Math . max ( ax , bx ) , Math . max ( cx , dx ) ) , Math . min ( Math . min ( ay , by ) , Math . min ( cy , dy ) ) , Math . max ( Math . max ( ay , by ) , Math . max ( cy , dy ) ) , Math . min ( Math . min ( az , bz ) , Math . min ( cz , dz ) ) , Math . max ( Math . max ( az , bz ) , Math . max ( cz , dz ) ) ) ;
      }

   }

   static class pow_col extends ExpressionFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         LDouble y = (LDouble)inputs[1]; 
         return new Color ( Math . pow ( x . r , y . val ) , Math . pow ( x . g , y . val ) , Math . pow ( x . b , y . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         double ax = Math . pow ( x . getRMaximum ( ) , y . getMaximum ( ) ) ; double bx = Math . pow ( x . getRMaximum ( ) , y . getMinimum ( ) ) ; double cx = Math . pow ( x . getRMinimum ( ) , y . getMaximum ( ) ) ; double dx = Math . pow ( x . getRMinimum ( ) , y . getMinimum ( ) ) ; double ay = Math . pow ( x . getGMaximum ( ) , y . getMaximum ( ) ) ; double by = Math . pow ( x . getGMaximum ( ) , y . getMinimum ( ) ) ; double cy = Math . pow ( x . getGMinimum ( ) , y . getMaximum ( ) ) ; double dy = Math . pow ( x . getGMinimum ( ) , y . getMinimum ( ) ) ; double az = Math . pow ( x . getBMaximum ( ) , y . getMaximum ( ) ) ; double bz = Math . pow ( x . getBMaximum ( ) , y . getMinimum ( ) ) ; double cz = Math . pow ( x . getBMinimum ( ) , y . getMaximum ( ) ) ; double dz = Math . pow ( x . getBMinimum ( ) , y . getMinimum ( ) ) ; return new Estimate_col ( Math . min ( Math . min ( ax , bx ) , Math . min ( cx , dx ) ) , Math . max ( Math . max ( ax , bx ) , Math . max ( cx , dx ) ) , Math . min ( Math . min ( ay , by ) , Math . min ( cy , dy ) ) , Math . max ( Math . max ( ay , by ) , Math . max ( cy , dy ) ) , Math . min ( Math . min ( az , bz ) , Math . min ( cz , dz ) ) , Math . max ( Math . max ( az , bz ) , Math . max ( cz , dz ) ) ) ;
      }

   }

   static class pow_col_col extends ExpressionFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         Color y = (Color)inputs[1]; 
         return new Color ( Math . pow ( x . r , y . r ) , Math . pow ( x . g , y . g ) , Math . pow ( x . b , y . b ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_col y = (Estimate_col)inputs[1]; 
         double ax = Math . pow ( x . getRMaximum ( ) , y . getRMaximum ( ) ) ; double bx = Math . pow ( x . getRMaximum ( ) , y . getRMinimum ( ) ) ; double cx = Math . pow ( x . getRMinimum ( ) , y . getRMaximum ( ) ) ; double dx = Math . pow ( x . getRMinimum ( ) , y . getRMinimum ( ) ) ; double ay = Math . pow ( x . getGMaximum ( ) , y . getGMaximum ( ) ) ; double by = Math . pow ( x . getGMaximum ( ) , y . getGMinimum ( ) ) ; double cy = Math . pow ( x . getGMinimum ( ) , y . getGMaximum ( ) ) ; double dy = Math . pow ( x . getGMinimum ( ) , y . getGMinimum ( ) ) ; double az = Math . pow ( x . getBMaximum ( ) , y . getBMaximum ( ) ) ; double bz = Math . pow ( x . getBMaximum ( ) , y . getBMinimum ( ) ) ; double cz = Math . pow ( x . getBMinimum ( ) , y . getBMaximum ( ) ) ; double dz = Math . pow ( x . getBMinimum ( ) , y . getBMinimum ( ) ) ; return new Estimate_col ( Math . min ( Math . min ( ax , bx ) , Math . min ( cx , dx ) ) , Math . max ( Math . max ( ax , bx ) , Math . max ( cx , dx ) ) , Math . min ( Math . min ( ay , by ) , Math . min ( cy , dy ) ) , Math . max ( Math . max ( ay , by ) , Math . max ( cy , dy ) ) , Math . min ( Math . min ( az , bz ) , Math . min ( cz , dz ) ) , Math . max ( Math . max ( az , bz ) , Math . max ( cz , dz ) ) ) ;
      }

   }

   static class pow_d extends ExpressionFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         LDouble y = (LDouble)inputs[1]; 
         return new LDouble ( Math . pow ( x . val , y . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         double a = Math . pow ( x . getMaximum ( ) , y . getMaximum ( ) ) ; double b = Math . pow ( x . getMaximum ( ) , y . getMinimum ( ) ) ; double c = Math . pow ( x . getMinimum ( ) , y . getMaximum ( ) ) ; double d = Math . pow ( x . getMinimum ( ) , y . getMinimum ( ) ) ; return new Estimate_d ( Math . min ( Math . min ( a , b ) , Math . min ( c , d ) ) , Math . max ( Math . max ( a , b ) , Math . max ( c , d ) ) ) ;
      }

   }

   static class pow_v2 extends ExpressionFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         LDouble y = (LDouble)inputs[1]; 
         return new LVect2d ( Math . pow ( x . x , y . val ) , Math . pow ( x . y , y . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         double ax = Math . pow ( x . getXMaximum ( ) , y . getMaximum ( ) ) ; double bx = Math . pow ( x . getXMaximum ( ) , y . getMinimum ( ) ) ; double cx = Math . pow ( x . getXMinimum ( ) , y . getMaximum ( ) ) ; double dx = Math . pow ( x . getXMinimum ( ) , y . getMinimum ( ) ) ; double ay = Math . pow ( x . getYMaximum ( ) , y . getMaximum ( ) ) ; double by = Math . pow ( x . getYMaximum ( ) , y . getMinimum ( ) ) ; double cy = Math . pow ( x . getYMinimum ( ) , y . getMaximum ( ) ) ; double dy = Math . pow ( x . getYMinimum ( ) , y . getMinimum ( ) ) ; return new Estimate_v2 ( Math . min ( Math . min ( ax , bx ) , Math . min ( cx , dx ) ) , Math . max ( Math . max ( ax , bx ) , Math . max ( cx , dx ) ) , Math . min ( Math . min ( ay , by ) , Math . min ( cy , dy ) ) , Math . max ( Math . max ( ay , by ) , Math . max ( cy , dy ) ) ) ;
      }

   }

   static class pow_v2_v2 extends ExpressionFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         return new LVect2d ( Math . pow ( x . x , y . x ) , Math . pow ( x . y , y . y ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         double ax = Math . pow ( x . getXMaximum ( ) , y . getXMaximum ( ) ) ; double bx = Math . pow ( x . getXMaximum ( ) , y . getXMinimum ( ) ) ; double cx = Math . pow ( x . getXMinimum ( ) , y . getXMaximum ( ) ) ; double dx = Math . pow ( x . getXMinimum ( ) , y . getXMinimum ( ) ) ; double ay = Math . pow ( x . getYMaximum ( ) , y . getYMaximum ( ) ) ; double by = Math . pow ( x . getYMaximum ( ) , y . getYMinimum ( ) ) ; double cy = Math . pow ( x . getYMinimum ( ) , y . getYMaximum ( ) ) ; double dy = Math . pow ( x . getYMinimum ( ) , y . getYMinimum ( ) ) ; return new Estimate_v2 ( Math . min ( Math . min ( ax , bx ) , Math . min ( cx , dx ) ) , Math . max ( Math . max ( ax , bx ) , Math . max ( cx , dx ) ) , Math . min ( Math . min ( ay , by ) , Math . min ( cy , dy ) ) , Math . max ( Math . max ( ay , by ) , Math . max ( cy , dy ) ) ) ;
      }

   }

   static class pow_v3 extends ExpressionFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LDouble y = (LDouble)inputs[1]; 
         return new LVect3d ( Math . pow ( x . x , y . val ) , Math . pow ( x . y , y . val ) , Math . pow ( x . z , y . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         double ax = Math . pow ( x . getXMaximum ( ) , y . getMaximum ( ) ) ; double bx = Math . pow ( x . getXMaximum ( ) , y . getMinimum ( ) ) ; double cx = Math . pow ( x . getXMinimum ( ) , y . getMaximum ( ) ) ; double dx = Math . pow ( x . getXMinimum ( ) , y . getMinimum ( ) ) ; double ay = Math . pow ( x . getYMaximum ( ) , y . getMaximum ( ) ) ; double by = Math . pow ( x . getYMaximum ( ) , y . getMinimum ( ) ) ; double cy = Math . pow ( x . getYMinimum ( ) , y . getMaximum ( ) ) ; double dy = Math . pow ( x . getYMinimum ( ) , y . getMinimum ( ) ) ; double az = Math . pow ( x . getZMaximum ( ) , y . getMaximum ( ) ) ; double bz = Math . pow ( x . getZMaximum ( ) , y . getMinimum ( ) ) ; double cz = Math . pow ( x . getZMinimum ( ) , y . getMaximum ( ) ) ; double dz = Math . pow ( x . getZMinimum ( ) , y . getMinimum ( ) ) ; return new Estimate_v3 ( Math . min ( Math . min ( ax , bx ) , Math . min ( cx , dx ) ) , Math . max ( Math . max ( ax , bx ) , Math . max ( cx , dx ) ) , Math . min ( Math . min ( ay , by ) , Math . min ( cy , dy ) ) , Math . max ( Math . max ( ay , by ) , Math . max ( cy , dy ) ) , Math . min ( Math . min ( az , bz ) , Math . min ( cz , dz ) ) , Math . max ( Math . max ( az , bz ) , Math . max ( cz , dz ) ) ) ;
      }

   }

   static class pow_v3_v3 extends ExpressionFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         return new LVect3d ( Math . pow ( x . x , y . x ) , Math . pow ( x . y , y . y ) , Math . pow ( x . z , y . z ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         double ax = Math . pow ( x . getXMaximum ( ) , y . getXMaximum ( ) ) ; double bx = Math . pow ( x . getXMaximum ( ) , y . getXMinimum ( ) ) ; double cx = Math . pow ( x . getXMinimum ( ) , y . getXMaximum ( ) ) ; double dx = Math . pow ( x . getXMinimum ( ) , y . getXMinimum ( ) ) ; double ay = Math . pow ( x . getYMaximum ( ) , y . getYMaximum ( ) ) ; double by = Math . pow ( x . getYMaximum ( ) , y . getYMinimum ( ) ) ; double cy = Math . pow ( x . getYMinimum ( ) , y . getYMaximum ( ) ) ; double dy = Math . pow ( x . getYMinimum ( ) , y . getYMinimum ( ) ) ; double az = Math . pow ( x . getZMaximum ( ) , y . getZMaximum ( ) ) ; double bz = Math . pow ( x . getZMaximum ( ) , y . getZMinimum ( ) ) ; double cz = Math . pow ( x . getZMinimum ( ) , y . getZMaximum ( ) ) ; double dz = Math . pow ( x . getZMinimum ( ) , y . getZMinimum ( ) ) ; return new Estimate_v3 ( Math . min ( Math . min ( ax , bx ) , Math . min ( cx , dx ) ) , Math . max ( Math . max ( ax , bx ) , Math . max ( cx , dx ) ) , Math . min ( Math . min ( ay , by ) , Math . min ( cy , dy ) ) , Math . max ( Math . max ( ay , by ) , Math . max ( cy , dy ) ) , Math . min ( Math . min ( az , bz ) , Math . min ( cz , dz ) ) , Math . max ( Math . max ( az , bz ) , Math . max ( cz , dz ) ) ) ;
      }

   }

   static class offset_col extends ExpressionFunction {
      private Color offset;
      public offset_col() {
         offset = new Color ( ) ; offset . r = 2 * Math . random ( ) - 1 ; offset . g = 2 * Math . random ( ) - 1 ; offset . b = 2 * Math . random ( ) - 1 ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         return offset . add ( x ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_col ( x . getRMinimum ( ) + offset . r , x . getRMaximum ( ) + offset . r , x . getGMinimum ( ) + offset . g , x . getGMaximum ( ) + offset . g , x . getBMinimum ( ) + offset . b , x . getBMaximum ( ) + offset . b ) ;
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return offset;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) offset = (Color)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "offset";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return Color.class;
         return null;
      }

   }

   static class offset_d extends ExpressionFunction {
      private double offset;
      public offset_d() {
         offset = 2 * Math . random ( ) - 1 ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( x . val + offset ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d ( x . getMinimum ( ) + offset , x . getMaximum ( ) + offset ) ;
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return offset;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) offset = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "offset";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   static class offset_c extends ExpressionFunction {
      private Complex offset;
      public offset_c() {
         offset = new Complex ( ) ; offset . x = 2 * Math . random ( ) - 1 ; offset . y = 2 * Math . random ( ) - 1 ;
      }

      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         return offset . add ( x ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         return new Estimate_c ( x . getXMinimum ( ) + offset . x , x . getXMaximum ( ) + offset . x , x . getYMinimum ( ) + offset . y , x . getYMaximum ( ) + offset . y ) ;
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return offset;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) offset = (Complex)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "offset";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return Complex.class;
         return null;
      }

   }

   static class offset_v2 extends ExpressionFunction {
      private LVect2d offset;
      public offset_v2() {
         offset = new LVect2d ( ) ; offset . x = 2 * Math . random ( ) - 1 ; offset . y = 2 * Math . random ( ) - 1 ;
      }

      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         return offset . add ( x ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_v2 ( x . getXMinimum ( ) + offset . x , x . getXMaximum ( ) + offset . x , x . getYMinimum ( ) + offset . y , x . getYMaximum ( ) + offset . y ) ;
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return offset;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) offset = (LVect2d)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "offset";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return LVect2d.class;
         return null;
      }

   }

   static class offset_v3 extends ExpressionFunction {
      private LVect3d offset;
      public offset_v3() {
         offset = new LVect3d ( ) ; offset . x = 2 * Math . random ( ) - 1 ; offset . y = 2 * Math . random ( ) - 1 ; offset . z = 2 * Math . random ( ) - 1 ;
      }

      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         return offset . add ( x ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         return new Estimate_v3 ( x . getXMinimum ( ) + offset . x , x . getXMaximum ( ) + offset . x , x . getYMinimum ( ) + offset . y , x . getYMaximum ( ) + offset . y , x . getZMinimum ( ) + offset . z , x . getZMaximum ( ) + offset . z ) ;
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return offset;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) offset = (LVect3d)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "offset";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return LVect3d.class;
         return null;
      }

   }

   static class scale_d extends ExpressionFunction {
      private double scale;
      public scale_d() {
         scale = 3 * Math . random ( ) ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return x . mult ( scale ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d ( x . getMinimum ( ) * scale , x . getMaximum ( ) * scale ) ;
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return scale;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) scale = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "scale";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   static class scale_c extends ExpressionFunction {
      private double scale;
      public scale_c() {
         scale = 3 * Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         return x . mult ( scale ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         return new Estimate_c ( x . getXMinimum ( ) * scale , x . getXMaximum ( ) * scale , x . getYMinimum ( ) * scale , x . getYMaximum ( ) * scale ) ;
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return scale;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) scale = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "scale";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   static class scale_v2 extends ExpressionFunction {
      private double scale;
      public scale_v2() {
         scale = 3 * Math . random ( ) ;
      }

      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         return x . mult ( scale ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_v2 ( x . getXMinimum ( ) * scale , x . getXMaximum ( ) * scale , x . getYMinimum ( ) * scale , x . getYMaximum ( ) * scale ) ;
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return scale;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) scale = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "scale";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   static class scale_v3 extends ExpressionFunction {
      private double scale;
      public scale_v3() {
         scale = 3 * Math . random ( ) ;
      }

      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         return x . mult ( scale ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         return new Estimate_v3 ( x . getXMinimum ( ) * scale , x . getXMaximum ( ) * scale , x . getYMinimum ( ) * scale , x . getYMaximum ( ) * scale , x . getZMinimum ( ) * scale , x . getZMaximum ( ) * scale ) ;
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return scale;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) scale = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "scale";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   static class scale_col extends ExpressionFunction {
      private double scale;
      public scale_col() {
         scale = 3 * Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         return x . mult ( scale ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_col ( x . getRMinimum ( ) * scale , x . getRMaximum ( ) * scale , x . getGMinimum ( ) * scale , x . getGMaximum ( ) * scale , x . getBMinimum ( ) * scale , x . getBMaximum ( ) * scale ) ;
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return scale;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) scale = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "scale";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   static class mod_d extends ExpressionFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( x . val - Math . floor ( x . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d ( 0 , 1 ) ;
      }

   }

   static class mod_v2 extends ExpressionFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         return new LVect2d ( x . x - Math . floor ( x . x ) , x . y - Math . floor ( x . y ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_v2 ( 0 , 1 , 0 , 1 ) ;
      }

   }

   static class mod_v3 extends ExpressionFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         return new LVect3d ( x . x - Math . floor ( x . x ) , x . y - Math . floor ( x . y ) , x . z - Math . floor ( x . z ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         return new Estimate_v3 ( 0 , 1 , 0 , 1 , 0 , 1 ) ;
      }

   }

   public List<ExpressionFunction> getFunctions() {
      List<ExpressionFunction> functions = new LinkedList();
      functions.add( new avg_d() );
      functions.add( new avg_c() );
      functions.add( new avg_v2() );
      functions.add( new avg_v3() );
      functions.add( new add_col() );
      functions.add( new add_d() );
      functions.add( new add_c() );
      functions.add( new add_v2() );
      functions.add( new add_v3() );
      functions.add( new sub_col() );
      functions.add( new sub_c() );
      functions.add( new sub_d() );
      functions.add( new sub_v2() );
      functions.add( new sub_v3() );
      functions.add( new mult_col() );
      functions.add( new mult_d() );
      functions.add( new mult_c() );
      functions.add( new mult_c_c() );
      functions.add( new mult_v2() );
      functions.add( new mult_v2_v2() );
      functions.add( new mult_v3() );
      functions.add( new mult_v3_v3() );
      functions.add( new pow_col() );
      functions.add( new pow_col_col() );
      functions.add( new pow_d() );
      functions.add( new pow_v2() );
      functions.add( new pow_v2_v2() );
      functions.add( new pow_v3() );
      functions.add( new pow_v3_v3() );
      functions.add( new offset_col() );
      functions.add( new offset_d() );
      functions.add( new offset_c() );
      functions.add( new offset_v2() );
      functions.add( new offset_v3() );
      functions.add( new scale_d() );
      functions.add( new scale_c() );
      functions.add( new scale_v2() );
      functions.add( new scale_v3() );
      functions.add( new scale_col() );
      functions.add( new mod_d() );
      functions.add( new mod_v2() );
      functions.add( new mod_v3() );
      return functions;
   }

   public ExpressionFunction build(Class<? extends ExpressionFunction> nfClass, ExpressionFactory nff) {
      ExpressionFunction r;
      if(nfClass == avg_d.class)
          return new avg_d();
      if(nfClass == avg_c.class)
          return new avg_c();
      if(nfClass == avg_v2.class)
          return new avg_v2();
      if(nfClass == avg_v3.class)
          return new avg_v3();
      if(nfClass == add_col.class)
          return new add_col();
      if(nfClass == add_d.class)
          return new add_d();
      if(nfClass == add_c.class)
          return new add_c();
      if(nfClass == add_v2.class)
          return new add_v2();
      if(nfClass == add_v3.class)
          return new add_v3();
      if(nfClass == sub_col.class)
          return new sub_col();
      if(nfClass == sub_c.class)
          return new sub_c();
      if(nfClass == sub_d.class)
          return new sub_d();
      if(nfClass == sub_v2.class)
          return new sub_v2();
      if(nfClass == sub_v3.class)
          return new sub_v3();
      if(nfClass == mult_col.class)
          return new mult_col();
      if(nfClass == mult_d.class)
          return new mult_d();
      if(nfClass == mult_c.class)
          return new mult_c();
      if(nfClass == mult_c_c.class)
          return new mult_c_c();
      if(nfClass == mult_v2.class)
          return new mult_v2();
      if(nfClass == mult_v2_v2.class)
          return new mult_v2_v2();
      if(nfClass == mult_v3.class)
          return new mult_v3();
      if(nfClass == mult_v3_v3.class)
          return new mult_v3_v3();
      if(nfClass == pow_col.class)
          return new pow_col();
      if(nfClass == pow_col_col.class)
          return new pow_col_col();
      if(nfClass == pow_d.class)
          return new pow_d();
      if(nfClass == pow_v2.class)
          return new pow_v2();
      if(nfClass == pow_v2_v2.class)
          return new pow_v2_v2();
      if(nfClass == pow_v3.class)
          return new pow_v3();
      if(nfClass == pow_v3_v3.class)
          return new pow_v3_v3();
      if(nfClass == offset_col.class)
          return new offset_col();
      if(nfClass == offset_d.class)
          return new offset_d();
      if(nfClass == offset_c.class)
          return new offset_c();
      if(nfClass == offset_v2.class)
          return new offset_v2();
      if(nfClass == offset_v3.class)
          return new offset_v3();
      if(nfClass == scale_d.class)
          return new scale_d();
      if(nfClass == scale_c.class)
          return new scale_c();
      if(nfClass == scale_v2.class)
          return new scale_v2();
      if(nfClass == scale_v3.class)
          return new scale_v3();
      if(nfClass == scale_col.class)
          return new scale_col();
      if(nfClass == mod_d.class)
          return new mod_d();
      if(nfClass == mod_v2.class)
          return new mod_v2();
      if(nfClass == mod_v3.class)
          return new mod_v3();
      return null;
   }

}
