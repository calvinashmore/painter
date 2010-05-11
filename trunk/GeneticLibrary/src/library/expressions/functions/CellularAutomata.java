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
      private transient Buffer_d data ;private void makeData ( ) { data = new Buffer_d ( dataSize , dataSize ) ; new CellularAutomata1d ( data , numberInputs , colors ) ; Buffer_d dataLarge = BlurTool . scaleBuffer ( data , dataSize * scaleFactor ) ; data = new BlurTool ( smoothing . val ) . process ( dataLarge , smoothRounds ) ; }
      private Integer numberInputs;private Integer colors;private Integer scaleFactor;private Integer smoothRounds;private LDouble smoothing;private Integer dataSize;
      public int getNumberParameters() {
         return 6;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return numberInputs;
            case 1: return colors;
            case 2: return scaleFactor;
            case 3: return smoothRounds;
            case 4: return smoothing;
            case 5: return dataSize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "numberInputs";
            case 1: return "colors";
            case 2: return "scaleFactor";
            case 3: return "smoothRounds";
            case 4: return "smoothing";
            case 5: return "dataSize";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return Integer.class;
            case 2: return Integer.class;
            case 3: return Integer.class;
            case 4: return LDouble.class;
            case 5: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: numberInputs = (Integer) value; return;
            case 1: colors = (Integer) value; return;
            case 2: scaleFactor = (Integer) value; return;
            case 3: smoothRounds = (Integer) value; return;
            case 4: smoothing = (LDouble) value; return;
            case 5: dataSize = (Integer) value; return;
            default: return;
         }

      }

      public cellular_1d1_discrete() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         numberInputs = 2 + rand . nextInt ( 3 ) ;
         colors = 2 + rand . nextInt ( 3 ) ;
         dataSize = 10 + rand . nextInt ( 10 ) ;
         scaleFactor = 2 + rand . nextInt ( 5 ) ;
         smoothRounds = 1 + rand . nextInt ( 4 ) ;
         smoothing = new LDouble ( 1.1 + 1 * rand . nextDouble ( ) ) ;
      }

      public Buffer_d evaluate(Context context, Object[] inputs) {

         if ( data == null ) makeData ( ) ;
         return data ;
      }

      public Class getReturnType() {
         return Buffer_d.class;
      }

   }

   public static class cellular_1d2_discrete extends ExpressionFunction {
      private transient Buffer_d data ;private void makeData ( ) { data = new Buffer_d ( dataSize , dataSize ) ; new CellularAutomata1d2 ( data , numberInputs , colors ) ; Buffer_d dataLarge = BlurTool . scaleBuffer ( data , dataSize * scaleFactor ) ; data = new BlurTool ( smoothing . val ) . process ( dataLarge , smoothRounds ) ; }
      private Integer numberInputs;private Integer colors;private Integer scaleFactor;private Integer smoothRounds;private LDouble smoothing;private Integer dataSize;
      public int getNumberParameters() {
         return 6;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return numberInputs;
            case 1: return colors;
            case 2: return scaleFactor;
            case 3: return smoothRounds;
            case 4: return smoothing;
            case 5: return dataSize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "numberInputs";
            case 1: return "colors";
            case 2: return "scaleFactor";
            case 3: return "smoothRounds";
            case 4: return "smoothing";
            case 5: return "dataSize";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return Integer.class;
            case 2: return Integer.class;
            case 3: return Integer.class;
            case 4: return LDouble.class;
            case 5: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: numberInputs = (Integer) value; return;
            case 1: colors = (Integer) value; return;
            case 2: scaleFactor = (Integer) value; return;
            case 3: smoothRounds = (Integer) value; return;
            case 4: smoothing = (LDouble) value; return;
            case 5: dataSize = (Integer) value; return;
            default: return;
         }

      }

      public cellular_1d2_discrete() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         numberInputs = 2 + rand . nextInt ( 3 ) ;
         colors = 2 + rand . nextInt ( 3 ) ;
         dataSize = 10 + rand . nextInt ( 10 ) ;
         scaleFactor = 2 + rand . nextInt ( 5 ) ;
         smoothRounds = 1 + rand . nextInt ( 4 ) ;
         smoothing = new LDouble ( 1.1 + 1 * rand . nextDouble ( ) ) ;
      }

      public Buffer_d evaluate(Context context, Object[] inputs) {

         if ( data == null ) makeData ( ) ;
         return data ;
      }

      public Class getReturnType() {
         return Buffer_d.class;
      }

   }

   public static class cellular_1d1_cont extends ExpressionFunction {
      private transient Buffer_d data ;private void makeData ( ) { data = new Buffer_d ( dataSize , dataSize ) ; new CellularAutomata1d_cont ( data , numberInputs ) ; Buffer_d dataLarge = BlurTool . scaleBuffer ( data , dataSize * scaleFactor ) ; data = new BlurTool ( smoothing . val ) . process ( dataLarge , smoothRounds ) ; }
      private Integer numberInputs;private Integer scaleFactor;private Integer smoothRounds;private LDouble smoothing;private Integer dataSize;
      public int getNumberParameters() {
         return 5;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return numberInputs;
            case 1: return scaleFactor;
            case 2: return smoothRounds;
            case 3: return smoothing;
            case 4: return dataSize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "numberInputs";
            case 1: return "scaleFactor";
            case 2: return "smoothRounds";
            case 3: return "smoothing";
            case 4: return "dataSize";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return Integer.class;
            case 2: return Integer.class;
            case 3: return LDouble.class;
            case 4: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: numberInputs = (Integer) value; return;
            case 1: scaleFactor = (Integer) value; return;
            case 2: smoothRounds = (Integer) value; return;
            case 3: smoothing = (LDouble) value; return;
            case 4: dataSize = (Integer) value; return;
            default: return;
         }

      }

      public cellular_1d1_cont() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         numberInputs = 2 + rand . nextInt ( 3 ) ;
         dataSize = 10 + rand . nextInt ( 10 ) ;
         scaleFactor = 2 + rand . nextInt ( 5 ) ;
         smoothRounds = 1 + rand . nextInt ( 4 ) ;
         smoothing = new LDouble ( 1.1 + 1 * rand . nextDouble ( ) ) ;
      }

      public Buffer_d evaluate(Context context, Object[] inputs) {

         if ( data == null ) makeData ( ) ;
         return data ;
      }

      public Class getReturnType() {
         return Buffer_d.class;
      }

   }

   public static class cellular_1d2_cont extends ExpressionFunction {
      private transient Buffer_d data ;private void makeData ( ) { data = new Buffer_d ( dataSize , dataSize ) ; new CellularAutomata1d2_cont ( data , numberInputs ) ; Buffer_d dataLarge = BlurTool . scaleBuffer ( data , dataSize * scaleFactor ) ; data = new BlurTool ( smoothing . val ) . process ( dataLarge , smoothRounds ) ; }
      private Integer numberInputs;private Integer scaleFactor;private Integer smoothRounds;private LDouble smoothing;private Integer dataSize;
      public int getNumberParameters() {
         return 5;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return numberInputs;
            case 1: return scaleFactor;
            case 2: return smoothRounds;
            case 3: return smoothing;
            case 4: return dataSize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "numberInputs";
            case 1: return "scaleFactor";
            case 2: return "smoothRounds";
            case 3: return "smoothing";
            case 4: return "dataSize";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return Integer.class;
            case 2: return Integer.class;
            case 3: return LDouble.class;
            case 4: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: numberInputs = (Integer) value; return;
            case 1: scaleFactor = (Integer) value; return;
            case 2: smoothRounds = (Integer) value; return;
            case 3: smoothing = (LDouble) value; return;
            case 4: dataSize = (Integer) value; return;
            default: return;
         }

      }

      public cellular_1d2_cont() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         numberInputs = 2 + rand . nextInt ( 3 ) ;
         dataSize = 10 + rand . nextInt ( 10 ) ;
         scaleFactor = 2 + rand . nextInt ( 5 ) ;
         smoothRounds = 1 + rand . nextInt ( 4 ) ;
         smoothing = new LDouble ( 1.1 + 1 * rand . nextDouble ( ) ) ;
      }

      public Buffer_d evaluate(Context context, Object[] inputs) {

         if ( data == null ) makeData ( ) ;
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
