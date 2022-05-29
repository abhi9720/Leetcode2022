class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
		int n  =  preorder.length;

        return helper(preorder,0,n-1);
    }
    
     private static TreeNode helper(int []preorder,int i,int j){
        if(i>j){
            return null;
        }

        if(i==j){
            return new TreeNode(preorder[i] );
        }

        TreeNode root =  new TreeNode(preorder[i] );
        int idx =  i+1;
        while(idx<=j && preorder[idx] < preorder[i] ) idx++;
        root.left =  helper(preorder,i+1,idx-1);
        root.right = helper(preorder,idx,j);
        return root;
    }
}