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
        // Approach 1 using recursive 
        return reverse(head);
    }
    private ListNode reverse(ListNode head){
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode newhead =  reverse(head.next);        
        head.next.next =  head;
        head.next = null;
        return newhead;
    }
        
}