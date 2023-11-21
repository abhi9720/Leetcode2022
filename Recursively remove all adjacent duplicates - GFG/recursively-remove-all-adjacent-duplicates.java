//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            String S = br.readLine();
            Solution ob = new Solution();
            String ans = ob.rremove(S).trim();
            if(ans.length() == 0)
                System.out.println();
            else
                System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{

 String rremove(String s) {
        // Create a stack to keep track of characters and their counts
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();

        int i = 0;
        int n = s.length();

        while (i < n) {
            int j = i;
            // Find the index of the first different character
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            int count = j - i;
            if (count == 1) {
                // No adjacent duplicates, push the character and count onto the stack
                charStack.push(s.charAt(i));
                countStack.push(1);
            }

            // Move to the next character
            i = j;
        }

        // Construct the final result string
        StringBuilder result = new StringBuilder();
        while (!charStack.isEmpty()) {
            char ch = charStack.pop();
            int count = countStack.pop();
            if (count == 1) {
                // Append the character to the result
                result.append(ch);
            }
        }

        // Reverse the result string as characters were popped from the stack
        result.reverse();

        // If the result string is not empty, recursively call the function
        if (result.length() < n) {
            return rremove(result.toString());
        } else {
            return result.toString();
        }
    }

}