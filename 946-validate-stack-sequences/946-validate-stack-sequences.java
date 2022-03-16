class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pu =  0, po = 0;
        int n =  pushed.length;
        Stack<Integer> stk =  new Stack<>();
        Set<Integer> used = new HashSet<>();
        while( pu<n && po<n){
            if( stk.size()>0 && stk.peek()== popped[po] ){
                // case 1 
                stk.pop();
                po++;
            }else{
                if(used.contains(popped[po]) ){
                    return false;
                }                     
                while(pu<n ){
                    stk.push( pushed[pu] );
                    used.add(pushed[pu] );                    
                    if(pushed[pu]==popped[po] ){
                        pu++;
                        break;
                    }                           
                    pu++;
                }                                         
            }                                                
        }
        
        while(po<n && stk.peek()== popped[po]  ){
            stk.pop();
            po++;
        }        
                
        return po==n;
    }
}