class Solution {
    public int countVowelStrings(int n) {
        //represent a,e,i,o,u - > 0,1,2,3,4
        // [5][-]  - total sum
        int arr[][] =  new int[6][n+1];
        for(int i=0;i<=4;i++){
            arr[i][1] =  1;
        }
        arr[5][1] =  5;
        for(int j=2;j<=n;j++){
            arr[0][j] =  arr[5][j-1];
            int c = 0,sum=arr[0][j] ;
            for(int i=1;i<=4;i++){
                c+=arr[i-1][j-1];
                arr[i][j] =  arr[0][j] - c;
                sum+=arr[i][j];
            }            
            arr[5][j] =  sum;
        }
        
        
        return arr[5][n];
        
        
        
        
        
        
    }
}