
public class Solution {

    // state 1 - live
    // state 0 - dead
    // compute the next state (after one update) of the board
    // given its current state
    public void gameOfLife(int[][] board) {
        int m = board.length;
        
        if (m==0)
            return;
        
        int n = board[0].length;
        
        int[][] curState = new int[m][n];
        
        for (int row=0; row<m; row++) {
            for (int col=0; col<n; col++) {
                curState[row][col] = board[row][col];
            }
        }
        
        for (int row=0; row<m; row++) {
            for (int col=0; col<n; col++) {
                int numLiveNeighbors = getNumLiveNeighbors(curState, row, col); 
                        
                if (curState[row][col] == 0) {
                    if (numLiveNeighbors == 3) {
                        board[row][col] = 1;
                    }
                }
                else if (curState[row][col] == 1) {
                    if (numLiveNeighbors < 2) {
                        board[row][col] = 0;
                    }
                    else if (numLiveNeighbors > 3) {
                        board[row][col] = 0;
                    }
                }
            }
        }
    }
    
    private int getNumLiveNeighbors(int[][] board, int row, int col) {
        int cnt = 0;
        int m = board.length;
        int n = board[0].length;
        
        // up
        if (row - 1 >= 0 && board[row-1][col] == 1)
            cnt++;
        
        // up-right
        if (row - 1 >= 0 && col + 1 < n && board[row-1][col+1] == 1)
            cnt++;
        
        // right
        if (col + 1 < n && board[row][col+1] == 1)
            cnt++;
        
        // bottom-right
        if (row + 1 < m && col + 1 < n && board[row+1][col+1] == 1)
            cnt++;
            
        // bottom
        if (row + 1 < m && board[row+1][col] == 1)
            cnt++;
        
        // bottom-left
        if (row + 1 < m && col - 1 >=0 && board[row+1][col-1] == 1)
            cnt++;
        
        // left
        if (col - 1 >= 0 && board[row][col-1] == 1)
            cnt++;
        
        // top-left
        if (row - 1>=0 && col-1 >= 0 && board[row-1][col-1] == 1)
            cnt++;
        
        return cnt;        
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
