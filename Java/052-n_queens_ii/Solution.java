import java.util.ArrayList;
import java.util.List;


public class Solution {

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        int[] ans = {0};
        for (int row=0; row<n; row++) {
            for (int col=0; col<n; col++) {
                board[row][col] = '.';
            }
        }
        solveNQueens(board, 0, n, ans);
        return ans[0];
    }
    
    private void solveNQueens(char[][] board, int row, int n, int[] ans) {
        
        for (int col=0; col<n; col++) {
            boolean allPassed = true;
            
            // check previous rows in the same column
            for (int r=row-1; r>=0; r--) {
                if (board[r][col] == 'Q') {
                    allPassed = false;
                    break;
                }
            }
            
            if (!allPassed)
                continue;
            
            // check previous rows along the diagonal
            int dist = 1;
            for (int r=row-1; r>=0; r--) {
                if (col-dist < 0)
                    break;
                if (board[r][col-dist] == 'Q') {
                    allPassed = false;
                    break;
                }
                dist++;
            }
            
            if (!allPassed)
                continue;
            
            // check previous rows along the reverse diagonal
            dist = 1;
            for (int r=row-1; r>=0; r--) {
                if (col+dist >= n)
                    break;
                if (board[r][col+dist] == 'Q') {
                    allPassed = false;
                    break;
                }
                dist++;
            }
            
            if (!allPassed)
                continue;
            
            board[row][col] = 'Q';
            
            if (row == n - 1) {
                ans[0]++;
            }
            else {
                solveNQueens(board, row+1, n, ans);
            }
            board[row][col] = '.';
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = sol.totalNQueens(4);
        System.out.println(ans);
    }
}
