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

public final class Noise1Grad implements AllComponents<ExpressionFunction>, Described {

   public static class ngrad_v2_d_1 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_v2_d_1() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         NoiseFunction noise = (NoiseFunction)inputs[1];
         double dx = ( noise . noise ( x . x + delta , x . y , 0 ) - noise . noise ( x . x - delta , x . y , 0 ) ) / ( 2 * delta ) ;
         double dy = ( noise . noise ( x . x , x . y + delta , 0 ) - noise . noise ( x . x , x . y - delta , 0 ) ) / ( 2 * delta ) ;
         return new LVect2d ( dx , dy ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class ngrad_v2_d_2 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_v2_d_2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         NoiseFunction noise = (NoiseFunction)inputs[1];
         double dx = ( noise . noise ( x . x + delta , x . y , 0 ) - noise . noise ( x . x - delta , x . y , 0 ) ) / ( 2 * delta ) ;
         double dy = ( noise . noise ( x . x , x . y + delta , 0 ) - noise . noise ( x . x , x . y - delta , 0 ) ) / ( 2 * delta ) ;
         return new LVect2d ( dx , dy ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class ngrad_v3_d_1 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_v3_d_1() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         NoiseFunction noise = (NoiseFunction)inputs[1];
         double dx = ( noise . noise ( x . x + delta , x . y , x . z ) - noise . noise ( x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ;
         double dy = ( noise . noise ( x . x , x . y + delta , x . z ) - noise . noise ( x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ;
         double dz = ( noise . noise ( x . x , x . y , x . z + delta ) - noise . noise ( x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ;
         return new LVect3d ( dx , dy , dz ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class ngrad_v3_d_2 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_v3_d_2() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         NoiseFunction noise = (NoiseFunction)inputs[1];
         double dx = ( noise . noise ( x . x + delta , x . y , x . z ) - noise . noise ( x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ;
         double dy = ( noise . noise ( x . x , x . y + delta , x . z ) - noise . noise ( x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ;
         double dz = ( noise . noise ( x . x , x . y , x . z + delta ) - noise . noise ( x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ;
         return new LVect3d ( dx , dy , dz ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class ngrad_v2_v2_1 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_v2_v2_1() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         double dx1 = ( noise . noise ( x . x + delta , x . y , 0 ) - noise . noise ( x . x - delta , x . y , 0 ) ) / ( 2 * delta ) ;
         double dy1 = ( noise . noise ( x . x , x . y + delta , 0 ) - noise . noise ( x . x , x . y - delta , 0 ) ) / ( 2 * delta ) ;
         double dx2 = ( noise . noise ( x . x + delta + 100 , x . y + 100 , 100 ) - noise . noise ( x . x - delta + 100 , x . y + 100 , 100 ) ) / ( 2 * delta ) ;
         double dy2 = ( noise . noise ( x . x + 100 , x . y + delta + 100 , 100 ) - noise . noise ( x . x + 100 , x . y - delta + 100 , 100 ) ) / ( 2 * delta ) ;
         LVect2d ynorm = y . normal ( ) ;
         return new LVect2d ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class ngrad_v2_v2_2 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_v2_v2_2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         double dx1 = ( noise . noise ( x . x + delta , x . y , 0 ) - noise . noise ( x . x - delta , x . y , 0 ) ) / ( 2 * delta ) ;
         double dy1 = ( noise . noise ( x . x , x . y + delta , 0 ) - noise . noise ( x . x , x . y - delta , 0 ) ) / ( 2 * delta ) ;
         double dx2 = ( noise . noise ( x . x + delta + 100 , x . y + 100 , 100 ) - noise . noise ( x . x - delta + 100 , x . y + 100 , 100 ) ) / ( 2 * delta ) ;
         double dy2 = ( noise . noise ( x . x + 100 , x . y + delta + 100 , 100 ) - noise . noise ( x . x + 100 , x . y - delta + 100 , 100 ) ) / ( 2 * delta ) ;
         LVect2d ynorm = y . normal ( ) ;
         return new LVect2d ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class ngrad_v2_v2_3 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_v2_v2_3() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         LVect2d vx1 = new LVect2d ( noise . noise ( x . x + delta , x . y , 0 ) , noise . noise ( x . x + delta + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
         LVect2d vx2 = new LVect2d ( noise . noise ( x . x - delta , x . y , 0 ) , noise . noise ( x . x - delta + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
         LVect2d vy1 = new LVect2d ( noise . noise ( x . x , x . y + delta , 0 ) , noise . noise ( x . x + 100 , x . y + delta + 100 , 100 ) ) . normal ( ) ;
         LVect2d vy2 = new LVect2d ( noise . noise ( x . x , x . y - delta , 0 ) , noise . noise ( x . x + 100 , x . y - delta + 100 , 100 ) ) . normal ( ) ;
         LVect2d ynorm = y . normal ( ) ;
         double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         return new LVect2d ( xpart , ypart ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class ngrad_v2_v2_4 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_v2_v2_4() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         LVect2d vx1 = new LVect2d ( noise . noise ( x . x + delta , x . y , 0 ) , noise . noise ( x . x + delta + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
         LVect2d vx2 = new LVect2d ( noise . noise ( x . x - delta , x . y , 0 ) , noise . noise ( x . x - delta + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
         LVect2d vy1 = new LVect2d ( noise . noise ( x . x , x . y + delta , 0 ) , noise . noise ( x . x + 100 , x . y + delta + 100 , 100 ) ) . normal ( ) ;
         LVect2d vy2 = new LVect2d ( noise . noise ( x . x , x . y - delta , 0 ) , noise . noise ( x . x + 100 , x . y - delta + 100 , 100 ) ) . normal ( ) ;
         LVect2d ynorm = y . normal ( ) ;
         double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         return new LVect2d ( xpart , ypart ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class ngrad_v3_v2_1 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_v3_v2_1() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         double dx1 = ( noise . noise ( x . x + delta , x . y , x . z ) - noise . noise ( x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ;
         double dy1 = ( noise . noise ( x . x , x . y + delta , x . z ) - noise . noise ( x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ;
         double dz1 = ( noise . noise ( x . x , x . y , x . z + delta ) - noise . noise ( x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ;
         double dx2 = ( noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) - noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dy2 = ( noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) - noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dz2 = ( noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) - noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ;
         LVect2d ynorm = y . normal ( ) ;
         return new LVect3d ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y , dz1 * ynorm . x + dz2 * ynorm . y ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class ngrad_v3_v2_2 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_v3_v2_2() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         double dx1 = ( noise . noise ( x . x + delta , x . y , x . z ) - noise . noise ( x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ;
         double dy1 = ( noise . noise ( x . x , x . y + delta , x . z ) - noise . noise ( x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ;
         double dz1 = ( noise . noise ( x . x , x . y , x . z + delta ) - noise . noise ( x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ;
         double dx2 = ( noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) - noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dy2 = ( noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) - noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dz2 = ( noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) - noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ;
         LVect2d ynorm = y . normal ( ) ;
         return new LVect3d ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y , dz1 * ynorm . x + dz2 * ynorm . y ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class ngrad_v3_v2_3 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_v3_v2_3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         LVect2d vx1 = new LVect2d ( noise . noise ( x . x + delta , x . y , x . z ) , noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vx2 = new LVect2d ( noise . noise ( x . x - delta , x . y , x . z ) , noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vy1 = new LVect2d ( noise . noise ( x . x , x . y + delta , x . z ) , noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vy2 = new LVect2d ( noise . noise ( x . x , x . y - delta , x . z ) , noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vz1 = new LVect2d ( noise . noise ( x . x , x . y , x . z + delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) ) . normal ( ) ;
         LVect2d vz2 = new LVect2d ( noise . noise ( x . x , x . y , x . z - delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) . normal ( ) ;
         LVect2d ynorm = y . normal ( ) ;
         double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         return new LVect3d ( xpart , ypart , zpart ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class ngrad_v3_v2_4 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_v3_v2_4() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         LVect2d vx1 = new LVect2d ( noise . noise ( x . x + delta , x . y , x . z ) , noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vx2 = new LVect2d ( noise . noise ( x . x - delta , x . y , x . z ) , noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vy1 = new LVect2d ( noise . noise ( x . x , x . y + delta , x . z ) , noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vy2 = new LVect2d ( noise . noise ( x . x , x . y - delta , x . z ) , noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vz1 = new LVect2d ( noise . noise ( x . x , x . y , x . z + delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) ) . normal ( ) ;
         LVect2d vz2 = new LVect2d ( noise . noise ( x . x , x . y , x . z - delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) . normal ( ) ;
         LVect2d ynorm = y . normal ( ) ;
         double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         return new LVect3d ( xpart , ypart , zpart ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class ngrad_v3_v3_1 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_v3_v3_1() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect3d y = (LVect3d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         double dx1 = ( noise . noise ( x . x + delta , x . y , x . z ) - noise . noise ( x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ;
         double dy1 = ( noise . noise ( x . x , x . y + delta , x . z ) - noise . noise ( x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ;
         double dz1 = ( noise . noise ( x . x , x . y , x . z + delta ) - noise . noise ( x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ;
         double dx2 = ( noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) - noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dy2 = ( noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) - noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dz2 = ( noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) - noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ;
         double dx3 = ( noise . noise ( x . x + delta + 300 , x . y + 300 , x . z + 300 ) - noise . noise ( x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) / ( 2 * delta ) ;
         double dy3 = ( noise . noise ( x . x + 300 , x . y + delta + 300 , x . z + 300 ) - noise . noise ( x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) / ( 2 * delta ) ;
         double dz3 = ( noise . noise ( x . x + 300 , x . y + 300 , x . z + delta + 300 ) - noise . noise ( x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) / ( 2 * delta ) ;
         LVect3d ynorm = y . normal ( ) ;
         return new LVect3d ( dx1 * ynorm . x + dx2 * ynorm . y + dx3 * ynorm . z , dy1 * ynorm . x + dy2 * ynorm . y + dy3 * ynorm . z , dz1 * ynorm . x + dz2 * ynorm . y + dz3 * ynorm . z ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class ngrad_v3_v3_2 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_v3_v3_2() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect3d y = (LVect3d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         double dx1 = ( noise . noise ( x . x + delta , x . y , x . z ) - noise . noise ( x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ;
         double dy1 = ( noise . noise ( x . x , x . y + delta , x . z ) - noise . noise ( x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ;
         double dz1 = ( noise . noise ( x . x , x . y , x . z + delta ) - noise . noise ( x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ;
         double dx2 = ( noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) - noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dy2 = ( noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) - noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dz2 = ( noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) - noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ;
         double dx3 = ( noise . noise ( x . x + delta + 300 , x . y + 300 , x . z + 300 ) - noise . noise ( x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) / ( 2 * delta ) ;
         double dy3 = ( noise . noise ( x . x + 300 , x . y + delta + 300 , x . z + 300 ) - noise . noise ( x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) / ( 2 * delta ) ;
         double dz3 = ( noise . noise ( x . x + 300 , x . y + 300 , x . z + delta + 300 ) - noise . noise ( x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) / ( 2 * delta ) ;
         LVect3d ynorm = y . normal ( ) ;
         return new LVect3d ( dx1 * ynorm . x + dx2 * ynorm . y + dx3 * ynorm . z , dy1 * ynorm . x + dy2 * ynorm . y + dy3 * ynorm . z , dz1 * ynorm . x + dz2 * ynorm . y + dz3 * ynorm . z ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class ngrad_v3_v3_3 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_v3_v3_3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect3d y = (LVect3d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         LVect3d vx1 = new LVect3d ( noise . noise ( x . x + delta , x . y , x . z ) , noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x + delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vx2 = new LVect3d ( noise . noise ( x . x - delta , x . y , x . z ) , noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vy1 = new LVect3d ( noise . noise ( x . x , x . y + delta , x . z ) , noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y + delta + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vy2 = new LVect3d ( noise . noise ( x . x , x . y - delta , x . z ) , noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vz1 = new LVect3d ( noise . noise ( x . x , x . y , x . z + delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z + delta + 300 ) ) . normal ( ) ;
         LVect3d vz2 = new LVect3d ( noise . noise ( x . x , x . y , x . z - delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) . normal ( ) ;
         LVect3d ynorm = y . normal ( ) ;
         double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         return new LVect3d ( xpart , ypart , zpart ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class ngrad_v3_v3_4 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_v3_v3_4() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect3d y = (LVect3d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         LVect3d vx1 = new LVect3d ( noise . noise ( x . x + delta , x . y , x . z ) , noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x + delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vx2 = new LVect3d ( noise . noise ( x . x - delta , x . y , x . z ) , noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vy1 = new LVect3d ( noise . noise ( x . x , x . y + delta , x . z ) , noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y + delta + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vy2 = new LVect3d ( noise . noise ( x . x , x . y - delta , x . z ) , noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vz1 = new LVect3d ( noise . noise ( x . x , x . y , x . z + delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z + delta + 300 ) ) . normal ( ) ;
         LVect3d vz2 = new LVect3d ( noise . noise ( x . x , x . y , x . z - delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) . normal ( ) ;
         LVect3d ynorm = y . normal ( ) ;
         double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         return new LVect3d ( xpart , ypart , zpart ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class ngrad_col_v2_1 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_col_v2_1() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         double dx1 = ( noise . noise ( x . x + delta , x . y , x . z ) - noise . noise ( x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ;
         double dy1 = ( noise . noise ( x . x , x . y + delta , x . z ) - noise . noise ( x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ;
         double dz1 = ( noise . noise ( x . x , x . y , x . z + delta ) - noise . noise ( x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ;
         double dx2 = ( noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) - noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dy2 = ( noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) - noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dz2 = ( noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) - noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ;
         LVect2d ynorm = y . normal ( ) ;
         return new Color ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y , dz1 * ynorm . x + dz2 * ynorm . y ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class ngrad_col_v2_2 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_col_v2_2() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         double dx1 = ( noise . noise ( x . x + delta , x . y , x . z ) - noise . noise ( x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ;
         double dy1 = ( noise . noise ( x . x , x . y + delta , x . z ) - noise . noise ( x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ;
         double dz1 = ( noise . noise ( x . x , x . y , x . z + delta ) - noise . noise ( x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ;
         double dx2 = ( noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) - noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dy2 = ( noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) - noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dz2 = ( noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) - noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ;
         LVect2d ynorm = y . normal ( ) ;
         return new Color ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y , dz1 * ynorm . x + dz2 * ynorm . y ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class ngrad_col_v2_3 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_col_v2_3() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         LVect2d vx1 = new LVect2d ( noise . noise ( x . x + delta , x . y , x . z ) , noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vx2 = new LVect2d ( noise . noise ( x . x - delta , x . y , x . z ) , noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vy1 = new LVect2d ( noise . noise ( x . x , x . y + delta , x . z ) , noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vy2 = new LVect2d ( noise . noise ( x . x , x . y - delta , x . z ) , noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vz1 = new LVect2d ( noise . noise ( x . x , x . y , x . z + delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) ) . normal ( ) ;
         LVect2d vz2 = new LVect2d ( noise . noise ( x . x , x . y , x . z - delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) . normal ( ) ;
         LVect2d ynorm = y . normal ( ) ;
         double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         return new Color ( xpart , ypart , zpart ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class ngrad_col_v2_4 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_col_v2_4() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         LVect2d vx1 = new LVect2d ( noise . noise ( x . x + delta , x . y , x . z ) , noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vx2 = new LVect2d ( noise . noise ( x . x - delta , x . y , x . z ) , noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vy1 = new LVect2d ( noise . noise ( x . x , x . y + delta , x . z ) , noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vy2 = new LVect2d ( noise . noise ( x . x , x . y - delta , x . z ) , noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vz1 = new LVect2d ( noise . noise ( x . x , x . y , x . z + delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) ) . normal ( ) ;
         LVect2d vz2 = new LVect2d ( noise . noise ( x . x , x . y , x . z - delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) . normal ( ) ;
         LVect2d ynorm = y . normal ( ) ;
         double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         return new Color ( xpart , ypart , zpart ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class ngrad_col_v3_1 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_col_v3_1() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect3d y = (LVect3d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         double dx1 = ( noise . noise ( x . x + delta , x . y , x . z ) - noise . noise ( x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ;
         double dy1 = ( noise . noise ( x . x , x . y + delta , x . z ) - noise . noise ( x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ;
         double dz1 = ( noise . noise ( x . x , x . y , x . z + delta ) - noise . noise ( x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ;
         double dx2 = ( noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) - noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dy2 = ( noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) - noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dz2 = ( noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) - noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ;
         double dx3 = ( noise . noise ( x . x + delta + 300 , x . y + 300 , x . z + 300 ) - noise . noise ( x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) / ( 2 * delta ) ;
         double dy3 = ( noise . noise ( x . x + 300 , x . y + delta + 300 , x . z + 300 ) - noise . noise ( x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) / ( 2 * delta ) ;
         double dz3 = ( noise . noise ( x . x + 300 , x . y + 300 , x . z + delta + 300 ) - noise . noise ( x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) / ( 2 * delta ) ;
         LVect3d ynorm = y . normal ( ) ;
         return new Color ( dx1 * ynorm . x + dx2 * ynorm . y + dx3 * ynorm . z , dy1 * ynorm . x + dy2 * ynorm . y + dy3 * ynorm . z , dz1 * ynorm . x + dz2 * ynorm . y + dz3 * ynorm . z ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class ngrad_col_v3_2 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_col_v3_2() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect3d y = (LVect3d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         double dx1 = ( noise . noise ( x . x + delta , x . y , x . z ) - noise . noise ( x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ;
         double dy1 = ( noise . noise ( x . x , x . y + delta , x . z ) - noise . noise ( x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ;
         double dz1 = ( noise . noise ( x . x , x . y , x . z + delta ) - noise . noise ( x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ;
         double dx2 = ( noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) - noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dy2 = ( noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) - noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dz2 = ( noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) - noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ;
         double dx3 = ( noise . noise ( x . x + delta + 300 , x . y + 300 , x . z + 300 ) - noise . noise ( x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) / ( 2 * delta ) ;
         double dy3 = ( noise . noise ( x . x + 300 , x . y + delta + 300 , x . z + 300 ) - noise . noise ( x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) / ( 2 * delta ) ;
         double dz3 = ( noise . noise ( x . x + 300 , x . y + 300 , x . z + delta + 300 ) - noise . noise ( x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) / ( 2 * delta ) ;
         LVect3d ynorm = y . normal ( ) ;
         return new Color ( dx1 * ynorm . x + dx2 * ynorm . y + dx3 * ynorm . z , dy1 * ynorm . x + dy2 * ynorm . y + dy3 * ynorm . z , dz1 * ynorm . x + dz2 * ynorm . y + dz3 * ynorm . z ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class ngrad_col_v3_3 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_col_v3_3() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect3d y = (LVect3d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         LVect3d vx1 = new LVect3d ( noise . noise ( x . x + delta , x . y , x . z ) , noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x + delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vx2 = new LVect3d ( noise . noise ( x . x - delta , x . y , x . z ) , noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vy1 = new LVect3d ( noise . noise ( x . x , x . y + delta , x . z ) , noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y + delta + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vy2 = new LVect3d ( noise . noise ( x . x , x . y - delta , x . z ) , noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vz1 = new LVect3d ( noise . noise ( x . x , x . y , x . z + delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z + delta + 300 ) ) . normal ( ) ;
         LVect3d vz2 = new LVect3d ( noise . noise ( x . x , x . y , x . z - delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) . normal ( ) ;
         LVect3d ynorm = y . normal ( ) ;
         double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         return new Color ( xpart , ypart , zpart ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class ngrad_col_v3_4 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return NoiseFunction.class;
            default: return null;
         }

      }

      public ngrad_col_v3_4() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect3d y = (LVect3d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         LVect3d vx1 = new LVect3d ( noise . noise ( x . x + delta , x . y , x . z ) , noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x + delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vx2 = new LVect3d ( noise . noise ( x . x - delta , x . y , x . z ) , noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vy1 = new LVect3d ( noise . noise ( x . x , x . y + delta , x . z ) , noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y + delta + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vy2 = new LVect3d ( noise . noise ( x . x , x . y - delta , x . z ) , noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vz1 = new LVect3d ( noise . noise ( x . x , x . y , x . z + delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z + delta + 300 ) ) . normal ( ) ;
         LVect3d vz2 = new LVect3d ( noise . noise ( x . x , x . y , x . z - delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) . normal ( ) ;
         LVect3d ynorm = y . normal ( ) ;
         double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         return new Color ( xpart , ypart , zpart ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class fgrad_v2_d_1 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "noise";
            case 2: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return NoiseFunction.class;
            case 2: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_v2_d_1() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         NoiseFunction noise = (NoiseFunction)inputs[1];
         NoiseFractal fractal = (NoiseFractal)inputs[2];
         double dx = ( fractal . evalFractal ( noise , x . x + delta , x . y , 0 ) - fractal . evalFractal ( noise , x . x - delta , x . y , 0 ) ) / ( 2 * delta ) ;
         double dy = ( fractal . evalFractal ( noise , x . x , x . y + delta , 0 ) - fractal . evalFractal ( noise , x . x , x . y - delta , 0 ) ) / ( 2 * delta ) ;
         return new LVect2d ( dx , dy ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class fgrad_v2_d_2 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "noise";
            case 2: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return NoiseFunction.class;
            case 2: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_v2_d_2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         NoiseFunction noise = (NoiseFunction)inputs[1];
         NoiseFractal fractal = (NoiseFractal)inputs[2];
         double dx = ( fractal . evalFractal ( noise , x . x + delta , x . y , 0 ) - fractal . evalFractal ( noise , x . x - delta , x . y , 0 ) ) / ( 2 * delta ) ;
         double dy = ( fractal . evalFractal ( noise , x . x , x . y + delta , 0 ) - fractal . evalFractal ( noise , x . x , x . y - delta , 0 ) ) / ( 2 * delta ) ;
         return new LVect2d ( dx , dy ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class fgrad_v3_d_1 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "noise";
            case 2: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return NoiseFunction.class;
            case 2: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_v3_d_1() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         NoiseFunction noise = (NoiseFunction)inputs[1];
         NoiseFractal fractal = (NoiseFractal)inputs[2];
         double dx = ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) - fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ;
         double dy = ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) - fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ;
         double dz = ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) - fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ;
         return new LVect3d ( dx , dy , dz ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class fgrad_v3_d_2 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "noise";
            case 2: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return NoiseFunction.class;
            case 2: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_v3_d_2() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         NoiseFunction noise = (NoiseFunction)inputs[1];
         NoiseFractal fractal = (NoiseFractal)inputs[2];
         double dx = ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) - fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ;
         double dy = ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) - fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ;
         double dz = ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) - fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ;
         return new LVect3d ( dx , dy , dz ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class fgrad_v2_v2_1 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            case 3: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            case 3: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_v2_v2_1() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         NoiseFractal fractal = (NoiseFractal)inputs[3];
         double dx1 = ( fractal . evalFractal ( noise , x . x + delta , x . y , 0 ) - fractal . evalFractal ( noise , x . x - delta , x . y , 0 ) ) / ( 2 * delta ) ;
         double dy1 = ( fractal . evalFractal ( noise , x . x , x . y + delta , 0 ) - fractal . evalFractal ( noise , x . x , x . y - delta , 0 ) ) / ( 2 * delta ) ;
         double dx2 = ( fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , 100 ) - fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , 100 ) ) / ( 2 * delta ) ;
         double dy2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , 100 ) ) / ( 2 * delta ) ;
         LVect2d ynorm = y . normal ( ) ;
         return new LVect2d ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class fgrad_v2_v2_2 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            case 3: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            case 3: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_v2_v2_2() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         NoiseFractal fractal = (NoiseFractal)inputs[3];
         double dx1 = ( fractal . evalFractal ( noise , x . x + delta , x . y , 0 ) - fractal . evalFractal ( noise , x . x - delta , x . y , 0 ) ) / ( 2 * delta ) ;
         double dy1 = ( fractal . evalFractal ( noise , x . x , x . y + delta , 0 ) - fractal . evalFractal ( noise , x . x , x . y - delta , 0 ) ) / ( 2 * delta ) ;
         double dx2 = ( fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , 100 ) - fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , 100 ) ) / ( 2 * delta ) ;
         double dy2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , 100 ) ) / ( 2 * delta ) ;
         LVect2d ynorm = y . normal ( ) ;
         return new LVect2d ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class fgrad_v2_v2_3 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            case 3: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            case 3: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_v2_v2_3() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         NoiseFractal fractal = (NoiseFractal)inputs[3];
         LVect2d vx1 = new LVect2d ( fractal . evalFractal ( noise , x . x + delta , x . y , 0 ) , fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
         LVect2d vx2 = new LVect2d ( fractal . evalFractal ( noise , x . x - delta , x . y , 0 ) , fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
         LVect2d vy1 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y + delta , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , 100 ) ) . normal ( ) ;
         LVect2d vy2 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y - delta , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , 100 ) ) . normal ( ) ;
         LVect2d ynorm = y . normal ( ) ;
         double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         return new LVect2d ( xpart , ypart ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class fgrad_v2_v2_4 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            case 3: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            case 3: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_v2_v2_4() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         NoiseFractal fractal = (NoiseFractal)inputs[3];
         LVect2d vx1 = new LVect2d ( fractal . evalFractal ( noise , x . x + delta , x . y , 0 ) , fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
         LVect2d vx2 = new LVect2d ( fractal . evalFractal ( noise , x . x - delta , x . y , 0 ) , fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
         LVect2d vy1 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y + delta , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , 100 ) ) . normal ( ) ;
         LVect2d vy2 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y - delta , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , 100 ) ) . normal ( ) ;
         LVect2d ynorm = y . normal ( ) ;
         double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         return new LVect2d ( xpart , ypart ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class fgrad_v3_v2_1 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            case 3: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            case 3: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_v3_v2_1() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         NoiseFractal fractal = (NoiseFractal)inputs[3];
         double dx1 = ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) - fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ;
         double dy1 = ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) - fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ;
         double dz1 = ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) - fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ;
         double dx2 = ( fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dy2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dz2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ;
         LVect2d ynorm = y . normal ( ) ;
         return new LVect3d ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y , dz1 * ynorm . x + dz2 * ynorm . y ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class fgrad_v3_v2_2 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            case 3: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            case 3: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_v3_v2_2() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         NoiseFractal fractal = (NoiseFractal)inputs[3];
         double dx1 = ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) - fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ;
         double dy1 = ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) - fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ;
         double dz1 = ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) - fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ;
         double dx2 = ( fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dy2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dz2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ;
         LVect2d ynorm = y . normal ( ) ;
         return new LVect3d ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y , dz1 * ynorm . x + dz2 * ynorm . y ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class fgrad_v3_v2_3 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            case 3: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            case 3: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_v3_v2_3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         NoiseFractal fractal = (NoiseFractal)inputs[3];
         LVect2d vx1 = new LVect2d ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vx2 = new LVect2d ( fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vy1 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vy2 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vz1 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) ) . normal ( ) ;
         LVect2d vz2 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) . normal ( ) ;
         LVect2d ynorm = y . normal ( ) ;
         double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         return new LVect3d ( xpart , ypart , zpart ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class fgrad_v3_v2_4 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            case 3: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            case 3: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_v3_v2_4() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         NoiseFractal fractal = (NoiseFractal)inputs[3];
         LVect2d vx1 = new LVect2d ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vx2 = new LVect2d ( fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vy1 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vy2 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vz1 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) ) . normal ( ) ;
         LVect2d vz2 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) . normal ( ) ;
         LVect2d ynorm = y . normal ( ) ;
         double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         return new LVect3d ( xpart , ypart , zpart ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class fgrad_v3_v3_1 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            case 3: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return NoiseFunction.class;
            case 3: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_v3_v3_1() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect3d y = (LVect3d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         NoiseFractal fractal = (NoiseFractal)inputs[3];
         double dx1 = ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) - fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ;
         double dy1 = ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) - fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ;
         double dz1 = ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) - fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ;
         double dx2 = ( fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dy2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dz2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ;
         double dx3 = ( fractal . evalFractal ( noise , x . x + delta + 300 , x . y + 300 , x . z + 300 ) - fractal . evalFractal ( noise , x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) / ( 2 * delta ) ;
         double dy3 = ( fractal . evalFractal ( noise , x . x + 300 , x . y + delta + 300 , x . z + 300 ) - fractal . evalFractal ( noise , x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) / ( 2 * delta ) ;
         double dz3 = ( fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + delta + 300 ) - fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) / ( 2 * delta ) ;
         LVect3d ynorm = y . normal ( ) ;
         return new LVect3d ( dx1 * ynorm . x + dx2 * ynorm . y + dx3 * ynorm . z , dy1 * ynorm . x + dy2 * ynorm . y + dy3 * ynorm . z , dz1 * ynorm . x + dz2 * ynorm . y + dz3 * ynorm . z ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class fgrad_v3_v3_2 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            case 3: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return NoiseFunction.class;
            case 3: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_v3_v3_2() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect3d y = (LVect3d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         NoiseFractal fractal = (NoiseFractal)inputs[3];
         double dx1 = ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) - fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ;
         double dy1 = ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) - fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ;
         double dz1 = ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) - fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ;
         double dx2 = ( fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dy2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dz2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ;
         double dx3 = ( fractal . evalFractal ( noise , x . x + delta + 300 , x . y + 300 , x . z + 300 ) - fractal . evalFractal ( noise , x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) / ( 2 * delta ) ;
         double dy3 = ( fractal . evalFractal ( noise , x . x + 300 , x . y + delta + 300 , x . z + 300 ) - fractal . evalFractal ( noise , x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) / ( 2 * delta ) ;
         double dz3 = ( fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + delta + 300 ) - fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) / ( 2 * delta ) ;
         LVect3d ynorm = y . normal ( ) ;
         return new LVect3d ( dx1 * ynorm . x + dx2 * ynorm . y + dx3 * ynorm . z , dy1 * ynorm . x + dy2 * ynorm . y + dy3 * ynorm . z , dz1 * ynorm . x + dz2 * ynorm . y + dz3 * ynorm . z ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class fgrad_v3_v3_3 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            case 3: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return NoiseFunction.class;
            case 3: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_v3_v3_3() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect3d y = (LVect3d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         NoiseFractal fractal = (NoiseFractal)inputs[3];
         LVect3d vx1 = new LVect3d ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vx2 = new LVect3d ( fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vy1 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + delta + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vy2 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vz1 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + delta + 300 ) ) . normal ( ) ;
         LVect3d vz2 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) . normal ( ) ;
         LVect3d ynorm = y . normal ( ) ;
         double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         return new LVect3d ( xpart , ypart , zpart ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class fgrad_v3_v3_4 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            case 3: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return NoiseFunction.class;
            case 3: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_v3_v3_4() {
         addGroupMeta(this);
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect3d y = (LVect3d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         NoiseFractal fractal = (NoiseFractal)inputs[3];
         LVect3d vx1 = new LVect3d ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vx2 = new LVect3d ( fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vy1 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + delta + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vy2 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vz1 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + delta + 300 ) ) . normal ( ) ;
         LVect3d vz2 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) . normal ( ) ;
         LVect3d ynorm = y . normal ( ) ;
         double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         return new LVect3d ( xpart , ypart , zpart ) . normal ( ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class fgrad_col_v2_1 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            case 3: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            case 3: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_col_v2_1() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         NoiseFractal fractal = (NoiseFractal)inputs[3];
         double dx1 = ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) - fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ;
         double dy1 = ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) - fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ;
         double dz1 = ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) - fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ;
         double dx2 = ( fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dy2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dz2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ;
         LVect2d ynorm = y . normal ( ) ;
         return new Color ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y , dz1 * ynorm . x + dz2 * ynorm . y ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class fgrad_col_v2_2 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            case 3: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            case 3: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_col_v2_2() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         NoiseFractal fractal = (NoiseFractal)inputs[3];
         double dx1 = ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) - fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ;
         double dy1 = ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) - fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ;
         double dz1 = ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) - fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ;
         double dx2 = ( fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dy2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dz2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ;
         LVect2d ynorm = y . normal ( ) ;
         return new Color ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y , dz1 * ynorm . x + dz2 * ynorm . y ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class fgrad_col_v2_3 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            case 3: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            case 3: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_col_v2_3() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         NoiseFractal fractal = (NoiseFractal)inputs[3];
         LVect2d vx1 = new LVect2d ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vx2 = new LVect2d ( fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vy1 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vy2 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vz1 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) ) . normal ( ) ;
         LVect2d vz2 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) . normal ( ) ;
         LVect2d ynorm = y . normal ( ) ;
         double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         return new Color ( xpart , ypart , zpart ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class fgrad_col_v2_4 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            case 3: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect2d.class;
            case 2: return NoiseFunction.class;
            case 3: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_col_v2_4() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect2d y = (LVect2d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         NoiseFractal fractal = (NoiseFractal)inputs[3];
         LVect2d vx1 = new LVect2d ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vx2 = new LVect2d ( fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vy1 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vy2 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) . normal ( ) ;
         LVect2d vz1 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) ) . normal ( ) ;
         LVect2d vz2 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) . normal ( ) ;
         LVect2d ynorm = y . normal ( ) ;
         double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         return new Color ( xpart , ypart , zpart ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class fgrad_col_v3_1 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            case 3: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return NoiseFunction.class;
            case 3: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_col_v3_1() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect3d y = (LVect3d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         NoiseFractal fractal = (NoiseFractal)inputs[3];
         double dx1 = ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) - fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ;
         double dy1 = ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) - fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ;
         double dz1 = ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) - fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ;
         double dx2 = ( fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dy2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dz2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ;
         double dx3 = ( fractal . evalFractal ( noise , x . x + delta + 300 , x . y + 300 , x . z + 300 ) - fractal . evalFractal ( noise , x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) / ( 2 * delta ) ;
         double dy3 = ( fractal . evalFractal ( noise , x . x + 300 , x . y + delta + 300 , x . z + 300 ) - fractal . evalFractal ( noise , x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) / ( 2 * delta ) ;
         double dz3 = ( fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + delta + 300 ) - fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) / ( 2 * delta ) ;
         LVect3d ynorm = y . normal ( ) ;
         return new Color ( dx1 * ynorm . x + dx2 * ynorm . y + dx3 * ynorm . z , dy1 * ynorm . x + dy2 * ynorm . y + dy3 * ynorm . z , dz1 * ynorm . x + dz2 * ynorm . y + dz3 * ynorm . z ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class fgrad_col_v3_2 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            case 3: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return NoiseFunction.class;
            case 3: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_col_v3_2() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect3d y = (LVect3d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         NoiseFractal fractal = (NoiseFractal)inputs[3];
         double dx1 = ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) - fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ;
         double dy1 = ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) - fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ;
         double dz1 = ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) - fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ;
         double dx2 = ( fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dy2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ;
         double dz2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ;
         double dx3 = ( fractal . evalFractal ( noise , x . x + delta + 300 , x . y + 300 , x . z + 300 ) - fractal . evalFractal ( noise , x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) / ( 2 * delta ) ;
         double dy3 = ( fractal . evalFractal ( noise , x . x + 300 , x . y + delta + 300 , x . z + 300 ) - fractal . evalFractal ( noise , x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) / ( 2 * delta ) ;
         double dz3 = ( fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + delta + 300 ) - fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) / ( 2 * delta ) ;
         LVect3d ynorm = y . normal ( ) ;
         return new Color ( dx1 * ynorm . x + dx2 * ynorm . y + dx3 * ynorm . z , dy1 * ynorm . x + dy2 * ynorm . y + dy3 * ynorm . z , dz1 * ynorm . x + dz2 * ynorm . y + dz3 * ynorm . z ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class fgrad_col_v3_3 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            case 3: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return NoiseFunction.class;
            case 3: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_col_v3_3() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect3d y = (LVect3d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         NoiseFractal fractal = (NoiseFractal)inputs[3];
         LVect3d vx1 = new LVect3d ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vx2 = new LVect3d ( fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vy1 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + delta + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vy2 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vz1 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + delta + 300 ) ) . normal ( ) ;
         LVect3d vz2 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) . normal ( ) ;
         LVect3d ynorm = y . normal ( ) ;
         double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         return new Color ( xpart , ypart , zpart ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class fgrad_col_v3_4 extends ExpressionFunction {
      private static final double delta = .01 ;
      public int getNumberInputs() {
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            case 1: return "y";
            case 2: return "noise";
            case 3: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return NoiseFunction.class;
            case 3: return NoiseFractal.class;
            default: return null;
         }

      }

      public fgrad_col_v3_4() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         LVect3d y = (LVect3d)inputs[1];
         NoiseFunction noise = (NoiseFunction)inputs[2];
         NoiseFractal fractal = (NoiseFractal)inputs[3];
         LVect3d vx1 = new LVect3d ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vx2 = new LVect3d ( fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vy1 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + delta + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vy2 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) . normal ( ) ;
         LVect3d vz1 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + delta + 300 ) ) . normal ( ) ;
         LVect3d vz2 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) . normal ( ) ;
         LVect3d ynorm = y . normal ( ) ;
         double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ;
         return new Color ( xpart , ypart , zpart ) . normal ( ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public String getDescription() {
      return "Noise: Gradient evaluation";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new ngrad_v2_d_1());
      r.add(new ngrad_v2_d_2());
      r.add(new ngrad_v3_d_1());
      r.add(new ngrad_v3_d_2());
      r.add(new ngrad_v2_v2_1());
      r.add(new ngrad_v2_v2_2());
      r.add(new ngrad_v2_v2_3());
      r.add(new ngrad_v2_v2_4());
      r.add(new ngrad_v3_v2_1());
      r.add(new ngrad_v3_v2_2());
      r.add(new ngrad_v3_v2_3());
      r.add(new ngrad_v3_v2_4());
      r.add(new ngrad_v3_v3_1());
      r.add(new ngrad_v3_v3_2());
      r.add(new ngrad_v3_v3_3());
      r.add(new ngrad_v3_v3_4());
      r.add(new ngrad_col_v2_1());
      r.add(new ngrad_col_v2_2());
      r.add(new ngrad_col_v2_3());
      r.add(new ngrad_col_v2_4());
      r.add(new ngrad_col_v3_1());
      r.add(new ngrad_col_v3_2());
      r.add(new ngrad_col_v3_3());
      r.add(new ngrad_col_v3_4());
      r.add(new fgrad_v2_d_1());
      r.add(new fgrad_v2_d_2());
      r.add(new fgrad_v3_d_1());
      r.add(new fgrad_v3_d_2());
      r.add(new fgrad_v2_v2_1());
      r.add(new fgrad_v2_v2_2());
      r.add(new fgrad_v2_v2_3());
      r.add(new fgrad_v2_v2_4());
      r.add(new fgrad_v3_v2_1());
      r.add(new fgrad_v3_v2_2());
      r.add(new fgrad_v3_v2_3());
      r.add(new fgrad_v3_v2_4());
      r.add(new fgrad_v3_v3_1());
      r.add(new fgrad_v3_v3_2());
      r.add(new fgrad_v3_v3_3());
      r.add(new fgrad_v3_v3_4());
      r.add(new fgrad_col_v2_1());
      r.add(new fgrad_col_v2_2());
      r.add(new fgrad_col_v2_3());
      r.add(new fgrad_col_v2_4());
      r.add(new fgrad_col_v3_1());
      r.add(new fgrad_col_v3_2());
      r.add(new fgrad_col_v3_3());
      r.add(new fgrad_col_v3_4());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
