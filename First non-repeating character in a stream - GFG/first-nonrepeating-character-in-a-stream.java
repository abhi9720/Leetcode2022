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
    public String FirstNonRepeating(String s)
    {
        StringBuilder sb =  new StringBuilder();
        
         int map[]= new int[26];
	        Queue<Character> q =  new ArrayDeque();
	        for(char ch : s.toCharArray() ){
	            map[ ch-'a' ]++;
	            int f = map[ ch-'a'];
	            
	            if(f>1 && !q.isEmpty() &&q.peek()==ch){
	                while(!q.isEmpty() && map[q.peek()-'a']!=1 ){
	                    q.poll();
	                }
	            
	            }else if(f==1){
	                q.add(ch);
	            }
	            
	            sb.append(q.size()==0?'#':q.peek() );
	        }
	        return sb.toString();
      
    }
}