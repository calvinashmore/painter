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
import painter.tools.stroke.*;
import painter.util.curves.*;

public final class StrokeCommands implements AllComponents<Command>, Described {

   public static class SimpleStroke extends Command {

      private LDouble width;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return width;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "width";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: width = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "position";
            case 1: return "color";
            case 2: return "brush";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_v2.class;
            case 1: return Color.class;
            case 2: return Brush.class;
            default: return null;
         }

      }

      public SimpleStroke() {
         addGroupMeta(this);
         width = new LDouble ( Math . random ( ) * .1 ) ;
      }

      public void execute(Context context, Object[] inputs) {
         CurveUtil . Curve_v2 position = (CurveUtil . Curve_v2)inputs[0];
         Color color = (Color)inputs[1];
         Brush brush = (Brush)inputs[2];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         Stroke stroke = new Stroke ( position , color ) ;
         stroke . setSize ( width . val ) ;
         stroke . setBrush ( brush ) ;
         stroke . render ( canvas ) ;
      }

   }

   public static class ColorStroke1 extends Command {

      private LDouble width;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return width;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "width";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: width = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "position";
            case 1: return "color";
            case 2: return "brush";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_v2.class;
            case 1: return CurveUtil . Curve_col.class;
            case 2: return Brush.class;
            default: return null;
         }

      }

      public ColorStroke1() {
         addGroupMeta(this);
         width = new LDouble ( Math . random ( ) * .1 ) ;
      }

      public void execute(Context context, Object[] inputs) {
         CurveUtil . Curve_v2 position = (CurveUtil . Curve_v2)inputs[0];
         CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         Brush brush = (Brush)inputs[2];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         Stroke stroke = new Stroke ( new ConstantCurve < LDouble > ( width ) , position , color ) ;
         stroke . setBrush ( brush ) ;
         stroke . render ( canvas ) ;
      }

   }

   public static class ColorStroke2 extends Command {

      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "position";
            case 1: return "color";
            case 2: return "width";
            case 3: return "brush";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_v2.class;
            case 1: return CurveUtil . Curve_col.class;
            case 2: return LDouble.class;
            case 3: return Brush.class;
            default: return null;
         }

      }

      public ColorStroke2() {
         addGroupMeta(this);
      }

      public void execute(Context context, Object[] inputs) {
         CurveUtil . Curve_v2 position = (CurveUtil . Curve_v2)inputs[0];
         CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         LDouble width = (LDouble)inputs[2];
         Brush brush = (Brush)inputs[3];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         Stroke stroke = new Stroke ( new ConstantCurve < LDouble > ( width ) , position , color ) ;
         stroke . setBrush ( brush ) ;
         stroke . render ( canvas ) ;
      }

   }

   public static class ColorSizeStroke extends Command {

      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "position";
            case 1: return "color";
            case 2: return "size";
            case 3: return "brush";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_v2.class;
            case 1: return CurveUtil . Curve_col.class;
            case 2: return CurveUtil . Curve_d.class;
            case 3: return Brush.class;
            default: return null;
         }

      }

      public ColorSizeStroke() {
         addGroupMeta(this);
      }

      public void execute(Context context, Object[] inputs) {
         CurveUtil . Curve_v2 position = (CurveUtil . Curve_v2)inputs[0];
         CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         CurveUtil . Curve_d size = (CurveUtil . Curve_d)inputs[2];
         Brush brush = (Brush)inputs[3];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         Stroke stroke = new Stroke ( size , position , color ) ;
         stroke . setBrush ( brush ) ;
         stroke . render ( canvas ) ;
      }

   }

   public String getDescription() {
      return "Stroke commands";
   }

   public List<Command> allInstances(ContextModel cm) {
      List<Command> r = new ArrayList<Command>();
      r.add(new SimpleStroke());
      r.add(new ColorStroke1());
      r.add(new ColorStroke2());
      r.add(new ColorSizeStroke());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
