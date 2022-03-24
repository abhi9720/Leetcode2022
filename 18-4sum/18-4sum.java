class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> pl=new ArrayList<List<Integer>>();
        if(nums.length<4) return pl;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++)
        {
             if(i>0 && nums[i]==nums[i-1])continue;
            for(int j=i+1;j<nums.length-2;j++)
            {
                if(j>i+1 && nums[j]==nums[j-1])continue;
                int lo=j+1;
                int hi=nums.length-1;
               
                while(lo<hi)
                {
                    if(hi<nums.length-1 && nums[hi]==nums[hi+1])
                {
                    hi--;
                    continue;
                }
                if(lo>j+1 && nums[lo]==nums[lo-1])
                {
                    lo++;
                    continue;
                }
                    
                    if(nums[lo]+nums[hi]+nums[i]+nums[j]>target)
                    {
                        hi--;
                        
                    }else if(nums[lo]+nums[hi]+nums[i]+nums[j]<target)
                    {
                        lo++;
                        
                    }else{
                       List<Integer> cl= new ArrayList<Integer>();
                        cl.add(nums[i]);
                        cl.add(nums[j]);
                        cl.add(nums[lo]);
                        cl.add(nums[hi]);
                        lo++;
                        hi--;
                        pl.add(cl);
                    }
                }
            }
        }
        return pl;
    }
}