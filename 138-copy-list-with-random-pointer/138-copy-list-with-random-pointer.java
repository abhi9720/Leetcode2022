/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
     if(head==null) return head;
        Node itr = head;
        while(itr!=null){
            Node clone =  new Node(itr.val);
            Node nextNode=  itr.next;
            itr.next = clone;
            clone.next =  nextNode;            
            itr =  itr.next.next;
            
        }
        
        // now make random pointer connection connections
        itr =  head;
        while(itr!=null){
            if(itr.random==null){
                itr.next.random =  itr.random;
            }else{
                itr.next.random =  itr.random.next;
            }            
            itr =  itr.next.next;
        }
        
        // now seprate cloned linkedlist    and orginal linkedlist
        
        Node newhead =  head.next,newtail=head.next;   
        Node orginalhead =  head;
         while(newtail!=null && newtail.next!=null){           
             head.next =  head.next.next;
             newtail.next =  newtail.next.next;
             head =  head.next;
             newtail = newtail.next;                                 
        }
        head.next = null;
        
        itr =  head;
      

        
    
        
        
        return newhead;
        
    }
    public void printlist(Node head){
        while(head!=null){
            System.out.print(head.val+" , ");
            head =  head.next;
        }
        System.out.println();
    }
}