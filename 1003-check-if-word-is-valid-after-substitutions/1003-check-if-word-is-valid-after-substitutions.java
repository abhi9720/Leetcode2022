class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stk = new Stack<>();
        
        for(char ch : s.toCharArray()){            
            if(ch=='a'){
                stk.push(ch);
            }
            else if(ch=='b'){
                if(stk.isEmpty() ||stk.peek()!='a' ) return false;
                stk.pop();                
                stk.push(ch);
            }
            else if(ch=='c'){
                if(stk.isEmpty() ||stk.peek()!='b' ) return false;
                stk.pop();                
            }                        
        }
        return stk.isEmpty();             
    }
}