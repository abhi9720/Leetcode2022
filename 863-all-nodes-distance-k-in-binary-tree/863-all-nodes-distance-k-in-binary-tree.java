/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// a node is at distance d from target node ,then all its right  clildren at distance k-d-2 will be k 
//  distance from target node
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans =  new ArrayList<>();
        printNodeDistanceK(root,target,k,ans);
        return ans;
    }
    private int printNodeDistanceK(TreeNode root, TreeNode target, int k, List<Integer>ans){
        
        if(root==null || k<0){
            return -1;
        }
        if(root == target){
            printNodeDepthK(root,k,ans);
            return 0;
        }
        
        // given me the distance on left of target Node
        int ld =  printNodeDistanceK(root.left,target,k,ans);
        if(ld!=-1){
            if(ld+1==k){
                ans.add(root.val);
            }
            else{
                printNodeDepthK(root.right,k-ld-2,ans);
            }
            return ld+1;
        }
        int rd =  printNodeDistanceK(root.right,target,k,ans);
        if(rd!=-1){
            if(rd+1==k){
                ans.add(root.val);
            }
            else{
                printNodeDepthK(root.left,k-rd-2,ans);
            }
            return rd+1;
        }              
        return -1;
    }
    private void printNodeDepthK(TreeNode root, int k,List<Integer>ans){
        if(root==null || k<0) return ;
        if(k==0){
            ans.add(root.val);
            return ;
        }
        printNodeDepthK(root.left,k-1,ans);
        printNodeDepthK(root.right,k-1,ans);
    }
}