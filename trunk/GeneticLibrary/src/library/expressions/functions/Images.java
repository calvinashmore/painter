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
      private transient BufferedImage image ;private void makeImage ( Buffer_d buffer ) { ColorGrid cg = new ColorGrid ( buffer . getXRes ( ) , buffer . getYRes ( ) ) ; for ( int x = 0 ; x < buffer . getXRes ( ) ; x ++ ) { for ( int y = 0 ; y < buffer . getYRes ( ) ; y ++ ) { double d = 1 - buffer . getValue ( x , y ) . val ; cg . setValue ( x , y , new Color ( d , d , d ) ) ; } } image = cg . makeImage ( ) ; }
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
         if ( image == null ) makeImage ( buffer ) ;
         return image ;
      }

      public Class getReturnType() {
         return BufferedImage.class;
      }

   }

   public static class makeImage_dualchrome_buffer_d extends ExpressionFunction {
      private transient BufferedImage image ;private void makeImage ( Buffer_d buffer ) { ColorGrid cg = new ColorGrid ( buffer . getXRes ( ) , buffer . getYRes ( ) ) ; for ( int x = 0 ; x < buffer . getXRes ( ) ; x ++ ) { for ( int y = 0 ; y < buffer . getYRes ( ) ; y ++ ) { double d = 1 - buffer . getValue ( x , y ) . val ; Color color = c1 . mult ( d ) . add ( c2 . mult ( 1 - d ) ) ; cg . setValue ( x , y , color ) ; } } image = cg . makeImage ( ) ; }
      private Color c1;private Color c2;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return c1;
            case 1: return c2;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "c1";
            case 1: return "c2";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: c1 = (Color) value; return;
            case 1: c2 = (Color) value; return;
            default: return;
         }

      }

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

      public makeImage_dualchrome_buffer_d() {
         addGroupMeta(this);
         c1 = new Color ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         c2 = new Color ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
      }

      public BufferedImage evaluate(Context context, Object[] inputs) {
         final Buffer_d buffer = (Buffer_d)inputs[0];
         if ( image == null ) makeImage ( buffer ) ;
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
      r.add(new makeImage_dualchrome_buffer_d());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
