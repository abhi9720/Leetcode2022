class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stk =  new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stk.push(i);
            }
            else if(s.charAt(i)==')' ){
                // check wheather top bracket is open or not 
                if(stk.size()>0 && s.charAt(stk.peek())=='(' ){
                    int idx =  stk.peek();                     
                    stk.pop();
                    
                }else{
                    stk.push(i);
                }
                // else do nothing                     
            }
        }
        // at last we left with barcket in stack which are not forming pair 
        StringBuilder sb =  new StringBuilder(s);
        // while not stk is empty
        
        while(stk.size()>0){
            int idx =  stk.pop();
            sb.deleteCharAt(idx);
        }
        // now return this string 
        return sb.toString();
            
        
        
        
    }
}