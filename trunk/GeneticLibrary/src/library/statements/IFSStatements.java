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
import utils.ifs.*;

public final class IFSStatements implements AllComponents<StatementFunction>, Described {

   public static class ifsLoop_v2 extends StatementFunction {
      private Random random ;
      private Integer seed;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return seed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "seed";
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
            case 0: seed = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "ifsExpression";
            case 1: return "body";
            default: return null;
         }

      }

      public InputSignature getInputSignature(int i) {
         switch(i) {
            case 0: return new ExpressionInputSignature(IFSUtil . IFS_v2.class);
            case 1: return new StatementListInputSignature();
            default: return null;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         random = new Random ( seed ) ;
      }

      public ifsLoop_v2() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public String getDescription() {
         return "this loops through the ifs";
      }

      public int getNumberContextVariables() {
         return 1;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public void execute(Context context, List<GeneticComponent> inputs) throws TerminationException {
         Expression ifsExpression = (Expression) inputs.get(0);
         StatementList body = (StatementList) inputs.get(1);
         final String __v = getContextVariableActualName("v");
         LVect2d v;
         IFSUtil . IFS_v2 ifs = ( IFSUtil . IFS_v2 ) ifsExpression . evaluate ( context ) ;
         for ( int i = 0 ;
         i < 5000 ;
         i ++ ) {
         LVect2d start = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         LVect2d result = ifs . applyRepeatedly ( start , 20 , random ) ;
         v = result ; context.setVariable(__v, v);
         body . execute ( context ) ;
         }
      }

   }

   public String getDescription() {
      return "Loops through iterated function systems.";
   }

   public List<StatementFunction> allInstances(ContextModel cm) {
      List<StatementFunction> r = new ArrayList<StatementFunction>();
      r.add(new ifsLoop_v2());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
