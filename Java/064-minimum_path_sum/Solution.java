
public class Solution {

    // m x n grid filled with non-negative numbers
    // no obstacles
    // minimizes the sum along the path
    public int minPathSum(int[][] grid) {
        
        if (grid==null || grid.length < 1) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] sum = new int[m][n];
        
        // first row
        sum[0][0] = grid[0][0];
        for (int col=1; col<n; col++) {
            sum[0][col] = sum[0][col-1] + grid[0][col];
        }
        
        // first col
        for (int row=1; row<m; row++) {
            sum[row][0] = sum[row-1][0] + grid[row][0];
        }
        
        for (int row=1; row<m; row++) {
            for (int col=1; col<n; col++) {
                int fromTop = grid[row][col] + sum[row-1][col];
                int fromLeft = grid[row][col] + sum[row][col-1];
                sum[row][col] = Math.min(fromTop, fromLeft);
            }
        }
        
        return sum[m-1][n-1];
    }
    
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0},
                        {0, 1, 0},
                        {0, 1, 1}};
        Solution sol = new Solution();
        int minSum = sol.minPathSum(grid);
        System.out.println(minSum);
    }

}
