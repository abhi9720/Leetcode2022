/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
//     public int deepestLeavesSum(TreeNode root) {
//         int k =  depth(root);
//         return sumAtDepth(root,k);
//     }
//     // find depth
//     private int depth(TreeNode root){
//         if(root==null) return 0;
//         return Math.max(depth(root.left),depth(root.right))+1;
//     }
//     // find sum a given depth
//     private int sumAtDepth(TreeNode root, int k){
//         if(root==null) return 0;
//         if(k==1 && root.left==null && root.right==null){
//             return root.val;
//         }
        
//         return sumAtDepth(root.left,k-1) +
//             sumAtDepth(root.right,k-1);        
//     }
    // Approach 2
    
    public int deepestLeavesSum(TreeNode root) {
             int data[]  =  helper(root);
        return data[1];
    }
    // /return {max_depth , sum }
    private int[]  helper(TreeNode root){
        
        if(root==null){
            return new int[]{0,0};
        }
        
        if(root.left==null && root.right==null){
            return new int[]{1,root.val};
        }
        
        
        
        int left[] = helper(root.left);                
        int right[] =  helper(root.right);
        int ans[] =  new int[2];
        
        if(left[0]==right[0] ){
            ans[0] =  left[0];
            ans[1] =  left[1]+right[1];
        }
        else if(left[0] < right[0]){
            ans[0]  =  right[0];
            ans[1]  =  right[1];
        }
        else{
            ans[0]  =  left[0];
            ans[1]  =  left[1];
        }
        
        ans[0]+=1;// increase for increase in depth
        
        return ans;
    }
}



