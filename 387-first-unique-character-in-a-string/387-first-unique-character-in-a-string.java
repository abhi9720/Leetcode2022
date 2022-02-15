class Solution {
    // Approach 1: sliding window technique
//     public int firstUniqChar(String s) {
//         int i = -1, j = 0;
//         HashMap < Character, Integer > freq = new HashMap < > ();
//         while (j < s.length()) {
//             if (!freq.containsKey(s.charAt(j))) {
//                 freq.put(s.charAt(j), 1);
//             } else {

//                 freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);

//                 // means this is no longer first unique
//                 while (i != -1 && i < j && freq.get(s.charAt(i)) != 1) {
//                     i++;
//                 }
//                 if (i != -1 && freq.get(s.charAt(i)) != 1) {
//                     i = -1;
//                 }
//             }

//             if (i == -1 && freq.get(s.charAt(j)) == 1) {
//                 i = j;
//             }

//             j++;
//         }
//         return i;
//     }
    
    // Approach 2: Using simple char array and store index of chars 
    public int firstUniqChar(String s) {
        int freq[] =  new int[26];
        Arrays.fill(freq,-1);
        int index =  0;
        for(char ch : s.toCharArray() ){
            if(freq[ch-'a']==-1){
                freq[ch-'a']=index;
            }else{
                freq[ch-'a']=-2;
            }
            index++;
        }
        int MinIndex =  s.length();
        for(char ch : s.toCharArray() ){
            if(freq[ch-'a'] >=0 ){
                MinIndex =  Math.min(MinIndex,freq[ch-'a']);
            }
        }
        return MinIndex==s.length()?-1:MinIndex;                
    }
}
