// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        return merge(arr,0,arr.length-1);
    }
    
    static long merge(long arr[], int start , int end ){
        if(start >= end){
            return 0;
        }
        int mid =  start+(end-start)/2;
        long count1 = merge(arr,start,mid);
        long count2 = merge(arr,mid+1,end);
        return count1+count2+countInversions(arr,start,mid,end);
    }
    
    static long countInversions(long arr[] , int start , int mid , int end){
     // there is two array one from start to mid 
     // other from mid+1 to end  [inclusive]
        int s1 =  start,  e1 =  mid;
        int s2 =  mid+1 , e2 =  end;
        long count = 0;
        long sorted[] =  new long[end-start+1];
        int itr = 0;
        while(s1<=e1 && s2<=e2){
            if(arr[s1] > arr[s2]){
                count += (e1-s1+1);
                sorted[itr++] =  arr[s2++];
            }
            else{
                sorted[itr++] = arr[s1++];
            }
        }
        while(s1<=e1){
            sorted[itr++]=  arr[s1++];
        }
        
        while(s2<=e2){
            sorted[itr++]=  arr[s2++];
        }
        
        // now copy back to orginal array
        itr  = 0;
        while(start<=end){
            arr[start++] =  sorted[itr++];
        }
        
        return count;
     
        
    }
}










