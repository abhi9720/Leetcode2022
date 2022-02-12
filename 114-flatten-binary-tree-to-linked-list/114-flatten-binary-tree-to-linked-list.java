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
    public void flatten(TreeNode root) {
        if(root==null || (root.left==null && root.right==null) ) return;
        
        TreeNode leftNode =  root.left;
        TreeNode rightNode =  root.right;
        
        flatten(root.left);
        
        if(leftNode!=null){
            root.left=null;
            root.right =  leftNode ;                
            TreeNode itr = leftNode;            
            while(itr!=null && itr.right!=null){
                itr =  itr.right;                
            }            
            itr.right = rightNode ;
            
        }
        flatten(rightNode);
        
        
        
        
        
    }
}