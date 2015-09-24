import java.util.HashSet;


public class Solution {

    public static final int SIZE = 9;
    public static final int SUBSIZE = 3;
    
    public boolean isValidSudoku(char[][] board) {
        
        for (int row=0; row<SIZE; row++) {
            if (!rowIsValid(board, row)) {
                return false;
            }
        }
        
        for (int col=0; col<SIZE; col++) {
            if (!colIsValid(board, col)) {
                return false;
            }
        }
        
        for (int row=0; row < SIZE; row+=SUBSIZE) {
            for (int col=0; col < SIZE; col+=SUBSIZE) {
                if (!subboardIsValid(board, row, col)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean subboardIsValid(char[][] board, int startRow, int startCol) {
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int y=0; y<SUBSIZE; y++) {
            for (int x=0; x<SUBSIZE; x++) {
                int row = startRow + y;
                int col = startCol + x;
                
                if (board[row][col] == '.') {
                    continue;
                }
                
                if (board[row][col] < '1' || board[row][col] > '9') {
                    return false;
                }
                
                int num = board[row][col] - '0';
                
                if (set.contains(num)) {
                    return false;
                }
                else {
                    set.add(num);
                }
            }
        }
        
        return true;
    }
    
    private boolean colIsValid(char[][] board, int col) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int row=0; row<SIZE; row++) {
            if (board[row][col] == '.') {
                continue;
            }
            
            if (board[row][col] < '1' || board[row][col] > '9') {
                return false;
            }
            
            int num = board[row][col] - '0';
            
            if (set.contains(num)) {
                return false;
            }
            else {
                set.add(num);
            }
        }
        return true;
    }
    
    private boolean rowIsValid(char[][] board, int row) {
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int col=0; col < SIZE; col++) {
            if (board[row][col] == '.') {
                continue;
            }
            if (board[row][col] < '1' || board[row][col] > '9') {
                return false;
            }
            int num = board[row][col] - '0';
            
            if (set.contains(num)) {
                return false;
            }
            else {
                set.add(num);
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        
    }

}
