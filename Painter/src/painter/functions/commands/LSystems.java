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
import painter.tools.lsystem.*;
import painter.tools.canvas.*;
import painter.tools.brush.*;
import painter.tools.stroke.*;

public final class LSystems implements AllComponents<Command>, Described {

   public static class RenderLSystem1 extends Command {

      private LDouble width;private LDouble initialTheta;private LDouble scale;private LVect2d initialPosition;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return width;
            case 1: return initialTheta;
            case 2: return scale;
            case 3: return initialPosition;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "width";
            case 1: return "initialTheta";
            case 2: return "scale";
            case 3: return "initialPosition";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LVect2d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: width = (LDouble) value; return;
            case 1: initialTheta = (LDouble) value; return;
            case 2: scale = (LDouble) value; return;
            case 3: initialPosition = (LVect2d) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 5;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "string";
            case 1: return "color";
            case 2: return "brush";
            case 3: return "stroke";
            case 4: return "renderer";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LSystemString.class;
            case 1: return Color.class;
            case 2: return Brush.class;
            case 3: return Stroke.class;
            case 4: return SegmentRenderer.class;
            default: return null;
         }

      }

      public RenderLSystem1() {
         addGroupMeta(this);
         addMeta("selectionWeight", 100);
         width = new LDouble ( Math . random ( ) * .1 ) ;
         initialTheta = new LDouble ( Math . random ( ) * Math . PI * 2 ) ;
         initialPosition = new LVect2d ( Math . random ( ) , Math . random ( ) ) ;
         scale = new LDouble ( 1 + Math . random ( ) ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final LSystemString string = (LSystemString)inputs[0];
         final Color color = (Color)inputs[1];
         final Brush brush = (Brush)inputs[2];
         final Stroke stroke = (Stroke)inputs[3];
         final SegmentRenderer renderer = (SegmentRenderer)inputs[4];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         LSystemRenderer lRenderer = new LSystemRenderer ( ) ;
         lRenderer . setRotateSize ( string . getAngle ( ) ) ;
         lRenderer . setInitialCoordinates ( initialPosition . x , initialPosition . y , initialTheta . val ) ;
         lRenderer . setScale ( scale . val ) ;
         List < CurveUtil . Curve_v2 > curves = lRenderer . process ( string . getString ( ) ) ;
         for ( CurveUtil . Curve_v2 position : curves ) {
         stroke . setSteps ( 100 ) ;
         stroke . render ( brush , new ConstantCurve < LDouble > ( width ) , position , new ConstantCurve < Color > ( color ) , canvas , renderer ) ;
         }
      }

   }

   public static class RenderLSystem2 extends Command {

      private LDouble width;private LDouble initialTheta;private LDouble scale;private LVect2d initialPosition;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return width;
            case 1: return initialTheta;
            case 2: return scale;
            case 3: return initialPosition;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "width";
            case 1: return "initialTheta";
            case 2: return "scale";
            case 3: return "initialPosition";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LVect2d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: width = (LDouble) value; return;
            case 1: initialTheta = (LDouble) value; return;
            case 2: scale = (LDouble) value; return;
            case 3: initialPosition = (LVect2d) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 5;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "string";
            case 1: return "color";
            case 2: return "brush";
            case 3: return "stroke";
            case 4: return "renderer";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LSystemString.class;
            case 1: return CurveUtil . Curve_col.class;
            case 2: return Brush.class;
            case 3: return Stroke.class;
            case 4: return SegmentRenderer.class;
            default: return null;
         }

      }

      public RenderLSystem2() {
         addGroupMeta(this);
         addMeta("selectionWeight", 5);
         width = new LDouble ( Math . random ( ) * .1 ) ;
         initialTheta = new LDouble ( Math . random ( ) * Math . PI * 2 ) ;
         initialPosition = new LVect2d ( Math . random ( ) , Math . random ( ) ) ;
         scale = new LDouble ( 1 + Math . random ( ) ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final LSystemString string = (LSystemString)inputs[0];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         final Brush brush = (Brush)inputs[2];
         final Stroke stroke = (Stroke)inputs[3];
         final SegmentRenderer renderer = (SegmentRenderer)inputs[4];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         LSystemRenderer lRenderer = new LSystemRenderer ( ) ;
         lRenderer . setRotateSize ( string . getAngle ( ) ) ;
         lRenderer . setInitialCoordinates ( initialPosition . x , initialPosition . y , initialTheta . val ) ;
         lRenderer . setScale ( scale . val ) ;
         List < CurveUtil . Curve_v2 > curves = lRenderer . process ( string . getString ( ) ) ;
         for ( CurveUtil . Curve_v2 position : curves ) {
         stroke . setSteps ( 100 ) ;
         stroke . render ( brush , new ConstantCurve < LDouble > ( width ) , position , color , canvas , renderer ) ;
         }
      }

   }

   public static class RenderLSystem3 extends Command {

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
         return 6;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "string";
            case 1: return "color";
            case 2: return "brush";
            case 3: return "stroke";
            case 4: return "renderer";
            case 5: return "width";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LSystemString.class;
            case 1: return CurveUtil . Curve_col.class;
            case 2: return Brush.class;
            case 3: return Stroke.class;
            case 4: return SegmentRenderer.class;
            case 5: return CurveUtil . Curve_d.class;
            default: return null;
         }

      }

      public RenderLSystem3() {
         addGroupMeta(this);
         addMeta("selectionWeight", 5);
         initialTheta = new LDouble ( Math . random ( ) * Math . PI * 2 ) ;
         initialPosition = new LVect2d ( Math . random ( ) , Math . random ( ) ) ;
         scale = new LDouble ( 1 + Math . random ( ) ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final LSystemString string = (LSystemString)inputs[0];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         final Brush brush = (Brush)inputs[2];
         final Stroke stroke = (Stroke)inputs[3];
         final SegmentRenderer renderer = (SegmentRenderer)inputs[4];
         final CurveUtil . Curve_d width = (CurveUtil . Curve_d)inputs[5];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         LSystemRenderer lRenderer = new LSystemRenderer ( ) ;
         lRenderer . setRotateSize ( string . getAngle ( ) ) ;
         lRenderer . setInitialCoordinates ( initialPosition . x , initialPosition . y , initialTheta . val ) ;
         lRenderer . setScale ( scale . val ) ;
         List < CurveUtil . Curve_v2 > curves = lRenderer . process ( string . getString ( ) ) ;
         for ( CurveUtil . Curve_v2 position : curves ) {
         stroke . setSteps ( 100 ) ;
         stroke . render ( brush , width , position , color , canvas , renderer ) ;
         }
      }

   }

   public static class RenderLSystem4 extends Command {

      private LDouble width;private LDouble initialTheta;private LDouble scale;private LVect2d initialPosition;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return width;
            case 1: return initialTheta;
            case 2: return scale;
            case 3: return initialPosition;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "width";
            case 1: return "initialTheta";
            case 2: return "scale";
            case 3: return "initialPosition";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LVect2d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: width = (LDouble) value; return;
            case 1: initialTheta = (LDouble) value; return;
            case 2: scale = (LDouble) value; return;
            case 3: initialPosition = (LVect2d) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 5;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "string";
            case 1: return "color";
            case 2: return "brush";
            case 3: return "stroke";
            case 4: return "renderer";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LSystemString.class;
            case 1: return CurveUtil . Curve_col.class;
            case 2: return Brush.class;
            case 3: return Stroke.class;
            case 4: return SegmentRenderer.class;
            default: return null;
         }

      }

      public RenderLSystem4() {
         addGroupMeta(this);
         addMeta("selectionWeight", 5);
         width = new LDouble ( Math . random ( ) * .1 ) ;
         initialTheta = new LDouble ( Math . random ( ) * Math . PI * 2 ) ;
         initialPosition = new LVect2d ( Math . random ( ) , Math . random ( ) ) ;
         scale = new LDouble ( 1 + Math . random ( ) ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final LSystemString string = (LSystemString)inputs[0];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         final Brush brush = (Brush)inputs[2];
         final Stroke stroke = (Stroke)inputs[3];
         final SegmentRenderer renderer = (SegmentRenderer)inputs[4];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         LSystemRenderer lRenderer = new LSystemRenderer ( ) ;
         lRenderer . setRotateSize ( string . getAngle ( ) ) ;
         lRenderer . setInitialCoordinates ( initialPosition . x , initialPosition . y , initialTheta . val ) ;
         lRenderer . setScale ( scale . val ) ;
         List < CurveUtil . Curve_v2 > curves = lRenderer . process ( string . getString ( ) ) ;
         double span = 1.0 / curves . size ( ) ;
         for ( int i = 0 ;
         i < curves . size ( ) ;
         i ++ ) {
         CurveUtil . Curve_v2 position = curves . get ( i ) ;
         double t = i * span ;
         Curve < Color > colorSegment = CurveUtil . subCurve ( color , t , span ) ;
         stroke . setSteps ( 100 ) ;
         stroke . render ( brush , new ConstantCurve < LDouble > ( width ) , position , colorSegment , canvas , renderer ) ;
         }
      }

   }

   public static class RenderLSystem5 extends Command {

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
         return 6;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "string";
            case 1: return "color";
            case 2: return "brush";
            case 3: return "stroke";
            case 4: return "renderer";
            case 5: return "width";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LSystemString.class;
            case 1: return CurveUtil . Curve_col.class;
            case 2: return Brush.class;
            case 3: return Stroke.class;
            case 4: return SegmentRenderer.class;
            case 5: return CurveUtil . Curve_d.class;
            default: return null;
         }

      }

      public RenderLSystem5() {
         addGroupMeta(this);
         addMeta("selectionWeight", 5);
         initialTheta = new LDouble ( Math . random ( ) * Math . PI * 2 ) ;
         initialPosition = new LVect2d ( Math . random ( ) , Math . random ( ) ) ;
         scale = new LDouble ( 1 + Math . random ( ) ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final LSystemString string = (LSystemString)inputs[0];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         final Brush brush = (Brush)inputs[2];
         final Stroke stroke = (Stroke)inputs[3];
         final SegmentRenderer renderer = (SegmentRenderer)inputs[4];
         final CurveUtil . Curve_d width = (CurveUtil . Curve_d)inputs[5];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         LSystemRenderer lRenderer = new LSystemRenderer ( ) ;
         lRenderer . setRotateSize ( string . getAngle ( ) ) ;
         lRenderer . setInitialCoordinates ( initialPosition . x , initialPosition . y , initialTheta . val ) ;
         lRenderer . setScale ( scale . val ) ;
         List < CurveUtil . Curve_v2 > curves = lRenderer . process ( string . getString ( ) ) ;
         double span = 1.0 / curves . size ( ) ;
         for ( int i = 0 ;
         i < curves . size ( ) ;
         i ++ ) {
         CurveUtil . Curve_v2 position = curves . get ( i ) ;
         double t = i * span ;
         Curve < Color > colorSegment = CurveUtil . subCurve ( color , t , span ) ;
         Curve < LDouble > widthSegment = CurveUtil . subCurve ( width , t , span ) ;
         stroke . setSteps ( 100 ) ;
         stroke . render ( brush , widthSegment , position , colorSegment , canvas , renderer ) ;
         }
      }

   }

   public String getDescription() {
      return "LSystem commands";
   }

   public List<Command> allInstances(ContextModel cm) {
      List<Command> r = new ArrayList<Command>();
      r.add(new RenderLSystem1());
      r.add(new RenderLSystem2());
      r.add(new RenderLSystem3());
      r.add(new RenderLSystem4());
      r.add(new RenderLSystem5());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
