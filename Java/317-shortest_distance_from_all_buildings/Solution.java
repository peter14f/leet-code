import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {

    class Cell {
        int row;
        int col;
        int dist;
        
        public Cell(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    
    // 0 - empty land
    // 1 - a building that you cannot pass through
    // 2 - an obstacle that you cannot pass through
    public int shortestDistance(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] cnt = new int[m][n]; 
        int buildingCnt = 0;
        
        for (int row=0; row<m; row++) {
            for (int col=0; col<n; col++) {
                
                if (grid[row][col] == 1) {
                    buildingCnt++;
                    Cell start = new Cell(row, col, 0);
                    Queue<Cell> q = new LinkedList<Cell>();
                    boolean[][] visited = new boolean[m][n];
                    visited[row][col] = true;
                    q.offer(start);
                    
                    while (!q.isEmpty()) {
                        Cell c = q.poll();
                        
                        if (c.dist > 0 && grid[c.row][c.col] <= 0) {
                            grid[c.row][c.col] -= c.dist;
                            cnt[c.row][c.col]++;
                        }
                        
                        // up
                        if (c.row - 1 >= 0 && grid[c.row-1][c.col] <= 0 && !visited[c.row-1][c.col]) {
                            visited[c.row-1][c.col] = true;
                            q.offer(new Cell(c.row-1, c.col, c.dist + 1));
                        }
                        
                        // down
                        if (c.row + 1 < m && grid[c.row+1][c.col] <= 0 && !visited[c.row+1][c.col]) {
                            visited[c.row+1][c.col] = true;
                            q.offer(new Cell(c.row+1, c.col, c.dist + 1));
                        }
                        
                        // left
                        if (c.col - 1 >= 0 && grid[c.row][c.col-1] <= 0 && !visited[c.row][c.col-1]) {
                            visited[c.row][c.col-1] = true;
                            q.offer(new Cell(c.row, c.col-1, c.dist + 1));
                        }
                        
                        // right
                        if (c.col + 1 < n && grid[c.row][c.col+1] <= 0 && !visited[c.row][c.col+1]) {
                            visited[c.row][c.col+1] = true;
                            q.offer(new Cell(c.row, c.col+1, c.dist+1));
                        }
                    }
                    
                    // done with BFS starting from one building, got to clear visited
                    for (int i=0; i<m; i++) {
                        for (int j=0; j<n; j++) {
                            visited[i][j] = false;
                        }
                    }
                }
            }
        }
        
        int dist = Integer.MIN_VALUE;
        
        //System.out.println(buildingCnt);
        
        for (int row=0; row<m; row++) {
            for (int col=0; col<n; col++) {
                if (grid[row][col] < 0 && cnt[row][col] == buildingCnt && grid[row][col] > dist) {
                    dist = grid[row][col];
                }
            }
        }
        
        if (dist== Integer.MIN_VALUE)
            return -1;
        return Math.abs(dist);
    }
    
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };
        
        Solution sol = new Solution();
        int shortestDistance = sol.shortestDistance(grid);
        
        System.out.println(shortestDistance);
    }

}
