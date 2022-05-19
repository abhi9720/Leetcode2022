// { Driver Code Starts
//Initial Template for JAVA

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

public class Tree {
    
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
    static void printInorder(Node root)
    {
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

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
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
*/

class pair{
    Node node;
    int level;
    int width;
    // level because  deeper node may visit before the upper node because of recursion
    public pair(Node node , int level,int width){
        this.node =  node;
        this.level  =  level;
        this.width =  width;
    }
}

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    
    
    static ArrayList<Integer> topView(Node root)
    {
        // horizontal_distance , pair
        HashMap<Integer,Integer> map = new HashMap<>();
        
        Queue<pair> q  =  new ArrayDeque<>();
        if(root==null) return  new ArrayList<>();
        q.add(new pair(root,0,0) );// node , level , width
        int min = 0;
        
        while(q.size() >0 ){
            pair peek =  q.remove();
            Node n =  peek.node;
            int w =  peek.width;
            int l =  peek.level;
            min =  Math.min(w,min);
            if(!map.containsKey(w) ){
                map.put(w ,n.data );
            }
            
            if(n.left!=null){
                q.add(new pair(n.left,l+1,w-1) );
            }
            if(n.right!=null){
                q.add(new pair(n.right,l+1,w+1) );
            }
            
        }
        ArrayList<Integer> ans =  new ArrayList<>();
        for(int i=min ;i<min+map.size();i++ ){
            ans.add(map.get(i) );
        }
        
        
        return ans;
        
    }
    
  
}




