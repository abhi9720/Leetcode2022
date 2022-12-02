class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : deck){
            map.put(ele , map.getOrDefault(ele,0)+1 );
        }        
        int x = 0;
        for(int freq : map.values() ){
            x =  _gcd(x,freq);
        }
      return x>1;
    }
    int _gcd(int a , int b){
        if(a==0) return b;
        return _gcd(b%a,a);
    }
}
    