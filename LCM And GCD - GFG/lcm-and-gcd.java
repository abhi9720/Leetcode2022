// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            Long A = Long.parseLong(S[0]);
            Long B = Long.parseLong(S[1]);

            Solution ob = new Solution();
            Long[] ptr = ob.lcmAndGcd(A,B);
            
            System.out.print(ptr[0]);
            System.out.print(" ");
            System.out.println(ptr[1]);
        }
    }
}// } Driver Code Ends


class Solution {
    static Long[] lcmAndGcd(Long A , Long B) {
       Long _g   =  _gcd(A,B);
       return new Long[]{(A*B)/_g,_g};
        
    }
    static Long gcd(Long A,Long B){
         if(A==0) return B;
            return gcd(B%A,A);
    }
    static Long _gcd(Long A,Long B){
        while(A!=0){
            Long r =  B%A;
            B =  A;
            A =  r;
        }
        return B;
    }
};