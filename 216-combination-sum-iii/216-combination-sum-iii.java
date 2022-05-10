class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans =  new ArrayList<>();
        ArrayList<Integer> comb =  new ArrayList<>();
        
        helper(k,n,ans,comb,1);
        return ans;
    }
    private void helper(int k , int n, List<List<Integer>> ans,ArrayList<Integer> comb, int lastUsed ){
        if(n==0){
            if(comb.size() == k ){
                ans.add(new ArrayList<>(comb));
            }
            return;
        }
        if(lastUsed>9) return;
        if(n-lastUsed>=0){
            comb.add(lastUsed);
            helper(k,n-lastUsed,ans,comb,lastUsed+1);
            comb.remove(comb.size()-1 );                
        }         
        helper(k,n,ans,comb,lastUsed+1);                    
    }
        
    
}