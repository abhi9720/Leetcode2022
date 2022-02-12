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
    class pair{
        TreeNode node;
        int state = -1;
        pair(TreeNode node){
            this.node =  node;
            this.state =  -1;                             
        }
        void incr(){
            this.state =  this.state+1;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder =  new ArrayList<>();
        if(root==null) return inorder;
        Stack<pair> stk =  new Stack<pair>();
        stk.add(new pair(root));
        
        while(!stk.isEmpty() ){
            pair peek  =  stk.peek();
            if(peek.state==-1){
                // insert left child
                if(peek.node.left!=null){
                    stk.add(new pair( peek.node.left ) );
                }
                
                peek.incr();
            }
            else if(peek.state==0){
                // inorder 
                inorder.add(peek.node.val);
                peek.incr();
            }
            else{
                // insert right child 
                stk.pop();
                if(peek.node.right!=null){
                    stk.add(new pair( peek.node.right ) );
                }
            }
        }
         
        return inorder;
        
        
    }
}