class pair  implements Comparable<pair> {
    TreeNode node;
    int level;
    public pair(TreeNode node, int level){
        this.level =  level;
        this.node =  node;        
    }
    public String toString(){
        return node.val+" @ "+level;
    }
    public int compareTo(pair o){
        if(this.level==o.level){
         return this.node.val-  o.node.val;
        }else{
            return this.level-o.level;
        }
    }
    
}
class Solution {
    int max , min;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        // horizontal distance , arraylist of<pair of node,level>
        HashMap<Integer, ArrayList<pair> > hm = new HashMap<>();
        max = 0;
        min = 0;
        preOrder(root,0,0,hm);
        List<List<Integer>> ans =  new ArrayList<>();
        // System.out.println(hm);
        for(int i =  min ;i<=max;i++){
            ArrayList<pair> pairs =  hm.get(i);
            ArrayList<Integer> vert =  new ArrayList<>();
            Collections.sort(pairs);
            // System.out.println(pairs);
            for(pair p : pairs){
                vert.add(p.node.val);
            }
            ans.add(vert);
        }
        return ans;
    }
    private void preOrder(TreeNode root, int dist , int level,
                         HashMap<Integer, ArrayList<pair> > hm
                         ){
        if(root==null) return ;
        max  = Math.max(max,dist);
        min  = Math.min(min,dist);
        
        hm.putIfAbsent(dist,new ArrayList<>());
        hm.get(dist).add(new pair(root,level) );
        
        preOrder(root.left , dist-1, level+1,hm);
        preOrder(root.right, dist+1, level+1,hm);
        
    }
}