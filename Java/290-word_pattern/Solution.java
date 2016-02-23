import java.util.HashMap;


public class Solution {

    // str contains lowercase letters separated by a single space
    // pattern contains only lowercase letters
    public boolean wordPattern(String pattern, String str) {
        
        HashMap<Character, String> map = new HashMap<Character, String>();
        HashMap<String, Character> reverseMap = new HashMap<String, Character>();
        String[] strs = str.split(" ");
        
        int i=0;
        for (; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            
            if (i >= strs.length)
                return false;
            
            if (map.containsKey(c)) {
                if (!map.get(c).equals(strs[i]))
                    return false;
            }
            else {
                if (!reverseMap.containsKey(strs[i]))
                    reverseMap.put(strs[i], c);
                else if (c != reverseMap.get(strs[i]))
                    return false;
                
                map.put(c, strs[i]);
            }
        }
        
        return i==strs.length;
    }
    
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog p";
        Solution sol = new Solution();
        boolean follows = sol.wordPattern(pattern, s);
        System.out.println(follows);
    }

}
