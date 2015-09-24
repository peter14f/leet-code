import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class Solution {

    public static final int SIZE = 9;
    public static final int SUBSIZE = 3;
    
    class Cell {
        int row;
        int col;
        HashSet<Integer> choices;
        
        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
            this.choices = new HashSet<Integer>();
        }
    }
    
    public void solveSudoku(char[][] board) {
        
        Stack<Cell> stk = new Stack<Cell>(); 
        
        for (int row=0; row<SIZE; row++) {
            for (int col=0; col<SIZE; col++) {
                
                
                if (board[row][col] == '.') {
                    Cell c = new Cell(row, col);
                    setPossibleChoices(board, row, col, c);
                    
                    boolean backtracked = false;
                    
                    while (c.choices.isEmpty()) {
                        // need to backtrack
                        if (board[c.row][c.col] != '.') {
                            board[c.row][c.col] = '.';
                        }
                        c = stk.pop(); 
                        backtracked = true;
                    }
                                        
                    int oneChoice = c.choices.iterator().next();
                    int ch = '0' + oneChoice;
                    board[c.row][c.col] = (char)ch;
                    c.choices.remove(oneChoice);
                    stk.push(c);
                    
                    if (backtracked) {
                        row = c.row;
                        col = c.col;
                    }
                }
            }
        }
        
    }
    
    private void setPossibleChoices(char[][] board, int row, int col, Cell cell) {
        
        Set<Integer> choices = new HashSet<Integer>();
        
        for (int i=1; i<=SIZE; i++)
            choices.add(i);
        
        for (int c=0; c<SIZE; c++) {
            if (board[row][c] == '.')
                continue;
            int num = board[row][c] - '0';
            
            if (choices.contains(num)) {
                choices.remove(num);
            }
        }
        
        for (int r=0; r<SIZE; r++) {
            if (board[r][col] == '.')
                continue;
            int num = board[r][col] - '0';
            
            if (choices.contains(num)) {
                choices.remove(num);
            }
        }
        
        int subboardY = row/SUBSIZE; // 0 or 1 or 2
        int subboardX = col/SUBSIZE; // 0 or 1 or 2
        
        int startRow = subboardY * SUBSIZE;
        int startCol = subboardX * SUBSIZE;
        
        for (int y=0; y<SUBSIZE; y++) {
            for (int x=0; x<SUBSIZE; x++) {
                if (board[startRow+y][startCol+x] == '.') {
                    continue;
                }
                int num = board[startRow+y][startCol+x] - '0';
                if (choices.contains(num)) {
                    choices.remove(num);
                }
            }
        }
        
        cell.choices.addAll(choices);
    }
    
    public static void main(String[] args) {
        
        char[][] board = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };
         
        Solution sol = new Solution();
        sol.solveSudoku(board);
        
        System.out.println(Arrays.deepToString(board));
    }

}
