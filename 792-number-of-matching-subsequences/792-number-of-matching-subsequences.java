class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashSet<String> present =  new HashSet<>();
        HashSet<String> notPresnt =  new HashSet<>();
        int count   = 0;
        for(int i=0;i<words.length;i++){
            int p1 =  0, p2 = 0;
            String str  =  words[i];
            if(present.contains(str) ){
                p2 =  str.length();
            }
            if(notPresnt.contains(str) ){
                continue;
            }
            while(p1<s.length() && p2<str.length()){
                if(s.charAt(p1)== str.charAt(p2)){
                    p1++;
                    p2++;
                }
                else{
                    p1++;
                }
            }
            if(p2 == str.length() ){
                present.add(str);
                count++;
            }
            else{
                notPresnt.add(str);
            }
        }
        return count;
        
    }
}