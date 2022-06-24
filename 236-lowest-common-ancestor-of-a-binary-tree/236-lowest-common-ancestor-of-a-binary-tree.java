// LCA is node for which and right both return not null
// one edge case if node itself is LCA
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==p ) return p;
        if(root==q) return q;
        
        TreeNode leftLCA =  lowestCommonAncestor(root.left,p,q);
        TreeNode rightLCA = lowestCommonAncestor(root.right,p,q);
        if(leftLCA!=null && rightLCA!=null) return root;
        else if(leftLCA==null) return rightLCA;
        else return leftLCA;        
    }
}