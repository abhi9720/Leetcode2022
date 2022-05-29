// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution ob = new Solution();
            System.out.println(ob.maxPathSum(root));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/* class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution
{
    static int maxLeafPath =  Integer.MIN_VALUE;
    int maxPathSum(Node root){ 
        maxLeafPath = Integer.MIN_VALUE;
        
        int ans = dfs(root);

        
        
		if(root.left==null || root.right==null){
		    return Math.max(maxLeafPath,ans);
		};
		
        
		return maxLeafPath;
    } 
	private int dfs(Node root){
		
		if(root.left==null && root.right==null){
		    return root.data;
		}
		else if(root.left==null){
		    int r =  dfs(root.right);
		    return r+root.data;
		}
		else if(root.right==null){
		    int l =  dfs(root.left);
		    return l+root.data;
		}
		else {
		    int l =  dfs(root.left), r =  dfs(root.right);
		    int leafPath =  l+r+root.data;
		  //  System.out.println("At "+root.data+" -> "+leafPath+" => "+maxLeafPath);
		    if(leafPath> maxLeafPath) maxLeafPath =  leafPath;
		    return Math.max(l,r)+root.data;
		}
		
		
	}
	
	 Node setTree(Node root){
       
      Node temp = new Node(0);
      //if tree is left most
      if(root.right==null){
          root.right=temp;
      }
      else{    //if tree is right most
          root.left=temp;
      }
       
      return root;
    }
}