class pair implements Comparable<pair>{
    TreeNode node;
    int depth;    
    public pair(TreeNode node , int depth){
        this.node =  node;
        this.depth =  depth;
    }
    public int compareTo(pair o){
        if(this.depth==o.depth){
            return Integer.compare(this.node.val,o.node.val);
        }
        else{
            return Integer.compare(this.depth,o.depth);
        }
    }
}
class Solution {
    int min = 0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        min = 0;
        HashMap<Integer,PriorityQueue<pair>> map =  new HashMap<>();
        dfs(root,map,0,0);
        List<List<Integer>> ans =  new ArrayList<>();
        
        
        for(int i=min;i<min+map.size();i++ ){
            PriorityQueue<pair> q =  map.get(i);
            ArrayList<Integer> vrt =  new ArrayList<>();
            while(q.size()!=0 ){
                vrt.add(q.poll().node.val );
            }
            ans.add(vrt);
        }
        return ans;
    }
    private void dfs(TreeNode node,HashMap<Integer,PriorityQueue<pair>> map, int hd, int depth ){
        if(node==null) return ;
        
        min  =  Math.min(hd,min);
        map.putIfAbsent(hd , new PriorityQueue<>())   ;
        map.get(hd).add(new pair(node,depth) );   
        dfs(node.left,map,hd-1,depth+1);
        dfs(node.right,map,hd+1,depth+1);
        
        
    }
}