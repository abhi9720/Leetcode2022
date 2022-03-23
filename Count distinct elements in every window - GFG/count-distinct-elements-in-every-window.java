// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        ArrayList<Integer> ans =    new ArrayList<>();
        HashMap<Integer,Integer> map =  new HashMap<>();
      
        for(int i=0;i<n;i++){
            if(i<k){
                map.put(A[i] , map.getOrDefault(A[i],0)+1 );
                if(i==k-1) ans.add(map.size());
            }else{
                // release i-k index  and acquire element ith index 
                int freq =  map.get(A[i-k]);
                if(freq==1){
                    map.remove(A[i-k]);
                }else{
                    map.put(A[i-k], freq-1);
                }
                
                
                // acquire 
                map.put(A[i] , map.getOrDefault(A[i],0)+1 );
                ans.add(map.size());
            }
        }
        return ans;
    }
}

