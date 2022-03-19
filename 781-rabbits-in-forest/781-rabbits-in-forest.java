class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : answers){
            map.put(ele , map.getOrDefault(ele,0)+1 );
        }
        int rabbit =  0;
        for(int key : map.keySet()){
            int grp =  key+1;
            int c  = map.get(key);
            int count = (int) Math.ceil( (c*1.0)/grp ) * grp;
            rabbit+= count;
        }
        return rabbit;
    }
}