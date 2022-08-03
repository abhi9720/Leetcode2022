class MyCalendar {
    TreeMap<Integer,Integer> map ;
    public MyCalendar() {
        map =  new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        end--;
        if(  map.floorKey(end) !=null  && map.get(map.floorKey(end)) >= start ){
            return false;
        }
        else{
            map.put(start,end);
            return true;
        }
    }
}
