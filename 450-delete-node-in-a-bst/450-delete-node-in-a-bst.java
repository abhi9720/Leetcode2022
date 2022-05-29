
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        if(root.val==key){
         if(root.left==null) return root.right;
         else if(root.right==null) return root.left;
         else{
          TreeNode del =  root.right;
          while(del.left!=null){
              del =  del.left;
          }
          root.val  =  del.val;
          root.right = deleteNode(root.right,del.val);
          
         }
        }
        else if(root.val > key){// move left
            root.left= deleteNode(root.left,key);
        }
        else{
            root.right=  deleteNode(root.right,key);
        }
        return root;
    }
    
    // to delete a node fo tree replace that node with the
    // right tree leftMost Node 
}