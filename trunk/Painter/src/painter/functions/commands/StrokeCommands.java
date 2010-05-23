package painter . functions . commands;

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
import utils.curves.*;
import painter.tools.canvas.*;
import painter.tools.brush.*;
import painter.tools.stroke.*;

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
         return 5;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "position";
            case 1: return "color";
            case 2: return "brush";
            case 3: return "stroke";
            case 4: return "renderer";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_v2.class;
            case 1: return Color.class;
            case 2: return Brush.class;
            case 3: return Stroke.class;
            case 4: return SegmentRenderer.class;
            default: return null;
         }

      }

      public SimpleStroke() {
         addGroupMeta(this);
         width = new LDouble ( Math . random ( ) * .1 ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final CurveUtil . Curve_v2 position = (CurveUtil . Curve_v2)inputs[0];
         final Color color = (Color)inputs[1];
         final Brush brush = (Brush)inputs[2];
         final Stroke stroke = (Stroke)inputs[3];
         final SegmentRenderer renderer = (SegmentRenderer)inputs[4];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         stroke . render ( brush , new ConstantCurve < LDouble > ( width ) , position , new ConstantCurve < Color > ( color ) , canvas , renderer ) ;
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
         return 5;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "position";
            case 1: return "color";
            case 2: return "brush";
            case 3: return "stroke";
            case 4: return "renderer";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_v2.class;
            case 1: return CurveUtil . Curve_col.class;
            case 2: return Brush.class;
            case 3: return Stroke.class;
            case 4: return SegmentRenderer.class;
            default: return null;
         }

      }

      public ColorStroke1() {
         addGroupMeta(this);
         width = new LDouble ( Math . random ( ) * .1 ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final CurveUtil . Curve_v2 position = (CurveUtil . Curve_v2)inputs[0];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         final Brush brush = (Brush)inputs[2];
         final Stroke stroke = (Stroke)inputs[3];
         final SegmentRenderer renderer = (SegmentRenderer)inputs[4];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         stroke . render ( brush , new ConstantCurve < LDouble > ( width ) , position , color , canvas , renderer ) ;
      }

   }

   public static class ColorStroke2 extends Command {

      public int getNumberInputs() {
         return 6;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "position";
            case 1: return "color";
            case 2: return "width";
            case 3: return "brush";
            case 4: return "stroke";
            case 5: return "renderer";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_v2.class;
            case 1: return CurveUtil . Curve_col.class;
            case 2: return LDouble.class;
            case 3: return Brush.class;
            case 4: return Stroke.class;
            case 5: return SegmentRenderer.class;
            default: return null;
         }

      }

      public ColorStroke2() {
         addGroupMeta(this);
      }

      public void execute(Context context, Object[] inputs) {
         final CurveUtil . Curve_v2 position = (CurveUtil . Curve_v2)inputs[0];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         final LDouble width = (LDouble)inputs[2];
         final Brush brush = (Brush)inputs[3];
         final Stroke stroke = (Stroke)inputs[4];
         final SegmentRenderer renderer = (SegmentRenderer)inputs[5];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         stroke . render ( brush , new ConstantCurve < LDouble > ( width ) , position , color , canvas , renderer ) ;
      }

   }

   public static class ColorSizeStroke extends Command {

      public int getNumberInputs() {
         return 6;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "position";
            case 1: return "color";
            case 2: return "width";
            case 3: return "brush";
            case 4: return "stroke";
            case 5: return "renderer";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_v2.class;
            case 1: return CurveUtil . Curve_col.class;
            case 2: return CurveUtil . Curve_d.class;
            case 3: return Brush.class;
            case 4: return Stroke.class;
            case 5: return SegmentRenderer.class;
            default: return null;
         }

      }

      public ColorSizeStroke() {
         addGroupMeta(this);
      }

      public void execute(Context context, Object[] inputs) {
         final CurveUtil . Curve_v2 position = (CurveUtil . Curve_v2)inputs[0];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         final CurveUtil . Curve_d width = (CurveUtil . Curve_d)inputs[2];
         final Brush brush = (Brush)inputs[3];
         final Stroke stroke = (Stroke)inputs[4];
         final SegmentRenderer renderer = (SegmentRenderer)inputs[5];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         stroke . render ( brush , width , position , color , canvas , renderer ) ;
      }

   }

   public static class ColorSizeCircle extends Command {

      public int getNumberInputs() {
         return 7;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "color";
            case 1: return "width";
            case 2: return "brush";
            case 3: return "stroke";
            case 4: return "renderer";
            case 5: return "center";
            case 6: return "radius";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_col.class;
            case 1: return CurveUtil . Curve_d.class;
            case 2: return Brush.class;
            case 3: return Stroke.class;
            case 4: return SegmentRenderer.class;
            case 5: return LVect2d.class;
            case 6: return LDouble.class;
            default: return null;
         }

      }

      public ColorSizeCircle() {
         addGroupMeta(this);
      }

      public void execute(Context context, Object[] inputs) {
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[0];
         final CurveUtil . Curve_d width = (CurveUtil . Curve_d)inputs[1];
         final Brush brush = (Brush)inputs[2];
         final Stroke stroke = (Stroke)inputs[3];
         final SegmentRenderer renderer = (SegmentRenderer)inputs[4];
         final LVect2d center = (LVect2d)inputs[5];
         final LDouble radius = (LDouble)inputs[6];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         stroke . render ( brush , width , new Circle ( center , radius . val ) , color , canvas , renderer ) ;
      }

   }

   public static class ColorSizeCircle2 extends Command {

      private LDouble radius;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return radius;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "radius";
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
            case 0: radius = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 6;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "color";
            case 1: return "width";
            case 2: return "brush";
            case 3: return "stroke";
            case 4: return "renderer";
            case 5: return "center";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_col.class;
            case 1: return CurveUtil . Curve_d.class;
            case 2: return Brush.class;
            case 3: return Stroke.class;
            case 4: return SegmentRenderer.class;
            case 5: return LVect2d.class;
            default: return null;
         }

      }

      public ColorSizeCircle2() {
         addGroupMeta(this);
         radius = new LDouble ( .5 + .5 * Math . random ( ) ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[0];
         final CurveUtil . Curve_d width = (CurveUtil . Curve_d)inputs[1];
         final Brush brush = (Brush)inputs[2];
         final Stroke stroke = (Stroke)inputs[3];
         final SegmentRenderer renderer = (SegmentRenderer)inputs[4];
         final LVect2d center = (LVect2d)inputs[5];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         stroke . render ( brush , width , new Circle ( center , radius . val ) , color , canvas , renderer ) ;
      }

   }

   public static class TwoCurveStroke1 extends Command {

      private int middlePoints;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return middlePoints;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "middlePoints";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return int.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: middlePoints = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 7;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "position1";
            case 1: return "position2";
            case 2: return "color";
            case 3: return "width";
            case 4: return "brush";
            case 5: return "stroke";
            case 6: return "renderer";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_v2.class;
            case 1: return CurveUtil . Curve_v2.class;
            case 2: return CurveUtil . Curve_col.class;
            case 3: return CurveUtil . Curve_d.class;
            case 4: return Brush.class;
            case 5: return Stroke.class;
            case 6: return SegmentRenderer.class;
            default: return null;
         }

      }

      public TwoCurveStroke1() {
         addGroupMeta(this);
         middlePoints = ( int ) ( 20 + 50 * Math . random ( ) ) ;
      }

      public String getDescription() {
         return "draws strokes between two curves";
      }

      public void execute(Context context, Object[] inputs) {
         final CurveUtil . Curve_v2 position1 = (CurveUtil . Curve_v2)inputs[0];
         final CurveUtil . Curve_v2 position2 = (CurveUtil . Curve_v2)inputs[1];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[2];
         final CurveUtil . Curve_d width = (CurveUtil . Curve_d)inputs[3];
         final Brush brush = (Brush)inputs[4];
         final Stroke stroke = (Stroke)inputs[5];
         final SegmentRenderer renderer = (SegmentRenderer)inputs[6];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         for ( int i = 0 ;
         i < middlePoints ;
         i ++ ) {
         double x = ( double ) i / middlePoints ;
         Curve < LVect2d > position = new SegmentCurve ( position1 . getValue ( x ) , position2 . getValue ( x ) ) ;
         stroke . render ( brush , width , position , color , canvas , renderer ) ;
         }
      }

   }

   public static class TwoCurveStroke2 extends Command {

      private int middlePoints;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return middlePoints;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "middlePoints";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return int.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: middlePoints = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 7;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "position1";
            case 1: return "position2";
            case 2: return "color";
            case 3: return "width";
            case 4: return "brush";
            case 5: return "stroke";
            case 6: return "renderer";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_v2.class;
            case 1: return CurveUtil . Curve_v2.class;
            case 2: return CurveUtil . Curve_col.class;
            case 3: return CurveUtil . Curve_d.class;
            case 4: return Brush.class;
            case 5: return Stroke.class;
            case 6: return SegmentRenderer.class;
            default: return null;
         }

      }

      public TwoCurveStroke2() {
         addGroupMeta(this);
         middlePoints = ( int ) ( 20 + 50 * Math . random ( ) ) ;
      }

      public String getDescription() {
         return "draws cuves between two strokes, but reverses them";
      }

      public void execute(Context context, Object[] inputs) {
         final CurveUtil . Curve_v2 position1 = (CurveUtil . Curve_v2)inputs[0];
         final CurveUtil . Curve_v2 position2 = (CurveUtil . Curve_v2)inputs[1];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[2];
         final CurveUtil . Curve_d width = (CurveUtil . Curve_d)inputs[3];
         final Brush brush = (Brush)inputs[4];
         final Stroke stroke = (Stroke)inputs[5];
         final SegmentRenderer renderer = (SegmentRenderer)inputs[6];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         for ( int i = 0 ;
         i < middlePoints ;
         i ++ ) {
         double x = ( double ) i / middlePoints ;
         Curve < LVect2d > position = new SegmentCurve ( position1 . getValue ( x ) , position2 . getValue ( 1 - x ) ) ;
         stroke . render ( brush , width , position , color , canvas , renderer ) ;
         }
      }

   }

   public static class CurveAndPointStroke extends Command {

      private int middlePoints;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return middlePoints;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "middlePoints";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return int.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: middlePoints = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 7;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "position1";
            case 1: return "position2";
            case 2: return "color";
            case 3: return "width";
            case 4: return "brush";
            case 5: return "stroke";
            case 6: return "renderer";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return CurveUtil . Curve_v2.class;
            case 1: return LVect2d.class;
            case 2: return CurveUtil . Curve_col.class;
            case 3: return CurveUtil . Curve_d.class;
            case 4: return Brush.class;
            case 5: return Stroke.class;
            case 6: return SegmentRenderer.class;
            default: return null;
         }

      }

      public CurveAndPointStroke() {
         addGroupMeta(this);
         middlePoints = ( int ) ( 20 + 50 * Math . random ( ) ) ;
      }

      public String getDescription() {
         return "draws strokes between a point and a curve";
      }

      public void execute(Context context, Object[] inputs) {
         final CurveUtil . Curve_v2 position1 = (CurveUtil . Curve_v2)inputs[0];
         final LVect2d position2 = (LVect2d)inputs[1];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[2];
         final CurveUtil . Curve_d width = (CurveUtil . Curve_d)inputs[3];
         final Brush brush = (Brush)inputs[4];
         final Stroke stroke = (Stroke)inputs[5];
         final SegmentRenderer renderer = (SegmentRenderer)inputs[6];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         for ( int i = 0 ;
         i < middlePoints ;
         i ++ ) {
         double x = ( double ) i / middlePoints ;
         Curve < LVect2d > position = new SegmentCurve ( position1 . getValue ( x ) , position2 ) ;
         stroke . render ( brush , width , position , color , canvas , renderer ) ;
         }
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
      r.add(new ColorSizeCircle());
      r.add(new ColorSizeCircle2());
      r.add(new TwoCurveStroke1());
      r.add(new TwoCurveStroke2());
      r.add(new CurveAndPointStroke());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
