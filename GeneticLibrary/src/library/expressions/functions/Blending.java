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

public final class Blending implements AllComponents<ExpressionFunction>, Described {

   public static class Limit extends ExpressionFunction {

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

      public Limit() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         Color x = (Color)inputs[0];
         return new Color ( Math . max ( Math . min ( x . r , 1 ) , 0 ) , Math . max ( Math . min ( x . g , 1 ) , 0 ) , Math . max ( Math . min ( x . b , 1 ) , 0 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Average extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public Average() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         Color x = (Color)inputs[0];
         Color y = (Color)inputs[1];
         return new Color ( ( x . r + y . r ) / 2 , ( x . g + y . g ) / 2 , ( x . b + y . b ) / 2 ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class ColorBurn extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public ColorBurn() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         Color x = (Color)inputs[0];
         Color y = (Color)inputs[1];
         return new Color ( 1 - ( 1 - x . r ) / ( y . r ) , 1 - ( 1 - x . g ) / ( y . g ) , 1 - ( 1 - x . b ) / ( y . b ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class ColorDodge extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public ColorDodge() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         Color x = (Color)inputs[0];
         Color y = (Color)inputs[1];
         return new Color ( x . r / ( 1 - y . r ) , x . g / ( 1 - y . g ) , x . b / ( 1 - y . b ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Darken extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public Darken() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         Color x = (Color)inputs[0];
         Color y = (Color)inputs[1];
         return new Color ( Math . min ( x . r , y . r ) , Math . min ( x . g , y . g ) , Math . min ( x . b , y . b ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Difference extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public Difference() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         Color x = (Color)inputs[0];
         Color y = (Color)inputs[1];
         return new Color ( Math . abs ( y . r - x . r ) , Math . abs ( y . g - x . g ) , Math . abs ( y . b - x . b ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Exclusion extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public Exclusion() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         Color x = (Color)inputs[0];
         Color y = (Color)inputs[1];
         return new Color ( x . r + y . r - 2 * x . r * y . r , x . g + y . g - 2 * x . g * y . g , x . b + y . b - 2 * x . b * y . b ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HardLight extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public HardLight() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         Color x = (Color)inputs[0];
         Color y = (Color)inputs[1];
         double lum = .2125 * y . r + .7154 * y . g + .0721 * y . b ;
         if ( lum < 0.45 ) {
         return new Color ( 2 * x . r * y . r , 2 * x . g * y . g , 2 * x . b * y . b ) ;
         }
         else if ( lum > .55 ) {
         return new Color ( 1 - 2 * ( 1 - x . r ) * ( 1 - y . r ) , 1 - 2 * ( 1 - x . g ) * ( 1 - y . g ) , 1 - 2 * ( 1 - x . b ) * ( 1 - y . b ) ) ;
         }
         else {
         Color r1 = new Color ( 2 * x . r * y . r , 2 * x . g * y . g , 2 * x . b * y . b ) ;
         Color r2 = new Color ( 1 - 2 * ( 1 - x . r ) * ( 1 - y . r ) , 1 - 2 * ( 1 - x . g ) * ( 1 - y . g ) , 1 - 2 * ( 1 - x . b ) * ( 1 - y . b ) ) ;
         r1 . multv ( 10 * ( lum - 0.45 ) ) ;
         r2 . multv ( 1 - 10 * ( lum - 0.45 ) ) ;
         return r1 . add ( r2 ) ;
         }
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class InverseDifference extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public InverseDifference() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         Color x = (Color)inputs[0];
         Color y = (Color)inputs[1];
         return new Color ( 1 - Math . abs ( 1 - y . r - x . r ) , 1 - Math . abs ( 1 - y . g - x . g ) , 1 - Math . abs ( 1 - y . b - x . b ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Lighten extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public Lighten() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         Color x = (Color)inputs[0];
         Color y = (Color)inputs[1];
         return new Color ( Math . max ( x . r , y . r ) , Math . max ( x . g , y . g ) , Math . max ( x . b , y . b ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Multiply extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public Multiply() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         Color x = (Color)inputs[0];
         Color y = (Color)inputs[1];
         return new Color ( x . r * y . r , x . g * y . g , x . b * y . b ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Overlay extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public Overlay() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         Color x = (Color)inputs[0];
         Color y = (Color)inputs[1];
         double lum = .2125 * x . r + .7154 * x . g + .0721 * x . b ;
         Color r1 = new Color ( 2 * x . r * y . r , 2 * x . g * y . g , 2 * x . b * y . b ) ;
         Color r2 = new Color ( 1 - 2 * ( 1 - x . r ) * ( 1 - y . r ) , 1 - 2 * ( 1 - x . g ) * ( 1 - y . g ) , 1 - 2 * ( 1 - x . b ) * ( 1 - y . b ) ) ;
         r1 . multv ( lum ) ;
         r2 . multv ( 1 - lum ) ;
         return r1 . add ( r2 ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Overlay_x extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public Overlay_x() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         Color x = (Color)inputs[0];
         Color y = (Color)inputs[1];
         double lum = .2125 * x . r + .7154 * x . g + .0721 * x . b ;
         if ( lum < 0.45 ) {
         return new Color ( 2 * x . r * y . r , 2 * x . g * y . g , 2 * x . b * y . b ) ;
         }
         else if ( lum > .55 ) {
         return new Color ( 1 - 2 * ( 1 - x . r ) * ( 1 - y . r ) , 1 - 2 * ( 1 - x . g ) * ( 1 - y . g ) , 1 - 2 * ( 1 - x . b ) * ( 1 - y . b ) ) ;
         }
         else {
         Color r1 = new Color ( 2 * x . r * y . r , 2 * x . g * y . g , 2 * x . b * y . b ) ;
         Color r2 = new Color ( 1 - 2 * ( 1 - x . r ) * ( 1 - y . r ) , 1 - 2 * ( 1 - x . g ) * ( 1 - y . g ) , 1 - 2 * ( 1 - x . b ) * ( 1 - y . b ) ) ;
         r1 . multv ( 10 * ( lum - 0.45 ) ) ;
         r2 . multv ( 1 - 10 * ( lum - 0.45 ) ) ;
         return r1 . add ( r2 ) ;
         }
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Screen extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public Screen() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         Color x = (Color)inputs[0];
         Color y = (Color)inputs[1];
         return new Color ( 1 - ( 1 - x . r ) * ( 1 - y . r ) , 1 - ( 1 - x . g ) * ( 1 - y . g ) , 1 - ( 1 - x . b ) * ( 1 - y . b ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class SoftLight extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public SoftLight() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         Color x = (Color)inputs[0];
         Color y = (Color)inputs[1];
         return new Color ( 2 * x . r * y . r + x . r * x . r - 2 * x . r * x . r * y . r , 2 * x . g * y . g + x . g * x . g - 2 * x . g * x . g * y . g , 2 * x . b * y . b + x . b * x . b - 2 * x . b * x . b * y . b ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public String getDescription() {
      return "Color blending operations";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new Limit());
      r.add(new Average());
      r.add(new ColorBurn());
      r.add(new ColorDodge());
      r.add(new Darken());
      r.add(new Difference());
      r.add(new Exclusion());
      r.add(new HardLight());
      r.add(new InverseDifference());
      r.add(new Lighten());
      r.add(new Multiply());
      r.add(new Overlay());
      r.add(new Overlay_x());
      r.add(new Screen());
      r.add(new SoftLight());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
