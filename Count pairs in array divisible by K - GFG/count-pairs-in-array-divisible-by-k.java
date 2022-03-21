// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    int k = Integer.parseInt(br.readLine().trim());
		    
		    Solution ob= new Solution();
		    System.out.println(ob.countKdivPairs(arr, n, k));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int countKdivPairs(int arr[], int n, int k){
        // count pair whose sum divisible by k 
        int count = 0;
        HashMap<Integer,Integer> map  =  new HashMap<>();
        
        // now find remainder of all pair 
        // x and k-x , reminder element can pair up 
        for(int ele : arr){
            int rem =  ele%k;
            map.put(rem , map.getOrDefault(rem,0)+1);
        }
        
        // on dividing element by k , we hav remainder range 0 to k-1
        for(int i=0;i<=k/2;i++){
            if(i==0 || (k%2==0 && i==k/2) ){
                int val =  map.getOrDefault(i,0);
                count += ((val)*(val-1))/2;
                
            }else{
                int v1  =  map.getOrDefault(i,0);
                int v2 =  map.getOrDefault(k-i,0);
                
                count+= v1*v2;
            }
            
        }
        return count;
        
        
    }
}