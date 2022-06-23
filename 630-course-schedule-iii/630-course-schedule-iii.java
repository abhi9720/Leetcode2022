class Solution {
    public int scheduleCourse(int[][] courses) {
        // try to compelete those courses first which have smaller deadline 
        Arrays.sort(courses , (a,b)-> a[1] - b[1]);
        PriorityQueue<Integer> pqmax  =  new PriorityQueue<>( (a,b)-> b-a );
        int time = 0;
        for(int c [] : courses){
            time+=c[0];
            pqmax.add(c[0]);
            if(time > c[1] ){
                // completing this course will cross will cross deadline 
                // so we will remove the course which have maximum duration 
                // including current course also
                time-=pqmax.poll();                
            }            
        }
        return pqmax.size();
        
        
    }
}