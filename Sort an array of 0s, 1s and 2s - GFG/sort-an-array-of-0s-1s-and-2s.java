// { Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function template for Java

class Solution
{
    
    //
    public static void sort012(int nums[], int n)
    {
        int p1=  0 , p2 =  nums.length-1;
        int i =0;
        while(i<=p2){
            if(nums[i]==0 ){
                swap(nums,i,p1);
                i++;
                p1++;
            }
            else if(nums[i]==2 ){
                swap(nums,i,p2);
                p2--;                
            }
            else{// 1 found 
                i++;
            }
        }                    
    }
    private static void swap(int a[] , int i , int j){
        int t=  a[i];
        a[i] = a[j];
        a[j] =  t;
    }
}

// { Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}

  // } Driver Code Ends