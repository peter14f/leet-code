
public class Solution {

    public int longestIncreasingPath(int[][] matrix) {
        
        int[] ans = {0};
        
        int m = matrix.length;
        
        if (m == 0)
            return 0;
        
        int n = matrix[0].length;
        
        for (int row=0; row<m; row++) {
            for (int col=0; col<n; col++) {
                dfs(matrix, row, col, -1, -1, 1, ans);
            }
        }
        
        return ans[0];
    }
    
    private void dfs(int[][] matrix, int row, int col, int prevRow, int prevCol, 
                     int curLen, int[] ans) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean deadEnd = true;
        
        // up
        if (row-1 >=0 && (prevRow != row-1 || prevCol != col) && 
                matrix[row-1][col] > matrix[row][col]) {
            
            deadEnd = false;
            dfs(matrix, row-1, col, row, col, curLen+1, ans);
        }
        
        // down
        if (row+1 < m && (prevRow != row+1 || prevCol != col) &&
                matrix[row+1][col] > matrix[row][col]) {
            
            if (deadEnd)
                deadEnd = false;
            dfs(matrix, row+1, col, row, col, curLen+1, ans);
        }
        
        // left
        if (col-1 >= 0 && (prevRow != row || prevCol != col-1) &&
                matrix[row][col-1] > matrix[row][col]) {
            
            if (deadEnd)
                deadEnd = false;
            
            dfs(matrix, row, col-1, row, col, curLen+1, ans);
        }
        
        
        // right
        if (col+1 < n && (prevRow != row || prevCol != col+1) &&
                matrix[row][col+1] > matrix[row][col]) {
            
            if (deadEnd)
                deadEnd = false;
            
            dfs(matrix, row, col+1, row, col, curLen+1, ans);
        }
        
        if (deadEnd && curLen > ans[0]) {
            ans[0] = curLen;
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        
        int len = sol.longestIncreasingPath(matrix);
        
        System.out.println(len);
    }

}
