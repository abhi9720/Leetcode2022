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
    public ListNode partition(ListNode head, int x) {
        ListNode l1 =  new ListNode(-1) , t1=  l1;
        ListNode l2 =  new ListNode(-1), t2 =  l2;
        
        for(ListNode ptr =  head ; ptr!=null;ptr =  ptr.next){            
            if(ptr.val < x){               
                t1.next =  ptr;
                t1 = ptr;                                    
            }
            else{              
                t2.next =  ptr;
                t2 = ptr;                    
                
            }            
        }
        t1.next =  l2.next;
        t2.next = null;
        return l1.next;
        
    }
}