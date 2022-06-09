// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String s = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.encryptString(s));
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String encryptString(String s) 
    {
        int n  =  s.length();
        int count = 0;
        char ch =  s.charAt(0);
        StringBuilder data =  new StringBuilder();
        for(int i=0;i<n;i++){
            if(ch==s.charAt(i) ){
                count++;
            }
            else{
                data.append(ch);
                data.append(count);
                count = 1;
                ch =  s.charAt(i);
            }
        }
        data.append(ch);
        data.append(count);
        data.reverse();
        return data.toString();
    }
} 