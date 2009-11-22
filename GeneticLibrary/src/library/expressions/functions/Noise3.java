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

public final class Noise3 implements AllComponents<ExpressionFunction>, Described {

   public static class fBm1 extends ExpressionFunction {
      private final NoiseFractal fractal = new NoiseFractal ( ) { public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double value = 0 ; double x1 = x ; double y1 = y ; double z1 = z ; for ( int i = 0 ; i < octaves ; i ++ ) { value += f . noise ( x1 , y1 , z1 ) * amplitude ; x1 *= lacunarity ; y1 *= lacunarity ; z1 *= lacunarity ; amplitude *= exponent ; } return value ; } } ;
      private double lacunarity;private double exponent;private int octaves;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return lacunarity;
            case 1: return exponent;
            case 2: return octaves;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "lacunarity";
            case 1: return "exponent";
            case 2: return "octaves";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            case 2: return int.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: lacunarity = (Double) value; return;
            case 1: exponent = (Double) value; return;
            case 2: octaves = (Integer) value; return;
            default: return;
         }

      }

      public fBm1() {
         addGroupMeta(this);
         lacunarity = 1.5 + Math . random ( ) ;
         exponent = .1 + .7 * Math . random ( ) ;
         octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public NoiseFractal evaluate(Context context, Object[] inputs) {

         return fractal ;
      }

      public Class getReturnType() {
         return NoiseFractal.class;
      }

   }

   public static class fBm2 extends ExpressionFunction {
      private double exponent1 ;private final NoiseFractal fractal = new NoiseFractal ( ) { public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double value = 0 ; double x1 = x ; double y1 = y ; double z1 = z ; for ( int i = 0 ; i < octaves ; i ++ ) { value += f . noise ( x1 , y1 , z1 ) * amplitude ; x1 *= lacunarity ; y1 *= lacunarity ; z1 *= lacunarity ; amplitude *= exponent1 ; } return value ; } } ;
      private double lacunarity;private int octaves;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return lacunarity;
            case 1: return octaves;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "lacunarity";
            case 1: return "octaves";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return int.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: lacunarity = (Double) value; return;
            case 1: octaves = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "exponent";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public fBm2() {
         addGroupMeta(this);
         lacunarity = 1.5 + Math . random ( ) ;
         octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public NoiseFractal evaluate(Context context, Object[] inputs) {
         LDouble exponent = (LDouble)inputs[0];
         exponent1 = exponent . val / 4 ;
         return fractal ;
      }

      public Class getReturnType() {
         return NoiseFractal.class;
      }

   }

   public static class fBm3 extends ExpressionFunction {
      private double exponent1 ;private double lacunarity1 ;private final NoiseFractal fractal = new NoiseFractal ( ) { public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double value = 0 ; double x1 = x ; double y1 = y ; double z1 = z ; for ( int i = 0 ; i < octaves ; i ++ ) { value += f . noise ( x1 , y1 , z1 ) * amplitude ; x1 *= lacunarity1 ; y1 *= lacunarity1 ; z1 *= lacunarity1 ; amplitude *= exponent1 ; } return value ; } } ;
      private int octaves;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return octaves;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "octaves";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return int.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: octaves = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "lacunarity";
            case 1: return "exponent";
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

      public fBm3() {
         addGroupMeta(this);
         octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public NoiseFractal evaluate(Context context, Object[] inputs) {
         LDouble lacunarity = (LDouble)inputs[0];
         LDouble exponent = (LDouble)inputs[1];
         exponent1 = exponent . val / 4 ;
         lacunarity1 = lacunarity . val ;
         return fractal ;
      }

      public Class getReturnType() {
         return NoiseFractal.class;
      }

   }

   public static class StatsByAlt1 extends ExpressionFunction {
      private final NoiseFractal fractal = new NoiseFractal ( ) { public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = f . noise ( x1 , y1 , z1 ) ; for ( int i = 1 ; i < octaves ; i ++ ) { value += value * f . noise ( x1 , y1 , z1 ) * amplitude ; x1 *= lacunarity ; y1 *= lacunarity ; z1 *= lacunarity ; amplitude *= exponent ; } return value ; } } ;
      private double lacunarity;private double exponent;private int octaves;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return lacunarity;
            case 1: return exponent;
            case 2: return octaves;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "lacunarity";
            case 1: return "exponent";
            case 2: return "octaves";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            case 2: return int.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: lacunarity = (Double) value; return;
            case 1: exponent = (Double) value; return;
            case 2: octaves = (Integer) value; return;
            default: return;
         }

      }

      public StatsByAlt1() {
         addGroupMeta(this);
         lacunarity = 1.5 + Math . random ( ) ;
         exponent = .1 + .7 * Math . random ( ) ;
         octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public NoiseFractal evaluate(Context context, Object[] inputs) {

         return fractal ;
      }

      public Class getReturnType() {
         return NoiseFractal.class;
      }

   }

   public static class StatsByAlt2 extends ExpressionFunction {
      private double exponent1 ;private final NoiseFractal fractal = new NoiseFractal ( ) { public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = f . noise ( x1 , y1 , z1 ) ; for ( int i = 1 ; i < octaves ; i ++ ) { value += value * f . noise ( x1 , y1 , z1 ) * amplitude ; x1 *= lacunarity ; y1 *= lacunarity ; z1 *= lacunarity ; amplitude *= exponent1 ; } return value ; } } ;
      private double lacunarity;private int octaves;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return lacunarity;
            case 1: return octaves;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "lacunarity";
            case 1: return "octaves";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return int.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: lacunarity = (Double) value; return;
            case 1: octaves = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "exponent";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public StatsByAlt2() {
         addGroupMeta(this);
         lacunarity = 1.5 + Math . random ( ) ;
         octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public NoiseFractal evaluate(Context context, Object[] inputs) {
         LDouble exponent = (LDouble)inputs[0];
         exponent1 = exponent . val / 4 ;
         return fractal ;
      }

      public Class getReturnType() {
         return NoiseFractal.class;
      }

   }

   public static class StatsByAlt3 extends ExpressionFunction {
      private double exponent1 ;private double lacunarity1 ;private final NoiseFractal fractal = new NoiseFractal ( ) { public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = f . noise ( x1 , y1 , z1 ) ; for ( int i = 1 ; i < octaves ; i ++ ) { value += value * f . noise ( x1 , y1 , z1 ) * amplitude ; x1 *= lacunarity1 ; y1 *= lacunarity1 ; z1 *= lacunarity1 ; amplitude *= exponent1 ; } return value ; } } ;
      private int octaves;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return octaves;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "octaves";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return int.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: octaves = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "lacunarity";
            case 1: return "exponent";
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

      public StatsByAlt3() {
         addGroupMeta(this);
         octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public NoiseFractal evaluate(Context context, Object[] inputs) {
         LDouble lacunarity = (LDouble)inputs[0];
         LDouble exponent = (LDouble)inputs[1];
         exponent1 = exponent . val / 4 ;
         lacunarity1 = lacunarity . val ;
         return fractal ;
      }

      public Class getReturnType() {
         return NoiseFractal.class;
      }

   }

   public static class MultifractalA_1 extends ExpressionFunction {
      private final NoiseFractal fractal = new NoiseFractal ( ) { public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = 0 ; double weight = 0 ; double signal = 0 ; weight = value = f . noise ( x1 , y1 , z1 ) ; for ( int i = 1 ; i < octaves ; i ++ ) { signal = f . noise ( x1 , y1 , z1 ) * amplitude ; value += weight * signal ; weight = signal ; x1 *= lacunarity ; y1 *= lacunarity ; z1 *= lacunarity ; amplitude *= exponent ; } return value ; } } ;
      private double lacunarity;private double exponent;private int octaves;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return lacunarity;
            case 1: return exponent;
            case 2: return octaves;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "lacunarity";
            case 1: return "exponent";
            case 2: return "octaves";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            case 2: return int.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: lacunarity = (Double) value; return;
            case 1: exponent = (Double) value; return;
            case 2: octaves = (Integer) value; return;
            default: return;
         }

      }

      public MultifractalA_1() {
         addGroupMeta(this);
         lacunarity = 1.5 + Math . random ( ) ;
         exponent = .1 + .7 * Math . random ( ) ;
         octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public NoiseFractal evaluate(Context context, Object[] inputs) {

         return fractal ;
      }

      public Class getReturnType() {
         return NoiseFractal.class;
      }

   }

   public static class MultifractalA_2 extends ExpressionFunction {
      private double exponent1 ;private final NoiseFractal fractal = new NoiseFractal ( ) { public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = 0 ; double weight = 0 ; double signal = 0 ; weight = value = f . noise ( x1 , y1 , z1 ) ; for ( int i = 1 ; i < octaves ; i ++ ) { signal = f . noise ( x1 , y1 , z1 ) * amplitude ; value += weight * signal ; weight = signal ; x1 *= lacunarity ; y1 *= lacunarity ; z1 *= lacunarity ; amplitude *= exponent1 ; } return value ; } } ;
      private double lacunarity;private int octaves;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return lacunarity;
            case 1: return octaves;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "lacunarity";
            case 1: return "octaves";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return int.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: lacunarity = (Double) value; return;
            case 1: octaves = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "exponent";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public MultifractalA_2() {
         addGroupMeta(this);
         lacunarity = 1.5 + Math . random ( ) ;
         octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public NoiseFractal evaluate(Context context, Object[] inputs) {
         LDouble exponent = (LDouble)inputs[0];
         exponent1 = exponent . val / 4 ;
         return fractal ;
      }

      public Class getReturnType() {
         return NoiseFractal.class;
      }

   }

   public static class MultifractalA_3 extends ExpressionFunction {
      private double exponent1 ;private double lacunarity1 ;private final NoiseFractal fractal = new NoiseFractal ( ) { public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = 0 ; double weight = 0 ; double signal = 0 ; weight = value = f . noise ( x1 , y1 , z1 ) ; for ( int i = 1 ; i < octaves ; i ++ ) { signal = f . noise ( x1 , y1 , z1 ) * amplitude ; value += weight * signal ; weight = signal ; x1 *= lacunarity1 ; y1 *= lacunarity1 ; z1 *= lacunarity1 ; amplitude *= exponent1 ; } return value ; } } ;
      private int octaves;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return octaves;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "octaves";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return int.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: octaves = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "lacunarity";
            case 1: return "exponent";
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

      public MultifractalA_3() {
         addGroupMeta(this);
         octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public NoiseFractal evaluate(Context context, Object[] inputs) {
         LDouble lacunarity = (LDouble)inputs[0];
         LDouble exponent = (LDouble)inputs[1];
         exponent1 = exponent . val / 4 ;
         lacunarity1 = lacunarity . val ;
         return fractal ;
      }

      public Class getReturnType() {
         return NoiseFractal.class;
      }

   }

   public static class MultifractalB_1 extends ExpressionFunction {
      private final NoiseFractal fractal = new NoiseFractal ( ) { public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = 0 ; double weight = 0 ; double signal = 0 ; weight = value = f . noise ( x1 , y1 , z1 ) ; for ( int i = 1 ; i < octaves ; i ++ ) { signal = f . noise ( x1 , y1 , z1 ) * amplitude ; value += weight * signal ; weight = signal ; x1 *= lacunarity + signal ; y1 *= lacunarity + signal ; z1 *= lacunarity + signal ; amplitude *= exponent ; } return value ; } } ;
      private double lacunarity;private double exponent;private int octaves;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return lacunarity;
            case 1: return exponent;
            case 2: return octaves;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "lacunarity";
            case 1: return "exponent";
            case 2: return "octaves";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            case 2: return int.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: lacunarity = (Double) value; return;
            case 1: exponent = (Double) value; return;
            case 2: octaves = (Integer) value; return;
            default: return;
         }

      }

      public MultifractalB_1() {
         addGroupMeta(this);
         lacunarity = 1.5 + Math . random ( ) ;
         exponent = .1 + .7 * Math . random ( ) ;
         octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public NoiseFractal evaluate(Context context, Object[] inputs) {

         return fractal ;
      }

      public Class getReturnType() {
         return NoiseFractal.class;
      }

   }

   public static class MultifractalB_2 extends ExpressionFunction {
      private double exponent1 ;private final NoiseFractal fractal = new NoiseFractal ( ) { public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = 0 ; double weight = 0 ; double signal = 0 ; weight = value = f . noise ( x1 , y1 , z1 ) ; for ( int i = 1 ; i < octaves ; i ++ ) { signal = f . noise ( x1 , y1 , z1 ) * amplitude ; value += weight * signal ; weight = signal ; x1 *= lacunarity + signal ; y1 *= lacunarity + signal ; z1 *= lacunarity + signal ; amplitude *= exponent1 ; } return value ; } } ;
      private double lacunarity;private int octaves;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return lacunarity;
            case 1: return octaves;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "lacunarity";
            case 1: return "octaves";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return int.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: lacunarity = (Double) value; return;
            case 1: octaves = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "exponent";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public MultifractalB_2() {
         addGroupMeta(this);
         lacunarity = 1.5 + Math . random ( ) ;
         octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public NoiseFractal evaluate(Context context, Object[] inputs) {
         LDouble exponent = (LDouble)inputs[0];
         exponent1 = exponent . val / 4 ;
         return fractal ;
      }

      public Class getReturnType() {
         return NoiseFractal.class;
      }

   }

   public static class MultifractalB_3 extends ExpressionFunction {
      private double exponent1 ;private double lacunarity1 ;private final NoiseFractal fractal = new NoiseFractal ( ) { public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = 0 ; double weight = 0 ; double signal = 0 ; weight = value = f . noise ( x1 , y1 , z1 ) ; for ( int i = 1 ; i < octaves ; i ++ ) { signal = f . noise ( x1 , y1 , z1 ) * amplitude ; value += weight * signal ; weight = signal ; x1 *= lacunarity1 + signal ; y1 *= lacunarity1 + signal ; z1 *= lacunarity1 + signal ; amplitude *= exponent1 ; } return value ; } } ;
      private int octaves;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return octaves;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "octaves";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return int.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: octaves = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "lacunarity";
            case 1: return "exponent";
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

      public MultifractalB_3() {
         addGroupMeta(this);
         octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public NoiseFractal evaluate(Context context, Object[] inputs) {
         LDouble lacunarity = (LDouble)inputs[0];
         LDouble exponent = (LDouble)inputs[1];
         exponent1 = exponent . val / 4 ;
         lacunarity1 = lacunarity . val ;
         return fractal ;
      }

      public Class getReturnType() {
         return NoiseFractal.class;
      }

   }

   public static class MultifractalC_1 extends ExpressionFunction {
      private final NoiseFractal fractal = new NoiseFractal ( ) { public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = 0 ; for ( int i = 0 ; i < octaves ; i ++ ) { value += f . noise ( x1 , y1 , z1 ) * amplitude ; x1 *= lacunarity + value ; y1 *= lacunarity + value ; z1 *= lacunarity + value ; amplitude *= exponent ; } return value ; } } ;
      private double lacunarity;private double exponent;private int octaves;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return lacunarity;
            case 1: return exponent;
            case 2: return octaves;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "lacunarity";
            case 1: return "exponent";
            case 2: return "octaves";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            case 2: return int.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: lacunarity = (Double) value; return;
            case 1: exponent = (Double) value; return;
            case 2: octaves = (Integer) value; return;
            default: return;
         }

      }

      public MultifractalC_1() {
         addGroupMeta(this);
         lacunarity = 1.5 + Math . random ( ) ;
         exponent = .1 + .6 * Math . random ( ) ;
         octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public NoiseFractal evaluate(Context context, Object[] inputs) {

         return fractal ;
      }

      public Class getReturnType() {
         return NoiseFractal.class;
      }

   }

   public static class MultifractalC_2 extends ExpressionFunction {
      private double exponent1 ;private final NoiseFractal fractal = new NoiseFractal ( ) { public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = 0 ; for ( int i = 0 ; i < octaves ; i ++ ) { value += f . noise ( x1 , y1 , z1 ) * amplitude ; x1 *= lacunarity + value ; y1 *= lacunarity + value ; z1 *= lacunarity + value ; amplitude *= exponent1 ; } return value ; } } ;
      private double lacunarity;private int octaves;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return lacunarity;
            case 1: return octaves;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "lacunarity";
            case 1: return "octaves";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return int.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: lacunarity = (Double) value; return;
            case 1: octaves = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "exponent";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public MultifractalC_2() {
         addGroupMeta(this);
         lacunarity = 1.5 + Math . random ( ) ;
         octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public NoiseFractal evaluate(Context context, Object[] inputs) {
         LDouble exponent = (LDouble)inputs[0];
         exponent1 = exponent . val / 4 ;
         return fractal ;
      }

      public Class getReturnType() {
         return NoiseFractal.class;
      }

   }

   public static class MultifractalC_3 extends ExpressionFunction {
      private double exponent1 ;private double lacunarity1 ;private final NoiseFractal fractal = new NoiseFractal ( ) { public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = 0 ; for ( int i = 0 ; i < octaves ; i ++ ) { value += f . noise ( x1 , y1 , z1 ) * amplitude ; x1 *= lacunarity1 + value ; y1 *= lacunarity1 + value ; z1 *= lacunarity1 + value ; amplitude *= exponent1 ; } return value ; } } ;
      private int octaves;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return octaves;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "octaves";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return int.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: octaves = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "lacunarity";
            case 1: return "exponent";
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

      public MultifractalC_3() {
         addGroupMeta(this);
         octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public NoiseFractal evaluate(Context context, Object[] inputs) {
         LDouble lacunarity = (LDouble)inputs[0];
         LDouble exponent = (LDouble)inputs[1];
         exponent1 = exponent . val / 4 ;
         lacunarity1 = lacunarity . val ;
         return fractal ;
      }

      public Class getReturnType() {
         return NoiseFractal.class;
      }

   }

   public String getDescription() {
      return "Noise: Fractals";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new fBm1());
      r.add(new fBm2());
      r.add(new fBm3());
      r.add(new StatsByAlt1());
      r.add(new StatsByAlt2());
      r.add(new StatsByAlt3());
      r.add(new MultifractalA_1());
      r.add(new MultifractalA_2());
      r.add(new MultifractalA_3());
      r.add(new MultifractalB_1());
      r.add(new MultifractalB_2());
      r.add(new MultifractalB_3());
      r.add(new MultifractalC_1());
      r.add(new MultifractalC_2());
      r.add(new MultifractalC_3());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
