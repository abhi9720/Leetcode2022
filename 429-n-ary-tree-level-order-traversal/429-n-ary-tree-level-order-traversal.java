/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans =  new ArrayList<>();
        if(root==null) return ans;
        Queue<Node> q =  new LinkedList<>() ;
        q.add(root);
        while(q.size()>0 ){
            int size = q.size();
            List<Integer> currLevel =  new ArrayList<>();
            for(int i=0;i<size;i++){
                Node parent =  q.poll();
                currLevel.add(parent.val);
                for(Node child : parent.children){
                    q.add(child);
                }
            }    
            ans.add(currLevel);
        }
        return ans;
    }
}