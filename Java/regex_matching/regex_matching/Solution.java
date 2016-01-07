package regex_matching;

public class Solution {

    public boolean isMatch(String s, String p) {
        
        char[] charArrS = s.toCharArray();
        char[] charArrP = p.toCharArray();
        
        int sLen = charArrS.length;
        int pLen = charArrP.length;
        
        /* '.' matches any character
         * '*' matches zero or more of the preceding element
         */
        
        boolean[][] isMatch = new boolean[sLen+1][pLen+1];
        
        // empty string matches empty pattern
        isMatch[0][0] = true;
        
        // 1st row: empty string 
        for (int col=1; col<=pLen; col++) {
            if (charArrP[col-1] == '*') {
                isMatch[0][col] = isMatch[0][col-2];
            }
            else {
                isMatch[0][col] = false;
            }
        }
        
        // 1st column: non-empty string cannot match with any empty pattern
        for (int row=1; row<=sLen; row++) {
            isMatch[row][0] = false;
        }
        
        /*      X c * a * b
         *      0 1 2 3 4 5
         *  X 0 T F T F T F
         *  a 1 F F F T T F
         *  a 2 F F F F T F
         *  b 3 F F F F F T
         *  
         *      X . *
         *      0 1 2
         *  X 0 T F T
         *  a 1 F T T
         *  a 2 F F   
         */
        
        for (int row=1; row<=sLen; row++) {
            for (int col=1; col<=pLen; col++) {
                
                char pattern = charArrP[col-1];
                char cur = charArrS[row-1];
                
                if (pattern == '*') {
                    char prevP = charArrP[col-2]; 
                    boolean matchOneTime = false;
                    boolean matchMany = false;
                    
                    if (prevP == '.' || prevP == cur) {
                        matchOneTime = isMatch[row][col-1];
                        if (col - 1 > 0) {
                            matchMany = isMatch[row-1][col];
                        }
                    }
                    
                    // match 0 time
                    boolean matchZeroTime = isMatch[row][col-2];
                    
                    isMatch[row][col] = matchZeroTime || matchOneTime || matchMany; 
                }
                else if (pattern == '.' || pattern == cur) {
                    isMatch[row][col] = isMatch[row-1][col-1];
                }
                // default value if false anyways
                
            }
        }
        
        return isMatch[sLen][pLen];
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean ans = sol.isMatch("aaaa", "a*a");
        System.out.println(ans);
    }

}
