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
        // recursive 
        // this.front =  head;
        // return helper(head);
        return isPalin(head);
    }
    // @ Recursive
    private boolean helper(ListNode head){
        if(head==null) return true;
        if(!helper(head.next) ) return false;
        if(head.val!=front.val) return false;
        front =  front.next;        
        return true;
    }
    // @ Itertative 
    private boolean isPalin(ListNode head){
        Stack<ListNode> stk =  new Stack<>();
        ListNode f =  head, s =  head;
        while(f!=null && f.next!=null){
            stk.push(s);
            f =  f.next.next;            
            s =  s.next;            
        }
        
        ListNode itr =  s;
        if(f!=null)itr =  itr.next;
        
        while(stk.size() >0 ){
            if(stk.pop().val !=itr.val ){
                return false;
            }
            itr =  itr.next;
        }
        return true;
    }
}