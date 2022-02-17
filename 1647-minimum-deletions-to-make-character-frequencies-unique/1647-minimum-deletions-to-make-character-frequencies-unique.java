class Solution {
    public int minDeletions(String s) {
        Set<Integer> freqset =  new HashSet<Integer>();
        int freq[] =  new int[26];
        int n =  s.length();
        for(int i=0;i<n;i++){
            freq[ s.charAt(i)-'a' ]++;
        }
        int del  = 0;
        for(int i=0;i<26;i++){
            if(freq[i]==0) continue;
            
            if(!freqset.contains( freq[i]  ) ){
                freqset.add(freq[i] );
            }else{
                int f =  freq[i];
                while(f>0 && freqset.contains( f) ){
                    f--;
                    del++;
                }
                if(f>0){
                    freqset.add(f);
                }
                freq[i] =  f;                                
            }                        
        }
        return del;
        
    }
}