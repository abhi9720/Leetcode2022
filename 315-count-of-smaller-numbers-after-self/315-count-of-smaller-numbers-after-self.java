class Solution {
    class pair{
        int ele;
        int index;
        public pair(int ele , int idx){
            this.ele =  ele;
            this.index =  idx;
            
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        ArrayList<pair> li =  new ArrayList<>();
        int n =  nums.length;;
        List<Integer> ans =  new ArrayList<>();
        for(int i=0;i<n;i++){
            li.add(new pair(nums[i] , i ) );
            ans.add(0);
        }
        
        mergeAndCount(li , 0 , n-1, ans);
        
        return ans;
    }
    private void mergeAndCount(ArrayList<pair> li , int s , int e, List<Integer> ans){
        if(s>=e) return;
        
        int mid =  (e-s)/2+s;
        mergeAndCount(li,s,mid,ans);
        mergeAndCount(li,mid+1,e,ans);
        
        ArrayList<pair> sorted =  new ArrayList<>();
        int left =  s , right =  mid+1;
        int count_lesser_ele_on_right =  0;
        while(left<=mid && right<=e){
            if(li.get(left).ele > li.get(right).ele ){
                sorted.add(li.get(right));
                count_lesser_ele_on_right++;
                right++;
            }
            else{
                int idx =  li.get(left).index;
                ans.set(idx , ans.get(idx) + count_lesser_ele_on_right);
                sorted.add(li.get(left));
                left++;
            }
        }
        
        while(left<=mid){
            int idx =  li.get(left).index;
            ans.set(idx , ans.get(idx) + count_lesser_ele_on_right);
            sorted.add(li.get(left));
            left++;            
        }
        while(right<=e){
            sorted.add(li.get(right));            
            right++;
        }
        int i = s;
        for(pair p : sorted){
            li.set(s++ ,  p);
        }                                    
    }
}