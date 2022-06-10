class Solution {
    public String getPermutation(int n, int k) {
        char ch[] =  new char[n];
        for(int i=0;i<n;i++){
            ch[i] =  (char)('1'+i);
        }
        for(int i=1;i<k;i++){
            nextPermutation(ch);
        }
        return new String(ch);
    }
    private void nextPermutation(char ch[]){
        int n  =  ch.length;
        int idx = n-1;

        while(idx > 0 &&   ch[idx-1] > ch[idx] ) idx-=1;
        idx-=1;

        if(idx!=-1){
            int idx2=  n-1;
            
            while(idx2>=0 && ch[idx2] < ch[idx] ) idx2-=1;
            if(idx2!=-1){
                char temp =  ch[idx];
                ch[idx]  =  ch[idx2];
                ch[idx2] =  temp;
            }
        }
        reverse(ch,idx+1,n-1);
    }
    
    private void reverse(char ch[] , int s, int e){
        while(s<e){
            char temp =  ch[s];
            ch[s]  =  ch[e];
            ch[e] =  temp;
            s++;
            e--;            
        }
    }
    
}