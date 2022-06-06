class Solution {
    ListNode front = null;

    public boolean isPalindrome(ListNode head) {
        // recursive
        // this.front =  head;
        // return helper(head);
        // return isPalin(head);
        return isPalindrome_withoutStack(head);
    }

    // @ Recursive
    private boolean helper(ListNode head) {
        if (head == null) return true;
        if (!helper(head.next)) return false;
        if (head.val != front.val) return false;
        front = front.next;
        return true;
    }

    // @ Itertative
    private boolean isPalin_stack(ListNode head) {
        Stack<ListNode> stk = new Stack<>();
        ListNode f = head, s = head;
        while (f != null && f.next != null) {
            stk.push(s);
            f = f.next.next;
            s = s.next;
        }

        ListNode itr = s;
        if (f != null) itr = itr.next;

        while (stk.size() > 0) {
            if (stk.pop().val != itr.val) {
                return false;
            }
            itr = itr.next;
        }
        return true;
    }

    // @ Itertative
    public boolean isPalindrome_withoutStack(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
