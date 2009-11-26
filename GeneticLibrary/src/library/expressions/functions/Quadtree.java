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
import utils.pointfield.attractor.*;

public final class Quadtree implements AllComponents<ExpressionFunction>, Described {

   public static class qt2_density extends ExpressionFunction {

      private double radius;
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
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: radius = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "qt";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return QT2d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public qt2_density() {
         addGroupMeta(this);
         radius = Math . random ( ) + .02 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final QT2d qt = (QT2d)inputs[0];
         final LVect2d x = (LVect2d)inputs[1];
         double rad = qt . getRadiusEstimate ( ) * radius ;
         double x1 = qt . convertXFromUnit ( x . x ) ;
         double y1 = qt . convertYFromUnit ( x . y ) ;
         List < APoint2d > contents = qt . getContents ( x1 , y1 , rad ) ;
         int ok = 0 ;
         for ( APoint2d point : contents ) {
         if ( point . distanceSquared ( x1 , y1 ) < rad * rad ) ok ++ ;
         }
         return new LDouble ( ( double ) ok / qt . getMaxDensity ( ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class qt2_density1 extends ExpressionFunction {

      private double radius;
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
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: radius = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "qt";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return QT2d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public qt2_density1() {
         addGroupMeta(this);
         radius = Math . random ( ) + .02 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final QT2d qt = (QT2d)inputs[0];
         final LVect2d x = (LVect2d)inputs[1];
         double rad = qt . getRadiusEstimate ( ) * radius ;
         double x1 = qt . convertXFromUnit ( x . x ) ;
         double y1 = qt . convertYFromUnit ( x . y ) ;
         List < APoint2d > contents = qt . getContents ( x1 , y1 , rad ) ;
         int ok = 0 ;
         double dist2 = 100 ;
         for ( APoint2d point : contents ) {
         double d = point . distanceSquared ( x1 , y1 ) ;
         if ( d < dist2 ) dist2 = d ;
         if ( point . distanceSquared ( x1 , y1 ) < rad * rad ) ok ++ ;
         }
         dist2 = Math . sqrt ( dist2 ) / rad ;
         return new LDouble ( ( double ) ok * ( 1 - dist2 ) / qt . getMaxDensity ( ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class qt2_nearestDist extends ExpressionFunction {

      private double radius;
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
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: radius = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "qt";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return QT2d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public qt2_nearestDist() {
         addGroupMeta(this);
         radius = Math . random ( ) + .02 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final QT2d qt = (QT2d)inputs[0];
         final LVect2d x = (LVect2d)inputs[1];
         double rad = qt . getRadiusEstimate ( ) * radius ;
         double x1 = qt . convertXFromUnit ( x . x ) ;
         double y1 = qt . convertYFromUnit ( x . y ) ;
         List < APoint2d > contents = qt . getContents ( x1 , y1 , rad ) ;
         double dist2 = 100 ;
         for ( APoint2d point : contents ) {
         double d = point . distanceSquared ( x1 , y1 ) ;
         if ( d < dist2 ) dist2 = d ;
         }
         dist2 = Math . sqrt ( dist2 ) / rad ;
         if ( dist2 > 1 ) return new LDouble ( 0 ) ;
         return new LDouble ( 1 - dist2 ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class qt2_nearestDist1 extends ExpressionFunction {

      private double radius;
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
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: radius = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "qt";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return QT2d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public qt2_nearestDist1() {
         addGroupMeta(this);
         radius = Math . random ( ) + .02 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final QT2d qt = (QT2d)inputs[0];
         final LVect2d x = (LVect2d)inputs[1];
         double rad = qt . getRadiusEstimate ( ) * radius ;
         double x1 = qt . convertXFromUnit ( x . x ) ;
         double y1 = qt . convertYFromUnit ( x . y ) ;
         List < APoint2d > contents = qt . getContents ( x1 , y1 , rad ) ;
         double dist2 = 100 ;
         for ( APoint2d point : contents ) {
         double d = point . distanceSquared ( x1 , y1 ) ;
         if ( d < dist2 ) dist2 = d ;
         }
         dist2 = Math . sqrt ( dist2 ) / rad ;
         if ( dist2 > 1 ) return new LDouble ( 0 ) ;
         return new LDouble ( dist2 ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class qt2_nearestDist_progress extends ExpressionFunction {

      private double radius;
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
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: radius = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "qt";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return QT2d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public qt2_nearestDist_progress() {
         addGroupMeta(this);
         radius = Math . random ( ) + .02 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final QT2d qt = (QT2d)inputs[0];
         final LVect2d x = (LVect2d)inputs[1];
         double rad = qt . getRadiusEstimate ( ) * radius ;
         double x1 = qt . convertXFromUnit ( x . x ) ;
         double y1 = qt . convertYFromUnit ( x . y ) ;
         List < APoint2d > contents = qt . getContents ( x1 , y1 , rad ) ;
         double dist2 = 100 ;
         double progress = 0 ;
         for ( APoint2d point : contents ) {
         double d = point . distanceSquared ( x1 , y1 ) ;
         if ( d < dist2 ) {
         dist2 = d ;
         progress = point . index ;
         }
         }
         dist2 = Math . sqrt ( dist2 ) / rad ;
         if ( dist2 > 1 ) return new LDouble ( 0 ) ;
         return new LDouble ( ( 1 - dist2 ) * progress ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class qt2_geometric extends ExpressionFunction {

      private double radius;
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
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: radius = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "qt";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return QT2d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public qt2_geometric() {
         addGroupMeta(this);
         radius = Math . random ( ) + .02 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final QT2d qt = (QT2d)inputs[0];
         final LVect2d x = (LVect2d)inputs[1];
         double rad = qt . getRadiusEstimate ( ) * radius ;
         double x1 = qt . convertXFromUnit ( x . x ) ;
         double y1 = qt . convertYFromUnit ( x . y ) ;
         List < APoint2d > contents = qt . getContents ( x1 , y1 , rad ) ;
         double dist2 = 100 ;
         for ( APoint2d point : contents ) {
         double d = point . distanceSquared ( x1 , y1 ) ;
         if ( d < dist2 ) dist2 = d ;
         }
         dist2 = Math . sqrt ( dist2 ) / rad ;
         if ( dist2 > 1 ) return new LDouble ( 0 ) ;
         return new LDouble ( 1 ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class qt2_geometric_progress extends ExpressionFunction {

      private double radius;
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
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: radius = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "qt";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return QT2d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public qt2_geometric_progress() {
         addGroupMeta(this);
         radius = Math . random ( ) + .02 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final QT2d qt = (QT2d)inputs[0];
         final LVect2d x = (LVect2d)inputs[1];
         double rad = qt . getRadiusEstimate ( ) * radius ;
         double x1 = qt . convertXFromUnit ( x . x ) ;
         double y1 = qt . convertYFromUnit ( x . y ) ;
         List < APoint2d > contents = qt . getContents ( x1 , y1 , rad ) ;
         double dist2 = 100 ;
         double progress = 0 ;
         for ( APoint2d point : contents ) {
         double d = point . distanceSquared ( x1 , y1 ) ;
         if ( d < dist2 ) {
         dist2 = d ;
         progress = point . index ;
         }
         }
         dist2 = Math . sqrt ( dist2 ) / rad ;
         if ( dist2 > 1 ) return new LDouble ( 0 ) ;
         return new LDouble ( progress ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class qt2_nearestVect extends ExpressionFunction {

      private double radius;
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
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: radius = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "qt";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return QT2d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public qt2_nearestVect() {
         addGroupMeta(this);
         radius = Math . random ( ) + .02 ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final QT2d qt = (QT2d)inputs[0];
         final LVect2d x = (LVect2d)inputs[1];
         double rad = qt . getRadiusEstimate ( ) * radius ;
         double x1 = qt . convertXFromUnit ( x . x ) ;
         double y1 = qt . convertYFromUnit ( x . y ) ;
         List < APoint2d > contents = qt . getContents ( x1 , y1 , rad ) ;
         double dist2 = 100 ;
         double dx = 0 ;
         double dy = 0 ;
         for ( APoint2d point : contents ) {
         double d = point . distanceSquared ( x1 , y1 ) ;
         if ( d < dist2 ) {
         dist2 = d ;
         dx = point . x - x1 ;
         dy = point . y - x1 ;
         }
         }
         dist2 = Math . sqrt ( dist2 ) / rad ;
         if ( dist2 > 1 ) return new LVect2d ( 0 , 0 ) ;
         return new LVect2d ( dx , dy ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class qt2_depth extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "qt";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return QT2d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public qt2_depth() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final QT2d qt = (QT2d)inputs[0];
         final LVect2d x = (LVect2d)inputs[1];
         double x1 = qt . convertXFromUnit ( x . x ) ;
         double y1 = qt . convertYFromUnit ( x . y ) ;
         return new LDouble ( ( double ) qt . getDepth ( x1 , y1 ) / qt . getMaxDepth ( ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class qt3_density extends ExpressionFunction {

      private double radius;
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
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: radius = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "qt";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return QT3d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public qt3_density() {
         addGroupMeta(this);
         radius = Math . random ( ) + .02 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final QT3d qt = (QT3d)inputs[0];
         final LVect2d x = (LVect2d)inputs[1];
         double rad = qt . getRadiusEstimate ( ) * radius ;
         double x1 = qt . convertXFromUnit ( x . x ) ;
         double y1 = qt . convertYFromUnit ( x . y ) ;
         List < APoint3d > contents = qt . getContents ( x1 , y1 , rad ) ;
         int ok = 0 ;
         for ( APoint3d point : contents ) {
         if ( point . distanceSquared ( x1 , y1 ) < rad * rad ) ok ++ ;
         }
         return new LDouble ( ( double ) ok / qt . getMaxDensity ( ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class qt3_density1 extends ExpressionFunction {

      private double radius;
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
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: radius = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "qt";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return QT3d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public qt3_density1() {
         addGroupMeta(this);
         radius = Math . random ( ) + .02 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final QT3d qt = (QT3d)inputs[0];
         final LVect2d x = (LVect2d)inputs[1];
         double rad = qt . getRadiusEstimate ( ) * radius ;
         double x1 = qt . convertXFromUnit ( x . x ) ;
         double y1 = qt . convertYFromUnit ( x . y ) ;
         List < APoint3d > contents = qt . getContents ( x1 , y1 , rad ) ;
         int ok = 0 ;
         double dist2 = 100 ;
         for ( APoint3d point : contents ) {
         double d = point . distanceSquared ( x1 , y1 ) ;
         if ( d < dist2 ) dist2 = d ;
         if ( point . distanceSquared ( x1 , y1 ) < rad * rad ) ok ++ ;
         }
         dist2 = Math . sqrt ( dist2 ) / rad ;
         return new LDouble ( ( double ) ok * ( 1 - dist2 ) / qt . getMaxDensity ( ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class qt3_nearestDist extends ExpressionFunction {

      private double radius;
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
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: radius = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "qt";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return QT3d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public qt3_nearestDist() {
         addGroupMeta(this);
         radius = Math . random ( ) + .02 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final QT3d qt = (QT3d)inputs[0];
         final LVect2d x = (LVect2d)inputs[1];
         double rad = qt . getRadiusEstimate ( ) * radius ;
         double x1 = qt . convertXFromUnit ( x . x ) ;
         double y1 = qt . convertYFromUnit ( x . y ) ;
         List < APoint3d > contents = qt . getContents ( x1 , y1 , rad ) ;
         double dist2 = 100 ;
         for ( APoint3d point : contents ) {
         double d = point . distanceSquared ( x1 , y1 ) ;
         if ( d < dist2 ) dist2 = d ;
         }
         dist2 = Math . sqrt ( dist2 ) / rad ;
         if ( dist2 > 1 ) return new LDouble ( 0 ) ;
         return new LDouble ( 1 - dist2 ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class qt3_nearestDist1 extends ExpressionFunction {

      private double radius;
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
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: radius = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "qt";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return QT3d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public qt3_nearestDist1() {
         addGroupMeta(this);
         radius = Math . random ( ) + .02 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final QT3d qt = (QT3d)inputs[0];
         final LVect2d x = (LVect2d)inputs[1];
         double rad = qt . getRadiusEstimate ( ) * radius ;
         double x1 = qt . convertXFromUnit ( x . x ) ;
         double y1 = qt . convertYFromUnit ( x . y ) ;
         List < APoint3d > contents = qt . getContents ( x1 , y1 , rad ) ;
         double dist2 = 100 ;
         for ( APoint3d point : contents ) {
         double d = point . distanceSquared ( x1 , y1 ) ;
         if ( d < dist2 ) dist2 = d ;
         }
         dist2 = Math . sqrt ( dist2 ) / rad ;
         if ( dist2 > 1 ) return new LDouble ( 0 ) ;
         return new LDouble ( dist2 ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class qt3_geometric_3Return extends ExpressionFunction {

      private double radius;
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
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: radius = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "qt";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return QT3d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public qt3_geometric_3Return() {
         addGroupMeta(this);
         radius = Math . random ( ) + .02 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final QT3d qt = (QT3d)inputs[0];
         final LVect2d x = (LVect2d)inputs[1];
         double rad = qt . getRadiusEstimate ( ) * radius ;
         double x1 = qt . convertXFromUnit ( x . x ) ;
         double y1 = qt . convertYFromUnit ( x . y ) ;
         List < APoint3d > contents = qt . getContents ( x1 , y1 , rad ) ;
         double dist2 = 100 ;
         double zval = 0 ;
         for ( APoint3d point : contents ) {
         double d = point . distanceSquared ( x1 , y1 ) ;
         if ( d < dist2 ) {
         dist2 = d ;
         zval = point . z ;
         }
         }
         dist2 = Math . sqrt ( dist2 ) / rad ;
         if ( dist2 > 1 ) return new LDouble ( 0 ) ;
         return new LDouble ( zval ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class qt3_nearestDist_3Return extends ExpressionFunction {

      private double radius;
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
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: radius = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "qt";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return QT3d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public qt3_nearestDist_3Return() {
         addGroupMeta(this);
         radius = Math . random ( ) + .02 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final QT3d qt = (QT3d)inputs[0];
         final LVect2d x = (LVect2d)inputs[1];
         double rad = qt . getRadiusEstimate ( ) * radius ;
         double x1 = qt . convertXFromUnit ( x . x ) ;
         double y1 = qt . convertYFromUnit ( x . y ) ;
         List < APoint3d > contents = qt . getContents ( x1 , y1 , rad ) ;
         double dist2 = 100 ;
         double zval = 0 ;
         for ( APoint3d point : contents ) {
         double d = point . distanceSquared ( x1 , y1 ) ;
         if ( d < dist2 ) {
         dist2 = d ;
         zval = point . z ;
         }
         }
         dist2 = Math . sqrt ( dist2 ) / rad ;
         if ( dist2 > 1 ) return new LDouble ( 0 ) ;
         return new LDouble ( dist2 * zval ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class qt3_nearestVect extends ExpressionFunction {

      private double radius;
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
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: radius = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "qt";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return QT3d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public qt3_nearestVect() {
         addGroupMeta(this);
         radius = Math . random ( ) + .02 ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final QT3d qt = (QT3d)inputs[0];
         final LVect2d x = (LVect2d)inputs[1];
         double rad = qt . getRadiusEstimate ( ) * radius ;
         double x1 = qt . convertXFromUnit ( x . x ) ;
         double y1 = qt . convertYFromUnit ( x . y ) ;
         List < APoint3d > contents = qt . getContents ( x1 , y1 , rad ) ;
         double dist2 = 100 ;
         double dx = 0 ;
         double dy = 0 ;
         double zval = 0 ;
         for ( APoint3d point : contents ) {
         double d = point . distanceSquared ( x1 , y1 ) ;
         if ( d < dist2 ) {
         dist2 = d ;
         dx = point . x - x1 ;
         dy = point . y - x1 ;
         zval = point . z ;
         }
         }
         dist2 = Math . sqrt ( dist2 ) / rad ;
         if ( dist2 > 1 ) return new LVect2d ( 0 , 0 ) ;
         return new LVect2d ( dx * zval , dy * zval ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class qt3_nearestVect_3Return extends ExpressionFunction {

      private double radius;
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
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: radius = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "qt";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return QT3d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public qt3_nearestVect_3Return() {
         addGroupMeta(this);
         radius = Math . random ( ) + .02 ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final QT3d qt = (QT3d)inputs[0];
         final LVect2d x = (LVect2d)inputs[1];
         double rad = qt . getRadiusEstimate ( ) * radius ;
         double x1 = qt . convertXFromUnit ( x . x ) ;
         double y1 = qt . convertYFromUnit ( x . y ) ;
         List < APoint3d > contents = qt . getContents ( x1 , y1 , rad ) ;
         double dist2 = 100 ;
         double dx = 0 ;
         double dy = 0 ;
         for ( APoint3d point : contents ) {
         double d = point . distanceSquared ( x1 , y1 ) ;
         if ( d < dist2 ) {
         dist2 = d ;
         dx = point . x - x . x ;
         dy = point . y - x . y ;
         }
         }
         dist2 = Math . sqrt ( dist2 ) / rad ;
         if ( dist2 > 1 ) return new LVect2d ( 0 , 0 ) ;
         return new LVect2d ( dx , dy ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class qt3_depth extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "qt";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return QT3d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public qt3_depth() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final QT3d qt = (QT3d)inputs[0];
         final LVect2d x = (LVect2d)inputs[1];
         double x1 = qt . convertXFromUnit ( x . x ) ;
         double y1 = qt . convertYFromUnit ( x . y ) ;
         return new LDouble ( ( double ) qt . getDepth ( x1 , y1 ) / qt . getMaxDepth ( ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public String getDescription() {
      return "Evaluating from quadtrees";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new qt2_density());
      r.add(new qt2_density1());
      r.add(new qt2_nearestDist());
      r.add(new qt2_nearestDist1());
      r.add(new qt2_nearestDist_progress());
      r.add(new qt2_geometric());
      r.add(new qt2_geometric_progress());
      r.add(new qt2_nearestVect());
      r.add(new qt2_depth());
      r.add(new qt3_density());
      r.add(new qt3_density1());
      r.add(new qt3_nearestDist());
      r.add(new qt3_nearestDist1());
      r.add(new qt3_geometric_3Return());
      r.add(new qt3_nearestDist_3Return());
      r.add(new qt3_nearestVect());
      r.add(new qt3_nearestVect_3Return());
      r.add(new qt3_depth());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
