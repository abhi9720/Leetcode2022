
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // run morris traversal
        TreeNode curr = root;
        while(curr!=null){
            TreeNode left =  curr.left;
            if(left==null){
                // inorder herer 
                k-=1;
                if(k==0) return curr.val;
                curr =  curr.right;
            }
            else{
                while(left.right!=null && left.right!=curr){
                    left =  left.right;
                }
                if(left.right==curr){
                    // again inorder here , break thread
                    k-=1;
                    if(k==0) return curr.val;
                    curr =  curr.right;
                        
                }
                else{
                    left.right =  curr;
                    curr =  curr.left;
                }
            }
        }
        return -1;
    }
   
}