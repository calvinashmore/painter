package painter . functions . commands;

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
import java.awt.image.*;
import utils.linear.*;
import painter.tools.canvas.*;

public final class ImageOps implements AllComponents<Command>, Described {

   public static class ApplyOp extends Command {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "op";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return BufferedImageOp.class;
            default: return null;
         }

      }

      public ApplyOp() {
         addGroupMeta(this);
      }

      public void execute(Context context, Object[] inputs) {
         final BufferedImageOp op = (BufferedImageOp)inputs[0];
         Canvas canvas = ( Canvas ) context . getVariable ( "canvas" ) ;
         BufferedImage result = op . filter ( canvas . makeImage ( ) , null ) ;
         synchronized ( canvas . getGraphics ( ) ) {
         canvas . getGraphics ( ) . drawImage ( result , 0 , 0 , null ) ;
         }
      }

   }

   public String getDescription() {
      return "BufferedImage operation commands";
   }

   public List<Command> allInstances(ContextModel cm) {
      List<Command> r = new ArrayList<Command>();
      r.add(new ApplyOp());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
