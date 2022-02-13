/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy   =  new ListNode(-1,head);
        ListNode t1 = dummy, t1pre =  null;
        ListNode t2 = dummy, t2pre =  null;
                        
        for(int i=0;i<k;i++){            
            t1pre =  t1;    t1 =  t1.next;            
            if(t1==null){
                return  head;
            }
        }        
        ListNode itr1 =  t1 ;
        while(itr1!=null){
            t2pre =  t2; t2 =  t2.next;
            itr1 =  itr1.next;            
        }
        
        // now swap these two nodes        
       // approach 1 working 
//         t1pre.next =  t2;
//         t2pre.next =  t1;
        
//         ListNode temp =  t1.next;
//         t1.next = t2.next;
//         t2.next = temp;
                                            
        // 2nd approch but this not working
        t1pre.next =  t2;
        t2pre.next =  t1;
        
        ListNode t1next  =  t1.next;
        ListNode t2next =  t2.next;  
        
        t1.next =  t2next;
        t2.next = t1next;  
       
        
        return dummy.next;
        
    }
}