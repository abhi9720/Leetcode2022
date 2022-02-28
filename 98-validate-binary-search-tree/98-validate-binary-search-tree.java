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
        TreeNode curr =  root;
        TreeNode prev =  null;
        while(curr!=null){
            TreeNode left =  curr.left;
             
            if(left==null){
                if(prev!=null && prev.val>=curr.val) return false;
                prev =  curr;
                curr = curr.right;
            }else{
                TreeNode rmn =  getRightMostNode(left,curr);
                if(rmn.right == null){
                    rmn.right =  curr;
                    curr =  curr.left;
                }
                else{
                    rmn.right =  null;
                    if(prev.val>=curr.val) return false;
                    prev =  curr;
                    curr =  curr.right;
                }
            }
          
            
            
        }
        
        
        return true;
        
    }
    
    private TreeNode getRightMostNode(TreeNode node , TreeNode curr){
        
        while(node.right!=null && node.right!=curr){
            node = node.right;
        }
        return node;
    }
}