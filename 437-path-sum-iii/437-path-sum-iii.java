
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        // preorder ? why 
        // because from root we can only move downward , either in left
        // or either in right
        Map<Integer,Integer> map =  new HashMap<>();
        map.put(0,1);
		return dfs(root,targetSum,0,map);

    }
	private int dfs(TreeNode root, int targetSum,int currSum,Map<Integer,Integer> map){

        if(root==null) return 0;
		// we have to move downward from root
		currSum+=root.val;
        
		int targetSumPathEndingAtCurrNode =  map.getOrDefault(currSum-targetSum,0);
        
		
		//Map : update target sum path ending at current node
		map.put(currSum,map.getOrDefault(currSum,0)+1);

		int res = targetSumPathEndingAtCurrNode +
			  dfs(root.left,targetSum,currSum,map)+
			  dfs(root.right,targetSum,currSum,map);

        map.put(currSum,map.getOrDefault(currSum,0)-1);
        return res;
	}
}