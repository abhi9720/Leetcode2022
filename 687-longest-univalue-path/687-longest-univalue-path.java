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
    int maxCount = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        int path = helper(root,null);
        
        return maxCount;
    }
    private int  helper(TreeNode root,Integer parent){
        
        if(root==null)  return 0;           
        
        
        int left = helper(root.left,root.val);
        int right =  helper(root.right,root.val);
        int path = 0;
        
            
            if(root.left!=null && root.left.val==root.val){
                // System.out.println("left child equal  ");
                path+=left+1;    
                left+=1;
            }
            
            if(root.right!=null && root.right.val==root.val){
                // System.out.println("right child equal  ");
                path+=right+1;
                right+=1;
            }
        // System.out.println("path : "+path+"  root.val  => "+root.val);
        maxCount =  Math.max(maxCount,path);
        if(parent!=null && parent!=root.val) {
            // System.out.println("Not equal  ");
            return 0;}
        int val  =  Math.max(left,right);
        // System.out.println("return val :  "+val);
        return val;
        
       
    }
}