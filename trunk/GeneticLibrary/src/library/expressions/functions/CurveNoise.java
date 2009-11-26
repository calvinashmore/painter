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
import utils.curves.*;
import utils.noise.*;

public final class CurveNoise implements AllComponents<ExpressionFunction>, Described {

   public static class basicnoise_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            default: return null;
         }

      }

      public basicnoise_d() {
         addGroupMeta(this);
         addMeta("selectionWeight", 5);
      }

      public CurveUtil . Curve_d evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         return new CurveUtil . Curve_d ( ) {
         public LDouble getValue ( double t ) {
         return new LDouble ( noise . noise ( t , 0 , 0 ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_d.class;
      }

   }

   public static class basicnoise_v2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            default: return null;
         }

      }

      public basicnoise_v2() {
         addGroupMeta(this);
         addMeta("selectionWeight", 5);
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         return new CurveUtil . Curve_v2 ( ) {
         public LVect2d getValue ( double t ) {
         return new LVect2d ( noise . noise ( t , 0 , 0 ) , noise . noise ( t + 100 , 0 , 100 ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class basicnoise_v2_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            default: return null;
         }

      }

      public basicnoise_v2_n() {
         addGroupMeta(this);
         addMeta("selectionWeight", 5);
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         return new CurveUtil . Curve_v2 ( ) {
         public LVect2d getValue ( double t ) {
         return new LVect2d ( noise . noise ( t , 0 , 0 ) , noise . noise ( t + 100 , 0 , 100 ) ) . normal ( ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class basicnoise_col extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            default: return null;
         }

      }

      public basicnoise_col() {
         addGroupMeta(this);
         addMeta("selectionWeight", 5);
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         return new CurveUtil . Curve_col ( ) {
         public Color getValue ( double t ) {
         return new Color ( .5 + .5 * noise . noise ( t , 0 , 0 ) , .5 + .5 * noise . noise ( t + 100 , 0 , 100 ) , .5 + .5 * noise . noise ( t + 300 , 0 , 300 ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public static class basicnoise_col_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            default: return null;
         }

      }

      public basicnoise_col_n() {
         addGroupMeta(this);
         addMeta("selectionWeight", 5);
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         return new CurveUtil . Curve_col ( ) {
         public Color getValue ( double t ) {
         return new Color ( .5 + .5 * noise . noise ( t , 0 , 0 ) , .5 + .5 * noise . noise ( t + 100 , 0 , 100 ) , .5 + .5 * noise . noise ( t + 300 , 0 , 300 ) ) . normal ( ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public static class basicfractal_d extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            default: return null;
         }

      }

      public basicfractal_d() {
         addGroupMeta(this);
         addMeta("selectionWeight", 5);
      }

      public CurveUtil . Curve_d evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         final NoiseFractal fractal = (NoiseFractal)inputs[1];
         return new CurveUtil . Curve_d ( ) {
         public LDouble getValue ( double t ) {
         return new LDouble ( fractal . evalFractal ( noise , t , 0 , 0 ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_d.class;
      }

   }

   public static class basicfractal_v2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            default: return null;
         }

      }

      public basicfractal_v2() {
         addGroupMeta(this);
         addMeta("selectionWeight", 5);
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         final NoiseFractal fractal = (NoiseFractal)inputs[1];
         return new CurveUtil . Curve_v2 ( ) {
         public LVect2d getValue ( double t ) {
         return new LVect2d ( fractal . evalFractal ( noise , t , 0 , 0 ) , fractal . evalFractal ( noise , t + 100 , 0 , 100 ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class basicfractal_v2_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            default: return null;
         }

      }

      public basicfractal_v2_n() {
         addGroupMeta(this);
         addMeta("selectionWeight", 5);
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         final NoiseFractal fractal = (NoiseFractal)inputs[1];
         return new CurveUtil . Curve_v2 ( ) {
         public LVect2d getValue ( double t ) {
         return new LVect2d ( fractal . evalFractal ( noise , t , 0 , 0 ) , fractal . evalFractal ( noise , t + 100 , 0 , 100 ) ) . normal ( ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class basicfractal_col extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            default: return null;
         }

      }

      public basicfractal_col() {
         addGroupMeta(this);
         addMeta("selectionWeight", 5);
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         final NoiseFractal fractal = (NoiseFractal)inputs[1];
         return new CurveUtil . Curve_col ( ) {
         public Color getValue ( double t ) {
         return new Color ( .5 + .5 * fractal . evalFractal ( noise , t , 0 , 0 ) , .5 + .5 * fractal . evalFractal ( noise , t + 100 , 0 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , t + 300 , 0 , 300 ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public static class basicfractal_col_n extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "noise";
            case 1: return "fractal";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return NoiseFunction.class;
            case 1: return NoiseFractal.class;
            default: return null;
         }

      }

      public basicfractal_col_n() {
         addGroupMeta(this);
         addMeta("selectionWeight", 5);
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         final NoiseFractal fractal = (NoiseFractal)inputs[1];
         return new CurveUtil . Curve_col ( ) {
         public Color getValue ( double t ) {
         return new Color ( .5 + .5 * fractal . evalFractal ( noise , t , 0 , 0 ) , .5 + .5 * fractal . evalFractal ( noise , t + 100 , 0 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , t + 300 , 0 , 300 ) ) . normal ( ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public String getDescription() {
      return "curves based on perlin noise";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new basicnoise_d());
      r.add(new basicnoise_v2());
      r.add(new basicnoise_v2_n());
      r.add(new basicnoise_col());
      r.add(new basicnoise_col_n());
      r.add(new basicfractal_d());
      r.add(new basicfractal_v2());
      r.add(new basicfractal_v2_n());
      r.add(new basicfractal_col());
      r.add(new basicfractal_col_n());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
