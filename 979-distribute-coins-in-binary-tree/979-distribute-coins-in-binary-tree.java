
class Solution {
    public int distributeCoins(TreeNode root) {
        helper(root);
        return move;
    }
    int move = 0;
    private int [] helper(TreeNode root){
        if(root==null){
            return new int[]{0,0};            
        }
        
        int left[] = helper(root.left);
        int right[]=  helper(root.right);
        
        int nodeCount =  left[0]+right[0]+1;
        int coins =  left[1]+right[1]+root.val;
        move+= Math.abs(coins - nodeCount);
        return new int[]{nodeCount,coins} ;          
    }
}
