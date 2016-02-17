import java.util.Arrays;


public class Solution {

    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length())
            return false;
        
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        char[] tArr = t.toCharArray();
        Arrays.sort(tArr);
        
        for (int i=0; i<sArr.length; i++) {
            if (sArr[i] != tArr[i])
                return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String s = "rat";
        String t = "tar";
        
        Solution sol = new Solution();
        boolean isAnagram = sol.isAnagram(s, t);
        
        System.out.println(isAnagram);
        
    }

}
