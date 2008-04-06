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
         i = 0; context.setVariable(__i, i);
         while ( i < n ) {
         body . execute ( context ) ;
         i = i+1; context.setVariable(__i, i);
         }
      }

      public int getNumberContextVariables() {
         return 1;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "i";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return Integer.class;
            default: return null;
         }

      }

   }

   public static class loop_input extends StatementFunction {

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
         int nValue = ( Integer ) n . evaluate ( context ) ;
         i = 0; context.setVariable(__i, i);
         while ( i < nValue ) {
         body . execute ( context ) ;
         i = i+1; context.setVariable(__i, i);
         }
      }

      public int getNumberContextVariables() {
         return 1;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "i";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return Integer.class;
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
      return r;
   }

}
