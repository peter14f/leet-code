import java.util.Arrays;

public class Solution {

    public void setZeroes(int[][] matrix) {
        
        int m = matrix.length;
        
        if (m<1) {
            return;
        }
        int n = matrix[0].length;
        
        boolean zeroOutFirstRow = false;
        for (int col=0; col<n; col++) {
            if (matrix[0][col]==0) {
                zeroOutFirstRow = true;
                break;
            }
        }
        
        boolean zeroOutFirstCol = false;
        for (int row=0; row<m; row++) {
            if (matrix[row][0] == 0) {
                zeroOutFirstCol = true;
                break;
            }
        }
        
        for (int row=1; row<m; row++) {
            for (int col=1; col<n; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
        
        // check first row
        for (int col=1; col<n; col++) {
            if (matrix[0][col] == 0) {
                // zero out the column
                for (int row=1; row<m; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
        
        // check first column
        for (int row=1; row<m; row++) {
            if (matrix[row][0] == 0) {
                // zero out the row
                for (int col=1; col<n; col++) {
                    matrix[row][col] = 0;
                }
            }
        }
        
        if (zeroOutFirstCol) {
            for (int row=0; row<m; row++) {
                matrix[row][0] = 0;
            }
        }
        
        if (zeroOutFirstRow) {
            for (int col=0; col<n; col++) {
                matrix[0][col] = 0;
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{9, 0, 2},
                          {3, -1, 5},
                          {6, 7, 8}};
        
        Solution sol = new Solution();
        sol.setZeroes(matrix);
        
        System.out.println(Arrays.deepToString(matrix));
    }

}
