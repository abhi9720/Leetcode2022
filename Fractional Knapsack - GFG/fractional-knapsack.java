// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/
class pair{
    int i;
    double density;
    public pair(int idx , double density){
        this.i =  idx;
        this.density =  density;
    }
}
class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // as partial wait picking is allowed 
        pair data[] =  new pair[n];
        for(int i=0;i<n;i++){
            double density =  (arr[i].value)*(1.0) / arr[i].weight;
            data[i] =  new pair(i,density);
        }
        Arrays.sort(data,(o1,o2)->{
            if(o1.density>o2.density) return -1;
            else return 1;
        } );
        double profit = 0;
        for(int i=0;i<n && W>0;i++){
            int w = ( W > arr[data[i].i].weight  ) ?arr[data[i].i].weight : W;
            W-=w;
            profit+= data[i].density*w;
            
        }
        
        return profit;
        
    }
}