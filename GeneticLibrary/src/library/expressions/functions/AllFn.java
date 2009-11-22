package library . expressions . functions;

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
      r.addAll(new Algebraic().allInstances(cm));
      r.addAll(new Analytic().allInstances(cm));
      r.addAll(new Blending().allInstances(cm));
      r.addAll(new BooleanOperations().allInstances(cm));
      r.addAll(new ColorOp().allInstances(cm));
      r.addAll(new Complexfn().allInstances(cm));
      r.addAll(new Curves().allInstances(cm));
      r.addAll(new Interpolate().allInstances(cm));
      r.addAll(new Lyapunov().allInstances(cm));
      r.addAll(new Noise1().allInstances(cm));
      r.addAll(new Noise1Grad().allInstances(cm));
      r.addAll(new Noise2().allInstances(cm));
      r.addAll(new Noise3().allInstances(cm));
      r.addAll(new ColorPaint().allInstances(cm));
      r.addAll(new Quaternions().allInstances(cm));
      r.addAll(new RandomValues().allInstances(cm));
      r.addAll(new VectorSwitch().allInstances(cm));
      return r;
   }

}
