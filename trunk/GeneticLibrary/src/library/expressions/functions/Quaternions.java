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

public final class Quaternions implements AllComponents<ExpressionFunction>, Described {

   public static class NewQuat4d extends ExpressionFunction {

      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "u";
            case 1: return "i";
            case 2: return "j";
            case 3: return "k";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            default: return null;
         }

      }

      public NewQuat4d() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final LDouble u = (LDouble)inputs[0];
         final LDouble i = (LDouble)inputs[1];
         final LDouble j = (LDouble)inputs[2];
         final LDouble k = (LDouble)inputs[3];
         return new Quaternion ( u . val , i . val , j . val , k . val ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class NewQuat2c1 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
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

      public NewQuat2c1() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Complex a = (Complex)inputs[0];
         final Complex b = (Complex)inputs[1];
         return new Quaternion ( a . x , a . y , b . x , b . y ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class NewQuatdv3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public NewQuatdv3() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final LDouble a = (LDouble)inputs[0];
         final LVect3d b = (LVect3d)inputs[1];
         return new Quaternion ( a . val , b . x , b . y , b . z ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class NewQuat2c2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
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

      public NewQuat2c2() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Complex a = (Complex)inputs[0];
         final Complex b = (Complex)inputs[1];
         return new Quaternion ( a . x * b . x , a . y * b . x , b . y * a . x , a . y * b . y ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class q_u extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "q";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public q_u() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final Quaternion q = (Quaternion)inputs[0];
         return new LDouble ( q . u ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class q_i extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "q";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public q_i() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final Quaternion q = (Quaternion)inputs[0];
         return new LDouble ( q . i ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class q_j extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "q";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public q_j() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final Quaternion q = (Quaternion)inputs[0];
         return new LDouble ( q . j ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class q_k extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "q";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public q_k() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final Quaternion q = (Quaternion)inputs[0];
         return new LDouble ( q . k ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class q_angle extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "q";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public q_angle() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final Quaternion q = (Quaternion)inputs[0];
         return new LDouble ( q . anglePart ( ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class q_magnitude extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "q";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public q_magnitude() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         final Quaternion q = (Quaternion)inputs[0];
         return new LDouble ( q . magnitude ( ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class q_ci extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "q";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public q_ci() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Quaternion q = (Quaternion)inputs[0];
         return new Complex ( q . u , q . i ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class q_cj extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "q";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public q_cj() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Quaternion q = (Quaternion)inputs[0];
         return new Complex ( q . u , q . j ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class q_ck extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "q";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public q_ck() {
         addGroupMeta(this);
      }

      public Complex evaluate(Context context, Object[] inputs) {
         final Quaternion q = (Quaternion)inputs[0];
         return new Complex ( q . u , q . k ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class q_v3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "q";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public q_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         final Quaternion q = (Quaternion)inputs[0];
         return q . vectorPart ( ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class q_col extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "q";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public q_col() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final Quaternion q = (Quaternion)inputs[0];
         return new Color ( q . i , q . j , q . k ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class add extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            case 1: return Quaternion.class;
            default: return null;
         }

      }

      public add() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         final Quaternion b = (Quaternion)inputs[1];
         return a . add ( b ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class sub extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            case 1: return Quaternion.class;
            default: return null;
         }

      }

      public sub() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         final Quaternion b = (Quaternion)inputs[1];
         return a . sub ( b ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class mult extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            case 1: return Quaternion.class;
            default: return null;
         }

      }

      public mult() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         final Quaternion b = (Quaternion)inputs[1];
         return a . mult ( b ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class div extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            case 1: return Quaternion.class;
            default: return null;
         }

      }

      public div() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         final Quaternion b = (Quaternion)inputs[1];
         return a . div ( b ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class powq extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            case 1: return Quaternion.class;
            default: return null;
         }

      }

      public powq() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         final Quaternion b = (Quaternion)inputs[1];
         return a . pow ( b ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class pow extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public pow() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         final LDouble b = (LDouble)inputs[1];
         return a . pow ( b . val ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class invert extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public invert() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return a . invert ( ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class square extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public square() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return a . mult ( a ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class exp extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public exp() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return a . exp ( ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class log extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public log() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return a . log ( ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class sin extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public sin() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return a . sin ( ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class cos extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public cos() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return a . cos ( ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class tan extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public tan() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return a . tan ( ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class sinh extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public sinh() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return a . sinh ( ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class cosh extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public cosh() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return a . cosh ( ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class tanh extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public tanh() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return a . tanh ( ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class arcsin extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public arcsin() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return a . arcsin ( ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class arccos extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public arccos() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return a . arccos ( ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class arctan extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public arctan() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return a . arctan ( ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class arcsinh extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public arcsinh() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return a . arcsinh ( ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class arccosh extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public arccosh() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return a . arccosh ( ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class arctanh extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public arctanh() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return a . arctanh ( ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class isin extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public isin() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return new Quaternion ( Math . sin ( a . u ) , Math . sin ( a . i ) , Math . sin ( a . j ) , Math . sin ( a . k ) ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class icos extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public icos() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return new Quaternion ( Math . cos ( a . u ) , Math . cos ( a . i ) , Math . cos ( a . j ) , Math . cos ( a . k ) ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class itan extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public itan() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return new Quaternion ( Math . tan ( a . u ) , Math . tan ( a . i ) , Math . tan ( a . j ) , Math . tan ( a . k ) ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class iexp extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public iexp() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return new Quaternion ( Math . exp ( a . u ) , Math . exp ( a . i ) , Math . exp ( a . j ) , Math . exp ( a . k ) ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class ilog extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public ilog() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return new Quaternion ( Math . log ( a . u ) , Math . log ( a . i ) , Math . log ( a . j ) , Math . log ( a . k ) ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class swapl extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public swapl() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return new Quaternion ( a . i , a . j , a . k , a . u ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class swapr extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public swapr() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return new Quaternion ( a . k , a . u , a . i , a . j ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class conj extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public conj() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return a . conj ( ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class aut1 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            case 1: return Quaternion.class;
            default: return null;
         }

      }

      public aut1() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         final Quaternion b = (Quaternion)inputs[1];
         return b . div ( a ) . mult ( a ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class aut2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            case 1: return Quaternion.class;
            default: return null;
         }

      }

      public aut2() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         final Quaternion b = (Quaternion)inputs[1];
         return b . div ( a . conj ( ) ) . mult ( a ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class orth extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            case 1: return Quaternion.class;
            default: return null;
         }

      }

      public orth() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         final Quaternion b = (Quaternion)inputs[1];
         return a . normal ( ) . mult ( b . mult ( a . normal ( ) . conj ( ) ) ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class mod extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            default: return null;
         }

      }

      public mod() {
         addGroupMeta(this);
      }

      public Quaternion evaluate(Context context, Object[] inputs) {
         final Quaternion a = (Quaternion)inputs[0];
         return new Quaternion ( a . u - Math . floor ( a . u ) , a . i - Math . floor ( a . i ) , a . j - Math . floor ( a . j ) , a . k - Math . floor ( a . k ) ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public String getDescription() {
      return "functions for complex quaternion numbers";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new NewQuat4d());
      r.add(new NewQuat2c1());
      r.add(new NewQuatdv3());
      r.add(new NewQuat2c2());
      r.add(new q_u());
      r.add(new q_i());
      r.add(new q_j());
      r.add(new q_k());
      r.add(new q_angle());
      r.add(new q_magnitude());
      r.add(new q_ci());
      r.add(new q_cj());
      r.add(new q_ck());
      r.add(new q_v3());
      r.add(new q_col());
      r.add(new add());
      r.add(new sub());
      r.add(new mult());
      r.add(new div());
      r.add(new powq());
      r.add(new pow());
      r.add(new invert());
      r.add(new square());
      r.add(new exp());
      r.add(new log());
      r.add(new sin());
      r.add(new cos());
      r.add(new tan());
      r.add(new sinh());
      r.add(new cosh());
      r.add(new tanh());
      r.add(new arcsin());
      r.add(new arccos());
      r.add(new arctan());
      r.add(new arcsinh());
      r.add(new arccosh());
      r.add(new arctanh());
      r.add(new isin());
      r.add(new icos());
      r.add(new itan());
      r.add(new iexp());
      r.add(new ilog());
      r.add(new swapl());
      r.add(new swapr());
      r.add(new conj());
      r.add(new aut1());
      r.add(new aut2());
      r.add(new orth());
      r.add(new mod());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
