// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    long substrCount (String S, int K) {
        
        return  AtMostK(S,K) - AtMostK(S,K-1);
    }
    
    public static long AtMostK(String str, int k) {
		long count  = 0, distinct = 0;
		int i = 0, j = 0 ;
		int map[] =  new int[26] ;
		while(i<str.length()){
		    char chi =  str.charAt(i);
		    map[chi-'a']++; // acquire 
		    if(map[chi-'a']==1) distinct++;
		    // check it is still valid 
		    while(distinct > k){
		        // release 
		        char chj =  str.charAt(j);
		        map[chj-'a']--;
		        if(map[chj-'a']==0  ){
		            distinct--;
		        }
		        j++;
		    }
		    count+=(i-j+1);
		    i++;
		}
		return count;
	}
    
}