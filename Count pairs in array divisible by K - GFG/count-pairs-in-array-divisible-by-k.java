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
    public static int countKdivPairs(int arr[], int n, int k)
    {
        int freq[] =  new int[k];
        // store rem in hasmap with freq 
        for(int  ele : arr){
            int rem  =   ( (ele%k) +k)%k;
            freq[rem]++;
        }
        int count =  0;
        // now form pair
        for(int i=0;i<=k/2;i++){
            int rem  =  i;
            if(rem==0 || (k%2==0 && rem==k/2 ) ){
                int val =  freq[rem];
                count  +=  (val*(val-1))/2;
            }else{
                int f1 =  freq[rem];
                int f2 =  freq[k-rem];
                count += (f1*f2);
            }
        }
        return count;
    }
}

