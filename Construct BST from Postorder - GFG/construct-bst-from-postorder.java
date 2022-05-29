// { Driver Code Starts
//Initial Template for Java

import java.util.Scanner;
import java.lang.Math;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
class GFG2
{
    public static void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []post=new int[n];
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                post[i]=b;
            }
            GFG obj=new GFG();
            Node root=obj.constructTree(post,n);
            inorder(root);
            System.out.println();
        }
    }
}
// } Driver Code Ends


// Function should return the root of the bst formed using postorder traversal.
class GFG
{
    public static Node constructTree(int post[],int n)
    {
        
        return helper(post,0,n-1);
    }
    private static Node helper(int []post,int i,int j){
        if(i>j){
            return null;
        }
        if(i==j){
            return new Node(post[j] );
        }
        Node root =  new Node(post[j] );
        int idx =  i;
        while(idx<j && post[idx] < post[j] ) idx++;
        root.left =  helper(post,i,idx-1);
        root.right = helper(post,idx,j-1);
        return root;
    }
}