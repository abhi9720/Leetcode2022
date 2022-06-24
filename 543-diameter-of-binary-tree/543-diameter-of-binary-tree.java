class Solution {
    int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return dia;        
    }
    private int helper(TreeNode root){
        if(root==null) return 0;
        int lh =  helper(root.left);
        int rh =  helper(root.right);
        // calculating data per node that is maximum size diameter from this node 
        // and maintaining global max 
        dia =  Math.max(lh+rh,dia)        ;
        // here we are retruning heigt of this substree 
        return 1+Math.max(lh,rh);
    }
}