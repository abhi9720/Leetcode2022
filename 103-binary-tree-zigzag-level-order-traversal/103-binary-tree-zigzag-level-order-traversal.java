class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode > stk =  new Stack<>();
        Queue<TreeNode> q =  new ArrayDeque<>();
        List<List<Integer>> ans =  new ArrayList<>();
        if(root==null) return ans;
        stk.add(root);
        int level =  0;
        // 0 level L to R
        // 1 level R to L
        while(stk.size()>0 ){
            List<Integer> level_nodes =  new ArrayList<>();
            
            if(level==0){// l to r
                while(stk.size() >0 ){
                    TreeNode peek =  stk.pop();
                    if(peek.left!=null){
                        q.add(peek.left);
                    }                    
                    if(peek.right!=null){
                        q.add(peek.right);
                    }
                    level_nodes.add(peek.val);
                }                
                level =  1;
            }
            else{
                 while(stk.size() >0 ){
                    TreeNode peek =  stk.pop();
                    if(peek.right!=null){
                        q.add(peek.right);
                    }
                    if(peek.left!=null){
                        q.add(peek.left);
                    }                    
                    level_nodes.add(peek.val);
                } 
                level =  0;
            }
            ans.add(level_nodes);
            while(!q.isEmpty() ){
                stk.push(q.poll());
            }                        
        }
        return ans;
    }
}