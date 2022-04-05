class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<wall.size();i++ ){
            int space = 0;
            for(int j=0; j<wall.get(i).size()-1; j++ ){
                space+= wall.get(i).get(j);
                map.put(space , map.getOrDefault(space,0)+1 );
            }
        }
        int ans = wall.size();
        for(int key : map.keySet() ){
            ans =  Math.min( ans , wall.size() - map.get(key)  );
        }
        
        return ans;
        
    }
}