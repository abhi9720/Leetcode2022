class Solution {
    public int reachNumber(int target) {
        target =  Math.abs(target);        
        int sum = 0;
        for(int i=0;true;i++){
             sum = getSum(i);            
            if( target <= sum && ((sum-target)&1)==0 ){
                return i;
            }
        }
        
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