package library . statements;

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

public class AllFn implements AllComponents<StatementFunction> {
   public List<StatementFunction> allInstances(ContextModel cm) {
      List<StatementFunction> r = new ArrayList<StatementFunction>();
      r.addAll(new AlongCurves().allInstances(cm));
      r.addAll(new Attractors().allInstances(cm));
      r.addAll(new Buffers().allInstances(cm));
      r.addAll(new Conditionals().allInstances(cm));
      r.addAll(new IFSStatements().allInstances(cm));
      r.addAll(new Loops().allInstances(cm));
      r.addAll(new Quadtrees().allInstances(cm));
      return r;
   }

}
