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
import painter.tools.misc.*;
import painter.tools.canvas.*;
import painter.tools.imageop.*;

public final class CustomImageOps implements AllComponents<ExpressionFunction>, Described {

   public static class Mosaic1 extends ExpressionFunction {

      private LDouble tileSize;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return tileSize;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "tileSize";
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
            case 0: tileSize = (LDouble) value; return;
            default: return;
         }

      }

      public Mosaic1() {
         addGroupMeta(this);
         addMeta("selectionWeight", 10);
         tileSize = new LDouble ( .01 * Math . random ( ) + .005 ) ;
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {

         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         int iTileSize = ( int ) Math . abs ( tileSize . val * canvas . getHeight ( ) ) ;
         return new MosaicFilter ( iTileSize ) ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class Mosaic2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "tileSize";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public Mosaic2() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {
         final LDouble tileSize = (LDouble)inputs[0];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         int iTileSize = ( int ) Math . abs ( tileSize . val * canvas . getHeight ( ) ) ;
         if ( iTileSize <= 1 ) iTileSize = 3 ;
         if ( iTileSize >= canvas . getHeight ( ) / 5 ) iTileSize = canvas . getHeight ( ) / 10 ;
         return new MosaicFilter ( iTileSize ) ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public static class Mosaic3 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "tileSize";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return Integer.class;
            default: return null;
         }

      }

      public Mosaic3() {
         addGroupMeta(this);
      }

      public BufferedImageOp evaluate(Context context, Object[] inputs) {
         final Integer tileSize = (Integer)inputs[0];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         int iTileSize = tileSize ;
         if ( iTileSize <= 1 ) iTileSize = 3 ;
         if ( iTileSize >= canvas . getHeight ( ) / 5 ) iTileSize = canvas . getHeight ( ) / 10 ;
         return new MosaicFilter ( iTileSize ) ;
      }

      public Class getReturnType() {
         return BufferedImageOp.class;
      }

   }

   public String getDescription() {
      return "expressions for custom image operations";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new Mosaic1());
      r.add(new Mosaic2());
      r.add(new Mosaic3());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
