// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n){      
      Stack<Integer> stk =  new Stack<>();
      for(int i=0;i<n;i++){
        stk.push(i);
      }
      int count = 0;
      while(stk.size()>1 ){
        int p1 =  stk.pop();
        int p2 =  stk.pop();
        // if p1 knows p2 than p1 cannot be celebrity
        // if p2 knows p1 than  p2 cannot be celebrity
        // if p1 and p2 don't know any each other p1 cannot be celebrity 
        // as celebrity is know by every one 

        if(M[p1][p2]==1){
          stk.push(p2);
        }
        else  {
          stk.push(p1);
          if(M[p1][p2]==0 && M[p2][p1]==0){
                count++;
          }
        }
      }

      // atlast make sure reamined person is celebrity 
      int p =  stk.peek();
      for(int i=0;i<n;i++){
        if(M[p][i]==1) return -1;
      }
      
      if(count==n-1) return -1;
      return p;    	 
    }
}