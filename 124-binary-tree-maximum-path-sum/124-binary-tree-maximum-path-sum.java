class Solution {
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        dfs(root);
        return maxPath;
    }
    private int dfs(TreeNode root){
        if(root==null) return 0;
        
        int lp =  dfs(root.left);
        int rp =  dfs(root.right);
        
        int maxpathfromCurrNode =  Math.max(lp,0)+ Math.max(rp,0)+ root.val;
        maxPath =  Math.max(maxPath , maxpathfromCurrNode);
        int bestpath =  Math.max(0, Math.max(lp,rp) )+root.val;
        
        return bestpath;
    }
}
 