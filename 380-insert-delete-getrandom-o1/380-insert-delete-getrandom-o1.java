class RandomizedSet {

    ArrayList<Integer> list= null;
    Map<Integer,Integer> valToIndex = null;
    Random  rand =  null;
    public RandomizedSet() {
        list =  new ArrayList<>();
        valToIndex =  new HashMap<>();
        rand =  new Random();
        
    }
    
    public boolean insert(int val) {
        if(valToIndex.containsKey( val ) ) return false;
        list.add(val);
        valToIndex.put(val , list.size()-1 );        
        return true;
    }
    
    public boolean remove(int val) {
        int idx  =  valToIndex.getOrDefault(val,-1);
        if(idx==-1) return false;
        
        int lastIdx =  list.size()-1;
        list.set( idx , list.get(lastIdx) );// swapping done 
        
        valToIndex.put( list.get(lastIdx) , idx );
        list.remove(lastIdx);
        valToIndex.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get( rand.nextInt( list.size() )  ) ;
    }
}
