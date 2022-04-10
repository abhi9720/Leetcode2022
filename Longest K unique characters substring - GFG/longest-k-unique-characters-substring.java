// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        HashMap<Character,Integer> map =  new HashMap<>();
        int i = 0, j = 0 , n =  s.length() , len  =  -1;
        
        while( i<n  ){
            char chi =  s.charAt(i);
            map.put(chi, map.getOrDefault(chi,0)+1 );
            
            // check wether set size is equal to k or not 
            while(map.size()>k ) {
                char chj  =  s.charAt(j);
                int prev = map.put(chj , map.get(chj)-1 );
                if(prev==1){
                    map.remove(chj);
                }
                j++;
            }
            if(i-j+1 > len && map.size()==k ){// need to check map 
            // size is k ot not, it make be smaller than k
                    len =  i-j+1;
            }
            i++;
        }
        return len;
        
    }
}