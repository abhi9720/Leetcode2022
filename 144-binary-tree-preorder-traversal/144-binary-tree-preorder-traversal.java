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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list =  new ArrayList<>();
        TreeNode curr =  root;
		while(curr!=null) {
			TreeNode left =  curr.left;
			if(left==null) {
				list.add(curr.val);
				curr =  curr.right;
			}
			else {
				while(left.right!=null && left.right!=curr) {
					left =  left.right;
				}
				
				if(left.right==curr) {		
					//break thread 
					
					left.right =  null;
					curr =  curr.right;
				
				}
				else {
					// create thread 
                    list.add(curr.val);
					left.right =  curr;
					curr =  curr.left;
				}
			}
			
		}
        return list;
    }
}