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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy =  new ListNode(-1,head);
        
        // step1: Find one node pre to left. 
        int pos = 0;
        ListNode itr =  dummy,prev=null;
        while(itr!=null){
            prev = itr;
            itr =  itr.next;
            pos+=1; 
            if(pos==left)break;
        }
        if(itr==null) return head;
        
        // step2: Now reverse this range.
        ListNode pre1 =  null,nextNode;
        int count=right-left;
        ListNode h =  itr;
        while(itr!=null && count>=0){
            nextNode=  itr.next;
            itr.next =  pre1;
            pre1 =  itr;
            itr =  nextNode;
            count-=1;            
        }
        h.next =  itr;
        prev.next =  pre1;
        return dummy.next;
        
    }
}