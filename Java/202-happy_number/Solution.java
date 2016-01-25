import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Solution {

    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<Integer>();
        
        while (n != 1) {
            if (seen.contains(n))
                return false;
            seen.add(n);
            
            List<Integer> list = new ArrayList<Integer>();
            
            while (n > 0) {
                int d = n % 10;
                list.add(d);
                n = n / 10;
            }
            
            while (!list.isEmpty()) {
                int num = list.remove(0);
                n = n + num*num;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        int num = 18;
        Solution sol = new Solution();
        boolean isHappy = sol.isHappy(num);
        System.out.println(isHappy);
    }

}
