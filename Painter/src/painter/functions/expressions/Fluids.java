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

   public String getDescription() {
      return "expressions to generate fluids, and things used by fluids";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new fluidImage_1());
      r.add(new droplet_1());
      r.add(new droplet_2());
      r.add(new droplet_3());
      r.add(new spray_1());
      r.add(new spray_2());
      r.add(new spray_3());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
