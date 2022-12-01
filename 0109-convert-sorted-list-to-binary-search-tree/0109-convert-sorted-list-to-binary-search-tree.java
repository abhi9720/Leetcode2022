class Solution {
    ListNode midNodeleft(ListNode head){
        ListNode slow = head , fast =  head;
        ListNode prev =  slow;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            fast =  fast.next.next;
            prev =  slow;
            slow =  slow.next;
        }
        return prev;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next==null){
            return new TreeNode(head.val);
        }
        
        ListNode midLeft =  midNodeleft(head);
         
        ListNode midNode =  midLeft.next;
        midLeft.next =  null;
        ListNode midRight =  midNode.next;
        midNode.next =  null;
        
        TreeNode root =  new TreeNode(midNode.val);
        root.left  =  sortedListToBST(head);
        root.right =  sortedListToBST(midRight);
        return root;        
    }
}