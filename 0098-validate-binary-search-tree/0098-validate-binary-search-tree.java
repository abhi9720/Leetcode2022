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
       if(root==null) return true;
        Integer left =  null;
        Integer right =  null;
        return DFS(root, left, right);
       
     }
    
    public boolean DFS(TreeNode root, Integer left, Integer right){
        if(root==null) return true;
        
        boolean isRootValid =  true;
        
        if(left!=null){
            isRootValid &= root.val > left;    
        }
        
        if(right!=null){
            isRootValid &= root.val < right;    
        }
        
        if(!isRootValid) return false;
        
        return DFS(root.left,left,root.val) && DFS(root.right,root.val,right);
    
    }
}