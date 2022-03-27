// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


class Solution{
    	class pair{
		int start , freq,end;
		public pair() {
			this.start =  0;;
			 this.freq=0;
			 this.end=0;
		}
		
	}
	
	ArrayList<Integer> smallestSubsegment(int a[], int n){
		HashMap<Integer, pair> map =  new HashMap<>();
		pair mfe =  new pair();
		for(int i=0;i<a.length;i++){
	            if(!map.containsKey(a[i]) ){
	            	pair  ele =  new pair();
	                ele.start =  i;
	                ele.end=i;
	                ele.freq =  1;
	                map.put(a[i] , ele  );
	                if(ele.freq > mfe.freq){
	                    mfe =  ele;
	                }
	            }else{
	            	pair  ele =  map.get( a[i] );
	                ele.freq+=1;	  
	                ele.end=i;
	                if(ele.freq>mfe.freq){
	                    mfe = ele;
	                }
	                else if( ele.freq==mfe.freq){
	                    if( (ele.end -  ele.start ) < (mfe.end -  mfe.start) ){
	                        mfe =  ele;
	                    }
	                    // else keep same donot update 
	                }
	            }
	        }
		
		
		 ArrayList<Integer> ans =  new ArrayList<>();
		 int freq =  mfe.freq ,ele = a[mfe.start];
		 for(int i =  mfe.start ; freq>0;i++) {
			 if( a[i]== ele ) {
				 freq-=1;
			 }
			 ans.add(a[i]);
		 }
		return ans;
	}
    
}


// { Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    res = obj.smallestSubsegment(arr, sizeOfArray);
		    for(int i:res)
		        System.out.print(i + " ");
		    System.out.println();
		}
	}
}


            

  // } Driver Code Ends