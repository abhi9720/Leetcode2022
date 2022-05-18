// { Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
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
class GfG {
    
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
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Tree g = new Tree();
			    ArrayList<Integer> diagonalNode = g.diagonal(root);
			    for(int i = 0 ;i<diagonalNode.size();i++){
			        System.out.print(diagonalNode.get(i)+ " ");
			    }
		        System.out.println();
	        }
	}
}


// } Driver Code Ends


//User function Template for Java

/* Node is defined as
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/

class pair{
    Node node;
    int diag;
    public pair(Node node, int diag){
        this.node =  node;
        this.diag =  diag;
    }
}


class Tree
{
     public ArrayList<Integer> diagonal(Node root)
      {
           
           
        //   as they are accepting answer in recursive way 
        //   while(q.size() > 0 ){
        //       pair peek =  q.remove();
        //       int diag =  peek.diag;
        //       Node peekNode =  peek.node;
              
        //       maxDiag =  Math.max(maxDiag,diag);
              
            //   map.putIfAbsent(diag,new ArrayList<>() );
            //   map.get(diag).add(peekNode.data);
              
        //       if(peekNode.left!=null){
        //           q.add(new pair(peekNode.left,diag+1) );
        //       }
        //       if(peekNode.right!=null){
        //           q.add(new pair(peekNode.right,diag) );
        //       }
        //   }
        
        //   treeTraversal(root,map,0);
        //   ArrayList<Integer> res   =  new ArrayList<>();
        //   for(int i=0;i<map.size() ;i++){
        //       res.addAll(map.get(i) );
        //   }
        //   return res;
        return bfsTraversal(root);
      }
      
      private void treeTraversal(Node node,  HashMap<Integer,ArrayList<Integer>> map, int diag){
          if(node==null) return ;
          
          map.putIfAbsent(diag,new ArrayList<>() );
          map.get(diag).add(node.data);
          
          treeTraversal(node.left,map,diag+1);
          treeTraversal(node.right,map,diag);
      }
      
      private ArrayList<Integer> bfsTraversal(Node root){
          ArrayList<Integer> res   =  new ArrayList<>();
          Queue<Node> q =  new ArrayDeque<>();
          q.add(root);
          while(q.size() >0 ){
              Node peek =  q.remove();
              while(peek!=null){
                  res.add(peek.data);
                  if(peek.left!=null) q.add(peek.left);
                  peek =  peek.right;
              }
          }
          return res;
      }
}








