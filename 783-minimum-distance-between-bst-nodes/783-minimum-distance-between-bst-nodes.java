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
    public int minDiffInBST(TreeNode root) {
        // morrsi tarversal
        TreeNode curr  = root;
        int prev =  -1;
        int minDiff =  (int)1e5;
        while(curr!=null){
            TreeNode left =  curr.left;
            if(left==null){
                // inorder here
                if(prev!=-1){
                    minDiff =  Math.min(minDiff, curr.val - prev);
                }
                prev =  curr.val;
                curr =  curr.right;
            }
            else{
                while(left.right!=null && left.right!=curr){
                    left =  left.right;
                }
                if(left.right==curr){
                    // inorder here
                    if(prev!=-1){
                    minDiff =  Math.min(minDiff, curr.val - prev);
                }
                prev =  curr.val;
                    curr =  curr.right;
                }
                else{
                    left.right =  curr;
                    curr =  curr.left;                        
                }
            }
        }
        return minDiff;
    }
}