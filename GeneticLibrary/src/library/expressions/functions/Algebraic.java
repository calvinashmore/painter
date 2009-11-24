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

public final class Algebraic implements AllComponents<ExpressionFunction>, Described {

   public static class avg_d extends ExpressionFunction {

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

      public avg_d() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         final LDouble y = (LDouble)inputs[1];
         return new LDouble ( ( x . val + y . val ) / 2 ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class avg_i extends ExpressionFunction {

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
            case 0: return Integer.class;
            case 1: return Integer.class;
            default: return null;
         }

      }

      public avg_i() {
         addGroupMeta(this);
      }

      public Integer evaluate(Context context, Object[] inputs) {
         final Integer x = (Integer)inputs[0];
         final Integer y = (Integer)inputs[1];
         return ( x + y ) / 2 ;
      }

      public Class getReturnType() {
         return Integer.class;
      }

   }

   public static class avg_c extends ExpressionFunction {

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
            case 0: return Complex.class;
            case 1: return Complex.class;
            default: return null;
         }

      }

      public avg_c() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Complex x = (Complex)inputs[0];
         final Complex y = (Complex)inputs[1];
         return new Complex ( x . x + y . x , x . y + y . y ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class avg_v2 extends ExpressionFunction {

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
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public avg_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         final LVect2d y = (LVect2d)inputs[1];
         return new LVect2d ( x . x + y . x , x . y + y . y ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class avg_v3 extends ExpressionFunction {

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
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public avg_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         final LVect3d x = (LVect3d)inputs[0];
         final LVect3d y = (LVect3d)inputs[1];
         return new LVect3d ( ( x . x + y . x ) / 2 , ( x . y + y . y ) / 2 , ( x . z + y . z ) / 2 ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class add_col extends ExpressionFunction {

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

      public add_col() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         final Color y = (Color)inputs[1];
         return new Color ( x . r + y . r , x . g + y . g , x . b + y . b ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class add_d extends ExpressionFunction {

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

      public add_d() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         final LDouble y = (LDouble)inputs[1];
         return new LDouble ( x . val + y . val ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class add_i extends ExpressionFunction {

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
            case 0: return Integer.class;
            case 1: return Integer.class;
            default: return null;
         }

      }

      public add_i() {
         addGroupMeta(this);
      }

      public Integer evaluate(Context context, Object[] inputs) {
         final Integer x = (Integer)inputs[0];
         final Integer y = (Integer)inputs[1];
         return x + y ;
      }

      public Class getReturnType() {
         return Integer.class;
      }

   }

   public static class add_c extends ExpressionFunction {

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
            case 0: return Complex.class;
            case 1: return Complex.class;
            default: return null;
         }

      }

      public add_c() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Complex x = (Complex)inputs[0];
         final Complex y = (Complex)inputs[1];
         return new Complex ( x . x + y . x , x . y + y . y ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class add_v2 extends ExpressionFunction {

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
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public add_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         final LVect2d y = (LVect2d)inputs[1];
         return new LVect2d ( x . x + y . x , x . y + y . y ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class add_v3 extends ExpressionFunction {

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
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public add_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         final LVect3d x = (LVect3d)inputs[0];
         final LVect3d y = (LVect3d)inputs[1];
         return new LVect3d ( x . x + y . x , x . y + y . y , x . z + y . z ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class sub_col extends ExpressionFunction {

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

      public sub_col() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         final Color y = (Color)inputs[1];
         return new Color ( x . r - y . r , x . g - y . g , x . b - y . b ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class sub_c extends ExpressionFunction {

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
            case 0: return Complex.class;
            case 1: return Complex.class;
            default: return null;
         }

      }

      public sub_c() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Complex x = (Complex)inputs[0];
         final Complex y = (Complex)inputs[1];
         return new Complex ( x . x - y . x , x . y - y . y ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class sub_d extends ExpressionFunction {

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

      public sub_d() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         final LDouble y = (LDouble)inputs[1];
         return new LDouble ( x . val - y . val ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class sub_i extends ExpressionFunction {

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
            case 0: return Integer.class;
            case 1: return Integer.class;
            default: return null;
         }

      }

      public sub_i() {
         addGroupMeta(this);
      }

      public Integer evaluate(Context context, Object[] inputs) {
         final Integer x = (Integer)inputs[0];
         final Integer y = (Integer)inputs[1];
         return x - y ;
      }

      public Class getReturnType() {
         return Integer.class;
      }

   }

   public static class sub_v2 extends ExpressionFunction {

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
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public sub_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         final LVect2d y = (LVect2d)inputs[1];
         return new LVect2d ( x . x - y . x , x . y - y . y ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class sub_v3 extends ExpressionFunction {

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
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public sub_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         final LVect3d x = (LVect3d)inputs[0];
         final LVect3d y = (LVect3d)inputs[1];
         return new LVect3d ( x . x - y . x , x . y - y . y , x . z - y . z ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class mult_col extends ExpressionFunction {

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
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public mult_col() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         final LDouble y = (LDouble)inputs[1];
         return new Color ( x . r * y . val , x . g * y . val , x . b * y . val ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class mult_d extends ExpressionFunction {

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

      public mult_d() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         final LDouble y = (LDouble)inputs[1];
         return new LDouble ( x . val * y . val ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class mult_i extends ExpressionFunction {

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
            case 0: return Integer.class;
            case 1: return Integer.class;
            default: return null;
         }

      }

      public mult_i() {
         addGroupMeta(this);
      }

      public Integer evaluate(Context context, Object[] inputs) {
         final Integer x = (Integer)inputs[0];
         final Integer y = (Integer)inputs[1];
         return x * y ;
      }

      public Class getReturnType() {
         return Integer.class;
      }

   }

   public static class mult_i_d extends ExpressionFunction {

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
            case 0: return Integer.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public mult_i_d() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final Integer x = (Integer)inputs[0];
         final LDouble y = (LDouble)inputs[1];
         return new LDouble ( x * y . val ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class mult_c extends ExpressionFunction {

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
            case 0: return Complex.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public mult_c() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Complex x = (Complex)inputs[0];
         final LDouble y = (LDouble)inputs[1];
         return new Complex ( x . x * y . val , x . y * y . val ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class mult_c_c extends ExpressionFunction {

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
            case 0: return Complex.class;
            case 1: return Complex.class;
            default: return null;
         }

      }

      public mult_c_c() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Complex x = (Complex)inputs[0];
         final Complex y = (Complex)inputs[1];
         return new Complex ( x . x * y . x , x . y * y . y ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class mult_v2 extends ExpressionFunction {

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
            case 0: return LVect2d.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public mult_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         final LDouble y = (LDouble)inputs[1];
         return new LVect2d ( x . x * y . val , x . y * y . val ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class mult_v2_v2 extends ExpressionFunction {

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
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public mult_v2_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         final LVect2d y = (LVect2d)inputs[1];
         return new LVect2d ( x . x * y . x , x . y * y . y ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class mult_v3 extends ExpressionFunction {

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
            case 0: return LVect3d.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public mult_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         final LVect3d x = (LVect3d)inputs[0];
         final LDouble y = (LDouble)inputs[1];
         return new LVect3d ( x . x * y . val , x . y * y . val , x . z * y . val ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class mult_v3_v3 extends ExpressionFunction {

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
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public mult_v3_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         final LVect3d x = (LVect3d)inputs[0];
         final LVect3d y = (LVect3d)inputs[1];
         return new LVect3d ( x . x * y . x , x . y * y . y , x . z * y . z ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class pow_col extends ExpressionFunction {

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
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public pow_col() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         final LDouble y = (LDouble)inputs[1];
         return new Color ( Math . pow ( x . r , y . val ) , Math . pow ( x . g , y . val ) , Math . pow ( x . b , y . val ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class pow_col_col extends ExpressionFunction {

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

      public pow_col_col() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         final Color y = (Color)inputs[1];
         return new Color ( Math . pow ( x . r , y . r ) , Math . pow ( x . g , y . g ) , Math . pow ( x . b , y . b ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class pow_d extends ExpressionFunction {

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

      public pow_d() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         final LDouble y = (LDouble)inputs[1];
         return new LDouble ( Math . pow ( x . val , y . val ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class pow_v2 extends ExpressionFunction {

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
            case 0: return LVect2d.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public pow_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         final LDouble y = (LDouble)inputs[1];
         return new LVect2d ( Math . pow ( x . x , y . val ) , Math . pow ( x . y , y . val ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class pow_v2_v2 extends ExpressionFunction {

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
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public pow_v2_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         final LVect2d y = (LVect2d)inputs[1];
         return new LVect2d ( Math . pow ( x . x , y . x ) , Math . pow ( x . y , y . y ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class pow_v3 extends ExpressionFunction {

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
            case 0: return LVect3d.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public pow_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         final LVect3d x = (LVect3d)inputs[0];
         final LDouble y = (LDouble)inputs[1];
         return new LVect3d ( Math . pow ( x . x , y . val ) , Math . pow ( x . y , y . val ) , Math . pow ( x . z , y . val ) ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class pow_v3_v3 extends ExpressionFunction {

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
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public pow_v3_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         final LVect3d x = (LVect3d)inputs[0];
         final LVect3d y = (LVect3d)inputs[1];
         return new LVect3d ( Math . pow ( x . x , y . x ) , Math . pow ( x . y , y . y ) , Math . pow ( x . z , y . z ) ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class offset_col extends ExpressionFunction {

      private Color offset;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return offset;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "offset";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: offset = (Color) value; return;
            default: return;
         }

      }

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

      public offset_col() {
         addGroupMeta(this);
         offset = new Color ( ) ;
         offset . r = 2 * Math . random ( ) - 1 ;
         offset . g = 2 * Math . random ( ) - 1 ;
         offset . b = 2 * Math . random ( ) - 1 ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         return offset . add ( x ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class offset_d extends ExpressionFunction {

      private double offset;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return offset;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "offset";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: offset = (Double) value; return;
            default: return;
         }

      }

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

      public offset_d() {
         addGroupMeta(this);
         offset = 2 * Math . random ( ) - 1 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( x . val + offset ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class offset_c extends ExpressionFunction {

      private Complex offset;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return offset;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "offset";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Complex.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: offset = (Complex) value; return;
            default: return;
         }

      }

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

      public offset_c() {
         addGroupMeta(this);
         offset = new Complex ( ) ;
         offset . x = 2 * Math . random ( ) - 1 ;
         offset . y = 2 * Math . random ( ) - 1 ;
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Complex x = (Complex)inputs[0];
         return offset . add ( x ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class offset_v2 extends ExpressionFunction {

      private LVect2d offset;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return offset;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "offset";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: offset = (LVect2d) value; return;
            default: return;
         }

      }

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

      public offset_v2() {
         addGroupMeta(this);
         offset = new LVect2d ( ) ;
         offset . x = 2 * Math . random ( ) - 1 ;
         offset . y = 2 * Math . random ( ) - 1 ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         return offset . add ( x ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class offset_v3 extends ExpressionFunction {

      private LVect3d offset;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return offset;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "offset";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: offset = (LVect3d) value; return;
            default: return;
         }

      }

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
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public offset_v3() {
         addGroupMeta(this);
         offset = new LVect3d ( ) ;
         offset . x = 2 * Math . random ( ) - 1 ;
         offset . y = 2 * Math . random ( ) - 1 ;
         offset . z = 2 * Math . random ( ) - 1 ;
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         final LVect3d x = (LVect3d)inputs[0];
         return offset . add ( x ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class scale_d extends ExpressionFunction {

      private double scale;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return scale;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "scale";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: scale = (Double) value; return;
            default: return;
         }

      }

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

      public scale_d() {
         addGroupMeta(this);
         scale = 3 * Math . random ( ) ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return x . mult ( scale ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class scale_c extends ExpressionFunction {

      private double scale;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return scale;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "scale";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: scale = (Double) value; return;
            default: return;
         }

      }

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

      public scale_c() {
         addGroupMeta(this);
         scale = 3 * Math . random ( ) ;
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Complex x = (Complex)inputs[0];
         return x . mult ( scale ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class scale_v2 extends ExpressionFunction {

      private double scale;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return scale;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "scale";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: scale = (Double) value; return;
            default: return;
         }

      }

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

      public scale_v2() {
         addGroupMeta(this);
         scale = 3 * Math . random ( ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         return x . mult ( scale ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class scale_v3 extends ExpressionFunction {

      private double scale;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return scale;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "scale";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: scale = (Double) value; return;
            default: return;
         }

      }

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
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public scale_v3() {
         addGroupMeta(this);
         scale = 3 * Math . random ( ) ;
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         final LVect3d x = (LVect3d)inputs[0];
         return x . mult ( scale ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class scale_col extends ExpressionFunction {

      private double scale;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return scale;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "scale";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: scale = (Double) value; return;
            default: return;
         }

      }

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

      public scale_col() {
         addGroupMeta(this);
         scale = 3 * Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         return x . mult ( scale ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class mod_d extends ExpressionFunction {

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

      public mod_d() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( x . val - Math . floor ( x . val ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class mod_v2 extends ExpressionFunction {

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

      public mod_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         return new LVect2d ( x . x - Math . floor ( x . x ) , x . y - Math . floor ( x . y ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class mod_v3 extends ExpressionFunction {

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
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public mod_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         final LVect3d x = (LVect3d)inputs[0];
         return new LVect3d ( x . x - Math . floor ( x . x ) , x . y - Math . floor ( x . y ) , x . z - Math . floor ( x . z ) ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public String getDescription() {
      return "alegebraic functions";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new avg_d());
      r.add(new avg_i());
      r.add(new avg_c());
      r.add(new avg_v2());
      r.add(new avg_v3());
      r.add(new add_col());
      r.add(new add_d());
      r.add(new add_i());
      r.add(new add_c());
      r.add(new add_v2());
      r.add(new add_v3());
      r.add(new sub_col());
      r.add(new sub_c());
      r.add(new sub_d());
      r.add(new sub_i());
      r.add(new sub_v2());
      r.add(new sub_v3());
      r.add(new mult_col());
      r.add(new mult_d());
      r.add(new mult_i());
      r.add(new mult_i_d());
      r.add(new mult_c());
      r.add(new mult_c_c());
      r.add(new mult_v2());
      r.add(new mult_v2_v2());
      r.add(new mult_v3());
      r.add(new mult_v3_v3());
      r.add(new pow_col());
      r.add(new pow_col_col());
      r.add(new pow_d());
      r.add(new pow_v2());
      r.add(new pow_v2_v2());
      r.add(new pow_v3());
      r.add(new pow_v3_v3());
      r.add(new offset_col());
      r.add(new offset_d());
      r.add(new offset_c());
      r.add(new offset_v2());
      r.add(new offset_v3());
      r.add(new scale_d());
      r.add(new scale_c());
      r.add(new scale_v2());
      r.add(new scale_v3());
      r.add(new scale_col());
      r.add(new mod_d());
      r.add(new mod_v2());
      r.add(new mod_v3());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
