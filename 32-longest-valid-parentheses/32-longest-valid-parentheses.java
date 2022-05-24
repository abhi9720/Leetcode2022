class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk =  new Stack<>();
        stk.push(-1);
        int maxLen=0;
        for(int i=0;i<s.length();i++ ){
            if(s.charAt(i)=='(' ){
                stk.push(i);
            }
            else{
                stk.pop(); // here we removed open bracket
                // if there is no opening bracket in stack
                // then stack will be empty and push current ith index 
                if(stk.empty() ){
                    stk.push(i);
                }
                else{
                    // as we popped open bracket
                    // we are willing to find , max len ending at
                    // index i
                    // here ith index is closing bracket
                    // that means , max len at ith closing bracket
                    maxLen =  Math.max(maxLen, i -  stk.peek() );
                }
            }
        }
        
        return maxLen;
        
        
    }
}