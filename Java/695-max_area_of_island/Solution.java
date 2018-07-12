import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        if (m < 1) {
            return 0;
        }
        int n = grid[0].length;

        int maxIslandSize = 0;
        boolean[][] counted = new boolean[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1 && !counted[i][j]) {
                    int islandSize = bfsFindAllCellsInIsland(grid, i, j, m, n, counted);
                    if (islandSize > maxIslandSize) {
                        maxIslandSize = islandSize;
                    }
                }
            }
        }
        
        return maxIslandSize;
    }

    private int bfsFindAllCellsInIsland(int[][] grid, 
            int i, int j, int m, int n, boolean[][] counted) {
        
        int size = 0;
        
        Queue<Cell> q = new LinkedList<>();
        Cell c = new Cell(i, j);
        q.offer(c);
        counted[c.x][c.y] = true;

        while (!q.isEmpty()) {
            c = q.poll();
            size++;

            if (c.x - 1 >= 0 && grid[c.x-1][c.y] == 1 && !counted[c.x-1][c.y]) {
                q.offer(new Cell(c.x-1, c.y));
                counted[c.x-1][c.y] = true;
            }
            if (c.x + 1 < m && grid[c.x+1][c.y] == 1 && !counted[c.x+1][c.y]) {
                q.offer(new Cell(c.x+1, c.y));
                counted[c.x+1][c.y] = true;
            }
            if (c.y - 1 >= 0 && grid[c.x][c.y-1] == 1 && !counted[c.x][c.y-1]) {
                q.offer(new Cell(c.x, c.y-1));
                counted[c.x][c.y-1] = true;
            }
            if (c.y + 1 < n && grid[c.x][c.y+1] == 1 && !counted[c.x][c.y+1]) {
                q.offer(new Cell(c.x, c.y+1));
                counted[c.x][c.y+1] = true;
            }
        }

        return size;
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
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        
        Solution sol = new Solution();
        int maxSize = sol.maxAreaOfIsland(grid);
        System.out.println(maxSize);
    }

}
