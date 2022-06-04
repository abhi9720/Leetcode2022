class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set =  new HashSet<>();
        for(int ele : nums){
            set.add(ele);
        }
        int maxlen = 0;
        for(int ele : nums){
            int left =  ele-1;
            while(set.contains(left) ){set.remove(left); left-=1;}
            int right =  ele+1;
            while(set.contains(right) ){set.remove(right); right+=1;}
            int len =  right-left-1;
            maxlen =  Math.max(maxlen,len);            
        }
        return maxlen;
                    
    }
}