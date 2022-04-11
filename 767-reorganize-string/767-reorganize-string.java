class Solution {
    public String reorganizeString(String s) {
        int freq[] =  new int[26];
        for(char ch : s.toCharArray() ){
            freq[ch-'a']++;
        }
        
        int max = 0, maxLetter = 0;
        for(int i=0;i<26;i++){
            if(freq[i] >max ){
                maxLetter =  i;
                max = freq[i];
            }
        }
        
        if(max > (s.length()+1 )/2 ){
            return "";
        }
        
        
        int idx = 0;
        char sb[] =  new char[s.length() ];
        while(freq[maxLetter] >0 ){
            sb[idx] = (char)('a' + maxLetter);
            idx+=2;
            freq[maxLetter]-=1;
        }
        
        for(int i=0;i<26;i++){
            while(freq[i] >0 ){
                if(idx >= sb.length ){
                    idx = 1;
                }
                sb[idx] =  (char)('a'+i) ;
                idx+=2;
                freq[i]-=1;                
            }
        }                        
        return String.valueOf(sb);
            
    }
}