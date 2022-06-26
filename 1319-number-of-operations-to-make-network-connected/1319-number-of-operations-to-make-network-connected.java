class Solution {
    int parent[], rank[];

    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] =  i;
        }
        
        int count = 0;
        for(int ed[] : connections){
            int s1L =  find(ed[0]);
            int s2L =  find(ed[1]);
            if(s1L==s2L){// redundant connection 
                count+=1;
            }
            else{
        
                union(s1L , s2L);
            }
        }
        
        HashSet<Integer> unique =  new HashSet<>();
        for(int ele : parent){
            // as some of them will left to connect with set lead direct
            unique.add(find(ele));
        }
        int wirerequired  = unique.size() - 1 ;
        
        return wirerequired > count ?-1 : wirerequired;
        
    }

    private int find(int x) {
        while (x != parent[x]) x = parent[x];
        return parent[x];
    }

    private void union(int s1L, int s2L) {
        if (rank[s1L] < rank[s2L]) parent[s1L] = s2L;
        else if (rank[s1L] > rank[s2L]) parent[s2L] = s1L;
        else {
            parent[s1L] = s2L;
            rank[s2L]++;
        }
    }
}
