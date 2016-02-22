import java.util.ArrayList;
import java.util.List;


public class ZigzagIteratorK {

    List<List<Integer>> lists;
    int nextList;
    int[] pointers;
    
    public ZigzagIteratorK(List<List<Integer>> lists) {
        this.lists = lists;
        nextList = 0;
        pointers = new int[lists.size()];
    }
    
    public boolean hasNext() {
        for (int i=0; i<pointers.length; i++) {
            if (pointers[i] < lists.get(i).size())
                return true;
        }
        return false;
    }
    
    public int next() {
        int n = lists.size();
        
        while (pointers[nextList%n] >= lists.get(nextList%n).size()) {
            nextList++;
        }
        
        int toReturn =  lists.get(nextList%n).get(pointers[nextList%n]);
        pointers[nextList%n]++;
        nextList++;
        
        return toReturn;
    }
    
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        List<Integer> l3 = new ArrayList<Integer>();
        
        l1.add(1);
        l1.add(2);
        l1.add(3);
        
        l2.add(4);
        l2.add(5);
        l2.add(6);
        l2.add(7);
        
        l3.add(8);
        l3.add(9);
        
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        ZigzagIteratorK iter = new ZigzagIteratorK(lists);
        
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        
    }

}
