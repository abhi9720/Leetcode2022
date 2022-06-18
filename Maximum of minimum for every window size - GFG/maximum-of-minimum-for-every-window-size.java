// { Driver Code Starts
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            Solution ob =new Solution();
            int[] res = ob.maxOfMin(arr, n);
            
            for (int i = 0; i < n; i++) 
                System.out.print (res[i] + " ");
            System.out.println ();
        }
    }
}// } Driver Code Ends

/*
1: Find indexes of next smaller and previous smaller for every element.
For input {10, 20, 30, 50, 10, 70, 30}, array of indexes of next smaller is {7, 4, 4, 4, 7, 6, 7}. 
For input {10, 20, 30, 50, 10, 70, 30}, array of indexes of previous smaller is {-1, 0, 1, 2, -1, 4, 4}

2: This array indicates, the first element is minimum in the window of size 7, 
the second element is minimum in the window of size 3, and so on.
So window in which element is smaller is right[i]-left[i]-1


Create an auxiliary array ans[n+1] to store the result

for (int i=0; i < n; i++){
        // length of the interval
        int len = right[i] - left[i] - 1;

        
        ans[len] = max(ans[len], arr[i]);
        // maximum of minimum all subarray is size len
}


for some entries left empty 

for (int i=n-1; i>=1; i--)
        ans[i] = max(ans[i], ans[i+1]);
        
Because if a element is minimum in window of size k from it
then that element in also minimum in window of size k-1 ,k-2,k-3



*/

class Solution 
{
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) 
    {
        
        int left[] =  new int[n];
        int right[] =  new int[n];
        Stack<Integer> prevSmaller =  new Stack<>();
        for(int i=0;i<n;i++){
            while(!prevSmaller.isEmpty() && arr[prevSmaller.peek()] >= arr[i] ){
                prevSmaller.pop();
            }
            if(prevSmaller.size()==0 ){
                left[i] =  -1;
            }
            else{
                left[i] = prevSmaller.peek();
            }
            prevSmaller.push(i);
        }
        
        Stack<Integer> nextSmaller =  new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!nextSmaller.isEmpty() && arr[nextSmaller.peek()] >= arr[i] ){
                nextSmaller.pop();
            }
            if(nextSmaller.size() ==0 ){
                right[i] = n;
            }
            else{
                right[i] =  nextSmaller.peek();
            }
            nextSmaller.push(i);
        }
        
        
        int ans[] =  new int[n];
        
         for (int i=0; i<n; i++)
        {
            // length of the interval
            int len = right[i] - left[i] - 1;
      
            // arr[i] is a possible answer for this length
            // 'len' interval, check if arr[i] is more than
            // max for 'len'
            ans[len-1] = Math.max(ans[len-1], arr[i]);
        }
          for (int i=n-2; i>=0; i--)
            ans[i] = Math.max(ans[i], ans[i+1]);
            
        // int fans[] =  new int[n];
        // System.arraycopy(ans,1,fans,0,n);
        return ans;
        
        
        
    }
}