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
import utils.noise.*;

public final class Noise1 implements AllComponents<ExpressionFunction>, Described {

   public static class Noise_d_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Noise_d_d() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LDouble x = (LDouble)inputs[1];
         return new LDouble ( noise . noise ( x . val , 0 , 0 ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Noise_d_d_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Noise_d_d_n() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LDouble x = (LDouble)inputs[1];
         return new LDouble ( noise . noise ( x . val , 0 , 0 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Noise_d_v2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Noise_d_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LDouble x = (LDouble)inputs[1];
         return new LVect2d ( noise . noise ( x . val , 0 , 0 ) , noise . noise ( x . val + 100 , 100 , 100 ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Noise_d_v2_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Noise_d_v2_n() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LDouble x = (LDouble)inputs[1];
         return new LVect2d ( noise . noise ( x . val , 0 , 0 ) , noise . noise ( x . val + 100 , 100 , 100 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Noise_d_c extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Noise_d_c() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LDouble x = (LDouble)inputs[1];
         return new Complex ( noise . noise ( x . val , 0 , 0 ) , noise . noise ( x . val + 100 , 100 , 100 ) ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Noise_d_c_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Noise_d_c_n() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LDouble x = (LDouble)inputs[1];
         return new Complex ( noise . noise ( x . val , 0 , 0 ) , noise . noise ( x . val + 100 , 100 , 100 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Noise_d_v3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Noise_d_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LDouble x = (LDouble)inputs[1];
         return new LVect3d ( noise . noise ( x . val , 0 , 0 ) , noise . noise ( x . val + 100 , 100 , 100 ) , noise . noise ( x . val + 300 , 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Noise_d_v3_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Noise_d_v3_n() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LDouble x = (LDouble)inputs[1];
         return new LVect3d ( noise . noise ( x . val , 0 , 0 ) , noise . noise ( x . val + 100 , 100 , 100 ) , noise . noise ( x . val + 300 , 300 , 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Noise_d_col extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Noise_d_col() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LDouble x = (LDouble)inputs[1];
         return new Color ( .5 + .5 * noise . noise ( x . val , 0 , 0 ) , .5 + .5 * noise . noise ( x . val + 100 , 100 , 100 ) , .5 + .5 * noise . noise ( x . val + 300 , 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_d_col_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Noise_d_col_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LDouble x = (LDouble)inputs[1];
         return new Color ( .5 + .5 * noise . noise ( x . val , 0 , 0 ) , .5 + .5 * noise . noise ( x . val + 100 , 100 , 100 ) , .5 + .5 * noise . noise ( x . val + 300 , 300 , 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_d_col1 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Noise_d_col1() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LDouble x = (LDouble)inputs[1];
         return Color . makeHSB ( noise . noise ( x . val , 0 , 0 ) , .5 + .5 * noise . noise ( x . val + 100 , 100 , 100 ) , .5 + .5 * noise . noise ( x . val + 300 , 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_d_col1_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Noise_d_col1_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LDouble x = (LDouble)inputs[1];
         LVect3d v = new LVect3d ( noise . noise ( x . val , 0 , 0 ) , .5 + .5 * noise . noise ( x . val + 100 , 100 , 100 ) , .5 + .5 * noise . noise ( x . val + 300 , 300 , 300 ) ) . normal ( ) ;
         return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_d_colA extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Noise_d_colA() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LDouble x = (LDouble)inputs[1];
         return new Color ( noise . noise ( x . val , 0 , 0 ) , noise . noise ( x . val + 100 , 100 , 100 ) , noise . noise ( x . val + 300 , 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_d_colA_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Noise_d_colA_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LDouble x = (LDouble)inputs[1];
         return new Color ( noise . noise ( x . val , 0 , 0 ) , noise . noise ( x . val + 100 , 100 , 100 ) , noise . noise ( x . val + 300 , 300 , 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_d_col1A extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Noise_d_col1A() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LDouble x = (LDouble)inputs[1];
         return Color . makeHSB ( noise . noise ( x . val , 0 , 0 ) , noise . noise ( x . val + 100 , 100 , 100 ) , noise . noise ( x . val + 300 , 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_d_col1A_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Noise_d_col1A_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LDouble x = (LDouble)inputs[1];
         LVect3d v = new LVect3d ( noise . noise ( x . val , 0 , 0 ) , noise . noise ( x . val + 100 , 100 , 100 ) , noise . noise ( x . val + 300 , 300 , 300 ) ) . normal ( ) ;
         return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_v2_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public Noise_v2_d() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect2d x = (LVect2d)inputs[1];
         return new LDouble ( noise . noise ( x . x , x . y , 0 ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Noise_v2_d_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public Noise_v2_d_n() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect2d x = (LVect2d)inputs[1];
         return new LDouble ( noise . noise ( x . x , x . y , 0 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Noise_v2_v2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public Noise_v2_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect2d x = (LVect2d)inputs[1];
         return new LVect2d ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Noise_v2_v2_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public Noise_v2_v2_n() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect2d x = (LVect2d)inputs[1];
         return new LVect2d ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Noise_v2_c extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public Noise_v2_c() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect2d x = (LVect2d)inputs[1];
         return new Complex ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Noise_v2_c_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public Noise_v2_c_n() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect2d x = (LVect2d)inputs[1];
         return new Complex ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Noise_v2_v3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public Noise_v2_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect2d x = (LVect2d)inputs[1];
         return new LVect3d ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Noise_v2_v3_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public Noise_v2_v3_n() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect2d x = (LVect2d)inputs[1];
         return new LVect3d ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Noise_v2_col extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public Noise_v2_col() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect2d x = (LVect2d)inputs[1];
         return new Color ( .5 + .5 * noise . noise ( x . x , x . y , 0 ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_v2_col_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public Noise_v2_col_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect2d x = (LVect2d)inputs[1];
         return new Color ( .5 + .5 * noise . noise ( x . x , x . y , 0 ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_v2_col1 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public Noise_v2_col1() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect2d x = (LVect2d)inputs[1];
         return Color . makeHSB ( noise . noise ( x . x , x . y , 0 ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_v2_col1_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public Noise_v2_col1_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect2d x = (LVect2d)inputs[1];
         LVect3d v = new LVect3d ( noise . noise ( x . x , x . y , 0 ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
         return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_v2_colA extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public Noise_v2_colA() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect2d x = (LVect2d)inputs[1];
         return new Color ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_v2_colA_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public Noise_v2_colA_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect2d x = (LVect2d)inputs[1];
         return new Color ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_v2_col1A extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public Noise_v2_col1A() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect2d x = (LVect2d)inputs[1];
         return Color . makeHSB ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_v2_col1A_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public Noise_v2_col1A_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect2d x = (LVect2d)inputs[1];
         LVect3d v = new LVect3d ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
         return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_c_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return Complex.class;
            default: return null;
         }

      }

      public Noise_c_d() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         Complex x = (Complex)inputs[1];
         return new LDouble ( noise . noise ( x . x , x . y , 0 ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Noise_c_d_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return Complex.class;
            default: return null;
         }

      }

      public Noise_c_d_n() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         Complex x = (Complex)inputs[1];
         return new LDouble ( noise . noise ( x . x , x . y , 0 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Noise_c_v2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return Complex.class;
            default: return null;
         }

      }

      public Noise_c_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         Complex x = (Complex)inputs[1];
         return new LVect2d ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Noise_c_v2_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return Complex.class;
            default: return null;
         }

      }

      public Noise_c_v2_n() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         Complex x = (Complex)inputs[1];
         return new LVect2d ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Noise_c_c extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return Complex.class;
            default: return null;
         }

      }

      public Noise_c_c() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         Complex x = (Complex)inputs[1];
         return new Complex ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Noise_c_c_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return Complex.class;
            default: return null;
         }

      }

      public Noise_c_c_n() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         Complex x = (Complex)inputs[1];
         return new Complex ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Noise_c_v3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return Complex.class;
            default: return null;
         }

      }

      public Noise_c_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         Complex x = (Complex)inputs[1];
         return new LVect3d ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Noise_c_v3_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return Complex.class;
            default: return null;
         }

      }

      public Noise_c_v3_n() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         Complex x = (Complex)inputs[1];
         return new LVect3d ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Noise_c_col extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return Complex.class;
            default: return null;
         }

      }

      public Noise_c_col() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         Complex x = (Complex)inputs[1];
         return new Color ( .5 + .5 * noise . noise ( x . x , x . y , 0 ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_c_col_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return Complex.class;
            default: return null;
         }

      }

      public Noise_c_col_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         Complex x = (Complex)inputs[1];
         return new Color ( .5 + .5 * noise . noise ( x . x , x . y , 0 ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_c_col1 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return Complex.class;
            default: return null;
         }

      }

      public Noise_c_col1() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         Complex x = (Complex)inputs[1];
         return Color . makeHSB ( noise . noise ( x . x , x . y , 0 ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_c_col1_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return Complex.class;
            default: return null;
         }

      }

      public Noise_c_col1_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         Complex x = (Complex)inputs[1];
         LVect3d v = new LVect3d ( noise . noise ( x . x , x . y , 0 ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
         return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_c_colA extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return Complex.class;
            default: return null;
         }

      }

      public Noise_c_colA() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         Complex x = (Complex)inputs[1];
         return new Color ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_c_colA_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return Complex.class;
            default: return null;
         }

      }

      public Noise_c_colA_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         Complex x = (Complex)inputs[1];
         return new Color ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_c_col1A extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return Complex.class;
            default: return null;
         }

      }

      public Noise_c_col1A() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         Complex x = (Complex)inputs[1];
         return Color . makeHSB ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_c_col1A_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return Complex.class;
            default: return null;
         }

      }

      public Noise_c_col1A_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         Complex x = (Complex)inputs[1];
         LVect3d v = new LVect3d ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
         return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_v3_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public Noise_v3_d() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect3d x = (LVect3d)inputs[1];
         return new LDouble ( noise . noise ( x . x , x . y , x . z ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Noise_v3_d_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public Noise_v3_d_n() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect3d x = (LVect3d)inputs[1];
         return new LDouble ( noise . noise ( x . x , x . y , x . z ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Noise_v3_v2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public Noise_v3_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect3d x = (LVect3d)inputs[1];
         return new LVect2d ( noise . noise ( x . x , x . y , x . z ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Noise_v3_v2_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public Noise_v3_v2_n() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect3d x = (LVect3d)inputs[1];
         return new LVect2d ( noise . noise ( x . x , x . y , x . z ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Noise_v3_c extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public Noise_v3_c() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect3d x = (LVect3d)inputs[1];
         return new Complex ( noise . noise ( x . x , x . y , x . z ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Noise_v3_c_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public Noise_v3_c_n() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect3d x = (LVect3d)inputs[1];
         return new Complex ( noise . noise ( x . x , x . y , x . z ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Noise_v3_v3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public Noise_v3_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect3d x = (LVect3d)inputs[1];
         return new LVect3d ( noise . noise ( x . x , x . y , x . z ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z + 300 ) ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Noise_v3_v3_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public Noise_v3_v3_n() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect3d x = (LVect3d)inputs[1];
         return new LVect3d ( noise . noise ( x . x , x . y , x . z ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Noise_v3_col extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public Noise_v3_col() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect3d x = (LVect3d)inputs[1];
         return new Color ( .5 + .5 * noise . noise ( x . x , x . y , x . z ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , x . z + 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_v3_col_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public Noise_v3_col_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect3d x = (LVect3d)inputs[1];
         return new Color ( .5 + .5 * noise . noise ( x . x , x . y , x . z ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_v3_col1 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public Noise_v3_col1() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect3d x = (LVect3d)inputs[1];
         return Color . makeHSB ( noise . noise ( x . x , x . y , x . z ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , x . z + 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_v3_col1_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public Noise_v3_col1_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect3d x = (LVect3d)inputs[1];
         LVect3d v = new LVect3d ( noise . noise ( x . x , x . y , x . z ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
         return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_v3_colA extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public Noise_v3_colA() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect3d x = (LVect3d)inputs[1];
         return new Color ( noise . noise ( x . x , x . y , x . z ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z + 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_v3_colA_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public Noise_v3_colA_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect3d x = (LVect3d)inputs[1];
         return new Color ( noise . noise ( x . x , x . y , x . z ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_v3_col1A extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public Noise_v3_col1A() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect3d x = (LVect3d)inputs[1];
         return Color . makeHSB ( noise . noise ( x . x , x . y , x . z ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z + 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Noise_v3_col1A_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public Noise_v3_col1A_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         LVect3d x = (LVect3d)inputs[1];
         LVect3d v = new LVect3d ( noise . noise ( x . x , x . y , x . z ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
         return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_d_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public Fractal_d_d() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LDouble x = (LDouble)inputs[2];
         return new LDouble ( fractal . evalFractal ( noise , x . val , 0 , 0 ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Fractal_d_d_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public Fractal_d_d_n() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LDouble x = (LDouble)inputs[2];
         return new LDouble ( fractal . evalFractal ( noise , x . val , 0 , 0 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Fractal_d_v2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public Fractal_d_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LDouble x = (LDouble)inputs[2];
         return new LVect2d ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Fractal_d_v2_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public Fractal_d_v2_n() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LDouble x = (LDouble)inputs[2];
         return new LVect2d ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Fractal_d_c extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public Fractal_d_c() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LDouble x = (LDouble)inputs[2];
         return new Complex ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Fractal_d_c_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public Fractal_d_c_n() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LDouble x = (LDouble)inputs[2];
         return new Complex ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Fractal_d_v3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public Fractal_d_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LDouble x = (LDouble)inputs[2];
         return new LVect3d ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) , fractal . evalFractal ( noise , x . val + 300 , 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Fractal_d_v3_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public Fractal_d_v3_n() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LDouble x = (LDouble)inputs[2];
         return new LVect3d ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) , fractal . evalFractal ( noise , x . val + 300 , 300 , 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Fractal_d_col extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public Fractal_d_col() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LDouble x = (LDouble)inputs[2];
         return new Color ( .5 + .5 * fractal . evalFractal ( noise , x . val , 0 , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . val + 300 , 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_d_col_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public Fractal_d_col_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LDouble x = (LDouble)inputs[2];
         return new Color ( .5 + .5 * fractal . evalFractal ( noise , x . val , 0 , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . val + 300 , 300 , 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_d_col1 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public Fractal_d_col1() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LDouble x = (LDouble)inputs[2];
         return Color . makeHSB ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . val + 300 , 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_d_col1_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public Fractal_d_col1_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LDouble x = (LDouble)inputs[2];
         LVect3d v = new LVect3d ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . val + 300 , 300 , 300 ) ) . normal ( ) ;
         return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_d_colA extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public Fractal_d_colA() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LDouble x = (LDouble)inputs[2];
         return new Color ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) , fractal . evalFractal ( noise , x . val + 300 , 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_d_colA_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public Fractal_d_colA_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LDouble x = (LDouble)inputs[2];
         return new Color ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) , fractal . evalFractal ( noise , x . val + 300 , 300 , 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_d_col1A extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public Fractal_d_col1A() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LDouble x = (LDouble)inputs[2];
         return Color . makeHSB ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) , fractal . evalFractal ( noise , x . val + 300 , 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_d_col1A_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public Fractal_d_col1A_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LDouble x = (LDouble)inputs[2];
         LVect3d v = new LVect3d ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) , fractal . evalFractal ( noise , x . val + 300 , 300 , 300 ) ) . normal ( ) ;
         return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_v2_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public Fractal_v2_d() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect2d x = (LVect2d)inputs[2];
         return new LDouble ( fractal . evalFractal ( noise , x . x , x . y , 0 ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Fractal_v2_d_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public Fractal_v2_d_n() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect2d x = (LVect2d)inputs[2];
         return new LDouble ( fractal . evalFractal ( noise , x . x , x . y , 0 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Fractal_v2_v2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public Fractal_v2_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect2d x = (LVect2d)inputs[2];
         return new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Fractal_v2_v2_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public Fractal_v2_v2_n() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect2d x = (LVect2d)inputs[2];
         return new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Fractal_v2_c extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public Fractal_v2_c() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect2d x = (LVect2d)inputs[2];
         return new Complex ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Fractal_v2_c_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public Fractal_v2_c_n() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect2d x = (LVect2d)inputs[2];
         return new Complex ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Fractal_v2_v3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public Fractal_v2_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect2d x = (LVect2d)inputs[2];
         return new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Fractal_v2_v3_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public Fractal_v2_v3_n() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect2d x = (LVect2d)inputs[2];
         return new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Fractal_v2_col extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public Fractal_v2_col() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect2d x = (LVect2d)inputs[2];
         return new Color ( .5 + .5 * fractal . evalFractal ( noise , x . x , x . y , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_v2_col_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public Fractal_v2_col_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect2d x = (LVect2d)inputs[2];
         return new Color ( .5 + .5 * fractal . evalFractal ( noise , x . x , x . y , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_v2_col1 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public Fractal_v2_col1() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect2d x = (LVect2d)inputs[2];
         return Color . makeHSB ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_v2_col1_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public Fractal_v2_col1_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect2d x = (LVect2d)inputs[2];
         LVect3d v = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
         ;
         return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_v2_colA extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public Fractal_v2_colA() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect2d x = (LVect2d)inputs[2];
         return new Color ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_v2_colA_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public Fractal_v2_colA_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect2d x = (LVect2d)inputs[2];
         return new Color ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_v2_col1A extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public Fractal_v2_col1A() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect2d x = (LVect2d)inputs[2];
         return Color . makeHSB ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_v2_col1A_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public Fractal_v2_col1A_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect2d x = (LVect2d)inputs[2];
         LVect3d v = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
         ;
         return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_c_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return Complex.class;
            default: return null;
         }

      }

      public Fractal_c_d() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         Complex x = (Complex)inputs[2];
         return new LDouble ( fractal . evalFractal ( noise , x . x , x . y , 0 ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Fractal_c_d_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return Complex.class;
            default: return null;
         }

      }

      public Fractal_c_d_n() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         Complex x = (Complex)inputs[2];
         return new LDouble ( fractal . evalFractal ( noise , x . x , x . y , 0 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Fractal_c_v2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return Complex.class;
            default: return null;
         }

      }

      public Fractal_c_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         Complex x = (Complex)inputs[2];
         return new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Fractal_c_v2_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return Complex.class;
            default: return null;
         }

      }

      public Fractal_c_v2_n() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         Complex x = (Complex)inputs[2];
         return new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Fractal_c_c extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return Complex.class;
            default: return null;
         }

      }

      public Fractal_c_c() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         Complex x = (Complex)inputs[2];
         return new Complex ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Fractal_c_c_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return Complex.class;
            default: return null;
         }

      }

      public Fractal_c_c_n() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         Complex x = (Complex)inputs[2];
         return new Complex ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Fractal_c_v3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return Complex.class;
            default: return null;
         }

      }

      public Fractal_c_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         Complex x = (Complex)inputs[2];
         return new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Fractal_c_v3_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return Complex.class;
            default: return null;
         }

      }

      public Fractal_c_v3_n() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         Complex x = (Complex)inputs[2];
         return new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Fractal_c_col extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return Complex.class;
            default: return null;
         }

      }

      public Fractal_c_col() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         Complex x = (Complex)inputs[2];
         return new Color ( .5 + .5 * fractal . evalFractal ( noise , x . x , x . y , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_c_col_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return Complex.class;
            default: return null;
         }

      }

      public Fractal_c_col_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         Complex x = (Complex)inputs[2];
         return new Color ( .5 + .5 * fractal . evalFractal ( noise , x . x , x . y , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_c_col1 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return Complex.class;
            default: return null;
         }

      }

      public Fractal_c_col1() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         Complex x = (Complex)inputs[2];
         return Color . makeHSB ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_c_col1_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return Complex.class;
            default: return null;
         }

      }

      public Fractal_c_col1_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         Complex x = (Complex)inputs[2];
         LVect3d v = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
         return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_c_colA extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return Complex.class;
            default: return null;
         }

      }

      public Fractal_c_colA() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         Complex x = (Complex)inputs[2];
         return new Color ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_c_colA_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return Complex.class;
            default: return null;
         }

      }

      public Fractal_c_colA_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         Complex x = (Complex)inputs[2];
         return new Color ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_c_col1A extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return Complex.class;
            default: return null;
         }

      }

      public Fractal_c_col1A() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         Complex x = (Complex)inputs[2];
         return Color . makeHSB ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_c_col1A_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return Complex.class;
            default: return null;
         }

      }

      public Fractal_c_col1A_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         Complex x = (Complex)inputs[2];
         LVect3d v = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
         return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_v3_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Fractal_v3_d() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect3d x = (LVect3d)inputs[2];
         return new LDouble ( fractal . evalFractal ( noise , x . x , x . y , x . z ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Fractal_v3_d_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Fractal_v3_d_n() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect3d x = (LVect3d)inputs[2];
         return new LDouble ( fractal . evalFractal ( noise , x . x , x . y , x . z ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Fractal_v3_v2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Fractal_v3_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect3d x = (LVect3d)inputs[2];
         return new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Fractal_v3_v2_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Fractal_v3_v2_n() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect3d x = (LVect3d)inputs[2];
         return new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Fractal_v3_c extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Fractal_v3_c() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect3d x = (LVect3d)inputs[2];
         return new Complex ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Fractal_v3_c_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Fractal_v3_c_n() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect3d x = (LVect3d)inputs[2];
         return new Complex ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Fractal_v3_v3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Fractal_v3_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect3d x = (LVect3d)inputs[2];
         return new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + 300 ) ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Fractal_v3_v3_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Fractal_v3_v3_n() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect3d x = (LVect3d)inputs[2];
         return new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Fractal_v3_col extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Fractal_v3_col() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect3d x = (LVect3d)inputs[2];
         return new Color ( .5 + .5 * fractal . evalFractal ( noise , x . x , x . y , x . z ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_v3_col_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Fractal_v3_col_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect3d x = (LVect3d)inputs[2];
         return new Color ( .5 + .5 * fractal . evalFractal ( noise , x . x , x . y , x . z ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_v3_col1 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Fractal_v3_col1() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect3d x = (LVect3d)inputs[2];
         return Color . makeHSB ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_v3_col1_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Fractal_v3_col1_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect3d x = (LVect3d)inputs[2];
         LVect3d v = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
         return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_v3_colA extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Fractal_v3_colA() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect3d x = (LVect3d)inputs[2];
         return new Color ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_v3_colA_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Fractal_v3_colA_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect3d x = (LVect3d)inputs[2];
         return new Color ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_v3_col1A extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Fractal_v3_col1A() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect3d x = (LVect3d)inputs[2];
         return Color . makeHSB ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + 300 ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Fractal_v3_col1A_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            case 2: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Fractal_v3_col1A_n() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         NoiseFunction noise = (NoiseFunction)inputs[0];
         NoiseFractal fractal = (NoiseFractal)inputs[1];
         LVect3d x = (LVect3d)inputs[2];
         LVect3d v = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
         return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public String getDescription() {
      return "Noise: Evaluation";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new Noise_d_d());
      r.add(new Noise_d_d_n());
      r.add(new Noise_d_v2());
      r.add(new Noise_d_v2_n());
      r.add(new Noise_d_c());
      r.add(new Noise_d_c_n());
      r.add(new Noise_d_v3());
      r.add(new Noise_d_v3_n());
      r.add(new Noise_d_col());
      r.add(new Noise_d_col_n());
      r.add(new Noise_d_col1());
      r.add(new Noise_d_col1_n());
      r.add(new Noise_d_colA());
      r.add(new Noise_d_colA_n());
      r.add(new Noise_d_col1A());
      r.add(new Noise_d_col1A_n());
      r.add(new Noise_v2_d());
      r.add(new Noise_v2_d_n());
      r.add(new Noise_v2_v2());
      r.add(new Noise_v2_v2_n());
      r.add(new Noise_v2_c());
      r.add(new Noise_v2_c_n());
      r.add(new Noise_v2_v3());
      r.add(new Noise_v2_v3_n());
      r.add(new Noise_v2_col());
      r.add(new Noise_v2_col_n());
      r.add(new Noise_v2_col1());
      r.add(new Noise_v2_col1_n());
      r.add(new Noise_v2_colA());
      r.add(new Noise_v2_colA_n());
      r.add(new Noise_v2_col1A());
      r.add(new Noise_v2_col1A_n());
      r.add(new Noise_c_d());
      r.add(new Noise_c_d_n());
      r.add(new Noise_c_v2());
      r.add(new Noise_c_v2_n());
      r.add(new Noise_c_c());
      r.add(new Noise_c_c_n());
      r.add(new Noise_c_v3());
      r.add(new Noise_c_v3_n());
      r.add(new Noise_c_col());
      r.add(new Noise_c_col_n());
      r.add(new Noise_c_col1());
      r.add(new Noise_c_col1_n());
      r.add(new Noise_c_colA());
      r.add(new Noise_c_colA_n());
      r.add(new Noise_c_col1A());
      r.add(new Noise_c_col1A_n());
      r.add(new Noise_v3_d());
      r.add(new Noise_v3_d_n());
      r.add(new Noise_v3_v2());
      r.add(new Noise_v3_v2_n());
      r.add(new Noise_v3_c());
      r.add(new Noise_v3_c_n());
      r.add(new Noise_v3_v3());
      r.add(new Noise_v3_v3_n());
      r.add(new Noise_v3_col());
      r.add(new Noise_v3_col_n());
      r.add(new Noise_v3_col1());
      r.add(new Noise_v3_col1_n());
      r.add(new Noise_v3_colA());
      r.add(new Noise_v3_colA_n());
      r.add(new Noise_v3_col1A());
      r.add(new Noise_v3_col1A_n());
      r.add(new Fractal_d_d());
      r.add(new Fractal_d_d_n());
      r.add(new Fractal_d_v2());
      r.add(new Fractal_d_v2_n());
      r.add(new Fractal_d_c());
      r.add(new Fractal_d_c_n());
      r.add(new Fractal_d_v3());
      r.add(new Fractal_d_v3_n());
      r.add(new Fractal_d_col());
      r.add(new Fractal_d_col_n());
      r.add(new Fractal_d_col1());
      r.add(new Fractal_d_col1_n());
      r.add(new Fractal_d_colA());
      r.add(new Fractal_d_colA_n());
      r.add(new Fractal_d_col1A());
      r.add(new Fractal_d_col1A_n());
      r.add(new Fractal_v2_d());
      r.add(new Fractal_v2_d_n());
      r.add(new Fractal_v2_v2());
      r.add(new Fractal_v2_v2_n());
      r.add(new Fractal_v2_c());
      r.add(new Fractal_v2_c_n());
      r.add(new Fractal_v2_v3());
      r.add(new Fractal_v2_v3_n());
      r.add(new Fractal_v2_col());
      r.add(new Fractal_v2_col_n());
      r.add(new Fractal_v2_col1());
      r.add(new Fractal_v2_col1_n());
      r.add(new Fractal_v2_colA());
      r.add(new Fractal_v2_colA_n());
      r.add(new Fractal_v2_col1A());
      r.add(new Fractal_v2_col1A_n());
      r.add(new Fractal_c_d());
      r.add(new Fractal_c_d_n());
      r.add(new Fractal_c_v2());
      r.add(new Fractal_c_v2_n());
      r.add(new Fractal_c_c());
      r.add(new Fractal_c_c_n());
      r.add(new Fractal_c_v3());
      r.add(new Fractal_c_v3_n());
      r.add(new Fractal_c_col());
      r.add(new Fractal_c_col_n());
      r.add(new Fractal_c_col1());
      r.add(new Fractal_c_col1_n());
      r.add(new Fractal_c_colA());
      r.add(new Fractal_c_colA_n());
      r.add(new Fractal_c_col1A());
      r.add(new Fractal_c_col1A_n());
      r.add(new Fractal_v3_d());
      r.add(new Fractal_v3_d_n());
      r.add(new Fractal_v3_v2());
      r.add(new Fractal_v3_v2_n());
      r.add(new Fractal_v3_c());
      r.add(new Fractal_v3_c_n());
      r.add(new Fractal_v3_v3());
      r.add(new Fractal_v3_v3_n());
      r.add(new Fractal_v3_col());
      r.add(new Fractal_v3_col_n());
      r.add(new Fractal_v3_col1());
      r.add(new Fractal_v3_col1_n());
      r.add(new Fractal_v3_colA());
      r.add(new Fractal_v3_colA_n());
      r.add(new Fractal_v3_col1A());
      r.add(new Fractal_v3_col1A_n());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
