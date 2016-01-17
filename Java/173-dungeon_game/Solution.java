import java.util.Arrays;


public class Solution {

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        int[][] minLife = new int[m][n]; 
        
        if (dungeon[m-1][n-1] < 0)
            minLife[m-1][n-1] = 1 + Math.abs(dungeon[m-1][n-1]);
        else
            minLife[m-1][n-1] = 1;
        
        // last row
        for (int col=n-2; col>=0; col--) {
            if (dungeon[m-1][col] < 0)
                minLife[m-1][col] = minLife[m-1][col+1] + Math.abs(dungeon[m-1][col]);
            else if (dungeon[m-1][col] >= minLife[m-1][col+1])
                minLife[m-1][col] = 1;
            else
                minLife[m-1][col] = minLife[m-1][col+1] - dungeon[m-1][col];
        }
        
        // last col
        for (int row=m-2; row>=0; row--) {
            if (dungeon[row][n-1] < 0)
                minLife[row][n-1] = minLife[row+1][n-1] + Math.abs(dungeon[row][n-1]);
            else if (dungeon[row][n-1] >= minLife[row+1][n-1] )
                minLife[row][n-1] = 1;
            else
                minLife[row][n-1] = minLife[row+1][n-1] - dungeon[row][n-1];
        }
        
        for (int row=m-2; row>=0; row--) {
            for (int col=n-2; col>=0; col--) {
                if (dungeon[row][col] < 0)
                    minLife[row][col] = Math.min(minLife[row+1][col], minLife[row][col+1]) +
                    Math.abs(dungeon[row][col]);
                else if (dungeon[row][col] >= Math.min(minLife[row+1][col], minLife[row][col+1]))
                    minLife[row][col] = 1;
                else
                    minLife[row][col] = Math.min(minLife[row+1][col], minLife[row][col+1]) - dungeon[row][col]; 
            }
        }
        
        return minLife[0][0];
    }
    
    public static void main(String[] args) {
        
        int[][] board = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        /*
        int[][] board = {
                {3, -20, 30},
                {-3, 4, 0}
        };*/
        
        Solution sol = new Solution();
        int minLife = sol.calculateMinimumHP(board);
        System.out.println(minLife);
    }

}
