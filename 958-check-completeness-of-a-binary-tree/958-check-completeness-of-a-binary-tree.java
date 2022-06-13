
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q =  new LinkedList<>();;
        q.add(root);        
        boolean noChildFalg =  false;
        while(q.size()>0){
            TreeNode peek =  q.remove();
           if(peek==null){
               noChildFalg =  true;
               continue;
           }                                    
            if(noChildFalg) return false;
            q.add(peek.left);                        
            q.add(peek.right);                        
            
        }
        
        return true;
    }
}