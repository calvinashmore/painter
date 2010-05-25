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
import painter.tools.misc.*;
import painter.tools.canvas.*;
import painter.tools.imageop.*;

public final class CustomImageOps implements AllComponents<ExpressionFunction>, Described {

   public static class Mosaic1 extends ExpressionFunction {

      private LDouble tileSize;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return tileSize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "tileSize";
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
            case 0: tileSize = (LDouble) value; return;
            default: return;
         }

      }

      public Mosaic1() {
         addGroupMeta(this);
         addMeta("selectionWeight", 3);
         tileSize = new LDouble ( .01 * Math . random ( ) + .005 ) ;
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         int iTileSize = ( int ) Math . abs ( tileSize . val * canvas . getHeight ( ) ) ;
         return new MosaicFilter ( iTileSize ) ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class Mosaic2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "tileSize";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public Mosaic2() {
         addGroupMeta(this);
         addMeta("selectionWeight", 3);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {
         final LDouble tileSize = (LDouble)inputs[0];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         int iTileSize = ( int ) Math . abs ( tileSize . val * canvas . getHeight ( ) ) ;
         if ( iTileSize <= 1 ) iTileSize = 3 ;
         if ( iTileSize >= canvas . getHeight ( ) / 5 ) iTileSize = canvas . getHeight ( ) / 10 ;
         return new MosaicFilter ( iTileSize ) ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class Mosaic3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "tileSize";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Integer.class;
            default: return null;
         }

      }

      public Mosaic3() {
         addGroupMeta(this);
         addMeta("selectionWeight", 3);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {
         final Integer tileSize = (Integer)inputs[0];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         int iTileSize = tileSize ;
         if ( iTileSize <= 1 ) iTileSize = 3 ;
         if ( iTileSize >= canvas . getHeight ( ) / 5 ) iTileSize = canvas . getHeight ( ) / 10 ;
         return new MosaicFilter ( iTileSize ) ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class smooth_boxBlur extends ExpressionFunction {

      private Integer xSize;private Integer ySize;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return xSize;
            case 1: return ySize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "xSize";
            case 1: return "ySize";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: xSize = (Integer) value; return;
            case 1: ySize = (Integer) value; return;
            default: return;
         }

      }

      public smooth_boxBlur() {
         addGroupMeta(this);
         addMeta("selectionWeight", 3);
         xSize = ( int ) ( 5 + 40 * Math . random ( ) * Math . random ( ) ) ;
         ySize = ( int ) ( 5 + 40 * Math . random ( ) * Math . random ( ) ) ;
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         Kernel kernel = new KernelGenerator ( ) {
         public double getValue ( double x , double y ) {
         return 1 ;
         }
         }
         . createKernel ( xSize , ySize ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class smooth_cosRipple1 extends ExpressionFunction {

      private Integer xSize;private Integer ySize;private LDouble xScale;private LDouble yScale;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return xSize;
            case 1: return ySize;
            case 2: return xScale;
            case 3: return yScale;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "xSize";
            case 1: return "ySize";
            case 2: return "xScale";
            case 3: return "yScale";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return Integer.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: xSize = (Integer) value; return;
            case 1: ySize = (Integer) value; return;
            case 2: xScale = (LDouble) value; return;
            case 3: yScale = (LDouble) value; return;
            default: return;
         }

      }

      public smooth_cosRipple1() {
         addGroupMeta(this);
         addMeta("selectionWeight", 3);
         xSize = ( int ) ( 5 + 40 * Math . random ( ) * Math . random ( ) ) ;
         ySize = ( int ) ( 5 + 40 * Math . random ( ) * Math . random ( ) ) ;
         xScale = new LDouble ( ( 3 - 6 * Math . random ( ) ) * Math . PI ) ;
         yScale = new LDouble ( ( 3 - 6 * Math . random ( ) ) * Math . PI ) ;
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         Kernel kernel = new KernelGenerator ( ) {
         public double getValue ( double x , double y ) {
         return Math . cos ( xScale . val * x + yScale . val * y ) ;
         }
         }
         . createKernel ( xSize , ySize ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class smooth_cosRipple2 extends ExpressionFunction {

      private Integer xSize;private Integer ySize;private LDouble xScale;private LDouble yScale;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return xSize;
            case 1: return ySize;
            case 2: return xScale;
            case 3: return yScale;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "xSize";
            case 1: return "ySize";
            case 2: return "xScale";
            case 3: return "yScale";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return Integer.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: xSize = (Integer) value; return;
            case 1: ySize = (Integer) value; return;
            case 2: xScale = (LDouble) value; return;
            case 3: yScale = (LDouble) value; return;
            default: return;
         }

      }

      public smooth_cosRipple2() {
         addGroupMeta(this);
         addMeta("selectionWeight", 3);
         xSize = ( int ) ( 5 + 40 * Math . random ( ) * Math . random ( ) ) ;
         ySize = ( int ) ( 5 + 40 * Math . random ( ) * Math . random ( ) ) ;
         xScale = new LDouble ( ( 3 - 6 * Math . random ( ) ) * Math . PI ) ;
         yScale = new LDouble ( ( 3 - 6 * Math . random ( ) ) * Math . PI ) ;
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         Kernel kernel = new KernelGenerator ( ) {
         public double getValue ( double x , double y ) {
         return Math . cos ( xScale . val * x ) * Math . cos ( yScale . val * y ) ;
         }
         }
         . createKernel ( xSize , ySize ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class smooth_sinRipple1 extends ExpressionFunction {

      private Integer xSize;private Integer ySize;private LDouble xScale;private LDouble yScale;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return xSize;
            case 1: return ySize;
            case 2: return xScale;
            case 3: return yScale;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "xSize";
            case 1: return "ySize";
            case 2: return "xScale";
            case 3: return "yScale";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return Integer.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: xSize = (Integer) value; return;
            case 1: ySize = (Integer) value; return;
            case 2: xScale = (LDouble) value; return;
            case 3: yScale = (LDouble) value; return;
            default: return;
         }

      }

      public smooth_sinRipple1() {
         addGroupMeta(this);
         addMeta("selectionWeight", 3);
         xSize = ( int ) ( 5 + 40 * Math . random ( ) * Math . random ( ) ) ;
         ySize = ( int ) ( 5 + 40 * Math . random ( ) * Math . random ( ) ) ;
         xScale = new LDouble ( ( 3 - 6 * Math . random ( ) ) * Math . PI ) ;
         yScale = new LDouble ( ( 3 - 6 * Math . random ( ) ) * Math . PI ) ;
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         Kernel kernel = new KernelGenerator ( ) {
         public double getValue ( double x , double y ) {
         return Math . sin ( xScale . val * x + yScale . val * y ) ;
         }
         }
         . createKernel ( xSize , ySize ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class smooth_sinRipple2 extends ExpressionFunction {

      private Integer xSize;private Integer ySize;private LDouble xScale;private LDouble yScale;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return xSize;
            case 1: return ySize;
            case 2: return xScale;
            case 3: return yScale;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "xSize";
            case 1: return "ySize";
            case 2: return "xScale";
            case 3: return "yScale";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return Integer.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: xSize = (Integer) value; return;
            case 1: ySize = (Integer) value; return;
            case 2: xScale = (LDouble) value; return;
            case 3: yScale = (LDouble) value; return;
            default: return;
         }

      }

      public smooth_sinRipple2() {
         addGroupMeta(this);
         addMeta("selectionWeight", 3);
         xSize = ( int ) ( 5 + 40 * Math . random ( ) * Math . random ( ) ) ;
         ySize = ( int ) ( 5 + 40 * Math . random ( ) * Math . random ( ) ) ;
         xScale = new LDouble ( ( 3 - 6 * Math . random ( ) ) * Math . PI ) ;
         yScale = new LDouble ( ( 3 - 6 * Math . random ( ) ) * Math . PI ) ;
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         Kernel kernel = new KernelGenerator ( ) {
         public double getValue ( double x , double y ) {
         return Math . sin ( xScale . val * x ) * Math . sin ( yScale . val * y ) ;
         }
         }
         . createKernel ( xSize , ySize ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class smooth_simpleXBoxBlur extends ExpressionFunction {

      private Integer xSize;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return xSize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "xSize";
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
            case 0: xSize = (Integer) value; return;
            default: return;
         }

      }

      public smooth_simpleXBoxBlur() {
         addGroupMeta(this);
         addMeta("selectionWeight", 3);
         xSize = ( int ) ( 5 + 40 * Math . random ( ) * Math . random ( ) ) ;
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         Kernel kernel = new KernelGenerator ( ) {
         public double getValue ( double x , double y ) {
         return 1 ;
         }
         }
         . createKernel ( xSize , 1 ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class smooth_simpleYBoxBlur extends ExpressionFunction {

      private Integer ySize;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return ySize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "ySize";
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
            case 0: ySize = (Integer) value; return;
            default: return;
         }

      }

      public smooth_simpleYBoxBlur() {
         addGroupMeta(this);
         addMeta("selectionWeight", 3);
         ySize = ( int ) ( 5 + 40 * Math . random ( ) * Math . random ( ) ) ;
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         Kernel kernel = new KernelGenerator ( ) {
         public double getValue ( double x , double y ) {
         return 1 ;
         }
         }
         . createKernel ( ySize , 1 ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class smooth_simpleXEdge extends ExpressionFunction {

      private Integer xSize;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return xSize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "xSize";
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
            case 0: xSize = (Integer) value; return;
            default: return;
         }

      }

      public smooth_simpleXEdge() {
         addGroupMeta(this);
         addMeta("selectionWeight", 3);
         xSize = ( int ) ( 5 + 40 * Math . random ( ) * Math . random ( ) ) ;
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         Kernel kernel = new KernelGenerator ( ) {
         public double getValue ( double x , double y ) {
         return x ;
         }
         }
         . createKernel ( xSize , 1 ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class smooth_simpleYEdge extends ExpressionFunction {

      private Integer ySize;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return ySize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "ySize";
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
            case 0: ySize = (Integer) value; return;
            default: return;
         }

      }

      public smooth_simpleYEdge() {
         addGroupMeta(this);
         addMeta("selectionWeight", 3);
         ySize = ( int ) ( 5 + 40 * Math . random ( ) * Math . random ( ) ) ;
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         Kernel kernel = new KernelGenerator ( ) {
         public double getValue ( double x , double y ) {
         return y ;
         }
         }
         . createKernel ( ySize , 1 ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class smooth_edge extends ExpressionFunction {

      private Integer xSize;private Integer ySize;private LDouble angle;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return xSize;
            case 1: return ySize;
            case 2: return angle;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "xSize";
            case 1: return "ySize";
            case 2: return "angle";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return Integer.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: xSize = (Integer) value; return;
            case 1: ySize = (Integer) value; return;
            case 2: angle = (LDouble) value; return;
            default: return;
         }

      }

      public smooth_edge() {
         addGroupMeta(this);
         addMeta("selectionWeight", 3);
         xSize = ( int ) ( 5 + 40 * Math . random ( ) * Math . random ( ) ) ;
         ySize = ( int ) ( 5 + 40 * Math . random ( ) * Math . random ( ) ) ;
         angle = new LDouble ( 2 * Math . random ( ) * Math . PI ) ;
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         Kernel kernel = new KernelGenerator ( ) {
         public double getValue ( double x , double y ) {
         return x * Math . cos ( angle . val ) + y * Math . sin ( angle . val ) ;
         }
         }
         . createKernel ( xSize , ySize ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class smooth_invertEdge extends ExpressionFunction {

      private Integer xSize;private Integer ySize;private LDouble angle;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return xSize;
            case 1: return ySize;
            case 2: return angle;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "xSize";
            case 1: return "ySize";
            case 2: return "angle";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return Integer.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: xSize = (Integer) value; return;
            case 1: ySize = (Integer) value; return;
            case 2: angle = (LDouble) value; return;
            default: return;
         }

      }

      public smooth_invertEdge() {
         addGroupMeta(this);
         addMeta("selectionWeight", 3);
         xSize = ( int ) ( 5 + 40 * Math . random ( ) * Math . random ( ) ) ;
         ySize = ( int ) ( 5 + 40 * Math . random ( ) * Math . random ( ) ) ;
         angle = new LDouble ( 2 * Math . random ( ) * Math . PI ) ;
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         Kernel kernel = new KernelGenerator ( ) {
         public double getValue ( double x , double y ) {
         return 1.0 / ( x * Math . cos ( angle . val ) + y * Math . sin ( angle . val ) ) ;
         }
         }
         . createKernel ( xSize , ySize ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public String getDescription() {
      return "expressions for custom image operations";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new Mosaic1());
      r.add(new Mosaic2());
      r.add(new Mosaic3());
      r.add(new smooth_boxBlur());
      r.add(new smooth_cosRipple1());
      r.add(new smooth_cosRipple2());
      r.add(new smooth_sinRipple1());
      r.add(new smooth_sinRipple2());
      r.add(new smooth_simpleXBoxBlur());
      r.add(new smooth_simpleYBoxBlur());
      r.add(new smooth_simpleXEdge());
      r.add(new smooth_simpleYEdge());
      r.add(new smooth_edge());
      r.add(new smooth_invertEdge());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
