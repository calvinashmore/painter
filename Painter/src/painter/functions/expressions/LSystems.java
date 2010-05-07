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
import utils.lsystem.*;
import utils.linear.*;
import painter.tools.lsystem.*;

public final class LSystems implements AllComponents<ExpressionFunction>, Described {

   public static class PermuteAngles extends ExpressionFunction {

      private LDouble angleMultiplier;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return angleMultiplier;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "angleMultiplier";
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
            case 0: angleMultiplier = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "ls";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LSystemString.class;
            default: return null;
         }

      }

      public PermuteAngles() {
         addGroupMeta(this);
         angleMultiplier = new LDouble ( .6 + .8 * Math . random ( ) ) ;
      }

      public LSystemString evaluate(Context context, Object[] inputs) {
         final LSystemString ls = (LSystemString)inputs[0];
         return new LSystemString ( ls . getString ( ) , angleMultiplier . val * ls . getAngle ( ) ) ;
      }

      public Class getReturnType() {
         return LSystemString.class;
      }

   }

   public static class LevyC extends ExpressionFunction {

      public LevyC() {
         addGroupMeta(this);
      }

      public LSystemString evaluate(Context context, Object[] inputs) {

         LSystem lSystem = new LSystem ( ) ;
         lSystem . addRule ( 'F' , "+F--F+" ) ;
         String out = lSystem . apply ( "F" , 8 ) ;
         return new LSystemString ( out , Math . PI / 4 ) ;
      }

      public Class getReturnType() {
         return LSystemString.class;
      }

   }

   public static class Pentigree extends ExpressionFunction {

      public Pentigree() {
         addGroupMeta(this);
      }

      public LSystemString evaluate(Context context, Object[] inputs) {

         LSystem lSystem = new LSystem ( ) ;
         lSystem . addRule ( 'F' , "F-F++F+F-F-F" ) ;
         String out = lSystem . apply ( "F-F-F-F-F" , 4 ) ;
         return new LSystemString ( out , 2 * Math . PI / 5 ) ;
      }

      public Class getReturnType() {
         return LSystemString.class;
      }

   }

   public static class IslandLake extends ExpressionFunction {

      public IslandLake() {
         addGroupMeta(this);
      }

      public LSystemString evaluate(Context context, Object[] inputs) {

         LSystem lSystem = new LSystem ( ) ;
         lSystem . addRule ( 'F' , "F-f+FF-F-FF-Ff-FF+f-FF+F+FF+Ff+FFF" ) ;
         String out = lSystem . apply ( "F" , 2 ) ;
         return new LSystemString ( out , Math . PI / 2 ) ;
      }

      public Class getReturnType() {
         return LSystemString.class;
      }

   }

   public static class KochIsland1 extends ExpressionFunction {

      public KochIsland1() {
         addGroupMeta(this);
      }

      public LSystemString evaluate(Context context, Object[] inputs) {

         LSystem lSystem = new LSystem ( ) ;
         lSystem . addRule ( 'F' , "F+F-F-FF+F+F-F" ) ;
         String out = lSystem . apply ( "F" , 3 ) ;
         return new LSystemString ( out , Math . PI / 2 ) ;
      }

      public Class getReturnType() {
         return LSystemString.class;
      }

   }

   public static class Koch1 extends ExpressionFunction {

      public Koch1() {
         addGroupMeta(this);
      }

      public LSystemString evaluate(Context context, Object[] inputs) {

         LSystem lSystem = new LSystem ( ) ;
         lSystem . addRule ( 'F' , "F+F-F-F+F" ) ;
         String out = lSystem . apply ( "F" , 5 ) ;
         return new LSystemString ( out , Math . PI / 2 ) ;
      }

      public Class getReturnType() {
         return LSystemString.class;
      }

   }

   public static class Koch2 extends ExpressionFunction {

      public Koch2() {
         addGroupMeta(this);
      }

      public LSystemString evaluate(Context context, Object[] inputs) {

         LSystem lSystem = new LSystem ( ) ;
         lSystem . addRule ( 'F' , "F+F--F+F" ) ;
         String out = lSystem . apply ( "F" , 5 ) ;
         return new LSystemString ( out , Math . PI / 6 ) ;
      }

      public Class getReturnType() {
         return LSystemString.class;
      }

   }

   public static class Koch3 extends ExpressionFunction {

      public Koch3() {
         addGroupMeta(this);
      }

      public LSystemString evaluate(Context context, Object[] inputs) {

         LSystem lSystem = new LSystem ( ) ;
         lSystem . addRule ( 'F' , "FF+F+F+F+F+F-F" ) ;
         String out = lSystem . apply ( "F" , 5 ) ;
         return new LSystemString ( out , Math . PI / 2 ) ;
      }

      public Class getReturnType() {
         return LSystemString.class;
      }

   }

   public static class Koch4 extends ExpressionFunction {

      public Koch4() {
         addGroupMeta(this);
      }

      public LSystemString evaluate(Context context, Object[] inputs) {

         LSystem lSystem = new LSystem ( ) ;
         lSystem . addRule ( 'F' , "FF+F++F+F" ) ;
         String out = lSystem . apply ( "F+F+F+F" , 5 ) ;
         return new LSystemString ( out , Math . PI / 2 ) ;
      }

      public Class getReturnType() {
         return LSystemString.class;
      }

   }

   public static class Koch5 extends ExpressionFunction {

      public Koch5() {
         addGroupMeta(this);
      }

      public LSystemString evaluate(Context context, Object[] inputs) {

         LSystem lSystem = new LSystem ( ) ;
         lSystem . addRule ( 'F' , "FF+F++F+F" ) ;
         String out = lSystem . apply ( "F+F+F+F" , 5 ) ;
         return new LSystemString ( out , 2 * Math . PI / 3 ) ;
      }

      public Class getReturnType() {
         return LSystemString.class;
      }

   }

   public static class Koch6 extends ExpressionFunction {

      public Koch6() {
         addGroupMeta(this);
      }

      public LSystemString evaluate(Context context, Object[] inputs) {

         LSystem lSystem = new LSystem ( ) ;
         lSystem . addRule ( 'F' , "F+FF++F+F" ) ;
         String out = lSystem . apply ( "F" , 5 ) ;
         return new LSystemString ( out , Math . PI / 2 ) ;
      }

      public Class getReturnType() {
         return LSystemString.class;
      }

   }

   public static class Serpinski1 extends ExpressionFunction {

      public Serpinski1() {
         addGroupMeta(this);
      }

      public LSystemString evaluate(Context context, Object[] inputs) {

         LSystem lSystem = new LSystem ( ) ;
         lSystem . addRule ( 'A' , "FB-FA-FB" ) ;
         lSystem . addRule ( 'B' , "FA+FB+FA" ) ;
         String out = lSystem . apply ( "A" , 6 ) ;
         return new LSystemString ( out , Math . PI / 6 ) ;
      }

      public Class getReturnType() {
         return LSystemString.class;
      }

   }

   public static class Dragon extends ExpressionFunction {

      public Dragon() {
         addGroupMeta(this);
      }

      public LSystemString evaluate(Context context, Object[] inputs) {

         LSystem lSystem = new LSystem ( ) ;
         lSystem . addRule ( 'X' , "X+YF" ) ;
         lSystem . addRule ( 'Y' , "FX-Y" ) ;
         String out = lSystem . apply ( "FX" , 10 ) ;
         return new LSystemString ( out , Math . PI / 2 ) ;
      }

      public Class getReturnType() {
         return LSystemString.class;
      }

   }

   public static class Plant1 extends ExpressionFunction {

      public Plant1() {
         addGroupMeta(this);
      }

      public LSystemString evaluate(Context context, Object[] inputs) {

         LSystem lSystem = new LSystem ( ) ;
         lSystem . addRule ( 'X' , "F-[[X]+X]+F[+FX]-X" ) ;
         lSystem . addRule ( 'F' , "FF" ) ;
         String out = lSystem . apply ( "X" , 5 ) ;
         return new LSystemString ( out , Math . PI * ( 25.0 / 180 ) ) ;
      }

      public Class getReturnType() {
         return LSystemString.class;
      }

   }

   public static class Plant2 extends ExpressionFunction {

      public Plant2() {
         addGroupMeta(this);
      }

      public LSystemString evaluate(Context context, Object[] inputs) {

         LSystem lSystem = new LSystem ( ) ;
         lSystem . addRule ( 'F' , "F[+F]F[-F]F" ) ;
         String out = lSystem . apply ( "X" , 5 ) ;
         return new LSystemString ( out , Math . PI / 7 ) ;
      }

      public Class getReturnType() {
         return LSystemString.class;
      }

   }

   public static class Plant3 extends ExpressionFunction {

      public Plant3() {
         addGroupMeta(this);
      }

      public LSystemString evaluate(Context context, Object[] inputs) {

         LSystem lSystem = new LSystem ( ) ;
         lSystem . addRule ( 'F' , "FF+[+F-F-F]-[F+F+F]" ) ;
         String out = lSystem . apply ( "X" , 4 ) ;
         return new LSystemString ( out , Math . PI / 8 ) ;
      }

      public Class getReturnType() {
         return LSystemString.class;
      }

   }

   public static class Plant4 extends ExpressionFunction {

      public Plant4() {
         addGroupMeta(this);
      }

      public LSystemString evaluate(Context context, Object[] inputs) {

         LSystem lSystem = new LSystem ( ) ;
         lSystem . addRule ( 'X' , "F[+X]F[-X]+X" ) ;
         lSystem . addRule ( 'F' , "FF" ) ;
         String out = lSystem . apply ( "X" , 7 ) ;
         return new LSystemString ( out , Math . PI / 9 ) ;
      }

      public Class getReturnType() {
         return LSystemString.class;
      }

   }

   public static class Spiral extends ExpressionFunction {

      public Spiral() {
         addGroupMeta(this);
      }

      public LSystemString evaluate(Context context, Object[] inputs) {

         LSystem lSystem = new LSystem ( ) ;
         lSystem . addRule ( 'A' , "X+X+X+X+X+X+" ) ;
         lSystem . addRule ( 'X' , "[F+F+F+F[---X-Y]+++++F++++++++F-F-F-F]" ) ;
         lSystem . addRule ( 'Y' , "[F+F+F+F[---Y]+++++F++++++++F-F-F-F]" ) ;
         String out = lSystem . apply ( "A" , 5 ) ;
         return new LSystemString ( out , Math . PI / 12 ) ;
      }

      public Class getReturnType() {
         return LSystemString.class;
      }

   }

   public String getDescription() {
      return "expressions for creating L-Systems";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new PermuteAngles());
      r.add(new LevyC());
      r.add(new Pentigree());
      r.add(new IslandLake());
      r.add(new KochIsland1());
      r.add(new Koch1());
      r.add(new Koch2());
      r.add(new Koch3());
      r.add(new Koch4());
      r.add(new Koch5());
      r.add(new Koch6());
      r.add(new Serpinski1());
      r.add(new Dragon());
      r.add(new Plant1());
      r.add(new Plant2());
      r.add(new Plant3());
      r.add(new Plant4());
      r.add(new Spiral());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
