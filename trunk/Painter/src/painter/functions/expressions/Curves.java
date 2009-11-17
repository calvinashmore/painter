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
         return new CurveUtil . Curve_d ( new SegmentCurve ( x , y ) ) ;
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
         return new CurveUtil . Curve_v2 ( new SegmentCurve ( x , y ) ) ;
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
         return new CurveUtil . Curve_col ( new SegmentCurve ( x , y ) ) ;
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
      r.add(new segmentCurve_d());
      r.add(new segmentCurve_v2());
      r.add(new segmentCurve_col());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
