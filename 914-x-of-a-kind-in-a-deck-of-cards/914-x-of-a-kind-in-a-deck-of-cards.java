class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> map =  new HashMap<>();
        for(int ele : deck){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
       
       
        // now find gdc  -  gdc what maximum value can divide all element 
        // number of set  = count/ gcd and size  of set =  gcd
        int gcd =  0;
        for(int k  : map.keySet()){
            gcd  = (gcd==0) ? map.get(k) : _gcd( gcd, map.get(k) ) ;            
        }
        
        return gcd>=2;
    }
    
    private static int _gcd(int n1 ,int n2){
        
        while(n1%n2!=0){
            int rem  =  n1%n2;
            n1 =  n2;
            n2 =  rem;
        }
        return n2;
    }
}