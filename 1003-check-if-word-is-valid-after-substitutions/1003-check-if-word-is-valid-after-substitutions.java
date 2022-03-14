class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stk = new Stack<>();
        
        for(char ch : s.toCharArray()){            
            if(ch=='a'){
                stk.push(ch);
            }
            else if(ch=='b'){
                if(stk.isEmpty()) return false;
                if(stk.peek()=='a') stk.pop();
                else return false;
                stk.push(ch);
            }
            else if(ch=='c'){
                if(stk.isEmpty()) return false;
                if(stk.peek()=='b') stk.pop();
                else return false;                
            }                        
        }
        return stk.isEmpty();             
    }
}