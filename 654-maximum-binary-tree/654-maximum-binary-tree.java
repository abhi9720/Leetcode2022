
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    private TreeNode helper(int nums[], int i , int j){
        if(i>j) return null;
        int max  =  nums[i];
        int idx = i;
        for(int x = i;x<=j;x++){
            if(nums[x] > max ){
                max = nums[x];
                idx =  x;
            }
        }
        // System.out.println("max element in range ["+i+" , "+j+"] is  "+max);
        
        TreeNode root =  new TreeNode(max);
        root.left  = helper(nums, i,idx-1 );
        root.right = helper(nums,idx+1,j);
        return root;
    }
}