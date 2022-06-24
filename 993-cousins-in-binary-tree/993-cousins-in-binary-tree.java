class Solution {

    public boolean isCousins(TreeNode root, int x, int y) {
        int d1 = getDepth(root, x);
        int d2 = getDepth(root, y);
        if (d1 == d2) {
            TreeNode lca = lowestCommonAncestor(root, x, y);

            if (lca.val != x && lca.val != y ) {
                return !((lca.left.val == x && lca.right.val == y) 
                         || (lca.left.val == y && lca.right.val == x));
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val == p || root.val == q) return root;

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
        if (leftLCA != null && rightLCA != null) return root; else if (leftLCA == null) return rightLCA; else return leftLCA;
    }

    private int getDepth(TreeNode node, int val) {
        if (node == null) return -1;
        if (node.val == val) return 0;
        int lf = getDepth(node.left, val);
        int rf = getDepth(node.right, val);
        if (lf != -1) return lf + 1; else if (rf != -1) return rf + 1; else return -1;
    }
}
