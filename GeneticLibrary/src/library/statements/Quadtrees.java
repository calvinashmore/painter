package library . statements;

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
import utils.pointfield.*;
import utils.pointfield.attractor.*;

public final class Quadtrees implements AllComponents<StatementFunction>, Described {

   public static class qt2_treeorder extends StatementFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "qt";
            case 1: return "body";
            default: return null;
         }

      }

      public InputSignature getInputSignature(int i) {
         switch(i) {
            case 0: return new ExpressionInputSignature(QT2d.class);
            case 1: return new StatementListInputSignature();
            default: return null;
         }

      }

      public qt2_treeorder() {
         addGroupMeta(this);
      }

      public int getNumberContextVariables() {
         return 4;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "v";
            case 1: return "x";
            case 2: return "y";
            case 3: return "t";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            default: return null;
         }

      }

      public void execute(Context context, List<GeneticComponent> inputs) {
         Expression qt = (Expression) inputs.get(0);
         StatementList body = (StatementList) inputs.get(1);
         final String __v = getContextVariableActualName("v");
         LVect2d v;
         final String __x = getContextVariableActualName("x");
         LDouble x;
         final String __y = getContextVariableActualName("y");
         LDouble y;
         final String __t = getContextVariableActualName("t");
         LDouble t;
         QT2d quadtree = ( QT2d ) qt . evaluate ( context ) ;
         List < APoint2d > points = quadtree . getPoints ( ) ;
         int i = 0 ;
         for ( APoint2d point : points ) {
         t = new LDouble ( ( double ) i / points . size ( ) ) ; context.setVariable(__t, t);
         double px = point . x ;
         double py = point . y ;
         px = ( px - quadtree . getMinX ( ) ) / ( quadtree . getMaxX ( ) - quadtree . getMinX ( ) ) ;
         py = ( py - quadtree . getMinY ( ) ) / ( quadtree . getMaxY ( ) - quadtree . getMinY ( ) ) ;
         x = new LDouble ( px ) ; context.setVariable(__x, x);
         y = new LDouble ( py ) ; context.setVariable(__y, y);
         v = new LVect2d ( px , py ) ; context.setVariable(__v, v);
         body . execute ( context ) ;
         i ++ ;
         }
      }

   }

   public static class qt2_cellsearch extends StatementFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "qt";
            case 1: return "body";
            default: return null;
         }

      }

      public InputSignature getInputSignature(int i) {
         switch(i) {
            case 0: return new ExpressionInputSignature(QT2d.class);
            case 1: return new StatementListInputSignature();
            default: return null;
         }

      }

      public qt2_cellsearch() {
         addGroupMeta(this);
      }

      public int getNumberContextVariables() {
         return 8;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "mid";
            case 1: return "minx";
            case 2: return "midy";
            case 3: return "miny";
            case 4: return "maxx";
            case 5: return "midx";
            case 6: return "maxy";
            case 7: return "depth";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            case 4: return LDouble.class;
            case 5: return LDouble.class;
            case 6: return LDouble.class;
            case 7: return LDouble.class;
            default: return null;
         }

      }

      public void execute(Context context, List<GeneticComponent> inputs) {
         Expression qt = (Expression) inputs.get(0);
         StatementList body = (StatementList) inputs.get(1);
         final String __mid = getContextVariableActualName("mid");
         LVect2d mid;
         final String __minx = getContextVariableActualName("minx");
         LDouble minx;
         final String __midy = getContextVariableActualName("midy");
         LDouble midy;
         final String __miny = getContextVariableActualName("miny");
         LDouble miny;
         final String __maxx = getContextVariableActualName("maxx");
         LDouble maxx;
         final String __midx = getContextVariableActualName("midx");
         LDouble midx;
         final String __maxy = getContextVariableActualName("maxy");
         LDouble maxy;
         final String __depth = getContextVariableActualName("depth");
         LDouble depth;
         QT2d quadtree = ( QT2d ) qt . evaluate ( context ) ;
         List < Quadtree . TreeCell > cells = new ArrayList < Quadtree . TreeCell > ( ) ;
         cells . add ( quadtree . getTreeRoot ( ) ) ;
         while ( ! cells . isEmpty ( ) ) {
         Quadtree . TreeCell cell = cells . remove ( 0 ) ;
         depth = new LDouble ( ( double ) cell . getDepth ( ) / quadtree . getMaxDepth ( ) ) ; context.setVariable(__depth, depth);
         minx = new LDouble ( cell . getMinRangeX ( ) ) ; context.setVariable(__minx, minx);
         midx = new LDouble ( cell . getMidRangeX ( ) ) ; context.setVariable(__midx, midx);
         maxx = new LDouble ( cell . getMaxRangeX ( ) ) ; context.setVariable(__maxx, maxx);
         miny = new LDouble ( cell . getMinRangeY ( ) ) ; context.setVariable(__miny, miny);
         midy = new LDouble ( cell . getMidRangeY ( ) ) ; context.setVariable(__midy, midy);
         maxy = new LDouble ( cell . getMaxRangeY ( ) ) ; context.setVariable(__maxy, maxy);
         mid = new LVect2d ( cell . getMidRangeX ( ) , cell . getMidRangeY ( ) ) ; context.setVariable(__mid, mid);
         body . execute ( context ) ;
         if ( cell . getC00 ( ) != null ) cells . add ( cell . getC00 ( ) ) ;
         if ( cell . getC01 ( ) != null ) cells . add ( cell . getC01 ( ) ) ;
         if ( cell . getC10 ( ) != null ) cells . add ( cell . getC10 ( ) ) ;
         if ( cell . getC11 ( ) != null ) cells . add ( cell . getC11 ( ) ) ;
         }
      }

   }

   public static class qt_brute_2d extends StatementFunction {

      private Integer n;private LDouble radius;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return n;
            case 1: return radius;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "n";
            case 1: return "radius";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: n = (Integer) value; return;
            case 1: radius = (LDouble) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "qt";
            case 1: return "body";
            default: return null;
         }

      }

      public InputSignature getInputSignature(int i) {
         switch(i) {
            case 0: return new ExpressionInputSignature(QT2d.class);
            case 1: return new StatementListInputSignature();
            default: return null;
         }

      }

      public qt_brute_2d() {
         addGroupMeta(this);
         n = 20 + new Random ( ) . nextInt ( 20 ) ;
         radius = new LDouble ( .05 + .1 * Math . random ( ) ) ;
      }

      public String getDescription() {
         return "Loops n times in two dimensions. The parameter n is initialized to a value between 10 and 20.";
      }

      public int getNumberContextVariables() {
         return 5;
      }

      public String getContextVariableIntendedName(int i) {
         switch(i) {
            case 0: return "i";
            case 1: return "j";
            case 2: return "density";
            case 3: return "nearest";
            case 4: return "v";
            default: return null;
         }

      }

      public Class getContextVariableType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return Integer.class;
            case 2: return LDouble.class;
            case 3: return LDouble.class;
            case 4: return LVect2d.class;
            default: return null;
         }

      }

      public void execute(Context context, List<GeneticComponent> inputs) {
         Expression qt = (Expression) inputs.get(0);
         StatementList body = (StatementList) inputs.get(1);
         final String __i = getContextVariableActualName("i");
         Integer i;
         final String __j = getContextVariableActualName("j");
         Integer j;
         final String __density = getContextVariableActualName("density");
         LDouble density;
         final String __nearest = getContextVariableActualName("nearest");
         LDouble nearest;
         final String __v = getContextVariableActualName("v");
         LVect2d v;
         QT2d quadtree = ( QT2d ) qt . evaluate ( context ) ;
         i = 0 ; context.setVariable(__i, i);
         j = 0 ; context.setVariable(__j, j);
         while ( i < n ) {
         double x = 1.0 * i / n ;
         j = 0 ; context.setVariable(__j, j);
         while ( j < n ) {
         double y = 1.0 * j / n ;
         v = new LVect2d ( x , y ) ; context.setVariable(__v, v);
         List < APoint2d > points = quadtree . getContents ( x , y , radius . val ) ;
         if ( points . size ( ) > 0 ) {
         double dist = 1000 ;
         for ( APoint2d point : points ) {
         double dx = ( point . x - v . x ) ;
         double dy = ( point . y - v . y ) ;
         double d = Math . sqrt ( dx * dx + dy * dy ) ;
         dist = Math . min ( d , dist ) ;
         }
         nearest = new LDouble ( dist ) ; context.setVariable(__nearest, nearest);
         }
         else {
         nearest = new LDouble ( 0 ) ; context.setVariable(__nearest, nearest);
         }
         density = new LDouble ( 1.0 * points . size ( ) / quadtree . getMaxDensity ( ) ) ; context.setVariable(__density, density);
         body . execute ( context ) ;
         j = j + 1 ; context.setVariable(__j, j);
         }
         i = i + 1 ; context.setVariable(__i, i);
         }
      }

   }

   public String getDescription() {
      return "Loops and tree iterations through quadtrees.";
   }

   public List<StatementFunction> allInstances(ContextModel cm) {
      List<StatementFunction> r = new ArrayList<StatementFunction>();
      r.add(new qt2_treeorder());
      r.add(new qt2_cellsearch());
      r.add(new qt_brute_2d());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
