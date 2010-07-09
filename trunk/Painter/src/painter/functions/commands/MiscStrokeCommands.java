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

public final class MiscStrokeCommands implements AllComponents<Command>, Described {

   public static class RadialStrokes1 extends Command {

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

      public RadialStrokes1() {
         addGroupMeta(this);
         middlePoints = ( int ) ( 5 + 20 * Math . random ( ) ) ;
      }

      public String getDescription() {
         return "draws several strokes surrounding a point.";
      }

      public void execute(Context context, Object[] inputs) {
         final CurveUtil . Curve_v2 position = (CurveUtil . Curve_v2)inputs[0];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         final CurveUtil . Curve_d width = (CurveUtil . Curve_d)inputs[2];
         final Brush brush = (Brush)inputs[3];
         final Stroke stroke = (Stroke)inputs[4];
         final SegmentRenderer renderer = (SegmentRenderer)inputs[5];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         LVect2d center = position . getValue ( 0 ) ;
         for ( int i = 0 ;
         i < middlePoints ;
         i ++ ) {
         double theta = 2 * Math . PI * ( double ) i / middlePoints ;
         Curve < LVect2d > curve = CurveUtil . add ( CurveUtil . rotate ( CurveUtil . sub ( position , center ) , theta ) , center ) ;
         stroke . render ( brush , width , curve , color , canvas , renderer ) ;
         }
      }

   }

   public static class RadialStrokes2 extends Command {

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

      public RadialStrokes2() {
         addGroupMeta(this);
         middlePoints = ( int ) ( 3 + 10 * Math . random ( ) ) ;
      }

      public String getDescription() {
         return "draws several strokes surrounding a point.";
      }

      public void execute(Context context, Object[] inputs) {
         final CurveUtil . Curve_v2 position = (CurveUtil . Curve_v2)inputs[0];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         final CurveUtil . Curve_d width = (CurveUtil . Curve_d)inputs[2];
         final Brush brush = (Brush)inputs[3];
         final Stroke stroke = (Stroke)inputs[4];
         final SegmentRenderer renderer = (SegmentRenderer)inputs[5];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         LVect2d center = position . getValue ( 0 ) ;
         for ( int i = 0 ;
         i < middlePoints ;
         i ++ ) {
         double theta = 2 * Math . PI * ( double ) i / middlePoints ;
         Curve < LVect2d > curve = CurveUtil . add ( CurveUtil . rotate ( CurveUtil . sub ( position , center ) , theta ) , center ) ;
         stroke . render ( brush , width , curve , color , canvas , renderer ) ;
         }
      }

   }

   public static class RadialSpiral1 extends Command {

      private int middlePoints;private LDouble multTheta;private LDouble multScale;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return middlePoints;
            case 1: return multTheta;
            case 2: return multScale;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "middlePoints";
            case 1: return "multTheta";
            case 2: return "multScale";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return int.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: middlePoints = (Integer) value; return;
            case 1: multTheta = (LDouble) value; return;
            case 2: multScale = (LDouble) value; return;
            default: return;
         }

      }

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

      public RadialSpiral1() {
         addGroupMeta(this);
         middlePoints = ( int ) ( 5 + 20 * Math . random ( ) ) ;
         multTheta = new LDouble ( 1 + 2 * Math . random ( ) ) ;
         multScale = new LDouble ( 1 + 2 * Math . random ( ) ) ;
      }

      public String getDescription() {
         return "draws several strokes surrounding a point.";
      }

      public void execute(Context context, Object[] inputs) {
         final CurveUtil . Curve_v2 position = (CurveUtil . Curve_v2)inputs[0];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         final CurveUtil . Curve_d width = (CurveUtil . Curve_d)inputs[2];
         final Brush brush = (Brush)inputs[3];
         final Stroke stroke = (Stroke)inputs[4];
         final SegmentRenderer renderer = (SegmentRenderer)inputs[5];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         LVect2d center = position . getValue ( 0 ) ;
         for ( int i = 0 ;
         i < middlePoints ;
         i ++ ) {
         double t = ( double ) i / middlePoints ;
         double theta = multTheta . val * 2 * Math . PI * t ;
         double scale = ( t + .1 ) * multScale . val ;
         Curve < LVect2d > curve = CurveUtil . add ( CurveUtil . mult ( CurveUtil . rotate ( CurveUtil . sub ( position , center ) , theta ) , scale ) , center ) ;
         stroke . render ( brush , width , curve , color , canvas , renderer ) ;
         }
      }

   }

   public static class RadialSpiral2 extends Command {

      private int middlePoints;private LDouble multTheta;private LDouble multScale;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return middlePoints;
            case 1: return multTheta;
            case 2: return multScale;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "middlePoints";
            case 1: return "multTheta";
            case 2: return "multScale";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return int.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: middlePoints = (Integer) value; return;
            case 1: multTheta = (LDouble) value; return;
            case 2: multScale = (LDouble) value; return;
            default: return;
         }

      }

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

      public RadialSpiral2() {
         addGroupMeta(this);
         middlePoints = ( int ) ( 5 + 20 * Math . random ( ) ) ;
         multTheta = new LDouble ( 1 + 2 * Math . random ( ) ) ;
         multScale = new LDouble ( 1 + 2 * Math . random ( ) ) ;
      }

      public String getDescription() {
         return "draws several strokes surrounding a point.";
      }

      public void execute(Context context, Object[] inputs) {
         final CurveUtil . Curve_v2 position = (CurveUtil . Curve_v2)inputs[0];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         final CurveUtil . Curve_d width = (CurveUtil . Curve_d)inputs[2];
         final Brush brush = (Brush)inputs[3];
         final Stroke stroke = (Stroke)inputs[4];
         final SegmentRenderer renderer = (SegmentRenderer)inputs[5];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         LVect2d center = position . getValue ( 0 ) ;
         for ( int i = 0 ;
         i < middlePoints ;
         i ++ ) {
         double t = ( double ) i / middlePoints ;
         double theta = multTheta . val * 2 * Math . PI * t ;
         double scale = ( t + .1 ) * multScale . val ;
         Curve < LVect2d > curve = CurveUtil . add ( CurveUtil . mult ( CurveUtil . rotate ( CurveUtil . sub ( position , center ) , theta ) , scale ) , center ) ;
         stroke . render ( brush , CurveUtil . mult ( width , scale ) , curve , color , canvas , renderer ) ;
         }
      }

   }

   public String getDescription() {
      return "Miscellaneous stroke commands";
   }

   public List<Command> allInstances(ContextModel cm) {
      List<Command> r = new ArrayList<Command>();
      r.add(new RadialStrokes1());
      r.add(new RadialStrokes2());
      r.add(new RadialSpiral1());
      r.add(new RadialSpiral2());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
