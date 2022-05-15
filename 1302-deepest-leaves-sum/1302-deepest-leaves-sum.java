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
    public int deepestLeavesSum(TreeNode root) {
        int k =  depth(root);
        return sumAtDepth(root,k);
    }
    // find depth
    private int depth(TreeNode root){
        if(root==null) return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }
    // find sum a given depth
    private int sumAtDepth(TreeNode root, int k){
        if(root==null) return 0;
        if(k==1 && root.left==null && root.right==null){
            return root.val;
        }
        
        return sumAtDepth(root.left,k-1) +
            sumAtDepth(root.right,k-1);        
    }
}