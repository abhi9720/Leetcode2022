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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode newHead = dummy;
        ListNode curr =  head, prev =  null , _next =  null;
        while(curr!=null){
            _next =  curr.next;
            if((prev!=null && curr.val == prev.val )  || (_next!=null && curr.val ==_next.val) ){               
            }
            else{
                dummy.next =  curr;
                dummy =  dummy.next;            
            }  
            prev =  curr;
            curr=  curr.next;                        
        }
        dummy.next = null;
       
        
        return newHead.next;
    }
    
}