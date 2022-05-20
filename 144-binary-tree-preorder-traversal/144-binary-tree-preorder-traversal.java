
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stk =  new Stack<>();
        List<Integer> list =  new ArrayList<>();
        while(stk.size() >0  || root!=null){
            while(root!=null){
                stk.add(root);
                list.add(root.val);
                root = root.left;
            }
            TreeNode peekNode =  stk.pop();
            root =  peekNode.right;
            
        }
        return list;
    }
}