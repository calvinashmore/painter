package painter . functions . statements;

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
import fluids.*;
import fluids.applied.*;

public final class Fluids implements AllComponents<StatementFunction>, Described {

   public static class FluidLoop extends StatementFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "fluidExpression";
            case 1: return "body";
            default: return null;
         }

      }

      public InputSignature getInputSignature(int i) {
         switch(i) {
            case 0: return new ExpressionInputSignature(ColorFluid.class);
            case 1: return new StatementListInputSignature();
            default: return null;
         }

      }

      public FluidLoop() {
         addGroupMeta(this);
      }

      public int getNumberContextVariables() {
         return 4;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "color";
            case 1: return "position";
            case 2: return "velocity";
            case 3: return "position2d";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return LVect3d.class;
            case 2: return LVect3d.class;
            case 3: return LVect2d.class;
            default: return null;
         }

      }

      public void execute(Context context, List<GeneticComponent> inputs) throws TerminationException {
         Expression fluidExpression = (Expression) inputs.get(0);
         StatementList body = (StatementList) inputs.get(1);
         final String __color = getContextVariableActualName("color");
         Color color;
         final String __position = getContextVariableActualName("position");
         LVect3d position;
         final String __velocity = getContextVariableActualName("velocity");
         LVect3d velocity;
         final String __position2d = getContextVariableActualName("position2d");
         LVect2d position2d;
         ColorFluid fluid = ( ColorFluid ) fluidExpression . evaluate ( context ) ;
         for ( ColorParticle particle : fluid . getAllParticles ( ) ) {
         color = particle . getColor ( ) ; context.setVariable(__color, color);
         position = particle . getPosition ( ) ; context.setVariable(__position, position);
         velocity = particle . getVelocity ( ) ; context.setVariable(__velocity, velocity);
         position2d = new LVect2d ( position . x , position . z ) ; context.setVariable(__position2d, position2d);
         body . execute ( context ) ;
         }
      }

   }

   public String getDescription() {
      return "statements that iterate through fluids";
   }

   public List<StatementFunction> allInstances(ContextModel cm) {
      List<StatementFunction> r = new ArrayList<StatementFunction>();
      r.add(new FluidLoop());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
