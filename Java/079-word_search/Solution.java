import java.util.ArrayList;
import java.util.List;


public class Solution {

    public boolean exist(char[][] board, String word) {
        
        int m = board.length;
        if (m < 1)
            return false;
        
        int n = board[0].length;
        
        char[] arrWord = word.toCharArray();
        boolean[][] visited = new boolean[m][n];
        
        for (int row=0; row < m; row++) {
            for (int col=0; col < n; col++) {
                if (board[row][col] == arrWord[0]) {
                    boolean found = foundWord(board, row, col, new boolean[m][n], arrWord, 0);
                    if (found)
                        return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean foundWord(
            char[][] board, 
            int row, 
            int col,
            boolean[][] visited,
            char[] arrWord, 
            int i) {
        
        int m = board.length;
        int n = board[0].length;
        
        visited[row][col] = true;
        
        if (i==arrWord.length - 1) {
            return true;
        }
        
        i++;
        
        if (row-1 >=0 && !visited[row-1][col] && board[row-1][col] == arrWord[i]) {
            if (foundWord(board, row-1, col, visited, arrWord, i))
                return true;
        }
        
        if (row + 1 < m && !visited[row+1][col] && board[row+1][col] == arrWord[i]) {
            if (foundWord(board, row+1, col, visited, arrWord, i))
                return true;
        }
        
        if (col-1 >=0 && !visited[row][col-1] && board[row][col-1] == arrWord[i]) {
            if (foundWord(board, row, col-1, visited, arrWord, i))
                return true;
        }
        
        if (col+1 < n && !visited[row][col+1] && board[row][col+1] == arrWord[i]) {
            if (foundWord(board, row, col+1, visited, arrWord, i))
                return true;
        }
        
        visited[row][col] = false;
        return false;
    }
    
    public static void main(String[] args) {
        char[][] board = 
            {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
            };
        
        Solution sol = new Solution();
        boolean exists = sol.exist(board, "SEEP");
        System.out.println(exists);
    }

}
