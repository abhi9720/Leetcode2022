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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avgs =  new ArrayList<>();
        Queue<TreeNode> q =  new LinkedList<>();
        q.add(root);
        
        while(q.size() >0 ){
            int size  =  q.size();
            double sum =0,  count = size;
            while(size-- >0 ){
                TreeNode peekNode =  q.remove();
                sum+=peekNode.val;                
                if(peekNode.left!=null) q.add(peekNode.left);
                if(peekNode.right!=null) q.add(peekNode.right);
            }
            double avg =  sum/count;
            avgs.add(avg);                
        }
        return avgs;
        
    }
}