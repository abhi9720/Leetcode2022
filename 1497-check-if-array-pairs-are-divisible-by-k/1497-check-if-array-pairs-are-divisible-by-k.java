class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n =  arr.length;
        HashMap<Integer,Integer> freq =  new HashMap<>();
        for(int ele : arr){            
            int rem =  ((ele)%k+k)%k;
            
            freq.put(rem , freq.getOrDefault(rem,0)+1);                        
        }
        
                
        int ans =  0;
        for(int i=0;i<=k/2;i++){
            int rm =  i;
            if(rm==0 || (k%2==0 && rm==k/2 )){
                int f =  freq.getOrDefault(rm,0);                
                if(f%2!=0) return false;
                ans += (f)/2;      
                freq.remove(rm);
            }else{
                int t1 =   freq.getOrDefault(rm,0);
                int t2 =   freq.getOrDefault(k-rm,0);
                if(t1!=t2) return false;
                ans =  ans+(t1); 
                freq.remove(rm);
                freq.remove(k-rm);
                
            }      
           
        }
        
        return ans==n/2;                
    }
}