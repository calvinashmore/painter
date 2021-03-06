package painter . functions . expressions . warp;

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

public class AllFn implements AllComponents<ExpressionFunction> {
   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.addAll(new Warp().allInstances(cm));
      return r;
   }

}
