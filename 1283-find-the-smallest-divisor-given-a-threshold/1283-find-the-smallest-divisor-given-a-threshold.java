class Solution {

    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, h = (int)1e6;
        
        while (l < h) {
            int mid = (l + h) / 2;            
            int count = sumTheSivision(nums, mid);
            if (count <= threshold) {
                h = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }

    int sumTheSivision(int nums[], int d) {
        int sum = 0;
        for (int ele : nums) {
            sum += Math.ceil(ele * 1.0 / d);
        }
        return sum;
    }
}
// l =  1 , h =  11 , count =  7
// l = 1 , h =  6 count =  11
// l =      
    