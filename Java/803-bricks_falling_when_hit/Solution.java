import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int[] hitBricks2(int[][] grid, int[][] hits) {
        int [] ans = new int[hits.length];
        int m = grid.length;

        if (m <=1 ) {
            return ans;
        }
        int n = grid[0].length;

        for (int[] hit : hits) {
            int x = hit[0];
            int y = hit[1];
            
            if (grid[x][y] == 1) {
                grid[x][y] = -1;
            }
        }

        // now go through first row, dfs mark all connected 1s to 2
        for (int j=0; j<n; j++) {
            if (grid[0][j] == 1) {
                dfsMarkOneToTwoAndCount(grid, 0, j);
            }
        }

        //System.out.println(Arrays.deepToString(grid));
        
        for (int i=hits.length-1; i>=0; i--) {
            int[] hit = hits[i];
            int x = hit[0];
            int y = hit[1];

            if (grid[x][y] == -1) {
                grid[x][y] = 1;
            } else {
                ans[i] = 0;
                continue;
            }

            if (x==0 || (x-1 >=0 && grid[x-1][y]==2) || //up
                    (y+1 < n && grid[x][y+1]==2) || // right
                    (x+1 < m && grid[x+1][y]==2) || // down
                    (y-1 >=0 && grid[x][y-1]==2)) { // left
                ans[i] = dfsMarkOneToTwoAndCount(grid, x, y) - 1;
            } else {
                ans[i] = 0;
            }
        }

        return ans;
    }

    private int dfsMarkOneToTwoAndCount(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = 2;
        
        int up = 0;
        int right = 0;
        int down = 0;
        int left = 0;

        // up
        if (i-1 >=0) {
            up = dfsMarkOneToTwoAndCount(grid, i-1, j);
        }

        // right
        if (j+1 < n) {
            right = dfsMarkOneToTwoAndCount(grid, i, j+1);
        }

        // down
        if (i+1 < m) {
            down = dfsMarkOneToTwoAndCount(grid, i+1, j);
        }

        // left
        if (j-1 >= 0) {
            left = dfsMarkOneToTwoAndCount(grid, i, j-1);
        }

        return 1 + up + right + down + left;
    }
    
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int n = hits.length;
        int[] ans = new int[n];
        
        for (int i=0; i<hits.length; i++) {
            grid[hits[i][0]][hits[i][1]] = 0;
            ans[i] = numBricksDropped(grid);
        }
        
        return ans;
    }

    // BFS 
    private int numBricksDropped(int[][] grid) {
        int m = grid.length;
        
        if (m <= 1) {
            return 0;
        }

        int n = grid[0].length;

        for (int j=0; j<n; j++) {
            if (grid[0][j] == 1) {
                bfsMarkAllCellsConnected(grid, 0, j); // mark all cells connected to 2
            }
        }

        int count = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    count++;
                } else if (grid[i][j] == 2) {
                    grid[i][j] = 1;
                }
            }
        }
        
        return count;
    }
    
    private void bfsMarkAllCellsConnected(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<Cell> q = new LinkedList<>();
        q.offer(new Cell(i, j));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Cell c = q.poll();
            grid[c.x][c.y] = 2;

            // up
            if (c.x - 1 >=0 && grid[c.x-1][c.y] == 1 && !visited[c.x-1][c.y]) {
                q.offer(new Cell(c.x-1, c.y));
                visited[c.x-1][c.y] = true;
            }

            // right
            if (c.y + 1 < n && grid[c.x][c.y+1] == 1 && !visited[c.x][c.y+1]) {
                q.offer(new Cell(c.x, c.y+1));
                visited[c.x][c.y+1] = true;
            }

            // down
            if (c.x + 1 < m && grid[c.x+1][c.y] == 1 && !visited[c.x+1][c.y]) {
                q.offer(new Cell(c.x+1, c.y));
                visited[c.x+1][c.y] = true;
            }

            // left
            if (c.y - 1 >= 0 && grid[c.x][c.y-1] == 1 && !visited[c.x][c.y-1]) {
                q.offer(new Cell(c.x, c.y-1));
                visited[c.x][c.y-1] = true;
            }
        }
    }

    static class Cell {
        int x;
        int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0},
                {0,1,1,1,0,0,1,1,1,0},
                {1,1,1,1,1,1,1,1,1,1,}
        };
        int[][] hits = {
                {0,2},
                {2,4},
                {1,2},
                {0,7}
        };
        int[] ans = sol.hitBricks2(grid, hits);
        System.out.println(Arrays.toString(ans));
    }

}
