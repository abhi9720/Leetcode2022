class MedianFinder {

    PriorityQueue<Integer> min , max;
    
    public MedianFinder() {
        min =  new PriorityQueue<Integer>();
        max =  new PriorityQueue<Integer>(Collections.reverseOrder() );        
    }
    
    public void addNum(int num) {
        max.add(num);
        if( max.size() -  min.size() >1 ){
            min.add(max.poll() );
        }
        else if(min.size()!=0 && max.peek() > min.peek() ){
            int t1 =  max.poll();
            int t2  =  min.poll();
            max.add(t2);
            min.add(t1);            
        }
        
    }
    
    public double findMedian() {
        
        if( (max.size() + min.size() ) % 2==0  ){
            double avg =  (max.peek() + min.peek() )/2.0;
            return avg ;
        }
        else{
            return 1.0*max.peek();
        }
    }
}

