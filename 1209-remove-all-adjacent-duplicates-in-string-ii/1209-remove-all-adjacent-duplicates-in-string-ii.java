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
        Stack<int[]> stk  =  new Stack<>();
        for(char c : s.toCharArray() ){
            if(stk.isEmpty() || stk.peek()[0]!=c ){
                stk.push(new int[]{c , 1} );
            }
            else{
                stk.peek()[1]++;
            }
            
            if(stk.peek()[1]==k){
               stk.pop();                
            }
                
        }
        
        StringBuilder sb =  new StringBuilder();
        for(int[] p : stk){
            while(p[1]-->0) sb.append((char)p[0]);
        }
        return sb.toString();
           
        
    }
}