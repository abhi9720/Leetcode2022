class Solution {

    public List<Integer> grayCode(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        ans.add(0); ans.add(1) ;
        for(int i=2;i<=n;i++){
            // itertate list
            int prev =  i-1;            
            
            int size =   ans.size();
            for(int itr=size-1;itr>=0;itr--   ){   
                int ele  =  ans.get(itr);
                ans.add((1<<prev )| ele);                                             
            }
            
        }
        return ans;
        
    }
}
