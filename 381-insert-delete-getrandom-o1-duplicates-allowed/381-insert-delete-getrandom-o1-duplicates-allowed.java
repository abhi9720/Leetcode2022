class RandomizedCollection {
    
    ArrayList<Integer> list;
    HashMap<Integer,HashSet<Integer>> map;
    Random rand ;
    public RandomizedCollection() {
        list =  new ArrayList<>();
        map =  new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        
        map.putIfAbsent( val , new HashSet<>() );
        map.get(val).add(list.size() );
        list.add(val);
        return map.get(val).size()==1;
    }
    
    public boolean remove(int val) {
        
        // we need to remove val
        if(!map.containsKey( val  ) ) return false;
        
        int idxToRemove =  map.get(val).iterator().next();
        // System.out.println("idxToRemove : "+idxToRemove);
        
        map.get(val).remove(idxToRemove);
        if(map.get(val).size()==0 ){
            map.remove(val);
        }        
        
        
        int lastIndex =  list.size()-1;
        if(lastIndex != idxToRemove){
            int lastEle =   list.get(lastIndex) ;            
            map.get(lastEle).add(idxToRemove);
            map.get(lastEle).remove(lastIndex );;                
            list.set( idxToRemove , lastEle );
        }
        list.remove(list.size()-1 );
        
        
        
        return true;
        
    }
    
    public int getRandom() {
        return list.get( rand.nextInt( list.size() ) ) ;        
    }
}
