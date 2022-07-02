import java.util.*;
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod  = 1000000007;
          Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long maxDiff_row = horizontalCuts[0]-0  ;
        int a=horizontalCuts.length ,b=verticalCuts.length;
        long maxDiff_col = verticalCuts[0]- 0;
      
       
        int i=0;
        
        while(i<a-1){                    
            maxDiff_row  = Math.max( maxDiff_row ,Math.abs(horizontalCuts[i+1] - horizontalCuts[i] ) );           
            i++;
            
        }
        maxDiff_row  = Math.max( maxDiff_row ,Math.abs(horizontalCuts[a-1] - h ) );           
                       
        
        
        
        
        int j =  0;
        while( j < b-1 ){            
            maxDiff_col  = Math.max( maxDiff_col ,Math.abs(verticalCuts[j+1] - verticalCuts[j] ) ); 
            j++;
            
        }
        
        
        maxDiff_col  = Math.max( maxDiff_col ,Math.abs(verticalCuts[b-1] - w ) );    
        
        
        // System.out.println(  maxDiff_row+"  "+maxDiff_col);
        return (int)(maxDiff_col%mod *maxDiff_row%mod  )%mod;
        
        
    }
}