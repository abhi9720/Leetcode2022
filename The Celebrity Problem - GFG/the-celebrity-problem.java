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
    int celebrity(int M[][], int n)
    {
        Stack<Integer> stk  =  new Stack<>();
        
        for(int i=0;i<n;i++ ){
            stk.push(i);
        }
        
        int count = 0;
        while(stk.size()>1 ){
            int p1  =  stk.pop(), p2 =  stk.pop();
            if(M[p1][p2]==1){
                stk.push(p2);
            }
            else{
                stk.push(p1);
                }
                if(M[p1][p2]==0 && M[p2][p1]==0){
                    count++;
                }
            }
            int p =  stk.peek();
            for(int i=0;i<n;i++){
                if(M[p][i]!=0) return -1;
            }
            if(count==n-1) return -1;
    
        return p;
        
        // n^2
        // int celebrity =  -1;
        // for(int i=0;i<n;i++){
        //     int count= 0;
        //     for(int mapping : M[i]){
        //         if(mapping==0){
        //             count+=1;
        //         }
        //     }
        //     if(count==n){
        //         if(celebrity!=-1){
        //             return -1;
        //         }
        //         celebrity =  i;
        //     }
        // }
        
        // return celebrity;
    	
    }
}