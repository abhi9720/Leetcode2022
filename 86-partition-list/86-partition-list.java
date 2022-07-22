
class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode h1 = null, t1 = null;
        ListNode h2 = null, t2 = null;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x) {
                if (h1 == null) {
                    h1 = temp;
                    t1 = temp;
                } else {
                    t1.next = temp;
                    t1 = temp;
                }
                temp = temp.next;
                t1.next = null;
            } else {
                if (h2 == null) {
                    h2 = temp;
                    t2 = temp;
                } else {
                    t2.next = temp;
                    t2 = temp;
                }
                temp = temp.next;
                t2.next = null;
            }
        }
        if (h1 == null) {
            return h2;
        } else {
            t1.next = h2;
            return h1;
        }
    }
}
