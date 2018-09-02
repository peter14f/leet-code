import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map; // key is the actual value stored, value is the index in list
    Random r;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.r = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (this.map.containsKey(val)) {
            return false;
        }

        this.list.add(val);
        this.map.put(val, this.list.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!this.map.containsKey(val)) {
            return false;
        }

        swap(this.list.size() - 1, this.map.get(val));
        this.list.remove(this.list.size() - 1);
        this.map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
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

        this.map.put(this.list.get(i), i);
        this.map.put(this.list.get(j), j);
    }

    public static void main(String[] args) {
        
    }

}
