//Approach 1 : Find the LCA from node and move to left and right and in left path replace every thiing bby U
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LCA =  findLCA(root,startValue,destValue);
        
        StringBuilder path =  new StringBuilder();
                
        traverse(LCA,startValue,path,true);
                        
        traverse(LCA,destValue,path,false);
                
        return path.toString();                
    }
    // find path from node to taregt
    private boolean traverse(TreeNode node , int target,StringBuilder sb, boolean startVal){
        if(node==null) return false;
        
        if(node.val==target) {            
            return true;
        }
        
        
        sb.append(startVal?"U":"L");
        if(traverse(node.left,target,sb,startVal))  return true;
        sb.setLength(sb.length() - 1); // back track 
        
        sb.append(startVal?"U":"R");
        if(traverse(node.right,target,sb,startVal))  return true;
        sb.setLength(sb.length() - 1); // back track 
        
        
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