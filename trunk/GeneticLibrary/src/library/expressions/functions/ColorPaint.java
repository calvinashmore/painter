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

public final class ColorPaint implements AllComponents<ExpressionFunction>, Described {

   public static class Pure extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "h";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public Pure() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble h = (LDouble)inputs[0];
         return ColorPainter . getColor ( h . val ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HueSat extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "s";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public HueSat() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble h = (LDouble)inputs[0];
         final LDouble s = (LDouble)inputs[1];
         Color val = ColorPainter . getColor ( h . val ) ;
         Color compliment = ColorPainter . getColor ( h . val + .5 ) ;
         return val . mult ( s . val ) . add ( compliment . mult ( 1 - s . val ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HueSat_gauss extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "s";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public HueSat_gauss() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble h = (LDouble)inputs[0];
         final LDouble s = (LDouble)inputs[1];
         Color val = ColorPainter . getColor ( h . val ) ;
         Color compliment = ColorPainter . getColor ( h . val + .5 ) ;
         double sat = Math . exp ( - s . val * s . val ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HueSat_sigmoid extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "s";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public HueSat_sigmoid() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble h = (LDouble)inputs[0];
         final LDouble s = (LDouble)inputs[1];
         Color val = ColorPainter . getColor ( h . val ) ;
         Color compliment = ColorPainter . getColor ( h . val + .5 ) ;
         double sat = 1 / ( 1.0 + Math . exp ( - s . val ) ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HueSat_gauss01 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "s";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public HueSat_gauss01() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble h = (LDouble)inputs[0];
         final LDouble s = (LDouble)inputs[1];
         Color val = ColorPainter . getColor ( h . val ) ;
         Color compliment = ColorPainter . getColor ( h . val + .5 ) ;
         double sat = .5 + .5 * Math . exp ( - s . val * s . val ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HueSat_sigmoid01 extends ExpressionFunction {

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "s";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public HueSat_sigmoid01() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble h = (LDouble)inputs[0];
         final LDouble s = (LDouble)inputs[1];
         Color val = ColorPainter . getColor ( h . val ) ;
         Color compliment = ColorPainter . getColor ( h . val + .5 ) ;
         double sat = .5 + .5 * 1 / ( 1.0 + Math . exp ( - s . val ) ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HueSat_v2 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hs";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public HueSat_v2() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect2d hs = (LVect2d)inputs[0];
         Color val = ColorPainter . getColor ( hs . x ) ;
         Color compliment = ColorPainter . getColor ( hs . x + .5 ) ;
         return val . mult ( hs . y ) . add ( compliment . mult ( 1 - hs . y ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HueSat_v2_gauss extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hs";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public HueSat_v2_gauss() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect2d hs = (LVect2d)inputs[0];
         Color val = ColorPainter . getColor ( hs . x ) ;
         Color compliment = ColorPainter . getColor ( hs . x + .5 ) ;
         double sat = Math . exp ( - hs . y * hs . y ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HueSat_v2_sigmoid extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hs";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public HueSat_v2_sigmoid() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect2d hs = (LVect2d)inputs[0];
         Color val = ColorPainter . getColor ( hs . x ) ;
         Color compliment = ColorPainter . getColor ( hs . x + .5 ) ;
         double sat = 1 / ( 1.0 + Math . exp ( - hs . y ) ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HueSat_v2_gauss01 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hs";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public HueSat_v2_gauss01() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect2d hs = (LVect2d)inputs[0];
         Color val = ColorPainter . getColor ( hs . x ) ;
         Color compliment = ColorPainter . getColor ( hs . x + .5 ) ;
         double sat = .5 + .5 * Math . exp ( - hs . y * hs . y ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class HueSat_v2_sigmoid01 extends ExpressionFunction {

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hs";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public HueSat_v2_sigmoid01() {
         addGroupMeta(this);
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect2d hs = (LVect2d)inputs[0];
         Color val = ColorPainter . getColor ( hs . x ) ;
         Color compliment = ColorPainter . getColor ( hs . x + .5 ) ;
         double sat = .5 + .5 / ( 1.0 + Math . exp ( - hs . y ) ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Hue extends ExpressionFunction {

      private double s;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return s;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "s";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: s = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "h";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public Hue() {
         addGroupMeta(this);
         s = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble h = (LDouble)inputs[0];
         Color val = ColorPainter . getColor ( h . val ) ;
         Color compliment = ColorPainter . getColor ( h . val + .5 ) ;
         return val . mult ( s ) . add ( compliment . mult ( 1 - s ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Sat extends ExpressionFunction {

      private double h;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "s";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public Sat() {
         addGroupMeta(this);
         h = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble s = (LDouble)inputs[0];
         Color val = ColorPainter . getColor ( h ) ;
         Color compliment = ColorPainter . getColor ( h + .5 ) ;
         return val . mult ( s . val ) . add ( compliment . mult ( 1 - s . val ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Sat_sigmoid extends ExpressionFunction {

      private double h;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "s";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public Sat_sigmoid() {
         addGroupMeta(this);
         h = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble s = (LDouble)inputs[0];
         Color val = ColorPainter . getColor ( h ) ;
         Color compliment = ColorPainter . getColor ( h + .5 ) ;
         double sat = 1 / Math . exp ( 1 + s . val ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Sat_gauss01 extends ExpressionFunction {

      private double h;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "s";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public Sat_gauss01() {
         addGroupMeta(this);
         h = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble s = (LDouble)inputs[0];
         Color val = ColorPainter . getColor ( h ) ;
         Color compliment = ColorPainter . getColor ( h + .5 ) ;
         double sat = .5 + .5 * Math . exp ( - s . val * s . val ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Sat_near extends ExpressionFunction {

      private double h;private double offset;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return offset;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "offset";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: offset = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "s";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public Sat_near() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         offset = Math . random ( ) / 3 - 1.0 / 6 ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble s = (LDouble)inputs[0];
         Color val = ColorPainter . getColor ( h ) ;
         Color compliment = ColorPainter . getColor ( h + .5 + offset ) ;
         return val . mult ( s . val ) . add ( compliment . mult ( 1 - s . val ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Sat_near_sigmoid extends ExpressionFunction {

      private double h;private double offset;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return offset;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "offset";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: offset = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "s";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public Sat_near_sigmoid() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         offset = Math . random ( ) / 3 - 1.0 / 6 ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble s = (LDouble)inputs[0];
         Color val = ColorPainter . getColor ( h ) ;
         Color compliment = ColorPainter . getColor ( h + .5 + offset ) ;
         double sat = .5 + .5 * Math . exp ( - s . val * s . val ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Secondaries_h extends ExpressionFunction {

      private double h;private double s;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return s;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "s";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: s = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hbias";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public Secondaries_h() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         s = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble hbias = (LDouble)inputs[0];
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ;
         return val . mult ( s ) . add ( compliment . mult ( 1 - s ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Secondaries_hs extends ExpressionFunction {

      private double h;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hbias";
            case 1: return "s";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Secondaries_hs() {
         addGroupMeta(this);
         h = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble hbias = (LDouble)inputs[0];
         final LDouble s = (LDouble)inputs[1];
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ;
         return val . mult ( s . val ) . add ( compliment . mult ( 1 - s . val ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Secondaries_hs_gauss extends ExpressionFunction {

      private double h;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hbias";
            case 1: return "s";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Secondaries_hs_gauss() {
         addGroupMeta(this);
         h = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble hbias = (LDouble)inputs[0];
         final LDouble s = (LDouble)inputs[1];
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ;
         double sat = Math . exp ( - s . val * s . val ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Secondaries_hs_sigmoid extends ExpressionFunction {

      private double h;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hbias";
            case 1: return "s";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Secondaries_hs_sigmoid() {
         addGroupMeta(this);
         h = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble hbias = (LDouble)inputs[0];
         final LDouble s = (LDouble)inputs[1];
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ;
         double sat = 1 / Math . exp ( 1 + s . val ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Secondaries_hs_gauss01 extends ExpressionFunction {

      private double h;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hbias";
            case 1: return "s";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Secondaries_hs_gauss01() {
         addGroupMeta(this);
         h = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble hbias = (LDouble)inputs[0];
         final LDouble s = (LDouble)inputs[1];
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ;
         double sat = .5 + .5 * Math . exp ( - s . val * s . val ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Secondaries_hs_sigmoid01 extends ExpressionFunction {

      private double h;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hbias";
            case 1: return "s";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Secondaries_hs_sigmoid01() {
         addGroupMeta(this);
         h = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble hbias = (LDouble)inputs[0];
         final LDouble s = (LDouble)inputs[1];
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ;
         double sat = .5 + .5 * 1 / Math . exp ( 1 + s . val ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Secondaries_hs_v2 extends ExpressionFunction {

      private double h;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Secondaries_hs_v2() {
         addGroupMeta(this);
         h = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         double hue_bias = Math . max ( Math . min ( x . x , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ;
         return val . mult ( x . y ) . add ( compliment . mult ( 1 - x . y ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Secondaries_hs_v2_gauss extends ExpressionFunction {

      private double h;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Secondaries_hs_v2_gauss() {
         addGroupMeta(this);
         h = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         double hue_bias = Math . max ( Math . min ( x . x , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ;
         double sat = Math . exp ( - x . y * x . y ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Secondaries_hs_v2_sigmoid extends ExpressionFunction {

      private double h;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Secondaries_hs_v2_sigmoid() {
         addGroupMeta(this);
         h = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         double hue_bias = Math . max ( Math . min ( x . x , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ;
         double sat = 1 / Math . exp ( 1 + x . y ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Secondaries_hs_v2_gauss01 extends ExpressionFunction {

      private double h;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Secondaries_hs_v2_gauss01() {
         addGroupMeta(this);
         h = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         double hue_bias = Math . max ( Math . min ( x . x , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ;
         double sat = .5 + .5 * Math . exp ( - x . y * x . y ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Secondaries_hs_v2_sigmoid01 extends ExpressionFunction {

      private double h;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Secondaries_hs_v2_sigmoid01() {
         addGroupMeta(this);
         h = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         double hue_bias = Math . max ( Math . min ( x . x , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ;
         double sat = .5 + .5 * 1 / Math . exp ( 1 + x . y ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Arc_h extends ExpressionFunction {

      private double h;private double s;private double arc;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return s;
            case 2: return arc;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "s";
            case 2: return "arc";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            case 2: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: s = (Double) value; return;
            case 2: arc = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hbias";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public Arc_h() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         s = Math . random ( ) ;
         arc = Math . random ( ) / 6 ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble hbias = (LDouble)inputs[0];
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + arc * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ;
         return val . mult ( s ) . add ( compliment . mult ( 1 - s ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Arc_hs extends ExpressionFunction {

      private double h;private double arc;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return arc;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "arc";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: arc = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hbias";
            case 1: return "s";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Arc_hs() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         arc = Math . random ( ) / 6 ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble hbias = (LDouble)inputs[0];
         final LDouble s = (LDouble)inputs[1];
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + arc * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ;
         return val . mult ( s . val ) . add ( compliment . mult ( 1 - s . val ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Arc_hs_gauss extends ExpressionFunction {

      private double h;private double arc;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return arc;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "arc";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: arc = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hbias";
            case 1: return "s";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Arc_hs_gauss() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         arc = Math . random ( ) / 6 ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble hbias = (LDouble)inputs[0];
         final LDouble s = (LDouble)inputs[1];
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + arc * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ;
         double sat = Math . exp ( - s . val * s . val ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Arc_hs_sigmoid extends ExpressionFunction {

      private double h;private double arc;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return arc;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "arc";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: arc = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hbias";
            case 1: return "s";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Arc_hs_sigmoid() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         arc = Math . random ( ) / 6 ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble hbias = (LDouble)inputs[0];
         final LDouble s = (LDouble)inputs[1];
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + arc * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ;
         double sat = 1 / Math . exp ( 1 + s . val ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Arc_hs_gauss01 extends ExpressionFunction {

      private double h;private double arc;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return arc;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "arc";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: arc = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hbias";
            case 1: return "s";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Arc_hs_gauss01() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         arc = Math . random ( ) / 6 ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble hbias = (LDouble)inputs[0];
         final LDouble s = (LDouble)inputs[1];
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + arc * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ;
         double sat = .5 + .5 * Math . exp ( - s . val * s . val ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Arc_hs_sigmoid01 extends ExpressionFunction {

      private double h;private double arc;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return arc;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "arc";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: arc = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "hbias";
            case 1: return "s";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public Arc_hs_sigmoid01() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         arc = Math . random ( ) / 6 ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble hbias = (LDouble)inputs[0];
         final LDouble s = (LDouble)inputs[1];
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + arc * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ;
         double sat = .5 + .5 * 1 / Math . exp ( 1 + s . val ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Arc_hs_v2 extends ExpressionFunction {

      private double h;private double arc;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return arc;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "arc";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: arc = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Arc_hs_v2() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         arc = Math . random ( ) / 6 ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         double hue_bias = Math . max ( Math . min ( x . x , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + arc * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ;
         return val . mult ( x . y ) . add ( compliment . mult ( 1 - x . y ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Arc_hs_v2_gauss extends ExpressionFunction {

      private double h;private double arc;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return arc;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "arc";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: arc = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Arc_hs_v2_gauss() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         arc = Math . random ( ) / 6 ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         double hue_bias = Math . max ( Math . min ( x . x , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + arc * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ;
         double sat = Math . exp ( - x . y * x . y ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Arc_hs_v2_sigmoid extends ExpressionFunction {

      private double h;private double arc;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return arc;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "arc";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: arc = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Arc_hs_v2_sigmoid() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         arc = Math . random ( ) / 6 ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         double hue_bias = Math . max ( Math . min ( x . x , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + arc * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ;
         double sat = 1 / Math . exp ( 1 + x . y ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Arc_hs_v2_gauss01 extends ExpressionFunction {

      private double h;private double arc;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return arc;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "arc";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: arc = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Arc_hs_v2_gauss01() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         arc = Math . random ( ) / 6 ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         double hue_bias = Math . max ( Math . min ( x . x , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + arc * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ;
         double sat = .5 + .5 * Math . exp ( - x . y * x . y ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Arc_hs_v2_sigmoid01 extends ExpressionFunction {

      private double h;private double arc;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return arc;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "arc";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: arc = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public Arc_hs_v2_sigmoid01() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         arc = Math . random ( ) / 6 ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         double hue_bias = Math . max ( Math . min ( x . x , 1 ) , - 1 ) ;
         Color val = ColorPainter . getColor ( h + arc * hue_bias ) ;
         Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ;
         double sat = .5 + .5 * 1 / Math . exp ( 1 + x . y ) ;
         return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class Chord_h extends ExpressionFunction {

      private double h1;private double h2;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h1;
            case 1: return h2;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h1";
            case 1: return "h2";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h1 = (Double) value; return;
            case 1: h2 = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public Chord_h() {
         addGroupMeta(this);
         h1 = Math . random ( ) ;
         h2 = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble v = (LDouble)inputs[0];
         Color v1 = ColorPainter . getColor ( h1 ) ;
         Color v2 = ColorPainter . getColor ( h2 ) ;
         return v1 . mult ( v . val ) . add ( v2 . mult ( 1 - v . val ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class MotherColor extends ExpressionFunction {

      private double h;private double h0;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return h0;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "h0";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: h0 = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "u";
            case 1: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public MotherColor() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         h0 = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble u = (LDouble)inputs[0];
         final LDouble v = (LDouble)inputs[1];
         Color c1 = ColorPainter . getColor ( h - h0 / 6 ) ;
         Color c2 = ColorPainter . getColor ( h + 1.0 / 6 - h0 / 6 ) ;
         Color c3 = ColorPainter . getColor ( h + .5 ) ;
         Color c4 = c1 . mult ( u . val ) . add ( c2 . mult ( 1 - u . val ) ) ;
         return c4 . mult ( v . val ) . add ( c3 . mult ( 1 - v . val ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class MotherColor_gauss extends ExpressionFunction {

      private double h;private double h0;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return h0;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "h0";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: h0 = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "u";
            case 1: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public MotherColor_gauss() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         h0 = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble u = (LDouble)inputs[0];
         final LDouble v = (LDouble)inputs[1];
         Color c1 = ColorPainter . getColor ( h - h0 / 6 ) ;
         Color c2 = ColorPainter . getColor ( h + 1.0 / 6 - h0 / 6 ) ;
         Color c3 = ColorPainter . getColor ( h + .5 ) ;
         Color c4 = c1 . mult ( u . val ) . add ( c2 . mult ( 1 - u . val ) ) ;
         double sat = Math . exp ( - v . val * v . val ) ;
         return c4 . mult ( sat ) . add ( c3 . mult ( sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class MotherColor_gauss1 extends ExpressionFunction {

      private double h;private double h0;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return h0;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "h0";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: h0 = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "u";
            case 1: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public MotherColor_gauss1() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         h0 = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble u = (LDouble)inputs[0];
         final LDouble v = (LDouble)inputs[1];
         Color c1 = ColorPainter . getColor ( h - h0 / 6 ) ;
         Color c2 = ColorPainter . getColor ( h + 1.0 / 6 - h0 / 6 ) ;
         Color c3 = ColorPainter . getColor ( h + .5 ) ;
         Color c4 = c1 . mult ( u . val ) . add ( c2 . mult ( 1 - u . val ) ) ;
         double sat = 1 - Math . exp ( - v . val * v . val ) ;
         return c4 . mult ( sat ) . add ( c3 . mult ( sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class MotherColor_sigmoid extends ExpressionFunction {

      private double h;private double h0;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return h0;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "h0";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: h0 = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "u";
            case 1: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public MotherColor_sigmoid() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         h0 = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LDouble u = (LDouble)inputs[0];
         final LDouble v = (LDouble)inputs[1];
         Color c1 = ColorPainter . getColor ( h - h0 / 6 ) ;
         Color c2 = ColorPainter . getColor ( h + 1.0 / 6 - h0 / 6 ) ;
         Color c3 = ColorPainter . getColor ( h + .5 ) ;
         Color c4 = c1 . mult ( u . val ) . add ( c2 . mult ( 1 - u . val ) ) ;
         double sat = 1 / Math . exp ( 1 + v . val ) ;
         return c4 . mult ( sat ) . add ( c3 . mult ( sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class MotherColor_v2 extends ExpressionFunction {

      private double h;private double h0;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return h0;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "h0";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: h0 = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public MotherColor_v2() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         h0 = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         Color c1 = ColorPainter . getColor ( h - h0 / 6 ) ;
         Color c2 = ColorPainter . getColor ( h + 1.0 / 6 - h0 / 6 ) ;
         Color c3 = ColorPainter . getColor ( h + .5 ) ;
         Color c4 = c1 . mult ( x . x ) . add ( c2 . mult ( 1 - x . x ) ) ;
         return c4 . mult ( x . y ) . add ( c3 . mult ( 1 - x . y ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class MotherColor_v2_gauss extends ExpressionFunction {

      private double h;private double h0;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return h0;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "h0";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: h0 = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public MotherColor_v2_gauss() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         h0 = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         Color c1 = ColorPainter . getColor ( h - h0 / 6 ) ;
         Color c2 = ColorPainter . getColor ( h + 1.0 / 6 - h0 / 6 ) ;
         Color c3 = ColorPainter . getColor ( h + .5 ) ;
         Color c4 = c1 . mult ( x . x ) . add ( c2 . mult ( 1 - x . x ) ) ;
         double sat = Math . exp ( - x . y * x . y ) ;
         return c4 . mult ( sat ) . add ( c3 . mult ( sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class MotherColor_v2_gauss1 extends ExpressionFunction {

      private double h;private double h0;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return h0;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "h0";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: h0 = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public MotherColor_v2_gauss1() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         h0 = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         Color c1 = ColorPainter . getColor ( h - h0 / 6 ) ;
         Color c2 = ColorPainter . getColor ( h + 1.0 / 6 - h0 / 6 ) ;
         Color c3 = ColorPainter . getColor ( h + .5 ) ;
         Color c4 = c1 . mult ( x . x ) . add ( c2 . mult ( 1 - x . x ) ) ;
         double sat = 1 - Math . exp ( - x . y * x . y ) ;
         return c4 . mult ( sat ) . add ( c3 . mult ( sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class MotherColor_v2_sigmoid extends ExpressionFunction {

      private double h;private double h0;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return h;
            case 1: return h0;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "h";
            case 1: return "h0";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: h = (Double) value; return;
            case 1: h0 = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "x";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            default: return null;
         }

      }

      public MotherColor_v2_sigmoid() {
         addGroupMeta(this);
         h = Math . random ( ) ;
         h0 = Math . random ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {
         final LVect2d x = (LVect2d)inputs[0];
         Color c1 = ColorPainter . getColor ( h - h0 / 6 ) ;
         Color c2 = ColorPainter . getColor ( h + 1.0 / 6 - h0 / 6 ) ;
         Color c3 = ColorPainter . getColor ( h + .5 ) ;
         Color c4 = c1 . mult ( x . x ) . add ( c2 . mult ( 1 - x . x ) ) ;
         double sat = 1 / Math . exp ( 1 + x . y ) ;
         return c4 . mult ( sat ) . add ( c3 . mult ( sat ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public String getDescription() {
      return "Color painting";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new Pure());
      r.add(new HueSat());
      r.add(new HueSat_gauss());
      r.add(new HueSat_sigmoid());
      r.add(new HueSat_gauss01());
      r.add(new HueSat_sigmoid01());
      r.add(new HueSat_v2());
      r.add(new HueSat_v2_gauss());
      r.add(new HueSat_v2_sigmoid());
      r.add(new HueSat_v2_gauss01());
      r.add(new HueSat_v2_sigmoid01());
      r.add(new Hue());
      r.add(new Sat());
      r.add(new Sat_sigmoid());
      r.add(new Sat_gauss01());
      r.add(new Sat_near());
      r.add(new Sat_near_sigmoid());
      r.add(new Secondaries_h());
      r.add(new Secondaries_hs());
      r.add(new Secondaries_hs_gauss());
      r.add(new Secondaries_hs_sigmoid());
      r.add(new Secondaries_hs_gauss01());
      r.add(new Secondaries_hs_sigmoid01());
      r.add(new Secondaries_hs_v2());
      r.add(new Secondaries_hs_v2_gauss());
      r.add(new Secondaries_hs_v2_sigmoid());
      r.add(new Secondaries_hs_v2_gauss01());
      r.add(new Secondaries_hs_v2_sigmoid01());
      r.add(new Arc_h());
      r.add(new Arc_hs());
      r.add(new Arc_hs_gauss());
      r.add(new Arc_hs_sigmoid());
      r.add(new Arc_hs_gauss01());
      r.add(new Arc_hs_sigmoid01());
      r.add(new Arc_hs_v2());
      r.add(new Arc_hs_v2_gauss());
      r.add(new Arc_hs_v2_sigmoid());
      r.add(new Arc_hs_v2_gauss01());
      r.add(new Arc_hs_v2_sigmoid01());
      r.add(new Chord_h());
      r.add(new MotherColor());
      r.add(new MotherColor_gauss());
      r.add(new MotherColor_gauss1());
      r.add(new MotherColor_sigmoid());
      r.add(new MotherColor_v2());
      r.add(new MotherColor_v2_gauss());
      r.add(new MotherColor_v2_gauss1());
      r.add(new MotherColor_v2_sigmoid());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
