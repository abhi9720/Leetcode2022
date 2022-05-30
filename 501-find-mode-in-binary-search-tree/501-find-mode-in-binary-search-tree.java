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

     int prev = -1;
    int counter = 0;
    int maxCouter = 0;
    ArrayList<Integer> ans = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        // morris traversal
      
        
         prev = -1;
        counter = 0;
        maxCouter = 0;
        ans = new ArrayList<>();
        
        TreeNode curr = root;
        while (curr != null) {
            TreeNode left = curr.left;
            if (curr.left == null) {
                                   
                    // inorder visit
                    
//    ------- Checking previous ele and update list START                
                  listHandler(curr);
//    ------- Checking previous code and update list END
                prev = curr.val;
                
                
                curr = curr.right;
            } else {
                while (left.right != null && left.right != curr) {
                    left = left.right;
                }
                if (left.right == curr) { // helps in deciding now we have to move right
                    
                    // inorder visit
                    
//    ------- Checking previous ele and update list START      
                    listHandler(curr);
                    
//    ------- Checking previous code and update list END
                    prev = curr.val;
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    left.right = null;
                    curr = curr.right;
                } else {
                    left.right = curr;
                    curr = curr.left;
                }
            }
        }
        
        
        int res[] =  new int[ans.size() ];
        for(int i=0;i<ans.size();i++ ){
            res[i] = ans.get(i);
        }
        return res;
        
        
    }
    
    private void listHandler(TreeNode curr){
        
        
        if (prev == -1 || prev == curr.val) counter++; else counter = 1;
                    // System.out.println(prev+" => "+curr.val+" , "+counter+" , "+maxCouter);
                    
                    if (counter > maxCouter) {
                        maxCouter = counter;
                        ans.clear();
                        ans.add(curr.val);
                    } else if (counter == maxCouter) {
                        if (ans.size() > 0) {
                            if (ans.get(ans.size() - 1) != curr.val) {
                                ans.add(curr.val);
                            }
                        }
                    }
        
    }
}
