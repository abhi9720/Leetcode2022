class pair{
    char ch; 
    int count;
    public pair(char ch , int count){
        this.ch =  ch;
        this.count  =  count;
    }        
    public String toString(){
        return "["+ch+"-"+count+"";
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
                pair p = stk.pop();                
                p.count+=1;
                stk.push(p);
            }                        
            if(stk.peek().count==k){
               stk.pop();                
            }
                
        }
        
        StringBuilder sb =  new StringBuilder();
        for(pair p : stk){
            String str =  (p.ch+"").repeat(p.count);                         
            sb.append(str);
        }
        return sb.toString();
           
        
    }
}