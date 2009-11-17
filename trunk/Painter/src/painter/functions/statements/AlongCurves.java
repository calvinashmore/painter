package painter . functions . statements;

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
import painter.util.curves.*;

public final class AlongCurves implements AllComponents<StatementFunction>, Described {

   public static class alongCurve_dense_d extends StatementFunction {

      private Integer n;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return n;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "n";
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
            case 0: n = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "curve";
            case 1: return "body";
            default: return null;
         }

      }

      public InputSignature getInputSignature(int i) {
         switch(i) {
            case 0: return new ExpressionInputSignature(CurveUtil . Curve_d.class);
            case 1: return new StatementListInputSignature();
            default: return null;
         }

      }

      public alongCurve_dense_d() {
         addGroupMeta(this);
         n = 150 + new Random ( ) . nextInt ( 100 ) ;
      }

      public String getDescription() {
         return "Iterates densely along a LDouble curve";
      }

      public void execute(Context context, List<GeneticComponent> inputs) {
         Expression curve = (Expression) inputs.get(0);
         StatementList body = (StatementList) inputs.get(1);
         String __i = getContextVariableActualName("i");
         Integer i;
         String __x = getContextVariableActualName("x");
         LDouble x;
         i = 0 ; context.setVariable(__i, i);
         CurveUtil . Curve_d evalCurve = ( CurveUtil . Curve_d ) curve . evaluate ( context ) ;
         while ( i < n ) {
         double t = 1.0 * i / n ;
         x = evalCurve . getValue ( t ) ; context.setVariable(__x, x);
         body . execute ( context ) ;
         i = i + 1 ; context.setVariable(__i, i);
         }
      }

      public int getNumberContextVariables() {
         return 2;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "i";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

   }

   public static class alongCurve_light_d extends StatementFunction {

      private Integer n;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return n;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "n";
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
            case 0: n = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "curve";
            case 1: return "body";
            default: return null;
         }

      }

      public InputSignature getInputSignature(int i) {
         switch(i) {
            case 0: return new ExpressionInputSignature(CurveUtil . Curve_d.class);
            case 1: return new StatementListInputSignature();
            default: return null;
         }

      }

      public alongCurve_light_d() {
         addGroupMeta(this);
         n = 15 + new Random ( ) . nextInt ( 10 ) ;
      }

      public String getDescription() {
         return "Iterates lightly along a LDouble curve";
      }

      public void execute(Context context, List<GeneticComponent> inputs) {
         Expression curve = (Expression) inputs.get(0);
         StatementList body = (StatementList) inputs.get(1);
         String __i = getContextVariableActualName("i");
         Integer i;
         String __x = getContextVariableActualName("x");
         LDouble x;
         i = 0 ; context.setVariable(__i, i);
         CurveUtil . Curve_d evalCurve = ( CurveUtil . Curve_d ) curve . evaluate ( context ) ;
         while ( i < n ) {
         double t = 1.0 * i / n ;
         x = evalCurve . getValue ( t ) ; context.setVariable(__x, x);
         body . execute ( context ) ;
         i = i + 1 ; context.setVariable(__i, i);
         }
      }

      public int getNumberContextVariables() {
         return 2;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "i";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

   }

   public static class alongCurve_dense_v2 extends StatementFunction {

      private Integer n;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return n;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "n";
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
            case 0: n = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "curve";
            case 1: return "body";
            default: return null;
         }

      }

      public InputSignature getInputSignature(int i) {
         switch(i) {
            case 0: return new ExpressionInputSignature(CurveUtil . Curve_v2.class);
            case 1: return new StatementListInputSignature();
            default: return null;
         }

      }

      public alongCurve_dense_v2() {
         addGroupMeta(this);
         n = 150 + new Random ( ) . nextInt ( 100 ) ;
      }

      public String getDescription() {
         return "Iterates densely along a LVect2d curve";
      }

      public void execute(Context context, List<GeneticComponent> inputs) {
         Expression curve = (Expression) inputs.get(0);
         StatementList body = (StatementList) inputs.get(1);
         String __i = getContextVariableActualName("i");
         Integer i;
         String __x = getContextVariableActualName("x");
         LVect2d x;
         i = 0 ; context.setVariable(__i, i);
         CurveUtil . Curve_v2 evalCurve = ( CurveUtil . Curve_v2 ) curve . evaluate ( context ) ;
         while ( i < n ) {
         double t = 1.0 * i / n ;
         x = evalCurve . getValue ( t ) ; context.setVariable(__x, x);
         body . execute ( context ) ;
         i = i + 1 ; context.setVariable(__i, i);
         }
      }

      public int getNumberContextVariables() {
         return 2;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "i";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

   }

   public static class alongCurve_light_v2 extends StatementFunction {

      private Integer n;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return n;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "n";
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
            case 0: n = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "curve";
            case 1: return "body";
            default: return null;
         }

      }

      public InputSignature getInputSignature(int i) {
         switch(i) {
            case 0: return new ExpressionInputSignature(CurveUtil . Curve_v2.class);
            case 1: return new StatementListInputSignature();
            default: return null;
         }

      }

      public alongCurve_light_v2() {
         addGroupMeta(this);
         n = 15 + new Random ( ) . nextInt ( 10 ) ;
      }

      public String getDescription() {
         return "Iterates lightly along a LVect2d curve";
      }

      public void execute(Context context, List<GeneticComponent> inputs) {
         Expression curve = (Expression) inputs.get(0);
         StatementList body = (StatementList) inputs.get(1);
         String __i = getContextVariableActualName("i");
         Integer i;
         String __x = getContextVariableActualName("x");
         LVect2d x;
         i = 0 ; context.setVariable(__i, i);
         CurveUtil . Curve_v2 evalCurve = ( CurveUtil . Curve_v2 ) curve . evaluate ( context ) ;
         while ( i < n ) {
         double t = 1.0 * i / n ;
         x = evalCurve . getValue ( t ) ; context.setVariable(__x, x);
         body . execute ( context ) ;
         i = i + 1 ; context.setVariable(__i, i);
         }
      }

      public int getNumberContextVariables() {
         return 2;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "i";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

   }

   public static class alongCurve_dense_col extends StatementFunction {

      private Integer n;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return n;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "n";
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
            case 0: n = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "curve";
            case 1: return "body";
            default: return null;
         }

      }

      public InputSignature getInputSignature(int i) {
         switch(i) {
            case 0: return new ExpressionInputSignature(CurveUtil . Curve_col.class);
            case 1: return new StatementListInputSignature();
            default: return null;
         }

      }

      public alongCurve_dense_col() {
         addGroupMeta(this);
         n = 150 + new Random ( ) . nextInt ( 100 ) ;
      }

      public String getDescription() {
         return "Iterates densely along a Color curve";
      }

      public void execute(Context context, List<GeneticComponent> inputs) {
         Expression curve = (Expression) inputs.get(0);
         StatementList body = (StatementList) inputs.get(1);
         String __i = getContextVariableActualName("i");
         Integer i;
         String __x = getContextVariableActualName("x");
         Color x;
         i = 0 ; context.setVariable(__i, i);
         CurveUtil . Curve_col evalCurve = ( CurveUtil . Curve_col ) curve . evaluate ( context ) ;
         while ( i < n ) {
         double t = 1.0 * i / n ;
         x = evalCurve . getValue ( t ) ; context.setVariable(__x, x);
         body . execute ( context ) ;
         i = i + 1 ; context.setVariable(__i, i);
         }
      }

      public int getNumberContextVariables() {
         return 2;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "i";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return Color.class;
            default: return null;
         }

      }

   }

   public static class alongCurve_light_col extends StatementFunction {

      private Integer n;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return n;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "n";
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
            case 0: n = (Integer) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "curve";
            case 1: return "body";
            default: return null;
         }

      }

      public InputSignature getInputSignature(int i) {
         switch(i) {
            case 0: return new ExpressionInputSignature(CurveUtil . Curve_col.class);
            case 1: return new StatementListInputSignature();
            default: return null;
         }

      }

      public alongCurve_light_col() {
         addGroupMeta(this);
         n = 15 + new Random ( ) . nextInt ( 10 ) ;
      }

      public String getDescription() {
         return "Iterates lightly along a Color curve";
      }

      public void execute(Context context, List<GeneticComponent> inputs) {
         Expression curve = (Expression) inputs.get(0);
         StatementList body = (StatementList) inputs.get(1);
         String __i = getContextVariableActualName("i");
         Integer i;
         String __x = getContextVariableActualName("x");
         Color x;
         i = 0 ; context.setVariable(__i, i);
         CurveUtil . Curve_col evalCurve = ( CurveUtil . Curve_col ) curve . evaluate ( context ) ;
         while ( i < n ) {
         double t = 1.0 * i / n ;
         x = evalCurve . getValue ( t ) ; context.setVariable(__x, x);
         body . execute ( context ) ;
         i = i + 1 ; context.setVariable(__i, i);
         }
      }

      public int getNumberContextVariables() {
         return 2;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "i";
            case 1: return "x";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return Color.class;
            default: return null;
         }

      }

   }

   public String getDescription() {
      return "Statements that iterate along curves.";
   }

   public List<StatementFunction> allInstances(ContextModel cm) {
      List<StatementFunction> r = new ArrayList<StatementFunction>();
      r.add(new alongCurve_dense_d());
      r.add(new alongCurve_light_d());
      r.add(new alongCurve_dense_v2());
      r.add(new alongCurve_light_v2());
      r.add(new alongCurve_dense_col());
      r.add(new alongCurve_light_col());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
