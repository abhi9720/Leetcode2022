class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans =  new ArrayList<>();
        HashMap<String,ArrayList<String>> map =  new HashMap<>();
        for( int i=0;i<strs.length;i++  ){
            String str =  strs[i];
            char freq[] =  new char[26];
            // create freq map
            for(char ch : str.toCharArray() ){
                freq[ch-'a']++;
            }
            
            String key =  String.valueOf(freq);
            if(!map.containsKey(key) ){
                map.put(key,new ArrayList() );
            }
            map.get(key).add(str);
            
        }
        
        ans =  new ArrayList<>(map.values());   
        return ans;
    }
}