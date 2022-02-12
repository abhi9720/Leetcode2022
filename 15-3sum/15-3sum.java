class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n =  nums.length;
        List<List<Integer>>  ans =  new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1] ) continue;
            ArrayList<ArrayList<Integer>> triplet = tripletsum(nums,i+1,n-1,nums[i]);            
            ans.addAll(triplet);
        }
        return ans;
        
    }
    public ArrayList<ArrayList<Integer>> tripletsum(int []nums, int i , int j, int target){
        ArrayList<ArrayList<Integer>>  ans =  new ArrayList<>();
        
        while(i<j){
            int sum =  nums[i]+nums[j]+target;
            if(sum==0){
                 ArrayList<Integer> triplet = new ArrayList<Integer>(
                            Arrays.asList(target ,nums[i], nums[j]));

                ans.add(triplet);
                int ele1 =  nums[i], ele2 =  nums[j];
                
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