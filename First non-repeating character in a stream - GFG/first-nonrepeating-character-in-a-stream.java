//{ Driver Code Starts
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
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        
        StringBuilder sb =  new StringBuilder();
        Queue<Character> q =  new ArrayDeque<>();
        HashMap<Character,Integer> map =  new HashMap<>();
        char nonrepeated =  A.charAt(0);
        map.put( nonrepeated ,1 );
        sb.append(nonrepeated);
        for(int i=1;i<A.length();i++){
            char ch =  A.charAt(i);
            map.put( ch , map.getOrDefault(ch,0)+1 );
            int occ =  map.get(ch);
            if(occ==1){
                q.offer(ch);
            }
            if(nonrepeated == ch){
                nonrepeated =  '#';
            }
            
            if(nonrepeated=='#'){
                nonrepeated =  findNonRepeatedCharTillNow(map,q);
            }
            
           
            sb.append(nonrepeated);
            
            
            
           
            
        }
       
        return sb.toString();
    }
    
    char findNonRepeatedCharTillNow(HashMap<Character,Integer> map, Queue<Character>q){
        // System.out.println(q);
        // System.out.println(map);
        // System.out.println();
         while(q.size()!=0 && map.get(q.peek()) >1 ){
             q.poll();
         }
         return q.size()==0 ? '#' :q.peek();
    }
    
    
}