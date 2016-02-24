import java.util.Arrays;


public class NumMatrixTwo {

    int[][] prefixSum;
    
    public NumMatrixTwo(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        prefixSum = new int[m+1][n+1];
        
        for (int row=1; row<=m; row++) {
            for (int col=1; col<=n; col++) {
                prefixSum[row][col] = prefixSum[row-1][col] + prefixSum[row][col-1] - 
                        prefixSum[row-1][col-1] + matrix[row-1][col-1];
            }
        }
        
        System.out.println(Arrays.deepToString(prefixSum));
    }
    
    public int sumRegion(
            int row1, int col1, 
            int row2, int col2) {
        
        // (row1, col1)   ->   (row2, col2)
        
        
        /*
        System.out.println("plus " + prefixSum[row2+1][col2+1] + 
                           " minus " + prefixSum[row1][col2+1] +
                           " minus " + prefixSum[row2+1][col1] +
                           " plus " + prefixSum[row1][col1]
                         );
        */
        
        return prefixSum[row2+1][col2+1] - prefixSum[row2+1][col1] - 
                prefixSum[row1][col2+1] + prefixSum[row1][col1];
        
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        
        NumMatrixTwo nm = new NumMatrixTwo(matrix);
        int area = nm.sumRegion(2, 1, 4, 3);
        System.out.println(area);
    }

}
