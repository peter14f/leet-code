
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        
        if (m < 1)
            return false;
        
        int n = matrix[0].length;
        
        int low = 0;
        int high = m*n - 1;
        
        while (low <= high) {
            int middle = low + (high-low)/2;
            int num = getMiddleNum(matrix, m, n, middle);
            
            if (num==target) {
                return true;
            }
            else if (num < target) {
                // num too small
                low = middle + 1;
            }
            else {
                // num too big
                high = middle - 1;
            }
        }
        
        return false;
    }
    
    private int getMiddleNum(int[][] matrix, int m, int n, int middle) {
        int row = middle/n;
        int col = middle%n;
        
        return matrix[row][col];
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 3},
                          {4, 5, 6, 7}};
        
        Solution sol = new Solution();
        boolean exist = sol.searchMatrix(matrix, -1);
        System.out.println(exist);
        
    }

}
