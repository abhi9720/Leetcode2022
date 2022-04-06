class Solution {

    Random rand =  new Random();
    HashMap<Integer,Integer> map =  new HashMap<>();
    int range  ;
    public Solution(int n, int[] blacklist) {
        // range     is n -  blacklist.size()
        this.range = n-1 -  blacklist.length;
       // 7 - 3 =  4 i.e., 0 to 4 
        HashSet<Integer> set =  new HashSet<>();
       for(int ele : blacklist){
           set.add(ele);
       }
       int pointer =  n-1;
        for(int ele : blacklist){
            if(ele >  range) continue;
            while( set.contains(pointer) ) pointer-=1;
            map.put(ele , pointer);    
            pointer-=1;
        }
        // System.out.println(map+"  "+range);
       
    }
    
    public int pick() {
        
        
        int idx =  rand.nextInt(range+1);
        // System.out.println(idx);
        return map.getOrDefault(idx,idx);
    }
}
