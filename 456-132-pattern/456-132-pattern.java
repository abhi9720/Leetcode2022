class Solution {
    public boolean find132pattern(int[] nums) {
        // i,j,k -> a,b,c
        // a<c<b
        // 1) b>a and b>c and c>a
        // b will be a element such that , on left on it some element is small
        // and on right on it , some element is small
        
        int c =  Integer.MIN_VALUE;        
        Stack<Integer> stk =  new Stack<>();
        for(int i =  nums.length-1 ; i>=0 ;i-- ){
            if(nums[i] < c ) return true;
            
            while(!stk.isEmpty() && stk.peek() < nums[i] ){
                c =  stk.pop();
            }
            stk.push(nums[i]);            

        }
        return false;
        
        
        
    }
}