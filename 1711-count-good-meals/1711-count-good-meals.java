class Solution {
    int power[] =  new int[21];
    public int countPairs(int[] nums) {
        
        int mod=  1000000007;
        HashMap<Integer,Integer> map =  new HashMap<>();
       
        
        long count = 0;
        for(int ele : nums ){                        
            int power =  1;
            for(int i=0;i<=21;i++){
                if(map.containsKey(power-ele) ){
                    count+=map.get(power-ele);
                    count =  count%mod;
                }
                power*=2;
            }       
            map.put(ele,map.getOrDefault( ele,0 )+1 );
            // by doing this we are avoding duplicay, 1,3 not happen , but 3,1 happend
        }

        return (int)count;
        
    }
    
    private void generatePower(){
        int pow =  1;
        for(int i=0;i<=20;i++){
            power[i] =  pow;
            pow<<=1;
        }       
        
    }
}