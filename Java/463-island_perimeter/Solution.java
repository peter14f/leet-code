
public class Solution {

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        if (m < 1) {
            return 0;
        }
        int n = grid[0].length;
        int perimeter = 0;

        // there is exactly one island
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    int numWalls = 0;
                    // up
                    if (i - 1 < 0 || grid[i-1][j] == 0) {
                        numWalls++;
                    }

                    // right
                    if (j + 1 >= n || grid[i][j+1] == 0) {
                        numWalls++;
                    }

                    // down
                    if (i + 1 >= m || grid[i+1][j] == 0) {
                        numWalls++;
                    }

                    // left
                    if (j - 1 < 0 || grid[i][j-1] == 0) {
                        numWalls++;
                    }

                    perimeter += numWalls;
                }
            }
        }

        return perimeter;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = {
                {0,0,0,0},
                {0,1,1,0},
                {0,0,0,0},
                {0,0,0,0}
        };
        int perimeter = sol.islandPerimeter(grid);
        System.out.println(perimeter);
    }

}
