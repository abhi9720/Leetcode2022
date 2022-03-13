// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) { 
        // let say array of length 8
        // if differnce of count 0 to 1 and 1 to 2 in subarray from 
        // 0 to 3 is x#y
        // if differnce of count 0 to 1 and 1 to 2 in subarray from 
        // 0 to 6 is also x#y
        // that means subarray 4 to 6 have equal number of 0,1,2
        HashMap<String,Integer> map =  new HashMap<>();
        int c0,c1,c2;
        c0=c1=c2=0;
        long count  = 0;
        map.put("0.0",1);
        for(char ch : str.toCharArray() ){
            if(ch=='0') c0++;
            else if(ch=='1') c1++;
            else c2++;
            
            String countstr   =  (c1-c0)+"."+(c2-c1);
            // map.put(countstr)
            if(map.containsKey(countstr) ){
                count+=map.get(countstr);
                map.put(countstr,map.get(countstr)+1 );
            }else{
                map.put(countstr,1);
            }
             
        }
        return count;
    }
} 