class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stk =  new Stack<>();
        for(int i=0;i<arr.length;i++){
            int max =  arr[i];
            while(!stk.isEmpty() && stk.peek() > arr[i] ){
                max =  Math.max(max , stk.pop());                
            }
                
            if(stk.size()==0 || stk.peek() <= max ){
                stk.push(max);
            }            
        }
        return stk.size();
    }
}