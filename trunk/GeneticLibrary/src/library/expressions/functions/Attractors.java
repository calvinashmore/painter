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
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
