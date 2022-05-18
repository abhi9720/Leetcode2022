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
    int s2 , s3;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        s2 = 0;
        s3 = 0;
        findNode(root,x);        
        
        
        int s1  =   n -  (s2+s3+1);
        int count =  Math.max(s1, Math.max(s2,s3) );
        
        return (count)>n/2;
        
    }
    
    
    private void findNode(TreeNode node, int x){
        if(node==null) return ;
        
        if(node.val==x){
            s2 =  countNode(node.left);
            s3 =  countNode(node.right);            
        }
        findNode(node.left,x);        
        findNode(node.right,x);
        
    }
    
    private int  countNode (TreeNode start  ){
        if(start==null) return 0;        
        
        return 1+ countNode(start.left) + countNode(start.right);        
    }
    
    
}