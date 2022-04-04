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
    public ListNode swapNodes(ListNode head, int k) {
    //  we have to swap kth index and n-k th index element in list
        ListNode dummy =  new ListNode(-1);
        dummy.next =  head;
        
        /*move two pointer such that
            i pointer point to kth index
            j pointer point to n-kth index         
        */

        
        ListNode swap1 = dummy;// store kth index element 
        ListNode swap2 = dummy ;// store n-kth index element 
        ListNode  prev1 =  null , prev2 = null;
        
        
        // noww find
        ListNode temp = dummy;
        int idx = 0;
        while(temp!=null){
            if(idx<k){
                prev1 =  swap1;
                swap1 =  swap1.next;
            }else{
                prev2 =  swap2;
                swap2 =  swap2.next;
            }
            idx++;
            temp =  temp.next;
        }
        
        // swap connection
        prev1.next = swap2;
        prev2.next =  swap1;
        ListNode swap1next =  swap1.next;
        swap1.next =  swap2.next;
        swap2.next =  swap1next;
        
        return dummy.next;
    }
}