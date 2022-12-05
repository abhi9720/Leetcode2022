//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int dp[][] ;
    static int matrixMultiplication(int N, int arr[])
    {
     
     int n  =  arr.length;
     dp =  new int[n][n];
     for(int rows[] : dp){
         Arrays.fill(rows,-1);
     }
     return helper(arr,1,arr.length-1);
    }
    private static int helper(int arr[], int i ,int j){
        if(i>=j) return  0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans =  Integer.MAX_VALUE;
        for(int k =  i;k<j;k++){
            int ans1 =  helper(arr, i,k);
            int ans2 =  helper(arr,k+1,j);
            int temp  =  ans1+ans2+arr[i-1]*arr[k]*arr[j];
            ans =  Math.min(ans , temp);
        }
        return dp[i][j] = ans;
    }
}