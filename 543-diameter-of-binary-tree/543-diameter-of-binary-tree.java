
class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        helper(root);
        return diameter;
    }
    private int helper(TreeNode root){
        if(root==null) return 0;
        
        int lh =  helper(root.left);
        int rh = helper(root.right);
        int dia =  lh+rh;
        diameter = Math.max(diameter,dia);
        
        return Math.max(lh,rh)+1;
    }
}

// maximum distance between two  leaf node 