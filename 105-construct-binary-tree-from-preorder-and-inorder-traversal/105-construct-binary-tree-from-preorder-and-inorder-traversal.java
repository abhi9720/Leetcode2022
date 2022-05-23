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
class Solution{
     public static TreeNode buildTree(int[] pre, int[] in) {
        
        return helper(pre,in,0,pre.length-1,0,in.length-1);
     }
    
    public static TreeNode helper(int[] pre, int[] in, int sp,int ep,int si,int ei) {
        
        
        if(sp > ep || si >ei){
            return null;
        }
        
        // make root 
        TreeNode root = new TreeNode(pre[sp] );
        int count = 0;
        for(int i =  si;i<=ei;i++){
            if(in[i] == pre[sp] ) break;
            count++;
        }
        
        root.left  =  helper(pre,in,sp+1,sp+count,si,si+count-1);
        root.right = helper(pre,in,sp+count+1,ep,si+count+1,ei);
        return root;
    }
}