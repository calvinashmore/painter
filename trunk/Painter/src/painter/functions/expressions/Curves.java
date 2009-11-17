package painter . functions . expressions;

import java.util.*;
import genetic.*;
import genetic.component.accessor.*;
import genetic.component.command.*;
import genetic.component.context.*;
import genetic.component.expression.*;
import genetic.component.expression.function.*;
import genetic.component.method.*;
import genetic.component.program.*;
import genetic.component.statement.*;
import genetic.component.statementlist.*;
import genetic.component.statement.function.*;
import utils.linear.*;
import painter.util.curves.*;

public final class Curves implements AllComponents<ExpressionFunction>, Described {

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
         LDouble x = (LDouble)inputs[0];
         LDouble y = (LDouble)inputs[1];
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
         LVect2d x = (LVect2d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
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
         Color x = (Color)inputs[0];
         Color y = (Color)inputs[1];
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
         LVect2d center = (LVect2d)inputs[0];
         LDouble radius = (LDouble)inputs[1];
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
         LVect2d center = (LVect2d)inputs[0];
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

   public String getDescription() {
      return "expressions to generate curves";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new segmentCurve_d());
      r.add(new segmentCurve_v2());
      r.add(new segmentCurve_col());
      r.add(new circleCurve_v2());
      r.add(new circleCurve1_v2());
      r.add(new sinCurve_d());
      r.add(new cosCurve_d());
      r.add(new sinBumpCurve_d());
      r.add(new cosBumpCurve_d());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
