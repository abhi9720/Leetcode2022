// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int nums[], int size)
    {
        if(size==1){
            return nums[0];
        }
         int freq =1;
        int ele =  nums[0];
        for(int i=1;i<nums.length;i++){
            if(ele!=nums[i]){
                freq-=1;
            }
            else{
                freq+=1;
            }            
            if(freq==0){
                ele =  nums[i];
                freq=1;
            }
            
            if(freq>size/2) return ele;
            
        }
        int count = 0;
        for(int e1 : nums){
            if(ele==e1){
                count++;
            }
        }
        
        if(count>size/2)
            return ele;
        else
            return -1;
        
            
    }
}