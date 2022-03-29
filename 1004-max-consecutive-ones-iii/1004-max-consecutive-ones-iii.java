class Solution {
    public int longestOnes(int[] arr, int k) {
        int n =  arr.length;
        int count0 =0, count1=0;
        int i =0, j =  0;
        int maxLen = 0;
        while(i<n){
            // acqire
            if(arr[i]==1){
                count1++;
            }
            else{
                count0++;
            }
            
            if(count0<=k){
                maxLen = Math.max(count1+count0 , maxLen);
            }else{
                while(count0>k){
                    if(arr[j]==0) count0--;
                    else count1--;
                    j++;
                }
            }
            
            i++;
            
            
        }

        return maxLen;
        
    }
}