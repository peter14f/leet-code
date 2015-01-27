
public class Solution {
    
    /* isMatch("aa","a") → false
     * isMatch("aa","aa") → true
     * isMatch("aaa","aa") → false
     * isMatch("aa", "a*") → true
     * isMatch("aa", ".*") → true
     * isMatch("ab", ".*") → true
     * isMatch("aab", "c*a*b") → true
     * 
     * isMatch("aaaa", "a*a") → true
     * 
     * in the last example, in order to find that there is a match
     * we must match precisely 3 a's for a*, not 4, 2, 1, or 0.
     * 
     * so we need to attempt all possible ways, 
     * - match 4 a's 
     * - match 3 a's
     * - match 2 a's
     * - match 1 a
     * - match 0 a
     */
    public boolean isMatch(String s, String p) {
        char[] s_arr = s.toCharArray();
        char[] p_arr = p.toCharArray();
        
        return isMatch(s_arr, 0, 
                       p_arr, 0);
    }
    
    private boolean isMatch(char[] s, 
                            int s_index,
                            char[] p,
                            int p_index) {
        
        if (s_index==s.length && p_index==p.length) {
            return true;
        }
        else if (p_index==p.length && s_index < s.length) {
            return false;
        }
        else if (s_index==s.length && p_index < p.length) {
            if (p_index + 1 < p.length &&
                p[p_index+1] == '*') {
                return isMatch(s, s_index, p, p_index+2);
            }
            else {
                return false;
            }
        }
        
        char s_char = s[s_index];
        char p_char = p[p_index];
        
        boolean star = false;
        
        if (p_index + 1 < p.length &&
            p[p_index+1] == '*') {
            star = true;
        }
        
        if (star) {
            if (p_char == '.' || s_char==p_char) {
                // if we match zero p_char
                boolean zeroTime = isMatch(s, s_index, p, p_index+2);
                
                // if we match 1 p_char
                boolean oneTime = isMatch(s, s_index+1, p, p_index);
                
                return zeroTime || oneTime;
            }
            else {
                // match zero p_char
                return isMatch(s, s_index, p, p_index+2);
            }
        }
        else {
            if (s_char==p_char || p_char == '.') {
                return isMatch(s, s_index+1, p, p_index+1);
            }
            else {
                return false;
            }
        }
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        
        System.out.println(s.isMatch("aa", "a"));
        System.out.println(s.isMatch("aa", "aa"));
        System.out.println(s.isMatch("aaa", "aa"));
        System.out.println(s.isMatch("aa", "a*"));
        System.out.println(s.isMatch("aa", ".*"));
        System.out.println(s.isMatch("ab", ".*"));
        System.out.println(s.isMatch("aab", "c*a*b*"));
        System.out.println(s.isMatch("ab", ".*c"));  // TC_361
        System.out.println(s.isMatch("aaa", "a*a")); // TC_391
    }
}
