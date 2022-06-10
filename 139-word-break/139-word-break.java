/*
Use map to cache result 

=> ["a","aa","aaa"]
    aaaaaaaaa
      aaaaaaa - we can cache this string resuly how 
     
     removing 2a's in 2 times same equivalne to removing 2 a's in one time 
      so "aaaaaaa" same this string result can be returned 
     
     

*/

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Boolean> map =  new HashMap<>();
        return dfs(s, wordDict,map);
    }

    private boolean dfs(String s, List<String> wordDict,HashMap<String, Boolean> map) {
        
        if(map.containsKey(s) ) return map.get(s);                
        if (s.length() == 0) {
            return true;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String remain = s.substring(word.length());
                if (dfs(remain, wordDict,map)){
                    map.put(s,true);
                    return true;
                    }
            }
        }
        map.put(s,false);
        return false;
    }
}
