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

public final class Conditionals implements AllComponents<StatementFunction> {
   public static class boolean_if_else extends StatementFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "condition";
            case 1: return "result_true";
            case 2: return "result_false";
            default: return null;
         }

      }

      public InputSignature getInputSignature(int i) {
         switch(i) {
            case 0: return new ExpressionInputSignature(Boolean.class);
            case 1: return new StatementListInputSignature();
            case 2: return new StatementListInputSignature();
            default: return null;
         }

      }

      public void execute(Context context, List<GeneticComponent> inputs) {
         Expression condition = (Expression) inputs.get(0);
         StatementList result_true = (StatementList) inputs.get(1);
         StatementList result_false = (StatementList) inputs.get(2);

         boolean result = ( Boolean ) condition . evaluate ( context ) ;
         if ( result ) {
         result_true . execute ( context ) ;
         }
         else {
         result_false . execute ( context ) ;
         }
      }

   }

   public static class boolean_if extends StatementFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "condition";
            case 1: return "result_true";
            default: return null;
         }

      }

      public InputSignature getInputSignature(int i) {
         switch(i) {
            case 0: return new ExpressionInputSignature(Boolean.class);
            case 1: return new StatementListInputSignature();
            default: return null;
         }

      }

      public void execute(Context context, List<GeneticComponent> inputs) {
         Expression condition = (Expression) inputs.get(0);
         StatementList result_true = (StatementList) inputs.get(1);

         boolean result = ( Boolean ) condition . evaluate ( context ) ;
         if ( result ) {
         result_true . execute ( context ) ;
         }
      }

   }

   public static class less_than_property_d extends StatementFunction {

      private LDouble property;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return property;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "property";
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
            case 0: property = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "value";
            case 1: return "result_true";
            default: return null;
         }

      }

      public InputSignature getInputSignature(int i) {
         switch(i) {
            case 0: return new ExpressionInputSignature(LDouble.class);
            case 1: return new StatementListInputSignature();
            default: return null;
         }

      }

      public less_than_property_d() {

         property = new LDouble ( Math . random ( ) ) ;
      }

      public String getDescription() {
         return "about";
      }

      public void execute(Context context, List<GeneticComponent> inputs) {
         Expression value = (Expression) inputs.get(0);
         StatementList result_true = (StatementList) inputs.get(1);

         LDouble dValue = ( LDouble ) value . evaluate ( context ) ;
         if ( dValue . val < property . val ) result_true . execute ( context ) ;
      }

   }

   public List<StatementFunction> allInstances(ContextModel cm) {
      List<StatementFunction> r = new ArrayList<StatementFunction>();
      r.add(new boolean_if_else());
      r.add(new boolean_if());
      r.add(new less_than_property_d());
      return r;
   }

}
