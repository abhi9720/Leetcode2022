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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>>  ans = new ArrayList<>();
        if(root==null) return ans;
        ArrayList<Integer> level =  new ArrayList<>();
        Stack<ArrayList<Integer>> stk =  new Stack<>();
        
        Queue<TreeNode> q =  new LinkedList<>();
        q.add(root);
        q.add(null);
        while(q.size() > 1 ){
            TreeNode peek =  q.remove();
            
            if(peek==null){
                stk.add( level );
                level =  new ArrayList<>();
                q.add(null);
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
        stk.add( level );
        while(stk.size() >0 ){
            ans.add(stk.pop() );
        }
        return ans;
        
    }
}