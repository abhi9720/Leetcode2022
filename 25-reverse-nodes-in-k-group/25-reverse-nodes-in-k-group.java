class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        int len = len(head);
        return helper(head, k, len);
    }

    private int len(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count += 1;
        }
        return count;
    }

    private ListNode helper(ListNode head, int k, int l) {
        if(l<k) return head;
        
        ListNode newhead =  null,tail = null,nextNode=null;
        
        for(int i=0;i<k;i++){
            nextNode =  head.next;
            if(newhead==null){
                newhead =  tail =  head;
            }
            else{
                head.next =  newhead;
                newhead =  head;
            }
            head = nextNode;
            
        }
        
        tail.next =  helper(head,k,l-k);
        return newhead;
    }
}
