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
import utils.linear.grid.*;
import utils.cellularautomata.*;

public final class CellularAutomata implements AllComponents<ExpressionFunction>, Described {

   public static class cellular_1d1_discrete extends ExpressionFunction {

      private Integer numberInputs;private Integer colors;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return numberInputs;
            case 1: return colors;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "numberInputs";
            case 1: return "colors";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: numberInputs = (Integer) value; return;
            case 1: colors = (Integer) value; return;
            default: return;
         }

      }

      public cellular_1d1_discrete() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         numberInputs = 2 + rand . nextInt ( 3 ) ;
         colors = 2 + rand . nextInt ( 3 ) ;
      }

      public Buffer_d evaluate(Context context, Object[] inputs) {

         Buffer_d data = new Buffer_d ( 100 , 100 ) ;
         new CellularAutomata1d ( data , numberInputs , colors ) ;
         return data ;
      }

      public Class getReturnType() {
         return Buffer_d.class;
      }

   }

   public static class cellular_1d2_discrete extends ExpressionFunction {

      private Integer numberInputs;private Integer colors;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return numberInputs;
            case 1: return colors;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "numberInputs";
            case 1: return "colors";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: numberInputs = (Integer) value; return;
            case 1: colors = (Integer) value; return;
            default: return;
         }

      }

      public cellular_1d2_discrete() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         numberInputs = 2 + rand . nextInt ( 3 ) ;
         colors = 2 + rand . nextInt ( 3 ) ;
      }

      public Buffer_d evaluate(Context context, Object[] inputs) {

         Buffer_d data = new Buffer_d ( 100 , 100 ) ;
         new CellularAutomata1d2 ( data , numberInputs , colors ) ;
         return data ;
      }

      public Class getReturnType() {
         return Buffer_d.class;
      }

   }

   public static class cellular_1d1_cont extends ExpressionFunction {

      private Integer numberInputs;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return numberInputs;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "numberInputs";
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
            case 0: numberInputs = (Integer) value; return;
            default: return;
         }

      }

      public cellular_1d1_cont() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         numberInputs = 2 + rand . nextInt ( 3 ) ;
      }

      public Buffer_d evaluate(Context context, Object[] inputs) {

         Buffer_d data = new Buffer_d ( 100 , 100 ) ;
         new CellularAutomata1d_cont ( data , numberInputs ) ;
         return data ;
      }

      public Class getReturnType() {
         return Buffer_d.class;
      }

   }

   public static class cellular_1d2_cont extends ExpressionFunction {

      private Integer numberInputs;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return numberInputs;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "numberInputs";
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
            case 0: numberInputs = (Integer) value; return;
            default: return;
         }

      }

      public cellular_1d2_cont() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         numberInputs = 2 + rand . nextInt ( 3 ) ;
      }

      public Buffer_d evaluate(Context context, Object[] inputs) {

         Buffer_d data = new Buffer_d ( 100 , 100 ) ;
         new CellularAutomata1d2_cont ( data , numberInputs ) ;
         return data ;
      }

      public Class getReturnType() {
         return Buffer_d.class;
      }

   }

   public String getDescription() {
      return "Cellular Automata";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new cellular_1d1_discrete());
      r.add(new cellular_1d2_discrete());
      r.add(new cellular_1d1_cont());
      r.add(new cellular_1d2_cont());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
