
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans =  new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> stk1 =  new Stack<>();
        Stack<TreeNode> stk2 =  new Stack<>();
        stk1.push(root);
        int level =  0;
        
        while(stk1.size()!=0 || stk2.size()!=0 ){    
            ArrayList<Integer> le =  new ArrayList<>();
            if(level%2==0){
                // left child , right child 
                while(stk1.size()!=0 ){
                    TreeNode p =  stk1.pop();
                    le.add(p.val);
                    if(p.left!=null) stk2.push(p.left);
                    if(p.right!=null) stk2.push(p.right);                
                }
                level++;
            }
            else{
                // right child  , left child 
                while(stk2.size()!=0 ){
                    TreeNode p =  stk2.pop();
                    le.add(p.val);
                    if(p.right!=null) stk1.push(p.right);                
                    if(p.left!=null) stk1.push(p.left);                    
                }
                level++;
            }   
            ans.add(le);
        }        
        return ans;
    }
}


    
    
 