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

   public static class PlotAttractor3_curve_col extends Command {

      public int getNumberInputs() {
         return 5;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "attractor";
            case 1: return "brush";
            case 2: return "color";
            case 3: return "xDot";
            case 4: return "yDot";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Attractor3.class;
            case 1: return Brush.class;
            case 2: return CurveUtil . Curve_col.class;
            case 3: return LVect3d.class;
            case 4: return LVect3d.class;
            default: return null;
         }

      }

      public PlotAttractor3_curve_col() {
         addGroupMeta(this);
      }

      public void execute(Context context, Object[] inputs) {
         final Attractor3 attractor = (Attractor3)inputs[0];
         final Brush brush = (Brush)inputs[1];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[2];
         final LVect3d xDot = (LVect3d)inputs[3];
         final LVect3d yDot = (LVect3d)inputs[4];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         AttractorResult result = attractor . getResult ( ) ;
         APoint3d minVals = ( APoint3d ) result . getMinVals ( ) ;
         APoint3d maxVals = ( APoint3d ) result . getMaxVals ( ) ;
         double maxx = Math . abs ( xDot . x ) * maxVals . x + Math . abs ( xDot . y ) * maxVals . y + Math . abs ( xDot . z ) * maxVals . z ;
         double minx = Math . abs ( xDot . x ) * minVals . x + Math . abs ( xDot . y ) * minVals . y + Math . abs ( xDot . z ) * minVals . z ;
         double maxy = Math . abs ( yDot . x ) * maxVals . x + Math . abs ( yDot . y ) * maxVals . y + Math . abs ( yDot . z ) * maxVals . z ;
         double miny = Math . abs ( yDot . x ) * minVals . x + Math . abs ( yDot . y ) * minVals . y + Math . abs ( yDot . z ) * minVals . z ;
         double spanx = 1.0 / ( maxx - minx ) ;
         double spany = 1.0 / ( maxy - miny ) ;
         List < APoint3d > points = ( List < APoint3d > ) result . getValues ( ) ;
         for ( int i = 0 ;
         i < points . size ( ) ;
         i ++ ) {
         APoint3d a = points . get ( i ) ;
         double t = ( double ) i / points . size ( ) ;
         double ax = xDot . x * a . x + xDot . y * a . y + xDot . z * a . z ;
         double ay = yDot . x * a . x + yDot . y * a . y + yDot . z * a . z ;
         double x = ( ax - minx ) * spanx ;
         double y = ( ay - miny ) * spany ;
         brush . paint ( x , y , 0 , 0 , .02 , color . getValue ( t ) , canvas ) ;
         }
      }

   }

   public static class PlotAttractor3a_curve_col extends Command {

      private LVect3d xDot;private LVect3d yDot;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return xDot;
            case 1: return yDot;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "xDot";
            case 1: return "yDot";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: xDot = (LVect3d) value; return;
            case 1: yDot = (LVect3d) value; return;
            default: return;
         }

      }

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
            case 0: return Attractor3.class;
            case 1: return Brush.class;
            case 2: return CurveUtil . Curve_col.class;
            default: return null;
         }

      }

      public PlotAttractor3a_curve_col() {
         addGroupMeta(this);
         xDot = new LVect3d ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         yDot = new LVect3d ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         yDot = yDot . sub ( xDot . mult ( xDot . dot ( yDot ) ) ) ;
         xDot . normalv ( ) ;
         yDot . normalv ( ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final Attractor3 attractor = (Attractor3)inputs[0];
         final Brush brush = (Brush)inputs[1];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[2];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         AttractorResult result = attractor . getResult ( ) ;
         APoint3d minVals = ( APoint3d ) result . getMinVals ( ) ;
         APoint3d maxVals = ( APoint3d ) result . getMaxVals ( ) ;
         double maxx = Math . abs ( xDot . x ) * maxVals . x + Math . abs ( xDot . y ) * maxVals . y + Math . abs ( xDot . z ) * maxVals . z ;
         double minx = Math . abs ( xDot . x ) * minVals . x + Math . abs ( xDot . y ) * minVals . y + Math . abs ( xDot . z ) * minVals . z ;
         double maxy = Math . abs ( yDot . x ) * maxVals . x + Math . abs ( yDot . y ) * maxVals . y + Math . abs ( yDot . z ) * maxVals . z ;
         double miny = Math . abs ( yDot . x ) * minVals . x + Math . abs ( yDot . y ) * minVals . y + Math . abs ( yDot . z ) * minVals . z ;
         double spanx = 1.0 / ( maxx - minx ) ;
         double spany = 1.0 / ( maxy - miny ) ;
         List < APoint3d > points = ( List < APoint3d > ) result . getValues ( ) ;
         for ( int i = 0 ;
         i < points . size ( ) ;
         i ++ ) {
         APoint3d a = points . get ( i ) ;
         double t = ( double ) i / points . size ( ) ;
         double ax = xDot . x * a . x + xDot . y * a . y + xDot . z * a . z ;
         double ay = yDot . x * a . x + yDot . y * a . y + yDot . z * a . z ;
         double x = ( ax - minx ) * spanx ;
         double y = ( ay - miny ) * spany ;
         brush . paint ( x , y , 0 , 0 , .02 , color . getValue ( t ) , canvas ) ;
         }
      }

   }

   public static class PlotAttractor3a_dotcol_curve_col extends Command {

      private LVect3d xDot;private LVect3d yDot;private LVect3d zDot;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return xDot;
            case 1: return yDot;
            case 2: return zDot;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "xDot";
            case 1: return "yDot";
            case 2: return "zDot";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: xDot = (LVect3d) value; return;
            case 1: yDot = (LVect3d) value; return;
            case 2: zDot = (LVect3d) value; return;
            default: return;
         }

      }

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
            case 0: return Attractor3.class;
            case 1: return Brush.class;
            case 2: return CurveUtil . Curve_col.class;
            default: return null;
         }

      }

      public PlotAttractor3a_dotcol_curve_col() {
         addGroupMeta(this);
         xDot = new LVect3d ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         yDot = new LVect3d ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         zDot = new LVect3d ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         yDot = yDot . sub ( xDot . mult ( xDot . dot ( yDot ) ) ) ;
         zDot = zDot . sub ( xDot . mult ( xDot . dot ( zDot ) ) ) ;
         zDot = zDot . sub ( yDot . mult ( yDot . dot ( zDot ) ) ) ;
         xDot . normalv ( ) ;
         yDot . normalv ( ) ;
         zDot . normalv ( ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final Attractor3 attractor = (Attractor3)inputs[0];
         final Brush brush = (Brush)inputs[1];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[2];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         AttractorResult result = attractor . getResult ( ) ;
         APoint3d minVals = ( APoint3d ) result . getMinVals ( ) ;
         APoint3d maxVals = ( APoint3d ) result . getMaxVals ( ) ;
         double maxx = Math . abs ( xDot . x ) * maxVals . x + Math . abs ( xDot . y ) * maxVals . y + Math . abs ( xDot . z ) * maxVals . z ;
         double minx = Math . abs ( xDot . x ) * minVals . x + Math . abs ( xDot . y ) * minVals . y + Math . abs ( xDot . z ) * minVals . z ;
         double maxy = Math . abs ( yDot . x ) * maxVals . x + Math . abs ( yDot . y ) * maxVals . y + Math . abs ( yDot . z ) * maxVals . z ;
         double miny = Math . abs ( yDot . x ) * minVals . x + Math . abs ( yDot . y ) * minVals . y + Math . abs ( yDot . z ) * minVals . z ;
         double spanx = 1.0 / ( maxx - minx ) ;
         double spany = 1.0 / ( maxy - miny ) ;
         List < APoint3d > points = ( List < APoint3d > ) result . getValues ( ) ;
         for ( int i = 0 ;
         i < points . size ( ) ;
         i ++ ) {
         APoint3d a = points . get ( i ) ;
         double ax = xDot . x * a . x + xDot . y * a . y + xDot . z * a . z ;
         double ay = yDot . x * a . x + yDot . y * a . y + yDot . z * a . z ;
         double x = ( ax - minx ) * spanx ;
         double y = ( ay - miny ) * spany ;
         double t = zDot . x * a . x + zDot . y * a . y + zDot . z * a . z ;
         brush . paint ( x , y , 0 , 0 , .02 , color . getValue ( t ) , canvas ) ;
         }
      }

   }

   public static class PlotAttractor3b_curve_col extends Command {

      private LVect3d xDot;private LVect3d yDot;private LVect3d zDot;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return xDot;
            case 1: return yDot;
            case 2: return zDot;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "xDot";
            case 1: return "yDot";
            case 2: return "zDot";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: xDot = (LVect3d) value; return;
            case 1: yDot = (LVect3d) value; return;
            case 2: zDot = (LVect3d) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "attractor";
            case 1: return "brush";
            case 2: return "color";
            case 3: return "width";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Attractor3.class;
            case 1: return Brush.class;
            case 2: return CurveUtil . Curve_col.class;
            case 3: return CurveUtil . Curve_d.class;
            default: return null;
         }

      }

      public PlotAttractor3b_curve_col() {
         addGroupMeta(this);
         xDot = new LVect3d ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         yDot = new LVect3d ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         zDot = new LVect3d ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         yDot = yDot . sub ( xDot . mult ( xDot . dot ( yDot ) ) ) ;
         zDot = zDot . sub ( xDot . mult ( xDot . dot ( zDot ) ) ) ;
         zDot = zDot . sub ( yDot . mult ( yDot . dot ( zDot ) ) ) ;
         xDot . normalv ( ) ;
         yDot . normalv ( ) ;
         zDot . normalv ( ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final Attractor3 attractor = (Attractor3)inputs[0];
         final Brush brush = (Brush)inputs[1];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[2];
         final CurveUtil . Curve_d width = (CurveUtil . Curve_d)inputs[3];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         AttractorResult result = attractor . getResult ( ) ;
         APoint3d minVals = ( APoint3d ) result . getMinVals ( ) ;
         APoint3d maxVals = ( APoint3d ) result . getMaxVals ( ) ;
         double maxx = Math . abs ( xDot . x ) * maxVals . x + Math . abs ( xDot . y ) * maxVals . y + Math . abs ( xDot . z ) * maxVals . z ;
         double minx = Math . abs ( xDot . x ) * minVals . x + Math . abs ( xDot . y ) * minVals . y + Math . abs ( xDot . z ) * minVals . z ;
         double maxy = Math . abs ( yDot . x ) * maxVals . x + Math . abs ( yDot . y ) * maxVals . y + Math . abs ( yDot . z ) * maxVals . z ;
         double miny = Math . abs ( yDot . x ) * minVals . x + Math . abs ( yDot . y ) * minVals . y + Math . abs ( yDot . z ) * minVals . z ;
         double spanx = 1.0 / ( maxx - minx ) ;
         double spany = 1.0 / ( maxy - miny ) ;
         List < APoint3d > points = ( List < APoint3d > ) result . getValues ( ) ;
         for ( int i = 0 ;
         i < points . size ( ) ;
         i ++ ) {
         APoint3d a = points . get ( i ) ;
         double ax = xDot . x * a . x + xDot . y * a . y + xDot . z * a . z ;
         double ay = yDot . x * a . x + yDot . y * a . y + yDot . z * a . z ;
         double x = ( ax - minx ) * spanx ;
         double y = ( ay - miny ) * spany ;
         double t = zDot . x * a . x + zDot . y * a . y + zDot . z * a . z ;
         brush . paint ( x , y , 0 , 0 , .02 * width . getValue ( t ) . val , color . getValue ( t ) , canvas ) ;
         }
      }

   }

   public static class PlotAttractor4_curve_col extends Command {

      public int getNumberInputs() {
         return 5;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "attractor";
            case 1: return "brush";
            case 2: return "color";
            case 3: return "xDot";
            case 4: return "yDot";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Attractor4.class;
            case 1: return Brush.class;
            case 2: return CurveUtil . Curve_col.class;
            case 3: return Quaternion.class;
            case 4: return Quaternion.class;
            default: return null;
         }

      }

      public PlotAttractor4_curve_col() {
         addGroupMeta(this);
      }

      public void execute(Context context, Object[] inputs) {
         final Attractor4 attractor = (Attractor4)inputs[0];
         final Brush brush = (Brush)inputs[1];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[2];
         final Quaternion xDot = (Quaternion)inputs[3];
         final Quaternion yDot = (Quaternion)inputs[4];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         AttractorResult result = attractor . getResult ( ) ;
         APoint4d minVals = ( APoint4d ) result . getMinVals ( ) ;
         APoint4d maxVals = ( APoint4d ) result . getMaxVals ( ) ;
         double maxx = Math . abs ( xDot . u ) * maxVals . w + Math . abs ( xDot . i ) * maxVals . x + Math . abs ( xDot . j ) * maxVals . y + Math . abs ( xDot . k ) * maxVals . z ;
         double minx = Math . abs ( xDot . u ) * minVals . w + Math . abs ( xDot . i ) * minVals . x + Math . abs ( xDot . j ) * minVals . y + Math . abs ( xDot . k ) * minVals . z ;
         double maxy = Math . abs ( yDot . u ) * maxVals . w + Math . abs ( yDot . i ) * maxVals . x + Math . abs ( yDot . j ) * maxVals . y + Math . abs ( yDot . k ) * maxVals . z ;
         double miny = Math . abs ( yDot . u ) * minVals . w + Math . abs ( yDot . i ) * minVals . x + Math . abs ( yDot . j ) * minVals . y + Math . abs ( yDot . k ) * minVals . z ;
         double spanx = 1.0 / ( maxx - minx ) ;
         double spany = 1.0 / ( maxy - miny ) ;
         List < APoint4d > points = ( List < APoint4d > ) result . getValues ( ) ;
         for ( int i = 0 ;
         i < points . size ( ) ;
         i ++ ) {
         APoint4d a = points . get ( i ) ;
         double t = ( double ) i / points . size ( ) ;
         double ax = xDot . u * a . w + xDot . i * a . x + xDot . j * a . y + xDot . k * a . z ;
         double ay = yDot . u * a . w + yDot . i * a . x + yDot . j * a . y + yDot . k * a . z ;
         double x = ( ax - minx ) * spanx ;
         double y = ( ay - miny ) * spany ;
         brush . paint ( x , y , 0 , 0 , .02 , color . getValue ( t ) , canvas ) ;
         }
      }

   }

   public static class PlotAttractor4a_curve_col extends Command {

      private Quaternion xDot;private Quaternion yDot;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return xDot;
            case 1: return yDot;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "xDot";
            case 1: return "yDot";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            case 1: return Quaternion.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: xDot = (Quaternion) value; return;
            case 1: yDot = (Quaternion) value; return;
            default: return;
         }

      }

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
            case 0: return Attractor4.class;
            case 1: return Brush.class;
            case 2: return CurveUtil . Curve_col.class;
            default: return null;
         }

      }

      public PlotAttractor4a_curve_col() {
         addGroupMeta(this);
         xDot = new Quaternion ( Math . random ( ) , Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         yDot = new Quaternion ( Math . random ( ) , Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         yDot = yDot . sub ( xDot . mult ( xDot . dot ( yDot ) ) ) ;
         xDot . normalv ( ) ;
         yDot . normalv ( ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final Attractor4 attractor = (Attractor4)inputs[0];
         final Brush brush = (Brush)inputs[1];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[2];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         AttractorResult result = attractor . getResult ( ) ;
         APoint4d minVals = ( APoint4d ) result . getMinVals ( ) ;
         APoint4d maxVals = ( APoint4d ) result . getMaxVals ( ) ;
         double maxx = Math . abs ( xDot . u ) * maxVals . w + Math . abs ( xDot . i ) * maxVals . x + Math . abs ( xDot . j ) * maxVals . y + Math . abs ( xDot . k ) * maxVals . z ;
         double minx = Math . abs ( xDot . u ) * minVals . w + Math . abs ( xDot . i ) * minVals . x + Math . abs ( xDot . j ) * minVals . y + Math . abs ( xDot . k ) * minVals . z ;
         double maxy = Math . abs ( yDot . u ) * maxVals . w + Math . abs ( yDot . i ) * maxVals . x + Math . abs ( yDot . j ) * maxVals . y + Math . abs ( yDot . k ) * maxVals . z ;
         double miny = Math . abs ( yDot . u ) * minVals . w + Math . abs ( yDot . i ) * minVals . x + Math . abs ( yDot . j ) * minVals . y + Math . abs ( yDot . k ) * minVals . z ;
         double spanx = 1.0 / ( maxx - minx ) ;
         double spany = 1.0 / ( maxy - miny ) ;
         List < APoint4d > points = ( List < APoint4d > ) result . getValues ( ) ;
         for ( int i = 0 ;
         i < points . size ( ) ;
         i ++ ) {
         APoint4d a = points . get ( i ) ;
         double t = ( double ) i / points . size ( ) ;
         double ax = xDot . u * a . w + xDot . i * a . x + xDot . j * a . y + xDot . k * a . z ;
         double ay = yDot . u * a . w + yDot . i * a . x + yDot . j * a . y + yDot . k * a . z ;
         double x = ( ax - minx ) * spanx ;
         double y = ( ay - miny ) * spany ;
         brush . paint ( x , y , 0 , 0 , .02 , color . getValue ( t ) , canvas ) ;
         }
      }

   }

   public static class PlotAttractor4a_dotcol_curve_col extends Command {

      private Quaternion xDot;private Quaternion yDot;private Quaternion zDot;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return xDot;
            case 1: return yDot;
            case 2: return zDot;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "xDot";
            case 1: return "yDot";
            case 2: return "zDot";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            case 1: return Quaternion.class;
            case 2: return Quaternion.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: xDot = (Quaternion) value; return;
            case 1: yDot = (Quaternion) value; return;
            case 2: zDot = (Quaternion) value; return;
            default: return;
         }

      }

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
            case 0: return Attractor4.class;
            case 1: return Brush.class;
            case 2: return CurveUtil . Curve_col.class;
            default: return null;
         }

      }

      public PlotAttractor4a_dotcol_curve_col() {
         addGroupMeta(this);
         xDot = new Quaternion ( Math . random ( ) , Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         yDot = new Quaternion ( Math . random ( ) , Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         zDot = new Quaternion ( Math . random ( ) , Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         yDot = yDot . sub ( xDot . mult ( xDot . dot ( yDot ) ) ) ;
         zDot = zDot . sub ( xDot . mult ( xDot . dot ( zDot ) ) ) ;
         zDot = zDot . sub ( yDot . mult ( yDot . dot ( zDot ) ) ) ;
         xDot . normalv ( ) ;
         yDot . normalv ( ) ;
         zDot . normalv ( ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final Attractor4 attractor = (Attractor4)inputs[0];
         final Brush brush = (Brush)inputs[1];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[2];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         AttractorResult result = attractor . getResult ( ) ;
         APoint4d minVals = ( APoint4d ) result . getMinVals ( ) ;
         APoint4d maxVals = ( APoint4d ) result . getMaxVals ( ) ;
         double maxx = Math . abs ( xDot . u ) * maxVals . w + Math . abs ( xDot . i ) * maxVals . x + Math . abs ( xDot . j ) * maxVals . y + Math . abs ( xDot . k ) * maxVals . z ;
         double minx = Math . abs ( xDot . u ) * minVals . w + Math . abs ( xDot . i ) * minVals . x + Math . abs ( xDot . j ) * minVals . y + Math . abs ( xDot . k ) * minVals . z ;
         double maxy = Math . abs ( yDot . u ) * maxVals . w + Math . abs ( yDot . i ) * maxVals . x + Math . abs ( yDot . j ) * maxVals . y + Math . abs ( yDot . k ) * maxVals . z ;
         double miny = Math . abs ( yDot . u ) * minVals . w + Math . abs ( yDot . i ) * minVals . x + Math . abs ( yDot . j ) * minVals . y + Math . abs ( yDot . k ) * minVals . z ;
         double spanx = 1.0 / ( maxx - minx ) ;
         double spany = 1.0 / ( maxy - miny ) ;
         List < APoint4d > points = ( List < APoint4d > ) result . getValues ( ) ;
         for ( int i = 0 ;
         i < points . size ( ) ;
         i ++ ) {
         APoint4d a = points . get ( i ) ;
         double t = zDot . u * a . w + zDot . i * a . x + zDot . j * a . y + zDot . k * a . z ;
         double ax = xDot . u * a . w + xDot . i * a . x + xDot . j * a . y + xDot . k * a . z ;
         double ay = yDot . u * a . w + yDot . i * a . x + yDot . j * a . y + yDot . k * a . z ;
         double x = ( ax - minx ) * spanx ;
         double y = ( ay - miny ) * spany ;
         brush . paint ( x , y , 0 , 0 , .02 , color . getValue ( t ) , canvas ) ;
         }
      }

   }

   public static class PlotAttractor4b_curve_col extends Command {

      private Quaternion xDot;private Quaternion yDot;private Quaternion zDot;private Quaternion wDot;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return xDot;
            case 1: return yDot;
            case 2: return zDot;
            case 3: return wDot;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "xDot";
            case 1: return "yDot";
            case 2: return "zDot";
            case 3: return "wDot";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            case 1: return Quaternion.class;
            case 2: return Quaternion.class;
            case 3: return Quaternion.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: xDot = (Quaternion) value; return;
            case 1: yDot = (Quaternion) value; return;
            case 2: zDot = (Quaternion) value; return;
            case 3: wDot = (Quaternion) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "attractor";
            case 1: return "brush";
            case 2: return "color";
            case 3: return "width";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Attractor4.class;
            case 1: return Brush.class;
            case 2: return CurveUtil . Curve_col.class;
            case 3: return CurveUtil . Curve_d.class;
            default: return null;
         }

      }

      public PlotAttractor4b_curve_col() {
         addGroupMeta(this);
         xDot = new Quaternion ( Math . random ( ) , Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         yDot = new Quaternion ( Math . random ( ) , Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         zDot = new Quaternion ( Math . random ( ) , Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         wDot = new Quaternion ( Math . random ( ) , Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         yDot = yDot . sub ( xDot . mult ( xDot . dot ( yDot ) ) ) ;
         zDot = zDot . sub ( xDot . mult ( xDot . dot ( zDot ) ) ) ;
         zDot = zDot . sub ( yDot . mult ( yDot . dot ( zDot ) ) ) ;
         wDot = wDot . sub ( xDot . mult ( xDot . dot ( wDot ) ) ) ;
         wDot = wDot . sub ( yDot . mult ( yDot . dot ( wDot ) ) ) ;
         wDot = wDot . sub ( zDot . mult ( zDot . dot ( wDot ) ) ) ;
         xDot . normalv ( ) ;
         yDot . normalv ( ) ;
         zDot . normalv ( ) ;
         wDot . normalv ( ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final Attractor4 attractor = (Attractor4)inputs[0];
         final Brush brush = (Brush)inputs[1];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[2];
         final CurveUtil . Curve_d width = (CurveUtil . Curve_d)inputs[3];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         AttractorResult result = attractor . getResult ( ) ;
         APoint4d minVals = ( APoint4d ) result . getMinVals ( ) ;
         APoint4d maxVals = ( APoint4d ) result . getMaxVals ( ) ;
         double maxx = Math . abs ( xDot . u ) * maxVals . w + Math . abs ( xDot . i ) * maxVals . x + Math . abs ( xDot . j ) * maxVals . y + Math . abs ( xDot . k ) * maxVals . z ;
         double minx = Math . abs ( xDot . u ) * minVals . w + Math . abs ( xDot . i ) * minVals . x + Math . abs ( xDot . j ) * minVals . y + Math . abs ( xDot . k ) * minVals . z ;
         double maxy = Math . abs ( yDot . u ) * maxVals . w + Math . abs ( yDot . i ) * maxVals . x + Math . abs ( yDot . j ) * maxVals . y + Math . abs ( yDot . k ) * maxVals . z ;
         double miny = Math . abs ( yDot . u ) * minVals . w + Math . abs ( yDot . i ) * minVals . x + Math . abs ( yDot . j ) * minVals . y + Math . abs ( yDot . k ) * minVals . z ;
         double spanx = 1.0 / ( maxx - minx ) ;
         double spany = 1.0 / ( maxy - miny ) ;
         List < APoint4d > points = ( List < APoint4d > ) result . getValues ( ) ;
         for ( int i = 0 ;
         i < points . size ( ) ;
         i ++ ) {
         APoint4d a = points . get ( i ) ;
         double ax = xDot . u * a . w + xDot . i * a . x + xDot . j * a . y + xDot . k * a . z ;
         double ay = yDot . u * a . w + yDot . i * a . x + yDot . j * a . y + yDot . k * a . z ;
         double x = ( ax - minx ) * spanx ;
         double y = ( ay - miny ) * spany ;
         double t = zDot . u * a . w + zDot . i * a . x + zDot . j * a . y + zDot . k * a . z ;
         double u = wDot . u * a . w + wDot . i * a . x + wDot . j * a . y + wDot . k * a . z ;
         brush . paint ( x , y , 0 , 0 , .02 * width . getValue ( u ) . val , color . getValue ( t ) , canvas ) ;
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

   public static class PlotBuffer2_curve_col extends Command {

      private LDouble samplingRatio;private LDouble sampleSharpness;private Integer sampleRadius;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return samplingRatio;
            case 1: return sampleSharpness;
            case 2: return sampleRadius;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "samplingRatio";
            case 1: return "sampleSharpness";
            case 2: return "sampleRadius";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: samplingRatio = (LDouble) value; return;
            case 1: sampleSharpness = (LDouble) value; return;
            case 2: sampleRadius = (Integer) value; return;
            default: return;
         }

      }

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

      public PlotBuffer2_curve_col() {
         addGroupMeta(this);
         samplingRatio = new LDouble ( 2 + 3 * Math . random ( ) ) ;
         sampleSharpness = new LDouble ( .01 + .5 * Math . random ( ) ) ;
         sampleRadius = ( int ) ( 2 + 3 * Math . random ( ) ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final Brush brush = (Brush)inputs[0];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         final Buffer_d buffer = (Buffer_d)inputs[2];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         double step = 1.0 / samplingRatio . val ;
         for ( double dx = 0 ;
         dx < buffer . getXRes ( ) ;
         dx += step ) for ( double dy = 0 ;
         dy < buffer . getYRes ( ) ;
         dy += step ) {
         double x = dx / buffer . getXRes ( ) ;
         double y = dy / buffer . getYRes ( ) ;
         double value = buffer . pointGaussAverage ( dx , dy , sampleRadius , sampleSharpness . val ) . val ;
         Color c = color . getValue ( value ) ;
         brush . paint ( x , y , 0 , 0 , .02 , c , canvas ) ;
         }
      }

   }

   public static class PlotBuffer2_curve_col2 extends Command {

      private LDouble samplingRatio;private LDouble sampleSharpness;private Integer sampleRadius;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return samplingRatio;
            case 1: return sampleSharpness;
            case 2: return sampleRadius;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "samplingRatio";
            case 1: return "sampleSharpness";
            case 2: return "sampleRadius";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: samplingRatio = (LDouble) value; return;
            case 1: sampleSharpness = (LDouble) value; return;
            case 2: sampleRadius = (Integer) value; return;
            default: return;
         }

      }

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

      public PlotBuffer2_curve_col2() {
         addGroupMeta(this);
         samplingRatio = new LDouble ( 2 + 3 * Math . random ( ) ) ;
         sampleSharpness = new LDouble ( .01 + .5 * Math . random ( ) ) ;
         sampleRadius = ( int ) ( 2 + 3 * Math . random ( ) ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final Brush brush = (Brush)inputs[0];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         final Buffer_d buffer = (Buffer_d)inputs[2];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         double step = 1.0 / samplingRatio . val ;
         for ( double dx = 0 ;
         dx < buffer . getXRes ( ) ;
         dx += step ) for ( double dy = 0 ;
         dy < buffer . getYRes ( ) ;
         dy += step ) {
         double x = dx / buffer . getXRes ( ) ;
         double y = dy / buffer . getYRes ( ) ;
         double value = buffer . pointGaussAverage ( dx , dy , sampleRadius , sampleSharpness . val ) . val ;
         Color c = color . getValue ( value ) ;
         brush . paint ( x , y , 0 , 0 , .1 * value , c , canvas ) ;
         }
      }

   }

   public static class PlotBuffer2_curve_col_size extends Command {

      private LDouble samplingRatio;private LDouble sampleSharpness;private Integer sampleRadius;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return samplingRatio;
            case 1: return sampleSharpness;
            case 2: return sampleRadius;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "samplingRatio";
            case 1: return "sampleSharpness";
            case 2: return "sampleRadius";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: samplingRatio = (LDouble) value; return;
            case 1: sampleSharpness = (LDouble) value; return;
            case 2: sampleRadius = (Integer) value; return;
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

      public PlotBuffer2_curve_col_size() {
         addGroupMeta(this);
         samplingRatio = new LDouble ( 2 + 3 * Math . random ( ) ) ;
         sampleSharpness = new LDouble ( .01 + .5 * Math . random ( ) ) ;
         sampleRadius = ( int ) ( 2 + 3 * Math . random ( ) ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final Brush brush = (Brush)inputs[0];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         final CurveUtil . Curve_d width = (CurveUtil . Curve_d)inputs[2];
         final Buffer_d buffer = (Buffer_d)inputs[3];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         double step = 1.0 / samplingRatio . val ;
         for ( double dx = 0 ;
         dx < buffer . getXRes ( ) ;
         dx += step ) for ( double dy = 0 ;
         dy < buffer . getYRes ( ) ;
         dy += step ) {
         double x = dx / buffer . getXRes ( ) ;
         double y = dy / buffer . getYRes ( ) ;
         double value = buffer . pointGaussAverage ( dx , dy , sampleRadius , sampleSharpness . val ) . val ;
         Color c = color . getValue ( value ) ;
         brush . paint ( x , y , 0 , 0 , .5 * width . getValue ( value ) . val , c , canvas ) ;
         }
      }

   }

   public static class PlotBuffer2_thresh1_curve_col_size extends Command {

      private LDouble threshold;private LDouble samplingRatio;private LDouble sampleSharpness;private Integer sampleRadius;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return threshold;
            case 1: return samplingRatio;
            case 2: return sampleSharpness;
            case 3: return sampleRadius;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "threshold";
            case 1: return "samplingRatio";
            case 2: return "sampleSharpness";
            case 3: return "sampleRadius";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: threshold = (LDouble) value; return;
            case 1: samplingRatio = (LDouble) value; return;
            case 2: sampleSharpness = (LDouble) value; return;
            case 3: sampleRadius = (Integer) value; return;
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

      public PlotBuffer2_thresh1_curve_col_size() {
         addGroupMeta(this);
         threshold = new LDouble ( .1 + .8 * Math . random ( ) ) ;
         samplingRatio = new LDouble ( 2 + 3 * Math . random ( ) ) ;
         sampleSharpness = new LDouble ( .01 + .5 * Math . random ( ) ) ;
         sampleRadius = ( int ) ( 2 + 3 * Math . random ( ) ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final Brush brush = (Brush)inputs[0];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         final CurveUtil . Curve_d width = (CurveUtil . Curve_d)inputs[2];
         final Buffer_d buffer = (Buffer_d)inputs[3];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         double step = 1.0 / samplingRatio . val ;
         for ( double dx = 0 ;
         dx < buffer . getXRes ( ) ;
         dx += step ) for ( double dy = 0 ;
         dy < buffer . getYRes ( ) ;
         dy += step ) {
         double x = dx / buffer . getXRes ( ) ;
         double y = dy / buffer . getYRes ( ) ;
         double value = buffer . pointGaussAverage ( dx , dy , sampleRadius , sampleSharpness . val ) . val ;
         if ( value < threshold . val ) continue ;
         value = ( value - threshold . val ) / ( 1 - threshold . val ) ;
         Color c = color . getValue ( value ) ;
         brush . paint ( x , y , 0 , 0 , .5 * width . getValue ( value ) . val , c , canvas ) ;
         }
      }

   }

   public static class PlotBuffer2_thresh2_curve_col_size extends Command {

      private LDouble threshold;private LDouble samplingRatio;private LDouble sampleSharpness;private Integer sampleRadius;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return threshold;
            case 1: return samplingRatio;
            case 2: return sampleSharpness;
            case 3: return sampleRadius;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "threshold";
            case 1: return "samplingRatio";
            case 2: return "sampleSharpness";
            case 3: return "sampleRadius";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: threshold = (LDouble) value; return;
            case 1: samplingRatio = (LDouble) value; return;
            case 2: sampleSharpness = (LDouble) value; return;
            case 3: sampleRadius = (Integer) value; return;
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

      public PlotBuffer2_thresh2_curve_col_size() {
         addGroupMeta(this);
         threshold = new LDouble ( .1 + .8 * Math . random ( ) ) ;
         samplingRatio = new LDouble ( 2 + 3 * Math . random ( ) ) ;
         sampleSharpness = new LDouble ( .01 + .5 * Math . random ( ) ) ;
         sampleRadius = ( int ) ( 2 + 3 * Math . random ( ) ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final Brush brush = (Brush)inputs[0];
         final CurveUtil . Curve_col color = (CurveUtil . Curve_col)inputs[1];
         final CurveUtil . Curve_d width = (CurveUtil . Curve_d)inputs[2];
         final Buffer_d buffer = (Buffer_d)inputs[3];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         double step = 1.0 / samplingRatio . val ;
         for ( double dx = 0 ;
         dx < buffer . getXRes ( ) ;
         dx += step ) for ( double dy = 0 ;
         dy < buffer . getYRes ( ) ;
         dy += step ) {
         double x = dx / buffer . getXRes ( ) ;
         double y = dy / buffer . getYRes ( ) ;
         double value = buffer . pointGaussAverage ( dx , dy , sampleRadius , sampleSharpness . val ) . val ;
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
      r.add(new PlotAttractor3_curve_col());
      r.add(new PlotAttractor3a_curve_col());
      r.add(new PlotAttractor3a_dotcol_curve_col());
      r.add(new PlotAttractor3b_curve_col());
      r.add(new PlotAttractor4_curve_col());
      r.add(new PlotAttractor4a_curve_col());
      r.add(new PlotAttractor4a_dotcol_curve_col());
      r.add(new PlotAttractor4b_curve_col());
      r.add(new PlotIFS());
      r.add(new PlotIFS_curve_col());
      r.add(new PlotBuffer_curve_col());
      r.add(new PlotBuffer_curve_col2());
      r.add(new PlotBuffer_curve_col_size());
      r.add(new PlotBuffer_thresh1_curve_col_size());
      r.add(new PlotBuffer_thresh2_curve_col_size());
      r.add(new PlotBuffer2_curve_col());
      r.add(new PlotBuffer2_curve_col2());
      r.add(new PlotBuffer2_curve_col_size());
      r.add(new PlotBuffer2_thresh1_curve_col_size());
      r.add(new PlotBuffer2_thresh2_curve_col_size());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
