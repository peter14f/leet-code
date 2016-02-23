
public class SolutionB {

    // state 1 - live
    // state 0 - dead
    // compute the next state (after one update) of the board
    // given its current state
    public void gameOfLife(int[][] board) {
        int m = board.length;
        
        if (m == 0)
            return;
        
        int n = board[0].length;
        
        
        // first pass
        for (int row=0; row<m; row++) {
            for (int col=0; col<n; col++) {
                int liveNeighbors = getLiveNeighbors(board, row, col);
                
                if (board[row][col] == 1) {
                    if (liveNeighbors < 2) {
                        board[row][col] = 3;  // live-to-dead
                    }
                    else if (liveNeighbors > 3) {
                        board[row][col] = 3;  // live-to-dead
                    }
                }
                else {
                    if (liveNeighbors == 3) {
                        board[row][col] = 2; // dead-to-live
                    }
                }
            }
        }
        
        // second pass
        for (int row=0; row<m; row++) {
            for (int col=0; col<n; col++) {
                if (board[row][col] == 3)
                    board[row][col] = 0;
                else if (board[row][col] == 2) {
                    board[row][col] = 1;
                }
            }
        }
    }
    
    private int getLiveNeighbors(int[][] board, int row, int col) {
        int m = board.length;
        int n = board[0].length;
        int cnt = 0;
        
        // top
        if (row - 1 >= 0 && (board[row-1][col] & 1) == 1)
            cnt++;
        
        // top-right
        if (row - 1 >=0 && col + 1 < n && (board[row-1][col+1] & 1) == 1)
            cnt++;
        
        // right
        if (col + 1 < n && (board[row][col+1] & 1) == 1)
            cnt++;
        
        // bottom-right
        if (row + 1 < m && col + 1 < n && (board[row+1][col+1] & 1) == 1)
            cnt++;
        
        // bottom
        if (row + 1 < m && (board[row+1][col] & 1) == 1)
            cnt++;
        
        // bottom-left
        if (row + 1 < m && col - 1 >=0 && (board[row+1][col-1] & 1) == 1)
            cnt++;
        
        // left
        if (col - 1 >= 0 && (board[row][col-1] & 1) == 1)
            cnt++;
        
        // top-left
        if (row - 1 >= 0 && col - 1 >= 0 && (board[row-1][col-1] & 1) == 1)
            cnt++;
        
        return cnt;
    }
    
    public static void main(String[] args) {
        
    }

}
