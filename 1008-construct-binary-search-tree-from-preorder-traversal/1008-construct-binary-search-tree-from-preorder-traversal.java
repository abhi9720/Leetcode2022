
class Solution {
    int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return preorder(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private TreeNode preorder(int pre[], int min, int max){
		if(idx==pre.length) return null;
		else if(pre[idx] > min && pre[idx]<max ){
			TreeNode root =  new TreeNode(pre[idx]);
			idx+=1;
			root.left =  preorder(pre,min,root.val);
			root.right =  preorder(pre,root.val,max);
			return root;
		}
		else{
			return null;
		}
	}
}