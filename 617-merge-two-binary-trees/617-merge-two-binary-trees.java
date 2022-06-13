class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        return helper(root1,root2);
    }
    private TreeNode helper(TreeNode r1 , TreeNode r2){
        if(r1==null) return r2;
        else if(r2==null) return r1;
        
        TreeNode cn =  new TreeNode(r1.val+r2.val);
        cn.left = helper(r1.left,r2.left);
        cn.right = helper(r1.right,r2.right);
        return cn;
    }
}
