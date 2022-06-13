// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{


 int NthRoot(int n, int m)
{
    // Code here.
    if(n == 1){
        return m;
    }
    if(m == 1){
        return 1;
    }
    
    int low = 1, high = (int)Math.sqrt(m);
    while(low <= high){
        int mid = low + (high - low)/2;
        long  power = 1;
        for(int i = 1; i <= n; i++){
            power *= mid;
            if(power > m){
                break;
            }
        }
        
        if(power == m){
            return mid;
        }
        
        if(power > m){
            high = mid-1;
        }
        
        else{
            low = mid+1;
        }
        
    }
    return -1;
}   
   
}
