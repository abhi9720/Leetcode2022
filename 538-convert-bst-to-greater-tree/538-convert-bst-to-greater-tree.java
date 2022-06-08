/**

 */
class Solution {
    public TreeNode convertBST(TreeNode root) {
        helper(root,0);
        return root;        
    }
    private int helper(TreeNode root, int sum){
        if(root==null) return sum;
        
        int rightSum = helper(root.right,sum);        
        root.val  =  root.val+rightSum;
        sum =  root.val;
        int leftSum =  helper(root.left,sum);
        return leftSum;        
    }
}