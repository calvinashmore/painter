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

public final class Interpolate implements AllComponents<ExpressionFunction>, Described {

   public static class Interpolate_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "interp";
            case 1: return "x";
            case 2: return "y";
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

      public Interpolate_d() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         LDouble interp = (LDouble)inputs[0];
         LDouble x = (LDouble)inputs[1];
         LDouble y = (LDouble)inputs[2];
         double mod = Math . min ( Math . max ( interp . val , 0 ) , 1 ) ;
         return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Interpolate_v2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "interp";
            case 1: return "x";
            case 2: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LVect2d.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public Interpolate_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LDouble interp = (LDouble)inputs[0];
         LVect2d x = (LVect2d)inputs[1];
         LVect2d y = (LVect2d)inputs[2];
         double mod = Math . min ( Math . max ( interp . val , 0 ) , 1 ) ;
         return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Interpolate_v3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "interp";
            case 1: return "x";
            case 2: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LVect3d.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Interpolate_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LDouble interp = (LDouble)inputs[0];
         LVect3d x = (LVect3d)inputs[1];
         LVect3d y = (LVect3d)inputs[2];
         double mod = Math . min ( Math . max ( interp . val , 0 ) , 1 ) ;
         return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Interpolate_col extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "interp";
            case 1: return "x";
            case 2: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return Color.class;
            case 2: return Color.class;
            default: return null;
         }

      }

      public Interpolate_col() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         LDouble interp = (LDouble)inputs[0];
         Color x = (Color)inputs[1];
         Color y = (Color)inputs[2];
         double mod = Math . min ( Math . max ( interp . val , 0 ) , 1 ) ;
         return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Interpolate1_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "interp";
            case 1: return "x";
            case 2: return "y";
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

      public Interpolate1_d() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         LDouble interp = (LDouble)inputs[0];
         LDouble x = (LDouble)inputs[1];
         LDouble y = (LDouble)inputs[2];
         double mod = 1 / ( 1.0 + Math . exp ( - interp . val ) ) ;
         return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Interpolate1_v2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "interp";
            case 1: return "x";
            case 2: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LVect2d.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public Interpolate1_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LDouble interp = (LDouble)inputs[0];
         LVect2d x = (LVect2d)inputs[1];
         LVect2d y = (LVect2d)inputs[2];
         double mod = 1 / ( 1.0 + Math . exp ( - interp . val ) ) ;
         return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Interpolate1_v3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "interp";
            case 1: return "x";
            case 2: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LVect3d.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Interpolate1_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LDouble interp = (LDouble)inputs[0];
         LVect3d x = (LVect3d)inputs[1];
         LVect3d y = (LVect3d)inputs[2];
         double mod = 1 / ( 1.0 + Math . exp ( - interp . val ) ) ;
         return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Interpolate1_col extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "interp";
            case 1: return "x";
            case 2: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return Color.class;
            case 2: return Color.class;
            default: return null;
         }

      }

      public Interpolate1_col() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         LDouble interp = (LDouble)inputs[0];
         Color x = (Color)inputs[1];
         Color y = (Color)inputs[2];
         double mod = 1 / ( 1.0 + Math . exp ( - interp . val ) ) ;
         return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Interpolate2_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "interp";
            case 1: return "x";
            case 2: return "y";
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

      public Interpolate2_d() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         LDouble interp = (LDouble)inputs[0];
         LDouble x = (LDouble)inputs[1];
         LDouble y = (LDouble)inputs[2];
         double mod = Math . exp ( - interp . val * interp . val ) ;
         return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Interpolate2_v2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "interp";
            case 1: return "x";
            case 2: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LVect2d.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public Interpolate2_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LDouble interp = (LDouble)inputs[0];
         LVect2d x = (LVect2d)inputs[1];
         LVect2d y = (LVect2d)inputs[2];
         double mod = Math . exp ( - interp . val * interp . val ) ;
         return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Interpolate2_v3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "interp";
            case 1: return "x";
            case 2: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LVect3d.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Interpolate2_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LDouble interp = (LDouble)inputs[0];
         LVect3d x = (LVect3d)inputs[1];
         LVect3d y = (LVect3d)inputs[2];
         double mod = Math . exp ( - interp . val * interp . val ) ;
         return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Interpolate2_col extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "interp";
            case 1: return "x";
            case 2: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return Color.class;
            case 2: return Color.class;
            default: return null;
         }

      }

      public Interpolate2_col() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         LDouble interp = (LDouble)inputs[0];
         Color x = (Color)inputs[1];
         Color y = (Color)inputs[2];
         double mod = Math . exp ( - interp . val * interp . val ) ;
         return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Threshold_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "thresh";
            case 1: return "x";
            case 2: return "y";
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

      public Threshold_d() {
         addGroupMeta(this);
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         LDouble thresh = (LDouble)inputs[0];
         LDouble x = (LDouble)inputs[1];
         LDouble y = (LDouble)inputs[2];
         if ( thresh . val < .5 ) return x ;
         else return y ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Threshold_v2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "thresh";
            case 1: return "x";
            case 2: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LVect2d.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public Threshold_v2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LDouble thresh = (LDouble)inputs[0];
         LVect2d x = (LVect2d)inputs[1];
         LVect2d y = (LVect2d)inputs[2];
         if ( thresh . val < .5 ) return x ;
         else return y ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Threshold_v3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "thresh";
            case 1: return "x";
            case 2: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LVect3d.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public Threshold_v3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LDouble thresh = (LDouble)inputs[0];
         LVect3d x = (LVect3d)inputs[1];
         LVect3d y = (LVect3d)inputs[2];
         if ( thresh . val < .5 ) return x ;
         else return y ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public String getDescription() {
      return "Interpolations";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new Interpolate_d());
      r.add(new Interpolate_v2());
      r.add(new Interpolate_v3());
      r.add(new Interpolate_col());
      r.add(new Interpolate1_d());
      r.add(new Interpolate1_v2());
      r.add(new Interpolate1_v3());
      r.add(new Interpolate1_col());
      r.add(new Interpolate2_d());
      r.add(new Interpolate2_v2());
      r.add(new Interpolate2_v3());
      r.add(new Interpolate2_col());
      r.add(new Threshold_d());
      r.add(new Threshold_v2());
      r.add(new Threshold_v3());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
