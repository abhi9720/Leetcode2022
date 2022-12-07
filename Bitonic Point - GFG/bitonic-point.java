//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaximum(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int findMaximum(int[] nums, int n) {
        
        int si = 0 , ei =  n-1;
        if(si==ei) return si;
        while(si<=ei){
            int mid =  si+(ei-si)/2;
            int next =  mid+1;
            int prev =  mid-1;

            if(mid>0 && mid<n-1){
               
                if(nums[mid]>nums[prev] && nums[mid]>nums[next]){
                    return nums[mid];
                }
                else if(nums[prev]>nums[mid]){
                    ei=  mid-1;                    
                }
                else{
                    si =  mid+1;
                }
            }else if(mid==0){
                if(nums[mid]>nums[next]) return nums[mid];
                else si =  mid+1;
            }
            else{
                if(nums[mid]>nums[prev]) return nums[mid];
                else ei =  mid-1;
            }
        }

        return -1;
        
        
    }
}