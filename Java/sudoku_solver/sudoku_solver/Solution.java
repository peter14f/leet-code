package sudoku_solver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Solution {

    public static final int SIZE = 9;
    public static final int SUBSIZE = 3;
    
    class Cell {
        int row;
        int col;
        HashSet<Character> numbers;
        
        public Cell(int row, int col, char[][] board) {
            this.row = row;
            this.col = col;
            
            numbers = new HashSet<Character>();
            for (int i=1; i<=SIZE; i++) {
                numbers.add((char) ('0' + i));
            }
            
            // numbers already in the row
            for (int i=0; i<SIZE; i++) {
                if (numbers.contains(board[row][i])) {
                    numbers.remove(board[row][i]);
                }
            }
            
            // numbers already in the column
            for (int i=0; i<SIZE; i++) {
                if (numbers.contains(board[i][col])) {
                    numbers.remove(board[i][col]);
                }
            }
            
            // numbers already in the subboard
            int subboardRow = (row/SUBSIZE)*SUBSIZE;
            int subboardCol = (col/SUBSIZE)*SUBSIZE;
            
            for (int i=0; i<SUBSIZE; i++) {
                for (int j=0; j<SUBSIZE; j++) {
                    if (numbers.contains(board[subboardRow+i][subboardCol+j])) {
                        numbers.remove(board[subboardRow+i][subboardCol+j]);
                    }
                }
            }
        }
    }
    
    public void solveSudoku(char[][] board) {
        
        Stack<Cell> stk = new Stack<Cell>();
        
        // find blank cells
        for (int row=0; row<SIZE; row++) {
            for (int col=0; col<SIZE; col++) {
                if (board[row][col] == '.') {
                    Cell cell = new Cell(row, col, board);
                    
                    if (cell.numbers.isEmpty()) {
                        // time to backtrack
                        do {
                            if (stk.isEmpty())
                                throw new IllegalArgumentException("board cannot be solved");
                            
                            cell = stk.pop();
                            board[cell.row][cell.col] = '.';
                            
                        } while (cell.numbers.isEmpty());
                        
                        row = cell.row;
                        col = cell.col;
                    }
                    
                    char choice = cell.numbers.iterator().next();
                    board[row][col] = choice;
                    cell.numbers.remove(choice);
                    stk.push(cell);
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        char[][] board = 
            {{'5', '3', '4', '6', '7', '8', '9', '1', '.'},
             {'6', '7', '2', '1', '9', '5', '3', '4', '.'},
             {'1', '9', '8', '3', '4', '2', '5', '6', '.'},
             {'8', '5', '9', '7', '6', '1', '4', '2', '.'},
             {'4', '2', '6', '8', '5', '3', '7', '9', '.'},
             {'7', '1', '3', '9', '2', '4', '8', '5', '.'},
             {'9', '6', '1', '5', '3', '7', '2', '8', '.'},
             {'2', '8', '7', '4', '.', '.', '.', '.', '.'},
             {'3', '4', '5', '2', '.', '.', '.', '.', '.'}};
        
        Solution sol = new Solution();
        sol.solveSudoku(board);
        
        System.out.println(Arrays.deepToString(board));
    }

}
