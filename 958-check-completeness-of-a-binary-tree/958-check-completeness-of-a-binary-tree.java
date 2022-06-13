
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q =  new LinkedList<>();;
        q.add(root);
        q.add(null);
        int child= 1;
        int count = 0;
        boolean noChildFalg =  false;
        while(q.size()  >= 1){
            TreeNode peek =  q.remove();
            if(peek==null){                
                if(q.size()==0 ) break;
                q.add(null);
                if(count!=child) return false;
                child*=2;
                count=0;
                
                continue;
                
            }
            count++;
                                    
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