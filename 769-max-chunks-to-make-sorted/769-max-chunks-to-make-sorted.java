class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max =  arr[0];
        int count =0 ;
        for(int i=0;i<arr.length;i++){
            
            max =  Math.max(arr[i] , max);
            if(max == i) count++;
            
        }
        return count;
    }
}