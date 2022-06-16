class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n  =  nums2.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i] ,  i );
        }
        
        int nge[] =  new int[n];
        Stack<Integer> stk =  new Stack<>();
        for(int i =  n-1;i>=0;i--){
            
            while(!stk.isEmpty() && stk.peek() < nums2[i] ){
                stk.pop();
            }            
            if(stk.size()==0 ) nge[i] =  -1;            
            else nge[i] =  stk.peek();
            
            stk.push(nums2[i] );            
        }
        

        int ans[] =  new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i] =  nge[map.get(nums1[i]) ];
        }
        return ans;
    }
}