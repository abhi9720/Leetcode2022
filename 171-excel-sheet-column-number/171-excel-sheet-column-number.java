class Solution {
    public int titleToNumber(String col) {
        int num = 0;
        int power  =  1;
        for(int i=col.length()-1;i>=0;i-- ){
            num  =  num + power*( col.charAt(i)-64 );
            power =  power*26;
        }
        return num;
    }
}


