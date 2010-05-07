package painter . functions . commands;

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

public class AllFn implements AllComponents<Command> {
   public List<Command> allInstances(ContextModel cm) {
      List<Command> r = new ArrayList<Command>();
      r.addAll(new BrushCommands().allInstances(cm));
      r.addAll(new ImageOps().allInstances(cm));
      r.addAll(new LSystems().allInstances(cm));
      r.addAll(new PointPlot().allInstances(cm));
      r.addAll(new StrokeCommands().allInstances(cm));
      return r;
   }

}
