class Solution {
    public int numRabbits(int[] answers) {
        int map[] =  new int[1000];
        for(int ele : answers){
            map[ele]+=1;
        }
        int rabbit =  0;
        // for(int key : map.keySet()){
        //     int grp =  key+1;
        //     int c  = map.get(key);
            // int count = (int) Math.ceil( (c*1.0)/grp ) * grp;
            // rabbit+= count;
        // }
        
        for(int i=0;i<1000;i++){
            int grp  = i+1;
            int c =  map[i];
            int count = (int) Math.ceil( (c*1.0)/grp ) * grp;
            rabbit+= count;            
        }
        return rabbit;
    }
}