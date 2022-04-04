class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        // precompuete
        Map<Integer,Integer> map =  new HashMap<>();
        for(int i=0 ;i < words.length ; i++){
            int freq =  leastCharFreq( words[i] );
            map.put( i , freq );            
        }
        int ans[] =  new int[ queries.length ];
        int idx = 0;
        for(String q  : queries ){            
            ans[idx++]  = howManyGreater(map,q);
        }
        return ans;
    }
    int howManyGreater( Map<Integer,Integer> map , String  q){
        int f = leastCharFreq(q);
        int count = 0;
        for(int val : map.keySet() ){
            count += map.get(val) > f?1:0;
        }
        return count;        
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