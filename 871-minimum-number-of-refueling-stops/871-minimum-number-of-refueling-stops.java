class Solution {
    
    
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        PriorityQueue<Integer> pq =   new PriorityQueue<>(Collections.reverseOrder());
        
        int petrol =  startFuel;;
        int count  = 0,i=0;
        while(petrol < target){
            while(i<stations.length && stations[i][0] <= petrol){                
                pq.add(stations[i][1]);                
                i++;
            }
            if(pq.size()==0 ){
                return -1;
            }
            petrol+=pq.poll();
            count++;
        }
        
      
        return count;
        
        
        
        
        
        
    }
}