import java.util.HashMap;
import java.util.HashSet;


public class Solution {

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        HashSet<Character> mapped = new HashSet<Character>();
        
        for (int i=0; i<s.length(); i++) {
            
            char sCur = s.charAt(i);
            char tCur = t.charAt(i);
            char converted;
            
            if (map.containsKey(sCur)) {
                converted = map.get(sCur);
                if (converted != tCur)
                    return false;
            }
            else {
                if (mapped.contains(tCur))
                    return false;
                
                map.put(sCur, tCur);
                mapped.add(tCur);
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String s = "ab";
        String t = "aa";
        
        Solution sol = new Solution();
        
        boolean isIsomorphic = sol.isIsomorphic(s, t);
        System.out.println(isIsomorphic);
    }

}
