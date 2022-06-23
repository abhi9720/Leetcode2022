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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stk =  new Stack<>();
        LinkedList<Integer> li =  new LinkedList<>();
        
        TreeNode itr =  root;
        while(itr!=null  || !stk.isEmpty() ){
            if(itr==null){
                itr =  stk.pop().left;
            }
            else{
                li.addFirst(itr.val);
                stk.push(itr);
                itr =  itr.right;
            }
        }
        return li;
    }
}