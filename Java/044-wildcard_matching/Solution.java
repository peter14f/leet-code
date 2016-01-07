
public class Solution {

    // '?' Matches any single character.
    // '*' Matches any sequence of characters (including the empty sequence).
    
    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);
    }
    
    // TC LONG
    //"abbaabbbbababaababababbabbbaaaabbbbaaabbbabaabbbbbabbbbabbabbaaabaaaabbbbbbaaabbabbbbababbbaaabbabbabb"
    //"***b**a*a*b***b*a*b*bbb**baa*bba**b**bb***b*a*aab*a**"
    private boolean isMatch(char[] s_arr, int i, char[] p_arr, int j) {
        
        if (j >= p_arr.length) {
            if (i >= s_arr.length)
                return true;
            else
                return false;
        }
        
        char p = p_arr[j];
        
        boolean zeroOrMore = false;
        
        if (p=='*') {
            zeroOrMore = true;
            
            
        }
        
        if (!zeroOrMore) {
            if (i>=s_arr.length)
                return false;
            
            if (p == '?' || p == s_arr[i]) {
                return isMatch(s_arr, i+1, p_arr, j+1);
            }
            else {
                return false;
            }
        }
        else {
            boolean matchNone = isMatch(s_arr, i, p_arr, j+1);
            boolean matchOne = false;
            
            if (!matchNone) {
                
                if (i+1 >= s_arr.length)
                    matchOne = false;
                else
                    matchOne = isMatch(s_arr, i+1, p_arr, j);
            }
            
            return matchNone || matchOne;
        }
        
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        boolean ans = sol.isMatch(
                "abbaabbbbababaababababbabbbaaaabbbbaaabbbabaabbbbbabbbbabbabbaaabaaaabbbbbbaaabbabbbbababbbaaabbabbabb", 
                "*b*a*a*b*b*a*b*bbb*baa*bba*b*bb*b*a*aab*a*");
        
        System.out.println(ans);
    }

}
