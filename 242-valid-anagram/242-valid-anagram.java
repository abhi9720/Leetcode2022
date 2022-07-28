class Solution {
    public boolean isAnagram(String s, String t) {
        
        int f[] =  new int[26];
        for(char ch : s.toCharArray() ){
            f[ch-'a']++;
        }
        for(char ch : t.toCharArray() ){
            f[ch-'a']-=1;
        }
        for(int ele :f){
            if(ele!=0) return false;
        }
        return true;
    }
}