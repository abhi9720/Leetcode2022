class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        // pre-compute
        int frequency[]   =  new int[words.length];
        for(int i=0 ;i < words.length ; i++){
            int freq =  leastCharFreq( words[i] );
            frequency[i]  =  freq;
        }
        Arrays.sort(frequency);
        
        int ans[] =  new int[ queries.length ];
        int idx = 0;
        for(String q  : queries ){            
            ans[idx++]  = howManyGreater(frequency,q);
        }
        return ans;
    }
    int howManyGreater(int frequency[]  , String  q){
        int f = leastCharFreq(q);
        
        int count = 0 ;
        int low = 0 , high = frequency.length-1;
        while(low <= high){
            int mid =  low+(high-low)/2;
            
            if( frequency[mid] <= f ){
                low =  mid+1;
            }else{
                high =  mid-1;
            }
        }
        return frequency.length-low;
           
    }
    
    int leastCharFreq(String word){
        int map[] =  new int[26];
        for(char ch : word.toCharArray() ){
            map[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if(map[i]!=0) return map[i];
        }
        return 0;
    }
}