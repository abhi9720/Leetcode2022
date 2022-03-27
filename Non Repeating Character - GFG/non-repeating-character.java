// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first non-repeating character in a string.
     static char nonrepeatingCharacter(String s)
	    {
	        char ans = '$';
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
	        }
	        
	        
	        return q.size()==0 ? '$':q.peek();
	        
	    }
}

