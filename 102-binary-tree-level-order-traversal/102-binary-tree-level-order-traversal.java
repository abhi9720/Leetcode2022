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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>  ans  =  new LinkedList<>();
        if(root==null)  return ans;
        List<Integer> level =  new ArrayList<>();
        Queue<TreeNode> q =  new LinkedList<>();
        q.add(root);
        q.add(null);
        while(q.size() > 1 ){
            TreeNode peek =  q.remove();
            if(peek==null){
                q.add(null);
                ans.add(level);
                level =  new ArrayList<>();
                continue;
            }
            level.add(peek.val);
            if(peek.left!=null){
                q.add(peek.left);
            }
            if(peek.right!=null){
                q.add(peek.right);
            }
        }
        ans.add(level);
        return ans;
    }
}