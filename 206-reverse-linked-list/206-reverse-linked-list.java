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
    public ListNode reverseList(ListNode head) {
        
        // return reverse(head);
        return iterative(head);
    }
    private ListNode iterative(ListNode head){
        ListNode prev =  null , curr =  head , next;
        while(curr!=null){
            next =  curr.next;
            curr.next = prev;
            prev =  curr;
            curr =  next;
        }
        return prev;
    }
    
    // Approach 1 using recursive 
    private ListNode reverse(ListNode head){
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode newhead =  reverse(head.next);        
        head.next.next =  head;
        head.next = null;
        return newhead;
    }
        
}