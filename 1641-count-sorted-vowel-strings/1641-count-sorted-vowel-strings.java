class Solution {
    public int countVowelStrings(int n) {
        //represent a,e,i,o,u - > 0,1,2,3,4
        // [5][-]  - total sum
        int arr[][] =  new int[5][n+1];                
        int previousSum = 1;
        for(int j=1;j<=n;j++){
            arr[0][j] =  previousSum;
            int c = 0,sum= previousSum ;
            for(int i=1;i<=4;i++){
                c+=arr[i-1][j-1];
                arr[i][j] =  arr[0][j] - c;
                sum+=arr[i][j];
            }            
            previousSum =  sum;
        }
        
        
        
        return previousSum;
        
        
        
        
        
        
    }
}