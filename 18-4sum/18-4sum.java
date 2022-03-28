class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return ksum(nums,target,4,0);
    }
    
    	private static List<List<Integer>> ksum(int nums[], int target , int k , int idx){
	     
	    if(k==2){
	       List<List<Integer>> ans =  twoSum(nums,target,idx)    ;
            return ans;
	    }else{
	        List<List<Integer>> ans =  new ArrayList<>();   
	        for(int i=idx;i<nums.length;i++){
                if(i>idx && nums[i]==nums[i-1]) continue;
	            List<List<Integer>>  k1sum =  ksum(nums,target-nums[i],k-1,i+1);
	            // now we cann append this element at the fron of each element 
	            for(List<Integer> lis : k1sum){
	                lis.add(0,nums[i]);
	            }
	            ans.addAll( k1sum );
	        }
	        return ans;
	    }
	}
	
	private static List<List<Integer>> twoSum(int nums [], int target, int idx ){
	    int i =  idx, j =  nums.length-1;
	    List<List<Integer>> ans =  new ArrayList<>();
	    while(i<j){
	        int sum  = nums[i]+nums[j];
	        if(sum==target){
	            // ans create
	            ans.add( new ArrayList<>(Arrays.asList(nums[i],nums[j]))  );
	            i++;
	            j--;
                while(i<j && nums[i]==nums[i-1])i++;
                while(i<j && nums[j]==nums[j+1])j--;
	        }else if(sum>target){
	            j--;
	        }else{ // less than
	             i++;
	        }
	    }
	    return ans;
	}
}