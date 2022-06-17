class Solution {
    final int CAMERA = 1;
    final int MONITORED = 2;
    final int NON_MONITORED = 3;
    int count = 0;

    public int minCameraCover(TreeNode root) {
        this.count = 0;
        int rootStatus = helper(root);
        return rootStatus == NON_MONITORED? count+1:count;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return MONITORED;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == NON_MONITORED || right == NON_MONITORED) {
            count += 1;
            return CAMERA;
        } else if (left == CAMERA || right == CAMERA) {
            return MONITORED;
        } else {
            return NON_MONITORED;
        }
    }
}
