class Solution {
    public int reachNumber(int target) {
        target =  Math.abs(target);        
        int sum = 0;
    int move = 0;
 
    // Continue till number is lesser or not in same parity
    while (getSum(move) < target || ((getSum(move) - target) & 1)==1){
        move++;
 }
        
        return move;
    }
    private int getSum(int n ){
        return n*(n+1)/2;
    }
}

/*
3
7
8
9
10
11
12
13
14
15
16
17
18
20
454
343
232
329839
272
2898923
*/