class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stk =  new Stack<>();
        for(char ch : s.toCharArray() ){
            if( ch=='[' || ch=='(' || ch=='{' ){
                stk.push(ch);
            }else {
                if(stk.size()==0){
                    return false;
                }
                char topchar  =  stk.pop();
                if(topchar=='(' && ch==')');
                else if(topchar=='[' && ch==']');
                else if(topchar=='{' && ch=='}');
                else return false;
            }
        }
        return stk.isEmpty() && true;
        
    }
}