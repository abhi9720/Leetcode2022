public class Solution {
  public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null  ) return false;                                            
        return dfs(root,targetSum);
    }
    private boolean dfs(TreeNode root, int target){
        
       
        if(root==null) return false;
        if(root.left==null && root.right==null && target-root.val==0) return true;        
        return   dfs(root.left  , target - root.val) || dfs(root.right , target - root.val);
        
    }
}