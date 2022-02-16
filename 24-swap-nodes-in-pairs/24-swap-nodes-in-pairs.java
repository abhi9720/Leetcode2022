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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy =  new ListNode(-1);
        ListNode curr =  head , prev =  dummy,NextNode=head.next;
        
        
        while(curr!=null && curr.next!=null){
            
            NextNode =  curr.next;
            ListNode nexttonext =  NextNode.next;
            prev.next = NextNode;
            NextNode.next  =  curr;
            curr.next = nexttonext;
            prev =  curr;
            curr = nexttonext;            
        }
        
        
        
        
        
        return dummy.next;
        
        
    }
}