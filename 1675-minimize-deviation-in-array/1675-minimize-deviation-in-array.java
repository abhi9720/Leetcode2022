class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set =  new TreeSet<>();
        for(int ele : nums){
            set.add( ele%2==0?ele:ele*2 );
        }
        
        int minDev =  set.last()-set.first();
        
        while(set.size() >0 && set.last()%2==0  ){
            int last =  set.last();
            //remove it
            set.remove( last );
            set.add( last/2 );
            // take diff 
            minDev =  Math.min( minDev, set.last() - set.first()) ;
            
        }
        
        return minDev;
    }
}