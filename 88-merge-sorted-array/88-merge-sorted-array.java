class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // move to last 
        // if(m==0 || n==0) return;
        int mpn =  nums1.length;
        int itr = mpn-1;
        for(int i=m-1;i>=0;i--){
            nums1[itr--] =  nums1[i];            
        }
        
        int p1 = itr+1,p2 =  0;
        itr = 0;
        while(m!=0 && (p1<mpn&& p2<n)){
            if(nums1[p1] < nums2[p2] ){
                nums1[itr++] =  nums1[p1++];                
            }
            else{
                nums1[itr++] =  nums2[p2++];                
            }            
        }
        
        while(m!=0 && p1<mpn){
            nums1[itr++] =  nums1[p1++];
        }
        while(p2<n){
            nums1[itr++] =  nums2[p2++]; 
        }        
    }
}