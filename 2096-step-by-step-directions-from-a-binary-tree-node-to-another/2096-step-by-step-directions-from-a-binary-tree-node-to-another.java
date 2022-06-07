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
    public String getDirections(TreeNode root, int start, int dest) {
        TreeNode lca_node =  LCA(root,start,dest);
        StringBuilder left  =  new StringBuilder() ,
                      right =  new StringBuilder();
        pathToNode(lca_node,start,left);
        pathToNode(lca_node,dest,right);
        
        for(int i=0;i<left.length();i++ ){
            left.setCharAt(i,'U');
        }
        left.append(right);
        return left.toString();        
    }
    
    private boolean pathToNode(TreeNode node , int target, StringBuilder sb){
        if(node==null) return false;
        if(node.val==target) return true;
        
        sb.append("L");
        if(pathToNode(node.left,target,sb) ) return true;
        sb.setLength(sb.length()-1 );
        
        
        sb.append("R");
        if(pathToNode(node.right,target,sb) ) return true ;
        sb.setLength(sb.length()-1 );
        return false;
        
    }
    
    private TreeNode LCA(TreeNode root, int start, int dest) {
        if(root==null) return root;
        if(root.val==start || root.val==dest ) return root;
        
        TreeNode leftLCA =  LCA(root.left,start,dest);
        TreeNode rightLCA =  LCA(root.right,start,dest);
        
        if(leftLCA!=null && rightLCA!=null) return root;
        else if(leftLCA!=null) return leftLCA;
        else return rightLCA;
    }
    
}