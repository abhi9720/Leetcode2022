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
        public void setLeft(Node left) 
    {
        this.left = left;
    }
  
    public void setRight(Node right) 
    {
        this.right = right;
    }
        
    
}


class ConstructBT
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        
	        int inord[] = new int[n];
	        int level[] = new int[n];
	        for(int i = 0; i < n; i++)
	            inord[i] = sc.nextInt();
	            
	        for(int i = 0; i < n; i++)
	             level[i] = sc.nextInt();
	             
	        GfG g = new GfG();
	        Node node =  g.buildTree(inord, level);
	        printPreOrder(node);
	        System.out.println();
	        
	        
	    }
    }
    
   static void printPreOrder(Node node)
   {
       if(node == null)
          return;
          
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
   }
}
// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    Node buildTree(int inord[], int level[])
    {
        return helper(inord,level,0,inord.length-1);
    }
    
    
     public static Node helper(int[] inorder, int[] levelOrder, int ins, int ine) {
    if (ins > ine) {
      return null;
    }


    if (ins == ine) {
      return new Node(inorder[ins]);
    }


    int idx = 0;

    HashMap<Integer, Integer> map =  new HashMap<>();
    for (int j = ins; j <= ine; j++) {
      map.put(inorder[j], j );
    }

    for (int i = 0; i < levelOrder.length; i++) {
      if (map.containsKey(levelOrder[i]) ) {
        idx =  map.get(levelOrder[i]);
        break;
      }
      
    }
    map.clear();

    Node root  =  new Node(inorder[idx]);
    root.left      =  helper(inorder, levelOrder, ins, idx - 1);
    root.right     =  helper(inorder, levelOrder, idx + 1, ine);

    return root;
  }


}


