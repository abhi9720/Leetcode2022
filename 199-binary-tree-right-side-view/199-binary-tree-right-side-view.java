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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q =  new LinkedList<>();
        List<Integer> ans =  new ArrayList<>();
        if(root==null) return ans;
        
        q.add(root);
        q.add(null);
        TreeNode level_lastNode =  null;
        while(q.size() >1 ){
            TreeNode peek =  q.remove();
            if(peek==null){
                ans.add(level_lastNode.val);
                q.add(null);
                continue;
            }
            level_lastNode =  peek;
            if(peek.left!=null){
                q.add(peek.left);                
            }
            
            if(peek.right!=null){
                q.add(peek.right);                
            }
        }
        ans.add(level_lastNode.val);
        return ans;
        
    }
}