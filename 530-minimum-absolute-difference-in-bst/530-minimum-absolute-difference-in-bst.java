
class Solution {
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        prev = null;        
        helper(root);
        return minDiff;
    }
    private void helper(TreeNode root){
        if(root==null) return ;
		helper(root.left);
		if(prev!=null){
			int diff =  Math.abs( prev.val - root.val );
			minDiff =  Math.min(minDiff,diff);
		}
        prev =  root;
		helper(root.right);
    }
}