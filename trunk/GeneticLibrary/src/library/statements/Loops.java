package library . statements;

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

public final class Loops implements AllComponents<StatementFunction>, Described {
   public static class loop_parameter extends StatementFunction {

      private Integer n;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return n;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "n";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: n = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "body";
            default: return null;
         }

      }

      public InputSignature getInputSignature(int i) {
         switch(i) {
            case 0: return new StatementListInputSignature();
            default: return null;
         }

      }

      public loop_parameter() {

         n = 10 + new Random ( ) . nextInt ( 10 ) ;
      }

      public String getDescription() {
         return "Loops n times. The parameter n is initialized to a value between 10 and 20.";
      }

      public void execute(Context context, List<GeneticComponent> inputs) {
         StatementList body = (StatementList) inputs.get(0);
         String __i = getContextVariableActualName("i");
         Integer i;
         String __x = getContextVariableActualName("x");
         LDouble x;
         i = 0 ; context.setVariable(__i, i);
         while ( i < n ) {
         x = new LDouble ( 1.0 * i / n ) ; context.setVariable(__x, x);
         body . execute ( context ) ;
         i = i + 1 ; context.setVariable(__i, i);
         }
      }

      public int getNumberContextVariables() {
         return 2;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "i";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

   }

   public static class loop_input extends StatementFunction {
      private static final int max = 100000 ;
      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "n";
            case 1: return "body";
            default: return null;
         }

      }

      public InputSignature getInputSignature(int i) {
         switch(i) {
            case 0: return new ExpressionInputSignature(Integer.class);
            case 1: return new StatementListInputSignature();
            default: return null;
         }

      }

      public String getDescription() {
         return "Loops n times, where n is an input value.";
      }

      public void execute(Context context, List<GeneticComponent> inputs) {
         Expression n = (Expression) inputs.get(0);
         StatementList body = (StatementList) inputs.get(1);
         String __i = getContextVariableActualName("i");
         Integer i;
         String __x = getContextVariableActualName("x");
         LDouble x;
         int nValue = ( Integer ) n . evaluate ( context ) ;
         nValue = Math . min ( nValue , max ) ;
         i = 0 ; context.setVariable(__i, i);
         while ( i < nValue ) {
         x = new LDouble ( 1.0 * i / nValue ) ; context.setVariable(__x, x);
         body . execute ( context ) ;
         i = i + 1 ; context.setVariable(__i, i);
         }
      }

      public int getNumberContextVariables() {
         return 2;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "i";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

   }

   public static class loop_parameter_2d extends StatementFunction {

      private Integer n;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return n;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "n";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: n = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "body";
            default: return null;
         }

      }

      public InputSignature getInputSignature(int i) {
         switch(i) {
            case 0: return new StatementListInputSignature();
            default: return null;
         }

      }

      public loop_parameter_2d() {

         n = 10 + new Random ( ) . nextInt ( 10 ) ;
      }

      public String getDescription() {
         return "Loops n times in two dimensions. The parameter n is initialized to a value between 10 and 20.";
      }

      public void execute(Context context, List<GeneticComponent> inputs) {
         StatementList body = (StatementList) inputs.get(0);
         String __i = getContextVariableActualName("i");
         Integer i;
         String __j = getContextVariableActualName("j");
         Integer j;
         String __x = getContextVariableActualName("x");
         LDouble x;
         String __y = getContextVariableActualName("y");
         LDouble y;
         String __v = getContextVariableActualName("v");
         LVect2d v;
         i = 0 ; context.setVariable(__i, i);
         j = 0 ; context.setVariable(__j, j);
         while ( i < n ) {
         x = new LDouble ( 1.0 * i / n ) ; context.setVariable(__x, x);
         j = 0 ; context.setVariable(__j, j);
         while ( j < n ) {
         y = new LDouble ( 1.0 * j / n ) ; context.setVariable(__y, y);
         v = new LVect2d ( x . val , y . val ) ; context.setVariable(__v, v);
         body . execute ( context ) ;
         j = j + 1 ; context.setVariable(__j, j);
         }
         i = i + 1 ; context.setVariable(__i, i);
         }
      }

      public int getNumberContextVariables() {
         return 5;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "i";
            case 1: return "j";
            case 2: return "x";
            case 3: return "y";
            case 4: return "v";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return Integer.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            case 4: return LVect2d.class;
            default: return null;
         }

      }

   }

   public static class loop_parameter_3d extends StatementFunction {

      private Integer n;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return n;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "n";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: n = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "body";
            default: return null;
         }

      }

      public InputSignature getInputSignature(int i) {
         switch(i) {
            case 0: return new StatementListInputSignature();
            default: return null;
         }

      }

      public loop_parameter_3d() {

         n = 10 + new Random ( ) . nextInt ( 10 ) ;
      }

      public String getDescription() {
         return "Loops n times in two dimensions. The parameter n is initialized to a value between 10 and 20.";
      }

      public void execute(Context context, List<GeneticComponent> inputs) {
         StatementList body = (StatementList) inputs.get(0);
         String __i = getContextVariableActualName("i");
         Integer i;
         String __j = getContextVariableActualName("j");
         Integer j;
         String __k = getContextVariableActualName("k");
         Integer k;
         String __x = getContextVariableActualName("x");
         LDouble x;
         String __y = getContextVariableActualName("y");
         LDouble y;
         String __z = getContextVariableActualName("z");
         LDouble z;
         String __v = getContextVariableActualName("v");
         LVect3d v;
         i = 0 ; context.setVariable(__i, i);
         while ( i < n ) {
         x = new LDouble ( 1.0 * i / n ) ; context.setVariable(__x, x);
         j = 0 ; context.setVariable(__j, j);
         while ( j < n ) {
         y = new LDouble ( 1.0 * j / n ) ; context.setVariable(__y, y);
         k = 0 ; context.setVariable(__k, k);
         while ( k < n ) {
         z = new LDouble ( 1.0 * k / n ) ; context.setVariable(__z, z);
         v = new LVect3d ( x . val , y . val , z . val ) ; context.setVariable(__v, v);
         body . execute ( context ) ;
         k = k + 1 ; context.setVariable(__k, k);
         }
         j = j + 1 ; context.setVariable(__j, j);
         }
         i = i + 1 ; context.setVariable(__i, i);
         }
      }

      public int getNumberContextVariables() {
         return 7;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "i";
            case 1: return "j";
            case 2: return "k";
            case 3: return "x";
            case 4: return "y";
            case 5: return "z";
            case 6: return "v";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return Integer.class;
            case 2: return Integer.class;
            case 3: return LDouble.class;
            case 4: return LDouble.class;
            case 5: return LDouble.class;
            case 6: return LVect3d.class;
            default: return null;
         }

      }

   }

   public String getDescription() {
      return "Statements that use some looping structure.";
   }

   public List<StatementFunction> allInstances(ContextModel cm) {
      List<StatementFunction> r = new ArrayList<StatementFunction>();
      r.add(new loop_parameter());
      r.add(new loop_input());
      r.add(new loop_parameter_2d());
      r.add(new loop_parameter_3d());
      return r;
   }

}
