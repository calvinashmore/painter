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
import utils.pointfield.attractor.*;

public final class Attractors implements AllComponents<StatementFunction>, Described {

   public static class attractorLoop_v2 extends StatementFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "attractorExpression";
            case 1: return "body";
            default: return null;
         }

      }

      public InputSignature getInputSignature(int i) {
         switch(i) {
            case 0: return new ExpressionInputSignature(Attractor2.class);
            case 1: return new StatementListInputSignature();
            default: return null;
         }

      }

      public attractorLoop_v2() {
         addGroupMeta(this);
      }

      public String getDescription() {
         return "this loops through the attractor and gives variables indicating direction and gradient";
      }

      public int getNumberContextVariables() {
         return 4;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "v";
            case 1: return "direction";
            case 2: return "derivative";
            case 3: return "t";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            default: return null;
         }

      }

      public void execute(Context context, List<GeneticComponent> inputs) {
         Expression attractorExpression = (Expression) inputs.get(0);
         StatementList body = (StatementList) inputs.get(1);
         final String __v = getContextVariableActualName("v");
         LVect2d v;
         final String __direction = getContextVariableActualName("direction");
         LVect2d direction;
         final String __derivative = getContextVariableActualName("derivative");
         LDouble derivative;
         final String __t = getContextVariableActualName("t");
         LDouble t;
         Attractor2 attractor = ( Attractor2 ) attractorExpression . evaluate ( context ) ;
         LVect2d lastv = null ;
         int count = 0 ;
         List < APoint2d > points = ( List < APoint2d > ) attractor . getQuadtree ( ) . getPoints ( ) ;
         for ( APoint2d a : points ) {
         v = new LVect2d ( a . x , a . y ) ; context.setVariable(__v, v);
         if ( count > 0 ) {
         direction = v . sub ( lastv ) ; context.setVariable(__direction, direction);
         derivative = new LDouble ( attractor . getFunction ( ) . derivMagnitude ( a ) ) ; context.setVariable(__derivative, derivative);
         t = new LDouble ( 1.0 * count / points . size ( ) ) ; context.setVariable(__t, t);
         body . execute ( context ) ;
         }
         lastv = v ;
         count ++ ;
         }
      }

   }

   public String getDescription() {
      return "Loops through strange attractors.";
   }

   public List<StatementFunction> allInstances(ContextModel cm) {
      List<StatementFunction> r = new ArrayList<StatementFunction>();
      r.add(new attractorLoop_v2());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
