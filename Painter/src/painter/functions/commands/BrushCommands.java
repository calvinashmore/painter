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

      public void execute(Context context, Object[] inputs) {
         LDouble x = (LDouble)inputs[0];
         LDouble y = (LDouble)inputs[1];
         Color color = (Color)inputs[2];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         new Brush ( ) . paint ( x . val , y . val , .02 , color , canvas ) ;
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

      public void execute(Context context, Object[] inputs) {
         LDouble x = (LDouble)inputs[0];
         LDouble y = (LDouble)inputs[1];
         LDouble r = (LDouble)inputs[2];
         Color color = (Color)inputs[3];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         new Brush ( ) . paint ( x . val , y . val , r . val , color , canvas ) ;
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

      public void execute(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         Color color = (Color)inputs[1];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         new Brush ( ) . paint ( x . x , x . y , .02 , color , canvas ) ;
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

      public void execute(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         LDouble r = (LDouble)inputs[1];
         Color color = (Color)inputs[2];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         new Brush ( ) . paint ( x . x , x . y , r . val , color , canvas ) ;
      }

   }

   public static class Line_d4_col extends Command {

      public int getNumberInputs() {
         return 5;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x1";
            case 1: return "y1";
            case 2: return "x2";
            case 3: return "y2";
            case 4: return "color";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            case 4: return Color.class;
            default: return null;
         }

      }

      public void execute(Context context, Object[] inputs) {
         LDouble x1 = (LDouble)inputs[0];
         LDouble y1 = (LDouble)inputs[1];
         LDouble x2 = (LDouble)inputs[2];
         LDouble y2 = (LDouble)inputs[3];
         Color color = (Color)inputs[4];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         new Brush ( ) . paintLine ( x1 . val , y1 . val , x2 . val , y2 . val , .02 , .02 , color , canvas ) ;
      }

   }

   public static class Line_d4_col2 extends Command {

      public int getNumberInputs() {
         return 6;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x1";
            case 1: return "y1";
            case 2: return "x2";
            case 3: return "y2";
            case 4: return "color1";
            case 5: return "color2";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            case 4: return Color.class;
            case 5: return Color.class;
            default: return null;
         }

      }

      public void execute(Context context, Object[] inputs) {
         LDouble x1 = (LDouble)inputs[0];
         LDouble y1 = (LDouble)inputs[1];
         LDouble x2 = (LDouble)inputs[2];
         LDouble y2 = (LDouble)inputs[3];
         Color color1 = (Color)inputs[4];
         Color color2 = (Color)inputs[5];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         new Brush ( ) . paintLine ( x1 . val , y1 . val , x2 . val , y2 . val , .02 , .02 , color1 , color2 , canvas ) ;
      }

   }

   public static class Line_d4_r_col extends Command {

      public int getNumberInputs() {
         return 6;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x1";
            case 1: return "y1";
            case 2: return "x2";
            case 3: return "y2";
            case 4: return "r";
            case 5: return "color";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            case 4: return LDouble.class;
            case 5: return Color.class;
            default: return null;
         }

      }

      public void execute(Context context, Object[] inputs) {
         LDouble x1 = (LDouble)inputs[0];
         LDouble y1 = (LDouble)inputs[1];
         LDouble x2 = (LDouble)inputs[2];
         LDouble y2 = (LDouble)inputs[3];
         LDouble r = (LDouble)inputs[4];
         Color color = (Color)inputs[5];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         new Brush ( ) . paintLine ( x1 . val , y1 . val , x2 . val , y2 . val , r . val , r . val , color , canvas ) ;
      }

   }

   public static class Line_d4_r_col2 extends Command {

      public int getNumberInputs() {
         return 7;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x1";
            case 1: return "y1";
            case 2: return "x2";
            case 3: return "y2";
            case 4: return "r";
            case 5: return "color1";
            case 6: return "color2";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            case 4: return LDouble.class;
            case 5: return Color.class;
            case 6: return Color.class;
            default: return null;
         }

      }

      public void execute(Context context, Object[] inputs) {
         LDouble x1 = (LDouble)inputs[0];
         LDouble y1 = (LDouble)inputs[1];
         LDouble x2 = (LDouble)inputs[2];
         LDouble y2 = (LDouble)inputs[3];
         LDouble r = (LDouble)inputs[4];
         Color color1 = (Color)inputs[5];
         Color color2 = (Color)inputs[6];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         new Brush ( ) . paintLine ( x1 . val , y1 . val , x2 . val , y2 . val , r . val , r . val , color1 , color2 , canvas ) ;
      }

   }

   public static class Line_v2_v2_col extends Command {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x1";
            case 1: return "x2";
            case 2: return "color";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            case 2: return Color.class;
            default: return null;
         }

      }

      public void execute(Context context, Object[] inputs) {
         LVect2d x1 = (LVect2d)inputs[0];
         LVect2d x2 = (LVect2d)inputs[1];
         Color color = (Color)inputs[2];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         new Brush ( ) . paintLine ( x1 . x , x1 . y , x2 . x , x2 . y , .02 , .02 , color , canvas ) ;
      }

   }

   public static class Line_v2_v2_col2 extends Command {

      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x1";
            case 1: return "x2";
            case 2: return "color1";
            case 3: return "color2";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            case 2: return Color.class;
            case 3: return Color.class;
            default: return null;
         }

      }

      public void execute(Context context, Object[] inputs) {
         LVect2d x1 = (LVect2d)inputs[0];
         LVect2d x2 = (LVect2d)inputs[1];
         Color color1 = (Color)inputs[2];
         Color color2 = (Color)inputs[3];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         new Brush ( ) . paintLine ( x1 . x , x1 . y , x2 . x , x2 . y , .02 , .02 , color1 , color2 , canvas ) ;
      }

   }

   public static class Line_v2_v2_r_col extends Command {

      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x1";
            case 1: return "x2";
            case 2: return "r";
            case 3: return "color";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            case 2: return LDouble.class;
            case 3: return Color.class;
            default: return null;
         }

      }

      public void execute(Context context, Object[] inputs) {
         LVect2d x1 = (LVect2d)inputs[0];
         LVect2d x2 = (LVect2d)inputs[1];
         LDouble r = (LDouble)inputs[2];
         Color color = (Color)inputs[3];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         new Brush ( ) . paintLine ( x1 . x , x1 . y , x2 . x , x2 . y , r . val , r . val , color , canvas ) ;
      }

   }

   public static class Line_v2_v2_r_col2 extends Command {

      public int getNumberInputs() {
         return 5;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x1";
            case 1: return "x2";
            case 2: return "r";
            case 3: return "color1";
            case 4: return "color2";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            case 2: return LDouble.class;
            case 3: return Color.class;
            case 4: return Color.class;
            default: return null;
         }

      }

      public void execute(Context context, Object[] inputs) {
         LVect2d x1 = (LVect2d)inputs[0];
         LVect2d x2 = (LVect2d)inputs[1];
         LDouble r = (LDouble)inputs[2];
         Color color1 = (Color)inputs[3];
         Color color2 = (Color)inputs[4];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         new Brush ( ) . paintLine ( x1 . x , x1 . y , x2 . x , x2 . y , r . val , r . val , color1 , color2 , canvas ) ;
      }

   }

   public static class Line_v2_v2_r2_col extends Command {

      public int getNumberInputs() {
         return 5;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x1";
            case 1: return "x2";
            case 2: return "r1";
            case 3: return "r2";
            case 4: return "color";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            case 4: return Color.class;
            default: return null;
         }

      }

      public void execute(Context context, Object[] inputs) {
         LVect2d x1 = (LVect2d)inputs[0];
         LVect2d x2 = (LVect2d)inputs[1];
         LDouble r1 = (LDouble)inputs[2];
         LDouble r2 = (LDouble)inputs[3];
         Color color = (Color)inputs[4];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         new Brush ( ) . paintLine ( x1 . x , x1 . y , x2 . x , x2 . y , r1 . val , r2 . val , color , canvas ) ;
      }

   }

   public static class Line_v2_v2_r2_col2 extends Command {

      public int getNumberInputs() {
         return 6;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x1";
            case 1: return "x2";
            case 2: return "r1";
            case 3: return "r2";
            case 4: return "color1";
            case 5: return "color2";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            case 4: return Color.class;
            case 5: return Color.class;
            default: return null;
         }

      }

      public void execute(Context context, Object[] inputs) {
         LVect2d x1 = (LVect2d)inputs[0];
         LVect2d x2 = (LVect2d)inputs[1];
         LDouble r1 = (LDouble)inputs[2];
         LDouble r2 = (LDouble)inputs[3];
         Color color1 = (Color)inputs[4];
         Color color2 = (Color)inputs[5];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         new Brush ( ) . paintLine ( x1 . x , x1 . y , x2 . x , x2 . y , r1 . val , r2 . val , color1 , color2 , canvas ) ;
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
      r.add(new Line_d4_col());
      r.add(new Line_d4_col2());
      r.add(new Line_d4_r_col());
      r.add(new Line_d4_r_col2());
      r.add(new Line_v2_v2_col());
      r.add(new Line_v2_v2_col2());
      r.add(new Line_v2_v2_r_col());
      r.add(new Line_v2_v2_r_col2());
      r.add(new Line_v2_v2_r2_col());
      r.add(new Line_v2_v2_r2_col2());
      return r;
   }

}
