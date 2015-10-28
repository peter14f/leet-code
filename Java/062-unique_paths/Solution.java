
public class Solution {

    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            throw new IllegalArgumentException();
        }
        
        int[][] board = new int[m][n];
        
        // first column
        for (int row=0; row < m; row++) {
            board[row][0] = 1;
        }
        
        // first row
        for (int col=0; col < n; col++) {
            board[0][col] = 1;
        }
        
        for (int row=1; row<m; row++) {
            for (int col=1; col<n; col++) {
                board[row][col] = board[row-1][col] + board[row][col-1];
            }
        }
        
        return board[m-1][n-1];
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = sol.uniquePaths(2, 2);
        System.out.println(ans);
    }

}
