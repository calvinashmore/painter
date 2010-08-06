package painter . functions . commands;

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
import utils.linear.grid.*;
import utils.curves.*;
import utils.pointfield.attractor.*;
import utils.ifs.*;
import painter.tools.canvas.*;
import painter.tools.brush.*;
import fluids.*;
import fluids.applied.*;
import fluids.output.*;
import java.awt.Graphics2D;
import java.awt.image.*;

public final class Fluids implements AllComponents<Command> {

   public static class DrawFluid_1 extends Command {

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
            case 1: return "x";
            case 2: return "y";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return ColorFluid.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public DrawFluid_1() {
         addGroupMeta(this);
         imageSize = ( int ) ( 100 + 400 * Math . random ( ) ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final ColorFluid fluid = (ColorFluid)inputs[0];
         final LDouble x = (LDouble)inputs[1];
         final LDouble y = (LDouble)inputs[2];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         BufferedImage image = fluid . createBasicImage ( imageSize ) ;
         Graphics2D graphics = ( Graphics2D ) canvas . getGraphics ( ) . create ( ) ;
         synchronized ( graphics ) {
         double dx = ( Math . abs ( x . val ) % 1 ) * canvas . getWidth ( ) ;
         double dy = ( Math . abs ( y . val ) % 1 ) * canvas . getHeight ( ) ;
         graphics . translate ( - image . getWidth ( ) / 2 , - image . getHeight ( ) / 2 ) ;
         graphics . translate ( dx , dy ) ;
         graphics . drawImage ( image , 0 , 0 , null ) ;
         }
      }

   }

   public static class DrawFluid_1a extends Command {

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
            case 1: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return ColorFluid.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public DrawFluid_1a() {
         addGroupMeta(this);
         imageSize = ( int ) ( 100 + 400 * Math . random ( ) ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final ColorFluid fluid = (ColorFluid)inputs[0];
         final LVect2d v = (LVect2d)inputs[1];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         BufferedImage image = fluid . createBasicImage ( imageSize ) ;
         Graphics2D graphics = ( Graphics2D ) canvas . getGraphics ( ) . create ( ) ;
         synchronized ( graphics ) {
         double dx = ( Math . abs ( v . x ) % 1 ) * canvas . getWidth ( ) ;
         double dy = ( Math . abs ( v . y ) % 1 ) * canvas . getHeight ( ) ;
         graphics . translate ( - image . getWidth ( ) / 2 , - image . getHeight ( ) / 2 ) ;
         graphics . translate ( dx , dy ) ;
         graphics . drawImage ( image , 0 , 0 , null ) ;
         }
      }

   }

   public static class DrawFluid_2 extends Command {

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
         return 4;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "fluid";
            case 1: return "x";
            case 2: return "y";
            case 3: return "theta";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return ColorFluid.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            default: return null;
         }

      }

      public DrawFluid_2() {
         addGroupMeta(this);
         imageSize = ( int ) ( 100 + 400 * Math . random ( ) ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final ColorFluid fluid = (ColorFluid)inputs[0];
         final LDouble x = (LDouble)inputs[1];
         final LDouble y = (LDouble)inputs[2];
         final LDouble theta = (LDouble)inputs[3];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         BufferedImage image = fluid . createBasicImage ( imageSize ) ;
         Graphics2D graphics = ( Graphics2D ) canvas . getGraphics ( ) . create ( ) ;
         synchronized ( graphics ) {
         double dx = ( Math . abs ( x . val ) % 1 ) * canvas . getWidth ( ) ;
         double dy = ( Math . abs ( y . val ) % 1 ) * canvas . getHeight ( ) ;
         graphics . translate ( - image . getWidth ( ) / 2 , - image . getHeight ( ) / 2 ) ;
         graphics . rotate ( theta . val ) ;
         graphics . translate ( dx , dy ) ;
         graphics . drawImage ( image , 0 , 0 , null ) ;
         }
      }

   }

   public static class DrawFluid_2a extends Command {

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
            case 1: return "v";
            case 2: return "theta";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return ColorFluid.class;
            case 1: return LVect2d.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public DrawFluid_2a() {
         addGroupMeta(this);
         imageSize = ( int ) ( 100 + 400 * Math . random ( ) ) ;
      }

      public void execute(Context context, Object[] inputs) {
         final ColorFluid fluid = (ColorFluid)inputs[0];
         final LVect2d v = (LVect2d)inputs[1];
         final LDouble theta = (LDouble)inputs[2];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         BufferedImage image = fluid . createBasicImage ( imageSize ) ;
         Graphics2D graphics = ( Graphics2D ) canvas . getGraphics ( ) . create ( ) ;
         synchronized ( graphics ) {
         double dx = ( Math . abs ( v . x ) % 1 ) * canvas . getWidth ( ) ;
         double dy = ( Math . abs ( v . y ) % 1 ) * canvas . getHeight ( ) ;
         graphics . translate ( - image . getWidth ( ) / 2 , - image . getHeight ( ) / 2 ) ;
         graphics . rotate ( theta . val ) ;
         graphics . translate ( dx , dy ) ;
         graphics . drawImage ( image , 0 , 0 , null ) ;
         }
      }

   }

   public List<Command> allInstances(ContextModel cm) {
      List<Command> r = new ArrayList<Command>();
      r.add(new DrawFluid_1());
      r.add(new DrawFluid_1a());
      r.add(new DrawFluid_2());
      r.add(new DrawFluid_2a());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
