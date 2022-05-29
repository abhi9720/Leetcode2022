/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Maximum path sum ANY Node to ANY Node 
class Solution {
    static int globalmax;
    public int maxPathSum(TreeNode root) {
        globalmax =  Integer.MIN_VALUE;
        helper(root);
        return globalmax;
        
    }
    private int helper(TreeNode root){
        if(root==null) return Integer.MIN_VALUE;
        
        
        int leftSum  = helper(root.left);
        int rightSum = helper(root.right);
        
        int maxFromThisNode =  Math.max(leftSum,0) +Math.max(rightSum,0) +root.val;
        
        globalmax =  Math.max(globalmax,maxFromThisNode);
        
        int val =  Math.max(0,Math.max(leftSum,rightSum));
        return val+ root.val;
    }
    
    
    
}