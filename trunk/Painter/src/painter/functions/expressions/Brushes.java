package painter . functions . expressions;

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
import java.awt.image.*;
import utils.linear.*;
import painter.tools.brush.*;
import painter.tools.canvas.*;

public final class Brushes implements AllComponents<ExpressionFunction>, Described {

   public static class simpleBrush1 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            default: return null;
         }

      }

      public simpleBrush1() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         return new SimpleBrush ( positionPolicy , sizePolicy ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class simpleBrush2 extends ExpressionFunction {

      private LDouble radiusMultiplier;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return radiusMultiplier;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "radiusMultiplier";
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
            case 0: radiusMultiplier = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            default: return null;
         }

      }

      public simpleBrush2() {
         addGroupMeta(this);
         radiusMultiplier = new LDouble ( .2 * Math . random ( ) * .5 ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         return new SimpleBrush ( positionPolicy , sizePolicy , radiusMultiplier . val ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class simpleBrush3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "radiusMultiplier";
            case 1: return "positionPolicy";
            case 2: return "sizePolicy";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return BrushPositionPolicy.class;
            case 2: return BrushSizePolicy.class;
            default: return null;
         }

      }

      public simpleBrush3() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final LDouble radiusMultiplier = (LDouble)inputs[0];
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[1];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[2];
         return new SimpleBrush ( positionPolicy , sizePolicy , radiusMultiplier . val ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class hollowCircleBrush extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            default: return null;
         }

      }

      public hollowCircleBrush() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         return new HollowCircleBrush ( positionPolicy , sizePolicy ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class ellipseBrush1 extends ExpressionFunction {

      public int getNumberInputs() {
         return 6;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            case 2: return "xScale";
            case 3: return "yScale";
            case 4: return "theta";
            case 5: return "hollow";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            case 4: return LDouble.class;
            case 5: return Boolean.class;
            default: return null;
         }

      }

      public ellipseBrush1() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final LDouble xScale = (LDouble)inputs[2];
         final LDouble yScale = (LDouble)inputs[3];
         final LDouble theta = (LDouble)inputs[4];
         final Boolean hollow = (Boolean)inputs[5];
         return new EllipseBrush ( positionPolicy , sizePolicy , xScale . val , yScale . val , theta . val , hollow ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class ellipseBrushv extends ExpressionFunction {

      public int getNumberInputs() {
         return 5;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            case 2: return "v";
            case 3: return "theta";
            case 4: return "hollow";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return LVect2d.class;
            case 3: return LDouble.class;
            case 4: return Boolean.class;
            default: return null;
         }

      }

      public ellipseBrushv() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final LVect2d v = (LVect2d)inputs[2];
         final LDouble theta = (LDouble)inputs[3];
         final Boolean hollow = (Boolean)inputs[4];
         return new EllipseBrush ( positionPolicy , sizePolicy , v . x , v . y , theta . val , hollow ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class hollowArcBrush1 extends ExpressionFunction {

      private LDouble arcSize;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return arcSize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "arcSize";
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
            case 0: arcSize = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            case 2: return "startAngle";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public hollowArcBrush1() {
         addGroupMeta(this);
         arcSize = new LDouble ( Math . random ( ) ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final LDouble startAngle = (LDouble)inputs[2];
         HollowArcBrush brush = new HollowArcBrush ( positionPolicy , sizePolicy ) ;
         brush . setAngles ( startAngle . val , startAngle . val + arcSize . val ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class hollowArcBrush2 extends ExpressionFunction {

      private LDouble startAngle;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return startAngle;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "startAngle";
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
            case 0: startAngle = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            case 2: return "arcSize";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public hollowArcBrush2() {
         addGroupMeta(this);
         startAngle = new LDouble ( Math . random ( ) ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final LDouble arcSize = (LDouble)inputs[2];
         HollowArcBrush brush = new HollowArcBrush ( positionPolicy , sizePolicy ) ;
         brush . setAngles ( startAngle . val , startAngle . val + arcSize . val ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class hollowArcBrush3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            case 2: return "startAngle";
            case 3: return "arcSize";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            default: return null;
         }

      }

      public hollowArcBrush3() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final LDouble startAngle = (LDouble)inputs[2];
         final LDouble arcSize = (LDouble)inputs[3];
         HollowArcBrush brush = new HollowArcBrush ( positionPolicy , sizePolicy ) ;
         brush . setAngles ( startAngle . val , startAngle . val + arcSize . val ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class curvyBrush1 extends ExpressionFunction {

      public int getNumberInputs() {
         return 6;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            case 2: return "v1";
            case 3: return "v2";
            case 4: return "v3";
            case 5: return "v4";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return LVect2d.class;
            case 3: return LVect2d.class;
            case 4: return LVect2d.class;
            case 5: return LVect2d.class;
            default: return null;
         }

      }

      public curvyBrush1() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final LVect2d v1 = (LVect2d)inputs[2];
         final LVect2d v2 = (LVect2d)inputs[3];
         final LVect2d v3 = (LVect2d)inputs[4];
         final LVect2d v4 = (LVect2d)inputs[5];
         return new CurvyBrush ( positionPolicy , sizePolicy , v1 , v2 , v3 , v4 ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class curvyBrush2 extends ExpressionFunction {

      private LVect2d v1;private LVect2d v2;private LVect2d v3;private LVect2d v4;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return v1;
            case 1: return v2;
            case 2: return v3;
            case 3: return v4;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "v1";
            case 1: return "v2";
            case 2: return "v3";
            case 3: return "v4";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            case 2: return LVect2d.class;
            case 3: return LVect2d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: v1 = (LVect2d) value; return;
            case 1: v2 = (LVect2d) value; return;
            case 2: v3 = (LVect2d) value; return;
            case 3: v4 = (LVect2d) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            default: return null;
         }

      }

      public curvyBrush2() {
         addGroupMeta(this);
         v1 = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         v2 = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         v3 = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         v4 = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         return new CurvyBrush ( positionPolicy , sizePolicy , v1 , v2 , v3 , v4 ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class penBrush extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            default: return null;
         }

      }

      public penBrush() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         return new PenBrush ( positionPolicy , sizePolicy ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class penBrush2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            default: return null;
         }

      }

      public penBrush2() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         return new DistortingPenBrush ( positionPolicy , sizePolicy ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class sweepBrush2 extends ExpressionFunction {

      private int numberDots;private double dotSize;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return numberDots;
            case 1: return dotSize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "numberDots";
            case 1: return "dotSize";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return int.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: numberDots = (Integer) value; return;
            case 1: dotSize = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "brush";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Brush.class;
            default: return null;
         }

      }

      public sweepBrush2() {
         addGroupMeta(this);
         dotSize = .2 + .8 * Math . random ( ) ;
         numberDots = ( int ) ( 3 + 5 * Math . random ( ) ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final Brush brush = (Brush)inputs[0];
         return new SweepBrush ( numberDots , dotSize , brush ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class spatterBrush1 extends ExpressionFunction {

      private LVect2d [ ] points;private LDouble size;private Boolean orient;private Boolean sizePoints;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return points;
            case 1: return size;
            case 2: return orient;
            case 3: return sizePoints;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "points";
            case 1: return "size";
            case 2: return "orient";
            case 3: return "sizePoints";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect2d [ ].class;
            case 1: return LDouble.class;
            case 2: return Boolean.class;
            case 3: return Boolean.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: points = (LVect2d [ ]) value; return;
            case 1: size = (LDouble) value; return;
            case 2: orient = (Boolean) value; return;
            case 3: sizePoints = (Boolean) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "brush";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Brush.class;
            default: return null;
         }

      }

      public spatterBrush1() {
         addGroupMeta(this);
         Random r = new Random ( ) ;
         int numberPoints = 4 + r . nextInt ( 20 ) ;
         points = new LVect2d [ numberPoints ] ;
         size = new LDouble ( .1 * Math . random ( ) + .05 ) ;
         for ( int i = 0 ;
         i < numberPoints ;
         i ++ ) {
         points [ i ] = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         }
         orient = r . nextBoolean ( ) ;
         sizePoints = r . nextBoolean ( ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final Brush brush = (Brush)inputs[0];
         SpatterBrush spatter = new SpatterBrush ( brush , points , size . val ) ;
         spatter . setOrient ( orient ) ;
         spatter . setSizePoints ( sizePoints ) ;
         return spatter ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class spatterBrush2 extends ExpressionFunction {

      private LVect2d [ ] points;private double [ ] sizes;private Boolean orient;private Boolean sizePoints;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return points;
            case 1: return sizes;
            case 2: return orient;
            case 3: return sizePoints;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "points";
            case 1: return "sizes";
            case 2: return "orient";
            case 3: return "sizePoints";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect2d [ ].class;
            case 1: return double [ ].class;
            case 2: return Boolean.class;
            case 3: return Boolean.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: points = (LVect2d [ ]) value; return;
            case 1: sizes = (double [ ]) value; return;
            case 2: orient = (Boolean) value; return;
            case 3: sizePoints = (Boolean) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "brush";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Brush.class;
            default: return null;
         }

      }

      public spatterBrush2() {
         addGroupMeta(this);
         Random r = new Random ( ) ;
         int numberPoints = 4 + r . nextInt ( 20 ) ;
         points = new LVect2d [ numberPoints ] ;
         sizes = new double [ numberPoints ] ;
         for ( int i = 0 ;
         i < numberPoints ;
         i ++ ) {
         points [ i ] = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         sizes [ i ] = .1 * Math . random ( ) + .05 ;
         }
         orient = r . nextBoolean ( ) ;
         sizePoints = r . nextBoolean ( ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final Brush brush = (Brush)inputs[0];
         SpatterBrush spatter = new SpatterBrush ( brush , points , sizes ) ;
         spatter . setOrient ( orient ) ;
         spatter . setSizePoints ( sizePoints ) ;
         return spatter ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class spatterBrush3 extends ExpressionFunction {

      private LVect2d [ ] points;private double [ ] sizes;private Color [ ] colorOffsets;private LDouble colorMultiplier;private Boolean orient;private Boolean sizePoints;
      public int getNumberParameters() {
         return 6;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return points;
            case 1: return sizes;
            case 2: return colorOffsets;
            case 3: return colorMultiplier;
            case 4: return orient;
            case 5: return sizePoints;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "points";
            case 1: return "sizes";
            case 2: return "colorOffsets";
            case 3: return "colorMultiplier";
            case 4: return "orient";
            case 5: return "sizePoints";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect2d [ ].class;
            case 1: return double [ ].class;
            case 2: return Color [ ].class;
            case 3: return LDouble.class;
            case 4: return Boolean.class;
            case 5: return Boolean.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: points = (LVect2d [ ]) value; return;
            case 1: sizes = (double [ ]) value; return;
            case 2: colorOffsets = (Color [ ]) value; return;
            case 3: colorMultiplier = (LDouble) value; return;
            case 4: orient = (Boolean) value; return;
            case 5: sizePoints = (Boolean) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "brush";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Brush.class;
            default: return null;
         }

      }

      public spatterBrush3() {
         addGroupMeta(this);
         addMeta("selectionWeight", 10);
         Random r = new Random ( ) ;
         int numberPoints = 4 + r . nextInt ( 20 ) ;
         points = new LVect2d [ numberPoints ] ;
         sizes = new double [ numberPoints ] ;
         colorOffsets = new Color [ numberPoints ] ;
         colorMultiplier = new LDouble ( Math . random ( ) * .3 + .1 ) ;
         for ( int i = 0 ;
         i < numberPoints ;
         i ++ ) {
         points [ i ] = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         sizes [ i ] = .1 * Math . random ( ) + .05 ;
         colorOffsets [ i ] = new Color ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         }
         orient = r . nextBoolean ( ) ;
         sizePoints = r . nextBoolean ( ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final Brush brush = (Brush)inputs[0];
         SpatterBrush spatter = new SpatterBrush ( brush , points , sizes ) ;
         spatter . setOrient ( orient ) ;
         spatter . setSizePoints ( sizePoints ) ;
         spatter . setColorOffsets ( colorOffsets , colorMultiplier . val ) ;
         return spatter ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class multiBrush_2 extends ExpressionFunction {
      private final static int SUB_BRUSHES = 2 ;
      private LVect2d [ ] offsets;private LDouble [ ] sizes;private Color [ ] colorOffsets;private LDouble colorMultiplier;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return offsets;
            case 1: return sizes;
            case 2: return colorOffsets;
            case 3: return colorMultiplier;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "offsets";
            case 1: return "sizes";
            case 2: return "colorOffsets";
            case 3: return "colorMultiplier";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect2d [ ].class;
            case 1: return LDouble [ ].class;
            case 2: return Color [ ].class;
            case 3: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: offsets = (LVect2d [ ]) value; return;
            case 1: sizes = (LDouble [ ]) value; return;
            case 2: colorOffsets = (Color [ ]) value; return;
            case 3: colorMultiplier = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "brush1";
            case 1: return "brush2";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Brush.class;
            case 1: return Brush.class;
            default: return null;
         }

      }

      public multiBrush_2() {
         addGroupMeta(this);
         Random r = new Random ( ) ;
         offsets = new LVect2d [ SUB_BRUSHES ] ;
         sizes = new LDouble [ SUB_BRUSHES ] ;
         colorOffsets = new Color [ SUB_BRUSHES ] ;
         for ( int i = 0 ;
         i < SUB_BRUSHES ;
         i ++ ) {
         offsets [ i ] = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         sizes [ i ] = new LDouble ( .5 + Math . random ( ) ) ;
         colorOffsets [ i ] = new Color ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         }
         colorMultiplier = new LDouble ( Math . random ( ) ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final Brush brush1 = (Brush)inputs[0];
         final Brush brush2 = (Brush)inputs[1];
         MultiBrush multi = new MultiBrush ( ) ;
         multi . setColorMultiplier ( colorMultiplier . val ) ;
         multi . addBrush ( brush1 , offsets [ 0 ] . x , offsets [ 0 ] . y , sizes [ 0 ] . val , colorOffsets [ 0 ] ) ;
         multi . addBrush ( brush2 , offsets [ 1 ] . x , offsets [ 1 ] . y , sizes [ 1 ] . val , colorOffsets [ 1 ] ) ;
         return multi ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class multiBrush_3 extends ExpressionFunction {
      private final static int SUB_BRUSHES = 3 ;
      private LVect2d [ ] offsets;private LDouble [ ] sizes;private Color [ ] colorOffsets;private LDouble colorMultiplier;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return offsets;
            case 1: return sizes;
            case 2: return colorOffsets;
            case 3: return colorMultiplier;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "offsets";
            case 1: return "sizes";
            case 2: return "colorOffsets";
            case 3: return "colorMultiplier";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect2d [ ].class;
            case 1: return LDouble [ ].class;
            case 2: return Color [ ].class;
            case 3: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: offsets = (LVect2d [ ]) value; return;
            case 1: sizes = (LDouble [ ]) value; return;
            case 2: colorOffsets = (Color [ ]) value; return;
            case 3: colorMultiplier = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "brush1";
            case 1: return "brush2";
            case 2: return "brush3";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Brush.class;
            case 1: return Brush.class;
            case 2: return Brush.class;
            default: return null;
         }

      }

      public multiBrush_3() {
         addGroupMeta(this);
         Random r = new Random ( ) ;
         offsets = new LVect2d [ SUB_BRUSHES ] ;
         sizes = new LDouble [ SUB_BRUSHES ] ;
         colorOffsets = new Color [ SUB_BRUSHES ] ;
         for ( int i = 0 ;
         i < SUB_BRUSHES ;
         i ++ ) {
         offsets [ i ] = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         sizes [ i ] = new LDouble ( .5 + Math . random ( ) ) ;
         colorOffsets [ i ] = new Color ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         }
         colorMultiplier = new LDouble ( Math . random ( ) ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final Brush brush1 = (Brush)inputs[0];
         final Brush brush2 = (Brush)inputs[1];
         final Brush brush3 = (Brush)inputs[2];
         MultiBrush multi = new MultiBrush ( ) ;
         multi . setColorMultiplier ( colorMultiplier . val ) ;
         multi . addBrush ( brush1 , offsets [ 0 ] . x , offsets [ 0 ] . y , sizes [ 0 ] . val , colorOffsets [ 0 ] ) ;
         multi . addBrush ( brush2 , offsets [ 1 ] . x , offsets [ 1 ] . y , sizes [ 1 ] . val , colorOffsets [ 1 ] ) ;
         multi . addBrush ( brush3 , offsets [ 2 ] . x , offsets [ 2 ] . y , sizes [ 2 ] . val , colorOffsets [ 2 ] ) ;
         return multi ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class multiBrush_4 extends ExpressionFunction {
      private final static int SUB_BRUSHES = 4 ;
      private LVect2d [ ] offsets;private LDouble [ ] sizes;private Color [ ] colorOffsets;private LDouble colorMultiplier;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return offsets;
            case 1: return sizes;
            case 2: return colorOffsets;
            case 3: return colorMultiplier;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "offsets";
            case 1: return "sizes";
            case 2: return "colorOffsets";
            case 3: return "colorMultiplier";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect2d [ ].class;
            case 1: return LDouble [ ].class;
            case 2: return Color [ ].class;
            case 3: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: offsets = (LVect2d [ ]) value; return;
            case 1: sizes = (LDouble [ ]) value; return;
            case 2: colorOffsets = (Color [ ]) value; return;
            case 3: colorMultiplier = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "brush1";
            case 1: return "brush2";
            case 2: return "brush3";
            case 3: return "brush4";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Brush.class;
            case 1: return Brush.class;
            case 2: return Brush.class;
            case 3: return Brush.class;
            default: return null;
         }

      }

      public multiBrush_4() {
         addGroupMeta(this);
         Random r = new Random ( ) ;
         offsets = new LVect2d [ SUB_BRUSHES ] ;
         sizes = new LDouble [ SUB_BRUSHES ] ;
         colorOffsets = new Color [ SUB_BRUSHES ] ;
         for ( int i = 0 ;
         i < SUB_BRUSHES ;
         i ++ ) {
         offsets [ i ] = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         sizes [ i ] = new LDouble ( .5 + Math . random ( ) ) ;
         colorOffsets [ i ] = new Color ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         }
         colorMultiplier = new LDouble ( Math . random ( ) ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final Brush brush1 = (Brush)inputs[0];
         final Brush brush2 = (Brush)inputs[1];
         final Brush brush3 = (Brush)inputs[2];
         final Brush brush4 = (Brush)inputs[3];
         MultiBrush multi = new MultiBrush ( ) ;
         multi . setColorMultiplier ( colorMultiplier . val ) ;
         multi . addBrush ( brush1 , offsets [ 0 ] . x , offsets [ 0 ] . y , sizes [ 0 ] . val , colorOffsets [ 0 ] ) ;
         multi . addBrush ( brush2 , offsets [ 1 ] . x , offsets [ 1 ] . y , sizes [ 1 ] . val , colorOffsets [ 1 ] ) ;
         multi . addBrush ( brush3 , offsets [ 2 ] . x , offsets [ 2 ] . y , sizes [ 2 ] . val , colorOffsets [ 2 ] ) ;
         multi . addBrush ( brush4 , offsets [ 3 ] . x , offsets [ 3 ] . y , sizes [ 3 ] . val , colorOffsets [ 3 ] ) ;
         return multi ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class dashBrush1 extends ExpressionFunction {

      private LDouble angle;private Boolean orient;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return angle;
            case 1: return orient;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "angle";
            case 1: return "orient";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return Boolean.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: angle = (LDouble) value; return;
            case 1: orient = (Boolean) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            default: return null;
         }

      }

      public dashBrush1() {
         addGroupMeta(this);
         orient = new Random ( ) . nextBoolean ( ) ;
         angle = new LDouble ( Math . random ( ) ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         DashBrush brush = new DashBrush ( angle . val , positionPolicy , sizePolicy ) ;
         brush . setOrient ( orient ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class dashBrush2 extends ExpressionFunction {

      private Boolean orient;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return orient;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "orient";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Boolean.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: orient = (Boolean) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "angle";
            case 1: return "positionPolicy";
            case 2: return "sizePolicy";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return BrushPositionPolicy.class;
            case 2: return BrushSizePolicy.class;
            default: return null;
         }

      }

      public dashBrush2() {
         addGroupMeta(this);
         orient = new Random ( ) . nextBoolean ( ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final LDouble angle = (LDouble)inputs[0];
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[1];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[2];
         DashBrush brush = new DashBrush ( angle . val , positionPolicy , sizePolicy ) ;
         brush . setOrient ( orient ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class smudgeBrush1 extends ExpressionFunction {

      private Boolean orient;private LVect2d smudgeDirection;private LDouble smudgeAmount;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return orient;
            case 1: return smudgeDirection;
            case 2: return smudgeAmount;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "orient";
            case 1: return "smudgeDirection";
            case 2: return "smudgeAmount";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Boolean.class;
            case 1: return LVect2d.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: orient = (Boolean) value; return;
            case 1: smudgeDirection = (LVect2d) value; return;
            case 2: smudgeAmount = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            default: return null;
         }

      }

      public smudgeBrush1() {
         addGroupMeta(this);
         orient = new Random ( ) . nextBoolean ( ) ;
         smudgeDirection = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         smudgeAmount = new LDouble ( 3 * Math . random ( ) + 1 ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         return new SmudgeBrush ( smudgeDirection , smudgeAmount . val , positionPolicy , sizePolicy ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class smudgeBrush2 extends ExpressionFunction {

      private Boolean orient;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return orient;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "orient";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Boolean.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: orient = (Boolean) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            case 2: return "smudgeDirection";
            case 3: return "smudgeAmount";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return LVect2d.class;
            case 3: return LDouble.class;
            default: return null;
         }

      }

      public smudgeBrush2() {
         addGroupMeta(this);
         orient = new Random ( ) . nextBoolean ( ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final LVect2d smudgeDirection = (LVect2d)inputs[2];
         final LDouble smudgeAmount = (LDouble)inputs[3];
         return new SmudgeBrush ( smudgeDirection , smudgeAmount . val , positionPolicy , sizePolicy ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class imageOpBrush extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            case 2: return "op";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return BufferedImageOp.class;
            default: return null;
         }

      }

      public imageOpBrush() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final BufferedImageOp op = (BufferedImageOp)inputs[2];
         return new ImageOpBrush ( op , positionPolicy , sizePolicy ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class rubberStampBrush1 extends ExpressionFunction {

      private LVect2d offset;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return offset;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "offset";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: offset = (LVect2d) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            default: return null;
         }

      }

      public rubberStampBrush1() {
         addGroupMeta(this);
         offset = new LVect2d ( .5 * ( Math . random ( ) - .5 ) , .5 * ( Math . random ( ) - .5 ) ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         return new RubberStampBrush ( positionPolicy , sizePolicy , offset . x , offset . y ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class rubberStampBrush2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            case 2: return "offset";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public rubberStampBrush2() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final LVect2d offset = (LVect2d)inputs[2];
         return new RubberStampBrush ( positionPolicy , sizePolicy , offset . x , offset . y ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class rubberStampBrush3 extends ExpressionFunction {

      private LVect2d offset;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return offset;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "offset";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: offset = (LVect2d) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            case 2: return "op";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return BufferedImageOp.class;
            default: return null;
         }

      }

      public rubberStampBrush3() {
         addGroupMeta(this);
         offset = new LVect2d ( .5 * ( Math . random ( ) - .5 ) , .5 * ( Math . random ( ) - .5 ) ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final BufferedImageOp op = (BufferedImageOp)inputs[2];
         RubberStampBrush brush = new RubberStampBrush ( positionPolicy , sizePolicy , offset . x , offset . y ) ;
         brush . setOp ( op ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class rubberStampBrush4 extends ExpressionFunction {

      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            case 2: return "offset";
            case 3: return "op";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return LVect2d.class;
            case 3: return BufferedImageOp.class;
            default: return null;
         }

      }

      public rubberStampBrush4() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final LVect2d offset = (LVect2d)inputs[2];
         final BufferedImageOp op = (BufferedImageOp)inputs[3];
         RubberStampBrush brush = new RubberStampBrush ( positionPolicy , sizePolicy , offset . x , offset . y ) ;
         brush . setOp ( op ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class simplePositionPolicy extends ExpressionFunction {

      private LDouble xAnchor;private LDouble yAnchor;private LDouble xDirection;private LDouble yDirection;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return xAnchor;
            case 1: return yAnchor;
            case 2: return xDirection;
            case 3: return yDirection;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "xAnchor";
            case 1: return "yAnchor";
            case 2: return "xDirection";
            case 3: return "yDirection";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: xAnchor = (LDouble) value; return;
            case 1: yAnchor = (LDouble) value; return;
            case 2: xDirection = (LDouble) value; return;
            case 3: yDirection = (LDouble) value; return;
            default: return;
         }

      }

      public simplePositionPolicy() {
         addGroupMeta(this);
         if ( Math . random ( ) < .5 ) {
         xAnchor = new LDouble ( Math . random ( ) < .5 ? 0 : - 1 ) ;
         xDirection = new LDouble ( Math . random ( ) < .5 ? 1 : .5 ) ;
         }
         else {
         xAnchor = new LDouble ( Math . random ( ) < .5 ? 0 : 1 ) ;
         xDirection = new LDouble ( Math . random ( ) < .5 ? - 1 : - .5 ) ;
         }
         if ( Math . random ( ) < .5 ) {
         yAnchor = new LDouble ( Math . random ( ) < .5 ? 0 : - 1 ) ;
         yDirection = new LDouble ( Math . random ( ) < .5 ? 1 : .5 ) ;
         }
         else {
         yAnchor = new LDouble ( Math . random ( ) < .5 ? 0 : 1 ) ;
         yDirection = new LDouble ( Math . random ( ) < .5 ? - 1 : - .5 ) ;
         }
      }

      public BrushPositionPolicy evaluate(Context context, Object[] inputs) {

         return new SimpleBrushPositionPolicy ( xAnchor . val , yAnchor . val , xDirection . val , yDirection . val ) ;
      }

      public Class getReturnType() {
         return BrushPositionPolicy.class;
      }

   }

   public static class rotationPositionPolicy extends ExpressionFunction implements BrushPositionPolicy {
      private double m00 , m01 , m10 , m11 ;public double getX ( double x , double y , Canvas canvas ) { return ( .5 + x * m00 + y * m01 ) * canvas . getWidth ( ) ; }public double getY ( double x , double y , Canvas canvas ) { return ( .5 + x * m10 + y * m11 ) * canvas . getHeight ( ) ; }
      private LDouble theta;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return theta;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "theta";
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
            case 0: theta = (LDouble) value; return;
            default: return;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         m00 = Math . cos ( theta . val ) ;
         m01 = Math . sin ( theta . val ) ;
         m10 = - Math . sin ( theta . val ) ;
         m11 = Math . cos ( theta . val ) ;
      }

      public rotationPositionPolicy() {
         addGroupMeta(this);
         theta = new LDouble ( Math . random ( ) * 2 * Math . PI ) ;
      }

      public String getDescription() {
         return "This is a policy that treats zero as centered, but rotates the canvas direction an arbitrary amount";
      }

      public BrushPositionPolicy evaluate(Context context, Object[] inputs) {

         return this ;
      }

      public Class getReturnType() {
         return BrushPositionPolicy.class;
      }

   }

   public static class skewPositionPolicy extends ExpressionFunction implements BrushPositionPolicy {
      public double getX ( double x , double y , Canvas canvas ) { return ( .5 + x * m00 . val + y * m01 . val ) * canvas . getWidth ( ) ; }public double getY ( double x , double y , Canvas canvas ) { return ( .5 + x * m10 . val + y * m11 . val ) * canvas . getHeight ( ) ; }
      private LDouble theta;private LDouble m00;private LDouble m01;private LDouble m10;private LDouble m11;
      public int getNumberParameters() {
         return 5;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return theta;
            case 1: return m00;
            case 2: return m01;
            case 3: return m10;
            case 4: return m11;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "theta";
            case 1: return "m00";
            case 2: return "m01";
            case 3: return "m10";
            case 4: return "m11";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            case 4: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: theta = (LDouble) value; return;
            case 1: m00 = (LDouble) value; return;
            case 2: m01 = (LDouble) value; return;
            case 3: m10 = (LDouble) value; return;
            case 4: m11 = (LDouble) value; return;
            default: return;
         }

      }

      public skewPositionPolicy() {
         addGroupMeta(this);
         m00 = new LDouble ( 2 * Math . random ( ) - 1 ) ;
         m01 = new LDouble ( 2 * Math . random ( ) - 1 ) ;
         m10 = new LDouble ( 2 * Math . random ( ) - 1 ) ;
         m11 = new LDouble ( 2 * Math . random ( ) - 1 ) ;
      }

      public String getDescription() {
         return "This is a policy that creates an arbitrary skew";
      }

      public BrushPositionPolicy evaluate(Context context, Object[] inputs) {

         return this ;
      }

      public Class getReturnType() {
         return BrushPositionPolicy.class;
      }

   }

   public static class cyclePositionPolicy extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "policy";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            default: return null;
         }

      }

      public cyclePositionPolicy() {
         addGroupMeta(this);
      }

      public BrushPositionPolicy evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy policy = (BrushPositionPolicy)inputs[0];
         return new CycleBrushPositionPolicy ( policy ) ;
      }

      public Class getReturnType() {
         return BrushPositionPolicy.class;
      }

   }

   public static class simpleBrushSizePolicy extends ExpressionFunction {

      private LDouble xOffset;private LDouble yOffset;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return xOffset;
            case 1: return yOffset;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "xOffset";
            case 1: return "yOffset";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: xOffset = (LDouble) value; return;
            case 1: yOffset = (LDouble) value; return;
            default: return;
         }

      }

      public simpleBrushSizePolicy() {
         addGroupMeta(this);
         double xv = Math . random ( ) ;
         double yv = Math . random ( ) ;
         if ( xv < .33333 ) {
         xOffset = new LDouble ( 0 ) ;
         }
         else if ( xv < .66666 ) {
         xOffset = new LDouble ( .5 ) ;
         }
         else {
         xOffset = new LDouble ( 1 ) ;
         }
         if ( yv < .33333 ) {
         yOffset = new LDouble ( 0 ) ;
         }
         else if ( yv < .66666 ) {
         yOffset = new LDouble ( .5 ) ;
         }
         else {
         yOffset = new LDouble ( 1 ) ;
         }
      }

      public BrushSizePolicy evaluate(Context context, Object[] inputs) {

         return new SimpleBrushSizePolicy ( xOffset . val , yOffset . val ) ;
      }

      public Class getReturnType() {
         return BrushSizePolicy.class;
      }

   }

   public String getDescription() {
      return "expressions to generate brushes";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new simpleBrush1());
      r.add(new simpleBrush2());
      r.add(new simpleBrush3());
      r.add(new hollowCircleBrush());
      r.add(new ellipseBrush1());
      r.add(new ellipseBrushv());
      r.add(new hollowArcBrush1());
      r.add(new hollowArcBrush2());
      r.add(new hollowArcBrush3());
      r.add(new curvyBrush1());
      r.add(new curvyBrush2());
      r.add(new penBrush());
      r.add(new penBrush2());
      r.add(new sweepBrush2());
      r.add(new spatterBrush1());
      r.add(new spatterBrush2());
      r.add(new spatterBrush3());
      r.add(new multiBrush_2());
      r.add(new multiBrush_3());
      r.add(new multiBrush_4());
      r.add(new dashBrush1());
      r.add(new dashBrush2());
      r.add(new smudgeBrush1());
      r.add(new smudgeBrush2());
      r.add(new imageOpBrush());
      r.add(new rubberStampBrush1());
      r.add(new rubberStampBrush2());
      r.add(new rubberStampBrush3());
      r.add(new rubberStampBrush4());
      r.add(new simplePositionPolicy());
      r.add(new rotationPositionPolicy());
      r.add(new skewPositionPolicy());
      r.add(new cyclePositionPolicy());
      r.add(new simpleBrushSizePolicy());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
