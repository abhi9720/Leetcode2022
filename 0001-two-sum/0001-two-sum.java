class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map =  new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int ele =  nums[i];
            if(map.containsKey(target -  ele) ){
                return new int[]{map.get(target-ele),i};
            }
            map.put(ele,i);
        }
        return new int[0];
        
    }
}