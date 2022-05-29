
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    int dfs(TreeNode root , int number){
		
		int num =  number*10 + root.val;
		if(root.left==null && root.right==null){
			return num;
		}
		return (root.left!=null?dfs(root.left,num):0) +
			  (root.right!=null ?dfs(root.right,num):0);
	}
}