class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans =  new ArrayList<>();
        boolean used[] =  new boolean[nums.length];
        helper(ans,new ArrayList<Integer>(),nums,used);
        return ans;
    }
    
    private void helper(List<List<Integer>> ans, ArrayList<Integer>path, int nums[], boolean used[]){

        if(path.size()==used.length ){
            ans.add(new ArrayList(path) );
            return;
        }
        
        for(int i=0;i<used.length;i++){
            if(!used[i] ){
                used[i] =  true;
                path.add(nums[i] );
                helper(ans,path,nums,used);
                used[i] =  false;
                path.remove(path.size()-1 );                
            }            
        }
        
        
        
        
        
    }
    
}