class Solution {
    public int calculate(String s) {
        
        Stack<Integer> stk =  new Stack<>();
        int result = 0;        
        int number =  0;
        int sign = 1;
        
        for(int i=0;i<s.length();i++ ){
            char ch =  s.charAt(i);
            if(Character.isDigit(ch)){
                number =  number*10 + (int)(ch-'0');
            }
            else if(ch=='+'){
                result =  result+sign*number;
                number  = 0;
                sign = 1;
            }
            else if(ch=='-'){
                result =  result+sign*number;
                number = 0;
                sign=-1;
            }
            else if(ch=='('){
                stk.push(result);
                stk.push(sign);
                result = 0;
                sign =  1;                                    
            }
            else if(ch==')'){
                result =  result + sign*number;
                result =  result*stk.pop();
                result =  result+stk.pop();     
                number=0;
            }               
        }
        
        if(number!=0) result =  result+sign*number;
        return result;
    }
}