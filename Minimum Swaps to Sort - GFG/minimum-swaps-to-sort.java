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
        int n =  nums.length;
        parent =  new int[n];
        size =  new int[n];
        for(int i=0;i<n;i++){
            parent[i] =  i;
        }
        Arrays.fill(size,1);
        
        ArrayList<pair> arrpos =  new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            arrpos.add( new pair(nums[i] ,  i ) );
        }
        Collections.sort(arrpos ,  (a,b)-> a.ele  - b.ele );
        
        
        int swap = 0;
        for(int i=0;i<n;i++){
            if(i!=arrpos.get(i).idx ){
                int s1L  =  find(i);
                int s2L  =  find(arrpos.get(i).idx) ;
                if(s1L!=s2L){
                    union(s1L ,s2L );
                }
                
            }
        }
        // same set sub component size not added,
        boolean used[] =  new boolean[n];
        for(int i=0;i<n;i++){
            int lead = find(i);
            if(!used[lead]){
                used[lead] =  true;
                swap+=size[lead]-1;
            }
        }
   
        return swap;
        
    }
    int parent[] , size[];
    int find(int x){
        if(parent[x] !=x ){
            parent[x] =  find(parent[x]);
        }
        return parent[x];
    }
    
    void union(int s1 , int s2){
     if(size[s1] <= size[s2] ){
         parent[s1] =  s2;
         size[s2]+=size[s1];
     }
     else{
         parent[s2] =  s1;
         size[s1]+=size[s2];
     }
    }
    
    
    
}