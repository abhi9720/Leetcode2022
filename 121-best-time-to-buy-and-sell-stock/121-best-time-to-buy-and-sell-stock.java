class Solution {
    public int maxProfit(int[] prices) {
        Stack<Integer> stk =  new Stack<>();
        // buy at as lower as possible 
        int maxProfit = 0;
        
        for(int ele : prices){
            if(stk.size() ==0 ) stk.push(ele);
            else if(stk.peek() > ele ){
                stk.pop();
                stk.push(ele);
            }
            else {
                maxProfit =  Math.max(maxProfit , ele - stk.peek()  );
            }
            
        }
        return maxProfit;
    }
}