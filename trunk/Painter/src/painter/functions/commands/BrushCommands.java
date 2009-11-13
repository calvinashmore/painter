package painter . functions . commands;

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
import painter.tools.canvas.*;
import painter.tools.brush.*;

public final class BrushCommands implements AllComponents<Command>, Described {

   public static class Plot_d2_col extends Command {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "color";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return Color.class;
            default: return null;
         }

      }

      public Plot_d2_col() {
         addGroupMeta(this);
      }

      public void execute(Context context, Object[] inputs) {
         LDouble x = (LDouble)inputs[0];
         LDouble y = (LDouble)inputs[1];
         Color color = (Color)inputs[2];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         new SimpleBrush ( ) . paint ( x . val , y . val , 0 , 0 , .02 , color , canvas ) ;
      }

   }

   public static class Plot_d2_r_col extends Command {

      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "r";
            case 3: return "color";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return Color.class;
            default: return null;
         }

      }

      public Plot_d2_r_col() {
         addGroupMeta(this);
      }

      public void execute(Context context, Object[] inputs) {
         LDouble x = (LDouble)inputs[0];
         LDouble y = (LDouble)inputs[1];
         LDouble r = (LDouble)inputs[2];
         Color color = (Color)inputs[3];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         new SimpleBrush ( ) . paint ( x . val , y . val , 0 , 0 , r . val , color , canvas ) ;
      }

   }

   public static class Plot_v2_col extends Command {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "color";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public Plot_v2_col() {
         addGroupMeta(this);
      }

      public void execute(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         Color color = (Color)inputs[1];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         new SimpleBrush ( ) . paint ( x . x , x . y , 0 , 0 , .02 , color , canvas ) ;
      }

   }

   public static class Plot_v2_r_col extends Command {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "r";
            case 2: return "color";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LDouble.class;
            case 2: return Color.class;
            default: return null;
         }

      }

      public Plot_v2_r_col() {
         addGroupMeta(this);
      }

      public void execute(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         LDouble r = (LDouble)inputs[1];
         Color color = (Color)inputs[2];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         new SimpleBrush ( ) . paint ( x . x , x . y , 0 , 0 , r . val , color , canvas ) ;
      }

   }

   public String getDescription() {
      return "Brush commands";
   }

   public List<Command> allInstances(ContextModel cm) {
      List<Command> r = new ArrayList<Command>();
      r.add(new Plot_d2_col());
      r.add(new Plot_d2_r_col());
      r.add(new Plot_v2_col());
      r.add(new Plot_v2_r_col());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
