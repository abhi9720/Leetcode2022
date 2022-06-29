// This is a math problem：
// 1 = 1
// 4 = 1 + 3
// 9 = 1 + 3 + 5
// 16 = 1 + 3 + 5 + 7
// 25 = 1 + 3 + 5 + 7 + 9
// 36 = 1 + 3 + 5 + 7 + 9 + 11
// ....
// so 1+3+...+(2n-1) = (2n-1 + 1)n/2 = nn
// if numbr is perfect square then it can be expressed like this 

class Solution {
    public boolean isPerfectSquare(int n) {
        int i = 1;
        while(n>0){
            n-=i;
            i+=2;
        }
        return n==0;
    }
}