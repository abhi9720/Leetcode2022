// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    
    Iterator<Integer> itr ;
    Integer nextElement;
	public PeekingIterator(Iterator<Integer> iterator) {
	    itr = iterator;
        if(itr.hasNext() ){
            nextElement =  itr.next();
        }
	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return nextElement;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        
            Integer vToreturn =  nextElement;
            nextElement =  itr.hasNext()? itr.next():null;
            return vToreturn;
        	    
	}
	
	@Override
	public boolean hasNext() {
	    return nextElement!=null;
	}
}