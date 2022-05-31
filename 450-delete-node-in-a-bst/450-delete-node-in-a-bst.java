
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
		if(root==null) return null;
        if(root.val==key){
            if(root.left==null) return root.right;
			else if(root.right==null) return root.left;
			else{
				// both left and right not null
				TreeNode successor = root.right;
				while(successor.left!=null){
					successor =  successor.left;
				}
				root.val  =  successor.val;
				root.right =  deleteNode(root.right,successor.val);
				

			}
        }
        else if(root.val < key){
			// move right
			root.right =  deleteNode(root.right,key);

		}
		else{
			// move left
			root.left =  deleteNode(root.left,key);
		}
    
        return root;
    }
}