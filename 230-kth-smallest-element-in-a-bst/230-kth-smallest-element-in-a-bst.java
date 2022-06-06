/*
Using Stack : Time -> O(n) and space -> o(n);
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk =  new Stack<>();
        TreeNode temp  =  root;
        while(temp!=null){
            stk.push(temp);
            temp =  temp.left;
        }
        
        while(stk.size() > 0 ){
            TreeNode peekNode =  stk.pop();
            k--;
            if(k==0) return peekNode.val;
            // now check left of TreeNode
            temp  =  peekNode.right;
            while(temp!=null){
                stk.push(temp);
                temp =  temp.left;
            }            
        }
        return -1;
        
    }
}
*/


// run morris traversal => Time -> O(n) ans space : O(1)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        TreeNode curr = root;
        while(curr!=null){
            TreeNode left =  curr.left;
            if(left==null){
                // inorder herer 
                k-=1;
                if(k==0) return curr.val;
                curr =  curr.right;
            }
            else{
                while(left.right!=null && left.right!=curr){
                    left =  left.right;
                }
                if(left.right==curr){
                    // again inorder here , break thread
                    k-=1;
                    if(k==0) return curr.val;
                    curr =  curr.right;
                        
                }
                else{
                    left.right =  curr;
                    curr =  curr.left;
                }
            }
        }
        return -1;
    }
   
}