class Solution {
    public int longestOnes(int[] arr, int k) {
        int n =  arr.length;
        int count0 =0, count1=0;
        int i =0, j =  0;
        int maxLen = 0;
        while(i<n){
            // acqire
            if(arr[i]==0){                
                count0++;
            }

            while(count0>k){
                if(arr[j]==0) count0--;                    
                    j++;
            }

            maxLen = Math.max(i-j+1, maxLen);
            i++;                        
        }
        return maxLen;
        
    }
}