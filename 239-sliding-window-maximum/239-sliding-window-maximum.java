class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        
    int n =  arr.length;
    int nge[] =  new int[n]; // fill this nge array
    nge[n-1] =  n;
    Stack<Integer>stk =  new Stack<>();
    stk.push(n-1);
    for(int i=n-2;i>=0;i--){
       while( stk.size()>0 && arr[i] > arr[stk.peek()] ){
          stk.pop();
       }
       if(stk.size()==0){
         nge[i] = n;
       }
       else{
          nge[i] = stk.peek();
       }
       stk.push(i);
    }
    
    int ans[] =  new int[n-k+1];
    int j=0;
    for(int i=0;i<=n-k;i++ ){
       if(j<i){
          j=i;
       }
       while(nge[j] < i+k){
          j=nge[j];
       }
      ans[i] =  arr[j];
    }
        return ans;
    }
}