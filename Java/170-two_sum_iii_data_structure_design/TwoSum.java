import java.util.HashMap;


public class TwoSum {

    // key is the number added, value is the number of times it has been added
    HashMap<Integer, Integer> cnt;
    
    public TwoSum() {
        cnt = new HashMap<Integer, Integer>();
    }
    
    public void add(int number) {
        if (cnt.containsKey(number))
            cnt.put(number, cnt.get(number)+1);
        else
            cnt.put(number, 1);
    }
    
    public boolean find(int value) {
        for (int num: cnt.keySet()) {
            int d = value - num;
            if (cnt.containsKey(d)) {
                if (num == d) {
                    if (cnt.get(num) > 1) {
                        return true;
                    }
                }
                else {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        TwoSum sol = new TwoSum();
        
        sol.add(3);
        sol.add(9);
        sol.add(5);
        sol.add(3);
        
        boolean found = sol.find(6);
        System.out.println(found);
    }

}
