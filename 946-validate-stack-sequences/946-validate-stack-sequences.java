class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pu =  0, po = 0;
        int n =  pushed.length;
        Stack<Integer> stk =  new Stack<>();
        
        while( pu<n && po<n){
            stk.push(pushed[pu]);            
            while(stk.size()>0&& po<n && stk.peek()== popped[po]  ){
                stk.pop();
                po++;
            }    
            pu++;
        }                                
        return po==n;
    }
}