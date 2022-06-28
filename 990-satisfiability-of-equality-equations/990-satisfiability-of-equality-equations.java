class Solution {
    
    int parent[] , rank[];
    public boolean equationsPossible(String[] equations) {
        parent =  new int[26];
        rank =  new int[26];
        for(int i=0;i<26;i++) parent[i] =  i;
        
        for(String e:  equations){
            int ch1 =  e.charAt(0)-'a';
            int ch2 =  e.charAt(3)-'a';
            char op =  e.charAt(1);            
            if(op=='='){
                int s1L =  find(ch1);
                int s2L =  find(ch2);
                union( s1L  , s2L );
            }            
        }
        
        
        for(String e:  equations){
            int ch1 =  e.charAt(0)-'a';
            int ch2 =  e.charAt(3)-'a';
            char op =  e.charAt(1);            
            if(op=='!'){
                int s1L =  find(ch1);
                int s2L =  find(ch2);
                if(s1L==s2L) return false;

            }            
        }
        
        return true;
    }
    private int find( int x){
        if(x!=parent[x]) {
            parent[x] =  find(parent[x]);
        }
        return parent[x];
    }
    private void union(int s1L , int s2L){
        if(rank[s1L] < rank[s2L] ){
            parent[s1L] = s2L;
        }
        else if(parent[s2L] < parent[s1L]){
            parent[s2L] =  s1L;
        }
        else{
            parent[s1L] =  s2L;
            rank[s2L]++;
        }
    }
}