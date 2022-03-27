class Solution {
    public int[] kWeakestRows(int[][] arr, int k) {
        int n   =  arr.length;
        int m  =  arr[0].length;
        int ans[] =  new int[k];
        int idx =0;
        HashSet<Integer> set =  new HashSet<>();
        for(int j=0;j<m;j++ ){
            for(int i=0;i<n;i++){
                if(  arr[i][j]==0  && ( j==0  || arr[i][j-1]!=0 ) ){
                   ans[idx++]  =  i;
                    set.add(i);
                   if(idx==k) return ans;
                }                
            }                    
        }
        if(idx!=k){
            for(int i=0;i<n;i++){
                if(!set.contains(i) ){
                    ans[idx++]  =  i;
                    set.add(i);
                    if(idx==k) return ans;
                }
            }
        }
        return ans;
    }
}