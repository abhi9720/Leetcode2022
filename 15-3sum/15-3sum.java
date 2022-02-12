class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n =  nums.length;
        Set<List<Integer>>  ans =  new HashSet<>();
        for(int i=0;i<n;i++){
            // if(i>0 && nums[i]==nums[i-1] ) continue;
            ArrayList<ArrayList<Integer>> twopair = twoSum(nums,i+1,n-1,nums[i]);
            if(twopair.size()>0 )
            for(ArrayList<Integer>li : twopair){
                li.add(nums[i]);
                
                
               ans.add(li) ;                
            }
        }
        return new ArrayList(ans);
        
    }
    public ArrayList<ArrayList<Integer>> twoSum(int []nums, int i , int j, int target){
        ArrayList<ArrayList<Integer>>  ans =  new ArrayList<>();
        
        while(i<j){
            int sum =  nums[i]+nums[j]+target;
            if(sum==0){
                ArrayList<Integer> li =  new ArrayList<>();
                li.add(nums[i]) ;
                li.add(nums[j]) ;
                ans.add(li);
                int ele1=nums[i] , ele2=nums[j];
                while(i<j && nums[i]==ele1 ) i++;
                while(i<j && nums[j]==ele2) j--;                
            }
            else if(sum >0 ){
                // decrease j
                j--;
            }
            else{
                i++;
            }
        }
        

        return ans;        
    }
}