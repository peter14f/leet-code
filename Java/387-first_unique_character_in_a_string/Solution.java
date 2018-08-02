import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int firstUniqChar(String s) {
        Map<Character, Integer> histogram = new HashMap<>(); 
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (!histogram.containsKey(c)) {
                histogram.put(c, 1);
            } else {
                histogram.put(c, histogram.get(c) + 1);
            }
        }

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (histogram.get(c) == 1) {
                return i;
            }
        }

        return s.length();
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        Solution sol = new Solution();
        int index = sol.firstUniqChar(s);
        System.out.println(index);
    }

}
