class Solution {
    public int numRabbits(int[] answers) {
        int count = 0;
        Map<Integer,Integer> map =  new HashMap<>();
        for(int i=0;i<answers.length;i++){
            int ele  =  answers[i];
            if(!map.containsKey(ele) ){
                map.put(ele, ele);
                count+=(ele+1);
            }
            else{
                if(map.get(ele) >0 ){
                    map.put(ele,map.get(ele)-1 );
                }
                else{
                    count+=(ele+1);
                    map.put(ele , ele);
                }
            }            
        }
        
        return count;
        
    }
}























