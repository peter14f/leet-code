import java.util.Arrays;


public class Solution {
    
    // n x n 2D array
    // since it's n x n, doing it in-place may be possible
    // 1 2 3      7 4 1 
    // 4 5 6  ->  8 5 2
    // 7 8 9      9 6 3
    
    //  1  2  3  4     13   9  5  1    
    //  5  6  7  8     14  10  6  2
    //  9 10 11 12  -> 15  11  7  3
    // 13 14 15 16     16  12  8  4
    
    // 1 4 7   7 4 1
    // 2 5 8   8 5 2
    // 3 6 9   9 6 3
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        
        // swap along the diagonal first
        for (int row=0; row < matrix.length; row++) {
            for (int distFromDiag = 1; row + distFromDiag < n; distFromDiag++) {
                int temp = matrix[row][row+distFromDiag];
                matrix[row][row+distFromDiag] = matrix[row+distFromDiag][row];
                matrix[row+distFromDiag][row] = temp;
            }
        }
        
        // and then swap along the center vertical line
        
        // find the middle column
        int l, r;
        if (n % 2 == 0) {
            // even n
            r = n / 2;
            l = r - 1;
        }
        else {
            // odd n
            l = (n/2) - 1;
            r = (n/2) + 1;
        }
        
        while (l >= 0) {
            for (int row=0; row<n; row++) {
                int temp = matrix[row][r];
                matrix[row][r] = matrix[row][l];
                matrix[row][l] = temp;
            }
            l--;
            r++;
        }
    }
    
    public static void main(String[] args) {
        
        int[][] matrix = {{1, 2, 3},  // 3 1
                          {4, 5, 6},
                          {7, 8, 9}}; // 4 2
        
        Solution sol = new Solution();
        sol.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
        
    }

}
