package painter . functions . expressions . warp;

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
import painter.foundation.warp.*;

public final class Warp implements AllComponents<ExpressionFunction> {

   public static class warp_d_d extends WarpFunction < LDouble , LDouble > {
      public Class getVariableType ( ) { return LDouble . class ; }public LDouble warp ( LDouble value ) { return new LDouble ( offset . val + scale . val * value . val ) ; }
      private LDouble offset;private LDouble scale;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return offset;
            case 1: return scale;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "offset";
            case 1: return "scale";
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
            case 0: offset = (LDouble) value; return;
            case 1: scale = (LDouble) value; return;
            default: return;
         }

      }

      public warp_d_d() {
         addGroupMeta(this);
         offset = new LDouble ( 2 * Math . random ( ) - 1 ) ;
         scale = new LDouble ( 2 * Math . random ( ) - 1 ) ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {

         return super . evaluate ( context ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new warp_d_d());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
