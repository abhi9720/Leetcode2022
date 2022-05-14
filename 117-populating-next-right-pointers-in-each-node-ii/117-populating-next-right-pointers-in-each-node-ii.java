class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Queue<Node> q =  new LinkedList<>();
        q.add(root);
        q.add(null);
        
        Node temp =  root;
        Node p1 =  null, p2=  null;
        
        while(q.size() > 1 ){
            p2 =  q.poll();
            if(p2==null){
                p1.next =  p2;
                p1 =  null;
                q.add(null);
                continue;            
            }
            
            if(p1 !=null ) p1.next =  p2;
            // as p2 will not be null
            if(p2.left!=null) q.add(p2.left);
            if(p2.right!=null) q.add(p2.right);                        
            p1 =  p2;            
        }        
        return root;        
    }
}