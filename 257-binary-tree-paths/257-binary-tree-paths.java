class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root, ans, "");
        return ans;
    }

    private void dfs(TreeNode root, List<String> ans, String path) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            path  +=  (path.length() == 0 ? "" : "->") + root.val;
            ans.add(path);
            return;
        }
        path  +=  (path.length() == 0 ? "" : "->") + root.val;
        
        dfs(root.left, ans, path);
        dfs(root.right, ans, path);
    }
}
