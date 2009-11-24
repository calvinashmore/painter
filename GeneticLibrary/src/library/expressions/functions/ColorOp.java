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

public final class ColorOp implements AllComponents<ExpressionFunction>, Described {

   public static class Invert extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

      public Invert() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         return new Color ( 1 - x . r , 1 - x . g , 1 - x . b ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Invert1 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

      public Invert1() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         Color c = new Color ( 1 - x . r , 1 - x . g , 1 - x . b ) ;
         return c . mult ( x . magnitude ( ) / c . magnitude ( ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Tone_blend extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "t";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Tone_blend() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         final LDouble t = (LDouble)inputs[1];
         Color c = new Color ( 1 - x . r , 1 - x . g , 1 - x . b ) ;
         c = c . mult ( x . magnitude ( ) / c . magnitude ( ) ) ;
         return x . mult ( 1 - t . val ) . add ( c . mult ( t . val ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class offsetHue extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "offset";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public offsetHue() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         final LDouble offset = (LDouble)inputs[1];
         double hsb [ ] = x . hsbvals ( ) ;
         return new Color ( hsb [ 0 ] + offset . val , hsb [ 1 ] , hsb [ 2 ] ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class setHue extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "value";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public setHue() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         final LDouble value = (LDouble)inputs[1];
         double hsb [ ] = x . hsbvals ( ) ;
         return new Color ( value . val , hsb [ 1 ] , hsb [ 2 ] ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class setSaturation extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "value";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public setSaturation() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         final LDouble value = (LDouble)inputs[1];
         double hsb [ ] = x . hsbvals ( ) ;
         return new Color ( hsb [ 0 ] , value . val , hsb [ 2 ] ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class setBrightness extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "value";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public setBrightness() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         final LDouble value = (LDouble)inputs[1];
         double hsb [ ] = x . hsbvals ( ) ;
         return new Color ( hsb [ 0 ] , hsb [ 1 ] , value . val ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class RGB_to_HSB1 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

      public RGB_to_HSB1() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         return Color . makeHSB ( x . r , x . g , x . b ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class RGB_to_HSB2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

      public RGB_to_HSB2() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         return Color . makeHSB ( x . g , x . r , x . b ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class RGB_to_HSB3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

      public RGB_to_HSB3() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         return Color . makeHSB ( x . r , x . b , x . g ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class RGB_to_HSB4 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

      public RGB_to_HSB4() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         return Color . makeHSB ( x . g , x . b , x . r ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class RGB_to_HSB5 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

      public RGB_to_HSB5() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         return Color . makeHSB ( x . b , x . r , x . g ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class RGB_to_HSB6 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

      public RGB_to_HSB6() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         return Color . makeHSB ( x . b , x . g , x . r ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HSB_to_RGB1 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

      public HSB_to_RGB1() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         double [ ] hsb = x . hsbvals ( ) ;
         return new Color ( hsb [ 0 ] , hsb [ 1 ] , hsb [ 2 ] ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HSB_to_RGB2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

      public HSB_to_RGB2() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         double [ ] hsb = x . hsbvals ( ) ;
         return new Color ( hsb [ 0 ] , hsb [ 2 ] , hsb [ 1 ] ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HSB_to_RGB3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

      public HSB_to_RGB3() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         double [ ] hsb = x . hsbvals ( ) ;
         return new Color ( hsb [ 1 ] , hsb [ 0 ] , hsb [ 2 ] ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HSB_to_RGB4 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

      public HSB_to_RGB4() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         double [ ] hsb = x . hsbvals ( ) ;
         return new Color ( hsb [ 1 ] , hsb [ 2 ] , hsb [ 0 ] ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HSB_to_RGB5 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

      public HSB_to_RGB5() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         double [ ] hsb = x . hsbvals ( ) ;
         return new Color ( hsb [ 2 ] , hsb [ 1 ] , hsb [ 0 ] ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HSB_to_RGB6 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

      public HSB_to_RGB6() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         double [ ] hsb = x . hsbvals ( ) ;
         return new Color ( hsb [ 2 ] , hsb [ 0 ] , hsb [ 1 ] ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HSB extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "s";
            case 2: return "b";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public HSB() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble h = (LDouble)inputs[0];
         final LDouble s = (LDouble)inputs[1];
         final LDouble b = (LDouble)inputs[2];
         return Color . makeHSB ( h . val , s . val , b . val ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HSB1 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "s";
            case 2: return "b";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public HSB1() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble h = (LDouble)inputs[0];
         final LDouble s = (LDouble)inputs[1];
         final LDouble b = (LDouble)inputs[2];
         return Color . makeHSB ( h . val , s . val , .5 + .5 * b . val / ( 1 + Math . abs ( b . val ) ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HSB_v3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hsb";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public HSB_v3() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect3d hsb = (LVect3d)inputs[0];
         return Color . makeHSB ( hsb . x , hsb . y , hsb . z ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HSB1_v3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hsb";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public HSB1_v3() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect3d hsb = (LVect3d)inputs[0];
         return Color . makeHSB ( hsb . x , hsb . y , .5 + .5 * hsb . z / ( 1 + Math . abs ( hsb . z ) ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HSB_v3_gauss extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hsb";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public HSB_v3_gauss() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect3d hsb = (LVect3d)inputs[0];
         return Color . makeHSB ( hsb . x , Math . exp ( - hsb . y * hsb . y ) , Math . exp ( - hsb . z * hsb . z ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HSB_v3_sigmoid extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hsb";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public HSB_v3_sigmoid() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect3d hsb = (LVect3d)inputs[0];
         return Color . makeHSB ( hsb . x , 1 / ( 1.0 + Math . exp ( - hsb . y ) ) , 1 / ( 1.0 + Math . exp ( - hsb . z ) ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class v3_RGB extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "rgb";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

      public v3_RGB() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         final Color rgb = (Color)inputs[0];
         return new LVect3d ( rgb . r , rgb . g , rgb . b ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class v3_HSB extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

      public v3_HSB() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         double [ ] hsb = x . hsbvals ( ) ;
         return new LVect3d ( hsb [ 0 ] , hsb [ 1 ] , hsb [ 2 ] ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class RGB extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "r";
            case 1: return "g";
            case 2: return "b";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public RGB() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble r = (LDouble)inputs[0];
         final LDouble g = (LDouble)inputs[1];
         final LDouble b = (LDouble)inputs[2];
         return new Color ( r . val , g . val , b . val ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class RGB_v3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "rgb";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public RGB_v3() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect3d rgb = (LVect3d)inputs[0];
         return new Color ( rgb . x , rgb . y , rgb . z ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class RGB_v3_gauss extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "rgb";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public RGB_v3_gauss() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect3d rgb = (LVect3d)inputs[0];
         return new Color ( Math . exp ( - rgb . x * rgb . x ) , Math . exp ( - rgb . y * rgb . y ) , Math . exp ( - rgb . z * rgb . z ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class RGB_v3_sigmoid extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "rgb";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public RGB_v3_sigmoid() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect3d rgb = (LVect3d)inputs[0];
         return new Color ( 1 / ( 1.0 + Math . exp ( - rgb . x ) ) , 1 / ( 1.0 + Math . exp ( - rgb . y ) ) , 1 / ( 1.0 + Math . exp ( - rgb . z ) ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Blend_to_White extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "color";
            case 1: return "blend";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Blend_to_White() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color color = (Color)inputs[0];
         final LDouble blend = (LDouble)inputs[1];
         double blend1 = 1 / ( 1.0 + Math . exp ( - blend . val ) ) ;
         return new Color ( blend1 + ( 1 - blend1 ) * color . r , blend1 + ( 1 - blend1 ) * color . g , blend1 + ( 1 - blend1 ) * color . b ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Blend_to_Black extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "color";
            case 1: return "blend";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Blend_to_Black() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color color = (Color)inputs[0];
         final LDouble blend = (LDouble)inputs[1];
         double blend1 = 1 / ( 1.0 + Math . exp ( - blend . val ) ) ;
         return new Color ( 0 + ( 1 - blend1 ) * color . r , 0 + ( 1 - blend1 ) * color . g , 0 + ( 1 - blend1 ) * color . b ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Blend_to_Gray extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "color";
            case 1: return "blend";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Blend_to_Gray() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color color = (Color)inputs[0];
         final LDouble blend = (LDouble)inputs[1];
         double blend1 = 1 / ( 1.0 + Math . exp ( - blend . val ) ) ;
         return new Color ( .5 * blend1 + ( 1 - blend1 ) * color . r , .5 * blend1 + ( 1 - blend1 ) * color . g , .5 * blend1 + ( 1 - blend1 ) * color . b ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Monochrome extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "color";
            case 1: return "blend";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Monochrome() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color color = (Color)inputs[0];
         final LDouble blend = (LDouble)inputs[1];
         double blend1 = 1 / ( 1.0 + Math . exp ( - blend . val ) ) ;
         if ( blend1 > .5 ) return new Color ( 2 * ( blend1 - .5 ) + ( 1 - 2 * ( blend1 - .5 ) ) * color . r , 2 * ( blend1 - .5 ) + ( 1 - 2 * ( blend1 - .5 ) ) * color . g , 2 * ( blend1 - .5 ) + ( 1 - 2 * ( blend1 - .5 ) ) * color . b ) ;
         else return new Color ( ( 2 * blend1 ) * color . r , ( 2 * blend1 ) * color . g , ( 2 * blend1 ) * color . b ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Sigmoidize extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "color";
            case 1: return "blend";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Sigmoidize() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color color = (Color)inputs[0];
         final LDouble blend = (LDouble)inputs[1];
         double blend1 = 1 / ( 1.0 + Math . exp ( - blend . val ) ) ;
         return new Color ( blend1 * ( 1 - color . r ) + ( 1 - blend1 ) * color . r , blend1 * ( 1 - color . g ) + ( 1 - blend1 ) * color . g , blend1 * ( 1 - color . b ) + ( 1 - blend1 ) * color . b ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public String getDescription() {
      return "Color operations";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new Invert());
      r.add(new Invert1());
      r.add(new Tone_blend());
      r.add(new offsetHue());
      r.add(new setHue());
      r.add(new setSaturation());
      r.add(new setBrightness());
      r.add(new RGB_to_HSB1());
      r.add(new RGB_to_HSB2());
      r.add(new RGB_to_HSB3());
      r.add(new RGB_to_HSB4());
      r.add(new RGB_to_HSB5());
      r.add(new RGB_to_HSB6());
      r.add(new HSB_to_RGB1());
      r.add(new HSB_to_RGB2());
      r.add(new HSB_to_RGB3());
      r.add(new HSB_to_RGB4());
      r.add(new HSB_to_RGB5());
      r.add(new HSB_to_RGB6());
      r.add(new HSB());
      r.add(new HSB1());
      r.add(new HSB_v3());
      r.add(new HSB1_v3());
      r.add(new HSB_v3_gauss());
      r.add(new HSB_v3_sigmoid());
      r.add(new v3_RGB());
      r.add(new v3_HSB());
      r.add(new RGB());
      r.add(new RGB_v3());
      r.add(new RGB_v3_gauss());
      r.add(new RGB_v3_sigmoid());
      r.add(new Blend_to_White());
      r.add(new Blend_to_Black());
      r.add(new Blend_to_Gray());
      r.add(new Monochrome());
      r.add(new Sigmoidize());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
