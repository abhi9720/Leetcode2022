//Approach 1 : Find the LCA from node and move to left and right and in left path replace every thiing bby U
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LCA =  findLCA(root,startValue,destValue);
        
        StringBuilder left =  new StringBuilder(), right =  new StringBuilder();
        
        
        traverse(LCA,startValue,left);
        
        
        
        traverse(LCA,destValue,right);
        
        // in left replace all
        for(int i=0;i<left.length();i++ ){
            left.setCharAt(i,'U');
        }
        return left.append(right).toString();                
    }
    // find path from node to taregt
    private boolean traverse(TreeNode node , int target,StringBuilder sb){
        if(node==null) return false;
        
        if(node.val==target) {            
            return true;
        }
        
        
        sb.append("L");
        if(traverse(node.left,target,sb))  return true;
        sb.setLength(Math.max(sb.length() - 1, 0)); // back track 
        
        sb.append("R");
        if(traverse(node.right,target,sb))  return true;
        sb.setLength(Math.max(sb.length() - 1, 0)); // back track 
        
        
        return false;
        
        
        
    }
    private TreeNode findLCA(TreeNode node,int s, int d){
        if(node==null) return null;
        
        if(node.val==s || node.val==d) return node;
        TreeNode left = findLCA(node.left,s,d);
        TreeNode right =  findLCA(node.right,s,d);
        if(left!=null && right!=null) return node;
        else if(left==null) return right;
        else return left;        
    }
}