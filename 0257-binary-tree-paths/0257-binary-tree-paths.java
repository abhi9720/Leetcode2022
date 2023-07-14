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
    public List<String> binaryTreePaths(TreeNode root) {
         StringBuilder path =  new StringBuilder();
        
         List<String> ans =  new ArrayList<>();
         binaryTreePathsHelper(root,path,ans);
        return ans;

    }
    
    private void binaryTreePathsHelper(TreeNode root, StringBuilder path , List<String> ans){
        
        if(root==null) return ;
        
        if(root.left==null  && root.right==null){
            String newpath =  new String(path);
            if(newpath.length()==0){
                newpath+=root.val;
            }
            else{
                newpath+= "->"+root.val;
            }
            ans.add(newpath);
            return ;
        }

        String part =  "";
        if(path.length()==0){
            part += root.val;
        }
        else{
            part =  "->"+root.val;
        }
         
        path.append(part);
        
        
        binaryTreePathsHelper(root.left,path,ans);
        binaryTreePathsHelper(root.right,path,ans);
        
        
        path.setLength(path.length()-part.length());
        
        
    }
}