class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n =  nums.length;
        Stack<Integer> stk =  new Stack<Integer>();
        int ans[] =  new int[n];
        Arrays.fill(ans,-1);
        int index =  0;
        int count  = 0;
        for(int i=0;i<2*n ; i++ ){
            // those which are removed by me , for those element i am the nge
            while(stk.size()>0 && nums[stk.peek()] < nums[i%n]  ){
                ans[stk.pop()]  = nums[i%n];                
            }            
            stk.push(i%n);             
        }
        return ans;        
    }
}