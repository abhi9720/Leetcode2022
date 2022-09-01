class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        int n = temperatures.length;
        int ans[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while(stk.size()!=0 && temperatures[i] >= temperatures[stk.peek()]  ){
                stk.pop();
            }
            if(stk.size()!=0 ){
                ans[i] = stk.peek() - i ;
            }
            
            stk.push(i);
        }
        return ans;
    }
}
