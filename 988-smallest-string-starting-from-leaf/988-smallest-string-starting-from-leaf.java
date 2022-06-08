
class Solution {
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb =  new StringBuilder();
        StringBuilder ans =  new StringBuilder();
        helper(root,sb,ans);
        return ans.toString();
    }
    private void helper(TreeNode root, StringBuilder sb,StringBuilder ans){
        if(root==null){
            return ;
        }
        if(root.left==null && root.right==null){
            sb.append( (char)('a'+root.val));            
            sb.reverse();            
            if(ans.length()==0 || sb.compareTo(ans) < 0 ){
                ans.setLength(0);                    
                ans.append(sb.toString() );                
            }
            sb.reverse();        
            sb.setLength(sb.length() -1 );
            return;
        }
        
        sb.append( (char)('a'+root.val));
        helper(root.left,sb,ans);
        helper(root.right,sb,ans);
        sb.setLength(sb.length() -1 );
            
    }
}