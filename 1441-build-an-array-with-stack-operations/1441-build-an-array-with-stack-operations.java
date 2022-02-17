class Solution {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> ans =  new ArrayList();
        int itr =  0;
        for(int i=1;i<=n;i++){            
            ans.add("Push");            
            if(target[itr]!= i ){
                ans.add("Pop");
            }else{
                itr++;
            }
            if(itr==target.length){
                
                return ans;
            }
        }
        return ans;        
    }
}