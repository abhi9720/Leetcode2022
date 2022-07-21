class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int freq[] = new int[60];
        int count =0 ;
        for(int ele : time){
            int r =  ele%60;
            
            count+= freq[(60-r)%60];
            
            freq[r]+=1;
        }
        return count;
    }
}