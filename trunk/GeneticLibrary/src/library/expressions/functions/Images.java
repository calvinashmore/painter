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
import utils.linear.grid.*;
import java.awt.image.*;

public final class Images implements AllComponents<ExpressionFunction>, Described {

   public static class makeImage_monotone_buffer_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "buffer";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Buffer_d.class;
            default: return null;
         }

      }

      public makeImage_monotone_buffer_d() {
         addGroupMeta(this);
      }

      public BufferedImage evaluate(Context context, Object[] inputs) {
         final Buffer_d buffer = (Buffer_d)inputs[0];
         BufferedImage image = new BufferedImage ( buffer . getXRes ( ) , buffer . getYRes ( ) , BufferedImage . TYPE_INT_ARGB ) ;
         for ( int x = 0 ;
         x < buffer . getXRes ( ) ;
         x ++ ) {
         for ( int y = 0 ;
         y < buffer . getYRes ( ) ;
         y ++ ) {
         double d = 1 - buffer . getValue ( x , y ) . val ;
         image . setRGB ( x , y , Color . toARGB ( d , d , d ) ) ;
         }
         }
         return image ;
      }

      public Class getReturnType() {
         return BufferedImage.class;
      }

   }

   public static class makeImage_monochrome1_buffer_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "buffer";
            case 1: return "c";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Buffer_d.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public makeImage_monochrome1_buffer_d() {
         addGroupMeta(this);
      }

      public BufferedImage evaluate(Context context, Object[] inputs) {
         final Buffer_d buffer = (Buffer_d)inputs[0];
         final Color c = (Color)inputs[1];
         BufferedImage image = new BufferedImage ( buffer . getXRes ( ) , buffer . getYRes ( ) , BufferedImage . TYPE_INT_ARGB ) ;
         for ( int x = 0 ;
         x < buffer . getXRes ( ) ;
         x ++ ) {
         for ( int y = 0 ;
         y < buffer . getYRes ( ) ;
         y ++ ) {
         double d = 1 - buffer . getValue ( x , y ) . val ;
         image . setRGB ( x , y , c . mult ( d ) . toARGB ( ) ) ;
         }
         }
         return image ;
      }

      public Class getReturnType() {
         return BufferedImage.class;
      }

   }

   public static class makeImage_monoalpha1_buffer_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "buffer";
            case 1: return "c";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Buffer_d.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public makeImage_monoalpha1_buffer_d() {
         addGroupMeta(this);
      }

      public BufferedImage evaluate(Context context, Object[] inputs) {
         final Buffer_d buffer = (Buffer_d)inputs[0];
         final Color c = (Color)inputs[1];
         BufferedImage image = new BufferedImage ( buffer . getXRes ( ) , buffer . getYRes ( ) , BufferedImage . TYPE_INT_ARGB ) ;
         for ( int x = 0 ;
         x < buffer . getXRes ( ) ;
         x ++ ) {
         for ( int y = 0 ;
         y < buffer . getYRes ( ) ;
         y ++ ) {
         double d = 1 - buffer . getValue ( x , y ) . val ;
         int A = Math . max ( Math . min ( ( int ) ( d * 255 ) , 255 ) , 0 ) ;
         int R = Math . max ( Math . min ( ( int ) ( c . r * 255 ) , 255 ) , 0 ) ;
         int G = Math . max ( Math . min ( ( int ) ( c . g * 255 ) , 255 ) , 0 ) ;
         int B = Math . max ( Math . min ( ( int ) ( c . b * 255 ) , 255 ) , 0 ) ;
         int argb = ( A << 24 ) + ( R << 16 ) + ( G << 8 ) + ( B ) ;
         image . setRGB ( x , y , argb ) ;
         }
         }
         return image ;
      }

      public Class getReturnType() {
         return BufferedImage.class;
      }

   }

   public static class makeImage_monoalpha2_buffer_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "buffer";
            case 1: return "c";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Buffer_d.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public makeImage_monoalpha2_buffer_d() {
         addGroupMeta(this);
      }

      public BufferedImage evaluate(Context context, Object[] inputs) {
         final Buffer_d buffer = (Buffer_d)inputs[0];
         final Color c = (Color)inputs[1];
         BufferedImage image = new BufferedImage ( buffer . getXRes ( ) , buffer . getYRes ( ) , BufferedImage . TYPE_INT_ARGB ) ;
         for ( int x = 0 ;
         x < buffer . getXRes ( ) ;
         x ++ ) {
         for ( int y = 0 ;
         y < buffer . getYRes ( ) ;
         y ++ ) {
         double d = buffer . getValue ( x , y ) . val ;
         int A = Math . max ( Math . min ( ( int ) ( d * 255 ) , 255 ) , 0 ) ;
         int R = Math . max ( Math . min ( ( int ) ( c . r * 255 ) , 255 ) , 0 ) ;
         int G = Math . max ( Math . min ( ( int ) ( c . g * 255 ) , 255 ) , 0 ) ;
         int B = Math . max ( Math . min ( ( int ) ( c . b * 255 ) , 255 ) , 0 ) ;
         int argb = ( A << 24 ) + ( R << 16 ) + ( G << 8 ) + ( B ) ;
         image . setRGB ( x , y , argb ) ;
         }
         }
         return image ;
      }

      public Class getReturnType() {
         return BufferedImage.class;
      }

   }

   public static class makeImage_monochrome2_buffer_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "buffer";
            case 1: return "c";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Buffer_d.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public makeImage_monochrome2_buffer_d() {
         addGroupMeta(this);
      }

      public BufferedImage evaluate(Context context, Object[] inputs) {
         final Buffer_d buffer = (Buffer_d)inputs[0];
         final Color c = (Color)inputs[1];
         BufferedImage image = new BufferedImage ( buffer . getXRes ( ) , buffer . getYRes ( ) , BufferedImage . TYPE_INT_ARGB ) ;
         for ( int x = 0 ;
         x < buffer . getXRes ( ) ;
         x ++ ) {
         for ( int y = 0 ;
         y < buffer . getYRes ( ) ;
         y ++ ) {
         double d = 1 - buffer . getValue ( x , y ) . val ;
         image . setRGB ( x , y , c . mult ( d ) . add ( new Color ( 1 - d , 1 - d , 1 - d ) ) . toARGB ( ) ) ;
         }
         }
         return image ;
      }

      public Class getReturnType() {
         return BufferedImage.class;
      }

   }

   public static class makeImage_dualchrome_buffer_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "buffer";
            case 1: return "c1";
            case 2: return "c2";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Buffer_d.class;
            case 1: return Color.class;
            case 2: return Color.class;
            default: return null;
         }

      }

      public makeImage_dualchrome_buffer_d() {
         addGroupMeta(this);
      }

      public BufferedImage evaluate(Context context, Object[] inputs) {
         final Buffer_d buffer = (Buffer_d)inputs[0];
         final Color c1 = (Color)inputs[1];
         final Color c2 = (Color)inputs[2];
         BufferedImage image = new BufferedImage ( buffer . getXRes ( ) , buffer . getYRes ( ) , BufferedImage . TYPE_INT_ARGB ) ;
         for ( int x = 0 ;
         x < buffer . getXRes ( ) ;
         x ++ ) {
         for ( int y = 0 ;
         y < buffer . getYRes ( ) ;
         y ++ ) {
         double d = 1 - buffer . getValue ( x , y ) . val ;
         image . setRGB ( x , y , c1 . mult ( d ) . add ( c2 . mult ( 1 - d ) ) . toARGB ( ) ) ;
         }
         }
         return image ;
      }

      public Class getReturnType() {
         return BufferedImage.class;
      }

   }

   public String getDescription() {
      return "expressions producing images";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new makeImage_monotone_buffer_d());
      r.add(new makeImage_monochrome1_buffer_d());
      r.add(new makeImage_monoalpha1_buffer_d());
      r.add(new makeImage_monoalpha2_buffer_d());
      r.add(new makeImage_monochrome2_buffer_d());
      r.add(new makeImage_dualchrome_buffer_d());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
