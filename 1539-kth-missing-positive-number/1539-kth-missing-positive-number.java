class Solution {
    public int findKthPositive(int[] arr, int k) {
        int pos = k , n =  arr.length;
        int last =  1;
        for(int i=0;i<n;i++){
            int p =  pos;
            pos-= ( arr[i] -  last );
            if(pos <=0 ){
                return p+last-1;
            }
            last =  arr[i]+1;                            
        }
        return last+pos-1;
    }
}