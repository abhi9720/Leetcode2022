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
    ListNode front=null;    
    public boolean isPalindrome(ListNode head) {
        this.front =  head;
        return helper(head);
    }
    
    private boolean helper(ListNode head){
        if(head==null) return true;
        if(!helper(head.next) ) return false;
        if(head.val!=front.val) return false;
        front =  front.next;        
        return true;
    }
}