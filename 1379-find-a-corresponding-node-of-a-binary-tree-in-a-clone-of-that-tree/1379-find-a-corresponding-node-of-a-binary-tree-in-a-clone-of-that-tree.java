
class Solution {
    public final TreeNode getTargetCopy(final TreeNode orginal, final TreeNode cloned, final TreeNode target) {
        if(orginal==null || cloned==null){
            return null;            
        }
        
        if(orginal.val==target.val) return cloned;
        
        TreeNode leftans = getTargetCopy(orginal.left,cloned.left,target);
        if(leftans!=null) return leftans;
        TreeNode rightans = getTargetCopy(orginal.right,cloned.right,target);
        return rightans;        
    }
}