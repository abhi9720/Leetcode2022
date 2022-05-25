// width is increasing, but if two widths are the same, the height is decreasing
// after sorting, all envolopes are valid 'based on width', so we just binary search based on 'heights'
// to choose 'some of them' to meet the requirement
// Ex. after sorting: (1,3),(3,4), (3,3), (6,8), (6,7), (8,4), (9,5) 
// transform to question find LIS: [3,4,3,8,7,4,5] => like '300. Longest Increasing Subsequence'

// For example, [[3,3] cannot fit in [3,4]]. Sorting height in descending order when there is a tie prevents such a sequence to be included in the solution i.e., (3,4) ,(3,3) 
// not 3,4 cannot we form and not give wrong answer 

class Solution {

    public int maxEnvelopes(int[][] env) {
        int n = env.length;
        Arrays.sort(env,(o1, o2) -> {
                if (o2[0] == o1[0]) return o2[1] - o1[1]; 
                else return o1[0] - o2[0];
            }
        );
        
        int tails[] =  new int[env.length];
        int size = 0;
         // we can maintain our tail as miniumum possible so any higher element can append;
        // instead of doing linear back traversal 
        // we can do binary search 
        // we have to implement lis on heights
        for(int e[] : env){
            
            int lo =  0, hi = size,mid;
            while(lo<hi){
                mid =  lo+(hi-lo)/2;
                if(tails[mid] < e[1] ){
                    lo =  mid+1;
                }else{
                    hi =  mid;
                    // hi  =  mid because we donot mid element is equal to greater
                }
            }
            
            // we have figured our correct position of e[1]
            tails[lo] =  e[1];
            if( lo == size ){
                size+=1;
            }
        }
        // size longest increasing lis 
        // width is sorted , not height mattern which forming lis of length -> size
        // so this number of   envelopes you can Russian doll
        return size;
        
    }
}
