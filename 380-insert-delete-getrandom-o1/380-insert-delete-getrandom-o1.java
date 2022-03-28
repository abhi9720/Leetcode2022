class RandomizedSet {

    ArrayList<Integer> valueList;
    HashMap<Integer,Integer> map;
    Random rand = null;
    public RandomizedSet() {
        valueList =  new ArrayList<>();
        map =  new HashMap<>();
         rand = new Random();
    }
    
    public boolean insert(int val) {
        
        boolean present =  map.containsKey(val);
        if(present) return false;
        valueList.add(val);
        map.put(val, valueList.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        int idx =  map.getOrDefault(val,-1);
        if(idx==-1) return false;
        
        int lidx =  valueList.size()-1;
        
        
        map.put( valueList.get(lidx) , idx );
        valueList.set(idx , valueList.get(lidx));
        
        map.remove( val );
        valueList.remove(lidx);
        return true;
    }
    
    public int getRandom() {
        
        return valueList.get( rand.nextInt(valueList.size()) );
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */