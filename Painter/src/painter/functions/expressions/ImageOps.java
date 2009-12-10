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

         LookupTable lookupTable = new LookupTable ( 0 , 4 ) {
         public int [ ] lookupPixel ( int [ ] src , int [ ] dst ) {
         if ( dst == null ) {
         dst = new int [ src . length ] ;
         }
         Color c = new Color ( src [ 0 ] / 255f , src [ 1 ] / 255f , src [ 2 ] / 255f ) ;
         double [ ] hsbvals = c . hsbvals ( ) ;
         hsbvals [ 0 ] += hueOffset . val ;
         c = Color . makeHSB ( hsbvals [ 0 ] , hsbvals [ 1 ] , hsbvals [ 2 ] ) ;
         float alpha = 1 ;
         if ( src . length >= 4 ) {
         dst [ 3 ] = src [ 3 ] ;
         alpha = src [ 3 ] / 255f ;
         }
         dst [ 0 ] = ( int ) ( 255 * c . r * alpha + ( 1 - alpha ) * src [ 0 ] ) ;
         dst [ 1 ] = ( int ) ( 255 * c . g * alpha + ( 1 - alpha ) * src [ 1 ] ) ;
         dst [ 2 ] = ( int ) ( 255 * c . b * alpha + ( 1 - alpha ) * src [ 2 ] ) ;
         return dst ;
         }
         }
         ;
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
         LookupTable lookupTable = new LookupTable ( 0 , 4 ) {
         public int [ ] lookupPixel ( int [ ] src , int [ ] dst ) {
         if ( dst == null ) {
         dst = new int [ src . length ] ;
         }
         Color c = new Color ( src [ 0 ] / 255f , src [ 1 ] / 255f , src [ 2 ] / 255f ) ;
         double [ ] hsbvals = c . hsbvals ( ) ;
         hsbvals [ 0 ] += hueOffset . val ;
         c = Color . makeHSB ( hsbvals [ 0 ] , hsbvals [ 1 ] , hsbvals [ 2 ] ) ;
         float alpha = 1 ;
         if ( src . length >= 4 ) {
         dst [ 3 ] = src [ 3 ] ;
         alpha = src [ 3 ] / 255f ;
         }
         dst [ 0 ] = ( int ) ( 255 * c . r * alpha + ( 1 - alpha ) * src [ 0 ] ) ;
         dst [ 1 ] = ( int ) ( 255 * c . g * alpha + ( 1 - alpha ) * src [ 1 ] ) ;
         dst [ 2 ] = ( int ) ( 255 * c . b * alpha + ( 1 - alpha ) * src [ 2 ] ) ;
         return dst ;
         }
         }
         ;
         return new LookupOp ( lookupTable , null ) ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class TransformSetHue1 extends ExpressionFunction {

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

      public TransformSetHue1() {
         addGroupMeta(this);
         hueOffset = new LDouble ( Math . random ( ) ) ;
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         LookupTable lookupTable = new LookupTable ( 0 , 4 ) {
         public int [ ] lookupPixel ( int [ ] src , int [ ] dst ) {
         if ( dst == null ) {
         dst = new int [ src . length ] ;
         }
         Color c = new Color ( src [ 0 ] / 255f , src [ 1 ] / 255f , src [ 2 ] / 255f ) ;
         double [ ] hsbvals = c . hsbvals ( ) ;
         hsbvals [ 0 ] = hueOffset . val ;
         c = Color . makeHSB ( hsbvals [ 0 ] , hsbvals [ 1 ] , hsbvals [ 2 ] ) ;
         float alpha = 1 ;
         if ( src . length >= 4 ) {
         dst [ 3 ] = src [ 3 ] ;
         alpha = src [ 3 ] / 255f ;
         }
         dst [ 0 ] = ( int ) ( 255 * c . r * alpha + ( 1 - alpha ) * src [ 0 ] ) ;
         dst [ 1 ] = ( int ) ( 255 * c . g * alpha + ( 1 - alpha ) * src [ 1 ] ) ;
         dst [ 2 ] = ( int ) ( 255 * c . b * alpha + ( 1 - alpha ) * src [ 2 ] ) ;
         return dst ;
         }
         }
         ;
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

      public TransformSetHue2() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {
         final LDouble hueOffset = (LDouble)inputs[0];
         LookupTable lookupTable = new LookupTable ( 0 , 4 ) {
         public int [ ] lookupPixel ( int [ ] src , int [ ] dst ) {
         if ( dst == null ) {
         dst = new int [ src . length ] ;
         }
         Color c = new Color ( src [ 0 ] / 255f , src [ 1 ] / 255f , src [ 2 ] / 255f ) ;
         double [ ] hsbvals = c . hsbvals ( ) ;
         hsbvals [ 0 ] = hueOffset . val ;
         c = Color . makeHSB ( hsbvals [ 0 ] , hsbvals [ 1 ] , hsbvals [ 2 ] ) ;
         float alpha = 1 ;
         if ( src . length >= 4 ) {
         dst [ 3 ] = src [ 3 ] ;
         alpha = src [ 3 ] / 255f ;
         }
         dst [ 0 ] = ( int ) ( 255 * c . r * alpha + ( 1 - alpha ) * src [ 0 ] ) ;
         dst [ 1 ] = ( int ) ( 255 * c . g * alpha + ( 1 - alpha ) * src [ 1 ] ) ;
         dst [ 2 ] = ( int ) ( 255 * c . b * alpha + ( 1 - alpha ) * src [ 2 ] ) ;
         return dst ;
         }
         }
         ;
         return new LookupOp ( lookupTable , null ) ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class TransformSetSaturation1 extends ExpressionFunction {

      private LDouble satOffset;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return satOffset;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "satOffset";
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
            case 0: satOffset = (LDouble) value; return;
            default: return;
         }

      }

      public TransformSetSaturation1() {
         addGroupMeta(this);
         satOffset = new LDouble ( Math . random ( ) ) ;
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         LookupTable lookupTable = new LookupTable ( 0 , 4 ) {
         public int [ ] lookupPixel ( int [ ] src , int [ ] dst ) {
         if ( dst == null ) {
         dst = new int [ src . length ] ;
         }
         Color c = new Color ( src [ 0 ] / 255f , src [ 1 ] / 255f , src [ 2 ] / 255f ) ;
         double [ ] hsbvals = c . hsbvals ( ) ;
         hsbvals [ 1 ] = satOffset . val ;
         c = Color . makeHSB ( hsbvals [ 0 ] , hsbvals [ 1 ] , hsbvals [ 2 ] ) ;
         float alpha = 1 ;
         if ( src . length >= 4 ) {
         dst [ 3 ] = src [ 3 ] ;
         alpha = src [ 3 ] / 255f ;
         }
         dst [ 0 ] = ( int ) ( 255 * c . r * alpha + ( 1 - alpha ) * src [ 0 ] ) ;
         dst [ 1 ] = ( int ) ( 255 * c . g * alpha + ( 1 - alpha ) * src [ 1 ] ) ;
         dst [ 2 ] = ( int ) ( 255 * c . b * alpha + ( 1 - alpha ) * src [ 2 ] ) ;
         return dst ;
         }
         }
         ;
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
            case 0: return "satOffset";
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
         final LDouble satOffset = (LDouble)inputs[0];
         LookupTable lookupTable = new LookupTable ( 0 , 4 ) {
         public int [ ] lookupPixel ( int [ ] src , int [ ] dst ) {
         if ( dst == null ) {
         dst = new int [ src . length ] ;
         }
         Color c = new Color ( src [ 0 ] / 255f , src [ 1 ] / 255f , src [ 2 ] / 255f ) ;
         double [ ] hsbvals = c . hsbvals ( ) ;
         hsbvals [ 0 ] = satOffset . val ;
         c = Color . makeHSB ( hsbvals [ 0 ] , hsbvals [ 1 ] , hsbvals [ 2 ] ) ;
         float alpha = 1 ;
         if ( src . length >= 4 ) {
         dst [ 3 ] = src [ 3 ] ;
         alpha = src [ 3 ] / 255f ;
         }
         dst [ 0 ] = ( int ) ( 255 * c . r * alpha + ( 1 - alpha ) * src [ 0 ] ) ;
         dst [ 1 ] = ( int ) ( 255 * c . g * alpha + ( 1 - alpha ) * src [ 1 ] ) ;
         dst [ 2 ] = ( int ) ( 255 * c . b * alpha + ( 1 - alpha ) * src [ 2 ] ) ;
         return dst ;
         }
         }
         ;
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
