class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
                
        int i =  rStart, j =  cStart;        
        
        int ans[][] =  new int[rows*cols][2];
        int idx =0;
        ans[idx++] =  new int[]{i,j};
        
        
        int looplen = 1;
        
        
        while(idx < rows*cols){            
            int loop =  looplen;
            while(loop-->0){                
                if(i>=0 && j+1>=0 && i<rows && j+1<cols){
                    
                    ans[idx++] =  new int[]{i,j+1};
                }       
                ++j;
            }
            
            loop =  looplen;
            while(loop-->0){                
                if(i+1>=0 && j>=0 && i+1<rows && j<cols){
                    ans[idx++] =  new int[]{i+1,j};
                }    
               
                ++i;
                
                
            }
            
            looplen+=1;
            loop =  looplen;
            while(loop-->0 ){
                if(i>=0 && j-1>=0 && i<rows && j-1<cols){
                    ans[idx++] =  new int[]{i,j-1};
                }
                --j;                
            }
            
            loop =  looplen;
            while(loop-->0 ){
                if(i-1>=0 && j>=0 && i-1<rows && j<cols){
                    ans[idx++] =  new int[]{i-1,j};
                }
                --i;                                
            }
            looplen+=1;
        }
        return ans;
        
    }
    
}