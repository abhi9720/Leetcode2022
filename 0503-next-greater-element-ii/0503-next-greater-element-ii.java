class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n =  nums.length;
        Stack<Integer> stk =  new Stack<>();
        // here we store index 
        int idx = n-1;
        int ans[] =  new int[n];
      
        int count = 0;
        while(count <=1  ){
            while(stk.size()!=0 && nums[stk.peek()] <= nums[idx] ){
                stk.pop();
            }
            
            if(stk.size()!=0 ){
                ans[idx] =  nums[stk.peek()];
            }
            else{
                ans[idx] = -1;
            }
            stk.push(idx);            
            idx =  idx-1;
            if(idx<0) count++;
            idx = (idx+n)%n;
            
        }
        return ans;
            
            
        
    }
}