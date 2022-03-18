class Solution {
    public String removeDuplicateLetters(String s) {
        int n =  s.length();
        Stack<Character> stk =  new Stack<>();
        int last[] =  new int[26];
        boolean used[] = new boolean[26];
        // store last index 
        for(int i=0;i<n;i++){
            last[s.charAt(i)-'a'] = i;
        }
        // now make string 
        for(int i=0;i<s.length();i++){
            char ch =  s.charAt(i);
            // if it alredy used then no need to use it again 
            if(used[ch-'a']) continue;            
            used[ch-'a'] =  true; //  mark visited
            
            while(!stk.isEmpty() && stk.peek() > ch && i< last[stk.peek()-'a'] ){
                used[ stk.pop()-'a' ] = false;                
            }                
            stk.push(ch);
        }
        // now make string back
        StringBuilder sb  =  new StringBuilder();
        for(Character ch : stk){
            sb.append(ch);            
        }
        stk.clear();
        
        return sb.toString();
    }
}