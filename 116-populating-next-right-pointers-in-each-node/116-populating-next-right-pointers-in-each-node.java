class Solution {
    public Node connect(Node root) {
		
        Node p1 =  root;
        while(p1!=null){
            Node curr  =  p1;
            while(curr!=null){
                if(curr.left!=null){
                    curr.left.next  = curr.right;
                }
                if(curr.right!=null && curr.next!=null){
                    curr.right.next =  curr.next.left;
                }
                curr  = curr.next;
            }
            p1 =  p1.left;
        }
        
        return root;
        
    }
    // recursive fails 
	// private void helper(Node p1){
	// 	if(p1==null) return ;
	// if(p1.left==null && p1.right==null) return;
	// 	p1.left.next =  p1.right;
	// 	if(p1.next!=null){
	// 		p1.right.next =  p1.next.left ;
	// 		helper(p1.next);
	// 	}								
	// 	helper(p1.left);
	// }
}