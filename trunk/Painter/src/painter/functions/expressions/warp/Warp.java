package painter . functions . expressions . warp;

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
import painter.foundation.warp.*;

public final class Warp implements AllComponents<ExpressionFunction>, Described {

   public static class warp_d_d extends WarpFunction < LDouble , LDouble > {
      public Class getVariableType ( ) { return LDouble . class ; }public LDouble warp ( LDouble value ) { return new LDouble ( offset . val + scale . val * value . val ) ; }
      private LDouble offset;private LDouble scale;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return offset;
            case 1: return scale;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "offset";
            case 1: return "scale";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            case 1: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: offset = (LDouble) value; return;
            case 1: scale = (LDouble) value; return;
            default: return;
         }

      }

      public warp_d_d() {
         addGroupMeta(this);
         offset = new LDouble ( 2 * Math . random ( ) - 1 ) ;
         scale = new LDouble ( 2 * Math . random ( ) - 1 ) ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {

         return super . evaluate ( context ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class warp_d_v2_line extends WarpFunction < LDouble , LVect2d > {
      public Class getVariableType ( ) { return LDouble . class ; }public LVect2d warp ( LDouble value ) { return center . add ( direction . mult ( value . val ) ) ; }
      private LVect2d center;private LVect2d direction;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return center;
            case 1: return direction;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "center";
            case 1: return "direction";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: center = (LVect2d) value; return;
            case 1: direction = (LVect2d) value; return;
            default: return;
         }

      }

      public warp_d_v2_line() {
         addGroupMeta(this);
         center = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         direction = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         direction . normalv ( ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {

         return super . evaluate ( context ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class warp_d_v2_circle extends WarpFunction < LDouble , LVect2d > {
      public Class getVariableType ( ) { return LDouble . class ; }public LVect2d warp ( LDouble value ) { LVect2d pos = new LVect2d ( ) ; double t = 2 * Math . PI * ( value . val + offset . val ) ; pos . x = center . x + radius . val * Math . cos ( t ) ; pos . y = center . y + radius . val * Math . sin ( t ) ; return pos ; }
      private LVect2d center;private LDouble radius;private LDouble offset;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return center;
            case 1: return radius;
            case 2: return offset;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "center";
            case 1: return "radius";
            case 2: return "offset";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: center = (LVect2d) value; return;
            case 1: radius = (LDouble) value; return;
            case 2: offset = (LDouble) value; return;
            default: return;
         }

      }

      public warp_d_v2_circle() {
         addGroupMeta(this);
         center = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         radius = new LDouble ( .2 + .8 * Math . random ( ) ) ;
         offset = new LDouble ( Math . random ( ) ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {

         return super . evaluate ( context ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class warp_v2_v2 extends WarpFunction < LVect2d , LVect2d > {
      public Class getVariableType ( ) { return LVect2d . class ; }public LVect2d warp ( LVect2d value ) { double x = a . dot ( value ) ; double y = b . dot ( value ) ; double z = c . dot ( value ) ; return new LVect2d ( x + z , y + z ) ; }
      private LVect2d a;private LVect2d b;private LVect2d c;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            case 1: return b;
            case 2: return c;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            case 2: return "c";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (LVect2d) value; return;
            case 1: b = (LVect2d) value; return;
            case 2: c = (LVect2d) value; return;
            default: return;
         }

      }

      public warp_v2_v2() {
         addGroupMeta(this);
         a = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         b = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         c = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
      }

      public LVect2d evaluate(Context context, Object[] inputs) {

         return super . evaluate ( context ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class warp_d_c_line extends WarpFunction < LDouble , Complex > {
      public Class getVariableType ( ) { return LDouble . class ; }public Complex warp ( LDouble value ) { return center . add ( direction . mult ( value . val ) ) ; }
      private Complex center;private Complex direction;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return center;
            case 1: return direction;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "center";
            case 1: return "direction";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Complex.class;
            case 1: return Complex.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: center = (Complex) value; return;
            case 1: direction = (Complex) value; return;
            default: return;
         }

      }

      public warp_d_c_line() {
         addGroupMeta(this);
         center = new Complex ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         direction = new Complex ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         direction . normalv ( ) ;
      }

      public Complex evaluate(Context context, Object[] inputs) {

         return super . evaluate ( context ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class warp_d_c_circle extends WarpFunction < LDouble , Complex > {
      public Class getVariableType ( ) { return LDouble . class ; }public Complex warp ( LDouble value ) { Complex pos = new Complex ( ) ; double t = 2 * Math . PI * ( value . val + offset . val ) ; pos . x = center . x + radius . val * Math . cos ( t ) ; pos . y = center . y + radius . val * Math . sin ( t ) ; return pos ; }
      private Complex center;private LDouble radius;private LDouble offset;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return center;
            case 1: return radius;
            case 2: return offset;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "center";
            case 1: return "radius";
            case 2: return "offset";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Complex.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: center = (Complex) value; return;
            case 1: radius = (LDouble) value; return;
            case 2: offset = (LDouble) value; return;
            default: return;
         }

      }

      public warp_d_c_circle() {
         addGroupMeta(this);
         center = new Complex ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         radius = new LDouble ( .2 + .8 * Math . random ( ) ) ;
         offset = new LDouble ( Math . random ( ) ) ;
      }

      public Complex evaluate(Context context, Object[] inputs) {

         return super . evaluate ( context ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class warp_v2_c extends WarpFunction < LVect2d , Complex > {
      public Class getVariableType ( ) { return LVect2d . class ; }public Complex warp ( LVect2d value ) { double x = a . dot ( value ) ; double y = b . dot ( value ) ; double z = c . dot ( value ) ; return new Complex ( x + z , y + z ) ; }
      private LVect2d a;private LVect2d b;private LVect2d c;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            case 1: return b;
            case 2: return c;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            case 2: return "c";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect2d.class;
            case 1: return LVect2d.class;
            case 2: return LVect2d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (LVect2d) value; return;
            case 1: b = (LVect2d) value; return;
            case 2: c = (LVect2d) value; return;
            default: return;
         }

      }

      public warp_v2_c() {
         addGroupMeta(this);
         a = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         b = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         c = new LVect2d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
      }

      public Complex evaluate(Context context, Object[] inputs) {

         return super . evaluate ( context ) ;
      }

      public Class getReturnType() {
         return Complex.class;
      }

   }

   public static class warp_d_v3_line extends WarpFunction < LDouble , LVect3d > {
      public Class getVariableType ( ) { return LDouble . class ; }public LVect3d warp ( LDouble value ) { return center . add ( direction . mult ( value . val ) ) ; }
      private LVect3d center;private LVect3d direction;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return center;
            case 1: return direction;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "center";
            case 1: return "direction";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: center = (LVect3d) value; return;
            case 1: direction = (LVect3d) value; return;
            default: return;
         }

      }

      public warp_d_v3_line() {
         addGroupMeta(this);
         center = new LVect3d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         direction = new LVect3d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         direction . normalv ( ) ;
      }

      public LVect3d evaluate(Context context, Object[] inputs) {

         return super . evaluate ( context ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class warp_v2_v3_plane extends WarpFunction < LVect2d , LVect3d > {
      public Class getVariableType ( ) { return LVect2d . class ; }public LVect3d warp ( LVect2d value ) { return center . add ( u . mult ( value . x ) ) . add ( v . mult ( value . y ) ) ; }
      private LVect3d center;private LVect3d u;private LVect3d v;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return center;
            case 1: return u;
            case 2: return v;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "center";
            case 1: return "u";
            case 2: return "v";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return LVect3d.class;
            case 1: return LVect3d.class;
            case 2: return LVect3d.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: center = (LVect3d) value; return;
            case 1: u = (LVect3d) value; return;
            case 2: v = (LVect3d) value; return;
            default: return;
         }

      }

      public warp_v2_v3_plane() {
         addGroupMeta(this);
         center = new LVect3d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         u = new LVect3d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         v = new LVect3d ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         u . normalv ( ) ;
         v . normalv ( ) ;
      }

      public LVect3d evaluate(Context context, Object[] inputs) {

         return super . evaluate ( context ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class warp_d_col_line_rgb extends WarpFunction < LDouble , Color > {
      public Class getVariableType ( ) { return LDouble . class ; }public Color warp ( LDouble value ) { return center . add ( direction . mult ( value . val ) ) ; }
      private Color center;private Color direction;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return center;
            case 1: return direction;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "center";
            case 1: return "direction";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: center = (Color) value; return;
            case 1: direction = (Color) value; return;
            default: return;
         }

      }

      public warp_d_col_line_rgb() {
         addGroupMeta(this);
         center = new Color ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         direction = new Color ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         direction . normalv ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {

         return super . evaluate ( context ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class warp_d_col_line_hsb extends WarpFunction < LDouble , Color > {
      public Class getVariableType ( ) { return LDouble . class ; }public Color warp ( LDouble value ) { Color hsb = center . add ( direction . mult ( value . val ) ) ; return Color . makeHSB ( hsb . r , hsb . g , hsb . b ) ; }
      private Color center;private Color direction;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return center;
            case 1: return direction;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "center";
            case 1: return "direction";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: center = (Color) value; return;
            case 1: direction = (Color) value; return;
            default: return;
         }

      }

      public warp_d_col_line_hsb() {
         addGroupMeta(this);
         center = new Color ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         direction = new Color ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         direction . normalv ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {

         return super . evaluate ( context ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class warp_v2_col_plane_rgb extends WarpFunction < LVect2d , Color > {
      public Class getVariableType ( ) { return LVect2d . class ; }public Color warp ( LVect2d value ) { return center . add ( u . mult ( value . x ) ) . add ( v . mult ( value . y ) ) ; }
      private Color center;private Color u;private Color v;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return center;
            case 1: return u;
            case 2: return v;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "center";
            case 1: return "u";
            case 2: return "v";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            case 2: return Color.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: center = (Color) value; return;
            case 1: u = (Color) value; return;
            case 2: v = (Color) value; return;
            default: return;
         }

      }

      public warp_v2_col_plane_rgb() {
         addGroupMeta(this);
         center = new Color ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         u = new Color ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         v = new Color ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         u . normalv ( ) ;
         v . normalv ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {

         return super . evaluate ( context ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class warp_v2_col_plane_hsb extends WarpFunction < LVect2d , Color > {
      public Class getVariableType ( ) { return LVect2d . class ; }public Color warp ( LVect2d value ) { Color hsb = center . add ( u . mult ( value . x ) ) . add ( v . mult ( value . y ) ) ; return Color . makeHSB ( hsb . r , hsb . g , hsb . b ) ; }
      private Color center;private Color u;private Color v;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return center;
            case 1: return u;
            case 2: return v;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "center";
            case 1: return "u";
            case 2: return "v";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Color.class;
            case 1: return Color.class;
            case 2: return Color.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: center = (Color) value; return;
            case 1: u = (Color) value; return;
            case 2: v = (Color) value; return;
            default: return;
         }

      }

      public warp_v2_col_plane_hsb() {
         addGroupMeta(this);
         center = new Color ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         u = new Color ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         v = new Color ( Math . random ( ) , Math . random ( ) , Math . random ( ) ) ;
         u . normalv ( ) ;
         v . normalv ( ) ;
      }

      public Color evaluate(Context context, Object[] inputs) {

         return super . evaluate ( context ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class warp_d_q_line extends WarpFunction < LDouble , Quaternion > {
      public Class getVariableType ( ) { return LDouble . class ; }public Quaternion warp ( LDouble value ) { return center . add ( direction . mult ( value . val ) ) ; }
      private Quaternion center;private Quaternion direction;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return center;
            case 1: return direction;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "center";
            case 1: return "direction";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            case 1: return Quaternion.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: center = (Quaternion) value; return;
            case 1: direction = (Quaternion) value; return;
            default: return;
         }

      }

      public warp_d_q_line() {
         addGroupMeta(this);
         center = new Quaternion ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         direction = new Quaternion ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         direction . normalv ( ) ;
      }

      public Quaternion evaluate(Context context, Object[] inputs) {

         return super . evaluate ( context ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public static class warp_v2_q_plane extends WarpFunction < LVect2d , Quaternion > {
      public Class getVariableType ( ) { return LVect2d . class ; }public Quaternion warp ( LVect2d value ) { return center . add ( u . mult ( value . x ) ) . add ( v . mult ( value . y ) ) ; }
      private Quaternion center;private Quaternion u;private Quaternion v;
      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return center;
            case 1: return u;
            case 2: return v;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "center";
            case 1: return "u";
            case 2: return "v";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return Quaternion.class;
            case 1: return Quaternion.class;
            case 2: return Quaternion.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: center = (Quaternion) value; return;
            case 1: u = (Quaternion) value; return;
            case 2: v = (Quaternion) value; return;
            default: return;
         }

      }

      public warp_v2_q_plane() {
         addGroupMeta(this);
         center = new Quaternion ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         u = new Quaternion ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         v = new Quaternion ( 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 , 2 * Math . random ( ) - 1 ) ;
         u . normalv ( ) ;
         v . normalv ( ) ;
      }

      public Quaternion evaluate(Context context, Object[] inputs) {

         return super . evaluate ( context ) ;
      }

      public Class getReturnType() {
         return Quaternion.class;
      }

   }

   public String getDescription() {
      return "Warps transform a variable and have no input. They can be used effectively to get the most leverage out of variables, transforming them into other types.";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new warp_d_d());
      r.add(new warp_d_v2_line());
      r.add(new warp_d_v2_circle());
      r.add(new warp_v2_v2());
      r.add(new warp_d_c_line());
      r.add(new warp_d_c_circle());
      r.add(new warp_v2_c());
      r.add(new warp_d_v3_line());
      r.add(new warp_v2_v3_plane());
      r.add(new warp_d_col_line_rgb());
      r.add(new warp_d_col_line_hsb());
      r.add(new warp_v2_col_plane_rgb());
      r.add(new warp_v2_col_plane_hsb());
      r.add(new warp_d_q_line());
      r.add(new warp_v2_q_plane());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
