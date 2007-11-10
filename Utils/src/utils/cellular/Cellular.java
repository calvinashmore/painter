/*
 * Cellular.java
 *
 * Created on September 27, 2005, 10:01 AM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package utils.cellular;

import utils.*;
import utils.linear.LVect3d;

/**
 *
 * @author gtg126z
 */
public class Cellular {
    
    CellularParams params;
    CellularDistance distFunction;
    
    /** Creates a new instance of Cellular */
    public Cellular() {
        params = new CellularParams();
        distFunction = CellularDistance.getEuclidean();
    }
    
    public Cellular(CellularParams params, CellularDistance distFunction) {
        this.params = params;
        this.distFunction = distFunction;
    }
    
    private double F[];
    private double delta[][];
    private int ID[];
    
    public CellularResult evaluate(LVect3d pos) {
        double at[] = new double[3];
        at[0] = pos.x * params.scale.x + params.translate.x;
        at[1] = pos.y * params.scale.y + params.translate.y;
        at[2] = pos.z * params.scale.z + params.translate.z;
        
        Worley(at);
        
        return new CellularResult(F, delta);
    }
    
    private void Worley(double at[])
    {
      double x2,y2,z2, mx2, my2, mz2;
      double new_at[] = new double[3];
      int int_at[] = new int[3];
      int i;
      
      // Initialize vars
      F = new double[params.max_order];
      delta = new double[params.max_order][3];
      ID = new int[params.max_order];

      /* Initialize the F values to "huge" so they will be replaced by the
         first real sample tests. Note we'll be storing and comparing the
         SQUARED distance from the feature points to avoid lots of slow
         sqrt() calls. We'll use sqrt() only on the final answer. */
      for (i=0; i< params.max_order; i++)
          F[i] = Double.MAX_VALUE; //999999.9;

      /* Make our own local copy, multiplying to make mean(F[0])==1.0  */
      new_at[0] = params.densityAdjustment*at[0];
      new_at[1] = params.densityAdjustment*at[1];
      new_at[2] = params.densityAdjustment*at[2];

      /* Find the integer cube holding the hit point */
      int_at[0] = (int)Math.floor(new_at[0]); /* A macro could make this slightly faster */
      int_at[1] = (int)Math.floor(new_at[1]);
      int_at[2] = (int)Math.floor(new_at[2]);

      
      
      int ii,jj,kk;
      int crange = 2;
      for (ii=-crange; ii<=crange; ii++)
      for (jj=-crange; jj<=crange; jj++)
      for (kk=-crange; kk<=crange; kk++)
        if(Math.abs(ii) + Math.abs(jj) + Math.abs(kk) < 4)
            AddSamples(int_at[0]+ii,int_at[1]+jj,int_at[2]+kk, new_at);
       
      
      /* A simple way to compute the closest neighbors would be to test all
         boundary cubes exhaustively. This is simple with code like: 
         {
           long ii, jj, kk;
           for (ii=-1; ii<=1; ii++) for (jj=-1; jj<=1; jj++) for (kk=-1; kk<=1; kk++)
           AddSamples(int_at[0]+ii,int_at[1]+jj,int_at[2]+kk, 
           max_order, new_at, F, delta, ID);
         }
         But this wastes a lot of time working on cubes which are known to be
         too far away to matter! So we can use a more complex testing method
         that avoids this needless testing of distant cubes. This doubles the 
         speed of the algorithm. */

     /* 
      // Test the central cube for closest point(s). //
      AddSamples(int_at[0], int_at[1], int_at[2], new_at);

      // We test if neighbor cubes are even POSSIBLE contributors by examining the
      //   combinations of the sum of the squared distances from the cube's lower 
      //   or upper corners.
      
      x2=new_at[0]-int_at[0];
      y2=new_at[1]-int_at[1];
      z2=new_at[2]-int_at[2];
      mx2=(1.0-x2)*(1.0-x2);
      my2=(1.0-y2)*(1.0-y2);
      mz2=(1.0-z2)*(1.0-z2);
      x2*=x2;
      y2*=y2;
      z2*=z2;
      
      int range = params.max_order - 1;

      // Test 6 facing neighbors of center cube. These are closest and most 
      //   likely to have a close feature point. //
      if (x2<F[range])  AddSamples(int_at[0]-1, int_at[1]  , int_at[2]  , new_at);
      if (y2<F[range])  AddSamples(int_at[0]  , int_at[1]-1, int_at[2]  , new_at);
      if (z2<F[range])  AddSamples(int_at[0]  , int_at[1]  , int_at[2]-1, new_at);

      if (mx2<F[range]) AddSamples(int_at[0]+1, int_at[1]  , int_at[2]  , new_at);
      if (my2<F[range]) AddSamples(int_at[0]  , int_at[1]+1, int_at[2]  , new_at);
      if (mz2<F[range]) AddSamples(int_at[0]  , int_at[1]  , int_at[2]+1, new_at);

      // Test 12 "edge cube" neighbors if necessary. They're next closest. //
      if ( x2+ y2<F[range]) AddSamples(int_at[0]-1, int_at[1]-1, int_at[2]  , new_at);
      if ( x2+ z2<F[range]) AddSamples(int_at[0]-1, int_at[1]  , int_at[2]-1, new_at);
      if ( y2+ z2<F[range]) AddSamples(int_at[0]  , int_at[1]-1, int_at[2]-1, new_at);
      if (mx2+my2<F[range]) AddSamples(int_at[0]+1, int_at[1]+1, int_at[2]  , new_at);
      if (mx2+mz2<F[range]) AddSamples(int_at[0]+1, int_at[1]  , int_at[2]+1, new_at);
      if (my2+mz2<F[range]) AddSamples(int_at[0]  , int_at[1]+1, int_at[2]+1, new_at);
      if ( x2+my2<F[range]) AddSamples(int_at[0]-1, int_at[1]+1, int_at[2]  , new_at);
      if ( x2+mz2<F[range]) AddSamples(int_at[0]-1, int_at[1]  , int_at[2]+1, new_at);
      if ( y2+mz2<F[range]) AddSamples(int_at[0]  , int_at[1]-1, int_at[2]+1, new_at);
      if (mx2+ y2<F[range]) AddSamples(int_at[0]+1, int_at[1]-1, int_at[2]  , new_at);
      if (mx2+ z2<F[range]) AddSamples(int_at[0]+1, int_at[1]  , int_at[2]-1, new_at);
      if (my2+ z2<F[range]) AddSamples(int_at[0]  , int_at[1]+1, int_at[2]-1, new_at);

      // Final 8 "corner" cubes //
      if ( x2+ y2+ z2<F[range]) AddSamples(int_at[0]-1, int_at[1]-1, int_at[2]-1, new_at);
      if ( x2+ y2+mz2<F[range]) AddSamples(int_at[0]-1, int_at[1]-1, int_at[2]+1, new_at);
      if ( x2+my2+ z2<F[range]) AddSamples(int_at[0]-1, int_at[1]+1, int_at[2]-1, new_at);
      if ( x2+my2+mz2<F[range]) AddSamples(int_at[0]-1, int_at[1]+1, int_at[2]+1, new_at);
      if (mx2+ y2+ z2<F[range]) AddSamples(int_at[0]+1, int_at[1]-1, int_at[2]-1, new_at);
      if (mx2+ y2+mz2<F[range]) AddSamples(int_at[0]+1, int_at[1]-1, int_at[2]+1, new_at);
      if (mx2+my2+ z2<F[range]) AddSamples(int_at[0]+1, int_at[1]+1, int_at[2]-1, new_at);
      if (mx2+my2+mz2<F[range]) AddSamples(int_at[0]+1, int_at[1]+1, int_at[2]+1, new_at);
*/
      // We're done! Convert everything to right size scale //
      double invDensity = 1.0/params.densityAdjustment;
      for (i=0; i<params.max_order; i++)
        {
          F[i] = Math.sqrt(F[i]) * invDensity;      
          delta[i][0] *= invDensity;
          delta[i][1] *= invDensity;
          delta[i][2] *= invDensity;
        }
    }
    
    private void AddSamples(int xi, int yi, int zi, double at[]) {
        
      double dx, dy, dz, fx, fy, fz, d2;
      int count, index, i,j;
      int seed, this_id;

      /* Each cube has a random number seed based on the cube's ID number.
         The seed might be better if it were a nonlinear hash like Perlin uses
         for noise but we do very well with this faster simple one.
         Our LCG uses Knuth-approved constants for maximal periods. */
      seed=702395077*xi + 915488749*yi + 2120969693*zi;

      /* How many feature points are in this cube? */
      count = params.Poisson_count[(int)(seed>>24) & 255]; /* 256 element lookup table. Use MSB */

      seed=1402024253*seed+586950981; /* churn the seed with good Knuth LCG */

      for (j=0; j<count; j++) /* test and insert each point into our solution */
        {
          this_id=seed;
          seed=1402024253*seed+586950981; /* churn */

          /* compute the 0..1 feature point location's XYZ */
          fx=(seed+0.5)*(1.0/4294967296.0); 
          seed=1402024253*seed+586950981; /* churn */
          fy=(seed+0.5)*(1.0/4294967296.0);
          seed=1402024253*seed+586950981; /* churn */
          fz=(seed+0.5)*(1.0/4294967296.0);
          seed=1402024253*seed+586950981; /* churn */

          /* delta from feature point to sample location */
          dx=xi+fx-at[0]; 
          dy=yi+fy-at[1];
          dz=zi+fz-at[2];

          /* Distance computation!  Lots of interesting variations are
             possible here!
             Biased "stretched"   A*dx*dx+B*dy*dy+C*dz*dz
             Manhattan distance   fabs(dx)+fabs(dy)+fabs(dz)
             Radial Manhattan:    A*fabs(dR)+B*fabs(dTheta)+C*dz
             Superquadratic:      pow(fabs(dx), A) + pow(fabs(dy), B) + pow(fabs(dz),C)

             Go ahead and make your own! Remember that you must insure that
             new distance function causes large deltas in 3D space to map into
             large deltas in your distance function, so our 3D search can find
             them! [Alternatively, change the search algorithm for your special
             cases.]       
          */

          //d2=dx*dx+dy*dy+dz*dz; /* Euclidian distance, squared */
          d2 = distFunction.distance(dx,dy,dz);

          if (d2<F[params.max_order-1]) /* Is this point close enough to rememember? */
            {
              /* Insert the information into the output arrays if it's close enough.
                 We use an insertion sort.  No need for a binary search to find
                 the appropriate index.. usually we're dealing with order 2,3,4 so
                 we can just go through the list. If you were computing order 50
                 (wow!!) you could get a speedup with a binary search in the sorted
                 F[] list. */

              index=params.max_order;
              while (index>0 && d2<F[index-1])
                  index--;

              /* We insert this new point into slot # <index> */

              /* Bump down more distant information to make room for this new point. */
              for (i=params.max_order-1; i-- > index;)
                {
                  F[i+1]=F[i];
                  ID[i+1]=ID[i];
                  delta[i+1][0]=delta[i][0];
                  delta[i+1][1]=delta[i][1];
                  delta[i+1][2]=delta[i][2];
                }
              
              /* Insert the new point's information into the list. */
              F[index]=d2;
              ID[index]=this_id;
              delta[index][0]=dx;
              delta[index][1]=dy;
              delta[index][2]=dz;
            }
        }

      return;
    }
}
