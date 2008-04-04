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
import utils.linear.*;

public final class Loops implements AllComponents<StatementFunction>, Described {
   public static class Wombat extends StatementFunction {

      public String getDescription() {
         return "toast";
      }

      public void execute(Context context, List<GeneticComponent> inputs) {



      }

   }

   public String getDescription() {
      return "Statements that use some looping structure.";
   }

   public List<StatementFunction> allInstances(ContextModel cm) {
      List<StatementFunction> r = new ArrayList<StatementFunction>();
      r.add(new Wombat());
      return r;
   }

}
