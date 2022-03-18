// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java



import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java



class Solution
{
    boolean checkIsAP(int arr[] ,int n)
    {
        int min1 , min2;
        min2 =  min1 =  Integer.MAX_VALUE;
        HashMap<Integer,Integer> map =  new HashMap<Integer,Integer>();
        for(int ele : arr){
            if(ele < min1){
                min2 =  min1;
                min1 =  ele;
            }else if(ele < min2){
                min2 =  ele;
            }
            map.put(ele , map.getOrDefault(ele,0)+1 );
        }
        
        int diff =  min2 - min1;
        int term =  min1;
        int count  = 0;
        while( map.containsKey(term) ){
            count++;
            term =  term+diff;
        }
        return count ==  n;
        

    
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
            for(int  i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(a1[i]);
            }
            Solution ob=new Solution();

            boolean ans=ob.checkIsAP(a,n);
            if(ans==true)
            System.out.println("YES");
            else
            System.out.println("NO");
        }
    }
}



  // } Driver Code Ends