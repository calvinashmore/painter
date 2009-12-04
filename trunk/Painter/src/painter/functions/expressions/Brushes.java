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
      r.add(new penBrush());
      r.add(new penBrush2());
      r.add(new sweepBrush2());
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
