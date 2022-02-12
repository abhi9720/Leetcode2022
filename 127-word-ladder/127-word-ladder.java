class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> wordset = new HashSet<>(wordList),
        beginSet  = new HashSet<>(),
        endSet   = new HashSet<>();
        
        if(!wordset.contains(endWord) ) return 0;
        
        endSet.add(endWord);
        beginSet.add(beginWord);
        int len=1;
        HashSet<String> visited = new HashSet<String>();
        while(!endSet.isEmpty()&& !beginSet.isEmpty()){
            
            if(beginSet.size() > endSet.size() ){
                HashSet<String> swap =  beginSet;
                beginSet = endSet;
                endSet =  swap;                
            }
            
            HashSet<String> temp = new HashSet<>();
            for(String word : beginSet){
                char [] wordarray =  word.toCharArray();
                
                for(int i=0;i<wordarray.length;i++){
                    char old =  wordarray[i];
                    for(char c='a' ; c<='z';c++){
                        wordarray[i]=c;
                        
                        String target = String.valueOf(wordarray);
                        if(endSet.contains(target) ){
                            return len+1;
                        }
                        
                        // if this word not visited till now 
                        // and also exists in wordlist then add it in visited array
                        
                        if(!visited.contains(target) && wordset.contains(target) ){
                            visited.add(target);
                            temp.add(target);
                        }
                        
                    }
                    wordarray[i]= old;
                }                                
            }
            
            beginSet =  temp;
            len++;         
            
            
        }
        return 0;
        
    }
}