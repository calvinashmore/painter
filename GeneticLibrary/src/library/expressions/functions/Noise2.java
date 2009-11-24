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

public final class Noise2 implements AllComponents<ExpressionFunction>, Described {

   public static class PerlinParameters1 extends ExpressionFunction {
      private PerlinNoiseParameters params = new PerlinNoiseParameters ( ) ;
      private LVect3d scale;private LVect3d translate;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return scale;
            case 1: return translate;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "scale";
            case 1: return "translate";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: scale = (LVect3d) value; return;
            case 1: translate = (LVect3d) value; return;
            default: return;
         }

      }

      public PerlinParameters1() {
         addGroupMeta(this);
         translate = new LVect3d ( ) ;
         translate . x = Math . random ( ) * 100 - 50 ;
         translate . y = Math . random ( ) * 100 - 50 ;
         translate . z = Math . random ( ) * 100 - 50 ;
         scale = new LVect3d ( ) ;
         scale . x = 1 ;
         scale . y = 1 ;
         scale . z = 1 ;
      }

      public PerlinNoiseParameters evaluate(Context context, Object[] inputs) {

         params . scale = scale ;
         params . translate = translate ;
         return params ;
      }

      public Class getReturnType() {
         return PerlinNoiseParameters.class;
      }

   }

   public static class PerlinParameters1a extends ExpressionFunction {
      private PerlinNoiseParameters params = new PerlinNoiseParameters ( ) ;
      private double scale;private LVect3d translate;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return scale;
            case 1: return translate;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "scale";
            case 1: return "translate";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: scale = (Double) value; return;
            case 1: translate = (LVect3d) value; return;
            default: return;
         }

      }

      public PerlinParameters1a() {
         addGroupMeta(this);
         translate = new LVect3d ( ) ;
         translate . x = Math . random ( ) * 100 - 50 ;
         translate . y = Math . random ( ) * 100 - 50 ;
         translate . z = Math . random ( ) * 100 - 50 ;
         scale = 1 ;
      }

      public PerlinNoiseParameters evaluate(Context context, Object[] inputs) {

         params . scale = new LVect3d ( scale , scale , scale ) ;
         params . translate = translate ;
         return params ;
      }

      public Class getReturnType() {
         return PerlinNoiseParameters.class;
      }

   }

   public static class PerlinParameters2 extends ExpressionFunction {
      private PerlinNoiseParameters params = new PerlinNoiseParameters ( ) ;
      private LVect3d translate;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return translate;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "translate";
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
            case 0: translate = (LVect3d) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "scale";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public PerlinParameters2() {
         addGroupMeta(this);
         translate = new LVect3d ( ) ;
         translate . x = Math . random ( ) * 100 - 50 ;
         translate . y = Math . random ( ) * 100 - 50 ;
         translate . z = Math . random ( ) * 100 - 50 ;
      }

      public PerlinNoiseParameters evaluate(Context context, Object[] inputs) {
         final LVect3d scale = (LVect3d)inputs[0];
         params . scale = scale ;
         params . translate = translate ;
         return params ;
      }

      public Class getReturnType() {
         return PerlinNoiseParameters.class;
      }

   }

   public static class PerlinParameters2a extends ExpressionFunction {
      private PerlinNoiseParameters params = new PerlinNoiseParameters ( ) ;
      private LVect3d translate;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return translate;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "translate";
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
            case 0: translate = (LVect3d) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "scale";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public PerlinParameters2a() {
         addGroupMeta(this);
         translate = new LVect3d ( ) ;
         translate . x = Math . random ( ) * 100 - 50 ;
         translate . y = Math . random ( ) * 100 - 50 ;
         translate . z = Math . random ( ) * 100 - 50 ;
      }

      public PerlinNoiseParameters evaluate(Context context, Object[] inputs) {
         final LDouble scale = (LDouble)inputs[0];
         params . scale . x = scale . val ;
         params . scale . y = scale . val ;
         params . scale . z = scale . val ;
         params . translate = translate ;
         return params ;
      }

      public Class getReturnType() {
         return PerlinNoiseParameters.class;
      }

   }

   public static class PerlinParameters3 extends ExpressionFunction {
      private PerlinNoiseParameters params = new PerlinNoiseParameters ( ) ;
      private LVect3d scale;
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
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: scale = (LVect3d) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "translate";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public PerlinParameters3() {
         addGroupMeta(this);
         scale = new LVect3d ( ) ;
         scale . x = 1 ;
         scale . y = 1 ;
         scale . z = 1 ;
      }

      public PerlinNoiseParameters evaluate(Context context, Object[] inputs) {
         final LVect3d translate = (LVect3d)inputs[0];
         params . scale = scale ;
         params . translate = translate ;
         return params ;
      }

      public Class getReturnType() {
         return PerlinNoiseParameters.class;
      }

   }

   public static class PerlinParameters3a extends ExpressionFunction {
      private PerlinNoiseParameters params = new PerlinNoiseParameters ( ) ;
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
            case 0: return "translate";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public PerlinParameters3a() {
         addGroupMeta(this);
         scale = 1 ;
      }

      public PerlinNoiseParameters evaluate(Context context, Object[] inputs) {
         final LVect3d translate = (LVect3d)inputs[0];
         params . scale . x = scale ;
         params . scale . y = scale ;
         params . scale . z = scale ;
         params . translate = translate ;
         return params ;
      }

      public Class getReturnType() {
         return PerlinNoiseParameters.class;
      }

   }

   public static class PerlinParameters4 extends ExpressionFunction {
      private PerlinNoiseParameters params = new PerlinNoiseParameters ( ) ;
      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "scale";
            case 1: return "translate";
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

      public PerlinParameters4() {
         addGroupMeta(this);
      }

      public PerlinNoiseParameters evaluate(Context context, Object[] inputs) {
         final LVect3d scale = (LVect3d)inputs[0];
         final LVect3d translate = (LVect3d)inputs[1];
         params . scale = scale ;
         params . translate = translate ;
         return params ;
      }

      public Class getReturnType() {
         return PerlinNoiseParameters.class;
      }

   }

   public static class PerlinParameters4a extends ExpressionFunction {
      private PerlinNoiseParameters params = new PerlinNoiseParameters ( ) ;
      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "scale";
            case 1: return "translate";
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

      public PerlinParameters4a() {
         addGroupMeta(this);
      }

      public PerlinNoiseParameters evaluate(Context context, Object[] inputs) {
         final LDouble scale = (LDouble)inputs[0];
         final LVect3d translate = (LVect3d)inputs[1];
         params . scale . x = scale . val ;
         params . scale . y = scale . val ;
         params . scale . z = scale . val ;
         params . translate = translate ;
         return params ;
      }

      public Class getReturnType() {
         return PerlinNoiseParameters.class;
      }

   }

   public static class Perlin1 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "params";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return PerlinNoiseParameters.class;
            default: return null;
         }

      }

      public Perlin1() {
         addGroupMeta(this);
      }

      public NoiseFunction evaluate(Context context, Object[] inputs) {
         final PerlinNoiseParameters params = (PerlinNoiseParameters)inputs[0];
         return new PerlinNoise ( params ) ;
      }

      public Class getReturnType() {
         return NoiseFunction.class;
      }

   }

   public static class Perlin2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "params";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return PerlinNoiseParameters.class;
            default: return null;
         }

      }

      public Perlin2() {
         addGroupMeta(this);
      }

      public NoiseFunction evaluate(Context context, Object[] inputs) {
         final PerlinNoiseParameters params = (PerlinNoiseParameters)inputs[0];
         PerlinNoise noise = new PerlinNoise ( ) {
         public double fade ( double t ) {
         return t ;
         }
         }
         ;
         noise . setParameters ( params ) ;
         return noise ;
      }

      public Class getReturnType() {
         return NoiseFunction.class;
      }

   }

   public static class Perlin3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "params";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return PerlinNoiseParameters.class;
            default: return null;
         }

      }

      public Perlin3() {
         addGroupMeta(this);
      }

      public NoiseFunction evaluate(Context context, Object[] inputs) {
         final PerlinNoiseParameters params = (PerlinNoiseParameters)inputs[0];
         PerlinNoise noise = new PerlinNoise ( ) {
         public double fade ( double t ) {
         return Math . sqrt ( t ) ;
         }
         }
         ;
         noise . setParameters ( params ) ;
         return noise ;
      }

      public Class getReturnType() {
         return NoiseFunction.class;
      }

   }

   public static class Perlin4 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "params";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return PerlinNoiseParameters.class;
            default: return null;
         }

      }

      public Perlin4() {
         addGroupMeta(this);
      }

      public NoiseFunction evaluate(Context context, Object[] inputs) {
         final PerlinNoiseParameters params = (PerlinNoiseParameters)inputs[0];
         PerlinNoise noise = new PerlinNoise ( ) {
         public double fade ( double t ) {
         return t * t ;
         }
         }
         ;
         noise . setParameters ( params ) ;
         return noise ;
      }

      public Class getReturnType() {
         return NoiseFunction.class;
      }

   }

   public static class Perlin5 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "params";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return PerlinNoiseParameters.class;
            default: return null;
         }

      }

      public Perlin5() {
         addGroupMeta(this);
      }

      public NoiseFunction evaluate(Context context, Object[] inputs) {
         final PerlinNoiseParameters params = (PerlinNoiseParameters)inputs[0];
         PerlinNoise noise = new PerlinNoise ( ) {
         public double fade ( double x ) {
         double y = 2 * ( x - .5 ) ;
         return ( y * y * y - y ) / 2 + x ;
         }
         }
         ;
         noise . setParameters ( params ) ;
         return noise ;
      }

      public Class getReturnType() {
         return NoiseFunction.class;
      }

   }

   public static class Perlin6 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "params";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return PerlinNoiseParameters.class;
            default: return null;
         }

      }

      public Perlin6() {
         addGroupMeta(this);
      }

      public NoiseFunction evaluate(Context context, Object[] inputs) {
         final PerlinNoiseParameters params = (PerlinNoiseParameters)inputs[0];
         PerlinNoise noise = new PerlinNoise ( ) {
         public double fade ( double x ) {
         return Math . sin ( x * Math . PI / 2 ) ;
         }
         }
         ;
         noise . setParameters ( params ) ;
         return noise ;
      }

      public Class getReturnType() {
         return NoiseFunction.class;
      }

   }

   public String getDescription() {
      return "Noise: Perlin parameters";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new PerlinParameters1());
      r.add(new PerlinParameters1a());
      r.add(new PerlinParameters2());
      r.add(new PerlinParameters2a());
      r.add(new PerlinParameters3());
      r.add(new PerlinParameters3a());
      r.add(new PerlinParameters4());
      r.add(new PerlinParameters4a());
      r.add(new Perlin1());
      r.add(new Perlin2());
      r.add(new Perlin3());
      r.add(new Perlin4());
      r.add(new Perlin5());
      r.add(new Perlin6());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
