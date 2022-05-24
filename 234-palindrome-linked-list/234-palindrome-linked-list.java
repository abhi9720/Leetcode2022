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
    public boolean isPalindrome(ListNode head) {
        ListNode ptr[] =  new ListNode[1];
        ptr[0] =  head;
        return isPalindrome( head , ptr );
    }
    
    private boolean isPalindrome(ListNode head, ListNode ptr[]){
        if(head==null){
            return true;
        }        
        boolean resTillNow = isPalindrome(head.next , ptr);
        if(resTillNow==false) return false;
        
        if(ptr[0].val!= head.val ){
            return false;
        }
        ptr[0] =  ptr[0].next;
        return true;
            
    }
}