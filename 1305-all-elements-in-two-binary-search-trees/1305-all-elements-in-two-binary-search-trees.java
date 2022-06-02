// aproach 1 
// get left tree inorder
// get right tree inorder
// then Use algo merge two sorted array
        
// Approach 2 by maintaining two stacks
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> ans =  new ArrayList<>();
        Stack<TreeNode> stk1 =  new Stack<>(),
						stk2 =  new Stack<>();
		
		TreeNode p1  =  root1 , p2 =  root2;
		while(p1!=null){
			stk1.push(p1);
			p1 =  p1.left;
		}
		while(p2!=null){
			stk2.push(p2);
			p2 =  p2.left;
		}
		while(stk1.size() > 0 || stk2.size() >0 ){
			
            if( stk2.size() ==0 ||  (stk1.size()!=0 && ( stk1.peek().val < stk2.peek().val)) ){
				TreeNode peekNode =  stk1.pop();
				ans.add(peekNode.val);
				peekNode =  peekNode.right;
				while(peekNode!=null){
					stk1.push(peekNode);
					peekNode =  peekNode.left;
				}
			}
			else {
				TreeNode peekNode =  stk2.pop();
				ans.add(peekNode.val);
				peekNode =  peekNode.right;
				while(peekNode!=null){
					stk2.push(peekNode);
					peekNode =  peekNode.left;
				}
			}

		}	
		return ans;        
    }
    
}