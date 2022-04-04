class FreqStack {

    // map fre to stack
    // map to store freq of element     
    Map<Integer, Stack<Integer> > map1;
    Map<Integer, Integer > map2;
    int maxFreq = 0;
    public FreqStack() {
        map1 = new HashMap<>();
        map2 =  new HashMap<>();        
    }
    
    public void push(int val) {
        map2.put( val, map2.getOrDefault( val , 0 )+1  );
        int freq =  map2.get(val);
        map1.putIfAbsent(freq , new Stack<Integer>() );
        map1.get(freq).add( val );
        maxFreq =  Math.max(maxFreq,freq);                
    }
    
    public int pop() {
        
        int popped = map1.get(maxFreq).pop();
        map2.put( popped, map2.get( popped )-1  );
        if(map2.get(popped)==0 ){
            map2.remove(popped);
        }
        if(map1.get(maxFreq).size()==0){
            map1.remove(maxFreq);
            maxFreq-=1;
        }
        return popped;        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */