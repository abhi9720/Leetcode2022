class LFUCache {
    HashMap<Integer, Integer> keyValMap;
    HashMap<Integer, Integer> keyCountMap;
    HashMap<Integer, LinkedHashSet<Integer>> countListMap;
    int cap;
    int min = -1;

    public LFUCache(int capacity) {
        cap = capacity;
        keyValMap = new HashMap<>();
        keyCountMap = new HashMap<>();
        countListMap = new HashMap<>();
        countListMap.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(!keyValMap.containsKey(key) ) return -1;
		int count =  keyCountMap.get(key);
		countListMap.get(count).remove(key);
		keyCountMap.put(key,count+1);

		// if size after removal this key from countListMap for that count become 0 
		// update min-count
		if(count==min && countListMap.get(count).size()==0){
			// countListMap.remove(count);
			min++;
		}

		countListMap.putIfAbsent(count+1, new LinkedHashSet());
		countListMap.get(count+1).add(key);
		
		return keyValMap.get(key);
    }

    public void put(int key, int value) {
        if(cap<=0) return ;
		// case1 : not present 
		// 		1.1  -  size == capacity , need to do removal and add new {key,val}
		//      1.2  -  size<capacity , simply add new {key,val}
		//  case2 :  present only updation 
		if(keyValMap.containsKey(key) ){ // case 2
			keyValMap.put(key,value);
			get(key);
			return;
		} else if( keyValMap.size() == cap ){ // case  1.1
			int discardKey = countListMap.get(min).iterator().next(); // least frequently used list node
			keyValMap.remove(discardKey);
			countListMap.get(min).remove(discardKey);
		}
		// case 1.1 + 1.2
		keyValMap.put(key,value);
		min  =  1;
		countListMap.get(min).add(key);
		keyCountMap.put(key,1);                
    }
}
