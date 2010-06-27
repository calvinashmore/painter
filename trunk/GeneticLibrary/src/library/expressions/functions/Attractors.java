package library . expressions . functions;

import java.util.*;
import genetic.*;
import genetic.component.accessor.*;
import genetic.component.command.*;
import genetic.component.context.*;
import genetic.component.expression.*;
import genetic.component.expression.function.*;
import genetic.component.expression.function.cx.*;
import genetic.component.method.*;
import genetic.component.program.*;
import genetic.component.statement.*;
import genetic.component.statementlist.*;
import genetic.component.statement.function.*;
import utils.linear.*;
import utils.pointfield.attractor.*;

public final class Attractors implements AllComponents<ExpressionFunction>, Described {

   public static class getQuadtree extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "attractor";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Attractor2.class;
            default: return null;
         }

      }

      public getQuadtree() {
         addGroupMeta(this);
      }

      public QT2d evaluate(Context context, Object[] inputs) {
         final Attractor2 attractor = (Attractor2)inputs[0];
         return ( QT2d ) attractor . getQuadtree ( ) ;
      }

      public Class getReturnType() {
         return QT2d.class;
      }

   }

   public static class PeterDeJong extends ExpressionFunction {
      private boolean built ;private Attractor2 attractor ;private class Impl extends AttractorFunction2 { public void apply ( APoint2d in_val , APoint2d out_val ) { out_val . x = Math . sin ( a * in_val . y ) - Math . cos ( b * in_val . x ) ; out_val . y = Math . sin ( c * in_val . x ) - Math . cos ( d * in_val . y ) ; } public double derivMagnitude ( APoint2d in_val ) { double d00 = a * Math . sin ( a * in_val . y ) ; double d01 = b * Math . cos ( b * in_val . x ) ; double d10 = c * Math . cos ( c * in_val . x ) ; double d11 = d * Math . sin ( d * in_val . y ) ; return Math . max ( Math . abs ( d00 ) + Math . abs ( d01 ) , Math . abs ( d10 ) + Math . abs ( d11 ) ) ; } public void adjustParameters ( ) { a = Math . random ( ) * 8 - 4 ; b = Math . random ( ) * 8 - 4 ; c = Math . random ( ) * 8 - 4 ; d = Math . random ( ) * 8 - 4 ; } public int getIdealIterations ( ) { return super . getIdealIterations ( ) * 4 ; } }
      private double a;private double b;private double c;private double d;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            case 1: return b;
            case 2: return c;
            case 3: return d;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            case 2: return "c";
            case 3: return "d";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            case 2: return double.class;
            case 3: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (Double) value; return;
            case 1: b = (Double) value; return;
            case 2: c = (Double) value; return;
            case 3: d = (Double) value; return;
            default: return;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         if ( ! built ) {
         attractor = new Attractor2 ( new Impl ( ) , new APoint2d ( ) ) ;
         setParametersChanged ( false ) ;
         built = true ;
         }
         else if ( parametersChanged ( ) ) {
         attractor = new Attractor2 ( new Impl ( ) , new APoint2d ( ) ) ;
         setParametersChanged ( false ) ;
         }
      }

      public PeterDeJong() {
         addGroupMeta(this);
      }

      public Attractor2 evaluate(Context context, Object[] inputs) {

         return attractor ;
      }

      public Class getReturnType() {
         return Attractor2.class;
      }

   }

   public static class Clifford extends ExpressionFunction {
      private boolean built ;private Attractor2 attractor ;private class Impl extends AttractorFunction2 { public void apply ( APoint2d in_val , APoint2d out_val ) { out_val . x = Math . sin ( a * in_val . y ) + b * Math . cos ( a * in_val . x ) ; out_val . y = Math . sin ( c * in_val . x ) + d * Math . cos ( c * in_val . y ) ; } public double derivMagnitude ( APoint2d in_val ) { double d00 = - a * Math . sin ( a * in_val . y ) ; double d01 = b * a * Math . cos ( a * in_val . x ) ; double d10 = c * Math . cos ( c * in_val . x ) ; double d11 = - d * c * Math . sin ( c * in_val . y ) ; return Math . max ( Math . abs ( d00 ) + Math . abs ( d01 ) , Math . abs ( d10 ) + Math . abs ( d11 ) ) ; } public void adjustParameters ( ) { a = Math . random ( ) * 8 - 4 ; b = Math . random ( ) * 8 - 4 ; c = Math . random ( ) * 8 - 4 ; d = Math . random ( ) * 8 - 4 ; } public int getIdealIterations ( ) { return super . getIdealIterations ( ) * 4 ; } }
      private double a;private double b;private double c;private double d;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            case 1: return b;
            case 2: return c;
            case 3: return d;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            case 2: return "c";
            case 3: return "d";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            case 2: return double.class;
            case 3: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (Double) value; return;
            case 1: b = (Double) value; return;
            case 2: c = (Double) value; return;
            case 3: d = (Double) value; return;
            default: return;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         if ( ! built ) {
         attractor = new Attractor2 ( new Impl ( ) , new APoint2d ( ) ) ;
         setParametersChanged ( false ) ;
         built = true ;
         }
         else if ( parametersChanged ( ) ) {
         attractor = new Attractor2 ( new Impl ( ) , new APoint2d ( ) ) ;
         setParametersChanged ( false ) ;
         }
      }

      public Clifford() {
         addGroupMeta(this);
      }

      public Attractor2 evaluate(Context context, Object[] inputs) {

         return attractor ;
      }

      public Class getReturnType() {
         return Attractor2.class;
      }

   }

   public static class Quadratic2_x1 extends ExpressionFunction {
      private boolean built ;private Attractor2 attractor ;private class Impl extends AttractorFunction2 { public void apply ( APoint2d in_val , APoint2d out_val ) { double x = in_val . x ; double y = in_val . y ; out_val . x = x * x * Math . sin ( y ) * a [ 0 ] + x * y * a [ 1 ] + y * y * a [ 2 ] + x * a [ 3 ] + y * a [ 4 ] + a [ 5 ] ; out_val . y = x * x * Math . cos ( y ) * b [ 0 ] + x * y * b [ 1 ] + y * y * b [ 2 ] + x * b [ 3 ] + y * b [ 4 ] + b [ 5 ] ; } public double derivMagnitude ( APoint2d in_val ) { double x = in_val . x ; double y = in_val . y ; double d00 = 2 * x * Math . sin ( y ) * a [ 0 ] + y * a [ 1 ] + a [ 3 ] ; double d01 = 2 * y * a [ 2 ] + x * a [ 1 ] + a [ 4 ] + Math . cos ( y ) * x * x * a [ 0 ] ; double d10 = 2 * x * Math . cos ( y ) * b [ 0 ] + y * b [ 1 ] + b [ 3 ] ; double d11 = 2 * y * b [ 2 ] + x * b [ 1 ] + b [ 4 ] + Math . cos ( y ) * x * x * a [ 0 ] ; return Math . max ( Math . abs ( d00 ) + Math . abs ( d01 ) , Math . abs ( d10 ) + Math . abs ( d11 ) ) ; } public void adjustParameters ( ) { a = new double [ 6 ] ; b = new double [ 6 ] ; for ( int i = 0 ; i < 6 ; i ++ ) { a [ i ] = Math . random ( ) * 3 - 1.5 ; b [ i ] = Math . random ( ) * 3 - 1.5 ; } } public int getIdealIterations ( ) { return super . getIdealIterations ( ) / 2 ; } }
      private double [ ] a;private double [ ] b;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            case 1: return b;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ].class;
            case 1: return double [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ]) value; return;
            case 1: b = (double [ ]) value; return;
            default: return;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         if ( ! built ) {
         attractor = new Attractor2 ( new Impl ( ) , new APoint2d ( ) ) ;
         setParametersChanged ( false ) ;
         built = true ;
         }
         else if ( parametersChanged ( ) ) {
         attractor = new Attractor2 ( new Impl ( ) , new APoint2d ( ) ) ;
         setParametersChanged ( false ) ;
         }
      }

      public Quadratic2_x1() {
         addGroupMeta(this);
      }

      public Attractor2 evaluate(Context context, Object[] inputs) {

         return attractor ;
      }

      public Class getReturnType() {
         return Attractor2.class;
      }

   }

   public static class Quadratic2 extends ExpressionFunction {
      private boolean built ;private Attractor2 attractor ;private class Impl extends AttractorFunction2 { public void apply ( APoint2d in_val , APoint2d out_val ) { double x = in_val . x ; double y = in_val . y ; out_val . x = x * x * a [ 0 ] + x * y * a [ 1 ] + y * y * a [ 2 ] + x * a [ 3 ] + y * a [ 4 ] + a [ 5 ] ; out_val . y = x * x * b [ 0 ] + x * y * b [ 1 ] + y * y * b [ 2 ] + x * b [ 3 ] + y * b [ 4 ] + b [ 5 ] ; } public double derivMagnitude ( APoint2d in_val ) { double x = in_val . x ; double y = in_val . y ; double d00 = 2 * x * a [ 0 ] + y * a [ 1 ] + a [ 3 ] ; double d01 = 2 * y * a [ 2 ] + x * a [ 1 ] + a [ 4 ] ; double d10 = 2 * x * b [ 0 ] + y * b [ 1 ] + b [ 3 ] ; double d11 = 2 * y * b [ 2 ] + x * b [ 1 ] + b [ 4 ] ; return Math . max ( Math . abs ( d00 ) + Math . abs ( d01 ) , Math . abs ( d10 ) + Math . abs ( d11 ) ) ; } public void adjustParameters ( ) { a = new double [ 6 ] ; b = new double [ 6 ] ; for ( int i = 0 ; i < 6 ; i ++ ) { a [ i ] = Math . random ( ) * 3 - 1.5 ; b [ i ] = Math . random ( ) * 3 - 1.5 ; } } public int getIdealIterations ( ) { return super . getIdealIterations ( ) / 2 ; } }
      private double [ ] a;private double [ ] b;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            case 1: return b;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ].class;
            case 1: return double [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ]) value; return;
            case 1: b = (double [ ]) value; return;
            default: return;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         if ( ! built ) {
         attractor = new Attractor2 ( new Impl ( ) , new APoint2d ( ) ) ;
         setParametersChanged ( false ) ;
         built = true ;
         }
         else if ( parametersChanged ( ) ) {
         attractor = new Attractor2 ( new Impl ( ) , new APoint2d ( ) ) ;
         setParametersChanged ( false ) ;
         }
      }

      public Quadratic2() {
         addGroupMeta(this);
      }

      public Attractor2 evaluate(Context context, Object[] inputs) {

         return attractor ;
      }

      public Class getReturnType() {
         return Attractor2.class;
      }

   }

   public static class Cubic2 extends ExpressionFunction {
      private boolean built ;private Attractor2 attractor ;private class Impl extends AttractorFunction2 { public void apply ( APoint2d in_val , APoint2d out_val ) { double x = in_val . x ; double y = in_val . y ; out_val . x = x * x * x * a [ 0 ] + x * x * y * a [ 1 ] + x * y * y * a [ 2 ] + y * y * y * a [ 3 ] + x * x * a [ 4 ] + x * y * a [ 5 ] + y * y * a [ 6 ] + x * a [ 7 ] + y * a [ 8 ] + a [ 9 ] ; out_val . y = x * x * x * b [ 0 ] + x * x * y * b [ 1 ] + x * y * y * b [ 2 ] + y * y * y * b [ 3 ] + x * x * b [ 4 ] + x * y * b [ 5 ] + y * y * b [ 6 ] + x * a [ 7 ] + y * b [ 8 ] + b [ 9 ] ; } public double derivMagnitude ( APoint2d in_val ) { double x = in_val . x ; double y = in_val . y ; double d00 = 3 * x * x * a [ 0 ] + 2 * x * y * a [ 1 ] + y * y * a [ 2 ] + 2 * x * a [ 4 ] + y * a [ 5 ] + a [ 7 ] ; double d01 = x * x * a [ 1 ] + 2 * x * y * a [ 2 ] + 3 * y * y * a [ 3 ] + x * a [ 5 ] + 2 * y * a [ 6 ] + a [ 8 ] ; double d10 = 3 * x * x * b [ 0 ] + 2 * x * y * b [ 1 ] + y * y * b [ 2 ] + 2 * x * b [ 4 ] + y * b [ 5 ] + b [ 7 ] ; double d11 = x * x * b [ 1 ] + 2 * x * y * b [ 2 ] + 3 * y * y * b [ 3 ] + x * b [ 5 ] + 2 * y * b [ 6 ] + b [ 8 ] ; return Math . max ( Math . abs ( d00 ) + Math . abs ( d01 ) , Math . abs ( d10 ) + Math . abs ( d11 ) ) ; } public void adjustParameters ( ) { a = new double [ 10 ] ; b = new double [ 10 ] ; for ( int i = 0 ; i < 10 ; i ++ ) { a [ i ] = Math . random ( ) * 3 - 1.5 ; b [ i ] = Math . random ( ) * 3 - 1.5 ; } } public int getIdealIterations ( ) { return super . getIdealIterations ( ) / 2 ; } }
      private double [ ] a;private double [ ] b;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            case 1: return b;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ].class;
            case 1: return double [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ]) value; return;
            case 1: b = (double [ ]) value; return;
            default: return;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         if ( ! built ) {
         attractor = new Attractor2 ( new Impl ( ) , new APoint2d ( ) ) ;
         setParametersChanged ( false ) ;
         built = true ;
         }
         else if ( parametersChanged ( ) ) {
         attractor = new Attractor2 ( new Impl ( ) , new APoint2d ( ) ) ;
         setParametersChanged ( false ) ;
         }
      }

      public Cubic2() {
         addGroupMeta(this);
      }

      public Attractor2 evaluate(Context context, Object[] inputs) {

         return attractor ;
      }

      public Class getReturnType() {
         return Attractor2.class;
      }

   }

   public static class Julia2 extends ExpressionFunction {
      private boolean built ;private Attractor2 attractor ;private class Impl extends AttractorFunction2 { @ Override public void adjustParameters ( ) { c = new Complex ( - .5 + 1.5 * ( Math . random ( ) - Math . random ( ) ) , 1.5 * ( Math . random ( ) - Math . random ( ) ) ) ; } @ Override public void apply ( APoint2d in_val , APoint2d out_val ) { double x = in_val . x - c . x ; double y = in_val . y - c . y ; double mag = Math . pow ( x * x + y * y , 1.0 / 4 ) ; double theta = Math . atan2 ( y , x ) / 2 ; if ( Math . random ( ) < .5 ) theta += Math . PI ; out_val . x = mag * Math . cos ( theta ) ; out_val . y = mag * Math . sin ( theta ) ; } @ Override public double derivMagnitude ( APoint2d in_val ) { double x = in_val . x - c . x ; double y = in_val . y - c . y ; double theta = Math . atan2 ( y , x ) ; if ( Math . random ( ) < .5 ) theta += Math . PI ; double r3 = 2 * Math . pow ( y * y + x * x , 3.0 / 4 ) ; double sin = Math . sin ( theta / 2 ) ; double cos = Math . cos ( theta / 2 ) ; double d00 = ( y * sin + x * cos ) / r3 ; double d01 = - ( x * sin - y * cos ) / r3 ; double d10 = ( x * sin - y * cos ) / r3 ; double d11 = ( y * sin + x * cos ) / r3 ; return Math . max ( Math . abs ( d00 ) + Math . abs ( d01 ) , Math . abs ( d10 ) + Math . abs ( d11 ) ) ; } }
      private Complex c;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return c;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "c";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Complex.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: c = (Complex) value; return;
            default: return;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         if ( ! built ) {
         attractor = new Attractor2 ( new Impl ( ) , new APoint2d ( ) ) ;
         setParametersChanged ( false ) ;
         built = true ;
         }
         else if ( parametersChanged ( ) ) {
         attractor = new Attractor2 ( new Impl ( ) , new APoint2d ( ) ) ;
         setParametersChanged ( false ) ;
         }
      }

      public Julia2() {
         addGroupMeta(this);
      }

      public Attractor2 evaluate(Context context, Object[] inputs) {

         return attractor ;
      }

      public Class getReturnType() {
         return Attractor2.class;
      }

   }

   public static class Quadratic3 extends ExpressionFunction {
      private class Impl extends AttractorFunction3 { public void adjustParameters ( ) { a = new double [ 10 ] ; b = new double [ 10 ] ; c = new double [ 10 ] ; for ( int i = 0 ; i < 10 ; i ++ ) { a [ i ] = Math . random ( ) * 2 - 1 ; b [ i ] = Math . random ( ) * 2 - 1 ; c [ i ] = Math . random ( ) * 2 - 1 ; } } public void apply ( APoint3d in_val , APoint3d out_val ) { double x = in_val . x ; double y = in_val . y ; double z = in_val . z ; out_val . x = x * x * a [ 0 ] + x * y * a [ 1 ] + x * z * a [ 2 ] + y * y * a [ 3 ] + y * z * a [ 4 ] + z * z * a [ 5 ] + x * a [ 6 ] + y * a [ 7 ] + z * a [ 8 ] + a [ 9 ] ; out_val . y = x * x * b [ 0 ] + x * y * b [ 1 ] + x * z * b [ 2 ] + y * y * b [ 3 ] + y * z * b [ 4 ] + z * z * b [ 5 ] + x * b [ 6 ] + y * b [ 7 ] + z * b [ 8 ] + b [ 9 ] ; out_val . z = x * x * c [ 0 ] + x * y * c [ 1 ] + x * z * c [ 2 ] + y * y * c [ 3 ] + y * z * c [ 4 ] + z * z * c [ 5 ] + x * c [ 6 ] + y * c [ 7 ] + z * c [ 8 ] + c [ 9 ] ; } public double derivMagnitude ( APoint3d in_val ) { double x = in_val . x ; double y = in_val . y ; double z = in_val . y ; double d00 = 2 * x * a [ 0 ] + y * a [ 1 ] + z * a [ 2 ] + a [ 6 ] ; double d01 = 2 * y * a [ 3 ] + x * a [ 1 ] + z * a [ 4 ] + a [ 7 ] ; double d02 = 2 * z * a [ 5 ] + x * a [ 2 ] + y * a [ 4 ] + a [ 8 ] ; double d10 = 2 * x * b [ 0 ] + y * b [ 1 ] + z * b [ 2 ] + b [ 6 ] ; double d11 = 2 * y * b [ 3 ] + x * b [ 1 ] + z * b [ 4 ] + b [ 7 ] ; double d12 = 2 * z * b [ 5 ] + x * b [ 2 ] + y * b [ 4 ] + b [ 8 ] ; double d20 = 2 * x * c [ 0 ] + y * c [ 1 ] + z * c [ 2 ] + c [ 6 ] ; double d21 = 2 * y * c [ 3 ] + x * c [ 1 ] + z * c [ 4 ] + c [ 7 ] ; double d22 = 2 * z * c [ 5 ] + x * c [ 2 ] + y * c [ 4 ] + c [ 8 ] ; return Math . max ( Math . max ( Math . abs ( d00 ) + Math . abs ( d01 ) + Math . abs ( d02 ) , Math . abs ( d10 ) + Math . abs ( d11 ) + Math . abs ( d12 ) ) , Math . abs ( d20 ) + Math . abs ( d21 ) + Math . abs ( d22 ) ) ; } public int getIdealIterations ( ) { return super . getIdealIterations ( ) / 2 ; } }private boolean built ;private Attractor3 attractor ;
      private double [ ] a;private double [ ] b;private double [ ] c;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            case 1: return b;
            case 2: return c;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            case 2: return "c";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ].class;
            case 1: return double [ ].class;
            case 2: return double [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ]) value; return;
            case 1: b = (double [ ]) value; return;
            case 2: c = (double [ ]) value; return;
            default: return;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         if ( ! built ) {
         attractor = new Attractor3 ( new Impl ( ) , new APoint3d ( ) ) ;
         setParametersChanged ( false ) ;
         built = true ;
         }
         else if ( parametersChanged ( ) ) {
         attractor = new Attractor3 ( new Impl ( ) , new APoint3d ( ) ) ;
         setParametersChanged ( false ) ;
         }
      }

      public Quadratic3() {
         addGroupMeta(this);
      }

      public Attractor3 evaluate(Context context, Object[] inputs) {

         return attractor ;
      }

      public Class getReturnType() {
         return Attractor3.class;
      }

   }

   public static class Julia4 extends ExpressionFunction {
      private boolean built ;private Attractor4 attractor ;private class Impl extends AttractorFunction4 { @ Override public void adjustParameters ( ) { c = new Quaternion ( - .5 + 1.5 * ( Math . random ( ) - Math . random ( ) ) , 1.5 * ( Math . random ( ) - Math . random ( ) ) , 1.5 * ( Math . random ( ) - Math . random ( ) ) , 1.5 * ( Math . random ( ) - Math . random ( ) ) ) ; } @ Override public void apply ( APoint4d in_val , APoint4d out_val ) { double w = in_val . w - c . u ; double x = in_val . x - c . i ; double y = in_val . y - c . j ; double z = in_val . z - c . k ; double mag = Math . pow ( w * w + x * x + y * y + z * z , 1.0 / 4 ) ; double vmag = Math . pow ( x * x + y * y + z * z , .5 ) ; if ( vmag > 0 ) { x = x / vmag ; y = y / vmag ; z = z / vmag ; } double theta = Math . atan2 ( vmag , w ) / 2 ; if ( Math . random ( ) < .5 ) { theta += Math . PI ; } out_val . w = mag * Math . cos ( theta ) ; out_val . x = mag * x * Math . sin ( theta ) ; out_val . y = mag * y * Math . sin ( theta ) ; out_val . z = mag * z * Math . sin ( theta ) ; } @ Override public double derivMagnitude ( APoint4d in_val ) { double w = in_val . w - c . u ; double x = in_val . x - c . i ; double y = in_val . y - c . j ; double z = in_val . z - c . k ; double vmag = Math . sqrt ( x * x + y * y + z * z ) ; double r3 = 2 * Math . pow ( w * w + x * x + y * y + z * z , 3.0 / 4 ) ; double theta = Math . atan2 ( vmag , w ) ; if ( Math . random ( ) < .5 ) { theta += Math . PI ; } double sin = Math . sin ( theta / 2 ) ; double cos = Math . cos ( theta / 2 ) ; double underTerm1 = ( vmag * cos - w * sin ) / ( r3 * vmag ) ; double underTerm2 = 1.0 / ( r3 * ( ( z * z + 2 * y * y + 2 * x * x ) * z * z + Math . pow ( y , 4 ) + 2 * x * x * y * y + Math . pow ( x , 4 ) ) ) ; double vmagSquared = x * x + y * y + z * z ; double upperTerm1 = vmagSquared + 2 * w * w ; double upperTerm2 = w * x * y * vmagSquared ; double d00 = ( vmag * sin + w * cos ) / r3 ; double d01 = x * underTerm1 ; double d02 = y * underTerm1 ; double d03 = z * underTerm1 ; double d10 = - d01 ; double d11 = ( Math . pow ( x , 4 ) + ( x * x + vmagSquared ) * ( z * z + y * y ) * sin + w * x * x * vmag * cos ) / ( r3 * vmag * vmagSquared ) ; double d12 = ( vmag * y * x * upperTerm1 * sin - upperTerm2 * cos ) * underTerm2 ; double d13 = ( vmag * z * x * upperTerm1 * sin - upperTerm2 * cos ) * underTerm2 ; double d20 = - d02 ; double d21 = - d12 ; double d22 = ( Math . pow ( y , 4 ) + ( y * y + vmagSquared ) * ( z * z + x * x ) * sin + w * y * y * vmag * cos ) / ( r3 * vmag * vmagSquared ) ; double d23 = - ( vmag * y * x * upperTerm1 * sin - upperTerm2 * cos ) * underTerm2 ; double d30 = - d03 ; double d31 = - d13 ; double d32 = - d23 ; double d33 = ( Math . pow ( z , 4 ) + ( z * z + vmagSquared ) * ( y * y + x * x ) * sin + w * z * z * vmag * cos ) / ( r3 * vmag * vmagSquared ) ; return Math . max ( Math . max ( Math . abs ( d00 ) + Math . abs ( d01 ) + Math . abs ( d02 ) + Math . abs ( d03 ) , Math . abs ( d10 ) + Math . abs ( d11 ) + Math . abs ( d12 ) + Math . abs ( d13 ) ) , Math . max ( Math . abs ( d20 ) + Math . abs ( d21 ) + Math . abs ( d22 ) + Math . abs ( d23 ) , Math . abs ( d30 ) + Math . abs ( d31 ) + Math . abs ( d32 ) + Math . abs ( d33 ) ) ) ; } }
      private Quaternion c;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return c;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "c";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: c = (Quaternion) value; return;
            default: return;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         if ( ! built ) {
         attractor = new Attractor4 ( new Impl ( ) , new APoint4d ( ) ) ;
         setParametersChanged ( false ) ;
         built = true ;
         }
         else if ( parametersChanged ( ) ) {
         attractor = new Attractor4 ( new Impl ( ) , new APoint4d ( ) ) ;
         setParametersChanged ( false ) ;
         }
      }

      public Julia4() {
         addGroupMeta(this);
      }

      public Attractor4 evaluate(Context context, Object[] inputs) {

         return attractor ;
      }

      public Class getReturnType() {
         return Attractor4.class;
      }

   }

   public String getDescription() {
      return "Functions for strange attractors";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new getQuadtree());
      r.add(new PeterDeJong());
      r.add(new Clifford());
      r.add(new Quadratic2_x1());
      r.add(new Quadratic2());
      r.add(new Cubic2());
      r.add(new Julia2());
      r.add(new Quadratic3());
      r.add(new Julia4());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
