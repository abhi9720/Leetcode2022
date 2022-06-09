/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer> output = new ArrayList<>();
        printNodesAtDistanceK(root, target, k, output);
        return output;
    }

   
    public int printNodesAtDistanceK(TreeNode root, TreeNode target, int k, ArrayList<Integer> output) {
        if (root == null || k < 0) {
            return -1;
        }

        if (root.val == target.val) {
            printAtDepthK(root, k, output);
            return 0;
        }

        // depth left 
        int dl = printNodesAtDistanceK(root.left, target, k, output);

        if (dl != -1) {
            if (dl + 1 == k) { // if root is also at k distance aways from target node then 
                // also add root 
                output.add(root.val);
            } else {
                // -2 because of one vertices from right and 1 vetices from left => count
                printAtDepthK(root.right, k - dl - 2, output);
            }
            return dl + 1;
        }

        // depth right 
        int dr = printNodesAtDistanceK(root.right, target, k, output);

        if (dr != -1) {
            if (dr + 1 == k) {// if root is also at k distance aways from target node then 
                // also add root 
                output.add(root.val);
            } else {
                // -2 because of one vertices from right and 1 vetices from left => count
                printAtDepthK(root.left, k - dr - 2, output);
            }
            return dr + 1;
        }

        return -1;
    }
    
    
     public static void printAtDepthK(TreeNode root, int k, ArrayList<Integer> output) {
        if (root == null || k < 0) {
            return;
        }

        if (k == 0) {
            output.add(root.val);
            return;
        }

        printAtDepthK(root.left, k - 1, output);
        printAtDepthK(root.right, k - 1, output);
    }

}
