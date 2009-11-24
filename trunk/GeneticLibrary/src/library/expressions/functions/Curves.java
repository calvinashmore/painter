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
import utils.curves.*;

public final class Curves implements AllComponents<ExpressionFunction>, Described {

   public static class exCurve_d extends ContextDependentExpressionFunction {

      public exCurve_d() {
         addGroupMeta(this);
      }

      public int getNumberContextVariables() {
         return 1;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public CurveUtil . Curve_d evaluate(final Context context, final Object[] inputs, final List<Expression> contextExpressions) {

         final Expression f = (Expression) contextExpressions.get(0);
         final String __x = getContextVariableActualName("x");
         LDouble x;
         return new CurveUtil . Curve_d ( ) {
         public LDouble getValue ( double t ) {
         context . setVariable ( __x , new LDouble ( t ) ) ;
         return ( LDouble ) f . evaluate ( context ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_d.class;
      }

      public int getNumberContextInputs() {
         return 1;
      }

      public String getContextInputName(int i) {
         switch(i) {
            case 0: return "f";
            default: return null;
         }

      }

      public Class getContextInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

   }

   public static class exCurve_v2 extends ContextDependentExpressionFunction {

      public exCurve_v2() {
         addGroupMeta(this);
      }

      public int getNumberContextVariables() {
         return 1;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public CurveUtil . Curve_v2 evaluate(final Context context, final Object[] inputs, final List<Expression> contextExpressions) {

         final Expression f = (Expression) contextExpressions.get(0);
         final String __x = getContextVariableActualName("x");
         LDouble x;
         return new CurveUtil . Curve_v2 ( ) {
         public LVect2d getValue ( double t ) {
         context . setVariable ( __x , new LDouble ( t ) ) ;
         return ( LVect2d ) f . evaluate ( context ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

      public int getNumberContextInputs() {
         return 1;
      }

      public String getContextInputName(int i) {
         switch(i) {
            case 0: return "f";
            default: return null;
         }

      }

      public Class getContextInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

   }

   public static class exCurve_col extends ContextDependentExpressionFunction {

      public exCurve_col() {
         addGroupMeta(this);
      }

      public int getNumberContextVariables() {
         return 1;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public CurveUtil . Curve_col evaluate(final Context context, final Object[] inputs, final List<Expression> contextExpressions) {

         final Expression f = (Expression) contextExpressions.get(0);
         final String __x = getContextVariableActualName("x");
         LDouble x;
         return new CurveUtil . Curve_col ( ) {
         public Color getValue ( double t ) {
         context . setVariable ( __x , new LDouble ( t ) ) ;
         return ( Color ) f . evaluate ( context ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

      public int getNumberContextInputs() {
         return 1;
      }

      public String getContextInputName(int i) {
         switch(i) {
            case 0: return "f";
            default: return null;
         }

      }

      public Class getContextInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

   }

   public static class segmentCurve_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public segmentCurve_d() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_d evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         final LDouble y = (LDouble)inputs[1];
         return new CurveUtil . Curve_d_wrap ( new SegmentCurve ( x , y ) ) ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_d.class;
      }

   }

   public static class segmentCurve_v2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public segmentCurve_v2() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         final LVect2d y = (LVect2d)inputs[1];
         return new CurveUtil . Curve_v2_wrap ( new SegmentCurve ( x , y ) ) ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class segmentCurve_col extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public segmentCurve_col() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         final Color y = (Color)inputs[1];
         return new CurveUtil . Curve_col_wrap ( new SegmentCurve ( x , y ) ) ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public static class segmentCurve1_d extends ExpressionFunction {

      private LDouble x;private LDouble y;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return x;
            case 1: return y;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: x = (LDouble) value; return;
            case 1: y = (LDouble) value; return;
            default: return;
         }

      }

      public segmentCurve1_d() {
         addGroupMeta(this);
         x = new LDouble ( 2 * Math . random ( ) - 1 ) ;
         y = new LDouble ( 2 * Math . random ( ) - 1 ) ;
      }

      public CurveUtil . Curve_d evaluate(Context context, Object[] inputs) {

         return new CurveUtil . Curve_d_wrap ( new SegmentCurve ( x , y ) ) ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_d.class;
      }

   }

   public static class segmentCurve1_v2 extends ExpressionFunction {

      private LVect2d x;private LVect2d y;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return x;
            case 1: return y;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: x = (LVect2d) value; return;
            case 1: y = (LVect2d) value; return;
            default: return;
         }

      }

      public segmentCurve1_v2() {
         addGroupMeta(this);
         x = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         y = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {

         return new CurveUtil . Curve_v2_wrap ( new SegmentCurve ( x , y ) ) ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class segmentCurve1_col extends ExpressionFunction {

      private Color x;private Color y;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return x;
            case 1: return y;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: x = (Color) value; return;
            case 1: y = (Color) value; return;
            default: return;
         }

      }

      public segmentCurve1_col() {
         addGroupMeta(this);
         x = new Color ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         y = new Color ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {

         return new CurveUtil . Curve_col_wrap ( new SegmentCurve ( x , y ) ) ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public static class circleCurve_v2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "center";
            case 1: return "radius";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public circleCurve_v2() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {
         final LVect2d center = (LVect2d)inputs[0];
         final LDouble radius = (LDouble)inputs[1];
         return new CurveUtil . Curve_v2_wrap ( new Circle ( center , radius . val ) ) ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class circleCurve1_v2 extends ExpressionFunction {

      private LDouble radius;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return radius;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "radius";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: radius = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "center";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public circleCurve1_v2() {
         addGroupMeta(this);
         radius = new LDouble ( Math . random ( ) + .1 ) ;
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {
         final LVect2d center = (LVect2d)inputs[0];
         return new CurveUtil . Curve_v2_wrap ( new Circle ( center , radius . val ) ) ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class sinCurve_d extends ExpressionFunction {

      public sinCurve_d() {
         addGroupMeta(this);
      }

      public String getDescription() {
         return "This is a sin curve from 0 to 2*pi";
      }

      public CurveUtil . Curve_d evaluate(Context context, Object[] inputs) {

         return new CurveUtil . Curve_d ( ) {
         public LDouble getValue ( double t ) {
         return new LDouble ( Math . sin ( t * 2 * Math . PI ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_d.class;
      }

   }

   public static class cosCurve_d extends ExpressionFunction {

      public cosCurve_d() {
         addGroupMeta(this);
      }

      public String getDescription() {
         return "This is a cos curve from 0 to 2*pi";
      }

      public CurveUtil . Curve_d evaluate(Context context, Object[] inputs) {

         return new CurveUtil . Curve_d ( ) {
         public LDouble getValue ( double t ) {
         return new LDouble ( Math . cos ( t * 2 * Math . PI ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_d.class;
      }

   }

   public static class sinBumpCurve_d extends ExpressionFunction {

      public sinBumpCurve_d() {
         addGroupMeta(this);
      }

      public String getDescription() {
         return "This is a sin curve from 0 to pi, creating a bump";
      }

      public CurveUtil . Curve_d evaluate(Context context, Object[] inputs) {

         return new CurveUtil . Curve_d ( ) {
         public LDouble getValue ( double t ) {
         return new LDouble ( Math . sin ( t * Math . PI ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_d.class;
      }

   }

   public static class cosBumpCurve_d extends ExpressionFunction {

      public cosBumpCurve_d() {
         addGroupMeta(this);
      }

      public String getDescription() {
         return "This is a cos curve from -pi to pi, creating a tapered bump, and scaled so its range is in 1/0";
      }

      public CurveUtil . Curve_d evaluate(Context context, Object[] inputs) {

         return new CurveUtil . Curve_d ( ) {
         public LDouble getValue ( double t ) {
         return new LDouble ( .5 + .5 * Math . cos ( - Math . PI + t * Math . PI ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_d.class;
      }

   }

   public static class spiralArchimedean extends ExpressionFunction {

      private double a;private double b;
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
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (Double) value; return;
            case 1: b = (Double) value; return;
            default: return;
         }

      }

      public spiralArchimedean() {
         addGroupMeta(this);
         a = .8 + .4 * Math . random ( ) ;
         b = 2 + 2 * Math . random ( ) ;
      }

      public String getDescription() {
         return "Archimedean spiral";
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {

         return new CurveUtil . Curve_v2_wrap ( new ArchimedeanSpiral ( a , b ) ) ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class spiralFermat extends ExpressionFunction {

      private double a;private double b;
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
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (Double) value; return;
            case 1: b = (Double) value; return;
            default: return;
         }

      }

      public spiralFermat() {
         addGroupMeta(this);
         a = .8 + .4 * Math . random ( ) ;
         b = 2 + 2 * Math . random ( ) ;
      }

      public String getDescription() {
         return "Fermat spiral";
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {

         return new CurveUtil . Curve_v2_wrap ( new FermatSpiral ( a , b ) ) ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class spiralLogarithmic extends ExpressionFunction {

      private double a;private double b;private double c;
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
            case 0: return double.class;
            case 1: return double.class;
            case 2: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (Double) value; return;
            case 1: b = (Double) value; return;
            case 2: c = (Double) value; return;
            default: return;
         }

      }

      public spiralLogarithmic() {
         addGroupMeta(this);
         a = .8 + .4 * Math . random ( ) ;
         b = .8 + .4 * Math . random ( ) ;
         c = 2 + 2 * Math . random ( ) ;
      }

      public String getDescription() {
         return "Logarithmic spiral";
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {

         return new CurveUtil . Curve_v2_wrap ( new LogarithmicSpiral ( a , b , c ) ) ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class add_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_d.class;
            case 1: return CurveUtil . Curve_d.class;
            default: return null;
         }

      }

      public add_d() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_d evaluate(Context context, Object[] inputs) {
         final CurveUtil . Curve_d x = (CurveUtil . Curve_d)inputs[0];
         final CurveUtil . Curve_d y = (CurveUtil . Curve_d)inputs[1];
         return new CurveUtil . Curve_d_wrap ( CurveUtil . add ( x , y ) ) ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_d.class;
      }

   }

   public static class sub_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_d.class;
            case 1: return CurveUtil . Curve_d.class;
            default: return null;
         }

      }

      public sub_d() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_d evaluate(Context context, Object[] inputs) {
         final CurveUtil . Curve_d x = (CurveUtil . Curve_d)inputs[0];
         final CurveUtil . Curve_d y = (CurveUtil . Curve_d)inputs[1];
         return new CurveUtil . Curve_d_wrap ( CurveUtil . sub ( x , y ) ) ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_d.class;
      }

   }

   public static class mult_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "c";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_d.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public mult_d() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_d evaluate(Context context, Object[] inputs) {
         final CurveUtil . Curve_d x = (CurveUtil . Curve_d)inputs[0];
         final LDouble c = (LDouble)inputs[1];
         return new CurveUtil . Curve_d_wrap ( CurveUtil . mult ( x , c . val ) ) ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_d.class;
      }

   }

   public static class add_v2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_v2.class;
            case 1: return CurveUtil . Curve_v2.class;
            default: return null;
         }

      }

      public add_v2() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {
         final CurveUtil . Curve_v2 x = (CurveUtil . Curve_v2)inputs[0];
         final CurveUtil . Curve_v2 y = (CurveUtil . Curve_v2)inputs[1];
         return new CurveUtil . Curve_v2_wrap ( CurveUtil . add ( x , y ) ) ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class sub_v2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_v2.class;
            case 1: return CurveUtil . Curve_v2.class;
            default: return null;
         }

      }

      public sub_v2() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {
         final CurveUtil . Curve_v2 x = (CurveUtil . Curve_v2)inputs[0];
         final CurveUtil . Curve_v2 y = (CurveUtil . Curve_v2)inputs[1];
         return new CurveUtil . Curve_v2_wrap ( CurveUtil . sub ( x , y ) ) ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class mult_v2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "c";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_v2.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public mult_v2() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {
         final CurveUtil . Curve_v2 x = (CurveUtil . Curve_v2)inputs[0];
         final LDouble c = (LDouble)inputs[1];
         return new CurveUtil . Curve_v2_wrap ( CurveUtil . mult ( x , c . val ) ) ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class add_col extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_col.class;
            case 1: return CurveUtil . Curve_col.class;
            default: return null;
         }

      }

      public add_col() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final CurveUtil . Curve_col x = (CurveUtil . Curve_col)inputs[0];
         final CurveUtil . Curve_col y = (CurveUtil . Curve_col)inputs[1];
         return new CurveUtil . Curve_col_wrap ( CurveUtil . add ( x , y ) ) ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public static class sub_col extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_col.class;
            case 1: return CurveUtil . Curve_col.class;
            default: return null;
         }

      }

      public sub_col() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final CurveUtil . Curve_col x = (CurveUtil . Curve_col)inputs[0];
         final CurveUtil . Curve_col y = (CurveUtil . Curve_col)inputs[1];
         return new CurveUtil . Curve_col_wrap ( CurveUtil . sub ( x , y ) ) ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public static class mult_col extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "c";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_col.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public mult_col() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final CurveUtil . Curve_col x = (CurveUtil . Curve_col)inputs[0];
         final LDouble c = (LDouble)inputs[1];
         return new CurveUtil . Curve_col_wrap ( CurveUtil . mult ( x , c . val ) ) ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public static class compose_v2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_d.class;
            case 1: return CurveUtil . Curve_d.class;
            default: return null;
         }

      }

      public compose_v2() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {
         final CurveUtil . Curve_d x = (CurveUtil . Curve_d)inputs[0];
         final CurveUtil . Curve_d y = (CurveUtil . Curve_d)inputs[1];
         return new CurveUtil . Curve_v2 ( ) {
         public LVect2d getValue ( double t ) {
         return new LVect2d ( x . getValue ( t ) . val , y . getValue ( t ) . val ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class compose_col_rgb extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "z";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_d.class;
            case 1: return CurveUtil . Curve_d.class;
            case 2: return CurveUtil . Curve_d.class;
            default: return null;
         }

      }

      public compose_col_rgb() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final CurveUtil . Curve_d x = (CurveUtil . Curve_d)inputs[0];
         final CurveUtil . Curve_d y = (CurveUtil . Curve_d)inputs[1];
         final CurveUtil . Curve_d z = (CurveUtil . Curve_d)inputs[2];
         return new CurveUtil . Curve_col ( ) {
         public Color getValue ( double t ) {
         return new Color ( x . getValue ( t ) . val , y . getValue ( t ) . val , z . getValue ( t ) . val ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public static class compose_col_hsb extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "z";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_d.class;
            case 1: return CurveUtil . Curve_d.class;
            case 2: return CurveUtil . Curve_d.class;
            default: return null;
         }

      }

      public compose_col_hsb() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final CurveUtil . Curve_d x = (CurveUtil . Curve_d)inputs[0];
         final CurveUtil . Curve_d y = (CurveUtil . Curve_d)inputs[1];
         final CurveUtil . Curve_d z = (CurveUtil . Curve_d)inputs[2];
         return new CurveUtil . Curve_col ( ) {
         public Color getValue ( double t ) {
         return Color . makeHSB ( x . getValue ( t ) . val , y . getValue ( t ) . val , z . getValue ( t ) . val ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public String getDescription() {
      return "expressions to generate curves";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new exCurve_d());
      r.add(new exCurve_v2());
      r.add(new exCurve_col());
      r.add(new segmentCurve_d());
      r.add(new segmentCurve_v2());
      r.add(new segmentCurve_col());
      r.add(new segmentCurve1_d());
      r.add(new segmentCurve1_v2());
      r.add(new segmentCurve1_col());
      r.add(new circleCurve_v2());
      r.add(new circleCurve1_v2());
      r.add(new sinCurve_d());
      r.add(new cosCurve_d());
      r.add(new sinBumpCurve_d());
      r.add(new cosBumpCurve_d());
      r.add(new spiralArchimedean());
      r.add(new spiralFermat());
      r.add(new spiralLogarithmic());
      r.add(new add_d());
      r.add(new sub_d());
      r.add(new mult_d());
      r.add(new add_v2());
      r.add(new sub_v2());
      r.add(new mult_v2());
      r.add(new add_col());
      r.add(new sub_col());
      r.add(new mult_col());
      r.add(new compose_v2());
      r.add(new compose_col_rgb());
      r.add(new compose_col_hsb());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
