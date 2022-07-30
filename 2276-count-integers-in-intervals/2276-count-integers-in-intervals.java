class CountIntervals {

    TreeMap<Integer,Integer> map;
    int counter = 0;
    public CountIntervals() {
        counter =0;
        map =  new TreeMap<>();
    }
    
    public void add(int left, int right) {
        if(map.floorKey(right) ==null || map.get(map.floorKey(right)) < left ){
            map.put(left,right);
            counter+= right-left+1;
        }
        else{
            int start =  left, end =  right;
            while(true){
                int l =  map.floorKey(end);
                int r =  map.get(l);
                start =  Math.min(l,start);
                end =  Math.max(r,end);
                counter -= (r-l+1);
                map.remove(l);
                if(map.floorKey(end) ==null || map.get(map.floorKey(end)) < start ){
                    break;
                }
            }
            counter+=(end-start+1);
            map.put(start,end);
        }
        
    }
    
    public int count() {
        return counter;
    }
    
    
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */