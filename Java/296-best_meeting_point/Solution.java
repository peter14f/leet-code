import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Solution {

    public int minTotalDistance(int[][] grid) {
        
        int m = grid.length;
        
        if (m==0)
            return 0;
        
        int n = grid[0].length;
        
        List<Integer> rowIndex = new ArrayList<Integer>();
        List<Integer> colIndex = new ArrayList<Integer>();
        
        for (int row=0; row<m; row++) {
            for (int col=0; col<n; col++) {
                if (grid[row][col] == 1) {
                    rowIndex.add(row);
                    colIndex.add(col);
                }
            }
        }
        
        // note the rowIndex is already sorted
        Collections.sort(colIndex);
        
        int xMid = colIndex.get(colIndex.size()/2);
        int yMid = rowIndex.get(rowIndex.size()/2);
        
        int sum = 0;
        
        for (int row=0; row<m; row++) {
            for (int col=0; col<n; col++) {
                if (grid[row][col] == 1) {
                    sum += Math.abs(row - yMid);
                    sum += Math.abs(col - xMid);
                }
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 0, 1}, 
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };
        
        Solution sol = new Solution();
        int totalDistance = sol.minTotalDistance(grid);
        System.out.println(totalDistance);
    }

}
