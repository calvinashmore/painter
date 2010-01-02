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
import utils.ifs.*;

public final class IFSExpressions implements AllComponents<ExpressionFunction>, Described {

   public static class LinearIFS_v2 extends ExpressionFunction {
      private IFSUtil . IFS_v2 ifs ;private Random random ;private Mapping < LVect2d > createMapping ( ) { double contractScale = .9 ; double contractOffset = .3 ; return new LinearMapping_v2 ( contractScale * ( 2 * random . nextDouble ( ) - 1 ) , contractScale * ( 2 * random . nextDouble ( ) - 1 ) , contractOffset * ( 2 * random . nextDouble ( ) - 1 ) , contractScale * ( 2 * random . nextDouble ( ) - 1 ) , contractScale * ( 2 * random . nextDouble ( ) - 1 ) , contractOffset * ( 2 * random . nextDouble ( ) - 1 ) ) ; }
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
         ifs = new IFSUtil . IFS_v2 ( ) ;
         int samples = 2 + random . nextInt ( 3 ) ;
         for ( int i = 0 ;
         i < samples ;
         i ++ ) {
         Mapping < LVect2d > mapping = createMapping ( ) ;
         double weight = random . nextDouble ( ) ;
         ifs . addMapping ( mapping , weight ) ;
         }
      }

      public LinearIFS_v2() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public IFSUtil . IFS_v2 evaluate(Context context, Object[] inputs) {

         return ifs ;
      }

      public Class getReturnType() {
         return IFSUtil . IFS_v2.class;
      }

   }

   public static class FlameIFS_3_v2 extends ExpressionFunction {
      private Random random ;private Mapping < LVect2d > wrapMapping ( Mapping < LVect2d > mapping ) { double contractScale = .9 ; double contractOffset = .3 ; return new LinearWrap_v2 ( mapping , contractScale * ( 2 * random . nextDouble ( ) - 1 ) , contractScale * ( 2 * random . nextDouble ( ) - 1 ) , contractOffset * ( 2 * random . nextDouble ( ) - 1 ) , contractScale * ( 2 * random . nextDouble ( ) - 1 ) , contractScale * ( 2 * random . nextDouble ( ) - 1 ) , contractOffset * ( 2 * random . nextDouble ( ) - 1 ) ) ; }
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

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "map1";
            case 1: return "map2";
            case 2: return "map3";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return IFSUtil . Mapping_v2.class;
            case 1: return IFSUtil . Mapping_v2.class;
            case 2: return IFSUtil . Mapping_v2.class;
            default: return null;
         }

      }

      public void setup() throws BuildException {
         super.setup();
         random = new Random ( seed ) ;
      }

      public FlameIFS_3_v2() {
         addGroupMeta(this);
         Random rand = new Random ( ) ;
         seed = rand . nextInt ( ) ;
      }

      public IFSUtil . IFS_v2 evaluate(Context context, Object[] inputs) {
         final IFSUtil . Mapping_v2 map1 = (IFSUtil . Mapping_v2)inputs[0];
         final IFSUtil . Mapping_v2 map2 = (IFSUtil . Mapping_v2)inputs[1];
         final IFSUtil . Mapping_v2 map3 = (IFSUtil . Mapping_v2)inputs[2];
         IFSUtil . IFS_v2 ifs = new IFSUtil . IFS_v2 ( ) ;
         ifs . addMapping ( wrapMapping ( map1 ) , random . nextDouble ( ) ) ;
         ifs . addMapping ( wrapMapping ( map2 ) , random . nextDouble ( ) ) ;
         ifs . addMapping ( wrapMapping ( map3 ) , random . nextDouble ( ) ) ;
         return ifs ;
      }

      public Class getReturnType() {
         return IFSUtil . IFS_v2.class;
      }

   }

   public String getDescription() {
      return "expressions for IFS systems";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new LinearIFS_v2());
      r.add(new FlameIFS_3_v2());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
