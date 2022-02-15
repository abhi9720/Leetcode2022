class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n =  nums.length;
        int stack[] =  new int[2*n];
        int itr = -1;
        int ans[] =  new int[n];
        Arrays.fill(ans,-1);
        int index =  0;
        int count  = 0;
        for(int i=0;i<2*n ; i++ ){
            // those which are removed by me , for those element i am the nge
            while(itr>=0 && nums[ stack[itr] ] < nums[i%n]  ){
                ans[stack[itr--]]  = nums[i%n];                
            }        
            stack[++itr] = (i%n);
            // stk.push(i%n);             
        }
        return ans;        
    }
}