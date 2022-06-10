class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans =  new ArrayList<>();
        subsetsWithDupHelper(nums,ans,new ArrayList<Integer>() , 0);
        return ans;
    }
    private void subsetsWithDupHelper(int []nums,List<List<Integer>> ans,ArrayList<Integer> curr , int idx){
        int n =  nums.length;
        
        ans.add(new ArrayList(curr));
        for(int i =  idx;i<n;i++){
            if(i>idx && nums[i] == nums[i-1] ) continue;
            
            curr.add(nums[i] );
            subsetsWithDupHelper(nums,ans,curr,i+1);
            curr.remove(curr.size()-1  );
            
        }        
    }
}