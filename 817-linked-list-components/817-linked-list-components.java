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

    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int ele : nums) {
            set.add(ele);
        }

        int c = 0, comp = 0;
        ListNode t = head;
        while (t != null) {
            if (set.contains(t.val)) {
                set.remove(t.val);
                c++;
            } else {
                if (c > 0) {
                    comp++;
                }
                c = 0;
            }
            t = t.next;
        }

        if (c > 0) {
            comp++;
        }
        return comp;
    }
}
