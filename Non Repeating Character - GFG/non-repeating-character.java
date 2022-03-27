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
        for(char ch : s.toCharArray() ){
            map[ ch-'a' ]++;
        }
        for(char ch : s.toCharArray() ){
            if( map[ch-'a']==1 ){
                ans =  ch;
                break;
            }
        }
        return ans;
        
    }
}

