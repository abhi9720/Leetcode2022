class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int k1 = (n + m + 1) / 2;
        int k2 = (n + m + 2) / 2;
        int median1 = getMedian(nums1, nums2, k1, 0, 0);
        int median2 = getMedian(nums1, nums2, k2, 0, 0);
        return (median1 + median2) / 2.0;
    }

    private int getMedian(int nums1[], int nums2[], int k, int s1, int s2) {
        if (s1 > nums1.length - 1) return nums2[s2 + k  - 1];
        if (s2 > nums2.length - 1) return nums1[s1 + k  - 1];

        if (k == 1) return Math.min(nums1[s1], nums2[s2]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;

        if (s1 + k / 2 - 1 < nums1.length) aMid = nums1[s1 + k / 2 - 1];
        if (s2 + k / 2 - 1 < nums2.length) bMid = nums2[s2 + k / 2 - 1];
        
        if(aMid<bMid){
            return getMedian(nums1,nums2,k-k/2,s1+k/2,s2);
        }
        else{
            return getMedian(nums1,nums2,k-k/2,s1,s2+k/2);
        }
        
        
        
    }
}
