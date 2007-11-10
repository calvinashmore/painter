package library.expressions.functions;

import genetic.*;
import genetic.expression.*;
import java.util.*;

public class AllFn implements FunctionGroup {
   public List<ExpressionFunction> getFunctions() {
      List<ExpressionFunction> functions = new LinkedList();
      functions.addAll( new Algebraic().getFunctions() );
      return functions;
   }

   public ExpressionFunction build(Class<? extends ExpressionFunction> nfClass, ExpressionFactory nff) {
      ExpressionFunction r;
      if( (r = new Algebraic().build(nfClass,nff)) != null) return r;
      return null;
   }

}
