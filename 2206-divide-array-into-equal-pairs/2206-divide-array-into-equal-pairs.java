class Solution {
    public boolean divideArray(int[] nums) {
        HashSet<Integer> seen =  new HashSet<>();
        for(int ele : nums){
            if(seen.contains(ele) ){
                seen.remove(ele);
            }
            else{
                seen.add(ele);
            }
            
        }
        
        return seen.size()==0 ;        
    }
}