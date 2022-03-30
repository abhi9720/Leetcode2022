// { Driver Code Starts
//Initial Template for Java


//Initial Template for Java


import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


 
class Solution
{ 
    // Method to calculate distinct sub-array 
    static int countDistinctSubarray(int arr[], int n) 
    { 
        // count distinct element 
        HashSet<Integer> unqiue =  new HashSet<>();
        for(int ele : arr){
            unqiue.add(ele);
        }
        int k =  unqiue.size();
        
        int count =  AtMostK(arr, k) -  AtMostK(arr,k-1);
        return count;

    }
    private static int AtMostK(int arr[] , int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0 , j = 0;
        int count = 0;
        while(i<arr.length){
            
            // acquire 
            map.put( arr[i] , map.getOrDefault(arr[i],0)+1 );
            
            // release 
            while( map.size() > k ){
                int prev =  map.put( arr[j] ,map.get(arr[j] )-1 );
                if(prev==1){
                    map.remove(arr[j]);
                }
                j++;
            }
        count+= (i-j+1);
        i++;
        }
    return count;
    }
    
    
    
}


// { Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    int n=Integer.parseInt(br.readLine());
		    String line1 = br.readLine();
		    String[] a1 = line1.trim().split("\\s+");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(a1[i]);
		    }
		    Solution ob=new Solution();
		    int ans=ob.countDistinctSubarray(a,n);
		    System.out.println(ans);
		    
		}
	}
}
  // } Driver Code Ends