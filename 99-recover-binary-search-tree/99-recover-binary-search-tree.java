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
    public void recoverTree(TreeNode root) {
        TreeNode [] point = new TreeNode[3];        
        inorder(root,point);                
            
        if(point[2]!=null){
            // swap first and second
            int t =  point[0].val;
            point[0].val =  point[2].val;
            point[2].val =t;
        }else{
            // swap first and middle
            int t =  point[0].val;
            point[0].val =  +point[1].val;
            point[1].val =t;
        }
    }
    TreeNode pre = null;
    void inorder(TreeNode root,TreeNode [] point){
        if(root==null) return ;
               
        
        inorder(root.left,point);

        if(pre!=null && root.val <  pre.val){
            if(point[0]==null){
                point[0]  =  pre;
                point[1]  =  root;                
            }
            else{
                point[2] =  root;
            }
        }
        pre   =  root;        
            
        inorder(root.right,point);                    
    }
}














