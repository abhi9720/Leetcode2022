class Solution {

    public List<Integer> largestValues(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        helper(root, map, 0);
        return new ArrayList<>(map.values() );
    }

    private void helper(TreeNode root, HashMap<Integer, Integer> map, int h) {
        if (root == null) return;

        if (map.get(h) == null) {
            map.put(h, root.val);
        }

        map.put(h, Math.max(map.get(h), root.val));

        helper(root.left, map,h+1);
        helper(root.right, map,h+1);
    }
}
