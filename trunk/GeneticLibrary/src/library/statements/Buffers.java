package library . statements;

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
import utils.linear.grid.*;

public final class Buffers implements AllComponents<StatementFunction>, Described {

   public static class loop_buffer_d extends StatementFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "bufferExpression";
            case 1: return "body";
            default: return null;
         }

      }

      public InputSignature getInputSignature(int i) {
         switch(i) {
            case 0: return new ExpressionInputSignature(Buffer_d.class);
            case 1: return new StatementListInputSignature();
            default: return null;
         }

      }

      public loop_buffer_d() {
         addGroupMeta(this);
         addMeta("selectionWeight", 3);
      }

      public int getNumberContextVariables() {
         return 2;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "pos";
            case 1: return "value";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public void execute(Context context, List<GeneticComponent> inputs) throws TerminationException {
         Expression bufferExpression = (Expression) inputs.get(0);
         StatementList body = (StatementList) inputs.get(1);
         final String __pos = getContextVariableActualName("pos");
         LVect2d pos;
         final String __value = getContextVariableActualName("value");
         LDouble value;
         Buffer_d buffer = ( Buffer_d ) bufferExpression . evaluate ( context ) ;
         int xRes = buffer . getXRes ( ) ;
         int yRes = buffer . getYRes ( ) ;
         for ( int x = 0 ;
         x < xRes ;
         x ++ ) for ( int y = 0 ;
         y < yRes ;
         y ++ ) {
         pos = new LVect2d ( ( double ) x / xRes , ( double ) y / yRes ) ; context.setVariable(__pos, pos);
         value = buffer . getValue ( x , y ) ; context.setVariable(__value, value);
         body . execute ( context ) ;
         }
      }

   }

   public String getDescription() {
      return "Loops through buffers.";
   }

   public List<StatementFunction> allInstances(ContextModel cm) {
      List<StatementFunction> r = new ArrayList<StatementFunction>();
      r.add(new loop_buffer_d());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
