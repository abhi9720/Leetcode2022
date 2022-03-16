class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n =  arr.length;
        HashMap<Integer,Integer> freq =  new HashMap<>();
        for(int ele : arr){            
            int rem =  ((ele)%k+k)%k;
            
            freq.put(rem , freq.getOrDefault(rem,0)+1);                        
        }
        
        if(freq.getOrDefault(0,0)%2!=0) return false;
        int ans =  0;
        for(int i=1;i<=k/2;i++){            
                int t1 =   freq.getOrDefault(i,0);
                int t2 =   freq.getOrDefault(k-i,0);
                if(t1!=t2) return false;                
            }      
           
        
        
        return true;
    }
}