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
    int sum  =0;
    public int sumNumbers(TreeNode root) {
        preorder(root,0);
        return sum;
    }
    private void preorder(TreeNode root, int num){
        if(root==null) return ;
        if(root.left==null && root.right==null){
            num =  num*10 + root.val;
            sum+=num;
            return ;
        }
        preorder(root.left,num*10+root.val);
        preorder(root.right,num*10+root.val);
    }
}