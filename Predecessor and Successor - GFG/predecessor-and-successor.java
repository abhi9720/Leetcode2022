// { Driver Code Starts

import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

 class Res
    {
        Node pre = null;
        Node succ = null;
    }
class PreSucc
{
   
     public static void insert(Node root,int a,int a1,char lr){
        if(root==null){
            return;
        }
        if(root.data==a){
            switch(lr){
                case 'L':root.left=new Node(a1);
                break;
                case 'R':root.right=new Node(a1);
                break;
            }
            return;
        }
        insert(root.left,a,a1,lr);
        insert(root.right,a,a1,lr);
    }
    
      public static void main (String[] args) 
    {
         Scanner sc=new Scanner(System.in);
          int t = sc.nextInt();
          
           while(t-->0){
            int n = sc.nextInt();
            if(n==0)
            {
                System.out.println(0);
                continue;
            }
            Node root = null;
           Res p = new Res();
           Res s = new Res();
            for(int i=0;i<n;i++){
                
                int a=sc.nextInt();
                int a1=sc.nextInt();
                
                char lr=sc.next().charAt(0);
                
                if(i==0){
                    
                    root=new Node(a);
                    
                    switch(lr)
                    {
                        
                        case 'L':root.left=new Node(a1);
                        break;
                        case 'R':root.right=new Node(a1);
                        break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                }
            }
            
            int key = sc.nextInt();
            GfG g=new GfG();
            g.findPreSuc(root, p, s, key);
            
            if(p.pre != null)
              System.out.print(p.pre.data + " ");
              else
              System.out.print("-1" + " ");
              
            if(s.succ != null)
              System.out.println(s.succ.data);
              else
              System.out.println("-1");
            
            
        }
    }
}// } Driver Code Ends



/* BST Node
class Node
{
	int key;
	Node left, right;
	
	Node(int item)
	{
	    data = item;
	    left = right = null;
	}
}
*/

// This function finds predecessor and successor of key in BST.
// It sets pre and suc as predecessor and successor respectively
class GfG
{
    public static void findPreSuc(Node root, Res p, Res s, int key){
       if(root==null) return ;
       
       findPreSuc(root.left,p,s,key);
       if(root.data < key){
           p.pre=root;
       }
       else if( s.succ==null && root.data > key){
           // check for s.succ is important if not check succ update by 78 instead of 45
           /*
            5
            78 80 R 78 24 L 24 18 L 24 55 R 80 85 R
            40
           */
           s.succ =  root;
           return;
       }
       
       findPreSuc(root.right,p,s,key);
       
    }
}













