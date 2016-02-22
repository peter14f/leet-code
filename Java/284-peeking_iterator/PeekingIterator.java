import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer val;
    
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (this.iterator.hasNext())
            val = iterator.next();
        else
            val = null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return val;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int toReturn = val;
        
        if (this.iterator.hasNext())
            val = iterator.next();
        else
            val = null;
        
        return toReturn;
    }

    @Override
    public boolean hasNext() {
        if (val == null)
            return false;
        else
            return true;
    }
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        
        list.add(1);
        list.add(2);
        list.add(3);
        
        PeekingIterator iter = new PeekingIterator(list.iterator());
        
        System.out.println(iter.peek());
        
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        
        System.out.println(iter.peek());
        
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        
        System.out.println(iter.peek());
        
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        
        System.out.println(iter.hasNext());
    }

}
