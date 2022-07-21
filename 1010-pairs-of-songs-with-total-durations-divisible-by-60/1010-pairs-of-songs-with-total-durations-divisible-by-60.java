class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> map =  new HashMap<>();
        int count =0 ;
        for(int ele : time){
            int r =  ele%60;
            if(map.containsKey((60-r)%60)){
                count+= map.get((60-r)%60);
            }
            map.put(r , map.getOrDefault(r,0)+1 );
        }
        return count;
    }
}