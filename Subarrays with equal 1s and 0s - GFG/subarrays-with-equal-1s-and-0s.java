//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;
class Driverclass
 {
	public static void main (String[] args) {
	   
	   Scanner in = new Scanner(System.in);
	   int t= in.nextInt();
	   while(t-->0){
	       
	       int n = in.nextInt();
	       int [] arr= new int[n];
	       for(int i=0;i<n;i++) {
	           arr[i] = in.nextInt();
	       }
	       System.out.println(new Solution().countSubarrWithEqualZeroAndOne(arr, n));
	   }
	 }
}


// } Driver Code Ends


//User function Template for Java


//User function Template for Java

class Solution
{
    // Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n){
        
        // treat 0 as -1 and 1 as 1 
        Map<Integer,Integer> map =  new HashMap<>();
        map.put(0,1);
        int ans = 0,c0 = 0 , c1 = 0;
        
        // for(int ele : arr ){
        //     sum+=(ele==0?-1:1);
        //     if(map.containsKey(sum) ){
        //         count+=map.get(sum);
        //         map.put(sum,map.get(sum)+1);
        //     } else {
        //         map.put(sum,1);
        //     }
        // }
        for(int ele : arr){
            if(ele==0) c0++;
            else c1++;
            int diff =  c0-c1;
            
            if(map.containsKey(diff) ){
                ans+= map.get(diff);
                map.put(diff , map.get(diff)+1);
            }
            else{
                map.put(diff,1);
            }
        }
        
        return ans;
        
    }
}
