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
    public List<TreeNode> allPossibleFBT(int n) {
        
        if(n%2==0) return new ArrayList<TreeNode>();
        List<TreeNode> res =  new ArrayList<>();
        if( n==1 ) {
            res.add(new TreeNode(0) );
            return res;
        }
        
        for(int i=1;i<n;i++){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n-i-1);
            
            for(TreeNode ln : left){
                for(TreeNode rn : right){
                    TreeNode curr =  new TreeNode(0);
                    curr.left =  ln;
                    curr.right =  rn;
                    res.add(curr);
                }
            }                            
        }        
        return res;        
    }
}