class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if(left!=null && right!=null){
            return root;
        }
        else if(left==null){
            if((root==p || root==q) ){
                return root;
            }
            else{
                return right;
            }            
        }
        else {
             if((root==p || root==q) ){
                return root;
            }
            else{
                return left;
            }  
            
        }
        
        
    }
}