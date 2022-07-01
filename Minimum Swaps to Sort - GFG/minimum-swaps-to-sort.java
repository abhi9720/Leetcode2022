// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    class pair{
        int ele  , idx;
        public pair(int ele , int idx){
            this.ele =  ele;
            this.idx = idx;
        }
    }
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        ArrayList<pair> arrpos =  new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            arrpos.add( new pair(nums[i] ,  i ) );
        }
        Collections.sort(arrpos ,  (a,b)-> a.ele  - b.ele );
        
        boolean visit[] = new boolean[nums.length];
        int swap = 0;
        for(int i=0;i<nums.length;i++){
            int j = i;
            int len = 0;
            // only run if not visited and only for those element which are not
            // at its correct position
            while(!visit[j] && arrpos.get(i).idx!=i){
                visit[j] =  true;
                len++;
                j =  arrpos.get(j).idx;
            }
            
            swap+=Math.max(len-1 , 0);
        }
        return swap;
        
    }
}