class Solution {

    Random rand =  new Random();
    HashMap<Integer,Integer> map =  new HashMap<>();
    int range  ;
    public Solution(int n, int[] blacklist) {
        // range     is n -  blacklist.size()
        this.range = n -  blacklist.length;
       // 7 - 3 =  4 i.e., 0 to 4 
        
       for(int ele : blacklist){
           map.put(ele , -1);
       }
        
       int pointer =  n-1;
        for(int ele : blacklist){
            if(ele >=  range) continue;
            while( map.containsKey(pointer) ) pointer-=1;
            map.put(ele , pointer);    
            pointer-=1;
        }
        // System.out.println(map+"  "+range);
       
    }
    
    public int pick() {
        
        
        int idx =  rand.nextInt(range);
        // System.out.println(idx);
        return map.getOrDefault(idx,idx);
    }
}
