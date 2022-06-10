
/*
[1,1,2,5,6,7,10]

here for 0th index element(1), we tried all possible combinations 
so we donot need to try again same combination with 1st index  element(1) ,
as this will result in adding duplicay

e.g 1(0th index) + 7(5th index)
    again if we going to try combination then with 1st index 1 -> then [1,7] going to be repeated 



*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans =  new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates,target,0,ans,new LinkedList<>() );
        return ans;
    }
    private void combinationSum2(int []cand, int target, int idx, List<List<Integer>> ans ,
                                                                  LinkedList<Integer> curr  ){
        
        int n  =  cand.length;
        if(idx>=n || target <=0 ){
            if(target==0){
                ans.add(new ArrayList<>(curr) );
            }
            return ;
        }
        for(int i=idx;i<n;i++){
            if(i>idx && cand[i] == cand[i-1] ) continue;
            if(target < cand[i]) break;
                curr.addLast(cand[i] );
                combinationSum2(cand, target-cand[i], i+1, ans, curr);
                curr.removeLast( );
            
        }
        
                
    }
}