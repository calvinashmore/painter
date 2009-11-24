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

public final class Analytic implements AllComponents<ExpressionFunction>, Described {

   public static class Gaussian_v2 extends ExpressionFunction {
      double gauss ( double x ) { return Math . exp ( - x * x ) ; }
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

      public Gaussian_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         return new LVect2d ( gauss ( x . x ) , gauss ( x . y ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Squash_v2 extends ExpressionFunction {
      double squash ( double x ) { return x / ( 1.0 + Math . abs ( x ) ) ; }
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

      public Squash_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         return new LVect2d ( squash ( x . x ) , squash ( x . y ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Squash2_v2 extends ExpressionFunction {
      double squash ( double x , double y ) { return x / ( y + Math . abs ( x ) ) ; }
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

      public Squash2_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         final LDouble y = (LDouble)inputs[1];
         return new LVect2d ( squash ( x . x , y . val ) , squash ( x . y , y . val ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Sigmoid_v2 extends ExpressionFunction {
      double squash ( double x ) { return 1 / ( 1.0 + Math . exp ( - x ) ) ; }
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

      public Sigmoid_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         return new LVect2d ( squash ( x . x ) , squash ( x . y ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Gaussian_v3 extends ExpressionFunction {
      double gauss ( double x ) { return Math . exp ( - x * x ) ; }
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

      public Gaussian_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         final LVect3d x = (LVect3d)inputs[0];
         return new LVect3d ( gauss ( x . x ) , gauss ( x . y ) , gauss ( x . z ) ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Squash_v3 extends ExpressionFunction {
      double squash ( double x ) { return x / ( 1.0 + Math . abs ( x ) ) ; }
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

      public Squash_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         final LVect3d x = (LVect3d)inputs[0];
         return new LVect3d ( squash ( x . x ) , squash ( x . y ) , squash ( x . z ) ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Squash2_v3 extends ExpressionFunction {
      double squash ( double x , double y ) { return x / ( y + Math . abs ( x ) ) ; }
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

      public Squash2_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         final LVect3d x = (LVect3d)inputs[0];
         final LDouble y = (LDouble)inputs[1];
         return new LVect3d ( squash ( x . x , y . val ) , squash ( x . y , y . val ) , squash ( x . z , y . val ) ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Sigmoid_v3 extends ExpressionFunction {
      double squash ( double x ) { return 1 / ( 1.0 + Math . exp ( - x ) ) ; }
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

      public Sigmoid_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         final LVect3d x = (LVect3d)inputs[0];
         return new LVect3d ( squash ( x . x ) , squash ( x . y ) , squash ( x . z ) ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Gaussian_col extends ExpressionFunction {
      double gauss ( double x ) { return Math . exp ( - x * x ) ; }
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

      public Gaussian_col() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         return new Color ( gauss ( x . r ) , gauss ( x . g ) , gauss ( x . b ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Squash_col extends ExpressionFunction {
      double squash ( double x ) { return x / ( 1.0 + Math . abs ( x ) ) ; }
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

      public Squash_col() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         return new Color ( squash ( x . r ) , squash ( x . g ) , squash ( x . b ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Squash2_col extends ExpressionFunction {
      double squash ( double x , double y ) { return x / ( y + Math . abs ( x ) ) ; }
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

      public Squash2_col() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         final LDouble y = (LDouble)inputs[1];
         return new Color ( squash ( x . r , y . val ) , squash ( x . g , y . val ) , squash ( x . b , y . val ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Sigmoid_col extends ExpressionFunction {
      double squash ( double x ) { return 1 / ( 1.0 + Math . exp ( - x ) ) ; }
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

      public Sigmoid_col() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Color x = (Color)inputs[0];
         return new Color ( squash ( x . r ) , squash ( x . g ) , squash ( x . b ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Abs extends ExpressionFunction {

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

      public Abs() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( Math . abs ( x . val ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Step extends ExpressionFunction {

      private double steps;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return steps;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "steps";
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
            case 0: steps = (Double) value; return;
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

      public Step() {
         addGroupMeta(this);
         steps = 5 + Math . random ( ) * 10 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( ( int ) ( x . val * steps ) / ( double ) steps ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Sawtooth extends ExpressionFunction {

      private double steps;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return steps;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "steps";
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
            case 0: steps = (Double) value; return;
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

      public Sawtooth() {
         addGroupMeta(this);
         steps = 5 + Math . random ( ) * 10 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         double x1 = x . val * steps ;
         double xbase = Math . floor ( x1 ) ;
         return new LDouble ( x1 - xbase ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Inverse extends ExpressionFunction {

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

      public Inverse() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( 1 / x . val ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Square extends ExpressionFunction {

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

      public Square() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( x . val * x . val ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Cube extends ExpressionFunction {

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

      public Cube() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( x . val * x . val * x . val ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Sqrt extends ExpressionFunction {

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

      public Sqrt() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( Math . sqrt ( x . val ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Cbrt extends ExpressionFunction {

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

      public Cbrt() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( Math . cbrt ( x . val ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Gaussian extends ExpressionFunction {
      double gauss ( double x ) { return Math . exp ( - x * x ) ; }
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

      public Gaussian() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( gauss ( x . val ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Squash extends ExpressionFunction {
      double squash ( double x ) { return x / ( 1.0 + Math . abs ( x ) ) ; }
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

      public Squash() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( squash ( x . val ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Squash2 extends ExpressionFunction {
      double squash ( double x , double y ) { return x / ( y + Math . abs ( x ) ) ; }
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

      public Squash2() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         final LDouble y = (LDouble)inputs[1];
         return new LDouble ( squash ( x . val , y . val ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Sigmoid extends ExpressionFunction {
      double squash ( double x ) { return 1 / ( 1.0 + Math . exp ( - x ) ) ; }
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

      public Sigmoid() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( squash ( x . val ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Exp extends ExpressionFunction {

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

      public Exp() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( Math . exp ( x . val ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Log extends ExpressionFunction {

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

      public Log() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( Math . log ( x . val ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Sin extends ExpressionFunction {

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

      public Sin() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( Math . sin ( x . val ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Cos extends ExpressionFunction {

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

      public Cos() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( Math . cos ( x . val ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Tan extends ExpressionFunction {

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

      public Tan() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( Math . tan ( x . val ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Sinh extends ExpressionFunction {

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

      public Sinh() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( Math . sinh ( x . val ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Cosh extends ExpressionFunction {

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

      public Cosh() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( Math . cosh ( x . val ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Tanh extends ExpressionFunction {

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

      public Tanh() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( Math . tanh ( x . val ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class ASin extends ExpressionFunction {

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

      public ASin() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( Math . asin ( x . val ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class ACos extends ExpressionFunction {

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

      public ACos() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( Math . acos ( x . val ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class ATan extends ExpressionFunction {

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

      public ATan() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final LDouble x = (LDouble)inputs[0];
         return new LDouble ( Math . atan ( x . val ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public String getDescription() {
      return "analytic functions";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new Gaussian_v2());
      r.add(new Squash_v2());
      r.add(new Squash2_v2());
      r.add(new Sigmoid_v2());
      r.add(new Gaussian_v3());
      r.add(new Squash_v3());
      r.add(new Squash2_v3());
      r.add(new Sigmoid_v3());
      r.add(new Gaussian_col());
      r.add(new Squash_col());
      r.add(new Squash2_col());
      r.add(new Sigmoid_col());
      r.add(new Abs());
      r.add(new Step());
      r.add(new Sawtooth());
      r.add(new Inverse());
      r.add(new Square());
      r.add(new Cube());
      r.add(new Sqrt());
      r.add(new Cbrt());
      r.add(new Gaussian());
      r.add(new Squash());
      r.add(new Squash2());
      r.add(new Sigmoid());
      r.add(new Exp());
      r.add(new Log());
      r.add(new Sin());
      r.add(new Cos());
      r.add(new Tan());
      r.add(new Sinh());
      r.add(new Cosh());
      r.add(new Tanh());
      r.add(new ASin());
      r.add(new ACos());
      r.add(new ATan());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
