class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // the Node which is nth from the  end 
        // will be n-2 index from start , as 0 base indexing
        ListNode prev =  null , itr  =  head;
        
            
        int len = 0;
        while(itr!=null){ itr =  itr.next;len++;}
        
        if(len-n==0) return head.next;        
         itr  =  head;
        for(int i=0;i<len-n;i++){
            prev =  itr;
            itr =  itr.next;
        }
        prev.next =  itr.next;
        itr.next =  null;
        return head;
    }
}