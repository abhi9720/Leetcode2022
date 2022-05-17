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
        // level same then compare on the basis on values
         return this.node.val-  o.node.val;
        }else{
            // if vertcial level not same , then sort ont the basis on vertcial level
            return this.level-o.level;
        }
    }
    
}
class Solution {
    int max_X , min_X;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        // horizontal distance , arraylist of<pair of node,level>
        HashMap<Integer, ArrayList<pair> > hm = new HashMap<>();
        max_X = 0;
        min_X = 0;
        preOrder(root,0,0,hm);
        
        List<List<Integer>> ans =  new ArrayList<>();
        
        for(int i =  min_X ;i<=max_X;i++){
            ArrayList<pair> pairs =  hm.get(i);
            ArrayList<Integer> vert =  new ArrayList<>();
            Collections.sort(pairs);
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
        max_X  = Math.max(max_X,dist);
        min_X  = Math.min(min_X,dist);
        
        hm.putIfAbsent(dist,new ArrayList<>());
        hm.get(dist).add(new pair(root,level) );
        
        preOrder(root.left , dist-1, level+1,hm);
        preOrder(root.right, dist+1, level+1,hm);
        
    }
}