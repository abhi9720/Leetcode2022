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

    public ListNode mergeNodes(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;

        ListNode itr = head;
        int sum = 0, c = 0;

        while (itr != null) {
            if (itr.val != 0) {
                sum += itr.val;
                c += 1;
            } else {
                if (c > 0) {
                    newTail.next = new ListNode(sum);
                    sum = c = 0;
                    newTail =  newTail.next;
                }
            }
            itr = itr.next;
        }
        return newHead.next;
    }
}
