// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.sortingCost(N, arr));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int sortingCost(int N, int arr[]){
        int lislenn=  lengthOfLIS(arr);
        return arr.length-lislenn;
    }
     public static int lengthOfLIS(int[] arr) {

        
       HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        
        for(int val: arr){
            if(map.containsKey(val - 1)){
                map.put(val, map.get(val - 1) + 1);
            } else {
                map.put(val, 1);
            }
            
            if(map.get(val) > max){
                max = map.get(val);
            }
        }
        return max;
        
    }
}