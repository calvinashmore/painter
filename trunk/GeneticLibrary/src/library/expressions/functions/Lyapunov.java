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
import utils.lyapunov.*;

public final class Lyapunov implements AllComponents<ExpressionFunction>, Described {

   public static class sin2b extends ExpressionFunction implements LyapunovFunction {
      public double apply ( double x , double k ) { return b * Math . pow ( Math . sin ( x + k ) , 2 ) ; }public double deriv ( double x , double k ) { return 2 * b * Math . sin ( x + k ) * Math . cos ( x + k ) ; }
      private double b;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return b;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "b";
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
            case 0: b = (Double) value; return;
            default: return;
         }

      }

      public sin2b() {
         addGroupMeta(this);
         b = Math . random ( ) * 2 + 1 ;
      }

      public LyapunovFunction evaluate(Context context, Object[] inputs) {

         return this ;
      }

      public Class getReturnType() {
         return LyapunovFunction.class;
      }

   }

   public static class sin2b1 extends ExpressionFunction implements LyapunovFunction {
      private double b ;public double apply ( double x , double k ) { return b * Math . pow ( Math . sin ( x + k ) , 2 ) ; }public double deriv ( double x , double k ) { return 2 * b * Math . sin ( x + k ) * Math . cos ( x + k ) ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "b_in";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public sin2b1() {
         addGroupMeta(this);
      }

      public LyapunovFunction evaluate(Context context, Object[] inputs) {
         LDouble b_in = (LDouble)inputs[0];
         b = b_in . val ;
         return this ;
      }

      public Class getReturnType() {
         return LyapunovFunction.class;
      }

   }

   public static class cos2b extends ExpressionFunction implements LyapunovFunction {
      public double apply ( double x , double k ) { return b * Math . pow ( Math . cos ( x + k ) , 2 ) ; }public double deriv ( double x , double k ) { return - 2 * b * Math . cos ( x + k ) * Math . sin ( x + k ) ; }
      private double b;
      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return b;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "b";
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
            case 0: b = (Double) value; return;
            default: return;
         }

      }

      public cos2b() {
         addGroupMeta(this);
         b = Math . random ( ) * 2 + 1 ;
      }

      public LyapunovFunction evaluate(Context context, Object[] inputs) {

         return this ;
      }

      public Class getReturnType() {
         return LyapunovFunction.class;
      }

   }

   public static class cos2b1 extends ExpressionFunction implements LyapunovFunction {
      private double b ;public double apply ( double x , double k ) { return b * Math . pow ( Math . cos ( x + k ) , 2 ) ; }public double deriv ( double x , double k ) { return - 2 * b * Math . cos ( x + k ) * Math . sin ( x + k ) ; }
      public int getNumberInputs() {
         return 1;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "b_in";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LDouble.class;
            default: return null;
         }

      }

      public cos2b1() {
         addGroupMeta(this);
      }

      public LyapunovFunction evaluate(Context context, Object[] inputs) {
         LDouble b_in = (LDouble)inputs[0];
         b = b_in . val ;
         return this ;
      }

      public Class getReturnType() {
         return LyapunovFunction.class;
      }

   }

   public static class kcos2 extends ExpressionFunction implements LyapunovFunction {
      public double apply ( double x , double k ) { return k * Math . pow ( Math . cos ( x ) , 2 ) ; }public double deriv ( double x , double k ) { return - 2 * k * Math . cos ( x ) * Math . sin ( x ) ; }
      public kcos2() {
         addGroupMeta(this);
      }

      public LyapunovFunction evaluate(Context context, Object[] inputs) {

         return this ;
      }

      public Class getReturnType() {
         return LyapunovFunction.class;
      }

   }

   public static class logistic_saw extends ExpressionFunction implements LyapunovFunction {
      public double apply ( double x , double k ) { k = k - 4 * Math . floor ( k / 4 ) ; return k * x * ( 1 - x ) ; }public double deriv ( double x , double k ) { k = k - 4 * Math . floor ( k / 4 ) ; return k - 2 * k * x ; }
      public logistic_saw() {
         addGroupMeta(this);
      }

      public LyapunovFunction evaluate(Context context, Object[] inputs) {

         return this ;
      }

      public Class getReturnType() {
         return LyapunovFunction.class;
      }

   }

   public static class Lyapunov_2_v2 extends ExpressionFunction {
      private static final int prelim = 20 ;private static final int iterations = 100 ;private char seqAt ( int i ) { return sequence . charAt ( i % sequence . length ( ) ) ; }
      private String sequence;private double seed;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return sequence;
            case 1: return seed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "sequence";
            case 1: return "seed";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return String.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: sequence = (String) value; return;
            case 1: seed = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "f";
            case 1: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LyapunovFunction.class;
            case 1: return LVect2d.class;
            default: return null;
         }

      }

      public Lyapunov_2_v2() {
         addGroupMeta(this);
         int len = 2 + ( int ) ( Math . random ( ) * 6 ) ;
         char chars [ ] = new char [ len ] ;
         chars [ 0 ] = 'a' ;
         do {
         for ( int i = 1 ;
         i < len ;
         i ++ ) chars [ i ] = ( char ) ( 'a' + ( Math . random ( ) * 2 ) ) ;
         sequence = new String ( chars ) ;
         }
         while ( sequence . indexOf ( 'b' ) == - 1 ) ;
         seed = Math . random ( ) * Math . PI ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         LyapunovFunction f = (LyapunovFunction)inputs[0];
         LVect2d v = (LVect2d)inputs[1];
         double x = v . x ;
         double y = v . y ;
         double sum = 0 ;
         double p = seed ;
         for ( int i = 0 ;
         i < iterations ;
         i ++ ) {
         char seq = seqAt ( i ) ;
         if ( i > prelim ) {
         if ( seq == 'a' ) sum += Math . log ( Math . abs ( f . deriv ( p , x ) ) ) ;
         else sum += Math . log ( Math . abs ( f . deriv ( p , y ) ) ) ;
         }
         if ( seq == 'a' ) p = f . apply ( p , x ) ;
         else p = f . apply ( p , y ) ;
         }
         sum /= ( iterations - prelim ) ;
         if ( sum < 0 ) sum /= 2 ;
         else sum *= 2 ;
         return new LDouble ( sum ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Lyapunov_2_dd extends ExpressionFunction {
      private static final int prelim = 20 ;private static final int iterations = 100 ;private char seqAt ( int i ) { return sequence . charAt ( i % sequence . length ( ) ) ; }
      private String sequence;private double seed;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return sequence;
            case 1: return seed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "sequence";
            case 1: return "seed";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return String.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: sequence = (String) value; return;
            case 1: seed = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 3;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "f";
            case 1: return "x1";
            case 2: return "y1";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LyapunovFunction.class;
            case 1: return LDouble.class;
            case 2: return LDouble.class;
            default: return null;
         }

      }

      public Lyapunov_2_dd() {
         addGroupMeta(this);
         int len = 2 + ( int ) ( Math . random ( ) * 6 ) ;
         char chars [ ] = new char [ len ] ;
         chars [ 0 ] = 'a' ;
         do {
         for ( int i = 1 ;
         i < len ;
         i ++ ) chars [ i ] = ( char ) ( 'a' + ( Math . random ( ) * 2 ) ) ;
         sequence = new String ( chars ) ;
         }
         while ( sequence . indexOf ( 'b' ) == - 1 ) ;
         seed = Math . random ( ) * Math . PI ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         LyapunovFunction f = (LyapunovFunction)inputs[0];
         LDouble x1 = (LDouble)inputs[1];
         LDouble y1 = (LDouble)inputs[2];
         double x = x1 . val ;
         double y = y1 . val ;
         double sum = 0 ;
         double p = seed ;
         for ( int i = 0 ;
         i < iterations ;
         i ++ ) {
         char seq = seqAt ( i ) ;
         if ( i > prelim ) {
         if ( seq == 'a' ) sum += Math . log ( Math . abs ( f . deriv ( p , x ) ) ) ;
         else sum += Math . log ( Math . abs ( f . deriv ( p , y ) ) ) ;
         }
         if ( seq == 'a' ) p = f . apply ( p , x ) ;
         else p = f . apply ( p , y ) ;
         }
         sum /= ( iterations - prelim ) ;
         if ( sum < 0 ) sum /= 2 ;
         else sum *= 2 ;
         return new LDouble ( sum ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public static class Lyapunov_3_v3 extends ExpressionFunction {
      private static final int prelim = 20 ;private static final int iterations = 100 ;private char seqAt ( int i ) { return sequence . charAt ( i % sequence . length ( ) ) ; }
      private String sequence;private double seed;
      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         switch(i) {
            case 0: return sequence;
            case 1: return seed;
            default: return null;
         }

      }

      public String getParameterName(int i) {
         switch(i) {
            case 0: return "sequence";
            case 1: return "seed";
            default: return null;
         }

      }

      public Class getParameterType(int i) {
         switch(i) {
            case 0: return String.class;
            case 1: return double.class;
            default: return null;
         }

      }

      public void setParameter(int i, Object value) {
         switch(i) {
            case 0: sequence = (String) value; return;
            case 1: seed = (Double) value; return;
            default: return;
         }

      }

      public int getNumberInputs() {
         return 2;
      }

      public String getInputName(int i) {
         switch(i) {
            case 0: return "f";
            case 1: return "v";
            default: return null;
         }

      }

      public Class getInputType(int i) {
         switch(i) {
            case 0: return LyapunovFunction.class;
            case 1: return LVect3d.class;
            default: return null;
         }

      }

      public Lyapunov_3_v3() {
         addGroupMeta(this);
         int len = 2 + ( int ) ( Math . random ( ) * 6 ) ;
         char chars [ ] = new char [ len ] ;
         chars [ 0 ] = 'a' ;
         do {
         for ( int i = 1 ;
         i < len ;
         i ++ ) chars [ i ] = ( char ) ( 'a' + ( Math . random ( ) * 3 ) ) ;
         sequence = new String ( chars ) ;
         }
         while ( sequence . indexOf ( 'b' ) == - 1 && sequence . indexOf ( 'c' ) == - 1 ) ;
         seed = Math . random ( ) * Math . PI ;
      }

      public LDouble evaluate(Context context, Object[] inputs) {
         LyapunovFunction f = (LyapunovFunction)inputs[0];
         LVect3d v = (LVect3d)inputs[1];
         double x = v . x ;
         double y = v . y ;
         double z = v . z ;
         double sum = 0 ;
         double p = seed ;
         for ( int i = 0 ;
         i < iterations ;
         i ++ ) {
         char seq = seqAt ( i ) ;
         if ( i > prelim ) {
         if ( seq == 'a' ) sum += Math . log ( Math . abs ( f . deriv ( p , x ) ) ) ;
         else if ( seq == 'b' ) sum += Math . log ( Math . abs ( f . deriv ( p , y ) ) ) ;
         else sum += Math . log ( Math . abs ( f . deriv ( p , z ) ) ) ;
         }
         if ( seq == 'a' ) p = f . apply ( p , x ) ;
         else if ( seq == 'b' ) p = f . apply ( p , y ) ;
         else p = f . apply ( p , z ) ;
         }
         sum /= ( iterations - prelim ) ;
         if ( sum < 0 ) sum /= 2 ;
         else sum *= 2 ;
         return new LDouble ( sum ) ;
      }

      public Class getReturnType() {
         return LDouble.class;
      }

   }

   public String getDescription() {
      return "Lyapunov fractals";
   }

   public List<ExpressionFunction> allInstances(ContextModel cm) {
      List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
      r.add(new sin2b());
      r.add(new sin2b1());
      r.add(new cos2b());
      r.add(new cos2b1());
      r.add(new kcos2());
      r.add(new logistic_saw());
      r.add(new Lyapunov_2_v2());
      r.add(new Lyapunov_2_dd());
      r.add(new Lyapunov_3_v3());
      return r;
   }

   private static void addGroupMeta(Metadata item) {

   }

}
