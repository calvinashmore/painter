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
         final Boolean x = (Boolean)inputs[0];
         final Boolean y = (Boolean)inputs[1];
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
         final Boolean x = (Boolean)inputs[0];
         final Boolean y = (Boolean)inputs[1];
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
         final Boolean x = (Boolean)inputs[0];
         final Boolean y = (Boolean)inputs[1];
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
         final Boolean x = (Boolean)inputs[0];
         return ! x ;
      }

      public Class getReturnType() {
         return Boolean.class;
      }

   }

   public static class lessThan extends ExpressionFunction {

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

      public lessThan() {
         addGroupMeta(this);
      }

      public Boolean evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         final LDouble y = (LDouble)inputs[1];
         return x . val < y . val ;
      }

      public Class getReturnType() {
         return Boolean.class;
      }

   }

   public static class greaterThan extends ExpressionFunction {

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

      public greaterThan() {
         addGroupMeta(this);
      }

      public Boolean evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         final LDouble y = (LDouble)inputs[1];
         return x . val > y . val ;
      }

      public Class getReturnType() {
         return Boolean.class;
      }

   }

   public static class nearTo extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "epsilon";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public nearTo() {
         addGroupMeta(this);
      }

      public Boolean evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         final LDouble y = (LDouble)inputs[1];
         final LDouble epsilon = (LDouble)inputs[2];
         return Math . abs ( x . val - y . val ) < epsilon . val ;
      }

      public Class getReturnType() {
         return Boolean.class;
      }

   }

   public static class modulo1_i1 extends ExpressionFunction {

      private int mod;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return mod;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "mod";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return int.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: mod = (Integer) value; return;
            default: return;
         }

      }

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
            case 0: return Integer.class;
            default: return null;
         }

      }

      public modulo1_i1() {
         addGroupMeta(this);
         mod = 1 + ( int ) ( 6 * Math . random ( ) ) ;
      }

      public Boolean evaluate(Context context, Object[] inputs) {
         final Integer x = (Integer)inputs[0];
         return x % mod == 0 ;
      }

      public Class getReturnType() {
         return Boolean.class;
      }

   }

   public static class modulo1_i2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "mod";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return Integer.class;
            default: return null;
         }

      }

      public modulo1_i2() {
         addGroupMeta(this);
      }

      public Boolean evaluate(Context context, Object[] inputs) {
         final Integer x = (Integer)inputs[0];
         final Integer mod = (Integer)inputs[1];
         if ( mod == 0 ) return false ;
         return x % mod == 0 ;
      }

      public Class getReturnType() {
         return Boolean.class;
      }

   }

   public static class modulo2_i1 extends ExpressionFunction {

      private int mod;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return mod;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "mod";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return int.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: mod = (Integer) value; return;
            default: return;
         }

      }

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
            case 0: return Integer.class;
            case 1: return Integer.class;
            default: return null;
         }

      }

      public modulo2_i1() {
         addGroupMeta(this);
         mod = 1 + ( int ) ( 6 * Math . random ( ) ) ;
      }

      public Boolean evaluate(Context context, Object[] inputs) {
         final Integer x = (Integer)inputs[0];
         final Integer y = (Integer)inputs[1];
         return ( x - y ) % mod == 0 ;
      }

      public Class getReturnType() {
         return Boolean.class;
      }

   }

   public static class modulo2_i2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "mod";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return Integer.class;
            case 2: return Integer.class;
            default: return null;
         }

      }

      public modulo2_i2() {
         addGroupMeta(this);
      }

      public Boolean evaluate(Context context, Object[] inputs) {
         final Integer x = (Integer)inputs[0];
         final Integer y = (Integer)inputs[1];
         final Integer mod = (Integer)inputs[2];
         if ( mod == 0 ) return false ;
         return ( x - y ) % mod == 0 ;
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
      r.add(new lessThan());
      r.add(new greaterThan());
      r.add(new nearTo());
      r.add(new modulo1_i1());
      r.add(new modulo1_i2());
      r.add(new modulo2_i1());
      r.add(new modulo2_i2());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
