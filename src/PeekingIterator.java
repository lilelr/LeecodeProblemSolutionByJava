import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.oldIterator=iterator;
        next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextval;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer ans=nextval;
        if(this.oldIterator.hasNext()){
            nextval=this.oldIterator.next();
            flagNext=true;
        }else{
            flagNext=false;
        }
        return ans;
    }

    @Override
    public boolean hasNext() {
        return  flagNext;
    }

    private boolean flagNext;
    private int nextval;
    private Iterator<Integer> oldIterator;
}