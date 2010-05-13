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

public final class NoiseCurves implements AllComponents<ExpressionFunction>, Described {

   public static class noisecurve_d extends ExpressionFunction {

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

      public noisecurve_d() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_d evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         return new CurveUtil . Curve_d ( ) {
         public LDouble getValue ( double v ) {
         return new LDouble ( noise . noise ( v , 0 , 0 ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_d.class;
      }

   }

   public static class noisecurve_d_scaled extends ExpressionFunction {

      private LDouble scale;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: scale = (LDouble) value; return;
            default: return;
         }

      }

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

      public noisecurve_d_scaled() {
         addGroupMeta(this);
         scale = new LDouble ( 1 + 3 * Math . random ( ) ) ;
      }

      public CurveUtil . Curve_d evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         return new CurveUtil . Curve_d ( ) {
         public LDouble getValue ( double v ) {
         v = v * scale . val ;
         return new LDouble ( noise . noise ( v , 0 , 0 ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_d.class;
      }

   }

   public static class noisecurve_v2 extends ExpressionFunction {

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

      public noisecurve_v2() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         return new CurveUtil . Curve_v2 ( ) {
         public LVect2d getValue ( double v ) {
         return new LVect2d ( noise . noise ( v , 0 , 0 ) , noise . noise ( v + 100 , 10 , 10 ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class noisecurve_v2_scaled extends ExpressionFunction {

      private LDouble scale;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: scale = (LDouble) value; return;
            default: return;
         }

      }

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

      public noisecurve_v2_scaled() {
         addGroupMeta(this);
         scale = new LDouble ( 1 + 3 * Math . random ( ) ) ;
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         return new CurveUtil . Curve_v2 ( ) {
         public LVect2d getValue ( double v ) {
         v = v * scale . val ;
         return new LVect2d ( noise . noise ( v , 0 , 0 ) , noise . noise ( v + 100 , 10 , 10 ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class noisecurve_v2_n extends ExpressionFunction {

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

      public noisecurve_v2_n() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         return new CurveUtil . Curve_v2 ( ) {
         public LVect2d getValue ( double v ) {
         return new LVect2d ( noise . noise ( v , 0 , 0 ) , noise . noise ( v + 100 , 10 , 10 ) ) . normal ( ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class noisecurve_v2_n_scaled extends ExpressionFunction {

      private LDouble scale;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: scale = (LDouble) value; return;
            default: return;
         }

      }

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

      public noisecurve_v2_n_scaled() {
         addGroupMeta(this);
         scale = new LDouble ( 1 + 3 * Math . random ( ) ) ;
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         return new CurveUtil . Curve_v2 ( ) {
         public LVect2d getValue ( double v ) {
         v = v * scale . val ;
         return new LVect2d ( noise . noise ( v , 0 , 0 ) , noise . noise ( v + 100 , 10 , 10 ) ) . normal ( ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class noisecurve_col extends ExpressionFunction {

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

      public noisecurve_col() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         return new CurveUtil . Curve_col ( ) {
         public Color getValue ( double v ) {
         return new Color ( noise . noise ( v , 0 , 0 ) , noise . noise ( v + 100 , 10 , 10 ) , noise . noise ( v + 300 , 30 , 30 ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public static class noisecurve_col_scaled extends ExpressionFunction {

      private LDouble scale;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: scale = (LDouble) value; return;
            default: return;
         }

      }

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

      public noisecurve_col_scaled() {
         addGroupMeta(this);
         scale = new LDouble ( 1 + 3 * Math . random ( ) ) ;
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         return new CurveUtil . Curve_col ( ) {
         public Color getValue ( double v ) {
         v = v * scale . val ;
         return new Color ( noise . noise ( v , 0 , 0 ) , noise . noise ( v + 100 , 10 , 10 ) , noise . noise ( v + 300 , 30 , 30 ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public static class noisecurve_col_n extends ExpressionFunction {

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

      public noisecurve_col_n() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         return new CurveUtil . Curve_col ( ) {
         public Color getValue ( double v ) {
         return new Color ( noise . noise ( v , 0 , 0 ) , noise . noise ( v + 100 , 10 , 10 ) , noise . noise ( v + 300 , 30 , 30 ) ) . normal ( ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public static class noisecurve_col_n_scaled extends ExpressionFunction {

      private LDouble scale;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: scale = (LDouble) value; return;
            default: return;
         }

      }

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

      public noisecurve_col_n_scaled() {
         addGroupMeta(this);
         scale = new LDouble ( 1 + 3 * Math . random ( ) ) ;
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         return new CurveUtil . Curve_col ( ) {
         public Color getValue ( double v ) {
         v = v * scale . val ;
         return new Color ( noise . noise ( v , 0 , 0 ) , noise . noise ( v + 100 , 10 , 10 ) , noise . noise ( v + 300 , 30 , 30 ) ) . normal ( ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public static class noisecurve_col2 extends ExpressionFunction {

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

      public noisecurve_col2() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         return new CurveUtil . Curve_col ( ) {
         public Color getValue ( double v ) {
         return Color . makeHSB ( noise . noise ( v , 0 , 0 ) , noise . noise ( v + 100 , 10 , 10 ) , noise . noise ( v + 300 , 30 , 30 ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public static class noisecurve_col3 extends ExpressionFunction {

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

      public noisecurve_col3() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         return new CurveUtil . Curve_col ( ) {
         public Color getValue ( double v ) {
         LVect3d a = new LVect3d ( noise . noise ( v , 0 , 0 ) , noise . noise ( v + 100 , 10 , 10 ) , noise . noise ( v + 300 , 30 , 30 ) ) . normal ( ) ;
         return Color . makeHSB ( a . x , a . y , a . z ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public static class fractalcurve_d extends ExpressionFunction {

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

      public fractalcurve_d() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_d evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         final NoiseFractal fractal = (NoiseFractal)inputs[1];
         return new CurveUtil . Curve_d ( ) {
         public LDouble getValue ( double v ) {
         return new LDouble ( fractal . evalFractal ( noise , v , 0 , 0 ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_d.class;
      }

   }

   public static class fractalcurve_d_scaled extends ExpressionFunction {

      private LDouble scale;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: scale = (LDouble) value; return;
            default: return;
         }

      }

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

      public fractalcurve_d_scaled() {
         addGroupMeta(this);
         scale = new LDouble ( 1 + 3 * Math . random ( ) ) ;
      }

      public CurveUtil . Curve_d evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         final NoiseFractal fractal = (NoiseFractal)inputs[1];
         return new CurveUtil . Curve_d ( ) {
         public LDouble getValue ( double v ) {
         v = v * scale . val ;
         return new LDouble ( fractal . evalFractal ( noise , v , 0 , 0 ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_d.class;
      }

   }

   public static class fractalcurve_v2 extends ExpressionFunction {

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

      public fractalcurve_v2() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         final NoiseFractal fractal = (NoiseFractal)inputs[1];
         return new CurveUtil . Curve_v2 ( ) {
         public LVect2d getValue ( double v ) {
         return new LVect2d ( fractal . evalFractal ( noise , v , 0 , 0 ) , fractal . evalFractal ( noise , v + 100 , 10 , 10 ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class fractalcurve_v2_scaled extends ExpressionFunction {

      private LDouble scale;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: scale = (LDouble) value; return;
            default: return;
         }

      }

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

      public fractalcurve_v2_scaled() {
         addGroupMeta(this);
         scale = new LDouble ( 1 + 3 * Math . random ( ) ) ;
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         final NoiseFractal fractal = (NoiseFractal)inputs[1];
         return new CurveUtil . Curve_v2 ( ) {
         public LVect2d getValue ( double v ) {
         v = v * scale . val ;
         return new LVect2d ( fractal . evalFractal ( noise , v , 0 , 0 ) , fractal . evalFractal ( noise , v + 100 , 10 , 10 ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class fractalcurve_v2_n extends ExpressionFunction {

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

      public fractalcurve_v2_n() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         final NoiseFractal fractal = (NoiseFractal)inputs[1];
         return new CurveUtil . Curve_v2 ( ) {
         public LVect2d getValue ( double v ) {
         return new LVect2d ( fractal . evalFractal ( noise , v , 0 , 0 ) , fractal . evalFractal ( noise , v + 100 , 10 , 10 ) ) . normal ( ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class fractalcurve_v2_n_scaled extends ExpressionFunction {

      private LDouble scale;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: scale = (LDouble) value; return;
            default: return;
         }

      }

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

      public fractalcurve_v2_n_scaled() {
         addGroupMeta(this);
         scale = new LDouble ( 1 + 3 * Math . random ( ) ) ;
      }

      public CurveUtil . Curve_v2 evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         final NoiseFractal fractal = (NoiseFractal)inputs[1];
         return new CurveUtil . Curve_v2 ( ) {
         public LVect2d getValue ( double v ) {
         v = v * scale . val ;
         return new LVect2d ( fractal . evalFractal ( noise , v , 0 , 0 ) , fractal . evalFractal ( noise , v + 100 , 10 , 10 ) ) . normal ( ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_v2.class;
      }

   }

   public static class fractalcurve_col extends ExpressionFunction {

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

      public fractalcurve_col() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         final NoiseFractal fractal = (NoiseFractal)inputs[1];
         return new CurveUtil . Curve_col ( ) {
         public Color getValue ( double v ) {
         return new Color ( fractal . evalFractal ( noise , v , 0 , 0 ) , fractal . evalFractal ( noise , v + 100 , 10 , 10 ) , fractal . evalFractal ( noise , v + 300 , 30 , 30 ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public static class fractalcurve_col_scaled extends ExpressionFunction {

      private LDouble scale;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: scale = (LDouble) value; return;
            default: return;
         }

      }

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

      public fractalcurve_col_scaled() {
         addGroupMeta(this);
         scale = new LDouble ( 1 + 3 * Math . random ( ) ) ;
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         final NoiseFractal fractal = (NoiseFractal)inputs[1];
         return new CurveUtil . Curve_col ( ) {
         public Color getValue ( double v ) {
         v = v * scale . val ;
         return new Color ( fractal . evalFractal ( noise , v , 0 , 0 ) , fractal . evalFractal ( noise , v + 100 , 10 , 10 ) , fractal . evalFractal ( noise , v + 300 , 30 , 30 ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public static class fractalcurve_col_n extends ExpressionFunction {

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

      public fractalcurve_col_n() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         final NoiseFractal fractal = (NoiseFractal)inputs[1];
         return new CurveUtil . Curve_col ( ) {
         public Color getValue ( double v ) {
         return new Color ( fractal . evalFractal ( noise , v , 0 , 0 ) , fractal . evalFractal ( noise , v + 100 , 10 , 10 ) , fractal . evalFractal ( noise , v + 300 , 30 , 30 ) ) . normal ( ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public static class fractalcurve_col_n_scaled extends ExpressionFunction {

      private LDouble scale;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: scale = (LDouble) value; return;
            default: return;
         }

      }

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

      public fractalcurve_col_n_scaled() {
         addGroupMeta(this);
         scale = new LDouble ( 1 + 3 * Math . random ( ) ) ;
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         final NoiseFractal fractal = (NoiseFractal)inputs[1];
         return new CurveUtil . Curve_col ( ) {
         public Color getValue ( double v ) {
         v = v * scale . val ;
         return new Color ( fractal . evalFractal ( noise , v , 0 , 0 ) , fractal . evalFractal ( noise , v + 100 , 10 , 10 ) , fractal . evalFractal ( noise , v + 300 , 30 , 30 ) ) . normal ( ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public static class fractalcurve_col2 extends ExpressionFunction {

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

      public fractalcurve_col2() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         final NoiseFractal fractal = (NoiseFractal)inputs[1];
         return new CurveUtil . Curve_col ( ) {
         public Color getValue ( double v ) {
         return Color . makeHSB ( fractal . evalFractal ( noise , v , 0 , 0 ) , fractal . evalFractal ( noise , v + 100 , 10 , 10 ) , fractal . evalFractal ( noise , v + 300 , 30 , 30 ) ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public static class fractalcurve_col3 extends ExpressionFunction {

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

      public fractalcurve_col3() {
         addGroupMeta(this);
      }

      public CurveUtil . Curve_col evaluate(Context context, Object[] inputs) {
         final NoiseFunction noise = (NoiseFunction)inputs[0];
         final NoiseFractal fractal = (NoiseFractal)inputs[1];
         return new CurveUtil . Curve_col ( ) {
         public Color getValue ( double v ) {
         LVect3d a = new LVect3d ( fractal . evalFractal ( noise , v , 0 , 0 ) , fractal . evalFractal ( noise , v + 100 , 10 , 10 ) , fractal . evalFractal ( noise , v + 300 , 30 , 30 ) ) . normal ( ) ;
         return Color . makeHSB ( a . x , a . y , a . z ) ;
         }
         }
         ;
      }

      public Class getReturnType() {
         return CurveUtil . Curve_col.class;
      }

   }

   public String getDescription() {
      return "expressions to generate curves based on Perlin noise";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new noisecurve_d());
      r.add(new noisecurve_d_scaled());
      r.add(new noisecurve_v2());
      r.add(new noisecurve_v2_scaled());
      r.add(new noisecurve_v2_n());
      r.add(new noisecurve_v2_n_scaled());
      r.add(new noisecurve_col());
      r.add(new noisecurve_col_scaled());
      r.add(new noisecurve_col_n());
      r.add(new noisecurve_col_n_scaled());
      r.add(new noisecurve_col2());
      r.add(new noisecurve_col3());
      r.add(new fractalcurve_d());
      r.add(new fractalcurve_d_scaled());
      r.add(new fractalcurve_v2());
      r.add(new fractalcurve_v2_scaled());
      r.add(new fractalcurve_v2_n());
      r.add(new fractalcurve_v2_n_scaled());
      r.add(new fractalcurve_col());
      r.add(new fractalcurve_col_scaled());
      r.add(new fractalcurve_col_n());
      r.add(new fractalcurve_col_n_scaled());
      r.add(new fractalcurve_col2());
      r.add(new fractalcurve_col3());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
