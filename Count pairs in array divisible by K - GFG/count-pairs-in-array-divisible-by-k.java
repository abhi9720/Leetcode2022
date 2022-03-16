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
        HashMap<Integer, Integer> hm = new HashMap<>();
                
        for(int val : arr){
            int t = val%k;   
            if(t<0){
                t+=k;
            }
            if(hm.containsKey(t)){            
                hm.put(t, hm.get(t)+1);
            }
            else{
                hm.put(t,1);
            }
        }
        
        int ans = 0 ;
        for(int i=0;i<= k/2;i++){
           int t = i;
           if( t ==0 || (t== k/2 && k%2==0) ){
             int t1 = hm.getOrDefault(t,0);
             hm.remove(t); 
             if(t1>=1){
                 int pair = ((t1*(t1-1)) /2 ) ;
                 ans+=pair;
             }
             
           } else if(hm.containsKey(k - t )){
               
              int t1 = hm.getOrDefault(t,0);
              int t2 = hm.getOrDefault(k-t,0);

              
               
               hm.remove(t);
               hm.remove(k-t);
               
               ans=ans+(t1*t2);
           }
           
        }
        
        return ans;
        
    }
}