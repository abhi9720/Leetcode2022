class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer> > ans =  new ArrayList<>();
        HashMap<Integer,Integer> map =  new HashMap<>();
        Set<Integer> unique =  new HashSet<>();
        for(int ele : nums){            
            unique.add(ele);
            map.putIfAbsent(ele,0);
            map.put(ele,map.get(ele)+1);
        }
        
        helper(map,new ArrayList<>(),ans,nums.length,unique);
        return ans;        
    }
    private void helper(HashMap<Integer,Integer> map ,List<Integer> permu ,List<List<Integer> > ans ,int n,Set<Integer> unique){
        if(permu.size() == n ){
            ans.add(new ArrayList(permu) );
            return;
        }
        for(int key : unique){
            int count =  map.get(key);
            if(count>0 ){
                map.put(key,count-1 );
                permu.add(key);
                helper(map,permu,ans,n,unique);
                permu.remove(permu.size()-1 );
                map.put(key,count );                    
            }            
        }
        
    }
}