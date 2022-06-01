
class Solution {
    static final int MONITER = 1;
    static final int NON_MONITER = 2;
    static final int CAMERA = 3;
    int count = 0;

    public int minCameraCover(TreeNode root) {
        int rootStatus = cameraHelper(root);
        return rootStatus == NON_MONITER ? count + 1 : count;
    }

    private int cameraHelper(TreeNode root) {
        if (root == null) return MONITER;

        int left = cameraHelper(root.left);
        int right = cameraHelper(root.right);

        if (left == NON_MONITER || right == NON_MONITER) {
            count += 1;
            return CAMERA;
        } else if (left == CAMERA || right == CAMERA) return MONITER;
		 else {
            return NON_MONITER;
        }
    }
}
