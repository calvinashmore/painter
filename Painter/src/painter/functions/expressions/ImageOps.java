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

public final class ImageOps implements AllComponents<ExpressionFunction>, Described {

   public static class BoxBlur extends ExpressionFunction {

      public BoxBlur() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         float v = 1.0f / 9 ;
         float [ ] matrix = new float [ ] {
         v , v , v , v , v , v , v , v , v }
         ;
         Kernel kernel = new Kernel ( 3 , 3 , matrix ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class CrossBlur extends ExpressionFunction {

      public CrossBlur() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         float v = 1.0f / 5 ;
         float [ ] matrix = new float [ ] {
         0 , v , 0 , v , v , v , 0 , v , 0 }
         ;
         Kernel kernel = new Kernel ( 3 , 3 , matrix ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class XBlur extends ExpressionFunction {

      public XBlur() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         float v = 1.0f / 5 ;
         float [ ] matrix = new float [ ] {
         v , 0 , v , 0 , v , 0 , v , 0 , v }
         ;
         Kernel kernel = new Kernel ( 3 , 3 , matrix ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class VBlur extends ExpressionFunction {

      public VBlur() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         float v = 1.0f / 3 ;
         float [ ] matrix = new float [ ] {
         0 , v , 0 , 0 , v , 0 , 0 , v , 0 }
         ;
         Kernel kernel = new Kernel ( 3 , 3 , matrix ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class HBlur extends ExpressionFunction {

      public HBlur() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         float v = 1.0f / 3 ;
         float [ ] matrix = new float [ ] {
         0 , 0 , 0 , v , v , v , 0 , 0 , 0 }
         ;
         Kernel kernel = new Kernel ( 3 , 3 , matrix ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class CrossSharpen extends ExpressionFunction {

      public CrossSharpen() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         float v = 1.0f / 5 ;
         float [ ] matrix = new float [ ] {
         0 , - v , 0 , - v , 1 + 4 * v , - v , 0 , - v , 0 }
         ;
         Kernel kernel = new Kernel ( 3 , 3 , matrix ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class BoxSharpen1 extends ExpressionFunction {

      public BoxSharpen1() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         float v = 1.0f / 5 ;
         float [ ] matrix = new float [ ] {
         - v , - v , - v , - v , 1 + 9 * v , - v , - v , - v , - v }
         ;
         Kernel kernel = new Kernel ( 3 , 3 , matrix ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class BoxSharpen2 extends ExpressionFunction {

      public BoxSharpen2() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         float v = 1.0f / 5 ;
         float [ ] matrix = new float [ ] {
         - .5f * v , - v , - 0.5f * v , - v , 1 + 6 * v , - v , - 0.5f * v , - v , - 0.5f * v }
         ;
         Kernel kernel = new Kernel ( 3 , 3 , matrix ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class FindEdgesV1 extends ExpressionFunction {

      public FindEdgesV1() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         float v = 1.0f / 3 ;
         float [ ] matrix = new float [ ] {
         0 , 0 , 0 , - v , 1 + 2 * v , - v , 0 , 0 , 0 }
         ;
         Kernel kernel = new Kernel ( 3 , 3 , matrix ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class FindEdgesV2 extends ExpressionFunction {

      public FindEdgesV2() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         float v = 1.0f / 3 ;
         float [ ] matrix = new float [ ] {
         0 , v , 0 , - v , 1 , - v , 0 , v , 0 }
         ;
         Kernel kernel = new Kernel ( 3 , 3 , matrix ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class FindEdgesH1 extends ExpressionFunction {

      public FindEdgesH1() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         float v = 1.0f / 3 ;
         float [ ] matrix = new float [ ] {
         0 , - v , 0 , 0 , 1 + 2 * v , 0 , 0 , - v , 0 }
         ;
         Kernel kernel = new Kernel ( 3 , 3 , matrix ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class FindEdgesH2 extends ExpressionFunction {

      public FindEdgesH2() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         float v = 1.0f / 3 ;
         float [ ] matrix = new float [ ] {
         0 , - v , 0 , v , 1 , v , 0 , - v , 0 }
         ;
         Kernel kernel = new Kernel ( 3 , 3 , matrix ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class FindEdgesZig1 extends ExpressionFunction {

      public FindEdgesZig1() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         float v = 1.0f / 3 ;
         float [ ] matrix = new float [ ] {
         - v , 0 , 0 , 0 , 1 + 2 * v , 0 , 0 , 0 , - v }
         ;
         Kernel kernel = new Kernel ( 3 , 3 , matrix ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class FindEdgesZig2 extends ExpressionFunction {

      public FindEdgesZig2() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         float v = 1.0f / 3 ;
         float [ ] matrix = new float [ ] {
         - v , 0 , v , 0 , 1 , 0 , v , 0 , - v }
         ;
         Kernel kernel = new Kernel ( 3 , 3 , matrix ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class FindEdgesZag1 extends ExpressionFunction {

      public FindEdgesZag1() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         float v = 1.0f / 3 ;
         float [ ] matrix = new float [ ] {
         0 , 0 , - v , 0 , 1 + 2 * v , 0 , - v , 0 , 0 }
         ;
         Kernel kernel = new Kernel ( 3 , 3 , matrix ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class FindEdgesZag2 extends ExpressionFunction {

      public FindEdgesZag2() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         float v = 1.0f / 3 ;
         float [ ] matrix = new float [ ] {
         v , 0 , - v , 0 , 1 , 0 , - v , 0 , v }
         ;
         Kernel kernel = new Kernel ( 3 , 3 , matrix ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class Blurry1 extends ExpressionFunction {

      public int getNumberInputs() {
         return 9;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v00";
            case 1: return "v01";
            case 2: return "v02";
            case 3: return "v10";
            case 4: return "v11";
            case 5: return "v12";
            case 6: return "v20";
            case 7: return "v21";
            case 8: return "v22";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            case 4: return LDouble.class;
            case 5: return LDouble.class;
            case 6: return LDouble.class;
            case 7: return LDouble.class;
            case 8: return LDouble.class;
            default: return null;
         }

      }

      public Blurry1() {
         addGroupMeta(this);
      }

      public String getDescription() {
         return "this takes 9 inputs for the convolution, uses their absolute values, averages them so the output weight is 1, and uses the result";
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {
         final LDouble v00 = (LDouble)inputs[0];
         final LDouble v01 = (LDouble)inputs[1];
         final LDouble v02 = (LDouble)inputs[2];
         final LDouble v10 = (LDouble)inputs[3];
         final LDouble v11 = (LDouble)inputs[4];
         final LDouble v12 = (LDouble)inputs[5];
         final LDouble v20 = (LDouble)inputs[6];
         final LDouble v21 = (LDouble)inputs[7];
         final LDouble v22 = (LDouble)inputs[8];
         float m00 = ( float ) Math . abs ( v00 . val ) ;
         float m01 = ( float ) Math . abs ( v01 . val ) ;
         float m02 = ( float ) Math . abs ( v02 . val ) ;
         float m10 = ( float ) Math . abs ( v10 . val ) ;
         float m11 = ( float ) Math . abs ( v11 . val ) ;
         float m12 = ( float ) Math . abs ( v12 . val ) ;
         float m20 = ( float ) Math . abs ( v20 . val ) ;
         float m21 = ( float ) Math . abs ( v21 . val ) ;
         float m22 = ( float ) Math . abs ( v22 . val ) ;
         float sum = m00 + m01 + m02 + m10 + m11 + m12 + m20 + m21 + m22 ;
         float [ ] matrix = new float [ ] {
         m00 / sum , m01 / sum , m02 / sum , m10 / sum , m11 / sum , m12 / sum , m20 / sum , m21 / sum , m22 / sum , }
         ;
         Kernel kernel = new Kernel ( 3 , 3 , matrix ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class Blurry2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v1";
            case 1: return "v2";
            case 2: return "v3";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Blurry2() {
         addGroupMeta(this);
      }

      public String getDescription() {
         return "this takes 3 LVect3d inputs for the convolution, uses their absolute values, averages them so the output weight is 1, and uses the result";
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {
         final LVect3d v1 = (LVect3d)inputs[0];
         final LVect3d v2 = (LVect3d)inputs[1];
         final LVect3d v3 = (LVect3d)inputs[2];
         float m00 = ( float ) Math . abs ( v1 . x ) ;
         float m01 = ( float ) Math . abs ( v1 . y ) ;
         float m02 = ( float ) Math . abs ( v1 . z ) ;
         float m10 = ( float ) Math . abs ( v2 . x ) ;
         float m11 = ( float ) Math . abs ( v2 . y ) ;
         float m12 = ( float ) Math . abs ( v2 . z ) ;
         float m20 = ( float ) Math . abs ( v3 . x ) ;
         float m21 = ( float ) Math . abs ( v3 . y ) ;
         float m22 = ( float ) Math . abs ( v3 . z ) ;
         float sum = m00 + m01 + m02 + m10 + m11 + m12 + m20 + m21 + m22 ;
         float [ ] matrix = new float [ ] {
         m00 / sum , m01 / sum , m02 / sum , m10 / sum , m11 / sum , m12 / sum , m20 / sum , m21 / sum , m22 / sum , }
         ;
         Kernel kernel = new Kernel ( 3 , 3 , matrix ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class Sharpy1 extends ExpressionFunction {

      public int getNumberInputs() {
         return 9;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v00";
            case 1: return "v01";
            case 2: return "v02";
            case 3: return "v10";
            case 4: return "v11";
            case 5: return "v12";
            case 6: return "v20";
            case 7: return "v21";
            case 8: return "v22";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            case 4: return LDouble.class;
            case 5: return LDouble.class;
            case 6: return LDouble.class;
            case 7: return LDouble.class;
            case 8: return LDouble.class;
            default: return null;
         }

      }

      public Sharpy1() {
         addGroupMeta(this);
      }

      public String getDescription() {
         return "This takes 9 inputs and uses the average of their sum without taking the absolute value";
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {
         final LDouble v00 = (LDouble)inputs[0];
         final LDouble v01 = (LDouble)inputs[1];
         final LDouble v02 = (LDouble)inputs[2];
         final LDouble v10 = (LDouble)inputs[3];
         final LDouble v11 = (LDouble)inputs[4];
         final LDouble v12 = (LDouble)inputs[5];
         final LDouble v20 = (LDouble)inputs[6];
         final LDouble v21 = (LDouble)inputs[7];
         final LDouble v22 = (LDouble)inputs[8];
         float m00 = ( float ) v00 . val ;
         float m01 = ( float ) v01 . val ;
         float m02 = ( float ) v02 . val ;
         float m10 = ( float ) v10 . val ;
         float m11 = ( float ) v11 . val ;
         float m12 = ( float ) v12 . val ;
         float m20 = ( float ) v20 . val ;
         float m21 = ( float ) v21 . val ;
         float m22 = ( float ) v22 . val ;
         float sum = m00 + m01 + m02 + m10 + m11 + m12 + m20 + m21 + m22 ;
         float [ ] matrix = new float [ ] {
         m00 / sum , m01 / sum , m02 / sum , m10 / sum , m11 / sum , m12 / sum , m20 / sum , m21 / sum , m22 / sum , }
         ;
         Kernel kernel = new Kernel ( 3 , 3 , matrix ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class Sharpy2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v1";
            case 1: return "v2";
            case 2: return "v3";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Sharpy2() {
         addGroupMeta(this);
      }

      public String getDescription() {
         return "this takes 3 LVect3d inputs and uses the average of their sum without taking the absolute value";
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {
         final LVect3d v1 = (LVect3d)inputs[0];
         final LVect3d v2 = (LVect3d)inputs[1];
         final LVect3d v3 = (LVect3d)inputs[2];
         float m00 = ( float ) v1 . x ;
         float m01 = ( float ) v1 . y ;
         float m02 = ( float ) v1 . z ;
         float m10 = ( float ) v2 . x ;
         float m11 = ( float ) v2 . y ;
         float m12 = ( float ) v2 . z ;
         float m20 = ( float ) v3 . x ;
         float m21 = ( float ) v3 . y ;
         float m22 = ( float ) v3 . z ;
         float sum = m00 + m01 + m02 + m10 + m11 + m12 + m20 + m21 + m22 ;
         float [ ] matrix = new float [ ] {
         m00 / sum , m01 / sum , m02 / sum , m10 / sum , m11 / sum , m12 / sum , m20 / sum , m21 / sum , m22 / sum , }
         ;
         Kernel kernel = new Kernel ( 3 , 3 , matrix ) ;
         ConvolveOp op = new ConvolveOp ( kernel ) ;
         return op ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class TransformHueOffset1 extends ExpressionFunction {

      private LDouble hueOffset;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return hueOffset;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "hueOffset";
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
            case 0: hueOffset = (LDouble) value; return;
            default: return;
         }

      }

      public TransformHueOffset1() {
         addGroupMeta(this);
         hueOffset = new LDouble ( Math . random ( ) ) ;
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         LookupTable lookupTable = new ColorTransformer ( ) {
         public void transformPixel ( int [ ] src , int [ ] dst ) {
         double [ ] hsbvals = toHSB ( src ) ;
         hsbvals [ 0 ] += hueOffset . val ;
         toRGB ( hsbvals , dst ) ;
         }
         }
         . createLookup ( ) ;
         return new LookupOp ( lookupTable , null ) ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class TransformHueOffset2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hueOffset";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public TransformHueOffset2() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {
         final LDouble hueOffset = (LDouble)inputs[0];
         LookupTable lookupTable = new ColorTransformer ( ) {
         public void transformPixel ( int [ ] src , int [ ] dst ) {
         double [ ] hsbvals = toHSB ( src ) ;
         hsbvals [ 0 ] += hueOffset . val ;
         toRGB ( hsbvals , dst ) ;
         }
         }
         . createLookup ( ) ;
         return new LookupOp ( lookupTable , null ) ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class TransformSetHue1 extends ExpressionFunction {

      private LDouble hueSet;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return hueSet;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "hueSet";
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
            case 0: hueSet = (LDouble) value; return;
            default: return;
         }

      }

      public TransformSetHue1() {
         addGroupMeta(this);
         hueSet = new LDouble ( Math . random ( ) ) ;
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         LookupTable lookupTable = new ColorTransformer ( ) {
         public void transformPixel ( int [ ] src , int [ ] dst ) {
         double [ ] hsbvals = toHSB ( src ) ;
         hsbvals [ 0 ] = hueSet . val ;
         toRGB ( hsbvals , dst ) ;
         }
         }
         . createLookup ( ) ;
         return new LookupOp ( lookupTable , null ) ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class TransformSetHue2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hueSet";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public TransformSetHue2() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {
         final LDouble hueSet = (LDouble)inputs[0];
         LookupTable lookupTable = new ColorTransformer ( ) {
         public void transformPixel ( int [ ] src , int [ ] dst ) {
         double [ ] hsbvals = toHSB ( src ) ;
         hsbvals [ 0 ] = hueSet . val ;
         toRGB ( hsbvals , dst ) ;
         }
         }
         . createLookup ( ) ;
         return new LookupOp ( lookupTable , null ) ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class TransformSetSaturation1 extends ExpressionFunction {

      private LDouble satSet;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return satSet;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "satSet";
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
            case 0: satSet = (LDouble) value; return;
            default: return;
         }

      }

      public TransformSetSaturation1() {
         addGroupMeta(this);
         satSet = new LDouble ( Math . random ( ) ) ;
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         LookupTable lookupTable = new ColorTransformer ( ) {
         public void transformPixel ( int [ ] src , int [ ] dst ) {
         double [ ] hsbvals = toHSB ( src ) ;
         hsbvals [ 0 ] = satSet . val ;
         toRGB ( hsbvals , dst ) ;
         }
         }
         . createLookup ( ) ;
         return new LookupOp ( lookupTable , null ) ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class TransformSetSaturation2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "satSet";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public TransformSetSaturation2() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {
         final LDouble satSet = (LDouble)inputs[0];
         LookupTable lookupTable = new ColorTransformer ( ) {
         public void transformPixel ( int [ ] src , int [ ] dst ) {
         double [ ] hsbvals = toHSB ( src ) ;
         hsbvals [ 0 ] = satSet . val ;
         toRGB ( hsbvals , dst ) ;
         }
         }
         . createLookup ( ) ;
         return new LookupOp ( lookupTable , null ) ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public String getDescription() {
      return "expressions for image operations";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new BoxBlur());
      r.add(new CrossBlur());
      r.add(new XBlur());
      r.add(new VBlur());
      r.add(new HBlur());
      r.add(new CrossSharpen());
      r.add(new BoxSharpen1());
      r.add(new BoxSharpen2());
      r.add(new FindEdgesV1());
      r.add(new FindEdgesV2());
      r.add(new FindEdgesH1());
      r.add(new FindEdgesH2());
      r.add(new FindEdgesZig1());
      r.add(new FindEdgesZig2());
      r.add(new FindEdgesZag1());
      r.add(new FindEdgesZag2());
      r.add(new Blurry1());
      r.add(new Blurry2());
      r.add(new Sharpy1());
      r.add(new Sharpy2());
      r.add(new TransformHueOffset1());
      r.add(new TransformHueOffset2());
      r.add(new TransformSetHue1());
      r.add(new TransformSetHue2());
      r.add(new TransformSetSaturation1());
      r.add(new TransformSetSaturation2());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
