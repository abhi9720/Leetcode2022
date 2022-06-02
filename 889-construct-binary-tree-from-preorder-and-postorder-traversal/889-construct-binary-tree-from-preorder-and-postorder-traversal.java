
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
     return helper(preorder,postorder,0,preorder.length-1,0,postorder.length-1);                
    }
    private TreeNode helper(int pre[],int post[],int preS,int preE,int postS,int postE){
        int n   = pre.length;
		if(preS > preE || postS > postE || preE >= n || postE >= n){
			return null;
		}
        // System.out.println("preorder : ["+preS+","+preE+"]  | "+"postorder : ["+postS+","+postE+"]  | ");
		// make node 
		TreeNode root =  new TreeNode(pre[preS]);
		int nextIdx =  preS+1;
		if(nextIdx <= preE){
			int ele =  pre[nextIdx];
			int count=0;
			for(int i =  postS;i<=postE;i++){
                count+=1;
				if(post[i]==ele){  break;}
				
			}
            // System.out.println("count  : "+count);
			root.left =  helper(pre,post,nextIdx,preS+count,postS,postS+count-1);
			root.right =  helper(pre,post,preS+count+1,preE,postS+count,postE-1);
		}
		return root;		
	}
}