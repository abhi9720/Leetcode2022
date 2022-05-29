class Solution {
    public int maxProduct(String[] words) {
        int n  = words.length;
        int bitcode[] =  new int[n];
        int idx = 0;
        for(String word : words){
            int code = 0;
            for(char ch : word.toCharArray() ){
                code =  code | 1<<(ch-'a');
            }
            bitcode[idx++]  = code;
        }
        
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && (bitcode[i] & bitcode[j]) ==0){
                    int val =  words[i].length() * words[j].length();
                    ans = Math.max(val,ans);
                }
            }
        }
        return ans;
    }
}