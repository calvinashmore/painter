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
import utils.linear.grid.*;
import utils.curves.*;
import utils.pointfield.attractor.*;
import utils.ifs.*;
import painter.tools.canvas.*;
import painter.tools.brush.*;

public final class PointPlot implements AllComponents<Command>, Described {

   public static class PlotAttractor1 extends Command {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "attractor";
            case 1: return "brush";
            case 2: return "color";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Attractor2.class;
            case 1: return Brush.class;
            case 2: return Color.class;
            default: return null;
         }

      }

      public PlotAttractor1() {
         addGroupMeta(this);
      }

      public void execute(Context context, Object[] inputs) {
         final Attractor2 attractor = (Attractor2)inputs[0];
         final Brush brush = (Brush)inputs[1];
         final Color color = (Color)inputs[2];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         AttractorResult result = attractor . getResult ( ) ;
         APoint2d minVals = ( APoint2d ) result . getMinVals ( ) ;
         APoint2d maxVals = ( APoint2d ) result . getMaxVals ( ) ;
         double spanx = 1.0 / ( maxVals . x - minVals . x ) ;
         double spany = 1.0 / ( maxVals . y - minVals . y ) ;
         List < APoint2d > points = ( List < APoint2d > ) result . getValues ( ) ;
         for ( APoint2d a : points ) {
         double x = ( a . x - minVals . x ) * spanx ;
         double y = ( a . y - minVals . y ) * spanx ;
         brush . paint ( x , y , 0 , 0 , .02 , color , canvas ) ;
         }
      }

   }

   public static class PlotAttractor2 extends Command {

      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "attractor";
            case 1: return "brush";
            case 2: return "color";
            case 3: return "radius";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Attractor2.class;
            case 1: return Brush.class;
            case 2: return Color.class;
            case 3: return LDouble.class;
            default: return null;
         }

      }

      public PlotAttractor2() {
         addGroupMeta(this);
      }

      public void execute(Context context, Object[] inputs) {
         final Attractor2 attractor = (Attractor2)inputs[0];
         final Brush brush = (Brush)inputs[1];
         final Color color = (Color)inputs[2];
         final LDouble radius = (LDouble)inputs[3];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         AttractorResult result = attractor . getResult ( ) ;
         APoint2d minVals = ( APoint2d ) result . getMinVals ( ) ;
         APoint2d maxVals = ( APoint2d ) result . getMaxVals ( ) ;
         double spanx = 1.0 / ( maxVals . x - minVals . x ) ;
         double spany = 1.0 / ( maxVals . y - minVals . y ) ;
         List < APoint2d > points = ( List < APoint2d > ) result . getValues ( ) ;
         for ( APoint2d a : points ) {
         double x = ( a . x - minVals . x ) * spanx ;
         double y = ( a . y - minVals . y ) * spanx ;
         brush . paint ( x , y , 0 , 0 , radius . val , color , canvas ) ;
         }
      }

   }

   public static class PlotAttractor_curve_col extends Command {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "attractor";
            case 1: return "brush";
            case 2: return "color";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Attractor2.class;
            case 1: return Brush.class;
            case 2: return CurveUtil . Curve_col.class;
            default: return null;
         }

      }

      public PlotAttractor_curve_col() {
         addGroupMeta(this);
      }

      public void execute(Context context, Object[] inputs) {
         final Attractor2 attractor = (Attractor2)inputs[0];
         final Brush brush = (Brush)inputs[1];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[2];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         AttractorResult result = attractor . getResult ( ) ;
         APoint2d minVals = ( APoint2d ) result . getMinVals ( ) ;
         APoint2d maxVals = ( APoint2d ) result . getMaxVals ( ) ;
         double spanx = 1.0 / ( maxVals . x - minVals . x ) ;
         double spany = 1.0 / ( maxVals . y - minVals . y ) ;
         List < APoint2d > points = ( List < APoint2d > ) result . getValues ( ) ;
         for ( int i = 0 ;
         i < points . size ( ) ;
         i ++ ) {
         APoint2d a = points . get ( i ) ;
         double t = ( double ) i / points . size ( ) ;
         double x = ( a . x - minVals . x ) * spanx ;
         double y = ( a . y - minVals . y ) * spanx ;
         brush . paint ( x , y , 0 , 0 , .02 , color . getValue ( t ) , canvas ) ;
         }
      }

   }

   public static class PlotIFS extends Command {

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
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "ifs";
            case 1: return "brush";
            case 2: return "color";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return IFSUtil . IFS_v2.class;
            case 1: return Brush.class;
            case 2: return Color.class;
            default: return null;
         }

      }

      public PlotIFS() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final IFSUtil . IFS_v2 ifs = (IFSUtil . IFS_v2)inputs[0];
         final Brush brush = (Brush)inputs[1];
         final Color color = (Color)inputs[2];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         Random random = new Random ( seed ) ;
         for ( int i = 0 ;
         i < 5000 ;
         i ++ ) {
         LVect2d start = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         LVect2d result = ifs . applyRepeatedly ( start , 20 , random ) ;
         brush . paint ( result . x , result . y , 0 , 0 , .02 , color , canvas ) ;
         }
      }

   }

   public static class PlotIFS_curve_col extends Command {

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
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "ifs";
            case 1: return "brush";
            case 2: return "color";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return IFSUtil . IFS_v2.class;
            case 1: return Brush.class;
            case 2: return CurveUtil . Curve_col.class;
            default: return null;
         }

      }

      public PlotIFS_curve_col() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final IFSUtil . IFS_v2 ifs = (IFSUtil . IFS_v2)inputs[0];
         final Brush brush = (Brush)inputs[1];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[2];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         Random random = new Random ( seed ) ;
         for ( int i = 0 ;
         i < 5000 ;
         i ++ ) {
         double t = ( double ) i / 5000 ;
         LVect2d start = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         LVect2d result = ifs . applyRepeatedly ( start , 20 , random ) ;
         brush . paint ( result . x , result . y , 0 , 0 , .02 , color . getValue ( t ) , canvas ) ;
         }
      }

   }

   public static class PlotBuffer_curve_col extends Command {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "brush";
            case 1: return "color";
            case 2: return "buffer";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Brush.class;
            case 1: return CurveUtil . Curve_col.class;
            case 2: return Buffer_d.class;
            default: return null;
         }

      }

      public PlotBuffer_curve_col() {
         addGroupMeta(this);
      }

      public void execute(Context context, Object[] inputs) {
         final Brush brush = (Brush)inputs[0];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         final Buffer_d buffer = (Buffer_d)inputs[2];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         for ( int ix = 0 ;
         ix < buffer . getXRes ( ) ;
         ix ++ ) for ( int iy = 0 ;
         iy < buffer . getYRes ( ) ;
         iy ++ ) {
         double x = ( double ) ix / buffer . getXRes ( ) ;
         double y = ( double ) iy / buffer . getYRes ( ) ;
         double value = buffer . getValue ( ix , iy ) . val ;
         Color c = color . getValue ( value ) ;
         brush . paint ( x , y , 0 , 0 , .02 , c , canvas ) ;
         }
      }

   }

   public static class PlotBuffer_curve_col2 extends Command {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "brush";
            case 1: return "color";
            case 2: return "buffer";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Brush.class;
            case 1: return CurveUtil . Curve_col.class;
            case 2: return Buffer_d.class;
            default: return null;
         }

      }

      public PlotBuffer_curve_col2() {
         addGroupMeta(this);
      }

      public void execute(Context context, Object[] inputs) {
         final Brush brush = (Brush)inputs[0];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         final Buffer_d buffer = (Buffer_d)inputs[2];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         for ( int ix = 0 ;
         ix < buffer . getXRes ( ) ;
         ix ++ ) for ( int iy = 0 ;
         iy < buffer . getYRes ( ) ;
         iy ++ ) {
         double x = ( double ) ix / buffer . getXRes ( ) ;
         double y = ( double ) iy / buffer . getYRes ( ) ;
         double value = buffer . getValue ( ix , iy ) . val ;
         Color c = color . getValue ( value ) ;
         brush . paint ( x , y , 0 , 0 , .1 * value , c , canvas ) ;
         }
      }

   }

   public static class PlotBuffer_curve_col_size extends Command {

      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "brush";
            case 1: return "color";
            case 2: return "width";
            case 3: return "buffer";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Brush.class;
            case 1: return CurveUtil . Curve_col.class;
            case 2: return CurveUtil . Curve_d.class;
            case 3: return Buffer_d.class;
            default: return null;
         }

      }

      public PlotBuffer_curve_col_size() {
         addGroupMeta(this);
      }

      public void execute(Context context, Object[] inputs) {
         final Brush brush = (Brush)inputs[0];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         final CurveUtil . Curve_d width = (CurveUtil . Curve_d)inputs[2];
         final Buffer_d buffer = (Buffer_d)inputs[3];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         for ( int ix = 0 ;
         ix < buffer . getXRes ( ) ;
         ix ++ ) for ( int iy = 0 ;
         iy < buffer . getYRes ( ) ;
         iy ++ ) {
         double x = ( double ) ix / buffer . getXRes ( ) ;
         double y = ( double ) iy / buffer . getYRes ( ) ;
         double value = buffer . getValue ( ix , iy ) . val ;
         Color c = color . getValue ( value ) ;
         brush . paint ( x , y , 0 , 0 , .5 * width . getValue ( value ) . val , c , canvas ) ;
         }
      }

   }

   public static class PlotBuffer_thresh1_curve_col_size extends Command {

      private LDouble threshold;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return threshold;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "threshold";
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
            case 0: threshold = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "brush";
            case 1: return "color";
            case 2: return "width";
            case 3: return "buffer";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Brush.class;
            case 1: return CurveUtil . Curve_col.class;
            case 2: return CurveUtil . Curve_d.class;
            case 3: return Buffer_d.class;
            default: return null;
         }

      }

      public PlotBuffer_thresh1_curve_col_size() {
         addGroupMeta(this);
         threshold = new LDouble ( .1 + .8 * Math . random ( ) ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final Brush brush = (Brush)inputs[0];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         final CurveUtil . Curve_d width = (CurveUtil . Curve_d)inputs[2];
         final Buffer_d buffer = (Buffer_d)inputs[3];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         for ( int ix = 0 ;
         ix < buffer . getXRes ( ) ;
         ix ++ ) for ( int iy = 0 ;
         iy < buffer . getYRes ( ) ;
         iy ++ ) {
         double x = ( double ) ix / buffer . getXRes ( ) ;
         double y = ( double ) iy / buffer . getYRes ( ) ;
         double value = buffer . getValue ( ix , iy ) . val ;
         if ( value < threshold . val ) continue ;
         value = ( value - threshold . val ) / ( 1 - threshold . val ) ;
         Color c = color . getValue ( value ) ;
         brush . paint ( x , y , 0 , 0 , .5 * width . getValue ( value ) . val , c , canvas ) ;
         }
      }

   }

   public static class PlotBuffer_thresh2_curve_col_size extends Command {

      private LDouble threshold;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return threshold;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "threshold";
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
            case 0: threshold = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "brush";
            case 1: return "color";
            case 2: return "width";
            case 3: return "buffer";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Brush.class;
            case 1: return CurveUtil . Curve_col.class;
            case 2: return CurveUtil . Curve_d.class;
            case 3: return Buffer_d.class;
            default: return null;
         }

      }

      public PlotBuffer_thresh2_curve_col_size() {
         addGroupMeta(this);
         threshold = new LDouble ( .1 + .8 * Math . random ( ) ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final Brush brush = (Brush)inputs[0];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         final CurveUtil . Curve_d width = (CurveUtil . Curve_d)inputs[2];
         final Buffer_d buffer = (Buffer_d)inputs[3];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         for ( int ix = 0 ;
         ix < buffer . getXRes ( ) ;
         ix ++ ) for ( int iy = 0 ;
         iy < buffer . getYRes ( ) ;
         iy ++ ) {
         double x = ( double ) ix / buffer . getXRes ( ) ;
         double y = ( double ) iy / buffer . getYRes ( ) ;
         double value = buffer . getValue ( ix , iy ) . val ;
         if ( value > threshold . val ) continue ;
         value = ( value ) / ( threshold . val ) ;
         Color c = color . getValue ( value ) ;
         brush . paint ( x , y , 0 , 0 , .5 * width . getValue ( value ) . val , c , canvas ) ;
         }
      }

   }

   public String getDescription() {
      return "Plots out points";
   }

   public List<Command> allInstances(ContextModel cm) {
      List<Command> r = new ArrayList<Command>();
      r.add(new PlotAttractor1());
      r.add(new PlotAttractor2());
      r.add(new PlotAttractor_curve_col());
      r.add(new PlotIFS());
      r.add(new PlotIFS_curve_col());
      r.add(new PlotBuffer_curve_col());
      r.add(new PlotBuffer_curve_col2());
      r.add(new PlotBuffer_curve_col_size());
      r.add(new PlotBuffer_thresh1_curve_col_size());
      r.add(new PlotBuffer_thresh2_curve_col_size());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
