class Solution {

    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int ele : nums){
            map.put(ele , map.getOrDefault(ele,0)+1 );
        }
        int count =0 ;
        
        for(int ele : nums){
            // an element can be repeated many time , we need to take of it             
            if(!map.containsKey(ele)) continue;
            if(k!=0 && map.containsKey(ele+k) ){
                count+=1;
            }
            
            if(k!=0 && map.containsKey(ele-k) ){
                count+=1;
            }
            if(k==0  && map.get(ele) > 1 ){
                count+=1;
            }
            map.remove(ele);
            // as we have done all work for curr ele 
            // means we have check its left and right side 
            // and checked for k=0 && (nums[i] , nums[i] );
        }
        return count;
        
    }
}
