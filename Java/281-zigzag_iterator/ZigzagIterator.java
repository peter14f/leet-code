import java.util.ArrayList;
import java.util.List;


public class ZigzagIterator {

    List<Integer> l1, l2;
    boolean oneNext;
    int i, j;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        l1 = v1;
        l2 = v2;
        oneNext = true;
        i=0;
        j=0;
    }

    public int next() {
        int toReturn = 0;
        if (i < l1.size() && j < l2.size()) {
            if (oneNext) {
                toReturn = l1.get(i);
                i++;
            }
            else {
                toReturn = l2.get(j);
                j++;
            }
            oneNext = !oneNext;
        }
        else if (i < l1.size()) {
            toReturn = l1.get(i);
            i++;
        }
        else if (j < l2.size()) {
            toReturn = l2.get(j);
            j++;
        }
        
        return toReturn;
    }

    public boolean hasNext() {
        return (i < l1.size() || j < l2.size()) ;
    }
    
    public static void main(String[] args) {
        List<Integer> v1 = new ArrayList<Integer>();
        List<Integer> v2 = new ArrayList<Integer>();
        
        v1.add(1);
        v1.add(2);
        
        v2.add(3);
        v2.add(4);
        v2.add(5);
        v2.add(6);
        
        ZigzagIterator iterator = new ZigzagIterator(v1, v2);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
