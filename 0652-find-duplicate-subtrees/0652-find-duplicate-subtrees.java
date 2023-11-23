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
    Map<String, TreeNode> map = null;
    List<TreeNode> ans  =  null;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map =  new HashMap<>();
        ans =  new ArrayList<>();
        DFS(root.left,'L');
        DFS(root.right,'R');
        

        return ans;
    }
    
    String DFS(TreeNode root, char dir){
        if(root==null) return "";
        
        String lsp =  DFS(root.left,'L');
        String rsp =  DFS(root.right,'R');
        
        String path  = root.val+ ","+lsp+","+rsp;
        
        if(!map.containsKey(path)){
            map.put(path,root);
        }
        else{
            if(map.get(path)!=null){
              ans.add(map.get(path));
              map.put(path,null);
            }
        }
        
        
        return
            path;
        
    }
}