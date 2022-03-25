class Solution {
    public int twoCitySchedCost(int[][] costs) {
          Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });
        
        int i=0 , cost  = 0, n =  costs.length;
        for(int []c : costs){
            
            if(i<n/2){
                cost+=c[0];
                // System.out.println("cost : "+cost+" "+c[0])
            }else{
             cost+=c[1];
            }
            i++;
        }
        return cost;
    }
}