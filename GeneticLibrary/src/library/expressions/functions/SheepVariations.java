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
import utils.ifs.*;

public final class SheepVariations implements AllComponents<ExpressionFunction>, Described {

   public static class Sinusoidal extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { dest . setTo ( Math . sin ( v . x ) , Math . sin ( v . y ) ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Sinusoidal() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Spherical extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double invR2 = 1.0 / ( v . x * v . x + v . y * v . y ) ; dest . setTo ( invR2 * v . x , invR2 * v . y ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Spherical() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Swirl extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double r2 = v . x * v . x + v . y * v . y ; double sr2 = Math . sin ( r2 ) ; double cr2 = Math . cos ( r2 ) ; dest . setTo ( v . x * sr2 - v . y * cr2 , v . x * cr2 + v . y * sr2 ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Swirl() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Horseshoe extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double invR = 1.0 / v . magnitude ( ) ; dest . setTo ( invR * ( v . x - v . y ) * ( v . x + v . y ) , invR * 2 * v . x * v . y ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Horseshoe() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Polar extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double r = v . magnitude ( ) ; double theta = Math . atan2 ( v . y , v . x ) ; dest . setTo ( theta / Math . PI , r - 1 ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Polar() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Handkerchief extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double r = v . magnitude ( ) ; double theta = Math . atan2 ( v . y , v . x ) ; dest . setTo ( r * Math . sin ( theta + r ) , r * Math . cos ( theta - r ) ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Handkerchief() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Heart extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double r = v . magnitude ( ) ; double theta = Math . atan2 ( v . y , v . x ) ; dest . setTo ( r * Math . sin ( theta * r ) , - r * Math . cos ( theta * r ) ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Heart() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Disc extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double r = v . magnitude ( ) ; double theta = Math . atan2 ( v . y , v . x ) / Math . PI ; dest . setTo ( theta * Math . sin ( Math . PI * r ) , theta * Math . cos ( Math . PI * r ) ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Disc() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Spiral extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double r = v . magnitude ( ) ; double invR = 1.0 / r ; double theta = Math . atan2 ( v . y , v . x ) ; dest . setTo ( invR * ( Math . cos ( theta ) + Math . sin ( r ) ) , invR * ( Math . sin ( theta ) - Math . cos ( r ) ) ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Spiral() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Hyperbolic extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double r = v . magnitude ( ) ; double theta = Math . atan2 ( v . y , v . x ) ; dest . setTo ( Math . sin ( theta ) / r , r * Math . cos ( theta ) ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Hyperbolic() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Diamond extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double r = v . magnitude ( ) ; double theta = Math . atan2 ( v . y , v . x ) ; dest . setTo ( Math . sin ( theta ) * Math . cos ( r ) , Math . cos ( theta ) * Math . sin ( r ) ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Diamond() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Ex extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double r = v . magnitude ( ) ; double theta = Math . atan2 ( v . y , v . x ) ; double p0 = Math . pow ( Math . sin ( theta + r ) , 3 ) ; double p1 = Math . pow ( Math . cos ( theta - r ) , 3 ) ; dest . setTo ( r * ( p0 + p1 ) , r * ( p0 - p1 ) ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Ex() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Julia extends ExpressionFunction implements Mapping < LVect2d > {
      private Random random ;public LVect2d map ( LVect2d v , LVect2d dest ) { double rRoot = Math . sqrt ( v . magnitude ( ) ) ; double theta = Math . atan2 ( v . y , v . x ) ; double omega = random . nextBoolean ( ) ? 0 : Math . PI ; dest . setTo ( rRoot * Math . cos ( theta / 2 + omega ) , rRoot * Math . sin ( theta / 2 + omega ) ) ; return dest ; }
      private Integer seed;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return seed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "seed";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: seed = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         random = new Random ( seed ) ;
      }

      public Julia() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Bent extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { if ( v . x >= 0 ) { if ( v . y >= 0 ) { dest . setTo ( v ) ; } else { dest . setTo ( v . x , v . y * .5 ) ; } } else { if ( v . y >= 0 ) { dest . setTo ( v . x * 2 , v . y ) ; } else { dest . setTo ( v . x * 2 , v . y * .5 ) ; } } return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Bent() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Waves extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { dest . setTo ( v . x + b . val * Math . sin ( v . y * c . val ) , v . y + e . val * Math . sin ( v . x * f . val ) ) ; return dest ; }
      private LDouble b;private LDouble c;private LDouble e;private LDouble f;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return b;
            case 1: return c;
            case 2: return e;
            case 3: return f;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "b";
            case 1: return "c";
            case 2: return "e";
            case 3: return "f";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: b = (LDouble) value; return;
            case 1: c = (LDouble) value; return;
            case 2: e = (LDouble) value; return;
            case 3: f = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Waves() {
         addGroupMeta(this);
         b = new LDouble ( 2 * Math . random ( ) - 1 ) ;
         e = new LDouble ( 2 * Math . random ( ) - 1 ) ;
         c = new LDouble ( Math . pow ( 2 * Math . random ( ) - 1 , - 2 ) ) ;
         f = new LDouble ( Math . pow ( 2 * Math . random ( ) - 1 , - 2 ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Fisheye extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double r = v . magnitude ( ) ; double scale = 2.0 / ( r + 1 ) ; dest . setTo ( scale * v . y , scale * v . x ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Fisheye() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Popcorn extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { dest . setTo ( v . x + c . val * Math . sin ( Math . tan ( 3 * v . y ) ) , v . y + f . val * Math . sin ( Math . tan ( 3 * v . x ) ) ) ; return dest ; }
      private LDouble c;private LDouble f;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return c;
            case 1: return f;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "c";
            case 1: return "f";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: c = (LDouble) value; return;
            case 1: f = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Popcorn() {
         addGroupMeta(this);
         c = new LDouble ( 2 * Math . random ( ) - 1 ) ;
         f = new LDouble ( 2 * Math . random ( ) - 1 ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Exponential extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double scale = Math . exp ( v . x - 1 ) ; dest . setTo ( scale * Math . cos ( Math . PI * v . y ) , scale * Math . sin ( Math . PI * v . y ) ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Exponential() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Power extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double r = v . magnitude ( ) ; double theta = Math . atan2 ( v . y , v . x ) ; double scale = r * Math . sin ( theta ) ; dest . setTo ( scale * Math . cos ( theta ) , scale * Math . sin ( theta ) ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Power() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Cosine extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { dest . setTo ( Math . cos ( Math . PI * v . x ) * Math . cosh ( v . y ) , - Math . sin ( Math . PI * v . x ) * Math . sinh ( v . y ) ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Cosine() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Rings extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double r = v . magnitude ( ) ; double scale = ( ( r + c . val ) % ( 2 * c . val ) ) - c . val + r * ( 1 - c . val ) ; double theta = Math . atan2 ( v . y , v . x ) ; dest . setTo ( scale * Math . cos ( theta ) , scale * Math . sin ( theta ) ) ; return dest ; }
      private LDouble c;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return c;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "c";
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
            case 0: c = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Rings() {
         addGroupMeta(this);
         c = new LDouble ( Math . pow ( Math . random ( ) , 2 ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Fan extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double r = v . magnitude ( ) ; double theta = Math . atan2 ( v . y , v . x ) ; if ( ( theta + f . val ) % t . val > t . val / 2 ) { double thetaMinus = theta - t . val / 2 ; dest . setTo ( r * Math . cos ( thetaMinus ) , r * Math . sin ( thetaMinus ) ) ; } else { double thetaPlus = theta + t . val / 2 ; dest . setTo ( r * Math . cos ( thetaPlus ) , r * Math . sin ( thetaPlus ) ) ; } return dest ; }
      private LDouble t;private LDouble f;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return t;
            case 1: return f;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "t";
            case 1: return "f";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: t = (LDouble) value; return;
            case 1: f = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Fan() {
         addGroupMeta(this);
         t = new LDouble ( Math . PI * Math . pow ( Math . random ( ) , 2 ) ) ;
         f = new LDouble ( 2 * Math . random ( ) - 1 ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Blob extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double r = v . magnitude ( ) ; double theta = Math . atan2 ( v . y , v . x ) ; double scale = r * ( p2 . val + .5 * ( p1 . val + p2 . val ) * ( Math . sin ( p3 * theta ) + 1 ) ) ; dest . setTo ( scale * Math . cos ( theta ) , scale * Math . sin ( theta ) ) ; return dest ; }
      private LDouble p1;private LDouble p2;private Integer p3;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return p1;
            case 1: return p2;
            case 2: return p3;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "p1";
            case 1: return "p2";
            case 2: return "p3";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: p1 = (LDouble) value; return;
            case 1: p2 = (LDouble) value; return;
            case 2: p3 = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Blob() {
         addGroupMeta(this);
         p1 = new LDouble ( .5 * Math . random ( ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
         p3 = ( int ) ( 3 + 5 * Math . random ( ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class PDJ extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { dest . setTo ( Math . sin ( p1 . val * v . y ) - Math . cos ( p2 . val * v . x ) , Math . sin ( p3 . val * v . x ) - Math . cos ( p4 . val * v . y ) ) ; return dest ; }
      private LDouble p1;private LDouble p2;private LDouble p3;private LDouble p4;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return p1;
            case 1: return p2;
            case 2: return p3;
            case 3: return p4;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "p1";
            case 1: return "p2";
            case 2: return "p3";
            case 3: return "p4";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: p1 = (LDouble) value; return;
            case 1: p2 = (LDouble) value; return;
            case 2: p3 = (LDouble) value; return;
            case 3: p4 = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public PDJ() {
         addGroupMeta(this);
         p1 = new LDouble ( Math . random ( ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
         p3 = new LDouble ( Math . random ( ) ) ;
         p4 = new LDouble ( Math . random ( ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Fan2 extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double r = v . magnitude ( ) ; double theta = Math . atan2 ( v . y , v . x ) ; double trunc = Math . floor ( 2 * theta * p2 . val / p1 . val ) ; double t = theta + p2 . val - p1 . val * trunc ; if ( t > p1 . val / 2 ) { dest . setTo ( r * Math . sin ( theta - p1 . val / 2 ) , r * Math . cos ( theta - p1 . val / 2 ) ) ; } else { dest . setTo ( r * Math . sin ( theta + p1 . val / 2 ) , r * Math . cos ( theta + p1 . val / 2 ) ) ; } return dest ; }
      private LDouble p1;private LDouble p2;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return p1;
            case 1: return p2;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "p1";
            case 1: return "p2";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: p1 = (LDouble) value; return;
            case 1: p2 = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Fan2() {
         addGroupMeta(this);
         p1 = new LDouble ( Math . PI * Math . pow ( Math . random ( ) , 2 ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Rings2 extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double r = v . magnitude ( ) ; double theta = Math . atan2 ( v . y , v . x ) ; double trunc = Math . floor ( ( r + p . val ) / ( 2 * p . val ) ) ; double t = r - 2 * p . val * trunc + r * ( 1 - p . val ) ; dest . setTo ( t * Math . sin ( theta ) , t * Math . cos ( theta ) ) ; return dest ; }
      private LDouble p;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return p;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "p";
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
            case 0: p = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Rings2() {
         addGroupMeta(this);
         p = new LDouble ( Math . pow ( Math . random ( ) , 2 ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Eyefish extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double r = v . magnitude ( ) ; double scale = 2.0 / ( r + 1 ) ; dest . setTo ( scale * v . x , scale * v . y ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Eyefish() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Bubble extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double r = v . magnitude ( ) ; double scale = 4.0 / ( r * r + 4 ) ; dest . setTo ( scale * v . x , scale * v . y ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Bubble() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Cylinder extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { dest . setTo ( Math . sin ( v . x ) , v . y ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Cylinder() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Perspective extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double scale = p2 . val / ( p2 . val - v . y * Math . sin ( p1 . val ) ) ; dest . setTo ( v . x , v . y * Math . cos ( p1 . val ) ) ; return dest ; }
      private LDouble p1;private LDouble p2;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return p1;
            case 1: return p2;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "p1";
            case 1: return "p2";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: p1 = (LDouble) value; return;
            case 1: p2 = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Perspective() {
         addGroupMeta(this);
         p1 = new LDouble ( Math . random ( ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Noise extends ExpressionFunction implements Mapping < LVect2d > {
      private Random random ;public LVect2d map ( LVect2d v , LVect2d dest ) { double psi1 = random . nextDouble ( ) ; double psi2 = random . nextDouble ( ) ; dest . setTo ( psi1 * v . x * Math . cos ( 2 * Math . PI * psi2 ) , psi1 * v . y * Math . sin ( 2 * Math . PI * psi2 ) ) ; return dest ; }
      private Integer seed;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return seed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "seed";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: seed = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         random = new Random ( seed ) ;
      }

      public Noise() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class JuliaN extends ExpressionFunction implements Mapping < LVect2d > {
      private Random random ;public LVect2d map ( LVect2d v , LVect2d dest ) { double psi = random . nextDouble ( ) ; double phi = Math . atan2 ( v . x , v . y ) ; double r = v . magnitude ( ) ; double p3 = Math . floor ( Math . abs ( p1 . val ) * psi ) ; double t = ( phi + 2 * Math . PI * p3 ) / p1 . val ; double scale = Math . pow ( r , p2 . val / p1 . val ) ; dest . setTo ( scale * Math . cos ( t ) , scale * Math . sin ( t ) ) ; return dest ; }
      private LDouble p1;private LDouble p2;private Integer seed;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return p1;
            case 1: return p2;
            case 2: return seed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "p1";
            case 1: return "p2";
            case 2: return "seed";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: p1 = (LDouble) value; return;
            case 1: p2 = (LDouble) value; return;
            case 2: seed = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         random = new Random ( seed ) ;
      }

      public JuliaN() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
         p1 = new LDouble ( 3 + 5 * Math . random ( ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class JuliaScope extends ExpressionFunction implements Mapping < LVect2d > {
      private Random random ;public LVect2d map ( LVect2d v , LVect2d dest ) { double psi = random . nextDouble ( ) ; double phi = Math . atan2 ( v . x , v . y ) ; double r = v . magnitude ( ) ; double p3 = Math . floor ( Math . abs ( p1 . val ) * psi ) ; double lambda = random . nextBoolean ( ) ? 1 : 0 ; double t = ( phi * lambda + 2 * Math . PI * p3 ) / p1 . val ; double scale = Math . pow ( r , p2 . val / p1 . val ) ; dest . setTo ( scale * Math . cos ( t ) , scale * Math . sin ( t ) ) ; return dest ; }
      private LDouble p1;private LDouble p2;private Integer seed;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return p1;
            case 1: return p2;
            case 2: return seed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "p1";
            case 1: return "p2";
            case 2: return "seed";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: p1 = (LDouble) value; return;
            case 1: p2 = (LDouble) value; return;
            case 2: seed = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         random = new Random ( seed ) ;
      }

      public JuliaScope() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
         p1 = new LDouble ( 3 + 5 * Math . random ( ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Blur extends ExpressionFunction implements Mapping < LVect2d > {
      private Random random ;public LVect2d map ( LVect2d v , LVect2d dest ) { double psi1 = random . nextDouble ( ) ; double psi2 = random . nextDouble ( ) ; dest . setTo ( psi1 * Math . cos ( 2 * Math . PI * psi2 ) , psi1 * Math . sin ( 2 * Math . PI * psi2 ) ) ; return dest ; }
      private Integer seed;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return seed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "seed";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: seed = (Integer) value; return;
            default: return;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         random = new Random ( seed ) ;
      }

      public Blur() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {

         return map ( null , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Gaussian extends ExpressionFunction implements Mapping < LVect2d > {
      private Random random ;public LVect2d map ( LVect2d v , LVect2d dest ) { double scale = - 2 ; for ( int i = 0 ; i < 4 ; i ++ ) { scale += random . nextDouble ( ) ; } double psi = random . nextDouble ( ) ; dest . setTo ( scale * Math . cos ( 2 * Math . PI * psi ) , scale * Math . sin ( 2 * Math . PI * psi ) ) ; return dest ; }
      private Integer seed;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return seed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "seed";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: seed = (Integer) value; return;
            default: return;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         random = new Random ( seed ) ;
      }

      public Gaussian() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {

         return map ( null , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class RadialBlur extends ExpressionFunction implements Mapping < LVect2d > {
      private Random random ;public LVect2d map ( LVect2d v , LVect2d dest ) { double t1 = - 2 ; for ( int i = 0 ; i < 4 ; i ++ ) t1 += random . nextDouble ( ) ; double phi = Math . atan2 ( v . x , v . y ) ; double t2 = phi + t1 * Math . sin ( p1 . val ) ; double t3 = t1 * Math . cos ( p1 . val ) - 1 ; double r = v . magnitude ( ) ; dest . setTo ( r * Math . cos ( t2 ) + t3 * v . x , r * Math . sin ( t2 ) + t3 * v . y ) ; return dest ; }
      private Integer seed;private LDouble p1;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return seed;
            case 1: return p1;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "seed";
            case 1: return "p1";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: seed = (Integer) value; return;
            case 1: p1 = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         random = new Random ( seed ) ;
      }

      public RadialBlur() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
         p1 = new LDouble ( Math . random ( ) * Math . PI / 2 ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Pie extends ExpressionFunction implements Mapping < LVect2d > {
      private Random random ;public LVect2d map ( LVect2d v , LVect2d dest ) { double t1 = Math . floor ( random . nextDouble ( ) * p1 . val + .5 ) ; double t2 = p2 . val + ( 2 * Math . PI / p1 . val ) * ( t1 + random . nextDouble ( ) * p3 . val ) ; double r = random . nextDouble ( ) ; dest . setTo ( r * Math . cos ( t2 ) , r * Math . sin ( t2 ) ) ; return dest ; }
      private Integer seed;private LDouble p1;private LDouble p2;private LDouble p3;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return seed;
            case 1: return p1;
            case 2: return p2;
            case 3: return p3;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "seed";
            case 1: return "p1";
            case 2: return "p2";
            case 3: return "p3";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: seed = (Integer) value; return;
            case 1: p1 = (LDouble) value; return;
            case 2: p2 = (LDouble) value; return;
            case 3: p3 = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         random = new Random ( seed ) ;
      }

      public Pie() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
         p1 = new LDouble ( 3 + 5 * Math . random ( ) ) ;
         p2 = new LDouble ( Math . PI * Math . random ( ) ) ;
         p3 = new LDouble ( Math . random ( ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Ngon extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double phi = Math . atan2 ( v . x , v . y ) ; double r = v . magnitude ( ) ; double t3 = phi - p2 . val * Math . floor ( phi / p2 . val ) ; double t4 = t3 > p2 . val / 2 ? t3 : t3 - p2 . val ; double k = ( p3 . val * ( 1.0 / Math . cos ( t4 ) - 1 ) + p4 . val ) / Math . pow ( r , p1 . val ) ; dest . setTo ( k * v . x , k * v . y ) ; return dest ; }
      private LDouble p1;private LDouble p2;private LDouble p3;private LDouble p4;
      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return p1;
            case 1: return p2;
            case 2: return p3;
            case 3: return p4;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "p1";
            case 1: return "p2";
            case 2: return "p3";
            case 3: return "p4";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: p1 = (LDouble) value; return;
            case 1: p2 = (LDouble) value; return;
            case 2: p3 = (LDouble) value; return;
            case 3: p4 = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Ngon() {
         addGroupMeta(this);
         p1 = new LDouble ( 1 + 4 * Math . random ( ) ) ;
         p2 = new LDouble ( 2 * Math . PI / ( 3 + 5 * Math . random ( ) ) ) ;
         p3 = new LDouble ( Math . random ( ) ) ;
         p4 = new LDouble ( Math . random ( ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Curl extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double t1 = 1 + p1 . val * v . x + p2 . val * ( v . x * v . x + v . y * v . y ) ; double t2 = p1 . val * v . y + 2 * p2 . val * v . x * v . y ; double scale = 1.0 / ( t1 * t1 + t2 * t2 ) ; dest . setTo ( scale * ( v . x * t1 + v . y * t2 ) , scale * ( v . y * t1 - v . x * t2 ) ) ; return dest ; }
      private LDouble p1;private LDouble p2;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return p1;
            case 1: return p2;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "p1";
            case 1: return "p2";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: p1 = (LDouble) value; return;
            case 1: p2 = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Curl() {
         addGroupMeta(this);
         p1 = new LDouble ( Math . random ( ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Rectangles extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { dest . setTo ( ( 2 * Math . floor ( v . x / p1 . val ) + 1 ) * p1 . val - v . x , ( 2 * Math . floor ( v . y / p2 . val ) + 1 ) * p2 . val - v . y ) ; return dest ; }
      private LDouble p1;private LDouble p2;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return p1;
            case 1: return p2;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "p1";
            case 1: return "p2";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: p1 = (LDouble) value; return;
            case 1: p2 = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Rectangles() {
         addGroupMeta(this);
         p1 = new LDouble ( Math . random ( ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Arch extends ExpressionFunction implements Mapping < LVect2d > {
      private Random random ;public LVect2d map ( LVect2d v , LVect2d dest ) { double psi = Math . PI * random . nextDouble ( ) ; dest . setTo ( Math . sin ( psi ) , Math . pow ( Math . sin ( psi ) , 2 ) / Math . cos ( psi ) ) ; return dest ; }
      private Integer seed;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return seed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "seed";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: seed = (Integer) value; return;
            default: return;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         random = new Random ( seed ) ;
      }

      public Arch() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {

         return map ( null , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Tangent extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { dest . setTo ( Math . sin ( v . x ) / Math . cos ( v . y ) , Math . tan ( v . y ) ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Tangent() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Square extends ExpressionFunction implements Mapping < LVect2d > {
      private Random random ;public LVect2d map ( LVect2d v , LVect2d dest ) { double psi1 = random . nextDouble ( ) ; double psi2 = random . nextDouble ( ) ; dest . setTo ( psi1 - .5 , psi2 - .5 ) ; return dest ; }
      private Integer seed;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return seed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "seed";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: seed = (Integer) value; return;
            default: return;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         random = new Random ( seed ) ;
      }

      public Square() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {

         return map ( null , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Rays extends ExpressionFunction implements Mapping < LVect2d > {
      private Random random ;public LVect2d map ( LVect2d v , LVect2d dest ) { double psi = Math . PI * random . nextDouble ( ) ; double scale = Math . tan ( psi ) / ( v . x * v . x + v . y * v . y ) ; dest . setTo ( scale * Math . cos ( v . x ) , scale * Math . sin ( v . y ) ) ; return dest ; }
      private Integer seed;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return seed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "seed";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: seed = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         random = new Random ( seed ) ;
      }

      public Rays() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Blade extends ExpressionFunction implements Mapping < LVect2d > {
      private Random random ;public LVect2d map ( LVect2d v , LVect2d dest ) { double psi = random . nextDouble ( ) ; double rpsi = psi * v . magnitude ( ) ; dest . setTo ( v . x * ( Math . cos ( rpsi ) + Math . sin ( rpsi ) ) , Math . cos ( rpsi ) - Math . sin ( rpsi ) ) ; return dest ; }
      private Integer seed;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return seed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "seed";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: seed = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         random = new Random ( seed ) ;
      }

      public Blade() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Secant extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double r = v . magnitude ( ) ; dest . setTo ( v . x , 1.0 / Math . cos ( r ) ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Secant() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Twintrain extends ExpressionFunction implements Mapping < LVect2d > {
      private Random random ;public LVect2d map ( LVect2d v , LVect2d dest ) { double psi = random . nextDouble ( ) ; double rpsi = psi * v . magnitude ( ) ; double t = 2 * Math . log ( Math . abs ( Math . sin ( rpsi ) ) ) + Math . cos ( rpsi ) ; dest . setTo ( v . x * t , v . x * ( t - Math . PI * Math . sin ( rpsi ) ) ) ; return dest ; }
      private Integer seed;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return seed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "seed";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: seed = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         random = new Random ( seed ) ;
      }

      public Twintrain() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Cross extends ExpressionFunction implements Mapping < LVect2d > {
      public LVect2d map ( LVect2d v , LVect2d dest ) { double scale = 1.0 / Math . abs ( v . x * v . x - v . y * v . y ) ; dest . setTo ( scale * v . x , scale * v . y ) ; return dest ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Cross() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public String getDescription() {
      return "V2->V2 Variations identified from Scott Draves' paper describing the Fractal Flame algorithm";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new Sinusoidal());
      r.add(new Spherical());
      r.add(new Swirl());
      r.add(new Horseshoe());
      r.add(new Polar());
      r.add(new Handkerchief());
      r.add(new Heart());
      r.add(new Disc());
      r.add(new Spiral());
      r.add(new Hyperbolic());
      r.add(new Diamond());
      r.add(new Ex());
      r.add(new Julia());
      r.add(new Bent());
      r.add(new Waves());
      r.add(new Fisheye());
      r.add(new Popcorn());
      r.add(new Exponential());
      r.add(new Power());
      r.add(new Cosine());
      r.add(new Rings());
      r.add(new Fan());
      r.add(new Blob());
      r.add(new PDJ());
      r.add(new Fan2());
      r.add(new Rings2());
      r.add(new Eyefish());
      r.add(new Bubble());
      r.add(new Cylinder());
      r.add(new Perspective());
      r.add(new Noise());
      r.add(new JuliaN());
      r.add(new JuliaScope());
      r.add(new Blur());
      r.add(new Gaussian());
      r.add(new RadialBlur());
      r.add(new Pie());
      r.add(new Ngon());
      r.add(new Curl());
      r.add(new Rectangles());
      r.add(new Arch());
      r.add(new Tangent());
      r.add(new Square());
      r.add(new Rays());
      r.add(new Blade());
      r.add(new Secant());
      r.add(new Twintrain());
      r.add(new Cross());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
