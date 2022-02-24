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
    public ListNode sortList(ListNode head) {        
     return   mergeSort(head);        
    }
    
    public ListNode mergeSort(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode mid  =  getMid(head);
        ListNode t =  mid.next;
        mid.next =  null;// break linkedlist about mid 
        
        ListNode h1 =  mergeSort(head);// head to mid of linkedlist
        ListNode h2 = mergeSort(t); // mid+1 to end of linkedlist
        return merger(h1,h2);
        
    }
    public ListNode getMid(ListNode head){
        ListNode fast =  head, slow =  head,prev =  slow;
        while(fast!=null && fast.next!=null){
            fast =  fast.next.next;
            prev =  slow;
            slow =  slow.next;
        }
        return prev;
    }
    
    public ListNode merger(ListNode head1 ,  ListNode head2){
        if(head1 ==null ) return head2;
        if(head2==null) return head1;
        
        // iterate here your linklist to merege 
        ListNode h =  null, t =  null;
        while(head1!=null && head2!=null){
                        
            
            if(head1.val<=head2.val){
                if(h==null){
                    h =  head1;
                    t =  head1;
                }
                else{
                    t.next =  head1;
                    t =  t.next;
                }
                head1=head1.next;
            }
            else{
                if(h==null){
                    h =  head2;
                    t =  head2;
                }
                else{
                    t.next =  head2;
                    t =  t.next;
                }
                head2=  head2.next;
                
            }
            
            
        }
        
        if(head1!=null){
            t.next =  head1;
        }
        else{
            t.next =  head2;
        }
        
        return h;
        
    }
    
}