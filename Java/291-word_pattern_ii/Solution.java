import java.util.HashMap;


public class Solution {

    public boolean wordPatternMatch(String pattern, String str) {
        
        return match(pattern, 0, str, 0, 
                new HashMap<Character, String>(), 
                new HashMap<String, Character>());
        
    }
    
    private boolean match(String pattern, int i, 
                          String str, int j,
                          HashMap<Character, String> map1,
                          HashMap<String, Character> map2) {
        
        if (i == pattern.length()) {
            if (j == str.length())
                return true;
            else
                return false;
        }
        
        char c = pattern.charAt(i);
        
        if (map1.containsKey(c)) {
            String s = map1.get(c);
            
            for (int z=0; z<s.length(); z++) {
                
                if (j + z == str.length())
                    return false;
                
                if (str.charAt(j+z) != s.charAt(z))
                    return false;
            }
            
            return match(pattern, i+1, str, j + s.length(), map1, map2);
        }
        else {
            for (int end=j; end < str.length(); end++) {
                String substr = str.substring(j, end+1);
                
                if (map2.containsKey(substr) && map2.get(substr) != c) {
                    // continue looking for longer substrings starting at start
                    continue;
                }
                
                map1.put(c, substr);
                map2.put(substr, c);
                
                if (match(pattern, i+1, str, end+1, map1, map2)) {
                    return true;
                }
                else {
                    map1.remove(c);
                    map2.remove(substr);
                }
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        boolean match = sol.wordPatternMatch("aba", "aaaa");
        System.out.println(match);
    }

}
