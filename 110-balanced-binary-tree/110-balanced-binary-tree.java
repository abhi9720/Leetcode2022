class pair {
    int h;
    boolean isBalanced;
    
    public pair(int h, boolean isBalanced) {
        this.h = h;
        this.isBalanced = isBalanced;
    }
    public String toString(){
        return this.h+" "+this.isBalanced;
    }
}

class Solution {

    public boolean isBalanced(TreeNode root) {
        return heightDiff(root).isBalanced;
    }

    private pair heightDiff(TreeNode root) {
        if (root == null) {
            return new pair(0, true);
        }
        pair left = heightDiff(root.left);
        if(!left.isBalanced) return left;

        pair right = heightDiff(root.right);
        if(!right.isBalanced) return right;

        
        int diff = Math.abs(left.h - right.h);
        
        boolean isBalanced =  diff<=1 ;

        return new pair(Math.max(left.h,right.h)+1 , isBalanced);
    }
}
