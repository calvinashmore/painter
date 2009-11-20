package painter . functions . expressions;

import java.util.*;
import genetic.*;
import genetic.component.accessor.*;
import genetic.component.command.*;
import genetic.component.context.*;
import genetic.component.expression.*;
import genetic.component.expression.function.*;
import genetic.component.method.*;
import genetic.component.program.*;
import genetic.component.statement.*;
import genetic.component.statementlist.*;
import genetic.component.statement.function.*;
import utils.linear.*;
import painter.tools.brush.*;

public final class Brushes implements AllComponents<ExpressionFunction>, Described {

   public static class simpleBrush extends ExpressionFunction {

      public simpleBrush() {
         addGroupMeta(this);
      }

      public Brush evaluate(Context context, Object[] inputs) {

         return new SimpleBrush ( ) ;
      }

      public Class getReturnType() {
         return Brush.class;
      }

   }

   public String getDescription() {
      return "expressions to generate brushes";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new simpleBrush());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
