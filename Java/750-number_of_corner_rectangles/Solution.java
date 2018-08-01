
public class Solution {

    // O(1) space
    // O(n^2 m^2) time
    public int countCornerRectangles(int[][] grid) {
        int count = 0;

        int m = grid.length;
        if (m <= 1) {
            return count;
        }

        int n = grid[0].length;
        if (n <= 1) {
            return count;
        }

        // (i, j) defines the top-left corner of the rectangle
        for (int i=0; i<m-1; i++) {
            for (int j=0; j<n-1; j++) {
                if (grid[i][j] == 1) {
                    
                    // (i, jNext) defines the top-right corner of the rectangle
                    for (int jNext=j+1; jNext<n; jNext++) {
                        if (grid[i][jNext] == 1) {

                            // (iNext, jNext) defines the bottom-right corner of the rectangle
                            for (int iNext=i+1; iNext<m; iNext++) {
                                if (grid[iNext][jNext] == 1 && grid[iNext][j] == 1) {
                                    count++;
                                }
                            }

                        }
                    }
                }
            }
        }

        return count;
    }

    // O(n^2) space
    // O(mn^2) time
    public int countCornerRectangles2(int[][] grid) {

        int count = 0;

        int m = grid.length;

        if (m <= 1) {
            return count;
        }

        int n = grid[0].length;
        if (n <= 1) {
            return count;
        }

        // numPrevRows[a][b] tells us the number of rows up to this point 
        // there are with both column a and column b being 1
        int[][] numPrevRows = new int[n][n];

        // first row
        for (int j=0; j<n; j++) {
            if (grid[0][j] == 1) {

                for (int jNext=j+1; jNext<n; jNext++) {
                    if (grid[0][jNext] == 1) {
                        numPrevRows[j][jNext] = 1;
                    }
                }

            }
        }

        for (int i=1; i<m; i++) { // scan bottom rows
            for (int j=0; j<n-1; j++) { // j is the left edge

                if (grid[i][j] == 1) {
                    for (int jNext=j+1; jNext<n; jNext++) {
                        if (grid[i][jNext] == 1) { // jNext is the right edge

                            count += numPrevRows[j][jNext]; // how many rows before row i have both column j and column jNext both being 1
                            numPrevRows[j][jNext]++; // increment by 1 because need to count row i
                        }
                    }
                }

            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1}
        };

        int[][] grid2 = {
                {1,1,1},
                {1,1,1},
                {1,1,1}
        };

        Solution sol = new Solution();
        int count = sol.countCornerRectangles2(grid2);
        System.out.println(count);
    }

}
