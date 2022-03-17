class Solution {
    public int scoreOfParentheses(String s) {
        Stack<String> stk =  new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch =  s.charAt(i);
            if(ch =='(')    {
                stk.push(ch+"");
            }else {
                int innerscore = 0;
                // pop till now open bracket found 
                while(!stk.isEmpty() && !stk.peek().equals("(")){
                    innerscore += Integer.valueOf(stk.peek());
                    stk.pop();
                }
                stk.pop(); // also pop open bracket
                if(innerscore  ==  0){
                    stk.push(1+"");
                }
                else{
                    stk.push(innerscore*2+"");
                }                
            }
            
        }
        
        int score  = 0;
        while(stk.size()>0){
            score+=Integer.valueOf(stk.pop());
        }
        return score;
    }
}