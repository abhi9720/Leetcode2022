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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left =  root;
            return newRoot;
        }
        return helper(root,val,depth,1);
    }
    private TreeNode helper(TreeNode root, int val, int depth , int curr_depth){
        if(root==null) return null;
        if(curr_depth > depth) return root;
        if(depth - curr_depth ==1 ){
            TreeNode leftSubtree =  root.left;
            root.left =  new TreeNode(val);
            root.left.left =  helper(leftSubtree,val,depth,curr_depth+1) ;            
            
            TreeNode rightSubTree =  root.right;
            root.right =  new TreeNode(val);
            root.right.right = helper(rightSubTree,val,depth,curr_depth+1) ;           
        }
        else{
            root.left =  helper(root.left,val,depth,curr_depth+1);
            root.right =  helper(root.right,val,depth,curr_depth+1);            
        }
        return root;
        
    }
}