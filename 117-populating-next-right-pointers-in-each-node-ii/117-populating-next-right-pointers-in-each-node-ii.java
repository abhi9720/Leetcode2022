
class Solution {
    public Node connect(Node root) {
        Node curr =  root, prev =  null , head =  null;
        while(curr!=null){
            
            // iterate current level node , as there next will be set
            // by their parent 
            while(curr!=null){
                if(curr.left!=null){
                    if(prev!=null){
                        prev.next =  curr.left;
                    }
                    else{
                        head =  curr.left;
                    }
                    prev =  curr.left;
                }
                
                if(curr.right!=null){
                    if(prev!=null){
                        prev.next = curr.right;
                    }
                    else{
                        head =  curr.right;
                    }
                    prev =  curr.right;
                }
                curr =  curr.next;
            }
            
            curr =  head;
            prev =  null;
            head =  null;
               
        }        
        return root;
        
    }
}