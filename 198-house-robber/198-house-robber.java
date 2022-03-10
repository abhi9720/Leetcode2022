class Solution {
    public int rob(int[] nums) {
        
        // we have two choices either pick or not pick 
        int include =  0;
        int exclude =  0;
        for(int ele : nums){
            int if_include  =  exclude+ele;
            int if_exclude =  Math.max(include,exclude);
            // donot path fa future same h , lekin hum usko lenge  jiska past best accha h
            
            
            include =  if_include;
            exclude =  if_exclude;            
        }
        return Math.max(exclude,include);
    }
}