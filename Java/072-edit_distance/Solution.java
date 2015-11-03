
public class Solution {

    /*
     *     X a b c d
     *     0 1 2 3 4
     * X 0 0 1 2 3 4
     * a 1 1 1 
     * d 2 2 
     * 
     * up-left
     *   requires a replace
     * 
     * left one 
     *   requires an insert
     * 
     * up one
     *   requires a delete
     * 
     *   if s1[i] == s2[j] 
     *     op(i, j) = op(i-1, j-1)
     *   else
     *     op(i, j) = min( op(i-1, j), op(i, j-1) ) + 1
     * 
     */
    
    public int minDistance(String word1, String word2) {
        char[] charArr1 = word1.toCharArray();
        char[] charArr2 = word2.toCharArray();
        
        int m = charArr1.length;
        int n = charArr2.length;
        
        int[][] numOps = new int[m+1][n+1];
        
        // word1 being empty
        for (int col=1; col<=n; col++) {
            numOps[0][col] = col;
        }
        
        // word2 being empty
        for (int row=1; row<=m; row++) {
            numOps[row][0] = row;
        }
        
        for (int row=1; row<=m; row++) {
            for (int col=1; col<=n; col++) {
                
                if (charArr1[row-1] == charArr2[col-1]) {
                    numOps[row][col] = numOps[row-1][col-1];
                }
                else {
                    numOps[row][col] = 1 + Math.min(Math.min(numOps[row-1][col], numOps[row][col-1]), 
                                                    numOps[row-1][col-1]);
                }
            }
        }
        
        return numOps[m][n];
    }
    
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "";
        
        Solution sol = new Solution();
        int minDist = sol.minDistance(s1, s2);
        System.out.println(minDist);
    }

}
