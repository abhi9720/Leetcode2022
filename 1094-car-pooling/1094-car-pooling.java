class Solution {

    public boolean carPooling(int[][] trips, int cap) {
       int road[] =  new int[1001];
        for(int trip[] : trips){
            int s =  trip[1] , e = trip[2] ,  nump =  trip[0];;
            road[s]+=nump;
            road[e]-=nump;
        }
        for(int i=0;i<1001;i++){
            cap-=road[i];
            if(cap<0) return false;
        }
        return true;
    }
}
