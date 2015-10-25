import java.util.ArrayList;
import java.util.List;


public class Solution {

    public static final int RIGHT = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int UP = 3;
    
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> ans = new ArrayList<Integer>();
        
        if (matrix==null || matrix.length == 0)
            return ans;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int cnt = m*n;
        
        int row=0;
        int col=0;
        int wall=0;
        int direction = RIGHT;
        
        while (ans.size() < cnt) {
            ans.add(matrix[row][col]);
            
            switch (direction) {
                case RIGHT:
                    if (col == n-1-wall) {
                        direction = DOWN;
                        row++;
                    }
                    else {
                        col++;
                    }
                    break;
                case DOWN:
                    if (row == m-1-wall) {
                        direction = LEFT;
                        col--;
                    }
                    else {
                        row++;
                    }
                    break;
                case LEFT:
                    if (col==wall) {
                        direction = UP;
                        row--;
                        wall++;
                    }
                    else {        
                        col--;
                    }
                    break;
                case UP:
                    if (row==wall) {
                        direction = RIGHT;
                        col++;
                    }
                    else {
                        row--;
                    }
                    break;
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        
        Solution sol = new Solution();
        List<Integer> ans = sol.spiralOrder(nums);
        System.out.println(ans);
    }

}
