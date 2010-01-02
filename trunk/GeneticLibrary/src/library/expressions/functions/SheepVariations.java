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
import utils.ifs.sheepvariations.*;

public final class SheepVariations implements AllComponents<ExpressionFunction>, Described {

   public static class Sinusoidal_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Sinusoidal ( ) ;
      }

      public Sinusoidal_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Sinusoidal_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Sinusoidal ( ) ;
      }

      public Sinusoidal_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Spherical_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Spherical ( ) ;
      }

      public Spherical_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Spherical_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Spherical ( ) ;
      }

      public Spherical_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Swirl_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Swirl ( ) ;
      }

      public Swirl_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Swirl_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Swirl ( ) ;
      }

      public Swirl_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Horseshoe_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Horseshoe ( ) ;
      }

      public Horseshoe_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Horseshoe_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Horseshoe ( ) ;
      }

      public Horseshoe_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Polar_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Polar ( ) ;
      }

      public Polar_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Polar_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Polar ( ) ;
      }

      public Polar_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Handkerchief_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Handkerchief ( ) ;
      }

      public Handkerchief_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Handkerchief_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Handkerchief ( ) ;
      }

      public Handkerchief_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Heart_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Heart ( ) ;
      }

      public Heart_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Heart_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Heart ( ) ;
      }

      public Heart_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Disc_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Heart ( ) ;
      }

      public Disc_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Disc_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Disc ( ) ;
      }

      public Disc_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Spiral_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Spiral ( ) ;
      }

      public Spiral_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Spiral_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Spiral ( ) ;
      }

      public Spiral_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Hyperbolic_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Hyperbolic ( ) ;
      }

      public Hyperbolic_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Hyperbolic_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Hyperbolic ( ) ;
      }

      public Hyperbolic_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Diamond_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Diamond ( ) ;
      }

      public Diamond_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Diamond_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Diamond ( ) ;
      }

      public Diamond_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Ex_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Ex ( ) ;
      }

      public Ex_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Ex_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Ex ( ) ;
      }

      public Ex_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Julia_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Julia ( new Random ( seed ) ) ;
      }

      public Julia_f() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Julia_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Julia ( new Random ( seed ) ) ;
      }

      public Julia_v() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Bent_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Bent ( ) ;
      }

      public Bent_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Bent_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Bent ( ) ;
      }

      public Bent_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Waves_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Waves ( b . val , c . val , e . val , f . val ) ;
      }

      public Waves_f() {
         addGroupMeta(this);
         b = new LDouble ( 2 * Math . random ( ) - 1 ) ;
         e = new LDouble ( 2 * Math . random ( ) - 1 ) ;
         c = new LDouble ( Math . pow ( 2 * Math . random ( ) - 1 , - 2 ) ) ;
         f = new LDouble ( Math . pow ( 2 * Math . random ( ) - 1 , - 2 ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Waves_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Waves ( b . val , c . val , e . val , f . val ) ;
      }

      public Waves_v() {
         addGroupMeta(this);
         b = new LDouble ( 2 * Math . random ( ) - 1 ) ;
         e = new LDouble ( 2 * Math . random ( ) - 1 ) ;
         c = new LDouble ( Math . pow ( 2 * Math . random ( ) - 1 , - 2 ) ) ;
         f = new LDouble ( Math . pow ( 2 * Math . random ( ) - 1 , - 2 ) ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Fisheye_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Fisheye ( ) ;
      }

      public Fisheye_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Fisheye_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Fisheye ( ) ;
      }

      public Fisheye_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Popcorn_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Popcorn ( c . val , f . val ) ;
      }

      public Popcorn_f() {
         addGroupMeta(this);
         c = new LDouble ( 2 * Math . random ( ) - 1 ) ;
         f = new LDouble ( 2 * Math . random ( ) - 1 ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Popcorn_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Popcorn ( c . val , f . val ) ;
      }

      public Popcorn_v() {
         addGroupMeta(this);
         c = new LDouble ( 2 * Math . random ( ) - 1 ) ;
         f = new LDouble ( 2 * Math . random ( ) - 1 ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Exponential_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Exponential ( ) ;
      }

      public Exponential_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Exponential_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Exponential ( ) ;
      }

      public Exponential_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Power_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Power ( ) ;
      }

      public Power_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Power_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Power ( ) ;
      }

      public Power_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Cosine_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Cosine ( ) ;
      }

      public Cosine_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Cosine_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Cosine ( ) ;
      }

      public Cosine_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Rings_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Rings ( c . val ) ;
      }

      public Rings_f() {
         addGroupMeta(this);
         c = new LDouble ( Math . pow ( Math . random ( ) , 2 ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Rings_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Rings ( c . val ) ;
      }

      public Rings_v() {
         addGroupMeta(this);
         c = new LDouble ( Math . pow ( Math . random ( ) , 2 ) ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Fan_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Fan ( t . val , f . val ) ;
      }

      public Fan_f() {
         addGroupMeta(this);
         t = new LDouble ( Math . PI * Math . pow ( Math . random ( ) , 2 ) ) ;
         f = new LDouble ( 2 * Math . random ( ) - 1 ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Fan_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Fan ( t . val , f . val ) ;
      }

      public Fan_v() {
         addGroupMeta(this);
         t = new LDouble ( Math . PI * Math . pow ( Math . random ( ) , 2 ) ) ;
         f = new LDouble ( 2 * Math . random ( ) - 1 ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Blob_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Blob ( p1 . val , p2 . val , p3 ) ;
      }

      public Blob_f() {
         addGroupMeta(this);
         p1 = new LDouble ( .5 * Math . random ( ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
         p3 = ( int ) ( 3 + 5 * Math . random ( ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Blob_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Blob ( p1 . val , p2 . val , p3 ) ;
      }

      public Blob_v() {
         addGroupMeta(this);
         p1 = new LDouble ( .5 * Math . random ( ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
         p3 = ( int ) ( 3 + 5 * Math . random ( ) ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class PDJ_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new PDJ ( p1 . val , p2 . val , p3 . val , p4 . val ) ;
      }

      public PDJ_f() {
         addGroupMeta(this);
         p1 = new LDouble ( Math . random ( ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
         p3 = new LDouble ( Math . random ( ) ) ;
         p4 = new LDouble ( Math . random ( ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class PDJ_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new PDJ ( p1 . val , p2 . val , p3 . val , p4 . val ) ;
      }

      public PDJ_v() {
         addGroupMeta(this);
         p1 = new LDouble ( Math . random ( ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
         p3 = new LDouble ( Math . random ( ) ) ;
         p4 = new LDouble ( Math . random ( ) ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Fan2_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Fan2 ( p1 . val , p2 . val ) ;
      }

      public Fan2_f() {
         addGroupMeta(this);
         p1 = new LDouble ( Math . PI * Math . pow ( Math . random ( ) , 2 ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Fan2_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Fan2 ( p1 . val , p2 . val ) ;
      }

      public Fan2_v() {
         addGroupMeta(this);
         p1 = new LDouble ( Math . PI * Math . pow ( Math . random ( ) , 2 ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Rings2_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Rings2 ( p . val ) ;
      }

      public Rings2_f() {
         addGroupMeta(this);
         p = new LDouble ( Math . pow ( Math . random ( ) , 2 ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Rings2_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Rings2 ( p . val ) ;
      }

      public Rings2_v() {
         addGroupMeta(this);
         p = new LDouble ( Math . pow ( Math . random ( ) , 2 ) ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Eyefish_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Eyefish ( ) ;
      }

      public Eyefish_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Eyefish_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Eyefish ( ) ;
      }

      public Eyefish_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Bubble_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Bubble ( ) ;
      }

      public Bubble_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Bubble_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Bubble ( ) ;
      }

      public Bubble_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Cylinder_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Cylinder ( ) ;
      }

      public Cylinder_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Cylinder_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Cylinder ( ) ;
      }

      public Cylinder_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Perspective_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Perspective ( p1 . val , p2 . val ) ;
      }

      public Perspective_f() {
         addGroupMeta(this);
         p1 = new LDouble ( Math . random ( ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Perspective_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Perspective ( p1 . val , p2 . val ) ;
      }

      public Perspective_v() {
         addGroupMeta(this);
         p1 = new LDouble ( Math . random ( ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Noise_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Noise ( new Random ( seed ) ) ;
      }

      public Noise_f() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Noise_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Noise ( new Random ( seed ) ) ;
      }

      public Noise_v() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class JuliaN_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new JuliaN ( new Random ( seed ) , p1 . val , p2 . val ) ;
      }

      public JuliaN_f() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
         p1 = new LDouble ( 3 + 5 * Math . random ( ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class JuliaN_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new JuliaN ( new Random ( seed ) , p1 . val , p2 . val ) ;
      }

      public JuliaN_v() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
         p1 = new LDouble ( 3 + 5 * Math . random ( ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class JuliaScope_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new JuliaScope ( new Random ( seed ) , p1 . val , p2 . val ) ;
      }

      public JuliaScope_f() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
         p1 = new LDouble ( 3 + 5 * Math . random ( ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class JuliaScope_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new JuliaScope ( new Random ( seed ) , p1 . val , p2 . val ) ;
      }

      public JuliaScope_v() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
         p1 = new LDouble ( 3 + 5 * Math . random ( ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Blur_f extends ExpressionFunction {
      private Random random ;private IFSUtil . Mapping_v2 function ;
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
         function = new Blur ( new Random ( seed ) ) ;
      }

      public Blur_f() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {

         return function . map ( null , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Blur_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Blur ( new Random ( seed ) ) ;
      }

      public Blur_v() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Gaussian_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Gaussian ( new Random ( seed ) ) ;
      }

      public Gaussian_f() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {

         return function . map ( null , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Gaussian_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Gaussian ( new Random ( seed ) ) ;
      }

      public Gaussian_v() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class RadialBlur_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new RadialBlur ( new Random ( seed ) , p1 . val ) ;
      }

      public RadialBlur_f() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
         p1 = new LDouble ( Math . random ( ) * Math . PI / 2 ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class RadialBlur_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new RadialBlur ( new Random ( seed ) , p1 . val ) ;
      }

      public RadialBlur_v() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
         p1 = new LDouble ( Math . random ( ) * Math . PI / 2 ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Pie_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Pie ( new Random ( seed ) , p1 . val , p2 . val , p3 . val ) ;
      }

      public Pie_f() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
         p1 = new LDouble ( 3 + 5 * Math . random ( ) ) ;
         p2 = new LDouble ( Math . PI * Math . random ( ) ) ;
         p3 = new LDouble ( Math . random ( ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Pie_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Pie ( new Random ( seed ) , p1 . val , p2 . val , p3 . val ) ;
      }

      public Pie_v() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
         p1 = new LDouble ( 3 + 5 * Math . random ( ) ) ;
         p2 = new LDouble ( Math . PI * Math . random ( ) ) ;
         p3 = new LDouble ( Math . random ( ) ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Ngon_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Ngon ( p1 . val , p2 . val , p3 . val , p4 . val ) ;
      }

      public Ngon_f() {
         addGroupMeta(this);
         p1 = new LDouble ( 1 + 4 * Math . random ( ) ) ;
         p2 = new LDouble ( 2 * Math . PI / ( 3 + 5 * Math . random ( ) ) ) ;
         p3 = new LDouble ( Math . random ( ) ) ;
         p4 = new LDouble ( Math . random ( ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Ngon_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Ngon ( p1 . val , p2 . val , p3 . val , p4 . val ) ;
      }

      public Ngon_v() {
         addGroupMeta(this);
         p1 = new LDouble ( 1 + 4 * Math . random ( ) ) ;
         p2 = new LDouble ( 2 * Math . PI / ( 3 + 5 * Math . random ( ) ) ) ;
         p3 = new LDouble ( Math . random ( ) ) ;
         p4 = new LDouble ( Math . random ( ) ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Curl_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Curl ( p1 . val , p2 . val ) ;
      }

      public Curl_f() {
         addGroupMeta(this);
         p1 = new LDouble ( Math . random ( ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Curl_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Curl ( p1 . val , p2 . val ) ;
      }

      public Curl_v() {
         addGroupMeta(this);
         p1 = new LDouble ( Math . random ( ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Rectangles_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Rectangles ( p1 . val , p2 . val ) ;
      }

      public Rectangles_f() {
         addGroupMeta(this);
         p1 = new LDouble ( Math . random ( ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Rectangles_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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

      public void setup() throws BuildException {
         super.setup();
         function = new Rectangles ( p1 . val , p2 . val ) ;
      }

      public Rectangles_v() {
         addGroupMeta(this);
         p1 = new LDouble ( Math . random ( ) ) ;
         p2 = new LDouble ( Math . random ( ) ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Arch_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Arch ( new Random ( seed ) ) ;
      }

      public Arch_f() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {

         return function . map ( null , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Arch_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Arch ( new Random ( seed ) ) ;
      }

      public Arch_v() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Tangent_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Tangent ( ) ;
      }

      public Tangent_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Tangent_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Tangent ( ) ;
      }

      public Tangent_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Square_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Square ( new Random ( seed ) ) ;
      }

      public Square_f() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {

         return function . map ( null , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Square_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Square ( new Random ( seed ) ) ;
      }

      public Square_v() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Rays_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Rays ( new Random ( seed ) ) ;
      }

      public Rays_f() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Rays_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Rays ( new Random ( seed ) ) ;
      }

      public Rays_v() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Blade_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Blade ( new Random ( seed ) ) ;
      }

      public Blade_f() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Blade_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Blade ( new Random ( seed ) ) ;
      }

      public Blade_v() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Secant_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Secant ( ) ;
      }

      public Secant_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( null , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Secant_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Secant ( ) ;
      }

      public Secant_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Twintrain_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Twintrain ( new Random ( seed ) ) ;
      }

      public Twintrain_f() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Twintrain_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Twintrain ( new Random ( seed ) ) ;
      }

      public Twintrain_v() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public static class Cross_f extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
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
         function = new Cross ( ) ;
      }

      public Cross_f() {
         addGroupMeta(this);
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         final LVect2d v = (LVect2d)inputs[0];
         return function . map ( v , new LVect2d ( ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Cross_v extends ExpressionFunction {
      private IFSUtil . Mapping_v2 function ;
      public void setup() throws BuildException {
         super.setup();
         function = new Cross ( ) ;
      }

      public Cross_v() {
         addGroupMeta(this);
      }

      public IFSUtil . Mapping_v2 evaluate(Context context, Object[] inputs) {

         return function ;
      }

      public Class getReturnType() {
         return IFSUtil . Mapping_v2.class;
      }

   }

   public String getDescription() {
      return "V2->V2 Variations identified from Scott Draves' paper describing the Fractal Flame algorithm";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new Sinusoidal_f());
      r.add(new Sinusoidal_v());
      r.add(new Spherical_f());
      r.add(new Spherical_v());
      r.add(new Swirl_f());
      r.add(new Swirl_v());
      r.add(new Horseshoe_f());
      r.add(new Horseshoe_v());
      r.add(new Polar_f());
      r.add(new Polar_v());
      r.add(new Handkerchief_f());
      r.add(new Handkerchief_v());
      r.add(new Heart_f());
      r.add(new Heart_v());
      r.add(new Disc_f());
      r.add(new Disc_v());
      r.add(new Spiral_f());
      r.add(new Spiral_v());
      r.add(new Hyperbolic_f());
      r.add(new Hyperbolic_v());
      r.add(new Diamond_f());
      r.add(new Diamond_v());
      r.add(new Ex_f());
      r.add(new Ex_v());
      r.add(new Julia_f());
      r.add(new Julia_v());
      r.add(new Bent_f());
      r.add(new Bent_v());
      r.add(new Waves_f());
      r.add(new Waves_v());
      r.add(new Fisheye_f());
      r.add(new Fisheye_v());
      r.add(new Popcorn_f());
      r.add(new Popcorn_v());
      r.add(new Exponential_f());
      r.add(new Exponential_v());
      r.add(new Power_f());
      r.add(new Power_v());
      r.add(new Cosine_f());
      r.add(new Cosine_v());
      r.add(new Rings_f());
      r.add(new Rings_v());
      r.add(new Fan_f());
      r.add(new Fan_v());
      r.add(new Blob_f());
      r.add(new Blob_v());
      r.add(new PDJ_f());
      r.add(new PDJ_v());
      r.add(new Fan2_f());
      r.add(new Fan2_v());
      r.add(new Rings2_f());
      r.add(new Rings2_v());
      r.add(new Eyefish_f());
      r.add(new Eyefish_v());
      r.add(new Bubble_f());
      r.add(new Bubble_v());
      r.add(new Cylinder_f());
      r.add(new Cylinder_v());
      r.add(new Perspective_f());
      r.add(new Perspective_v());
      r.add(new Noise_f());
      r.add(new Noise_v());
      r.add(new JuliaN_f());
      r.add(new JuliaN_v());
      r.add(new JuliaScope_f());
      r.add(new JuliaScope_v());
      r.add(new Blur_f());
      r.add(new Blur_v());
      r.add(new Gaussian_f());
      r.add(new Gaussian_v());
      r.add(new RadialBlur_f());
      r.add(new RadialBlur_v());
      r.add(new Pie_f());
      r.add(new Pie_v());
      r.add(new Ngon_f());
      r.add(new Ngon_v());
      r.add(new Curl_f());
      r.add(new Curl_v());
      r.add(new Rectangles_f());
      r.add(new Rectangles_v());
      r.add(new Arch_f());
      r.add(new Arch_v());
      r.add(new Tangent_f());
      r.add(new Tangent_v());
      r.add(new Square_f());
      r.add(new Square_v());
      r.add(new Rays_f());
      r.add(new Rays_v());
      r.add(new Blade_f());
      r.add(new Blade_v());
      r.add(new Secant_f());
      r.add(new Secant_v());
      r.add(new Twintrain_f());
      r.add(new Twintrain_v());
      r.add(new Cross_f());
      r.add(new Cross_v());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
