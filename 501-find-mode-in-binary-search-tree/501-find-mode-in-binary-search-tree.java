class Solution {
	int max =  0;
    public int[] findMode(TreeNode root) {
		max = 0;
        Map<Integer,Integer> map = new HashMap<>();
		helper(root,map);
		ArrayList<Integer> ans =  new ArrayList<>();
		for(int key : map.keySet() ){
			if( map.get(key)==max ){
				ans.add(key );
			}
		}
		int res[]  =  new int[ans.size() ];
		for(int i=0;i<ans.size();i++ ){
			res[i] =  ans.get(i);
		}
		return res;
    }

	private void helper(TreeNode root, Map<Integer,Integer>map ) {
		if(root==null) return ;

		map.putIfAbsent(root.val,0);
		int prev = map.put(root.val,map.get(root.val)+1 );
		max =  Math.max(prev+1,max);
		helper(root.left,map);
		helper(root.right,map);
	}

}