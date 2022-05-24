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
        ListNode fast=  head , slow = head;
        while( fast!=null && fast.next!=null ){
            fast =  fast.next.next;
            slow =  slow.next;
            
        }

        
        ListNode curr =  head;
        
        Stack<ListNode> stk =  new Stack<>();
        while(curr!=slow){
            stk.push(curr)   ;
            curr =  curr.next;
        }
        if(fast!=null){
          curr =  curr.next;   
        }
        
        while(stk.size()>0  ){
            if(stk.peek().val!=curr.val) return false;
            stk.pop();
            curr =  curr.next;
        }
        
        return stk.size()==0 && curr==null;
    }
    
  
}