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

class Solution {
    static int max;
    public int maxPathSum(TreeNode root) {
        max =  Integer.MIN_VALUE;
        helper(root);
        return max;
        
    }
    private int helper(TreeNode root){
        if(root==null) return Integer.MIN_VALUE;
        
        
        int leftSum  = helper(root.left);
        int rightSum = helper(root.right);
        
        int maxTillNow =  Math.max(leftSum,0) +Math.max(rightSum,0) +root.val;
        max =  Math.max(max,maxTillNow);
        
        int val =  Math.max(0,Math.max(leftSum,rightSum));
        return val+ root.val;
    }
}