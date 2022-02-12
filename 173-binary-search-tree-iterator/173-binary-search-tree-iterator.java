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
class BSTIterator {
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
    int nxtval;
    Stack<pair> stk ;
    public BSTIterator(TreeNode root) {
        stk = new Stack<pair>();
        stk.add(new pair(root));
        this.nxtval=-1;
        next();
    }
    
    public int next() {
        int vtoreturn = nxtval;
        nxtval=-1;
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
                nxtval = peek.node.val;
                peek.incr();
                break;
            }
            else{
                // insert right child 
                stk.pop();
                if(peek.node.right!=null){
                    stk.add(new pair( peek.node.right ) );
                }
            }
        }
        
        return vtoreturn;
        
    }
    
    public boolean hasNext() {
        return stk.size()>0;
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */