import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomizedCollection {

    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    Random r;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.r = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean toReturn = false;
        if (!this.map.containsKey(val)) {
            toReturn = true;
        }
        this.list.add(val);

        Set<Integer> indexList = this.map.getOrDefault(val, new HashSet<Integer>());
        indexList.add(this.list.size() - 1);
        this.map.put(val, indexList);

        return toReturn;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!this.map.containsKey(val)) {
            return false;
        }

        int index = this.map.get(val).iterator().next();
        
        swap(index, this.list.size() - 1);
        this.map.get(val).remove(this.list.size() - 1);
        this.list.remove(this.list.size() - 1);

        if (this.map.get(val).isEmpty()) {
            this.map.remove(val);
        }

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int index = this.r.nextInt(this.list.size());
        return this.list.get(index);
    }

    private void swap(int i, int j) {
        if (i==j) return;
        int oldValAtI = this.list.get(i);
        int oldValAtJ = this.list.get(j);
        this.list.set(i, oldValAtJ);
        this.list.set(j, oldValAtI);
        
        this.map.get(oldValAtI).remove(i);
        this.map.get(oldValAtI).add(j);
        
        this.map.get(oldValAtJ).remove(j);
        this.map.get(oldValAtJ).add(i);
    }

    public static void main(String[] args) {

    }

}
