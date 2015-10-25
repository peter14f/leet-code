import java.util.ArrayList;
import java.util.List;


public class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<List<String>>();
        char[][] board = new char[n][n];
        for (int row=0; row<n; row++) {
            for (int col=0; col<n; col++) {
                board[row][col] = '.';
            }
        }
        solveNQueens(board, 0, n, ans);
        return ans;
    }
    
    private void solveNQueens(char[][] board, int row, int n, List<List<String>> ans) {
        
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
                List<String> newAns = new ArrayList<String>();
                for (int i=0; i<n; i++) {
                    newAns.add(new String(board[i]));
                }
                ans.add(newAns);
            }
            else {
                solveNQueens(board, row+1, n, ans);
            }
            board[row][col] = '.';
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<String>> ans = sol.solveNQueens(4);
        System.out.println(ans);
    }

}
