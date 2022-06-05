class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        return approach_Time_n(head,n);
    }
    
    private ListNode approach_Time2n(ListNode head,int n){
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
    
    private ListNode approach_Time_n(ListNode head,int n){
        // move two pointer at a gap k 
        ListNode dummy =  new ListNode(-1);
        dummy.next =  head;
        ListNode p1 =  dummy , p2 =  dummy;
        for(int i=0;i<n;i++){
            p1 =  p1.next;
        }
        
        // now two pointer is at gap of k
        ListNode p2prev =  null;
        while(p1!=null){
            p1 = p1.next;
            p2prev =  p2;
            p2 =  p2.next;
        }
        p2prev.next =  p2.next;
        return dummy.next;
        
                
    }
}