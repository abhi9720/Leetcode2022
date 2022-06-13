class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer>  ans =  new ArrayList<>();
        helper(n,0,ans);
        return ans;
    }
    private void helper(int n ,int num , List<Integer> ans ){
       
        for(int i=0;i<10;i++){
            if(num==0 && i==0) continue;
            int nextnum = num*10+i;
            if(nextnum<=n){
                ans.add(nextnum);
                helper(n,nextnum,ans);
            }
        }
    }
}