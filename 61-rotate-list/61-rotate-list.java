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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        int len =0;ListNode temp =  head;
        while(temp!=null){
            len++;
            temp = temp.next;
        }        
        k =  k%len;
        if(k==0 || head==null) return head;
        ListNode head1 =  head, tail1 =  head;
        ListNode fast = head ,slow =  head;
        for(int i=0;i<k;i++){
            fast =  fast.next;            
        }
        while(fast!=null && fast.next!=null){
            fast =  fast.next;
            slow =  slow.next;
        }        
        head1 =  slow.next;
        tail1 = fast;
        slow.next =  null;
        tail1.next =  head;
        return head1;
        
    }
}