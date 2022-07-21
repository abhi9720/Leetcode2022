class Solution {
    String encode [] =  {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set =  new HashSet<>();
        for(String str : words){
            StringBuilder sb =  new StringBuilder();
            for(char ch : str.toCharArray() ){
                sb.append( encode[ch-'a'] );
            }
            set.add(sb.toString() );
        }
        return set.size();
    }
}