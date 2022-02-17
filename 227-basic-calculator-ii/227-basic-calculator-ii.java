class Solution {
    public int calculate(String s) {
        
        Stack<Integer> stk  =  new Stack<Integer>();
        Stack<Character> op = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch =  s.charAt(i);
            if(ch==' ') continue;
            // now create number
            if( Character.isDigit(s.charAt(i) )  ){
                int num  =  s.charAt(i)-'0';
                
                while(i+1<s.length() && Character.isDigit( s.charAt(i+1) ) ){
                    num = num*10 + s.charAt(i+1)-'0';
                    i++;
                    
                }
                
                stk.push(num);                
            }
            else{// otherwise some symbol 
                while(!stk.empty() && !op.empty() && precedence( ch ) <= precedence( op.peek() ) ){ 
                    evaluate(stk,op );
                }
                op.push(ch);
            }     
            // System.out.println(stk);
            // System.out.println(op);
        }
         while(!stk.empty() && !op.empty() ){ 
                    evaluate(stk,op );
        }
        
        
        return stk.pop();
    }
    public int precedence(char c){
        if(c=='+') return 1;
        else if(c=='-') return 1;
        else if(c=='*') return 2;
        else if(c=='/') return 2;
        else return 0;
    }
    public void evaluate(Stack<Integer> stk , Stack<Character>op){
        int num2 =  stk.pop();
        int num1  =  stk.pop();
        char oper = op.pop();
        stk.push( calc( num1,num2,oper ) );        
    }
    
    public int calc(int num1 , int num2 , char op){
        if(op=='+') return num1+num2;
        else if(op=='-') return num1-num2;
        else if(op=='*') return num1*num2;
        else return num1/num2;            
    }
}