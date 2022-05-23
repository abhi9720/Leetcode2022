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

    public static TreeNode buildTree(int[] pre, int[] in) {
        // hashmap only work for unique entry of binary tree
        // i.e., no two nodes of same data
        HashMap<Integer,Integer> inordermap =  new HashMap<>();
        for(int i=0;i<in.length;i++){
            inordermap.put(in[i], i );
        }
        return helper(pre, in, 0, pre.length - 1, 0, in.length - 1,inordermap);
    }

    public static TreeNode helper(int[] pre, int[] in, int sp, int ep, int si, int ei ,
                                 HashMap<Integer,Integer> inordermap
                                 ) {
        if (sp > ep || si > ei) {
            return null;
        }

        // make root
        TreeNode root = new TreeNode(pre[sp]);
        int count = inordermap.get(pre[sp]) - si ;
        // for (int i = si; i <= ei; i++) {
        //     if (in[i] == pre[sp]) break;
        //     count++;
        // }

        root.left = helper(pre, in, sp + 1, sp + count, si, si + count - 1,inordermap);
        root.right = helper(pre, in, sp + count + 1, ep, si + count + 1, ei,inordermap);
        return root;
    }
}
