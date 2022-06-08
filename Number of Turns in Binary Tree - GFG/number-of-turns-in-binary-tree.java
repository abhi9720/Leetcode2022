// { Driver Code Starts
//Initial template for Java

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
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            
            String line = br.readLine();
            String[] splitLine = line.split(" ");
            int nd1 = Integer.parseInt(splitLine[0]);
            int nd2 = Integer.parseInt(splitLine[1]);
            int turn;

            Solution ob = new Solution();
            if((turn = ob.NumberOfTurns(root, nd1, nd2)) != 0)
              System.out.println(turn);
            else
              System.out.println("-1");
            t--;
        }
    }
}
// } Driver Code Ends

class Solution {

    static int NumberOfTurns(Node root, int first, int second) {
        Node lcaNode = LCA(root, first, second);
           if (lcaNode == null)
            return -1;
        int count[] = new int[1];

        // if(lcaNode.data!=first && lcaNode.data!=second){
        //     if(pathTurn(lcaNode.left, first, count, true) || pathTurn(lcaNode.right, first, count, false));
        //     if(pathTurn(lcaNode.left, second, count, true) || pathTurn(lcaNode.right, second, count, false));
        //     return (count[0] +1);
        // }

        // if(lcaNode.data==first){
        //     pathTurn(lcaNode.left, second, count, true);
        //     pathTurn(lcaNode.right, second, count, false);
        //     return (count[0] );
        // }
        // else {
        //     pathTurn(lcaNode.left, first, count, true);
        //     pathTurn(lcaNode.right, first, count, false);
        //     return (count[0] );
        // }
        
        
        //--------------------
        
          if(lcaNode.data==first){
            pathTurn(lcaNode.left, second, count, true);
            pathTurn(lcaNode.right, second, count, false);
             return (count[0] );
        }
        else if(lcaNode.data==second){
            pathTurn(lcaNode.left, first, count, true);
            pathTurn(lcaNode.right, first, count, false);
             return (count[0] );
        }
        else{
            if(pathTurn(lcaNode.left, first, count, true) || pathTurn(lcaNode.right, first, count, false));
            if(pathTurn(lcaNode.left, second, count, true) || pathTurn(lcaNode.right, second, count, false));
             return (count[0] +1);
        }
        
        
    
        
        
    }

    private static Node LCA(Node root, int a, int b) {
        if (root == null) return null;
        if (root.data == a || root.data == b) return root;

        Node leftLCA = LCA(root.left, a, b);
        Node rightLCA = LCA(root.right, a, b);

        if (leftLCA != null && rightLCA != null) {
            return root;
        } 
        else if (leftLCA != null) return leftLCA;
        else return rightLCA;
    }

    private static boolean pathTurn(Node root, int target, int count[], boolean isLeft) {
        if (root == null) return false;
        if (root.data == target) {
            // System.out.println("target found ");
            return true;
        }

if(isLeft){
    
    if (pathTurn(root.left, target, count, isLeft))  return true;
    if (pathTurn(root.right, target, count, !isLeft)) {
        count[0] += 1;
        return true;
    }
}
else{
    
    if (pathTurn(root.right, target, count, isLeft))  return true;
    if (pathTurn(root.left, target, count, !isLeft)) {
        count[0] += 1;
        return true;
    }
    
}
      
      
        return false;
    }
}
