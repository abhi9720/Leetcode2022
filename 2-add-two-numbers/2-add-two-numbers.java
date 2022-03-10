class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head  =  null;
        ListNode tail  =  null;
        int sum=0,carry=0;
        while(l1!=null || l2!=null || carry!=0){
                         
            sum = (l1!=null?l1.val:0)
                  + (l2!=null?l2.val:0 )
                  +carry;
            
            carry =  sum/10;
            sum =  sum%10;  
            
            ListNode sumNode =  new ListNode(sum);
            if(head==null){
                head =  tail =  sumNode;
            }else{
                tail.next =  sumNode;
                tail =  sumNode;
            }
            l1 =  l1!=null?l1.next:null;
            l2 =  l2!=null?l2.next:null;
         
        }
        if(carry!=0){
            ListNode carryNode =  new ListNode(carry);
            tail.next =  carryNode;
        }
        return head;
        
    }
}