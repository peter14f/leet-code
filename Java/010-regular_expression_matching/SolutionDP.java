
public class SolutionDP {

    public boolean isMatch(String s, String p) {
        char[] s_arr = s.toCharArray();
        char[] p_arr = p.toCharArray();
        
        boolean[][] dp = new boolean[s_arr.length + 1][p_arr.length + 1];
        
        // empty string matches with empty pattern
        dp[0][0] = true;
        
        // first column - empty pattern => default value is false anyways
        
        // first row - empty string
        for (int j=1; j<=p_arr.length; j++) {
            if (p_arr[j-1] == '*') {
                dp[0][j] = dp[0][j-2];
            }
            // else default value is false anyways
        }
        
        for (int i=1; i<=s_arr.length; i++) {
            for (int j=1; j<=p_arr.length; j++) {
                
                if (p_arr[j-1] != '*') {
                    
                    if (p_arr[j-1] == '.' || s_arr[i-1] == p_arr[j-1]) {
                        dp[i][j] = dp[i-1][j-1];
                    }
                    
                }
                else {
                    if (j-2 >= 0 && (p_arr[j-2] == '.' || s_arr[i-1] == p_arr[j-2])) {
                        boolean matchOne = dp[i-1][j-2];
                        boolean matchMany = dp[i-1][j];
                        
                        dp[i][j] = matchOne || matchMany;
                    }
                    
                    boolean matchNone = dp[i][j-2];
                    dp[i][j] = dp[i][j] || matchNone;
                }                
            }
        }
        
        return dp[s_arr.length][p_arr.length];
    }
    
    public static void main(String[] args) {
        SolutionDP sol = new SolutionDP();
        
        boolean ans = sol.isMatch("aaa", "ab*ac*a");
        System.out.println(ans);
    }

}
