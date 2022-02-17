import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp  =  new ArrayList<>();
        List<List<Integer>> ans =  new ArrayList();
         helper(candidates,target,temp,0,ans);
        return ans;
    }
    
    private void helper(int[] candidates, int target , List<Integer>temp, int index,List<List<Integer>> ans  ){
            if(index==candidates.length){
                if(target==0) {
                    ans.add(new ArrayList<>(temp));
                    
                }
                return ;
                
            }
        
        // 1st choice pick element 
        if(candidates[index]<=target ){
            temp.add(candidates[index]);
            helper(candidates,target-candidates[index],temp,index,ans );
            temp.remove(temp.size() -1);
        }
        // not include  element
        helper(candidates,target,temp,index+1,ans );
        
            
        
    
    }
}