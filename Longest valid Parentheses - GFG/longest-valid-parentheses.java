//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String S){
        Stack<Integer> stk =  new Stack<>();
        stk.push(-1);
        int maxlen = 0;
        for(int i=0;i<S.length();i++){
            char ch =  S.charAt(i);
            if(ch=='('){
                stk.push(i);
            }
            else{
                stk.pop();
                if(stk.size()==0 ){
                    stk.push(i);
                }
                else{
                    int gap =  i -  stk.peek();
                    maxlen =  Math.max(maxlen,gap);
                }
            }
            
        }
        return maxlen;
    }
}