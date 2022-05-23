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

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
    }

    private static TreeNode helper(int in[], int post[], int si, int ei, int sp, int ep, HashMap<Integer, Integer> map) {
        if (sp > ep || si > ei) {
            return null;
        }
        TreeNode root = new TreeNode(post[ep]);
        int idx = map.get(post[ep]);
        int count = ei - idx;

        root.left = helper(in, post, si, idx - 1, sp, ep - count - 1, map);
        root.right = helper(in, post, idx + 1, ei, ep - count, ep - 1, map);
        return root;
    }
}















