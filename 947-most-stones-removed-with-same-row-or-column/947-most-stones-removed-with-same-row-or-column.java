class Solution {
   

    HashMap<Integer,Integer> parent, rank;
    
    int islands=0;

    public int removeStones(int[][] stones) {
        islands =0;
        parent = new HashMap<>();
        rank = new HashMap<>();

        // consider each stone as independent island
        // if connected stone combine then count of island decrease
        // as stone can connect and reduced to one
        // ans =  total_stone  -  no_of_island

        for (int stone[] : stones) {
            
            int s1L =  find(stone[0]);
            int s2L  = find(~stone[1]);
            // System.out.println(s1L +"  "+s2L);
            if(s1L!=s2L){
                union(s1L, s2L );
            }
        }
        return stones.length -  islands;
    }

    private int find(int x) {
        // System.out.println(x);
        // if not present in map means first time coming
        if (!parent.containsKey(x)) {
            islands++;
            parent.put(x, x);
            rank.put(x,0);
            return x;
        }

        if (parent.get(x) != x) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    private void union(int s1L, int s2L) {
        int r1 = rank.get(s1L), r2 =  rank.get(s2L);
        if(r1<r2){
            parent.put(s1L , s2L);
        }
        else if(r1 > r2){
            parent.put(s2L, s1L);
        }
        else{
            parent.put(s1L , s2L);
            rank.put(s2L , r2+1);
        }
        islands-=1;
    }
}
