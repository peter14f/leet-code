
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int row = m-1;
        int col = 0;
        
        while (true) {
            if (row < 0)
                break;
            if (col >= n)
                break;
            
            int num = matrix[row][col];
            if (num == target) {
                return true;
            }
            else if (num < target) {
                // too small
                col++;
            }
            else {
                // too big
                row--;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4, 5},
                { 6,7 , 8, 9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        
        Solution sol = new Solution();
        
        boolean found = sol.searchMatrix(matrix, 15);
        System.out.println(found);
    }

}
