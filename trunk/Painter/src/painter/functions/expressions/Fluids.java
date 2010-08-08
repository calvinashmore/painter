package painter . functions . expressions;

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
import java.awt.image.*;
import utils.linear.*;
import painter.tools.brush.*;
import painter.tools.canvas.*;
import fluids.*;
import fluids.applied.*;
import fluids.output.*;

public final class Fluids implements AllComponents<ExpressionFunction>, Described {

   public static class fluidImage_1 extends ExpressionFunction {

      private Integer imageSize;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return imageSize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "imageSize";
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
            case 0: imageSize = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "fluid";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return ColorFluid.class;
            default: return null;
         }

      }

      public fluidImage_1() {
         addGroupMeta(this);
         imageSize = ( int ) ( 100 + 400 * Math . random ( ) ) ;
      }

      public BufferedImage evaluate(Context context, Object[] inputs) {
         final ColorFluid fluid = (ColorFluid)inputs[0];
         BufferedImage image = fluid . createBasicImage ( imageSize ) ;
         return image ;
      }

      public Class getReturnType() {
         return BufferedImage.class;
      }

   }

   public static class fluidBrush_1 extends ExpressionFunction {

      private Integer imageSize;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return imageSize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "imageSize";
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
            case 0: imageSize = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "fluid";
            case 1: return "positionPolicy";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return ColorFluid.class;
            case 1: return BrushPositionPolicy.class;
            default: return null;
         }

      }

      public fluidBrush_1() {
         addGroupMeta(this);
         imageSize = ( int ) ( 100 + 400 * Math . random ( ) ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final ColorFluid fluid = (ColorFluid)inputs[0];
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[1];
         BufferedImage image = fluid . createBasicImage ( imageSize ) ;
         return new FullImageBrush ( image , positionPolicy ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class fluidBrush_2 extends ExpressionFunction {

      private Integer imageSize;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return imageSize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "imageSize";
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
            case 0: imageSize = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "fluid";
            case 1: return "positionPolicy";
            case 2: return "op";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return ColorFluid.class;
            case 1: return BrushPositionPolicy.class;
            case 2: return BufferedImageOp.class;
            default: return null;
         }

      }

      public fluidBrush_2() {
         addGroupMeta(this);
         imageSize = ( int ) ( 100 + 400 * Math . random ( ) ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final ColorFluid fluid = (ColorFluid)inputs[0];
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[1];
         final BufferedImageOp op = (BufferedImageOp)inputs[2];
         BufferedImage image = fluid . createBasicImage ( imageSize ) ;
         FullImageBrush brush = new FullImageBrush ( image , positionPolicy ) ;
         brush . setOp ( op ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class fluidBrush_3 extends ExpressionFunction {

      private Integer imageSize;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return imageSize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "imageSize";
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
            case 0: imageSize = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "fluid";
            case 1: return "positionPolicy";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return ColorFluid.class;
            case 1: return BrushPositionPolicy.class;
            default: return null;
         }

      }

      public fluidBrush_3() {
         addGroupMeta(this);
         imageSize = ( int ) ( 100 + 400 * Math . random ( ) ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final ColorFluid fluid = (ColorFluid)inputs[0];
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[1];
         BufferedImage image = fluid . createBasicImage ( imageSize ) ;
         FullImageBrush brush = new FullImageBrush ( image , positionPolicy ) ;
         brush . setSizeOffset ( 1.0 ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class fluidBrush_4 extends ExpressionFunction {

      private Integer imageSize;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return imageSize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "imageSize";
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
            case 0: imageSize = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "fluid";
            case 1: return "positionPolicy";
            case 2: return "op";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return ColorFluid.class;
            case 1: return BrushPositionPolicy.class;
            case 2: return BufferedImageOp.class;
            default: return null;
         }

      }

      public fluidBrush_4() {
         addGroupMeta(this);
         imageSize = ( int ) ( 100 + 400 * Math . random ( ) ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final ColorFluid fluid = (ColorFluid)inputs[0];
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[1];
         final BufferedImageOp op = (BufferedImageOp)inputs[2];
         BufferedImage image = fluid . createBasicImage ( imageSize ) ;
         FullImageBrush brush = new FullImageBrush ( image , positionPolicy ) ;
         brush . setSizeOffset ( 1.0 ) ;
         brush . setOp ( op ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class fluidBrush_5 extends ExpressionFunction {

      private Integer imageSize;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return imageSize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "imageSize";
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
            case 0: imageSize = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "fluid";
            case 1: return "positionPolicy";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return ColorFluid.class;
            case 1: return BrushPositionPolicy.class;
            default: return null;
         }

      }

      public fluidBrush_5() {
         addGroupMeta(this);
         imageSize = ( int ) ( 400 + 400 * Math . random ( ) ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final ColorFluid fluid = (ColorFluid)inputs[0];
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[1];
         BufferedImage image = fluid . createBasicImage ( imageSize ) ;
         FullImageBrush brush = new FullImageBrush ( image , positionPolicy ) ;
         brush . setSizeOffset ( 1.0 ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class fluidBrush_6 extends ExpressionFunction {

      private Integer imageSize;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return imageSize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "imageSize";
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
            case 0: imageSize = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "fluid";
            case 1: return "positionPolicy";
            case 2: return "op";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return ColorFluid.class;
            case 1: return BrushPositionPolicy.class;
            case 2: return BufferedImageOp.class;
            default: return null;
         }

      }

      public fluidBrush_6() {
         addGroupMeta(this);
         imageSize = ( int ) ( 400 + 400 * Math . random ( ) ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final ColorFluid fluid = (ColorFluid)inputs[0];
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[1];
         final BufferedImageOp op = (BufferedImageOp)inputs[2];
         BufferedImage image = fluid . createBasicImage ( imageSize ) ;
         FullImageBrush brush = new FullImageBrush ( image , positionPolicy ) ;
         brush . setSizeOffset ( 1.0 ) ;
         brush . setOp ( op ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class fluidBrush_7 extends ExpressionFunction {

      private Integer imageSize;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return imageSize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "imageSize";
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
            case 0: imageSize = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "fluid";
            case 1: return "positionPolicy";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return ColorFluid.class;
            case 1: return BrushPositionPolicy.class;
            default: return null;
         }

      }

      public fluidBrush_7() {
         addGroupMeta(this);
         imageSize = ( int ) ( 800 + 400 * Math . random ( ) ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final ColorFluid fluid = (ColorFluid)inputs[0];
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[1];
         BufferedImage image = fluid . createBasicImage ( imageSize ) ;
         FullImageBrush brush = new FullImageBrush ( image , positionPolicy ) ;
         brush . setSizeOffset ( 1.0 ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class fluidBrush_8 extends ExpressionFunction {

      private Integer imageSize;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return imageSize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "imageSize";
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
            case 0: imageSize = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "fluid";
            case 1: return "positionPolicy";
            case 2: return "op";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return ColorFluid.class;
            case 1: return BrushPositionPolicy.class;
            case 2: return BufferedImageOp.class;
            default: return null;
         }

      }

      public fluidBrush_8() {
         addGroupMeta(this);
         imageSize = ( int ) ( 800 + 400 * Math . random ( ) ) ;
      }

      public Brush evaluate(Context context, Object[] inputs) {
         final ColorFluid fluid = (ColorFluid)inputs[0];
         final BrushPositionPolicy positionPolicy = (BrushPositionPolicy)inputs[1];
         final BufferedImageOp op = (BufferedImageOp)inputs[2];
         BufferedImage image = fluid . createBasicImage ( imageSize ) ;
         FullImageBrush brush = new FullImageBrush ( image , positionPolicy ) ;
         brush . setSizeOffset ( 1.0 ) ;
         brush . setOp ( op ) ;
         return brush ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public static class droplet_1 extends ExpressionFunction {

      private LDouble density;private LDouble viscosity1;private LDouble viscosity2;private LDouble absorption;private LDouble friction;private Integer numberParticles;private LDouble speed;
      public int getNumberParameters() {
         return 7;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return density;
            case 1: return viscosity1;
            case 2: return viscosity2;
            case 3: return absorption;
            case 4: return friction;
            case 5: return numberParticles;
            case 6: return speed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "density";
            case 1: return "viscosity1";
            case 2: return "viscosity2";
            case 3: return "absorption";
            case 4: return "friction";
            case 5: return "numberParticles";
            case 6: return "speed";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            case 4: return LDouble.class;
            case 5: return Integer.class;
            case 6: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: density = (LDouble) value; return;
            case 1: viscosity1 = (LDouble) value; return;
            case 2: viscosity2 = (LDouble) value; return;
            case 3: absorption = (LDouble) value; return;
            case 4: friction = (LDouble) value; return;
            case 5: numberParticles = (Integer) value; return;
            case 6: speed = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "color";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

      public droplet_1() {
         addGroupMeta(this);
         density = new LDouble ( 5 + 5 * Math . random ( ) ) ;
         viscosity1 = new LDouble ( 5 + 15 * Math . random ( ) ) ;
         viscosity2 = new LDouble ( .5 + 1 * Math . random ( ) ) ;
         absorption = new LDouble ( .003 * .01 * Math . random ( ) ) ;
         friction = new LDouble ( .001 + .1 * Math . random ( ) * Math . random ( ) ) ;
         numberParticles = ( int ) ( 100 + 300 * Math . random ( ) ) ;
         speed = new LDouble ( .3 + .6 * Math . random ( ) ) ;
      }

      public ColorFluid evaluate(Context context, Object[] inputs) {
         final Color color = (Color)inputs[0];
         ColorFluid fluid = new ColorFluid ( .1 ) ;
         fluid . setDt ( .1 ) ;
         fluid . setDensityRelaxation ( new FluidDensityRelaxation ( density . val , .01 , .002 ) ) ;
         fluid . setForces ( new FieldForces ( new LVect3d ( 0 , .03 , 0 ) ) ) ;
         fluid . setViscosity ( new FluidViscosity < ColorParticle > ( viscosity1 . val , viscosity2 . val ) ) ;
         AbsorptionCollisions collisions = new AbsorptionCollisions ( ) ;
         CollidableBox box = new CollidableBox ( new LVect3d ( 0 , 0.5 , 0 ) , 2 , .50 , 2 ) ;
         collisions . addCollidable ( box ) ;
         collisions . setSlidingFriction ( friction . val ) ;
         collisions . setAbsorptionRate ( absorption . val ) ;
         fluid . setCollisions ( collisions ) ;
         fluid . addEmitter ( new BoxEmitter < ColorParticle > ( numberParticles , true , new LVect3d ( 0 , speed . val , 0 ) , new LVect3d ( new LVect3d ( 0 , - .5 , 0 ) ) , new LVect3d ( .10 , .30 , .10 ) ) {
         @ Override public ColorParticle constructParticle ( ) {
         ColorParticle particle = new ColorParticle ( ) ;
         particle . setColor ( color ) ;
         return particle ;
         }
         }
         ) ;
         for ( int i = 0 ;
         i < 100 ;
         i ++ ) {
         fluid . simulateTimestep ( ) ;
         }
         return fluid ;
      }

      public Class getReturnType() {
         return ColorFluid.class;
      }

   }

   public static class droplet_2 extends ExpressionFunction {

      private LDouble density;private LDouble viscosity1;private LDouble viscosity2;private LDouble absorption;private LDouble friction;private Integer numberParticles;private LDouble speed;
      public int getNumberParameters() {
         return 7;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return density;
            case 1: return viscosity1;
            case 2: return viscosity2;
            case 3: return absorption;
            case 4: return friction;
            case 5: return numberParticles;
            case 6: return speed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "density";
            case 1: return "viscosity1";
            case 2: return "viscosity2";
            case 3: return "absorption";
            case 4: return "friction";
            case 5: return "numberParticles";
            case 6: return "speed";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            case 4: return LDouble.class;
            case 5: return Integer.class;
            case 6: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: density = (LDouble) value; return;
            case 1: viscosity1 = (LDouble) value; return;
            case 2: viscosity2 = (LDouble) value; return;
            case 3: absorption = (LDouble) value; return;
            case 4: friction = (LDouble) value; return;
            case 5: numberParticles = (Integer) value; return;
            case 6: speed = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "color1";
            case 1: return "color2";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public droplet_2() {
         addGroupMeta(this);
         density = new LDouble ( 5 + 5 * Math . random ( ) ) ;
         viscosity1 = new LDouble ( 5 + 15 * Math . random ( ) ) ;
         viscosity2 = new LDouble ( .5 + 1 * Math . random ( ) ) ;
         absorption = new LDouble ( .003 * .01 * Math . random ( ) ) ;
         friction = new LDouble ( .001 + .1 * Math . random ( ) * Math . random ( ) ) ;
         numberParticles = ( int ) ( 100 + 300 * Math . random ( ) ) ;
         speed = new LDouble ( .3 + .6 * Math . random ( ) ) ;
      }

      public ColorFluid evaluate(Context context, Object[] inputs) {
         final Color color1 = (Color)inputs[0];
         final Color color2 = (Color)inputs[1];
         ColorFluid fluid = new ColorFluid ( .1 ) ;
         fluid . setDt ( .1 ) ;
         fluid . setDensityRelaxation ( new FluidDensityRelaxation ( density . val , .01 , .002 ) ) ;
         fluid . setForces ( new FieldForces ( new LVect3d ( 0 , .03 , 0 ) ) ) ;
         fluid . setViscosity ( new FluidViscosity < ColorParticle > ( viscosity1 . val , viscosity2 . val ) ) ;
         AbsorptionCollisions collisions = new AbsorptionCollisions ( ) ;
         CollidableBox box = new CollidableBox ( new LVect3d ( 0 , 0.5 , 0 ) , 2 , .50 , 2 ) ;
         collisions . addCollidable ( box ) ;
         collisions . setSlidingFriction ( friction . val ) ;
         collisions . setAbsorptionRate ( absorption . val ) ;
         fluid . setCollisions ( collisions ) ;
         fluid . addEmitter ( new BoxEmitter < ColorParticle > ( numberParticles , true , new LVect3d ( 0 , speed . val , 0 ) , new LVect3d ( new LVect3d ( 0 , - .5 , 0 ) ) , new LVect3d ( .10 , .30 , .10 ) ) {
         @ Override public ColorParticle constructParticle ( ) {
         ColorParticle particle = new ColorParticle ( ) ;
         double v = Math . random ( ) ;
         particle . setColor ( color1 . mult ( v ) . add ( color2 . mult ( 1 - v ) ) ) ;
         return particle ;
         }
         }
         ) ;
         for ( int i = 0 ;
         i < 100 ;
         i ++ ) {
         fluid . simulateTimestep ( ) ;
         }
         return fluid ;
      }

      public Class getReturnType() {
         return ColorFluid.class;
      }

   }

   public static class droplet_2a extends ExpressionFunction {

      private LDouble density;private LDouble viscosity1;private LDouble viscosity2;private LDouble absorption;private LDouble friction;private Integer numberParticles;private LDouble speed;
      public int getNumberParameters() {
         return 7;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return density;
            case 1: return viscosity1;
            case 2: return viscosity2;
            case 3: return absorption;
            case 4: return friction;
            case 5: return numberParticles;
            case 6: return speed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "density";
            case 1: return "viscosity1";
            case 2: return "viscosity2";
            case 3: return "absorption";
            case 4: return "friction";
            case 5: return "numberParticles";
            case 6: return "speed";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            case 4: return LDouble.class;
            case 5: return Integer.class;
            case 6: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: density = (LDouble) value; return;
            case 1: viscosity1 = (LDouble) value; return;
            case 2: viscosity2 = (LDouble) value; return;
            case 3: absorption = (LDouble) value; return;
            case 4: friction = (LDouble) value; return;
            case 5: numberParticles = (Integer) value; return;
            case 6: speed = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "color1";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

      public droplet_2a() {
         addGroupMeta(this);
         density = new LDouble ( 5 + 5 * Math . random ( ) ) ;
         viscosity1 = new LDouble ( 5 + 15 * Math . random ( ) ) ;
         viscosity2 = new LDouble ( .5 + 1 * Math . random ( ) ) ;
         absorption = new LDouble ( .003 * .01 * Math . random ( ) ) ;
         friction = new LDouble ( .001 + .1 * Math . random ( ) * Math . random ( ) ) ;
         numberParticles = ( int ) ( 100 + 300 * Math . random ( ) ) ;
         speed = new LDouble ( .3 + .6 * Math . random ( ) ) ;
      }

      public ColorFluid evaluate(Context context, Object[] inputs) {
         final Color color1 = (Color)inputs[0];
         ColorFluid fluid = new ColorFluid ( .1 ) ;
         fluid . setDt ( .1 ) ;
         fluid . setDensityRelaxation ( new FluidDensityRelaxation ( density . val , .01 , .002 ) ) ;
         fluid . setForces ( new FieldForces ( new LVect3d ( 0 , .03 , 0 ) ) ) ;
         fluid . setViscosity ( new FluidViscosity < ColorParticle > ( viscosity1 . val , viscosity2 . val ) ) ;
         AbsorptionCollisions collisions = new AbsorptionCollisions ( ) ;
         CollidableBox box = new CollidableBox ( new LVect3d ( 0 , 0.5 , 0 ) , 2 , .50 , 2 ) ;
         collisions . addCollidable ( box ) ;
         collisions . setSlidingFriction ( friction . val ) ;
         collisions . setAbsorptionRate ( absorption . val ) ;
         fluid . setCollisions ( collisions ) ;
         fluid . addEmitter ( new BoxEmitter < ColorParticle > ( numberParticles , true , new LVect3d ( 0 , speed . val , 0 ) , new LVect3d ( new LVect3d ( 0 , - .5 , 0 ) ) , new LVect3d ( .10 , .30 , .10 ) ) {
         @ Override public ColorParticle constructParticle ( ) {
         ColorParticle particle = new ColorParticle ( ) ;
         Color color2 = new Color ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         double v = .5 + .5 * Math . random ( ) ;
         particle . setColor ( color1 . mult ( v ) . add ( color2 . mult ( 1 - v ) ) ) ;
         return particle ;
         }
         }
         ) ;
         for ( int i = 0 ;
         i < 100 ;
         i ++ ) {
         fluid . simulateTimestep ( ) ;
         }
         return fluid ;
      }

      public Class getReturnType() {
         return ColorFluid.class;
      }

   }

   public static class droplet_3 extends ExpressionFunction {

      private LDouble density;private LDouble viscosity1;private LDouble viscosity2;private LDouble absorption;private LDouble friction;private Integer numberParticles;private LDouble speed;
      public int getNumberParameters() {
         return 7;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return density;
            case 1: return viscosity1;
            case 2: return viscosity2;
            case 3: return absorption;
            case 4: return friction;
            case 5: return numberParticles;
            case 6: return speed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "density";
            case 1: return "viscosity1";
            case 2: return "viscosity2";
            case 3: return "absorption";
            case 4: return "friction";
            case 5: return "numberParticles";
            case 6: return "speed";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            case 4: return LDouble.class;
            case 5: return Integer.class;
            case 6: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: density = (LDouble) value; return;
            case 1: viscosity1 = (LDouble) value; return;
            case 2: viscosity2 = (LDouble) value; return;
            case 3: absorption = (LDouble) value; return;
            case 4: friction = (LDouble) value; return;
            case 5: numberParticles = (Integer) value; return;
            case 6: speed = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "color1";
            case 1: return "color2";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public droplet_3() {
         addGroupMeta(this);
         density = new LDouble ( 5 + 5 * Math . random ( ) ) ;
         viscosity1 = new LDouble ( 5 + 15 * Math . random ( ) ) ;
         viscosity2 = new LDouble ( .5 + 1 * Math . random ( ) ) ;
         absorption = new LDouble ( .003 * .01 * Math . random ( ) ) ;
         friction = new LDouble ( .001 + .1 * Math . random ( ) * Math . random ( ) ) ;
         numberParticles = ( int ) ( 100 + 300 * Math . random ( ) ) ;
         speed = new LDouble ( .3 + .6 * Math . random ( ) ) ;
      }

      public ColorFluid evaluate(Context context, Object[] inputs) {
         final Color color1 = (Color)inputs[0];
         final Color color2 = (Color)inputs[1];
         ColorFluid fluid = new ColorFluid ( .1 ) ;
         fluid . setDt ( .1 ) ;
         fluid . setDensityRelaxation ( new FluidDensityRelaxation ( density . val , .01 , .002 ) ) ;
         fluid . setForces ( new FieldForces ( new LVect3d ( 0 , .03 , 0 ) ) ) ;
         fluid . setViscosity ( new FluidViscosity < ColorParticle > ( viscosity1 . val , viscosity2 . val ) ) ;
         AbsorptionCollisions collisions = new AbsorptionCollisions ( ) ;
         CollidableBox box = new CollidableBox ( new LVect3d ( 0 , 0.5 , 0 ) , 2 , .50 , 2 ) ;
         collisions . addCollidable ( box ) ;
         collisions . setSlidingFriction ( friction . val ) ;
         collisions . setAbsorptionRate ( absorption . val ) ;
         fluid . setCollisions ( collisions ) ;
         fluid . addEmitter ( new BoxEmitter < ColorParticle > ( numberParticles / 2 , true , new LVect3d ( 0 , speed . val , 0 ) , new LVect3d ( new LVect3d ( 0 , - .5 , 0 ) ) , new LVect3d ( .10 , .30 , .10 ) ) {
         @ Override public ColorParticle constructParticle ( ) {
         ColorParticle particle = new ColorParticle ( ) ;
         double v = Math . random ( ) ;
         particle . setColor ( color1 ) ;
         return particle ;
         }
         }
         ) ;
         for ( int i = 0 ;
         i < 50 ;
         i ++ ) {
         fluid . simulateTimestep ( ) ;
         }
         fluid . addEmitter ( new BoxEmitter < ColorParticle > ( numberParticles / 2 , true , new LVect3d ( 0 , speed . val , 0 ) , new LVect3d ( new LVect3d ( 0 , - .5 , 0 ) ) , new LVect3d ( .10 , .30 , .10 ) ) {
         @ Override public ColorParticle constructParticle ( ) {
         ColorParticle particle = new ColorParticle ( ) ;
         particle . setColor ( color2 ) ;
         return particle ;
         }
         }
         ) ;
         for ( int i = 0 ;
         i < 50 ;
         i ++ ) {
         fluid . simulateTimestep ( ) ;
         }
         return fluid ;
      }

      public Class getReturnType() {
         return ColorFluid.class;
      }

   }

   public static class spray_1 extends ExpressionFunction {

      private LDouble absorption;private LDouble friction;private Integer numberParticles;private LDouble speed;private LDouble angle;
      public int getNumberParameters() {
         return 5;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return absorption;
            case 1: return friction;
            case 2: return numberParticles;
            case 3: return speed;
            case 4: return angle;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "absorption";
            case 1: return "friction";
            case 2: return "numberParticles";
            case 3: return "speed";
            case 4: return "angle";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return Integer.class;
            case 3: return LDouble.class;
            case 4: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: absorption = (LDouble) value; return;
            case 1: friction = (LDouble) value; return;
            case 2: numberParticles = (Integer) value; return;
            case 3: speed = (LDouble) value; return;
            case 4: angle = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "color";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

      public spray_1() {
         addGroupMeta(this);
         absorption = new LDouble ( .003 * .01 * Math . random ( ) ) ;
         friction = new LDouble ( .005 + .1 * Math . random ( ) * Math . random ( ) ) ;
         numberParticles = ( int ) ( 100 + 200 * Math . random ( ) ) ;
         speed = new LDouble ( .4 + 1.5 * Math . random ( ) ) ;
         angle = new LDouble ( .25 + Math . PI * .5 * Math . random ( ) ) ;
      }

      public ColorFluid evaluate(Context context, Object[] inputs) {
         final Color color = (Color)inputs[0];
         ColorFluid fluid = new ColorFluid ( .1 ) ;
         fluid . setDt ( .1 ) ;
         fluid . setDensityRelaxation ( new FluidDensityRelaxation ( 10 , .004 , .01 ) ) ;
         fluid . setForces ( new FieldForces ( new LVect3d ( 0 , .03 , 0 ) ) ) ;
         AbsorptionCollisions collisions = new AbsorptionCollisions ( ) ;
         CollidableBox box = new CollidableBox ( new LVect3d ( 0 , 0.5 , 0 ) , 20 , .50 , 20 ) ;
         collisions . addCollidable ( box ) ;
         collisions . setSlidingFriction ( friction . val ) ;
         collisions . setAbsorptionRate ( absorption . val ) ;
         fluid . setCollisions ( collisions ) ;
         LVect3d velocity = new LVect3d ( 0 , Math . cos ( angle . val ) , Math . sin ( angle . val ) ) . mult ( speed . val ) ;
         fluid . addEmitter ( new BoxEmitter < ColorParticle > ( numberParticles , true , velocity , new LVect3d ( new LVect3d ( - 1.25 , - .5 , 0 ) ) , new LVect3d ( .10 , .10 , .10 ) ) {
         @ Override public ColorParticle constructParticle ( ) {
         ColorParticle particle = new ColorParticle ( ) ;
         particle . setColor ( color ) ;
         return particle ;
         }
         }
         ) ;
         for ( int i = 0 ;
         i < 100 ;
         i ++ ) {
         fluid . simulateTimestep ( ) ;
         }
         return fluid ;
      }

      public Class getReturnType() {
         return ColorFluid.class;
      }

   }

   public static class spray_2 extends ExpressionFunction {

      private LDouble absorption;private LDouble friction;private Integer numberParticles;private LDouble speed;private LDouble angle;
      public int getNumberParameters() {
         return 5;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return absorption;
            case 1: return friction;
            case 2: return numberParticles;
            case 3: return speed;
            case 4: return angle;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "absorption";
            case 1: return "friction";
            case 2: return "numberParticles";
            case 3: return "speed";
            case 4: return "angle";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return Integer.class;
            case 3: return LDouble.class;
            case 4: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: absorption = (LDouble) value; return;
            case 1: friction = (LDouble) value; return;
            case 2: numberParticles = (Integer) value; return;
            case 3: speed = (LDouble) value; return;
            case 4: angle = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "color1";
            case 1: return "color2";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public spray_2() {
         addGroupMeta(this);
         absorption = new LDouble ( .003 * .01 * Math . random ( ) ) ;
         friction = new LDouble ( .005 + .1 * Math . random ( ) * Math . random ( ) ) ;
         numberParticles = ( int ) ( 100 + 200 * Math . random ( ) ) ;
         speed = new LDouble ( .4 + 1.5 * Math . random ( ) ) ;
         angle = new LDouble ( .25 + Math . PI * .5 * Math . random ( ) ) ;
      }

      public ColorFluid evaluate(Context context, Object[] inputs) {
         final Color color1 = (Color)inputs[0];
         final Color color2 = (Color)inputs[1];
         ColorFluid fluid = new ColorFluid ( .1 ) ;
         fluid . setDt ( .1 ) ;
         fluid . setDensityRelaxation ( new FluidDensityRelaxation ( 10 , .004 , .01 ) ) ;
         fluid . setForces ( new FieldForces ( new LVect3d ( 0 , .03 , 0 ) ) ) ;
         AbsorptionCollisions collisions = new AbsorptionCollisions ( ) ;
         CollidableBox box = new CollidableBox ( new LVect3d ( 0 , 0.5 , 0 ) , 20 , .50 , 20 ) ;
         collisions . addCollidable ( box ) ;
         collisions . setSlidingFriction ( friction . val ) ;
         collisions . setAbsorptionRate ( absorption . val ) ;
         fluid . setCollisions ( collisions ) ;
         LVect3d velocity = new LVect3d ( 0 , Math . cos ( angle . val ) , Math . sin ( angle . val ) ) . mult ( speed . val ) ;
         fluid . addEmitter ( new BoxEmitter < ColorParticle > ( numberParticles , true , velocity , new LVect3d ( new LVect3d ( - 1.25 , - .5 , 0 ) ) , new LVect3d ( .10 , .10 , .10 ) ) {
         @ Override public ColorParticle constructParticle ( ) {
         ColorParticle particle = new ColorParticle ( ) ;
         double v = Math . random ( ) ;
         particle . setColor ( color1 . mult ( v ) . add ( color2 . mult ( 1 - v ) ) ) ;
         return particle ;
         }
         }
         ) ;
         for ( int i = 0 ;
         i < 100 ;
         i ++ ) {
         fluid . simulateTimestep ( ) ;
         }
         return fluid ;
      }

      public Class getReturnType() {
         return ColorFluid.class;
      }

   }

   public static class spray_2a extends ExpressionFunction {

      private LDouble absorption;private LDouble friction;private Integer numberParticles;private LDouble speed;private LDouble angle;
      public int getNumberParameters() {
         return 5;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return absorption;
            case 1: return friction;
            case 2: return numberParticles;
            case 3: return speed;
            case 4: return angle;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "absorption";
            case 1: return "friction";
            case 2: return "numberParticles";
            case 3: return "speed";
            case 4: return "angle";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return Integer.class;
            case 3: return LDouble.class;
            case 4: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: absorption = (LDouble) value; return;
            case 1: friction = (LDouble) value; return;
            case 2: numberParticles = (Integer) value; return;
            case 3: speed = (LDouble) value; return;
            case 4: angle = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "color1";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            default: return null;
         }

      }

      public spray_2a() {
         addGroupMeta(this);
         absorption = new LDouble ( .003 * .01 * Math . random ( ) ) ;
         friction = new LDouble ( .005 + .1 * Math . random ( ) * Math . random ( ) ) ;
         numberParticles = ( int ) ( 100 + 200 * Math . random ( ) ) ;
         speed = new LDouble ( .4 + 1.5 * Math . random ( ) ) ;
         angle = new LDouble ( .25 + Math . PI * .5 * Math . random ( ) ) ;
      }

      public ColorFluid evaluate(Context context, Object[] inputs) {
         final Color color1 = (Color)inputs[0];
         ColorFluid fluid = new ColorFluid ( .1 ) ;
         fluid . setDt ( .1 ) ;
         fluid . setDensityRelaxation ( new FluidDensityRelaxation ( 10 , .004 , .01 ) ) ;
         fluid . setForces ( new FieldForces ( new LVect3d ( 0 , .03 , 0 ) ) ) ;
         AbsorptionCollisions collisions = new AbsorptionCollisions ( ) ;
         CollidableBox box = new CollidableBox ( new LVect3d ( 0 , 0.5 , 0 ) , 20 , .50 , 20 ) ;
         collisions . addCollidable ( box ) ;
         collisions . setSlidingFriction ( friction . val ) ;
         collisions . setAbsorptionRate ( absorption . val ) ;
         fluid . setCollisions ( collisions ) ;
         LVect3d velocity = new LVect3d ( 0 , Math . cos ( angle . val ) , Math . sin ( angle . val ) ) . mult ( speed . val ) ;
         fluid . addEmitter ( new BoxEmitter < ColorParticle > ( numberParticles , true , velocity , new LVect3d ( new LVect3d ( - 1.25 , - .5 , 0 ) ) , new LVect3d ( .10 , .10 , .10 ) ) {
         @ Override public ColorParticle constructParticle ( ) {
         ColorParticle particle = new ColorParticle ( ) ;
         Color color2 = new Color ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         double v = .5 + .5 * Math . random ( ) ;
         particle . setColor ( color1 . mult ( v ) . add ( color2 . mult ( 1 - v ) ) ) ;
         return particle ;
         }
         }
         ) ;
         for ( int i = 0 ;
         i < 100 ;
         i ++ ) {
         fluid . simulateTimestep ( ) ;
         }
         return fluid ;
      }

      public Class getReturnType() {
         return ColorFluid.class;
      }

   }

   public static class spray_3 extends ExpressionFunction {

      private LDouble absorption;private LDouble friction;private Integer numberParticles;private LDouble speed;private LDouble angle;
      public int getNumberParameters() {
         return 5;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return absorption;
            case 1: return friction;
            case 2: return numberParticles;
            case 3: return speed;
            case 4: return angle;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "absorption";
            case 1: return "friction";
            case 2: return "numberParticles";
            case 3: return "speed";
            case 4: return "angle";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return Integer.class;
            case 3: return LDouble.class;
            case 4: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: absorption = (LDouble) value; return;
            case 1: friction = (LDouble) value; return;
            case 2: numberParticles = (Integer) value; return;
            case 3: speed = (LDouble) value; return;
            case 4: angle = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "color1";
            case 1: return "color2";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public spray_3() {
         addGroupMeta(this);
         absorption = new LDouble ( .003 * .01 * Math . random ( ) ) ;
         friction = new LDouble ( .005 + .1 * Math . random ( ) * Math . random ( ) ) ;
         numberParticles = ( int ) ( 100 + 200 * Math . random ( ) ) ;
         speed = new LDouble ( .4 + 1.5 * Math . random ( ) ) ;
         angle = new LDouble ( .25 + Math . PI * .5 * Math . random ( ) ) ;
      }

      public ColorFluid evaluate(Context context, Object[] inputs) {
         final Color color1 = (Color)inputs[0];
         final Color color2 = (Color)inputs[1];
         ColorFluid fluid = new ColorFluid ( .1 ) ;
         fluid . setDt ( .1 ) ;
         fluid . setDensityRelaxation ( new FluidDensityRelaxation ( 10 , .004 , .01 ) ) ;
         fluid . setForces ( new FieldForces ( new LVect3d ( 0 , .03 , 0 ) ) ) ;
         AbsorptionCollisions collisions = new AbsorptionCollisions ( ) ;
         CollidableBox box = new CollidableBox ( new LVect3d ( 0 , 0.5 , 0 ) , 20 , .50 , 20 ) ;
         collisions . addCollidable ( box ) ;
         collisions . setSlidingFriction ( friction . val ) ;
         collisions . setAbsorptionRate ( absorption . val ) ;
         fluid . setCollisions ( collisions ) ;
         LVect3d velocity = new LVect3d ( 0 , Math . cos ( angle . val ) , Math . sin ( angle . val ) ) . mult ( speed . val ) ;
         fluid . addEmitter ( new BoxEmitter < ColorParticle > ( numberParticles / 2 , true , velocity , new LVect3d ( new LVect3d ( - 1.25 , - .5 , 0 ) ) , new LVect3d ( .10 , .10 , .10 ) ) {
         @ Override public ColorParticle constructParticle ( ) {
         ColorParticle particle = new ColorParticle ( ) ;
         particle . setColor ( color1 ) ;
         return particle ;
         }
         }
         ) ;
         for ( int i = 0 ;
         i < 50 ;
         i ++ ) {
         fluid . simulateTimestep ( ) ;
         }
         fluid . addEmitter ( new BoxEmitter < ColorParticle > ( numberParticles / 2 , true , velocity , new LVect3d ( new LVect3d ( - 1.25 , - .5 , 0 ) ) , new LVect3d ( .10 , .10 , .10 ) ) {
         @ Override public ColorParticle constructParticle ( ) {
         ColorParticle particle = new ColorParticle ( ) ;
         particle . setColor ( color2 ) ;
         return particle ;
         }
         }
         ) ;
         for ( int i = 0 ;
         i < 50 ;
         i ++ ) {
         fluid . simulateTimestep ( ) ;
         }
         return fluid ;
      }

      public Class getReturnType() {
         return ColorFluid.class;
      }

   }

   public static class arc_1 extends ExpressionFunction {

      private LDouble absorption;private LDouble friction;private Integer arcDensity;private LDouble arcThickness;private Integer arcSidedness;private LDouble vx_magnitude;private LDouble vx_frequency;private LDouble vx_offset;private LDouble vx_tInfluence;private LDouble vy_baseline;private LDouble vy_frequency;private LDouble vy_magnitude;private LDouble vy_offset;private LDouble vy_randomness;private LDouble vz_magnitude;private LDouble vz_frequency;private LDouble vz_offset;private LDouble vz_randomness;
      public int getNumberParameters() {
         return 18;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return absorption;
            case 1: return friction;
            case 2: return arcDensity;
            case 3: return arcThickness;
            case 4: return arcSidedness;
            case 5: return vx_magnitude;
            case 6: return vx_frequency;
            case 7: return vx_offset;
            case 8: return vx_tInfluence;
            case 9: return vy_baseline;
            case 10: return vy_frequency;
            case 11: return vy_magnitude;
            case 12: return vy_offset;
            case 13: return vy_randomness;
            case 14: return vz_magnitude;
            case 15: return vz_frequency;
            case 16: return vz_offset;
            case 17: return vz_randomness;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "absorption";
            case 1: return "friction";
            case 2: return "arcDensity";
            case 3: return "arcThickness";
            case 4: return "arcSidedness";
            case 5: return "vx_magnitude";
            case 6: return "vx_frequency";
            case 7: return "vx_offset";
            case 8: return "vx_tInfluence";
            case 9: return "vy_baseline";
            case 10: return "vy_frequency";
            case 11: return "vy_magnitude";
            case 12: return "vy_offset";
            case 13: return "vy_randomness";
            case 14: return "vz_magnitude";
            case 15: return "vz_frequency";
            case 16: return "vz_offset";
            case 17: return "vz_randomness";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return Integer.class;
            case 3: return LDouble.class;
            case 4: return Integer.class;
            case 5: return LDouble.class;
            case 6: return LDouble.class;
            case 7: return LDouble.class;
            case 8: return LDouble.class;
            case 9: return LDouble.class;
            case 10: return LDouble.class;
            case 11: return LDouble.class;
            case 12: return LDouble.class;
            case 13: return LDouble.class;
            case 14: return LDouble.class;
            case 15: return LDouble.class;
            case 16: return LDouble.class;
            case 17: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: absorption = (LDouble) value; return;
            case 1: friction = (LDouble) value; return;
            case 2: arcDensity = (Integer) value; return;
            case 3: arcThickness = (LDouble) value; return;
            case 4: arcSidedness = (Integer) value; return;
            case 5: vx_magnitude = (LDouble) value; return;
            case 6: vx_frequency = (LDouble) value; return;
            case 7: vx_offset = (LDouble) value; return;
            case 8: vx_tInfluence = (LDouble) value; return;
            case 9: vy_baseline = (LDouble) value; return;
            case 10: vy_frequency = (LDouble) value; return;
            case 11: vy_magnitude = (LDouble) value; return;
            case 12: vy_offset = (LDouble) value; return;
            case 13: vy_randomness = (LDouble) value; return;
            case 14: vz_magnitude = (LDouble) value; return;
            case 15: vz_frequency = (LDouble) value; return;
            case 16: vz_offset = (LDouble) value; return;
            case 17: vz_randomness = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "color1";
            case 1: return "color2";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public arc_1() {
         addGroupMeta(this);
         addMeta("selectionWeight", 2);
         absorption = new LDouble ( .01 * .2 * Math . random ( ) ) ;
         friction = new LDouble ( .01 + .05 * Math . random ( ) * Math . random ( ) ) ;
         arcDensity = ( int ) ( 100 + 200 * Math . random ( ) ) ;
         arcThickness = new LDouble ( 4 + 3 * Math . random ( ) ) ;
         arcSidedness = ( int ) ( 3 * Math . random ( ) ) ;
         vx_offset = new LDouble ( Math . random ( ) ) ;
         vx_magnitude = new LDouble ( .01 + .1 * Math . random ( ) ) ;
         vx_frequency = new LDouble ( .5 + 2 * Math . random ( ) ) ;
         vx_tInfluence = new LDouble ( .1 + .8 * Math . random ( ) ) ;
         vy_baseline = new LDouble ( .3 + .4 * Math . random ( ) ) ;
         vy_frequency = new LDouble ( .5 + 2 * Math . random ( ) ) ;
         vy_magnitude = new LDouble ( .05 + .1 * Math . random ( ) ) ;
         vy_offset = new LDouble ( Math . random ( ) ) ;
         vy_randomness = new LDouble ( .3 * Math . random ( ) ) ;
         vz_magnitude = new LDouble ( .01 * .1 * Math . random ( ) ) ;
         vz_frequency = new LDouble ( .5 + 2 * Math . random ( ) ) ;
         vz_offset = new LDouble ( Math . random ( ) ) ;
         vz_randomness = new LDouble ( .3 * Math . random ( ) ) ;
      }

      public ColorFluid evaluate(Context context, Object[] inputs) {
         final Color color1 = (Color)inputs[0];
         final Color color2 = (Color)inputs[1];
         ColorFluid fluid = new ColorFluid ( .1 ) ;
         fluid . setDt ( .1 ) ;
         fluid . setDensityRelaxation ( new FluidDensityRelaxation ( 10 , .004 , .01 ) ) ;
         fluid . setForces ( new FieldForces ( new LVect3d ( 0 , .03 , 0 ) ) ) ;
         fluid . setViscosity ( new FluidViscosity < ColorParticle > ( 20 , 1.5 ) ) ;
         fluid . setElastics ( new FluidElastics < ColorParticle > ( .1 , .1 , 0 ) ) ;
         AbsorptionCollisions collisions = new AbsorptionCollisions ( ) ;
         CollidableBox box = new CollidableBox ( new LVect3d ( 0 , 0.5 , 0 ) , 20 , .50 , 20 ) ;
         collisions . addCollidable ( box ) ;
         collisions . setSlidingFriction ( friction . val ) ;
         collisions . setAbsorptionRate ( absorption . val ) ;
         fluid . setCollisions ( collisions ) ;
         fluid . addEmitter ( new Emitter < ColorParticle > ( ) {
         boolean fired = false ;
         @ Override public List < ColorParticle > emitParticles ( ) {
         if ( fired ) {
         return Collections . emptyList ( ) ;
         }
         fired = true ;
         List < ColorParticle > particles = new ArrayList < ColorParticle > ( ) ;
         int N = arcDensity ;
         for ( int i = 0 ;
         i < N ;
         i ++ ) {
         double t = 1.0 * i / N ;
         int M ;
         if ( arcSidedness % 3 == 0 ) M = 1 + ( int ) ( arcThickness . val * ( 1 - t ) * Math . random ( ) ) ;
         else if ( arcSidedness % 3 == 1 ) M = 1 + ( int ) ( arcThickness . val * ( t ) * Math . random ( ) ) ;
         else M = 1 + ( int ) ( arcThickness . val * .5 * Math . random ( ) ) ;
         for ( int j = 0 ;
         j < M ;
         j ++ ) {
         double u = 1.0 * j / M ;
         ColorParticle particle = new ColorParticle ( ) ;
         particle . getPosition ( ) . x = 2 * ( 2 * t - 1 ) ;
         particle . getPosition ( ) . y = - .5 ;
         particle . getPosition ( ) . z = 0 + .1 * u ;
         particle . getVelocity ( ) . x = vx_magnitude . val * Math . cos ( Math . PI * t * vx_frequency . val + vx_offset . val * 2 * Math . PI ) + vx_tInfluence . val * t ;
         particle . getVelocity ( ) . y = vy_baseline . val + vy_magnitude . val * Math . cos ( 2 * Math . PI * vy_frequency . val * t + vy_randomness . val * Math . random ( ) + + vy_offset . val * 2 * Math . PI ) ;
         particle . getVelocity ( ) . z = .0 + vz_magnitude . val * Math . sin ( 4 * Math . PI * vz_frequency . val * t + + vz_offset . val * 2 * Math . PI + vz_randomness . val * Math . random ( ) ) ;
         particle . setColor ( color1 . mult ( t ) . add ( color2 . mult ( 1 - t ) ) ) ;
         particles . add ( particle ) ;
         }
         }
         return particles ;
         }
         }
         ) ;
         for ( int i = 0 ;
         i < 100 ;
         i ++ ) {
         fluid . simulateTimestep ( ) ;
         }
         return fluid ;
      }

      public Class getReturnType() {
         return ColorFluid.class;
      }

   }

   public static class arc_2 extends ExpressionFunction {

      private LDouble absorption;private LDouble friction;private Integer arcDensity;private LDouble arcThickness;private Integer arcSidedness;private LDouble vx_magnitude;private LDouble vx_frequency;private LDouble vx_offset;private LDouble vx_tInfluence;private LDouble vy_baseline;private LDouble vy_frequency;private LDouble vy_magnitude;private LDouble vy_offset;private LDouble vy_randomness;private LDouble vz_magnitude;private LDouble vz_frequency;private LDouble vz_offset;private LDouble vz_randomness;
      public int getNumberParameters() {
         return 18;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return absorption;
            case 1: return friction;
            case 2: return arcDensity;
            case 3: return arcThickness;
            case 4: return arcSidedness;
            case 5: return vx_magnitude;
            case 6: return vx_frequency;
            case 7: return vx_offset;
            case 8: return vx_tInfluence;
            case 9: return vy_baseline;
            case 10: return vy_frequency;
            case 11: return vy_magnitude;
            case 12: return vy_offset;
            case 13: return vy_randomness;
            case 14: return vz_magnitude;
            case 15: return vz_frequency;
            case 16: return vz_offset;
            case 17: return vz_randomness;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "absorption";
            case 1: return "friction";
            case 2: return "arcDensity";
            case 3: return "arcThickness";
            case 4: return "arcSidedness";
            case 5: return "vx_magnitude";
            case 6: return "vx_frequency";
            case 7: return "vx_offset";
            case 8: return "vx_tInfluence";
            case 9: return "vy_baseline";
            case 10: return "vy_frequency";
            case 11: return "vy_magnitude";
            case 12: return "vy_offset";
            case 13: return "vy_randomness";
            case 14: return "vz_magnitude";
            case 15: return "vz_frequency";
            case 16: return "vz_offset";
            case 17: return "vz_randomness";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            case 2: return Integer.class;
            case 3: return LDouble.class;
            case 4: return Integer.class;
            case 5: return LDouble.class;
            case 6: return LDouble.class;
            case 7: return LDouble.class;
            case 8: return LDouble.class;
            case 9: return LDouble.class;
            case 10: return LDouble.class;
            case 11: return LDouble.class;
            case 12: return LDouble.class;
            case 13: return LDouble.class;
            case 14: return LDouble.class;
            case 15: return LDouble.class;
            case 16: return LDouble.class;
            case 17: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: absorption = (LDouble) value; return;
            case 1: friction = (LDouble) value; return;
            case 2: arcDensity = (Integer) value; return;
            case 3: arcThickness = (LDouble) value; return;
            case 4: arcSidedness = (Integer) value; return;
            case 5: vx_magnitude = (LDouble) value; return;
            case 6: vx_frequency = (LDouble) value; return;
            case 7: vx_offset = (LDouble) value; return;
            case 8: vx_tInfluence = (LDouble) value; return;
            case 9: vy_baseline = (LDouble) value; return;
            case 10: vy_frequency = (LDouble) value; return;
            case 11: vy_magnitude = (LDouble) value; return;
            case 12: vy_offset = (LDouble) value; return;
            case 13: vy_randomness = (LDouble) value; return;
            case 14: vz_magnitude = (LDouble) value; return;
            case 15: vz_frequency = (LDouble) value; return;
            case 16: vz_offset = (LDouble) value; return;
            case 17: vz_randomness = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "color1";
            case 1: return "color2";
            case 2: return "color3";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            case 2: return Color.class;
            default: return null;
         }

      }

      public arc_2() {
         addGroupMeta(this);
         addMeta("selectionWeight", 2);
         absorption = new LDouble ( .01 * .2 * Math . random ( ) ) ;
         friction = new LDouble ( .01 + .05 * Math . random ( ) * Math . random ( ) ) ;
         arcDensity = ( int ) ( 100 + 200 * Math . random ( ) ) ;
         arcThickness = new LDouble ( 4 + 3 * Math . random ( ) ) ;
         arcSidedness = ( int ) ( 3 * Math . random ( ) ) ;
         vx_offset = new LDouble ( Math . random ( ) ) ;
         vx_magnitude = new LDouble ( .01 + .1 * Math . random ( ) ) ;
         vx_frequency = new LDouble ( .5 + 2 * Math . random ( ) ) ;
         vx_tInfluence = new LDouble ( .1 + .8 * Math . random ( ) ) ;
         vy_baseline = new LDouble ( .3 + .4 * Math . random ( ) ) ;
         vy_frequency = new LDouble ( .5 + 2 * Math . random ( ) ) ;
         vy_magnitude = new LDouble ( .05 + .1 * Math . random ( ) ) ;
         vy_offset = new LDouble ( Math . random ( ) ) ;
         vy_randomness = new LDouble ( .3 * Math . random ( ) ) ;
         vz_magnitude = new LDouble ( .01 * .1 * Math . random ( ) ) ;
         vz_frequency = new LDouble ( .5 + 2 * Math . random ( ) ) ;
         vz_offset = new LDouble ( Math . random ( ) ) ;
         vz_randomness = new LDouble ( .3 * Math . random ( ) ) ;
      }

      public ColorFluid evaluate(Context context, Object[] inputs) {
         final Color color1 = (Color)inputs[0];
         final Color color2 = (Color)inputs[1];
         final Color color3 = (Color)inputs[2];
         ColorFluid fluid = new ColorFluid ( .1 ) ;
         fluid . setDt ( .1 ) ;
         fluid . setDensityRelaxation ( new FluidDensityRelaxation ( 10 , .004 , .01 ) ) ;
         fluid . setForces ( new FieldForces ( new LVect3d ( 0 , .03 , 0 ) ) ) ;
         fluid . setViscosity ( new FluidViscosity < ColorParticle > ( 20 , 1.5 ) ) ;
         fluid . setElastics ( new FluidElastics < ColorParticle > ( .1 , .1 , 0 ) ) ;
         AbsorptionCollisions collisions = new AbsorptionCollisions ( ) ;
         CollidableBox box = new CollidableBox ( new LVect3d ( 0 , 0.5 , 0 ) , 20 , .50 , 20 ) ;
         collisions . addCollidable ( box ) ;
         collisions . setSlidingFriction ( friction . val ) ;
         collisions . setAbsorptionRate ( absorption . val ) ;
         fluid . setCollisions ( collisions ) ;
         fluid . addEmitter ( new Emitter < ColorParticle > ( ) {
         boolean fired = false ;
         @ Override public List < ColorParticle > emitParticles ( ) {
         if ( fired ) {
         return Collections . emptyList ( ) ;
         }
         fired = true ;
         List < ColorParticle > particles = new ArrayList < ColorParticle > ( ) ;
         int N = arcDensity ;
         for ( int i = 0 ;
         i < N ;
         i ++ ) {
         double t = 1.0 * i / N ;
         int M ;
         if ( arcSidedness % 3 == 0 ) M = 1 + ( int ) ( arcThickness . val * ( 1 - t ) * Math . random ( ) ) ;
         else if ( arcSidedness % 3 == 1 ) M = 1 + ( int ) ( arcThickness . val * ( t ) * Math . random ( ) ) ;
         else M = 1 + ( int ) ( arcThickness . val * .5 * Math . random ( ) ) ;
         for ( int j = 0 ;
         j < M ;
         j ++ ) {
         double u = 1.0 * j / M ;
         ColorParticle particle = new ColorParticle ( ) ;
         particle . getPosition ( ) . x = 2 * ( 2 * t - 1 ) ;
         particle . getPosition ( ) . y = - .5 ;
         particle . getPosition ( ) . z = 0 + .1 * u ;
         particle . getVelocity ( ) . x = vx_magnitude . val * Math . cos ( Math . PI * t * vx_frequency . val + vx_offset . val * 2 * Math . PI ) + vx_tInfluence . val * t ;
         particle . getVelocity ( ) . y = vy_baseline . val + vy_magnitude . val * Math . cos ( 2 * Math . PI * vy_frequency . val * t + vy_randomness . val * Math . random ( ) + + vy_offset . val * 2 * Math . PI ) ;
         particle . getVelocity ( ) . z = .0 + vz_magnitude . val * Math . sin ( 4 * Math . PI * vz_frequency . val * t + + vz_offset . val * 2 * Math . PI + vz_randomness . val * Math . random ( ) ) ;
         double v = Math . random ( ) ;
         Color c = color1 . mult ( t ) . add ( color2 . mult ( 1 - t ) ) ;
         particle . setColor ( c . mult ( v ) . add ( color3 . mult ( 1 - v ) ) ) ;
         particles . add ( particle ) ;
         }
         }
         return particles ;
         }
         }
         ) ;
         for ( int i = 0 ;
         i < 100 ;
         i ++ ) {
         fluid . simulateTimestep ( ) ;
         }
         return fluid ;
      }

      public Class getReturnType() {
         return ColorFluid.class;
      }

   }

   public String getDescription() {
      return "expressions to generate fluids, and things used by fluids";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new fluidImage_1());
      r.add(new fluidBrush_1());
      r.add(new fluidBrush_2());
      r.add(new fluidBrush_3());
      r.add(new fluidBrush_4());
      r.add(new fluidBrush_5());
      r.add(new fluidBrush_6());
      r.add(new fluidBrush_7());
      r.add(new fluidBrush_8());
      r.add(new droplet_1());
      r.add(new droplet_2());
      r.add(new droplet_2a());
      r.add(new droplet_3());
      r.add(new spray_1());
      r.add(new spray_2());
      r.add(new spray_2a());
      r.add(new spray_3());
      r.add(new arc_1());
      r.add(new arc_2());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
