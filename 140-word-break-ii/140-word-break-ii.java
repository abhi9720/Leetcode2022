import java.util.*;
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
         
        List<String> ans  = new ArrayList<>();
         canCreate(s , wordDict , "" ,   ans );
        return ans;
        
    }

    private void canCreate( String target , List<String>wordDict , String  newStr ,List<String> ans   ){
        
        if(target.length()==0){
            ans.add(newStr.strip());
            return;
        }
        
        for(String word  : wordDict){
            if(target.startsWith(word ) ){
                  canCreate(target.substring(word.length()) , wordDict , newStr +word+" " ,ans   );
            }
        }                       
    }
    
}