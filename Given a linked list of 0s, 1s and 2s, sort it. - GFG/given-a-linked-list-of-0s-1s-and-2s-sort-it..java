// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        
          Node pz = new Node(0),po = new Node(1),pt = new Node(2);
        Node pzt=pz,pot=po,ptt=pt;

        Node cur =  head;
        while(cur!=null){
            if(cur.data==0){
                pzt.next =  cur;
                pzt = cur;

            }else if(cur.data==1){
                pot.next =  cur;
                pot=cur;
            }else{
                ptt.next =  cur;
                ptt=cur;
            }        
            cur =  cur.next;
        }

        pzt.next=null;
        pot.next=null;
        ptt.next=null;
        if(po.next!=null){
            pzt.next =  po.next;//00.....011........111
            pot.next =  pt.next;//1.......12.......222
        }
        else{
            pzt.next=pt.next;//0.....022222222
        }
        

        return pz.next;
        
    }
}


