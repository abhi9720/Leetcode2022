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
     public static TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return buildTree_helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        
    }
    
    public static TreeNode buildTree_helper(int[] preorder, int[] inorder, int sp,int ep,int si,int ei) {
        
        // recur. terminate condition
        if(sp > ep || si >ei){
            return null;
        }
        
        // make root 
        TreeNode root = new TreeNode(preorder[sp] );
        int count = 0;
        for(int i =  si;i<=ei;i++){
            if(inorder[i] == preorder[sp] ) break;
            count++;
        }
        
        root.left  =  buildTree_helper(preorder,inorder,sp+1,sp+count,si,si+count-1);
        root.right = buildTree_helper(preorder,inorder,sp+count+1,ep,si+count+1,ei);
        return root;
    }
}