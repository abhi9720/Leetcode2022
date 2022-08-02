// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Integer nextEle = null;
    Iterator<Integer> itr;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.itr = iterator;
        if (itr.hasNext()) {
            nextEle = itr.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextEle;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int rv = nextEle;
        nextEle = null;
        if (itr.hasNext()) nextEle = itr.next();
        return rv;
    }

    @Override
    public boolean hasNext() {
        return nextEle != null;
    }
}
