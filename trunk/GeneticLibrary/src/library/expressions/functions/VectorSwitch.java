package library . expressions . functions;

import java.util.*;
import genetic.*;
import genetic.component.accessor.*;
import genetic.component.command.*;
import genetic.component.context.*;
import genetic.component.expression.*;
import genetic.component.expression.function.*;
import genetic.component.method.*;
import genetic.component.program.*;
import genetic.component.statement.*;
import genetic.component.statementlist.*;
import genetic.component.statement.function.*;
import utils.linear.*;

public final class VectorSwitch implements AllComponents<ExpressionFunction>, Described {
   public static class d_to_i extends ExpressionFunction {

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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public Integer evaluate(Context context, Object[] inputs) {
         LDouble x = (LDouble)inputs[0];
         return ( int ) x . val ;
      }

      public Class getReturnType() {
         return Integer.class;
      }

   }

   public static class i_to_d extends ExpressionFunction {

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
            case 0: return Integer.class;
            default: return null;
         }

      }

      public LDouble evaluate(Context context, Object[] inputs) {
         Integer x = (Integer)inputs[0];
         return new LDouble ( x ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class C_v2 extends ExpressionFunction {

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
            case 0: return Complex.class;
            default: return null;
         }

      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         Complex x = (Complex)inputs[0];
         return new LVect2d ( x . x , x . y ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class C_x extends ExpressionFunction {

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
            case 0: return Complex.class;
            default: return null;
         }

      }

      public LDouble evaluate(Context context, Object[] inputs) {
         Complex x = (Complex)inputs[0];
         return new LDouble ( x . x ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class C_y extends ExpressionFunction {

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
            case 0: return Complex.class;
            default: return null;
         }

      }

      public LDouble evaluate(Context context, Object[] inputs) {
         Complex x = (Complex)inputs[0];
         return new LDouble ( x . y ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class V2_c extends ExpressionFunction {

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
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Complex evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         return new Complex ( x . x , x . y ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class V2_x extends ExpressionFunction {

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
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public LDouble evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         return new LDouble ( x . x ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class V2_y extends ExpressionFunction {

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
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public LDouble evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         return new LDouble ( x . y ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class V2_swap extends ExpressionFunction {

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
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         return new LVect2d ( x . y , x . x ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class V2_to_magTheta extends ExpressionFunction {

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
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         double r = Math . sqrt ( x . x * x . x + x . y * x . y ) ;
         double theta = Math . atan2 ( x . y , x . x ) ;
         return new LVect2d ( r , theta ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class MagTheta_to_v2 extends ExpressionFunction {

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
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         return new LVect2d ( x . x * Math . cos ( x . y ) , x . x * Math . sin ( x . y ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Color_r extends ExpressionFunction {

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

      public LDouble evaluate(Context context, Object[] inputs) {
         Color x = (Color)inputs[0];
         return new LDouble ( x . r ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Color_g extends ExpressionFunction {

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

      public LDouble evaluate(Context context, Object[] inputs) {
         Color x = (Color)inputs[0];
         return new LDouble ( x . g ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Color_b extends ExpressionFunction {

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

      public LDouble evaluate(Context context, Object[] inputs) {
         Color x = (Color)inputs[0];
         return new LDouble ( x . b ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Color_hue extends ExpressionFunction {

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

      public LDouble evaluate(Context context, Object[] inputs) {
         Color x = (Color)inputs[0];
         return new LDouble ( x . hsbvals ( ) [ 0 ] ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Color_saturation extends ExpressionFunction {

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

      public LDouble evaluate(Context context, Object[] inputs) {
         Color x = (Color)inputs[0];
         return new LDouble ( x . hsbvals ( ) [ 1 ] ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Color_brightness extends ExpressionFunction {

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

      public LDouble evaluate(Context context, Object[] inputs) {
         Color x = (Color)inputs[0];
         return new LDouble ( x . hsbvals ( ) [ 2 ] ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class New_c extends ExpressionFunction {

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
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Complex evaluate(Context context, Object[] inputs) {
         LDouble x = (LDouble)inputs[0];
         LDouble y = (LDouble)inputs[1];
         return new Complex ( x . val , y . val ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class New_v2 extends ExpressionFunction {

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
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LDouble x = (LDouble)inputs[0];
         LDouble y = (LDouble)inputs[1];
         return new LVect2d ( x . val , y . val ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class New_v3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "z";
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

      public LVect3d evaluate(Context context, Object[] inputs) {
         LDouble x = (LDouble)inputs[0];
         LDouble y = (LDouble)inputs[1];
         LDouble z = (LDouble)inputs[2];
         return new LVect3d ( x . val , y . val , z . val ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class New_dv2_v3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "yz";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LDouble x = (LDouble)inputs[0];
         LVect2d yz = (LVect2d)inputs[1];
         return new LVect3d ( x . val , yz . x , yz . y ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class New_v2d_v3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "xy";
            case 1: return "z";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect2d xy = (LVect2d)inputs[0];
         LDouble z = (LDouble)inputs[1];
         return new LVect3d ( xy . x , xy . y , z . val ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class New_vdv_v3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "xz";
            case 1: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect2d xz = (LVect2d)inputs[0];
         LDouble y = (LDouble)inputs[1];
         return new LVect3d ( xz . x , y . val , xz . y ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public String getDescription() {
      return "vector switching functions";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new d_to_i());
      r.add(new i_to_d());
      r.add(new C_v2());
      r.add(new C_x());
      r.add(new C_y());
      r.add(new V2_c());
      r.add(new V2_x());
      r.add(new V2_y());
      r.add(new V2_swap());
      r.add(new V2_to_magTheta());
      r.add(new MagTheta_to_v2());
      r.add(new Color_r());
      r.add(new Color_g());
      r.add(new Color_b());
      r.add(new Color_hue());
      r.add(new Color_saturation());
      r.add(new Color_brightness());
      r.add(new New_c());
      r.add(new New_v2());
      r.add(new New_v3());
      r.add(new New_dv2_v3());
      r.add(new New_v2d_v3());
      r.add(new New_vdv_v3());
      return r;
   }

}
