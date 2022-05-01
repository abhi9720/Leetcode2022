class Solution {
    public long appealSum(String s) {
        int arr[] =  new int[26];
        Arrays.fill(arr,-1);
        long res = 0, last_added = 0;
        for(int i=0;i<s.length();i++ ){
            long inc =0;
            if(arr[s.charAt(i)-'a'] ==-1){
                inc =  last_added;
                inc+=(i+1);
            }
            else{
                inc =  last_added;
                inc+=(i-arr[s.charAt(i)-'a']);
            }
            res+=inc;
            last_added=inc;
            arr[s.charAt(i)-'a']=i;
        }
        return res;                
    }
}