

class Solution {
    boolean istrue = false;
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        if (k > nums.length) return false;
        
        int sum = 0;
        
        for (int num : nums) sum += num;
        
        if (sum % k != 0) return false;
   
        solution(0, nums, new int[k], sum/k);
        
        return istrue;
        
    }
    
    
    public void solution(int aid, int[] nums,  int[] set, int tar)
    {
      
        if(aid == nums.length)
        {
            if(allequal(set))
                istrue = true;
            
            return ;
        }
        
        for(int i=0; i<set.length; i++)
        {
            int t = set[i];
            
            if(t == 0)
            {
                set[i] = nums[aid];
                solution(aid+1, nums, set, tar);
                set[i] = 0;
                break;
            }
            else{
                if(tar >= nums[aid] +  set[i] ){
                set[i] = nums[aid] +  set[i];
                solution(aid+1, nums, set, tar);
                set[i] -= nums[aid];}
            }
        }
    }
    
    public boolean allequal(int[] set)
    {
        boolean e = true;
        for(int i=1; i<set.length; i++)
        {
            if(set[i-1]!= set[i])
                return false;
        }
        
        return true;
    }
}