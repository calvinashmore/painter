package library . expressions . functions;

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

public final class Randoms implements AllComponents<ExpressionFunction>, Described {

   public static class Random_d extends ExpressionFunction {
      private Random random ;
      private Integer seed;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return seed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "seed";
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
            case 0: seed = (Integer) value; return;
            default: return;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         random = new Random ( seed ) ;
      }

      public Random_d() {
         addGroupMeta(this);
         Random rand1 = new Random ( ) ;
         seed = rand1 . nextInt ( ) ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {

         return new LDouble ( random . nextDouble ( ) * 2 - 1 ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Random_i extends ExpressionFunction {
      private Random random ;
      private Integer seed;private Integer limit;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return seed;
            case 1: return limit;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "seed";
            case 1: return "limit";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Integer.class;
            case 1: return Integer.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: seed = (Integer) value; return;
            case 1: limit = (Integer) value; return;
            default: return;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         random = new Random ( seed ) ;
      }

      public Random_i() {
         addGroupMeta(this);
         Random rand1 = new Random ( ) ;
         seed = rand1 . nextInt ( ) ;
         limit = 10 + rand1 . nextInt ( 100 ) ;
      }

      public Integer evaluate(Context context, Object[] inputs) {

         return random . nextInt ( limit ) ;
      }

      public Class getReturnType() {
         return Integer.class;
      }

   }

   public static class Random_bool extends ExpressionFunction {
      private Random random ;
      private Integer seed;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return seed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "seed";
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
            case 0: seed = (Integer) value; return;
            default: return;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         random = new Random ( seed ) ;
      }

      public Random_bool() {
         addGroupMeta(this);
         Random rand1 = new Random ( ) ;
         seed = rand1 . nextInt ( ) ;
      }

      public Boolean evaluate(Context context, Object[] inputs) {

         return random . nextBoolean ( ) ;
      }

      public Class getReturnType() {
         return Boolean.class;
      }

   }

   public static class Random_v2 extends ExpressionFunction {
      private Random random ;
      private Integer seed;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return seed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "seed";
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
            case 0: seed = (Integer) value; return;
            default: return;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         random = new Random ( seed ) ;
      }

      public Random_v2() {
         addGroupMeta(this);
         Random rand1 = new Random ( ) ;
         seed = rand1 . nextInt ( ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {

         return new LVect2d ( random . nextDouble ( ) * 2 - 1 , random . nextDouble ( ) * 2 - 1 ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class Random_v3 extends ExpressionFunction {
      private Random random ;
      private Integer seed;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return seed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "seed";
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
            case 0: seed = (Integer) value; return;
            default: return;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         random = new Random ( seed ) ;
      }

      public Random_v3() {
         addGroupMeta(this);
         Random rand1 = new Random ( ) ;
         seed = rand1 . nextInt ( ) ;
      }

      public LVect3d evaluate(Context context, Object[] inputs) {

         return new LVect3d ( random . nextDouble ( ) * 2 - 1 , random . nextDouble ( ) * 2 - 1 , random . nextDouble ( ) * 2 - 1 ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class Random_col extends ExpressionFunction {
      private Random random ;
      private Integer seed;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return seed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "seed";
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
            case 0: seed = (Integer) value; return;
            default: return;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         random = new Random ( seed ) ;
      }

      public Random_col() {
         addGroupMeta(this);
         Random rand1 = new Random ( ) ;
         seed = rand1 . nextInt ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {

         return new Color ( random . nextDouble ( ) , random . nextDouble ( ) , random . nextDouble ( ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public String getDescription() {
      return "Expressions that generate random numbers. These are based on seeds, so they can be reproduced.";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new Random_d());
      r.add(new Random_i());
      r.add(new Random_bool());
      r.add(new Random_v2());
      r.add(new Random_v3());
      r.add(new Random_col());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
