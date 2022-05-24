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
                stk.pop();
                if(stk.empty() ){
                    stk.push(i);
                }
                else{
                    maxLen =  Math.max(maxLen, i -  stk.peek() );
                }
            }
        }
        
        return maxLen;
        
        
    }
}