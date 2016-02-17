
public class SolutionB {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        return search(matrix, 0, m-1, 0, n-1, target);
    }
    
    private boolean search(int[][] matrix, int beginRow, int endRow,
                           int beginCol, int endCol, int target) {
        
        if (beginRow > endRow || beginCol > endCol)
            return false;
        
        int row = beginRow + (endRow - beginRow) / 2;
        int col = beginCol + (endCol - beginCol) / 2;
        
        if (matrix[row][col] == target) {
            return true;
        }
        else if (matrix[row][col] > target) {
            // too big
            return search(matrix, beginRow, row-1, col, endCol, target) ||
                    search(matrix, beginRow, row-1, beginCol, col-1, target) ||
                    search(matrix, row, endRow, beginCol, col-1, target);
        }
        else {
            // too small
            return search(matrix, beginRow, row, col+1, endCol, target) ||
                    search(matrix, row+1, endRow, col+1, endCol, target) ||
                    search(matrix, row+1, endRow, beginCol, col, target);
        }
    }
                           
    public static void main(String[] args) {
        SolutionB sol = new SolutionB();
        int[][] matrix = {
                { 1,  4,  7, 11, 15},
                { 2,  5,  8, 12, 19},
                { 3,  6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean found = sol.searchMatrix(matrix, 16);
        
        System.out.println(found);
    }

}
