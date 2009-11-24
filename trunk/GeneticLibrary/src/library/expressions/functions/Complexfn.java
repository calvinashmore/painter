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

public final class Complexfn implements AllComponents<ExpressionFunction>, Described {

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
            case 0: return Complex.class;
            default: return null;
         }

      }

      public Sin() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Complex x = (Complex)inputs[0];
         return new Complex ( Math . sin ( x . x ) * Math . cosh ( x . y ) , Math . cos ( x . x ) * Math . sinh ( x . y ) ) ;
      }

      public Class getReturnType() {
         return Complex.class;
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
            case 0: return Complex.class;
            default: return null;
         }

      }

      public Cos() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Complex x = (Complex)inputs[0];
         return new Complex ( Math . cos ( x . x ) * Math . cosh ( x . y ) , - Math . sin ( x . x ) * Math . sinh ( x . y ) ) ;
      }

      public Class getReturnType() {
         return Complex.class;
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
            case 0: return Complex.class;
            default: return null;
         }

      }

      public Tan() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Complex x = (Complex)inputs[0];
         return new Complex ( Math . sinh ( x . y ) * Math . cosh ( x . y ) , Math . sin ( x . x ) * Math . cos ( x . x ) ) . mult ( 1.0 / ( Math . cos ( x . x ) * Math . cos ( x . x ) + Math . sinh ( x . y ) * Math . sinh ( x . y ) ) ) ;
      }

      public Class getReturnType() {
         return Complex.class;
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
            case 0: return Complex.class;
            default: return null;
         }

      }

      public Sinh() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Complex x = (Complex)inputs[0];
         return new Complex ( Math . sinh ( x . x ) * Math . cos ( x . y ) , Math . cosh ( x . x ) * Math . sin ( x . y ) ) ;
      }

      public Class getReturnType() {
         return Complex.class;
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
            case 0: return Complex.class;
            default: return null;
         }

      }

      public Cosh() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Complex x = (Complex)inputs[0];
         return new Complex ( Math . cosh ( x . x ) * Math . cos ( x . y ) , Math . sinh ( x . x ) * Math . sin ( x . y ) ) ;
      }

      public Class getReturnType() {
         return Complex.class;
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
            case 0: return Complex.class;
            default: return null;
         }

      }

      public Tanh() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Complex x = (Complex)inputs[0];
         return new Complex ( Math . sinh ( x . x ) * Math . cosh ( x . x ) , Math . sin ( x . y ) * Math . cos ( x . y ) ) . mult ( 1.0 / ( Math . cos ( x . y ) * Math . cos ( x . y ) + Math . sinh ( x . x ) * Math . sinh ( x . x ) ) ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Asin extends ExpressionFunction {

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

      public Asin() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Complex x = (Complex)inputs[0];
         Complex r = new Complex ( - x . y , x . x ) . add ( new Complex ( 1 - x . x * x . x + x . y * x . y , - 2 * x . x * x . y ) . pow ( .5 ) ) . log ( ) ;
         Complex p = new Complex ( r . y , - r . x ) ;
         return p ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Acos extends ExpressionFunction {

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

      public Acos() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Complex x = (Complex)inputs[0];
         Complex r = new Complex ( - x . y , x . x ) . add ( new Complex ( 1 - x . x * x . x + x . y * x . y , - 2 * x . x * x . y ) . pow ( .5 ) ) . log ( ) ;
         Complex p = new Complex ( Math . PI / 2 - r . y , r . x ) ;
         return p ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Atan extends ExpressionFunction {

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

      public Atan() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Complex x = (Complex)inputs[0];
         Complex r = new Complex ( 1 + x . y , - x . x ) . log ( ) ;
         Complex s = new Complex ( 1 - x . y , x . x ) . log ( ) ;
         Complex t = r . add ( s ) ;
         Complex p = new Complex ( - t . y / 2 , t . x / 2 ) ;
         return p ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Pow extends ExpressionFunction {

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

      public Pow() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Complex x = (Complex)inputs[0];
         final Complex y = (Complex)inputs[1];
         Complex xlog = new Complex ( Math . log ( x . magnitude ( ) ) , x . theta ( ) ) ;
         Complex ymul = new Complex ( xlog . x * y . x - xlog . y * y . y , xlog . x * y . y + xlog . y * y . x ) ;
         Complex z = new Complex ( Math . exp ( ymul . x ) * Math . cos ( ymul . y ) , Math . exp ( ymul . x ) * Math . sin ( ymul . y ) ) ;
         return z ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Div extends ExpressionFunction {

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

      public Div() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Complex x = (Complex)inputs[0];
         final Complex y = (Complex)inputs[1];
         Complex z = new Complex ( ) ;
         z . x = x . x * y . x + x . y * y . y ;
         z . y = x . y * y . x - x . x * y . y ;
         double mag = x . magnitude ( ) * y . magnitude ( ) ;
         return z . mult ( 1.0 / mag ) ;
      }

      public Class getReturnType() {
         return Complex.class;
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
            case 0: return Complex.class;
            default: return null;
         }

      }

      public Exp() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Complex x = (Complex)inputs[0];
         return x . exp ( ) ;
      }

      public Class getReturnType() {
         return Complex.class;
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
            case 0: return Complex.class;
            default: return null;
         }

      }

      public Log() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Complex x = (Complex)inputs[0];
         return x . log ( ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class Spin extends ExpressionFunction {

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

      public Spin() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Complex x = (Complex)inputs[0];
         final Complex y = (Complex)inputs[1];
         Complex c = new Complex ( ) ;
         c . x = - x . x ;
         c . y = x . y + y . theta ( ) ;
         return c . exp ( ) . mult ( y . magnitude ( ) ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public String getDescription() {
      return "Functions for complex numbers";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new Sin());
      r.add(new Cos());
      r.add(new Tan());
      r.add(new Sinh());
      r.add(new Cosh());
      r.add(new Tanh());
      r.add(new Asin());
      r.add(new Acos());
      r.add(new Atan());
      r.add(new Pow());
      r.add(new Div());
      r.add(new Exp());
      r.add(new Log());
      r.add(new Spin());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
