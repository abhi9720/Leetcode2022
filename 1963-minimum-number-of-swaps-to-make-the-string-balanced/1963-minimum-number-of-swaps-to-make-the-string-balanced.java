class Solution {
    public int minSwaps(String s) {
        // count maximum closing bracket 
        int close =  0 , maxClose = 0;
        for(char ch : s.toCharArray()){
            close =  close + (ch==']'? 1 : -1 );
            maxClose =  Math.max(maxClose , close);            
        }
        
        return (maxClose+1)/2;                        
    }
}