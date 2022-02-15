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
    public boolean isValidBST(TreeNode root) {
        return validateLimit(root,null,null);
    }
    public boolean validateLimit(TreeNode root,Integer lower,Integer higher){
        if(root ==null){
            return true;
        }
        
        if( !((lower==null || lower<root.val) && (higher==null || higher>root.val) ) ){
             return false;           
        }
        
        
        
        
        return validateLimit(root.left,lower,root.val) && validateLimit(root.right,root.val,higher);
        
    }
}












