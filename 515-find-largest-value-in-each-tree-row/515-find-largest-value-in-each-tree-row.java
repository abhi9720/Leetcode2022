class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans =  new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q =  new LinkedList<>();
        q.add(root);
        q.add(null);
        int max = Integer.MIN_VALUE;
        while(q.size() >1 ){
            TreeNode peek =  q.remove();
            if(peek==null){
                ans.add(max);
                max = Integer.MIN_VALUE;
                q.add(null);
                continue;
            }
            if( max < peek.val){
                max =  peek.val;
            }
            if(peek.left!=null){
                q.add(peek.left);
            }
            if(peek.right!=null){
                q.add(peek.right);
            }
        }
        ans.add(max);
        return ans;
    }
}