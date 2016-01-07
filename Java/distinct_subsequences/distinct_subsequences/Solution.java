package distinct_subsequences;

public class Solution {

    public int numDistinct(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        int m = sArr.length;
        int n = tArr.length;
        
        int[][] numTinS = new int[m+1][n+1];
        
        // first column
        for (int row=0; row<=m; row++) {
            numTinS[row][0] = 1;
        }
        
        for (int row=1; row<=m; row++) {
            for (int col=1; col<=n; col++) {
                if (sArr[row-1] == tArr[col-1])
                    numTinS[row][col] = numTinS[row-1][col-1] + numTinS[row-1][col];
                else
                    numTinS[row][col] = numTinS[row-1][col];
            }
        }
        
        return numTinS[m][n];
    }
    
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        
        Solution sol = new Solution();
        int numTinS = sol.numDistinct(s, t);
        System.out.println(numTinS);
    }

}
