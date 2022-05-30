class Solution {

    public String findLongestWord(String s, List<String> dictionary) {
        String ans = null;
        for (String word : dictionary) {
            int i = 0,j=0;
            // itertate  current word 
            while(i<word.length() && j<s.length() ){
                if(s.charAt(j)==word.charAt(i) ){
                    i++;
                }
                j++;
            }
            if( i == word.length() ){
                if(ans==null || ans.length() < word.length() ){
                    ans =  word;
                }
                else if(ans.length() == word.length() && ans.compareTo(word) > 0 ){
                    ans =  word;
                }
            }
        }
        return ans==null?"":ans;
    }
}
