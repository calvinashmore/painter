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

public final class ImageBrushes implements AllComponents<ExpressionFunction>, Described {

   public static class imageBrush_simple extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            case 2: return "image";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return BufferedImage.class;
            default: return null;
         }

      }

      public imageBrush_simple() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final BufferedImage image = (BufferedImage)inputs[2];
         return new ImageBrush ( image , positionPolicy , sizePolicy ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class imageBrush_simple_parameter1 extends ExpressionFunction {

      private Boolean round;private Boolean scaleImage;private Boolean stamp;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return round;
            case 1: return scaleImage;
            case 2: return stamp;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "round";
            case 1: return "scaleImage";
            case 2: return "stamp";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Boolean.class;
            case 1: return Boolean.class;
            case 2: return Boolean.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: round = (Boolean) value; return;
            case 1: scaleImage = (Boolean) value; return;
            case 2: stamp = (Boolean) value; return;
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
            case 2: return "image";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return BufferedImage.class;
            default: return null;
         }

      }

      public imageBrush_simple_parameter1() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         round = rand . nextBoolean ( ) ;
         scaleImage = rand . nextBoolean ( ) ;
         stamp = rand . nextBoolean ( ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final BufferedImage image = (BufferedImage)inputs[2];
         ImageBrush brush = new ImageBrush ( image , positionPolicy , sizePolicy ) ;
         brush . setRound ( round ) ;
         brush . setScaleImage ( scaleImage ) ;
         brush . setStamp ( stamp ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class imageBrush_xformed1 extends ExpressionFunction {

      private LDouble scale;private LDouble rotation;private LVect2d offset;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return scale;
            case 1: return rotation;
            case 2: return offset;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "scale";
            case 1: return "rotation";
            case 2: return "offset";
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
            case 0: scale = (LDouble) value; return;
            case 1: rotation = (LDouble) value; return;
            case 2: offset = (LVect2d) value; return;
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
            case 2: return "image";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return BufferedImage.class;
            default: return null;
         }

      }

      public imageBrush_xformed1() {
         addGroupMeta(this);
         scale = new LDouble ( .5 + 2 * Math . random ( ) ) ;
         rotation = new LDouble ( Math . PI * Math . random ( ) ) ;
         offset = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final BufferedImage image = (BufferedImage)inputs[2];
         ImageBrush brush = new ImageBrush ( image , positionPolicy , sizePolicy ) ;
         brush . setScale ( scale . val ) ;
         brush . setRotation ( rotation . val ) ;
         brush . setOffset ( offset . x , offset . y ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class imageBrush_xformed2 extends ExpressionFunction {

      private Boolean round;private Boolean scaleImage;private Boolean stamp;private LDouble scale;private LDouble rotation;private LVect2d offset;
      public int getNumberParameters() {
         return 6;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return round;
            case 1: return scaleImage;
            case 2: return stamp;
            case 3: return scale;
            case 4: return rotation;
            case 5: return offset;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "round";
            case 1: return "scaleImage";
            case 2: return "stamp";
            case 3: return "scale";
            case 4: return "rotation";
            case 5: return "offset";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Boolean.class;
            case 1: return Boolean.class;
            case 2: return Boolean.class;
            case 3: return LDouble.class;
            case 4: return LDouble.class;
            case 5: return LVect2d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: round = (Boolean) value; return;
            case 1: scaleImage = (Boolean) value; return;
            case 2: stamp = (Boolean) value; return;
            case 3: scale = (LDouble) value; return;
            case 4: rotation = (LDouble) value; return;
            case 5: offset = (LVect2d) value; return;
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
            case 2: return "image";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return BufferedImage.class;
            default: return null;
         }

      }

      public imageBrush_xformed2() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         round = rand . nextBoolean ( ) ;
         scaleImage = rand . nextBoolean ( ) ;
         stamp = rand . nextBoolean ( ) ;
         scale = new LDouble ( .5 + 2 * Math . random ( ) ) ;
         rotation = new LDouble ( Math . PI * Math . random ( ) ) ;
         offset = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final BufferedImage image = (BufferedImage)inputs[2];
         ImageBrush brush = new ImageBrush ( image , positionPolicy , sizePolicy ) ;
         brush . setRound ( round ) ;
         brush . setScaleImage ( scaleImage ) ;
         brush . setStamp ( stamp ) ;
         brush . setScale ( scale . val ) ;
         brush . setRotation ( rotation . val ) ;
         brush . setOffset ( offset . x , offset . y ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class imageBrush_op extends ExpressionFunction {

      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            case 2: return "image";
            case 3: return "op";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return BufferedImage.class;
            case 3: return BufferedImageOp.class;
            default: return null;
         }

      }

      public imageBrush_op() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final BufferedImage image = (BufferedImage)inputs[2];
         final BufferedImageOp op = (BufferedImageOp)inputs[3];
         ImageBrush brush = new ImageBrush ( image , positionPolicy , sizePolicy ) ;
         brush . setOp ( op ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class imageBrush_op_parameter extends ExpressionFunction {

      private Boolean round;private Boolean scaleImage;private Boolean stamp;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return round;
            case 1: return scaleImage;
            case 2: return stamp;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "round";
            case 1: return "scaleImage";
            case 2: return "stamp";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Boolean.class;
            case 1: return Boolean.class;
            case 2: return Boolean.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: round = (Boolean) value; return;
            case 1: scaleImage = (Boolean) value; return;
            case 2: stamp = (Boolean) value; return;
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
            case 2: return "image";
            case 3: return "op";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return BufferedImage.class;
            case 3: return BufferedImageOp.class;
            default: return null;
         }

      }

      public imageBrush_op_parameter() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         round = rand . nextBoolean ( ) ;
         scaleImage = rand . nextBoolean ( ) ;
         stamp = rand . nextBoolean ( ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final BufferedImage image = (BufferedImage)inputs[2];
         final BufferedImageOp op = (BufferedImageOp)inputs[3];
         ImageBrush brush = new ImageBrush ( image , positionPolicy , sizePolicy ) ;
         brush . setRound ( round ) ;
         brush . setScaleImage ( scaleImage ) ;
         brush . setStamp ( stamp ) ;
         brush . setOp ( op ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class imageBrush_xformed3 extends ExpressionFunction {

      private LDouble scale;private LDouble rotation;private LVect2d offset;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return scale;
            case 1: return rotation;
            case 2: return offset;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "scale";
            case 1: return "rotation";
            case 2: return "offset";
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
            case 0: scale = (LDouble) value; return;
            case 1: rotation = (LDouble) value; return;
            case 2: offset = (LVect2d) value; return;
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
            case 2: return "image";
            case 3: return "op";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return BufferedImage.class;
            case 3: return BufferedImageOp.class;
            default: return null;
         }

      }

      public imageBrush_xformed3() {
         addGroupMeta(this);
         scale = new LDouble ( .5 + 2 * Math . random ( ) ) ;
         rotation = new LDouble ( Math . PI * Math . random ( ) ) ;
         offset = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final BufferedImage image = (BufferedImage)inputs[2];
         final BufferedImageOp op = (BufferedImageOp)inputs[3];
         ImageBrush brush = new ImageBrush ( image , positionPolicy , sizePolicy ) ;
         brush . setScale ( scale . val ) ;
         brush . setRotation ( rotation . val ) ;
         brush . setOffset ( offset . x , offset . y ) ;
         brush . setOp ( op ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class imageBrush_xformed4 extends ExpressionFunction {

      private Boolean round;private Boolean scaleImage;private Boolean stamp;private LDouble scale;private LDouble rotation;private LVect2d offset;
      public int getNumberParameters() {
         return 6;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return round;
            case 1: return scaleImage;
            case 2: return stamp;
            case 3: return scale;
            case 4: return rotation;
            case 5: return offset;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "round";
            case 1: return "scaleImage";
            case 2: return "stamp";
            case 3: return "scale";
            case 4: return "rotation";
            case 5: return "offset";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Boolean.class;
            case 1: return Boolean.class;
            case 2: return Boolean.class;
            case 3: return LDouble.class;
            case 4: return LDouble.class;
            case 5: return LVect2d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: round = (Boolean) value; return;
            case 1: scaleImage = (Boolean) value; return;
            case 2: stamp = (Boolean) value; return;
            case 3: scale = (LDouble) value; return;
            case 4: rotation = (LDouble) value; return;
            case 5: offset = (LVect2d) value; return;
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
            case 2: return "image";
            case 3: return "op";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return BufferedImage.class;
            case 3: return BufferedImageOp.class;
            default: return null;
         }

      }

      public imageBrush_xformed4() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         round = rand . nextBoolean ( ) ;
         scaleImage = rand . nextBoolean ( ) ;
         stamp = rand . nextBoolean ( ) ;
         scale = new LDouble ( .5 + 2 * Math . random ( ) ) ;
         rotation = new LDouble ( Math . PI * Math . random ( ) ) ;
         offset = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final BufferedImage image = (BufferedImage)inputs[2];
         final BufferedImageOp op = (BufferedImageOp)inputs[3];
         ImageBrush brush = new ImageBrush ( image , positionPolicy , sizePolicy ) ;
         brush . setRound ( round ) ;
         brush . setScaleImage ( scaleImage ) ;
         brush . setStamp ( stamp ) ;
         brush . setScale ( scale . val ) ;
         brush . setRotation ( rotation . val ) ;
         brush . setOffset ( offset . x , offset . y ) ;
         brush . setOp ( op ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class imageBrush_inxform1 extends ExpressionFunction {

      private Boolean round;private Boolean scaleImage;private Boolean stamp;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return round;
            case 1: return scaleImage;
            case 2: return stamp;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "round";
            case 1: return "scaleImage";
            case 2: return "stamp";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Boolean.class;
            case 1: return Boolean.class;
            case 2: return Boolean.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: round = (Boolean) value; return;
            case 1: scaleImage = (Boolean) value; return;
            case 2: stamp = (Boolean) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 6;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            case 2: return "image";
            case 3: return "scale";
            case 4: return "rotation";
            case 5: return "offset";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return BufferedImage.class;
            case 3: return LDouble.class;
            case 4: return LDouble.class;
            case 5: return LVect2d.class;
            default: return null;
         }

      }

      public imageBrush_inxform1() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         round = rand . nextBoolean ( ) ;
         scaleImage = rand . nextBoolean ( ) ;
         stamp = rand . nextBoolean ( ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final BufferedImage image = (BufferedImage)inputs[2];
         final LDouble scale = (LDouble)inputs[3];
         final LDouble rotation = (LDouble)inputs[4];
         final LVect2d offset = (LVect2d)inputs[5];
         ImageBrush brush = new ImageBrush ( image , positionPolicy , sizePolicy ) ;
         brush . setRound ( round ) ;
         brush . setScaleImage ( scaleImage ) ;
         brush . setStamp ( stamp ) ;
         brush . setScale ( scale . val ) ;
         brush . setRotation ( rotation . val ) ;
         brush . setOffset ( offset . x , offset . y ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class imageBrush_inxform2 extends ExpressionFunction {

      private Boolean round;private Boolean scaleImage;private Boolean stamp;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return round;
            case 1: return scaleImage;
            case 2: return stamp;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "round";
            case 1: return "scaleImage";
            case 2: return "stamp";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Boolean.class;
            case 1: return Boolean.class;
            case 2: return Boolean.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: round = (Boolean) value; return;
            case 1: scaleImage = (Boolean) value; return;
            case 2: stamp = (Boolean) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 7;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            case 2: return "image";
            case 3: return "op";
            case 4: return "scale";
            case 5: return "rotation";
            case 6: return "offset";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return BufferedImage.class;
            case 3: return BufferedImageOp.class;
            case 4: return LDouble.class;
            case 5: return LDouble.class;
            case 6: return LVect2d.class;
            default: return null;
         }

      }

      public imageBrush_inxform2() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         round = rand . nextBoolean ( ) ;
         scaleImage = rand . nextBoolean ( ) ;
         stamp = rand . nextBoolean ( ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final BufferedImage image = (BufferedImage)inputs[2];
         final BufferedImageOp op = (BufferedImageOp)inputs[3];
         final LDouble scale = (LDouble)inputs[4];
         final LDouble rotation = (LDouble)inputs[5];
         final LVect2d offset = (LVect2d)inputs[6];
         ImageBrush brush = new ImageBrush ( image , positionPolicy , sizePolicy ) ;
         brush . setRound ( round ) ;
         brush . setScaleImage ( scaleImage ) ;
         brush . setStamp ( stamp ) ;
         brush . setScale ( scale . val ) ;
         brush . setRotation ( rotation . val ) ;
         brush . setOffset ( offset . x , offset . y ) ;
         brush . setOp ( op ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class imageBrush_inxform3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 9;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            case 2: return "image";
            case 3: return "round";
            case 4: return "scaleImage";
            case 5: return "stamp";
            case 6: return "scale";
            case 7: return "rotation";
            case 8: return "offset";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return BufferedImage.class;
            case 3: return Boolean.class;
            case 4: return Boolean.class;
            case 5: return Boolean.class;
            case 6: return LDouble.class;
            case 7: return LDouble.class;
            case 8: return LVect2d.class;
            default: return null;
         }

      }

      public imageBrush_inxform3() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final BufferedImage image = (BufferedImage)inputs[2];
         final Boolean round = (Boolean)inputs[3];
         final Boolean scaleImage = (Boolean)inputs[4];
         final Boolean stamp = (Boolean)inputs[5];
         final LDouble scale = (LDouble)inputs[6];
         final LDouble rotation = (LDouble)inputs[7];
         final LVect2d offset = (LVect2d)inputs[8];
         ImageBrush brush = new ImageBrush ( image , positionPolicy , sizePolicy ) ;
         brush . setRound ( round ) ;
         brush . setScaleImage ( scaleImage ) ;
         brush . setStamp ( stamp ) ;
         brush . setScale ( scale . val ) ;
         brush . setRotation ( rotation . val ) ;
         brush . setOffset ( offset . x , offset . y ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class imageBrush_inxform4 extends ExpressionFunction {

      public int getNumberInputs() {
         return 10;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "positionPolicy";
            case 1: return "sizePolicy";
            case 2: return "image";
            case 3: return "op";
            case 4: return "round";
            case 5: return "scaleImage";
            case 6: return "stamp";
            case 7: return "scale";
            case 8: return "rotation";
            case 9: return "offset";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BrushPositionPolicy.class;
            case 1: return BrushSizePolicy.class;
            case 2: return BufferedImage.class;
            case 3: return BufferedImageOp.class;
            case 4: return Boolean.class;
            case 5: return Boolean.class;
            case 6: return Boolean.class;
            case 7: return LDouble.class;
            case 8: return LDouble.class;
            case 9: return LVect2d.class;
            default: return null;
         }

      }

      public imageBrush_inxform4() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[0];
         final BrushSizePolicy sizePolicy = (BrushSizePolicy)inputs[1];
         final BufferedImage image = (BufferedImage)inputs[2];
         final BufferedImageOp op = (BufferedImageOp)inputs[3];
         final Boolean round = (Boolean)inputs[4];
         final Boolean scaleImage = (Boolean)inputs[5];
         final Boolean stamp = (Boolean)inputs[6];
         final LDouble scale = (LDouble)inputs[7];
         final LDouble rotation = (LDouble)inputs[8];
         final LVect2d offset = (LVect2d)inputs[9];
         ImageBrush brush = new ImageBrush ( image , positionPolicy , sizePolicy ) ;
         brush . setRound ( round ) ;
         brush . setScaleImage ( scaleImage ) ;
         brush . setStamp ( stamp ) ;
         brush . setScale ( scale . val ) ;
         brush . setRotation ( rotation . val ) ;
         brush . setOffset ( offset . x , offset . y ) ;
         brush . setOp ( op ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public String getDescription() {
      return "expressions to generate image brushes";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new imageBrush_simple());
      r.add(new imageBrush_simple_parameter1());
      r.add(new imageBrush_xformed1());
      r.add(new imageBrush_xformed2());
      r.add(new imageBrush_op());
      r.add(new imageBrush_op_parameter());
      r.add(new imageBrush_xformed3());
      r.add(new imageBrush_xformed4());
      r.add(new imageBrush_inxform1());
      r.add(new imageBrush_inxform2());
      r.add(new imageBrush_inxform3());
      r.add(new imageBrush_inxform4());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
