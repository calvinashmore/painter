package library . expressions . functions;

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

public final class RandomValues implements AllComponents<ExpressionFunction>, Described {
   public static class rand_i extends ExpressionFunction {

      private int [ ] a;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return int [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (int [ ]) value; return;
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
            case 0: return Integer.class;
            default: return null;
         }

      }

      public rand_i() {

         Random rand = new Random ( ) ;
         a = new int [ 5 + rand . nextInt ( 5 ) ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) a [ i ] = rand . nextInt ( 101 ) ;
      }

      public String getDescription() {
         return "Chooses between 5 and 10 random numbers, whose values are between 0 and 100.";
      }

      public Integer evaluate(Context context, Object[] inputs) {
         Integer x = (Integer)inputs[0];
         int xmod = ( ( int ) x ) % a . length ;
         if ( xmod < 0 ) xmod += a . length ;
         return a [ xmod ] ;
      }

      public Class getReturnType() {
         return Integer.class;
      }

   }

   public static class permutation_i extends ExpressionFunction {

      private int [ ] a;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return int [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (int [ ]) value; return;
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
            case 0: return Integer.class;
            default: return null;
         }

      }

      public permutation_i() {

         Random rand = new Random ( ) ;
         a = new int [ 5 + rand . nextInt ( 5 ) ] ;
         boolean chosen [ ] = new boolean [ a . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) {
         boolean ok = false ;
         while ( ! ok ) {
         int value = rand . nextInt ( a . length ) ;
         if ( ! chosen [ value ] ) {
         ok = true ;
         chosen [ value ] = true ;
         a [ i ] = value ;
         }
         }
         }
      }

      public Integer evaluate(Context context, Object[] inputs) {
         Integer x = (Integer)inputs[0];
         int xmod = ( ( int ) x ) % a . length ;
         if ( xmod < 0 ) xmod += a . length ;
         return a [ xmod ] ;
      }

      public Class getReturnType() {
         return Integer.class;
      }

   }

   public static class random_d_d_const extends ExpressionFunction {

      private double [ ] a;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ]) value; return;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public random_d_d_const() {

         Random rand = new Random ( ) ;
         a = new double [ 5 + rand . nextInt ( 5 ) ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) a [ i ] = rand . nextDouble ( ) * 2 - 1 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         LDouble x = (LDouble)inputs[0];
         double v = x . val - Math . floor ( x . val ) ;
         int i = ( int ) ( v * a . length ) ;
         return new LDouble ( a [ i ] ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class random_d_d_linear extends ExpressionFunction {

      private double [ ] a;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ]) value; return;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public random_d_d_linear() {

         Random rand = new Random ( ) ;
         a = new double [ 5 + rand . nextInt ( 5 ) ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) a [ i ] = rand . nextDouble ( ) * 2 - 1 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         LDouble x = (LDouble)inputs[0];
         double v = x . val - Math . floor ( x . val ) ;
         double alpha = v * a . length - Math . floor ( v * a . length ) ;
         int i = ( int ) ( v * a . length ) ;
         int j = ( i + 1 ) % a . length ;
         return new LDouble ( a [ i ] * ( 1 - alpha ) + a [ j ] * ( alpha ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class random_d_d_spline extends ExpressionFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; }private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double [ ] a;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ]) value; return;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public random_d_d_spline() {

         Random rand = new Random ( ) ;
         a = new double [ 5 + rand . nextInt ( 5 ) ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) a [ i ] = rand . nextDouble ( ) * 2 - 1 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         LDouble x = (LDouble)inputs[0];
         double v = x . val - Math . floor ( x . val ) ;
         double alpha = v * a . length - Math . floor ( v * a . length ) ;
         int i = ( int ) ( v * a . length ) ;
         double r = 0 ;
         r += a [ getWrap ( i - 1 ) ] * splineEval ( alpha , - 1 ) ;
         r += a [ getWrap ( i + 0 ) ] * splineEval ( alpha , 0 ) ;
         r += a [ getWrap ( i + 1 ) ] * splineEval ( alpha , 1 ) ;
         r += a [ getWrap ( i + 2 ) ] * splineEval ( alpha , 2 ) ;
         return new LDouble ( r ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class random_d_v2_const extends ExpressionFunction {

      private double [ ] a;private double [ ] b;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            case 1: return b;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ].class;
            case 1: return double [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ]) value; return;
            case 1: b = (double [ ]) value; return;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public random_d_v2_const() {

         Random rand = new Random ( ) ;
         a = new double [ 5 + rand . nextInt ( 5 ) ] ;
         b = new double [ a . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) {
         a [ i ] = rand . nextDouble ( ) * 2 - 1 ;
         b [ i ] = rand . nextDouble ( ) * 2 - 1 ;
         }
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LDouble x = (LDouble)inputs[0];
         double v = x . val - Math . floor ( x . val ) ;
         int i = ( int ) ( v * a . length ) ;
         return new LVect2d ( a [ i ] , b [ i ] ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class random_d_v2_linear extends ExpressionFunction {

      private double [ ] a;private double [ ] b;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            case 1: return b;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ].class;
            case 1: return double [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ]) value; return;
            case 1: b = (double [ ]) value; return;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public random_d_v2_linear() {

         Random rand = new Random ( ) ;
         a = new double [ 5 + rand . nextInt ( 5 ) ] ;
         b = new double [ a . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) {
         a [ i ] = rand . nextDouble ( ) * 2 - 1 ;
         b [ i ] = rand . nextDouble ( ) * 2 - 1 ;
         }
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LDouble x = (LDouble)inputs[0];
         double v = x . val - Math . floor ( x . val ) ;
         double alpha = v * a . length - Math . floor ( v * a . length ) ;
         int i = ( int ) ( v * a . length ) ;
         int j = ( i + 1 ) % a . length ;
         return new LVect2d ( a [ i ] * ( 1 - alpha ) + a [ j ] * ( alpha ) , b [ i ] * ( 1 - alpha ) + b [ j ] * ( alpha ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class random_d_v2_spline extends ExpressionFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; }private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double [ ] a;private double [ ] b;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            case 1: return b;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ].class;
            case 1: return double [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ]) value; return;
            case 1: b = (double [ ]) value; return;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public random_d_v2_spline() {

         Random rand = new Random ( ) ;
         a = new double [ 5 + rand . nextInt ( 5 ) ] ;
         b = new double [ a . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) {
         a [ i ] = rand . nextDouble ( ) * 2 - 1 ;
         b [ i ] = rand . nextDouble ( ) * 2 - 1 ;
         }
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LDouble x = (LDouble)inputs[0];
         double v = x . val - Math . floor ( x . val ) ;
         double alpha = v * a . length - Math . floor ( v * a . length ) ;
         int i = ( int ) ( v * a . length ) ;
         double rx = 0 , ry = 0 ;
         rx += a [ getWrap ( i - 1 ) ] * splineEval ( alpha , - 1 ) ;
         rx += a [ getWrap ( i + 0 ) ] * splineEval ( alpha , 0 ) ;
         rx += a [ getWrap ( i + 1 ) ] * splineEval ( alpha , 1 ) ;
         rx += a [ getWrap ( i + 2 ) ] * splineEval ( alpha , 2 ) ;
         ry += b [ getWrap ( i - 1 ) ] * splineEval ( alpha , - 1 ) ;
         ry += b [ getWrap ( i + 0 ) ] * splineEval ( alpha , 0 ) ;
         ry += b [ getWrap ( i + 1 ) ] * splineEval ( alpha , 1 ) ;
         ry += b [ getWrap ( i + 2 ) ] * splineEval ( alpha , 2 ) ;
         return new LVect2d ( rx , ry ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class random_d_v3_const extends ExpressionFunction {

      private double [ ] a;private double [ ] b;private double [ ] c;
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
            case 0: return double [ ].class;
            case 1: return double [ ].class;
            case 2: return double [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ]) value; return;
            case 1: b = (double [ ]) value; return;
            case 2: c = (double [ ]) value; return;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public random_d_v3_const() {

         Random rand = new Random ( ) ;
         a = new double [ 5 + rand . nextInt ( 5 ) ] ;
         b = new double [ a . length ] ;
         c = new double [ a . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) {
         a [ i ] = rand . nextDouble ( ) * 2 - 1 ;
         b [ i ] = rand . nextDouble ( ) * 2 - 1 ;
         c [ i ] = rand . nextDouble ( ) * 2 - 1 ;
         }
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LDouble x = (LDouble)inputs[0];
         double v = x . val - Math . floor ( x . val ) ;
         int i = ( int ) ( v * a . length ) ;
         return new LVect3d ( a [ i ] , b [ i ] , c [ i ] ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class random_d_v3_linear extends ExpressionFunction {

      private double [ ] a;private double [ ] b;private double [ ] c;
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
            case 0: return double [ ].class;
            case 1: return double [ ].class;
            case 2: return double [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ]) value; return;
            case 1: b = (double [ ]) value; return;
            case 2: c = (double [ ]) value; return;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public random_d_v3_linear() {

         Random rand = new Random ( ) ;
         a = new double [ 5 + rand . nextInt ( 5 ) ] ;
         b = new double [ a . length ] ;
         c = new double [ a . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) {
         a [ i ] = rand . nextDouble ( ) * 2 - 1 ;
         b [ i ] = rand . nextDouble ( ) * 2 - 1 ;
         c [ i ] = rand . nextDouble ( ) * 2 - 1 ;
         }
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LDouble x = (LDouble)inputs[0];
         double v = x . val - Math . floor ( x . val ) ;
         double alpha = v * a . length - Math . floor ( v * a . length ) ;
         int i = ( int ) ( v * a . length ) ;
         int j = ( i + 1 ) % a . length ;
         return new LVect3d ( a [ i ] * ( 1 - alpha ) + a [ j ] * ( alpha ) , b [ i ] * ( 1 - alpha ) + b [ j ] * ( alpha ) , c [ i ] * ( 1 - alpha ) + c [ j ] * ( alpha ) ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class random_d_v3_spline extends ExpressionFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; }private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double [ ] a;private double [ ] b;private double [ ] c;
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
            case 0: return double [ ].class;
            case 1: return double [ ].class;
            case 2: return double [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ]) value; return;
            case 1: b = (double [ ]) value; return;
            case 2: c = (double [ ]) value; return;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public random_d_v3_spline() {

         Random rand = new Random ( ) ;
         a = new double [ 5 + rand . nextInt ( 5 ) ] ;
         b = new double [ a . length ] ;
         c = new double [ a . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) {
         a [ i ] = rand . nextDouble ( ) * 2 - 1 ;
         b [ i ] = rand . nextDouble ( ) * 2 - 1 ;
         c [ i ] = rand . nextDouble ( ) * 2 - 1 ;
         }
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LDouble x = (LDouble)inputs[0];
         double v = x . val - Math . floor ( x . val ) ;
         double alpha = v * a . length - Math . floor ( v * a . length ) ;
         int i = ( int ) ( v * a . length ) ;
         double rx = 0 , ry = 0 , rz = 0 ;
         rx += a [ getWrap ( i - 1 ) ] * splineEval ( alpha , - 1 ) ;
         rx += a [ getWrap ( i + 0 ) ] * splineEval ( alpha , 0 ) ;
         rx += a [ getWrap ( i + 1 ) ] * splineEval ( alpha , 1 ) ;
         rx += a [ getWrap ( i + 2 ) ] * splineEval ( alpha , 2 ) ;
         ry += b [ getWrap ( i - 1 ) ] * splineEval ( alpha , - 1 ) ;
         ry += b [ getWrap ( i + 0 ) ] * splineEval ( alpha , 0 ) ;
         ry += b [ getWrap ( i + 1 ) ] * splineEval ( alpha , 1 ) ;
         ry += b [ getWrap ( i + 2 ) ] * splineEval ( alpha , 2 ) ;
         rz += c [ getWrap ( i - 1 ) ] * splineEval ( alpha , - 1 ) ;
         rz += c [ getWrap ( i + 0 ) ] * splineEval ( alpha , 0 ) ;
         rz += c [ getWrap ( i + 1 ) ] * splineEval ( alpha , 1 ) ;
         rz += c [ getWrap ( i + 2 ) ] * splineEval ( alpha , 2 ) ;
         return new LVect3d ( rx , ry , rz ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class random_d_col_const extends ExpressionFunction {

      private double [ ] a;private double [ ] b;private double [ ] c;
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
            case 0: return double [ ].class;
            case 1: return double [ ].class;
            case 2: return double [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ]) value; return;
            case 1: b = (double [ ]) value; return;
            case 2: c = (double [ ]) value; return;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public random_d_col_const() {

         Random rand = new Random ( ) ;
         a = new double [ 5 + rand . nextInt ( 5 ) ] ;
         b = new double [ a . length ] ;
         c = new double [ a . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) {
         a [ i ] = rand . nextDouble ( ) * 1 ;
         b [ i ] = rand . nextDouble ( ) * 1 ;
         c [ i ] = rand . nextDouble ( ) * 1 ;
         }
      }

      public Color evaluate(Context context, Object[] inputs) {
         LDouble x = (LDouble)inputs[0];
         double v = x . val - Math . floor ( x . val ) ;
         int i = ( int ) ( v * a . length ) ;
         return new Color ( a [ i ] , b [ i ] , c [ i ] ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class random_d_col_linear extends ExpressionFunction {

      private double [ ] a;private double [ ] b;private double [ ] c;
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
            case 0: return double [ ].class;
            case 1: return double [ ].class;
            case 2: return double [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ]) value; return;
            case 1: b = (double [ ]) value; return;
            case 2: c = (double [ ]) value; return;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public random_d_col_linear() {

         Random rand = new Random ( ) ;
         a = new double [ 5 + rand . nextInt ( 5 ) ] ;
         b = new double [ a . length ] ;
         c = new double [ a . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) {
         a [ i ] = rand . nextDouble ( ) * 1 ;
         b [ i ] = rand . nextDouble ( ) * 1 ;
         c [ i ] = rand . nextDouble ( ) * 1 ;
         }
      }

      public Color evaluate(Context context, Object[] inputs) {
         LDouble x = (LDouble)inputs[0];
         double v = x . val - Math . floor ( x . val ) ;
         double alpha = v * a . length - Math . floor ( v * a . length ) ;
         int i = ( int ) ( v * a . length ) ;
         int j = ( i + 1 ) % a . length ;
         return new Color ( a [ i ] * ( 1 - alpha ) + a [ j ] * ( alpha ) , b [ i ] * ( 1 - alpha ) + b [ j ] * ( alpha ) , c [ i ] * ( 1 - alpha ) + c [ j ] * ( alpha ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class random_d_col_spline extends ExpressionFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; }private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double [ ] a;private double [ ] b;private double [ ] c;
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
            case 0: return double [ ].class;
            case 1: return double [ ].class;
            case 2: return double [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ]) value; return;
            case 1: b = (double [ ]) value; return;
            case 2: c = (double [ ]) value; return;
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
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public random_d_col_spline() {

         Random rand = new Random ( ) ;
         a = new double [ 5 + rand . nextInt ( 5 ) ] ;
         b = new double [ a . length ] ;
         c = new double [ a . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) {
         a [ i ] = rand . nextDouble ( ) * 1 ;
         b [ i ] = rand . nextDouble ( ) * 1 ;
         c [ i ] = rand . nextDouble ( ) * 1 ;
         }
      }

      public Color evaluate(Context context, Object[] inputs) {
         LDouble x = (LDouble)inputs[0];
         double v = x . val - Math . floor ( x . val ) ;
         double alpha = v * a . length - Math . floor ( v * a . length ) ;
         int i = ( int ) ( v * a . length ) ;
         double rx = 0 , ry = 0 , rz = 0 ;
         rx += a [ getWrap ( i - 1 ) ] * splineEval ( alpha , - 1 ) ;
         rx += a [ getWrap ( i + 0 ) ] * splineEval ( alpha , 0 ) ;
         rx += a [ getWrap ( i + 1 ) ] * splineEval ( alpha , 1 ) ;
         rx += a [ getWrap ( i + 2 ) ] * splineEval ( alpha , 2 ) ;
         ry += b [ getWrap ( i - 1 ) ] * splineEval ( alpha , - 1 ) ;
         ry += b [ getWrap ( i + 0 ) ] * splineEval ( alpha , 0 ) ;
         ry += b [ getWrap ( i + 1 ) ] * splineEval ( alpha , 1 ) ;
         ry += b [ getWrap ( i + 2 ) ] * splineEval ( alpha , 2 ) ;
         rz += c [ getWrap ( i - 1 ) ] * splineEval ( alpha , - 1 ) ;
         rz += c [ getWrap ( i + 0 ) ] * splineEval ( alpha , 0 ) ;
         rz += c [ getWrap ( i + 1 ) ] * splineEval ( alpha , 1 ) ;
         rz += c [ getWrap ( i + 2 ) ] * splineEval ( alpha , 2 ) ;
         return new Color ( rx , ry , rz ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class random_v2_d_const extends ExpressionFunction {

      private double [ ] [ ] a;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ]) value; return;
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

      public random_v2_d_const() {

         Random rand = new Random ( ) ;
         a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ i ] . length ;
         j ++ ) a [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double v = x . y - Math . floor ( x . y ) ;
         int ui = ( int ) ( u * a . length ) ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         return new LDouble ( a [ ui ] [ vi ] ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class random_v2_d_linear extends ExpressionFunction {

      private double [ ] [ ] a;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ]) value; return;
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

      public random_v2_d_linear() {

         Random rand = new Random ( ) ;
         a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ i ] . length ;
         j ++ ) a [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double ualpha = u * a . length - Math . floor ( u * a . length ) ;
         double v = x . y - Math . floor ( x . y ) ;
         double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ;
         int ui = ( int ) ( u * a . length ) ;
         int uj = ( ui + 1 ) % a . length ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         int vj = ( vi + 1 ) % a [ 0 ] . length ;
         return new LDouble ( a [ ui ] [ vi ] * ( 1 - ualpha ) * ( 1 - valpha ) + a [ ui ] [ vj ] * ( 1 - ualpha ) * ( valpha ) + a [ uj ] [ vi ] * ( ualpha ) * ( 1 - valpha ) + a [ uj ] [ vj ] * ( ualpha ) * ( valpha ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class random_v2_d_spline extends ExpressionFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; }private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double [ ] [ ] a;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ]) value; return;
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

      public random_v2_d_spline() {

         Random rand = new Random ( ) ;
         int size = 3 + rand . nextInt ( 3 ) ;
         a = new double [ size ] [ size ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ i ] . length ;
         j ++ ) a [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double ualpha = u * a . length - Math . floor ( u * a . length ) ;
         double v = x . y - Math . floor ( x . y ) ;
         double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ;
         int ui = ( int ) ( u * a . length ) ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         double r = 0 ;
         for ( int i = - 1 ;
         i <= 2 ;
         i ++ ) for ( int j = - 1 ;
         j <= 2 ;
         j ++ ) r += a [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] * splineEval ( ualpha , i ) * splineEval ( valpha , j ) ;
         return new LDouble ( r ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class random_v2_v2_const extends ExpressionFunction {

      private double [ ] [ ] a;private double [ ] [ ] b;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            case 1: return b;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ] [ ].class;
            case 1: return double [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ]) value; return;
            case 1: b = (double [ ] [ ]) value; return;
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

      public random_v2_v2_const() {

         Random rand = new Random ( ) ;
         a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ;
         b = new double [ a . length ] [ a [ 0 ] . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ 0 ] . length ;
         j ++ ) {
         a [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ;
         b [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ;
         }
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double v = x . y - Math . floor ( x . y ) ;
         int ui = ( int ) ( u * a . length ) ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         return new LVect2d ( a [ ui ] [ vi ] , b [ ui ] [ vi ] ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class random_v2_v2_linear extends ExpressionFunction {

      private double [ ] [ ] a;private double [ ] [ ] b;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            case 1: return b;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ] [ ].class;
            case 1: return double [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ]) value; return;
            case 1: b = (double [ ] [ ]) value; return;
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

      public random_v2_v2_linear() {

         Random rand = new Random ( ) ;
         a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ;
         b = new double [ a . length ] [ a [ 0 ] . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ 0 ] . length ;
         j ++ ) {
         a [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ;
         b [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ;
         }
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double ualpha = u * a . length - Math . floor ( u * a . length ) ;
         double v = x . y - Math . floor ( x . y ) ;
         double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ;
         int ui = ( int ) ( u * a . length ) ;
         int uj = ( ui + 1 ) % a . length ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         int vj = ( vi + 1 ) % a [ 0 ] . length ;
         return new LVect2d ( a [ ui ] [ vi ] * ( 1 - ualpha ) * ( 1 - valpha ) + a [ ui ] [ vj ] * ( 1 - ualpha ) * ( valpha ) + a [ uj ] [ vi ] * ( ualpha ) * ( 1 - valpha ) + a [ uj ] [ vj ] * ( ualpha ) * ( valpha ) , b [ ui ] [ vi ] * ( 1 - ualpha ) * ( 1 - valpha ) + b [ ui ] [ vj ] * ( 1 - ualpha ) * ( valpha ) + b [ uj ] [ vi ] * ( ualpha ) * ( 1 - valpha ) + b [ uj ] [ vj ] * ( ualpha ) * ( valpha ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class random_v2_v2_spline extends ExpressionFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; }private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double [ ] [ ] a;private double [ ] [ ] b;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            case 1: return b;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ] [ ].class;
            case 1: return double [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ]) value; return;
            case 1: b = (double [ ] [ ]) value; return;
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

      public random_v2_v2_spline() {

         Random rand = new Random ( ) ;
         int size = 3 + rand . nextInt ( 3 ) ;
         a = new double [ size ] [ size ] ;
         b = new double [ a . length ] [ a [ 0 ] . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ 0 ] . length ;
         j ++ ) {
         a [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ;
         b [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ;
         }
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double ualpha = u * a . length - Math . floor ( u * a . length ) ;
         double v = x . y - Math . floor ( x . y ) ;
         double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ;
         int ui = ( int ) ( u * a . length ) ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         double rx = 0 ;
         double ry = 0 ;
         for ( int i = - 1 ;
         i <= 2 ;
         i ++ ) for ( int j = - 1 ;
         j <= 2 ;
         j ++ ) {
         double coeff = splineEval ( ualpha , i ) * splineEval ( valpha , j ) ;
         rx += a [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] * coeff ;
         ry += b [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] * coeff ;
         }
         return new LVect2d ( rx , ry ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class random_v2_v3_const extends ExpressionFunction {

      private double [ ] [ ] a;private double [ ] [ ] b;private double [ ] [ ] c;
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
            case 0: return double [ ] [ ].class;
            case 1: return double [ ] [ ].class;
            case 2: return double [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ]) value; return;
            case 1: b = (double [ ] [ ]) value; return;
            case 2: c = (double [ ] [ ]) value; return;
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

      public random_v2_v3_const() {

         Random rand = new Random ( ) ;
         a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ;
         b = new double [ a . length ] [ a [ 0 ] . length ] ;
         c = new double [ a . length ] [ a [ 0 ] . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ 0 ] . length ;
         j ++ ) {
         a [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ;
         b [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ;
         c [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ;
         }
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double v = x . y - Math . floor ( x . y ) ;
         int ui = ( int ) ( u * a . length ) ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         return new LVect3d ( a [ ui ] [ vi ] , b [ ui ] [ vi ] , c [ ui ] [ vi ] ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class random_v2_v3_linear extends ExpressionFunction {

      private double [ ] [ ] a;private double [ ] [ ] b;private double [ ] [ ] c;
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
            case 0: return double [ ] [ ].class;
            case 1: return double [ ] [ ].class;
            case 2: return double [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ]) value; return;
            case 1: b = (double [ ] [ ]) value; return;
            case 2: c = (double [ ] [ ]) value; return;
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

      public random_v2_v3_linear() {

         Random rand = new Random ( ) ;
         a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ;
         b = new double [ a . length ] [ a [ 0 ] . length ] ;
         c = new double [ a . length ] [ a [ 0 ] . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ 0 ] . length ;
         j ++ ) {
         a [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ;
         b [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ;
         c [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ;
         }
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double ualpha = u * a . length - Math . floor ( u * a . length ) ;
         double v = x . y - Math . floor ( x . y ) ;
         double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ;
         int ui = ( int ) ( u * a . length ) ;
         int uj = ( ui + 1 ) % a . length ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         int vj = ( vi + 1 ) % a [ 0 ] . length ;
         return new LVect3d ( a [ ui ] [ vi ] * ( 1 - ualpha ) * ( 1 - valpha ) + a [ ui ] [ vj ] * ( 1 - ualpha ) * ( valpha ) + a [ uj ] [ vi ] * ( ualpha ) * ( 1 - valpha ) + a [ uj ] [ vj ] * ( ualpha ) * ( valpha ) , b [ ui ] [ vi ] * ( 1 - ualpha ) * ( 1 - valpha ) + b [ ui ] [ vj ] * ( 1 - ualpha ) * ( valpha ) + b [ uj ] [ vi ] * ( ualpha ) * ( 1 - valpha ) + b [ uj ] [ vj ] * ( ualpha ) * ( valpha ) , c [ ui ] [ vi ] * ( 1 - ualpha ) * ( 1 - valpha ) + c [ ui ] [ vj ] * ( 1 - ualpha ) * ( valpha ) + c [ uj ] [ vi ] * ( ualpha ) * ( 1 - valpha ) + c [ uj ] [ vj ] * ( ualpha ) * ( valpha ) ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class random_v2_v3_spline extends ExpressionFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; }private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double [ ] [ ] a;private double [ ] [ ] b;private double [ ] [ ] c;
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
            case 0: return double [ ] [ ].class;
            case 1: return double [ ] [ ].class;
            case 2: return double [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ]) value; return;
            case 1: b = (double [ ] [ ]) value; return;
            case 2: c = (double [ ] [ ]) value; return;
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

      public random_v2_v3_spline() {

         Random rand = new Random ( ) ;
         int size = 3 + rand . nextInt ( 3 ) ;
         a = new double [ size ] [ size ] ;
         b = new double [ a . length ] [ a [ 0 ] . length ] ;
         c = new double [ a . length ] [ a [ 0 ] . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ 0 ] . length ;
         j ++ ) {
         a [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ;
         b [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ;
         c [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ;
         }
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double ualpha = u * a . length - Math . floor ( u * a . length ) ;
         double v = x . y - Math . floor ( x . y ) ;
         double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ;
         int ui = ( int ) ( u * a . length ) ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         double rx = 0 ;
         double ry = 0 ;
         double rz = 0 ;
         for ( int i = - 1 ;
         i <= 2 ;
         i ++ ) for ( int j = - 1 ;
         j <= 2 ;
         j ++ ) {
         double coeff = splineEval ( ualpha , i ) * splineEval ( valpha , j ) ;
         rx += a [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] * coeff ;
         ry += b [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] * coeff ;
         rz += b [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] * coeff ;
         }
         return new LVect3d ( rx , ry , rz ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class random_v2_col_const extends ExpressionFunction {

      private double [ ] [ ] a;private double [ ] [ ] b;private double [ ] [ ] c;
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
            case 0: return double [ ] [ ].class;
            case 1: return double [ ] [ ].class;
            case 2: return double [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ]) value; return;
            case 1: b = (double [ ] [ ]) value; return;
            case 2: c = (double [ ] [ ]) value; return;
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

      public random_v2_col_const() {

         Random rand = new Random ( ) ;
         a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ;
         b = new double [ a . length ] [ a [ 0 ] . length ] ;
         c = new double [ a . length ] [ a [ 0 ] . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ 0 ] . length ;
         j ++ ) {
         a [ i ] [ j ] = rand . nextDouble ( ) * 1 ;
         b [ i ] [ j ] = rand . nextDouble ( ) * 1 ;
         c [ i ] [ j ] = rand . nextDouble ( ) * 1 ;
         }
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double v = x . y - Math . floor ( x . y ) ;
         int ui = ( int ) ( u * a . length ) ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         return new Color ( a [ ui ] [ vi ] , b [ ui ] [ vi ] , c [ ui ] [ vi ] ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class random_v2_col_linear extends ExpressionFunction {

      private double [ ] [ ] a;private double [ ] [ ] b;private double [ ] [ ] c;
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
            case 0: return double [ ] [ ].class;
            case 1: return double [ ] [ ].class;
            case 2: return double [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ]) value; return;
            case 1: b = (double [ ] [ ]) value; return;
            case 2: c = (double [ ] [ ]) value; return;
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

      public random_v2_col_linear() {

         Random rand = new Random ( ) ;
         a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ;
         b = new double [ a . length ] [ a [ 0 ] . length ] ;
         c = new double [ a . length ] [ a [ 0 ] . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ 0 ] . length ;
         j ++ ) {
         a [ i ] [ j ] = rand . nextDouble ( ) * 1 ;
         b [ i ] [ j ] = rand . nextDouble ( ) * 1 ;
         c [ i ] [ j ] = rand . nextDouble ( ) * 1 ;
         }
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double ualpha = u * a . length - Math . floor ( u * a . length ) ;
         double v = x . y - Math . floor ( x . y ) ;
         double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ;
         int ui = ( int ) ( u * a . length ) ;
         int uj = ( ui + 1 ) % a . length ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         int vj = ( vi + 1 ) % a [ 0 ] . length ;
         return new Color ( a [ ui ] [ vi ] * ( 1 - ualpha ) * ( 1 - valpha ) + a [ ui ] [ vj ] * ( 1 - ualpha ) * ( valpha ) + a [ uj ] [ vi ] * ( ualpha ) * ( 1 - valpha ) + a [ uj ] [ vj ] * ( ualpha ) * ( valpha ) , b [ ui ] [ vi ] * ( 1 - ualpha ) * ( 1 - valpha ) + b [ ui ] [ vj ] * ( 1 - ualpha ) * ( valpha ) + b [ uj ] [ vi ] * ( ualpha ) * ( 1 - valpha ) + b [ uj ] [ vj ] * ( ualpha ) * ( valpha ) , c [ ui ] [ vi ] * ( 1 - ualpha ) * ( 1 - valpha ) + c [ ui ] [ vj ] * ( 1 - ualpha ) * ( valpha ) + c [ uj ] [ vi ] * ( ualpha ) * ( 1 - valpha ) + c [ uj ] [ vj ] * ( ualpha ) * ( valpha ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class random_v2_col_spline extends ExpressionFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; }private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double [ ] [ ] a;private double [ ] [ ] b;private double [ ] [ ] c;
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
            case 0: return double [ ] [ ].class;
            case 1: return double [ ] [ ].class;
            case 2: return double [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ]) value; return;
            case 1: b = (double [ ] [ ]) value; return;
            case 2: c = (double [ ] [ ]) value; return;
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

      public random_v2_col_spline() {

         Random rand = new Random ( ) ;
         int size = 3 + rand . nextInt ( 3 ) ;
         a = new double [ size ] [ size ] ;
         b = new double [ a . length ] [ a [ 0 ] . length ] ;
         c = new double [ a . length ] [ a [ 0 ] . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ 0 ] . length ;
         j ++ ) {
         a [ i ] [ j ] = rand . nextDouble ( ) * 1 ;
         b [ i ] [ j ] = rand . nextDouble ( ) * 1 ;
         c [ i ] [ j ] = rand . nextDouble ( ) * 1 ;
         }
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect2d x = (LVect2d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double ualpha = u * a . length - Math . floor ( u * a . length ) ;
         double v = x . y - Math . floor ( x . y ) ;
         double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ;
         int ui = ( int ) ( u * a . length ) ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         double rx = 0 ;
         double ry = 0 ;
         double rz = 0 ;
         for ( int i = - 1 ;
         i <= 2 ;
         i ++ ) for ( int j = - 1 ;
         j <= 2 ;
         j ++ ) {
         double coeff = splineEval ( ualpha , i ) * splineEval ( valpha , j ) ;
         rx += a [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] * coeff ;
         ry += b [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] * coeff ;
         rz += b [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] * coeff ;
         }
         return new Color ( rx , ry , rz ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class random_v3_d_const extends ExpressionFunction {

      private double [ ] [ ] [ ] a;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ] [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ] [ ]) value; return;
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
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public random_v3_d_const() {

         Random rand = new Random ( ) ;
         a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ 0 ] . length ;
         j ++ ) for ( int k = 0 ;
         k < a [ 0 ] [ 0 ] . length ;
         k ++ ) a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double v = x . y - Math . floor ( x . y ) ;
         double w = x . z - Math . floor ( x . z ) ;
         int ui = ( int ) ( u * a . length ) ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ;
         return new LDouble ( a [ ui ] [ vi ] [ wi ] ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class random_v3_d_linear extends ExpressionFunction {

      private double [ ] [ ] [ ] a;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ] [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ] [ ]) value; return;
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
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public random_v3_d_linear() {

         Random rand = new Random ( ) ;
         a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ 0 ] . length ;
         j ++ ) for ( int k = 0 ;
         k < a [ 0 ] [ 0 ] . length ;
         k ++ ) a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double ualpha = u * a . length - Math . floor ( u * a . length ) ;
         double v = x . y - Math . floor ( x . y ) ;
         double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ;
         double w = x . z - Math . floor ( x . z ) ;
         double walpha = w * a [ 0 ] [ 0 ] . length - Math . floor ( w * a [ 0 ] [ 0 ] . length ) ;
         int ui = ( int ) ( u * a . length ) ;
         int uj = ( ui + 1 ) % a . length ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         int vj = ( vi + 1 ) % a [ 0 ] . length ;
         int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ;
         int wj = ( wi + 1 ) % a [ 0 ] [ 0 ] . length ;
         return new LDouble ( a [ ui ] [ vi ] [ wi ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + a [ ui ] [ vj ] [ wi ] * ( 1 - ualpha ) * ( valpha ) * ( 1 - walpha ) + a [ uj ] [ vi ] [ wi ] * ( ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + a [ uj ] [ vj ] [ wi ] * ( ualpha ) * ( valpha ) * ( 1 - walpha ) + a [ ui ] [ vi ] [ wj ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( walpha ) + a [ ui ] [ vj ] [ wj ] * ( 1 - ualpha ) * ( valpha ) * ( walpha ) + a [ uj ] [ vi ] [ wj ] * ( ualpha ) * ( 1 - valpha ) * ( walpha ) + a [ uj ] [ vj ] [ wj ] * ( ualpha ) * ( valpha ) * ( walpha ) ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class random_v3_d_spline extends ExpressionFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; }private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double [ ] [ ] [ ] a;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ] [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ] [ ]) value; return;
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
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public random_v3_d_spline() {

         Random rand = new Random ( ) ;
         int size = 3 + rand . nextInt ( 3 ) ;
         a = new double [ size ] [ size ] [ size ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ 0 ] . length ;
         j ++ ) for ( int k = 0 ;
         k < a [ 0 ] [ 0 ] . length ;
         k ++ ) a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double ualpha = u * a . length - Math . floor ( u * a . length ) ;
         double v = x . y - Math . floor ( x . y ) ;
         double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ;
         double w = x . z - Math . floor ( x . z ) ;
         double walpha = w * a [ 0 ] [ 0 ] . length - Math . floor ( w * a [ 0 ] [ 0 ] . length ) ;
         int ui = ( int ) ( u * a . length ) ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ;
         double r = 0 ;
         for ( int i = - 1 ;
         i <= 2 ;
         i ++ ) for ( int j = - 1 ;
         j <= 2 ;
         j ++ ) for ( int k = - 1 ;
         k <= 2 ;
         k ++ ) r += a [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] [ getWrap ( wi + k ) ] * splineEval ( ualpha , i ) * splineEval ( valpha , j ) * splineEval ( walpha , k ) ;
         return new LDouble ( r ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class random_v3_v2_const extends ExpressionFunction {

      private double [ ] [ ] [ ] a;private double [ ] [ ] [ ] b;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            case 1: return b;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ] [ ] [ ].class;
            case 1: return double [ ] [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ] [ ]) value; return;
            case 1: b = (double [ ] [ ] [ ]) value; return;
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
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public random_v3_v2_const() {

         Random rand = new Random ( ) ;
         a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ;
         b = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ 0 ] . length ;
         j ++ ) for ( int k = 0 ;
         k < a [ 0 ] [ 0 ] . length ;
         k ++ ) {
         a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ;
         b [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ;
         }
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double v = x . y - Math . floor ( x . y ) ;
         double w = x . z - Math . floor ( x . z ) ;
         int ui = ( int ) ( u * a . length ) ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ;
         return new LVect2d ( a [ ui ] [ vi ] [ wi ] , b [ ui ] [ vi ] [ wi ] ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class random_v3_v2_linear extends ExpressionFunction {

      private double [ ] [ ] [ ] a;private double [ ] [ ] [ ] b;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            case 1: return b;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ] [ ] [ ].class;
            case 1: return double [ ] [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ] [ ]) value; return;
            case 1: b = (double [ ] [ ] [ ]) value; return;
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
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public random_v3_v2_linear() {

         Random rand = new Random ( ) ;
         a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ;
         b = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ 0 ] . length ;
         j ++ ) for ( int k = 0 ;
         k < a [ 0 ] [ 0 ] . length ;
         k ++ ) {
         a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ;
         b [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ;
         }
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double ualpha = u * a . length - Math . floor ( u * a . length ) ;
         double v = x . y - Math . floor ( x . y ) ;
         double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ;
         double w = x . z - Math . floor ( x . z ) ;
         double walpha = w * a [ 0 ] [ 0 ] . length - Math . floor ( w * a [ 0 ] [ 0 ] . length ) ;
         int ui = ( int ) ( u * a . length ) ;
         int uj = ( ui + 1 ) % a . length ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         int vj = ( vi + 1 ) % a [ 0 ] . length ;
         int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ;
         int wj = ( wi + 1 ) % a [ 0 ] [ 0 ] . length ;
         return new LVect2d ( a [ ui ] [ vi ] [ wi ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + a [ ui ] [ vj ] [ wi ] * ( 1 - ualpha ) * ( valpha ) * ( 1 - walpha ) + a [ uj ] [ vi ] [ wi ] * ( ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + a [ uj ] [ vj ] [ wi ] * ( ualpha ) * ( valpha ) * ( 1 - walpha ) + a [ ui ] [ vi ] [ wj ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( walpha ) + a [ ui ] [ vj ] [ wj ] * ( 1 - ualpha ) * ( valpha ) * ( walpha ) + a [ uj ] [ vi ] [ wj ] * ( ualpha ) * ( 1 - valpha ) * ( walpha ) + a [ uj ] [ vj ] [ wj ] * ( ualpha ) * ( valpha ) * ( walpha ) , b [ ui ] [ vi ] [ wi ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + b [ ui ] [ vj ] [ wi ] * ( 1 - ualpha ) * ( valpha ) * ( 1 - walpha ) + b [ uj ] [ vi ] [ wi ] * ( ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + b [ uj ] [ vj ] [ wi ] * ( ualpha ) * ( valpha ) * ( 1 - walpha ) + b [ ui ] [ vi ] [ wj ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( walpha ) + b [ ui ] [ vj ] [ wj ] * ( 1 - ualpha ) * ( valpha ) * ( walpha ) + b [ uj ] [ vi ] [ wj ] * ( ualpha ) * ( 1 - valpha ) * ( walpha ) + b [ uj ] [ vj ] [ wj ] * ( ualpha ) * ( valpha ) * ( walpha ) ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class random_v3_v2_spline extends ExpressionFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; }private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double [ ] [ ] [ ] a;private double [ ] [ ] [ ] b;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return a;
            case 1: return b;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "a";
            case 1: return "b";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return double [ ] [ ] [ ].class;
            case 1: return double [ ] [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ] [ ]) value; return;
            case 1: b = (double [ ] [ ] [ ]) value; return;
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
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public random_v3_v2_spline() {

         Random rand = new Random ( ) ;
         int size = 3 + rand . nextInt ( 3 ) ;
         a = new double [ size ] [ size ] [ size ] ;
         b = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ 0 ] . length ;
         j ++ ) for ( int k = 0 ;
         k < a [ 0 ] [ 0 ] . length ;
         k ++ ) {
         a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ;
         b [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ;
         }
      }

      public LVect2d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double ualpha = u * a . length - Math . floor ( u * a . length ) ;
         double v = x . y - Math . floor ( x . y ) ;
         double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ;
         double w = x . z - Math . floor ( x . z ) ;
         double walpha = w * a [ 0 ] [ 0 ] . length - Math . floor ( w * a [ 0 ] [ 0 ] . length ) ;
         int ui = ( int ) ( u * a . length ) ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ;
         double rx = 0 ;
         double ry = 0 ;
         for ( int i = - 1 ;
         i <= 2 ;
         i ++ ) for ( int j = - 1 ;
         j <= 2 ;
         j ++ ) for ( int k = - 1 ;
         k <= 2 ;
         k ++ ) {
         double coeff = splineEval ( ualpha , i ) * splineEval ( valpha , j ) * splineEval ( walpha , k ) ;
         rx += a [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] [ getWrap ( wi + k ) ] * coeff ;
         ry += b [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] [ getWrap ( wi + k ) ] * coeff ;
         }
         return new LVect2d ( rx , ry ) ;
      }

      public Class getReturnType() {
         return LVect2d.class;
      }

   }

   public static class random_v3_v3_const extends ExpressionFunction {

      private double [ ] [ ] [ ] a;private double [ ] [ ] [ ] b;private double [ ] [ ] [ ] c;
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
            case 0: return double [ ] [ ] [ ].class;
            case 1: return double [ ] [ ] [ ].class;
            case 2: return double [ ] [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ] [ ]) value; return;
            case 1: b = (double [ ] [ ] [ ]) value; return;
            case 2: c = (double [ ] [ ] [ ]) value; return;
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
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public random_v3_v3_const() {

         Random rand = new Random ( ) ;
         a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ;
         b = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ;
         c = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ 0 ] . length ;
         j ++ ) for ( int k = 0 ;
         k < a [ 0 ] [ 0 ] . length ;
         k ++ ) {
         a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ;
         b [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ;
         c [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ;
         }
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double v = x . y - Math . floor ( x . y ) ;
         double w = x . z - Math . floor ( x . z ) ;
         int ui = ( int ) ( u * a . length ) ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ;
         return new LVect3d ( a [ ui ] [ vi ] [ wi ] , b [ ui ] [ vi ] [ wi ] , c [ ui ] [ vi ] [ wi ] ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class random_v3_v3_linear extends ExpressionFunction {

      private double [ ] [ ] [ ] a;private double [ ] [ ] [ ] b;private double [ ] [ ] [ ] c;
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
            case 0: return double [ ] [ ] [ ].class;
            case 1: return double [ ] [ ] [ ].class;
            case 2: return double [ ] [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ] [ ]) value; return;
            case 1: b = (double [ ] [ ] [ ]) value; return;
            case 2: c = (double [ ] [ ] [ ]) value; return;
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
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public random_v3_v3_linear() {

         Random rand = new Random ( ) ;
         a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ;
         b = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ;
         c = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ 0 ] . length ;
         j ++ ) for ( int k = 0 ;
         k < a [ 0 ] [ 0 ] . length ;
         k ++ ) {
         a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ;
         b [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ;
         c [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ;
         }
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double ualpha = u * a . length - Math . floor ( u * a . length ) ;
         double v = x . y - Math . floor ( x . y ) ;
         double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ;
         double w = x . z - Math . floor ( x . z ) ;
         double walpha = w * a [ 0 ] [ 0 ] . length - Math . floor ( w * a [ 0 ] [ 0 ] . length ) ;
         int ui = ( int ) ( u * a . length ) ;
         int uj = ( ui + 1 ) % a . length ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         int vj = ( vi + 1 ) % a [ 0 ] . length ;
         int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ;
         int wj = ( wi + 1 ) % a [ 0 ] [ 0 ] . length ;
         return new LVect3d ( a [ ui ] [ vi ] [ wi ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + a [ ui ] [ vj ] [ wi ] * ( 1 - ualpha ) * ( valpha ) * ( 1 - walpha ) + a [ uj ] [ vi ] [ wi ] * ( ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + a [ uj ] [ vj ] [ wi ] * ( ualpha ) * ( valpha ) * ( 1 - walpha ) + a [ ui ] [ vi ] [ wj ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( walpha ) + a [ ui ] [ vj ] [ wj ] * ( 1 - ualpha ) * ( valpha ) * ( walpha ) + a [ uj ] [ vi ] [ wj ] * ( ualpha ) * ( 1 - valpha ) * ( walpha ) + a [ uj ] [ vj ] [ wj ] * ( ualpha ) * ( valpha ) * ( walpha ) , b [ ui ] [ vi ] [ wi ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + b [ ui ] [ vj ] [ wi ] * ( 1 - ualpha ) * ( valpha ) * ( 1 - walpha ) + b [ uj ] [ vi ] [ wi ] * ( ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + b [ uj ] [ vj ] [ wi ] * ( ualpha ) * ( valpha ) * ( 1 - walpha ) + b [ ui ] [ vi ] [ wj ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( walpha ) + b [ ui ] [ vj ] [ wj ] * ( 1 - ualpha ) * ( valpha ) * ( walpha ) + b [ uj ] [ vi ] [ wj ] * ( ualpha ) * ( 1 - valpha ) * ( walpha ) + b [ uj ] [ vj ] [ wj ] * ( ualpha ) * ( valpha ) * ( walpha ) , c [ ui ] [ vi ] [ wi ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + c [ ui ] [ vj ] [ wi ] * ( 1 - ualpha ) * ( valpha ) * ( 1 - walpha ) + c [ uj ] [ vi ] [ wi ] * ( ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + c [ uj ] [ vj ] [ wi ] * ( ualpha ) * ( valpha ) * ( 1 - walpha ) + c [ ui ] [ vi ] [ wj ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( walpha ) + c [ ui ] [ vj ] [ wj ] * ( 1 - ualpha ) * ( valpha ) * ( walpha ) + c [ uj ] [ vi ] [ wj ] * ( ualpha ) * ( 1 - valpha ) * ( walpha ) + c [ uj ] [ vj ] [ wj ] * ( ualpha ) * ( valpha ) * ( walpha ) ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class random_v3_v3_spline extends ExpressionFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; }private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double [ ] [ ] [ ] a;private double [ ] [ ] [ ] b;private double [ ] [ ] [ ] c;
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
            case 0: return double [ ] [ ] [ ].class;
            case 1: return double [ ] [ ] [ ].class;
            case 2: return double [ ] [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ] [ ]) value; return;
            case 1: b = (double [ ] [ ] [ ]) value; return;
            case 2: c = (double [ ] [ ] [ ]) value; return;
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
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public random_v3_v3_spline() {

         Random rand = new Random ( ) ;
         int size = 3 + rand . nextInt ( 3 ) ;
         a = new double [ size ] [ size ] [ size ] ;
         b = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ;
         c = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ 0 ] . length ;
         j ++ ) for ( int k = 0 ;
         k < a [ 0 ] [ 0 ] . length ;
         k ++ ) {
         a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ;
         b [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ;
         c [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ;
         }
      }

      public LVect3d evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double ualpha = u * a . length - Math . floor ( u * a . length ) ;
         double v = x . y - Math . floor ( x . y ) ;
         double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ;
         double w = x . z - Math . floor ( x . z ) ;
         double walpha = w * a [ 0 ] [ 0 ] . length - Math . floor ( w * a [ 0 ] [ 0 ] . length ) ;
         int ui = ( int ) ( u * a . length ) ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ;
         double rx = 0 ;
         double ry = 0 ;
         double rz = 0 ;
         for ( int i = - 1 ;
         i <= 2 ;
         i ++ ) for ( int j = - 1 ;
         j <= 2 ;
         j ++ ) for ( int k = - 1 ;
         k <= 2 ;
         k ++ ) {
         double coeff = splineEval ( ualpha , i ) * splineEval ( valpha , j ) * splineEval ( walpha , k ) ;
         rx += a [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] [ getWrap ( wi + k ) ] * coeff ;
         ry += b [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] [ getWrap ( wi + k ) ] * coeff ;
         rz += c [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] [ getWrap ( wi + k ) ] * coeff ;
         }
         return new LVect3d ( rx , ry , rz ) ;
      }

      public Class getReturnType() {
         return LVect3d.class;
      }

   }

   public static class random_v3_col_const extends ExpressionFunction {

      private double [ ] [ ] [ ] a;private double [ ] [ ] [ ] b;private double [ ] [ ] [ ] c;
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
            case 0: return double [ ] [ ] [ ].class;
            case 1: return double [ ] [ ] [ ].class;
            case 2: return double [ ] [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ] [ ]) value; return;
            case 1: b = (double [ ] [ ] [ ]) value; return;
            case 2: c = (double [ ] [ ] [ ]) value; return;
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
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public random_v3_col_const() {

         Random rand = new Random ( ) ;
         a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ;
         b = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ;
         c = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ 0 ] . length ;
         j ++ ) for ( int k = 0 ;
         k < a [ 0 ] [ 0 ] . length ;
         k ++ ) {
         a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 1 ;
         b [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 1 ;
         c [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 1 ;
         }
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double v = x . y - Math . floor ( x . y ) ;
         double w = x . z - Math . floor ( x . z ) ;
         int ui = ( int ) ( u * a . length ) ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ;
         return new Color ( a [ ui ] [ vi ] [ wi ] , b [ ui ] [ vi ] [ wi ] , c [ ui ] [ vi ] [ wi ] ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class random_v3_col_linear extends ExpressionFunction {

      private double [ ] [ ] [ ] a;private double [ ] [ ] [ ] b;private double [ ] [ ] [ ] c;
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
            case 0: return double [ ] [ ] [ ].class;
            case 1: return double [ ] [ ] [ ].class;
            case 2: return double [ ] [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ] [ ]) value; return;
            case 1: b = (double [ ] [ ] [ ]) value; return;
            case 2: c = (double [ ] [ ] [ ]) value; return;
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
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public random_v3_col_linear() {

         Random rand = new Random ( ) ;
         a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ;
         b = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ;
         c = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ 0 ] . length ;
         j ++ ) for ( int k = 0 ;
         k < a [ 0 ] [ 0 ] . length ;
         k ++ ) {
         a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 1 ;
         b [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 1 ;
         c [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 1 ;
         }
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double ualpha = u * a . length - Math . floor ( u * a . length ) ;
         double v = x . y - Math . floor ( x . y ) ;
         double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ;
         double w = x . z - Math . floor ( x . z ) ;
         double walpha = w * a [ 0 ] [ 0 ] . length - Math . floor ( w * a [ 0 ] [ 0 ] . length ) ;
         int ui = ( int ) ( u * a . length ) ;
         int uj = ( ui + 1 ) % a . length ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         int vj = ( vi + 1 ) % a [ 0 ] . length ;
         int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ;
         int wj = ( wi + 1 ) % a [ 0 ] [ 0 ] . length ;
         return new Color ( a [ ui ] [ vi ] [ wi ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + a [ ui ] [ vj ] [ wi ] * ( 1 - ualpha ) * ( valpha ) * ( 1 - walpha ) + a [ uj ] [ vi ] [ wi ] * ( ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + a [ uj ] [ vj ] [ wi ] * ( ualpha ) * ( valpha ) * ( 1 - walpha ) + a [ ui ] [ vi ] [ wj ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( walpha ) + a [ ui ] [ vj ] [ wj ] * ( 1 - ualpha ) * ( valpha ) * ( walpha ) + a [ uj ] [ vi ] [ wj ] * ( ualpha ) * ( 1 - valpha ) * ( walpha ) + a [ uj ] [ vj ] [ wj ] * ( ualpha ) * ( valpha ) * ( walpha ) , b [ ui ] [ vi ] [ wi ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + b [ ui ] [ vj ] [ wi ] * ( 1 - ualpha ) * ( valpha ) * ( 1 - walpha ) + b [ uj ] [ vi ] [ wi ] * ( ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + b [ uj ] [ vj ] [ wi ] * ( ualpha ) * ( valpha ) * ( 1 - walpha ) + b [ ui ] [ vi ] [ wj ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( walpha ) + b [ ui ] [ vj ] [ wj ] * ( 1 - ualpha ) * ( valpha ) * ( walpha ) + b [ uj ] [ vi ] [ wj ] * ( ualpha ) * ( 1 - valpha ) * ( walpha ) + b [ uj ] [ vj ] [ wj ] * ( ualpha ) * ( valpha ) * ( walpha ) , c [ ui ] [ vi ] [ wi ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + c [ ui ] [ vj ] [ wi ] * ( 1 - ualpha ) * ( valpha ) * ( 1 - walpha ) + c [ uj ] [ vi ] [ wi ] * ( ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + c [ uj ] [ vj ] [ wi ] * ( ualpha ) * ( valpha ) * ( 1 - walpha ) + c [ ui ] [ vi ] [ wj ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( walpha ) + c [ ui ] [ vj ] [ wj ] * ( 1 - ualpha ) * ( valpha ) * ( walpha ) + c [ uj ] [ vi ] [ wj ] * ( ualpha ) * ( 1 - valpha ) * ( walpha ) + c [ uj ] [ vj ] [ wj ] * ( ualpha ) * ( valpha ) * ( walpha ) ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public static class random_v3_col_spline extends ExpressionFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; }private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double [ ] [ ] [ ] a;private double [ ] [ ] [ ] b;private double [ ] [ ] [ ] c;
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
            case 0: return double [ ] [ ] [ ].class;
            case 1: return double [ ] [ ] [ ].class;
            case 2: return double [ ] [ ] [ ].class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: a = (double [ ] [ ] [ ]) value; return;
            case 1: b = (double [ ] [ ] [ ]) value; return;
            case 2: c = (double [ ] [ ] [ ]) value; return;
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
            case 0: return LVect3d.class;
            default: return null;
         }

      }

      public random_v3_col_spline() {

         Random rand = new Random ( ) ;
         int size = 3 + rand . nextInt ( 3 ) ;
         a = new double [ size ] [ size ] [ size ] ;
         b = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ;
         c = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ;
         for ( int i = 0 ;
         i < a . length ;
         i ++ ) for ( int j = 0 ;
         j < a [ 0 ] . length ;
         j ++ ) for ( int k = 0 ;
         k < a [ 0 ] [ 0 ] . length ;
         k ++ ) {
         a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 1 ;
         b [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 1 ;
         c [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 1 ;
         }
      }

      public Color evaluate(Context context, Object[] inputs) {
         LVect3d x = (LVect3d)inputs[0];
         double u = x . x - Math . floor ( x . x ) ;
         double ualpha = u * a . length - Math . floor ( u * a . length ) ;
         double v = x . y - Math . floor ( x . y ) ;
         double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ;
         double w = x . z - Math . floor ( x . z ) ;
         double walpha = w * a [ 0 ] [ 0 ] . length - Math . floor ( w * a [ 0 ] [ 0 ] . length ) ;
         int ui = ( int ) ( u * a . length ) ;
         int vi = ( int ) ( v * a [ 0 ] . length ) ;
         int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ;
         double rx = 0 ;
         double ry = 0 ;
         double rz = 0 ;
         for ( int i = - 1 ;
         i <= 2 ;
         i ++ ) for ( int j = - 1 ;
         j <= 2 ;
         j ++ ) for ( int k = - 1 ;
         k <= 2 ;
         k ++ ) {
         double coeff = splineEval ( ualpha , i ) * splineEval ( valpha , j ) * splineEval ( walpha , k ) ;
         rx += a [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] [ getWrap ( wi + k ) ] * coeff ;
         ry += b [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] [ getWrap ( wi + k ) ] * coeff ;
         rz += c [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] [ getWrap ( wi + k ) ] * coeff ;
         }
         return new Color ( rx , ry , rz ) ;
      }

      public Class getReturnType() {
         return Color.class;
      }

   }

   public String getDescription() {
      return "random values";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new rand_i());
      r.add(new permutation_i());
      r.add(new random_d_d_const());
      r.add(new random_d_d_linear());
      r.add(new random_d_d_spline());
      r.add(new random_d_v2_const());
      r.add(new random_d_v2_linear());
      r.add(new random_d_v2_spline());
      r.add(new random_d_v3_const());
      r.add(new random_d_v3_linear());
      r.add(new random_d_v3_spline());
      r.add(new random_d_col_const());
      r.add(new random_d_col_linear());
      r.add(new random_d_col_spline());
      r.add(new random_v2_d_const());
      r.add(new random_v2_d_linear());
      r.add(new random_v2_d_spline());
      r.add(new random_v2_v2_const());
      r.add(new random_v2_v2_linear());
      r.add(new random_v2_v2_spline());
      r.add(new random_v2_v3_const());
      r.add(new random_v2_v3_linear());
      r.add(new random_v2_v3_spline());
      r.add(new random_v2_col_const());
      r.add(new random_v2_col_linear());
      r.add(new random_v2_col_spline());
      r.add(new random_v3_d_const());
      r.add(new random_v3_d_linear());
      r.add(new random_v3_d_spline());
      r.add(new random_v3_v2_const());
      r.add(new random_v3_v2_linear());
      r.add(new random_v3_v2_spline());
      r.add(new random_v3_v3_const());
      r.add(new random_v3_v3_linear());
      r.add(new random_v3_v3_spline());
      r.add(new random_v3_col_const());
      r.add(new random_v3_col_linear());
      r.add(new random_v3_col_spline());
      return r;
   }

}
