// { Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Pair ans = new Solve().getFloorAndCeil(arr, n, x);
            System.out.println(ans.floor + " " + ans.ceil);
        }
    }
}

class Pair {
    int floor, ceil;

    Pair() {
        this.floor = 0;
        this.ceil = 0;
    }

    Pair(int floor, int ceil) {
        this.floor = floor;
        this.ceil = ceil;
    }
}
// } Driver Code Ends


//User function Template for Java




class Solve {
    Pair getFloorAndCeil(int[] arr, int n, int x) {
        Arrays.sort(arr);
        int i =  0 ,  j =  n-1;
		int floor  = -1,ceil =  -1;
	int   l =0,h =  n-1;
    while(l<=h){
        int m =  l+(h-l)/2;
        if(arr[m] == x ){
            floor =  ceil =  x;
            break;
        }
        else if(arr[m]>x ){
            ceil =  arr[m];
            h =  m-1;
        }
        else{
            floor =  arr[m];
            l =  m+1;
        }
        
        
    }
		
		return new Pair(floor,ceil);
    }
    
    
}

