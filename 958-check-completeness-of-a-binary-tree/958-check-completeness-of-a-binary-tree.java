
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q =  new LinkedList<>();;
        q.add(root);                
        boolean noChildFalg =  false;
        while(q.size()  >= 1){
            TreeNode peek =  q.remove();                                        
            if(peek.left!=null){
                if(noChildFalg) return false;
                q.add(peek.left);}
            else  noChildFalg =  true;
            
            if(peek.right!=null){
                if(noChildFalg) return false;
                q.add(peek.right);                        
            }
            else  noChildFalg =  true;
        }
        
        return true;
    }
}