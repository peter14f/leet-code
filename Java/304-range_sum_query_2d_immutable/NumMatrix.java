
public class NumMatrix {

    int[][] prefixSum;
    
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        
        if (m==0)
            return;
        
        int n = matrix[0].length;
        
        prefixSum = new int[m][n];
        
        for (int row=0; row < m; row++) {
            prefixSum[row][0] = matrix[row][0];
            
            for (int col = 1; col < n; col++) {
                prefixSum[row][col] = prefixSum[row][col-1] + matrix[row][col];
            }
        }
        
        
        
        // System.out.println(Arrays.deepToString(prefixSum));
        // System.out.println(prefixSum);
    }

    public int sumRegion(int row1, int col1, 
                         int row2, int col2) {
        //System.out.println(prefixSum);
        
        int sum = 0;
        
        for (int row=row1; row <= row2; row++) {
            if (col1 == 0)
                sum += prefixSum[row][col2];
            else {
                /*
                System.out.println("col1=" + col1 + 
                      " col2=" + col2 + " row1=" + row1 + " row2=" + row2 + " row=" + row);
                System.out.println(Arrays.toString(prefixSum[row]));
                */
                sum += (prefixSum[row][col2] - prefixSum[row][col1-1]);
            }
                
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        
        NumMatrix nm = new NumMatrix(matrix);
        
        int sum = nm.sumRegion(1, 1, 2, 2);
        System.out.println(sum);
    }
}
