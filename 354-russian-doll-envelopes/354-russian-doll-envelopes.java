class Solution {

    public int maxEnvelopes(int[][] env) {
        int n = env.length;
        Arrays.sort(
            env,
            (o1, o2) -> {
                if (o2[0] == o1[0]) return o2[1] - o1[1]; else return o1[0] - o2[0];
            }
        );
        int count[] = new int[n];
        int overallmax = 0;
        Arrays.fill(count, 1);

        // System.out.println(Arrays.deepToString(env));

        // for(int i=0;i<n;i++){
        //     // to fill ith , move from 0 to i-1
        //     int max  = count[i];
        //     // for(int j=0;j<i;j++){
        //     //     if( env[j][0] > env[i][0] && env[j][1] > env[i][1] ){
        //             // if( count[j]+1 > max ){
        //             //     max =  count[j]+1;
        //             // }
        //     //     }
        //     // }
        //     int lo = 0 , hi =  i-1;
        //     System.out.println("low : "+lo+"  high: "+hi);
        //     while(lo<=hi){
        //         int mid =  (hi-lo)/2 + lo;
        //         System.out.println(mid+"   :   "+(env[mid][0] > env[i][0] && env[mid][1] > env[i][1]));
        //         if(env[mid][0] > env[i][0] && env[mid][1] > env[i][1]){
        //             if( count[mid]+1 > max ){
        //                 max =  count[mid]+1;
        //             }
        //             lo =  mid+1;
        //         }
        //         else{
        //             hi =  mid-1;
        //         }
        //     }
        //     System.out.println("max at : "+i+"    is -> "+max);
        //     count[i] =  max;
        //     overallmax =  Math.max(overallmax,max);
        //     System.out.println("----------------------------------");
        // }
        int dp[] = new int[env.length];
        int len = 0;
        for (int[] envelope : env) {
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if (index < 0) index = -(index + 1);
            dp[index] = envelope[1];
            if (index == len) len++;
        }
        return len;
    }
}
