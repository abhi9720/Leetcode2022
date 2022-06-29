class Solution {
    public String reverseVowels(String s) {
        char ch[] =  s.toCharArray();
        int n  =  ch.length;
        int i= 0  , j =  n-1;
        HashSet<Character> vowels =  new HashSet<>(){{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};
        
        while(i<j){
            while( i < n && !vowels.contains(ch[i]) ){
                i++;
            }
            
            while( j>=0 && !vowels.contains(ch[j]) ){
                j--;
            }
            if(i<j){
                char temp =  ch[i];
                ch[i] =  ch[j];
                ch[j] = temp;                
            }
            i++;
            j--;
        }
        return new String(ch);
    }
}