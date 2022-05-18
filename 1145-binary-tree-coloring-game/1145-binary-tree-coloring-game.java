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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode p2  =  findNode(root,x);        
        int s2 =  countNode(p2.left);
        int s3 =  countNode(p2.right);
        int s1  =   n -  (s2+s3+1);
        int count =  Math.max(s1, Math.max(s2,s3) );
        
        return (count)>n/2;
        
    }
    
    
    private TreeNode findNode(TreeNode node, int x){
        if(node==null) return null;
        
        if(node.val==x) return node;
        TreeNode left = findNode(node.left,x);
        if(left!=null) return left;
        TreeNode right = findNode(node.right,x);
        return right;
    }
    
    private int  countNode (TreeNode start  ){
        if(start==null) return 0;        
        
        return 1+ countNode(start.left) + countNode(start.right);        
    }
    
    
}