class Solution {
	int counter =1;
	int maxCouter  = 0;
	int prev = -(int)1e4;
    public int[] findMode(TreeNode root) {
        counter =0;
	    maxCouter  = 0;
	    prev = -(int)1e4;
        TreeNode temp =  root;
        while(temp!=null && temp.left!=null){
            temp = temp.left;
        }
        prev =  temp.val;
        ArrayList<Integer> ans =  new ArrayList<>();
        inorder(root,ans);
        int res[] =  new int[ans.size() ];
        for(int i=0;i<ans.size();i++ ){
            res[i] = ans.get(i);
        }
        return res;
    }
    private void inorder(TreeNode root, ArrayList<Integer> ans){
        
		if(root==null) return ;
        
		inorder(root.left,ans);
        
        // System.out.println(prev+"  "+root.val);
		if(prev==root.val) counter++;
        else counter = 1;
		if(counter>maxCouter){
			maxCouter  = counter;
			ans.clear();
			ans.add(root.val);
		}
		else if(counter==maxCouter){
			if(ans.size() >0 ){
				if(ans.get(ans.size()-1 ) != root.val ){
					ans.add(root.val);
				}
			}
		}
		prev =  root.val;
		inorder(root.right,ans);
		


	}
}