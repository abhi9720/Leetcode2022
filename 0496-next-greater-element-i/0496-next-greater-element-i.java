class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map =  new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i], i);
        }
        int rightGreater[] =  new int[nums2.length];
        Stack<Integer> stk =  new Stack<>();
        int idx = nums2.length-1;
        rightGreater[idx] =  -1;
        stk.push(nums2[idx]);
        idx--;
        while(!stk.isEmpty() && idx>=0 ){
            while(stk.size()!=0 && stk.peek() <= nums2[idx] ){
                stk.pop();                
            }
            if(stk.size()==0 ){
                rightGreater[idx] = -1;
            }
            else{
                rightGreater[idx] =  stk.peek();
            }
            stk.push(nums2[idx]);                
            idx--;
        }
        int ans[] =  new int[nums1.length];
        int i=0;
        for(int ele : nums1){
            idx =  map.get(ele);
            ans[i++] =  rightGreater[idx];
        }
        return ans;
    }
}