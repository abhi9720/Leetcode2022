class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk =  new Stack<>();
        for(String op : tokens){
            if(isOPerator(op) ){
                Integer op1 = stk.pop();
                Integer op2 =  stk.pop();
                if(op.equals("+") ){
                    stk.add(op1+op2);
                }
                else if(op.equals("-") ){
                    stk.add(op2-op1);
                }
                else if(op.equals("*") ){
                    stk.add(op1*op2);
                }
                else{
                    stk.add(op2/op1);
                }
            }
            else{
                stk.push(Integer.parseInt(op) );
            }
        }
        return stk.pop();
    }
    private boolean isOPerator(String op){
        return op.equals("+") || op.equals("-") || op.equals("/") || op.equals("*");
    }
}