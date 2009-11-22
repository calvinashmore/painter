package painter . functions . expressions;

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
import painter.tools.brush.*;

public final class Brushes implements AllComponents<ExpressionFunction>, Described {

   public static class simpleBrush1 extends ExpressionFunction {

      public simpleBrush1() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {

         return new SimpleBrush ( ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class simpleBrush2 extends ExpressionFunction {

      private LDouble radiusMultiplier;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return radiusMultiplier;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "radiusMultiplier";
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
            case 0: radiusMultiplier = (LDouble) value; return;
            default: return;
         }

      }

      public simpleBrush2() {
         addGroupMeta(this);
         radiusMultiplier = new LDouble ( .2 * Math . random ( ) * .5 ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {

         return new SimpleBrush ( radiusMultiplier . val ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class simpleBrush3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "radiusMultiplier";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public simpleBrush3() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {
         LDouble radiusMultiplier = (LDouble)inputs[0];
         return new SimpleBrush ( radiusMultiplier . val ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class hollowCircleBrush extends ExpressionFunction {

      public hollowCircleBrush() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {

         return new HollowCircleBrush ( ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class cyclingBrush extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "brush";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Brush.class;
            default: return null;
         }

      }

      public cyclingBrush() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {
         Brush brush = (Brush)inputs[0];
         return new CyclingBrush ( brush ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class penBrush extends ExpressionFunction {

      public penBrush() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {

         return new PenBrush ( ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class sweepBrush1 extends ExpressionFunction {

      private int numberDots;private double dotSize;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return numberDots;
            case 1: return dotSize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "numberDots";
            case 1: return "dotSize";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return int.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: numberDots = (Integer) value; return;
            case 1: dotSize = (Double) value; return;
            default: return;
         }

      }

      public sweepBrush1() {
         addGroupMeta(this);
         dotSize = .2 + .8 * Math . random ( ) ;
         numberDots = ( int ) ( 3 + 5 * Math . random ( ) ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {

         return new SweepBrush ( numberDots , dotSize , new SimpleBrush ( ) ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class sweepBrush2 extends ExpressionFunction {

      private int numberDots;private double dotSize;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return numberDots;
            case 1: return dotSize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "numberDots";
            case 1: return "dotSize";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return int.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: numberDots = (Integer) value; return;
            case 1: dotSize = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "brush";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Brush.class;
            default: return null;
         }

      }

      public sweepBrush2() {
         addGroupMeta(this);
         dotSize = .2 + .8 * Math . random ( ) ;
         numberDots = ( int ) ( 3 + 5 * Math . random ( ) ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         Brush brush = (Brush)inputs[0];
         return new SweepBrush ( numberDots , dotSize , brush ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public String getDescription() {
      return "expressions to generate brushes";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new simpleBrush1());
      r.add(new simpleBrush2());
      r.add(new simpleBrush3());
      r.add(new hollowCircleBrush());
      r.add(new cyclingBrush());
      r.add(new penBrush());
      r.add(new sweepBrush1());
      r.add(new sweepBrush2());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
