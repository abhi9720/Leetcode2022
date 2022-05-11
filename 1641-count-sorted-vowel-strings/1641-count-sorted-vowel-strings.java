class Solution {
    public int countVowelStrings(int n) {
        //represent a,e,i,o,u - > 0,1,2,3,4
        // this previous sum is last column
        int prevCol[] =  new int[5];        
        int newCol[] =  new int[5];
        int previousSum = 1;
        for(int j=1;j<=n;j++){
            
            newCol[0] =  previousSum;
            int c = 0,sum= previousSum ;
            for(int i=1;i<=4;i++){
                c+=prevCol[i-1];
                newCol[i] = newCol[0] - c;
                sum+=newCol[i];
            }        
             System.arraycopy(newCol, 0, prevCol, 0, 5);             
            previousSum =  sum;
        }
        
                
        return previousSum;
        
        
        
        
        
        
    }
}