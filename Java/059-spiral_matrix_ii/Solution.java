import java.util.Arrays;


public class Solution {

    public static final int RIGHT = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int UP = 3;
    
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        
        int i=1;
        int total = n*n;
        int direction = RIGHT;
        int wall = 0;
        int row = 0;
        int col = 0;
                
        while (i<=total) {
            matrix[row][col] = i;
            
            switch (direction) {
                case RIGHT:
                    if (col == n - 1 - wall) {
                        direction = DOWN;
                        row++;
                    }
                    else {
                        col++;
                    }
                    break;
                case DOWN:
                    if (row == n - 1 - wall) {
                        direction = LEFT;
                        col--;
                    }
                    else {
                        row++;
                    }
                    break;
                case LEFT:
                    if (col == wall) {
                        direction = UP;
                        wall++;
                        row--;
                    }
                    else {
                        col--;
                    }
                    break;
                case UP:
                    if (row == wall) {
                        direction = RIGHT;
                        col++;
                    }
                    else {
                        row--;
                    }
                    break;
            }
            i++;
        }
        
        return matrix;
    }
    
    public static void main(String[] args) {
        
        Solution sol = new Solution();
        int[][] matrix = sol.generateMatrix(3);
        System.out.println(Arrays.deepToString(matrix));
        
    }

}
