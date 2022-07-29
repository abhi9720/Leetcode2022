class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
     
        int delta = 0;
        int petrol = 0;
        int start = 0;
        for(int i =0 ; i<gas.length;i++){
            delta+= (gas[i] -  cost[i]);
            petrol+= (gas[i] -  cost[i]);
            if(petrol <0){
                petrol = 0;
                start =  i+1;
            }
        }
        return delta<0 ? -1 :  start;
        
    }
}