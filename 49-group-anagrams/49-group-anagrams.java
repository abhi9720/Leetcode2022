class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans =  new ArrayList<>();
        HashMap<String,ArrayList<String>> map =  new HashMap<>();
        for( int i=0;i<strs.length;i++  ){
            String str =  strs[i];
           
            
            
            String key =  getCode(str);
            
            if(!map.containsKey(key) ){
                map.put(key,new ArrayList() );
            }
            map.get(key).add(str);
            
        }
        
        ans =  new ArrayList<>(map.values());   
        return ans;
    }
    private String getCode(String str){
        Map<Character,Integer> freqMap =  new TreeMap<>();
        for(char ch : str.toCharArray()){
            freqMap.put(ch , freqMap.getOrDefault(ch,0)+1 );
        }
        StringBuilder code =  new StringBuilder();
        for(char ch : freqMap.keySet() ){
            code.append(ch+""+freqMap.get(ch));
        }
        return code.toString();
    }
}