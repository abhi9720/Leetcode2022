class Solution {
    public int minAddToMakeValid(String s) {
        // Stack<Character> stk =  new Stack<>();
        // for(char ch : s.toCharArray()){
        //     if(stk.size()>0 && stk.peek()=='(' && ch==')' ){
        //         stk.pop();
        //     }
        //     else{
        //         stk.push(ch);
        //     }
        // }
        // return stk.size();
        // without stack
        int open = 0,  close = 0;
        for(char ch : s.toCharArray()){
            if(ch==')'){
                if( open>0){
                    open--;
                }
                else{
                    close++;
                }
            }else{
                open++;
            }                            
        }
        return open+close;
    }
}