
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans =  new ArrayList<>();
        dfs(root,0,ans);
        int size =  ans.size();
        for(int i=0;i<size/2;i++){
            int j =  size - 1 -i;
            List<Integer> temp =  ans.get(i);
            ans.set(i ,  ans.get(j) );
            ans.set(j , temp);
        }
        return ans;
    }
    private void dfs(TreeNode root, int depth , List<List<Integer>> ans){
        
        if(root==null) return ;
        if( depth>= ans.size() ){
            ans.add(new ArrayList<>());            
        }
        ans.get(depth).add(root.val);
        dfs(root.left,depth+1,ans);
        dfs(root.right,depth+1,ans);            
    }
}