class Solution {
    public int romanToInt(String s) {
        char prev = ' ';
        int num = 0;
        for(int i=0;i<s.length() ;i++ ){
            char curr =  s.charAt(i);
            if(value(prev) >= value(curr) ){
                num+=value(curr);
            }
            else{
                num+= ( value(curr) - 2*value(prev) );
            }
            prev =  curr;
        }
        return num;
        
    }
    int value(char ch){
        if(ch=='I') return 1;
        else if(ch=='V') return 5;
        else if(ch=='X') return 10;
        else if(ch=='L') return 50;
        else if(ch=='C') return 100;
        else if(ch=='D') return 500;
        else if(ch=='M') return 1000;
        else return Integer.MAX_VALUE;
    }
}