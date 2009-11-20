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
import painter.tools.brush.*;
import painter.tools.stroke.*;

public final class Strokes implements AllComponents<ExpressionFunction>, Described {

   public static class basicStroke extends ExpressionFunction {

      public basicStroke() {
         addGroupMeta(this);
      }

      public Stroke evaluate(Context context, Object[] inputs) {

         return new BasicStroke ( ) ;
      }

      public Class getReturnType() {
         return Stroke.class;
      }

   }

   public static class alphaStroke1 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "alpha";
            case 1: return "baseStroke";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_d.class;
            case 1: return Stroke.class;
            default: return null;
         }

      }

      public alphaStroke1() {
         addGroupMeta(this);
      }

      public Stroke evaluate(Context context, Object[] inputs) {
         CurveUtil . Curve_d alpha = (CurveUtil . Curve_d)inputs[0];
         Stroke baseStroke = (Stroke)inputs[1];
         return new AlphaStroke ( baseStroke , alpha ) ;
      }

      public Class getReturnType() {
         return Stroke.class;
      }

   }

   public static class alphaStroke2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "baseStroke";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Stroke.class;
            default: return null;
         }

      }

      public alphaStroke2() {
         addGroupMeta(this);
      }

      public Stroke evaluate(Context context, Object[] inputs) {
         Stroke baseStroke = (Stroke)inputs[0];
         return new AlphaStroke ( baseStroke ) ;
      }

      public Class getReturnType() {
         return Stroke.class;
      }

   }

   public static class alphaStroke3 extends ExpressionFunction {

      public alphaStroke3() {
         addGroupMeta(this);
      }

      public Stroke evaluate(Context context, Object[] inputs) {

         return new AlphaStroke ( new BasicStroke ( ) ) ;
      }

      public Class getReturnType() {
         return Stroke.class;
      }

   }

   public static class basicSegmentRenderer extends ExpressionFunction {

      public basicSegmentRenderer() {
         addGroupMeta(this);
      }

      public SegmentRenderer evaluate(Context context, Object[] inputs) {

         return new BasicSegmentRenderer ( ) ;
      }

      public Class getReturnType() {
         return SegmentRenderer.class;
      }

   }

   public String getDescription() {
      return "expressions to generate brush strokes";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new basicStroke());
      r.add(new alphaStroke1());
      r.add(new alphaStroke2());
      r.add(new alphaStroke3());
      r.add(new basicSegmentRenderer());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
