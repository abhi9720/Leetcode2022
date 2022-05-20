
  
    
    
class Solution {
    boolean isBalanced=true;
    public boolean isBalanced(TreeNode root) {
        heightDiff(root);
        return isBalanced;
    }

    private int heightDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = heightDiff(root.left);
        
        int rh = heightDiff(root.right);
        
        
        
        boolean isBalance =  Math.abs(lh - rh)<=1 ;
        isBalanced =  isBalanced && isBalance;

        return Math.max(lh,rh)+1 ;
    }
}
