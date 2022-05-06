class pair{
    char ch; 
    int count;
    public pair(char ch , int count){
        this.ch =  ch;
        this.count  =  count;
    }        
}
class Solution {
    
    
    public String removeDuplicates(String s, int k) {
        Stack<pair> stk  =  new Stack<>();
        for(char c : s.toCharArray() ){
            if(stk.isEmpty() || stk.peek().ch!=c ){
                stk.push(new pair(c , 1) );
            }
            else{
                int peekCount  =  stk.peek().count;
                stk.push(new pair(c , peekCount+1) );                                
            }
            if(stk.peek().count==k){
                    int loop =  k;
                     while(loop-->0){
                         stk.pop();
                     }                    
            }
                
        }
        StringBuilder sb =  new StringBuilder();
        for(pair p : stk){
            sb.append(p.ch);
        }
        return sb.toString();
           
        
    }
}