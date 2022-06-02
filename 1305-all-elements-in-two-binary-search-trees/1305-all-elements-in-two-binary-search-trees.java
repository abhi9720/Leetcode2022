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
		pushLeftMost(root1,stk1);
        pushLeftMost(root2,stk2);
        
		while(stk1.size() > 0 || stk2.size() >0 ){			
            if( stk2.size() ==0 ||  (stk1.size()!=0 && ( stk1.peek().val < stk2.peek().val)) ){
				TreeNode peekNode =  stk1.pop();
				ans.add(peekNode.val);				
				pushLeftMost(peekNode.right,stk1);
			}
			else {
				TreeNode peekNode =  stk2.pop();
				ans.add(peekNode.val);				
				pushLeftMost(peekNode.right,stk2);
			}

		}	
		return ans;        
    }
            
    private void pushLeftMost(TreeNode p , Stack<TreeNode> stk){
        while(p!=null){
			stk.push(p);
			p =  p.left;
		}
    }
}