//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    int target =  0;
	    for(int ele: arr){
	        target+=ele;
	    }
	    int minDiff =  Integer.MAX_VALUE;
	    boolean[] sumPossible =  possibleSum(arr,n,target);
	   // System.out.println(Arrays.toString(sumPossible));
	    for(int i=0;i<target;i++){
	        if(sumPossible[i]){
	            int s =  Math.abs(target -  2*i);
	            minDiff =  Math.min(s , minDiff);
	        }
	    }
	    
	    return minDiff;
	    
	} 
	
	public boolean[] possibleSum(int arr[]  , int n, int target){
	    boolean dp[][] =  new boolean[n+1][target+1];
	    
	    for(int i=0;i<=n;i++){
	        for(int j=0;j<=target;j++){
	            if(i==0 || j==0){
	                if(i==0) dp[i][j] =  false;
	                if(j==0) dp[i][j] =  true;
	            }
	            else if(arr[i-1]<=j){
	                dp[i][j] =  dp[i-1][j-arr[i-1]] || dp[i-1][j];
	            }
	            else{
	                dp[i][j] = dp[i-1][j];
	            }
	        }
	    }
	    return dp[n];
	}
	
}
