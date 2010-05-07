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

   public String getDescription() {
      return "expressions for creating L-Systems";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new Koch1());
      r.add(new Koch2());
      r.add(new Dragon());
      r.add(new Plant1());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
