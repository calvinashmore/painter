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
import utils.lsystem.*;
import utils.linear.*;
import utils.curves.*;
import painter.tools.lsystem.*;

public final class LSystems implements AllComponents<StatementFunction>, Described {

   public static class LSystemLoop extends StatementFunction {

      private LDouble initialTheta;private LDouble scale;private LVect2d initialPosition;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return initialTheta;
            case 1: return scale;
            case 2: return initialPosition;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "initialTheta";
            case 1: return "scale";
            case 2: return "initialPosition";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: initialTheta = (LDouble) value; return;
            case 1: scale = (LDouble) value; return;
            case 2: initialPosition = (LVect2d) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "stringExpression";
            case 1: return "body";
            default: return null;
         }

      }

      public InputSignature getInputSignature(int i) {
         switch(i) {
            case 0: return new ExpressionInputSignature(LSystemString.class);
            case 1: return new StatementListInputSignature();
            default: return null;
         }

      }

      public LSystemLoop() {
         addGroupMeta(this);
         initialTheta = new LDouble ( Math . random ( ) * Math . PI * 2 ) ;
         initialPosition = new LVect2d ( Math . random ( ) , Math . random ( ) ) ;
         scale = new LDouble ( 1 + Math . random ( ) ) ;
      }

      public int getNumberContextVariables() {
         return 3;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "segment";
            case 1: return "t";
            case 2: return "start";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_v2.class;
            case 1: return LDouble.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public void execute(Context context, List<GeneticComponent> inputs) throws TerminationException {
         Expression stringExpression = (Expression) inputs.get(0);
         StatementList body = (StatementList) inputs.get(1);
         final String __segment = getContextVariableActualName("segment");
         CurveUtil . Curve_v2 segment;
         final String __t = getContextVariableActualName("t");
         LDouble t;
         final String __start = getContextVariableActualName("start");
         LVect2d start;
         LSystemString string = ( LSystemString ) stringExpression . evaluate ( context ) ;
         LSystemRenderer lRenderer = new LSystemRenderer ( ) ;
         lRenderer . setRotateSize ( string . getAngle ( ) ) ;
         lRenderer . setInitialCoordinates ( initialPosition . x , initialPosition . y , initialTheta . val ) ;
         lRenderer . setScale ( scale . val ) ;
         List < CurveUtil . Curve_v2 > curves = lRenderer . process ( string . getString ( ) ) ;
         for ( int i = 0 ;
         i < curves . size ( ) ;
         i ++ ) {
         segment = curves . get ( i ) ; context.setVariable(__segment, segment);
         t = new LDouble ( ( double ) i / curves . size ( ) ) ; context.setVariable(__t, t);
         start = segment . getValue ( 0 ) ; context.setVariable(__start, start);
         body . execute ( context ) ;
         }
      }

   }

   public String getDescription() {
      return "statements that iterate through L-Systems";
   }

   public List<StatementFunction> allInstances(ContextModel cm) {
      List<StatementFunction> r = new ArrayList<StatementFunction>();
      r.add(new LSystemLoop());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
