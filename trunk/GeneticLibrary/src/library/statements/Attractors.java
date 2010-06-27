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

      public void execute(Context context, List<GeneticComponent> inputs) throws TerminationException {
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
         List < APoint2d > points = ( List < APoint2d > ) attractor . getResult ( ) . getValues ( ) ;
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

   public static class attractorLoop_v3 extends StatementFunction {

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
            case 0: return new ExpressionInputSignature(Attractor3.class);
            case 1: return new StatementListInputSignature();
            default: return null;
         }

      }

      public attractorLoop_v3() {
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
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            default: return null;
         }

      }

      public void execute(Context context, List<GeneticComponent> inputs) throws TerminationException {
         Expression attractorExpression = (Expression) inputs.get(0);
         StatementList body = (StatementList) inputs.get(1);
         final String __v = getContextVariableActualName("v");
         LVect3d v;
         final String __direction = getContextVariableActualName("direction");
         LVect3d direction;
         final String __derivative = getContextVariableActualName("derivative");
         LDouble derivative;
         final String __t = getContextVariableActualName("t");
         LDouble t;
         Attractor3 attractor = ( Attractor3 ) attractorExpression . evaluate ( context ) ;
         LVect3d lastv = null ;
         int count = 0 ;
         List < APoint3d > points = ( List < APoint3d > ) attractor . getResult ( ) . getValues ( ) ;
         for ( APoint3d a : points ) {
         v = new LVect3d ( a . x , a . y , a . z ) ; context.setVariable(__v, v);
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

   public static class attractorLoop_v4 extends StatementFunction {

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
            case 0: return new ExpressionInputSignature(Attractor4.class);
            case 1: return new StatementListInputSignature();
            default: return null;
         }

      }

      public attractorLoop_v4() {
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
            case 0: return "direction";
            case 1: return "v";
            case 2: return "derivative";
            case 3: return "t";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            case 1: return Quaternion.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            default: return null;
         }

      }

      public void execute(Context context, List<GeneticComponent> inputs) throws TerminationException {
         Expression attractorExpression = (Expression) inputs.get(0);
         StatementList body = (StatementList) inputs.get(1);
         final String __direction = getContextVariableActualName("direction");
         Quaternion direction;
         final String __v = getContextVariableActualName("v");
         Quaternion v;
         final String __derivative = getContextVariableActualName("derivative");
         LDouble derivative;
         final String __t = getContextVariableActualName("t");
         LDouble t;
         Attractor4 attractor = ( Attractor4 ) attractorExpression . evaluate ( context ) ;
         Quaternion lastv = null ;
         int count = 0 ;
         List < APoint4d > points = ( List < APoint4d > ) attractor . getResult ( ) . getValues ( ) ;
         for ( APoint4d a : points ) {
         v = new Quaternion ( a . w , a . x , a . y , a . z ) ; context.setVariable(__v, v);
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
      r.add(new attractorLoop_v3());
      r.add(new attractorLoop_v4());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
