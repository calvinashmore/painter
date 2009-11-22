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

public final class BooleanOperations implements AllComponents<ExpressionFunction>, Described {

   public static class or extends ExpressionFunction {

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
            case 0: return Boolean.class;
            case 1: return Boolean.class;
            default: return null;
         }

      }

      public or() {
         addGroupMeta(this);
      }

      public Boolean evaluate(Context context, Object[] inputs) {
         Boolean x = (Boolean)inputs[0];
         Boolean y = (Boolean)inputs[1];
         return x || y ;
      }

      public Class getReturnType() {
         return Boolean.class;
      }

   }

   public static class and extends ExpressionFunction {

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
            case 0: return Boolean.class;
            case 1: return Boolean.class;
            default: return null;
         }

      }

      public and() {
         addGroupMeta(this);
      }

      public Boolean evaluate(Context context, Object[] inputs) {
         Boolean x = (Boolean)inputs[0];
         Boolean y = (Boolean)inputs[1];
         return x && y ;
      }

      public Class getReturnType() {
         return Boolean.class;
      }

   }

   public static class xor extends ExpressionFunction {

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
            case 0: return Boolean.class;
            case 1: return Boolean.class;
            default: return null;
         }

      }

      public xor() {
         addGroupMeta(this);
      }

      public Boolean evaluate(Context context, Object[] inputs) {
         Boolean x = (Boolean)inputs[0];
         Boolean y = (Boolean)inputs[1];
         return x ^ y ;
      }

      public Class getReturnType() {
         return Boolean.class;
      }

   }

   public static class not extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Boolean.class;
            default: return null;
         }

      }

      public not() {
         addGroupMeta(this);
      }

      public Boolean evaluate(Context context, Object[] inputs) {
         Boolean x = (Boolean)inputs[0];
         return ! x ;
      }

      public Class getReturnType() {
         return Boolean.class;
      }

   }

   public String getDescription() {
      return "Boolean operations, such as logical operators and comparisons.";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new or());
      r.add(new and());
      r.add(new xor());
      r.add(new not());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
