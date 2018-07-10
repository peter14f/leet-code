import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        
        if (m <= 2)
            return 0;
        
        int n = heightMap[0].length;
        
        if (n <= 2)
            return 0;
        
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>();
        boolean[][] visited = new boolean[m][n];

        for (int i=0; i<n; i++) {
            visited[0][i] = true;
            pq.offer(new Cell(0, i, heightMap[0][i]));
            visited[m-1][i] = true;
            pq.offer(new Cell(m-1, i, heightMap[m-1][i]));
        }
        
        for (int i=1; i<m-1; i++) {
            visited[i][0] = true;
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            visited[i][n-1] = true;
            pq.offer(new Cell(i, n-1, heightMap[i][n-1]));
        }

        
        int minWall = Integer.MIN_VALUE;
        int totalVolume = 0;

        while (!pq.isEmpty()) {
            Cell c = pq.poll();
            if (c.val > minWall) {
                minWall = c.val;
            }

            // each cell has up to 4 neighbors
            if (c.x - 1 >= 0) {
                if (!visited[c.x-1][c.y]) {
                    if (heightMap[c.x-1][c.y] < minWall) {
                        totalVolume += minWall - heightMap[c.x-1][c.y];
                    }
                    pq.offer(new Cell(c.x-1, c.y, heightMap[c.x-1][c.y]));
                    visited[c.x-1][c.y] = true;
                }
            }
            if (c.y - 1 >= 0) {
                if (!visited[c.x][c.y-1]) {
                    if (heightMap[c.x][c.y-1] < minWall) {
                        totalVolume += minWall - heightMap[c.x][c.y-1];
                    }
                    pq.offer(new Cell(c.x, c.y-1, heightMap[c.x][c.y-1]));
                    visited[c.x][c.y-1] = true;
                }
            }
            if (c.x + 1 < m) {
                if (!visited[c.x+1][c.y]) {
                    if (heightMap[c.x+1][c.y] < minWall) {
                        totalVolume += minWall - heightMap[c.x+1][c.y];
                    }
                    pq.offer(new Cell(c.x+1, c.y, heightMap[c.x+1][c.y]));
                    visited[c.x+1][c.y] = true;
                }
            }
            if (c.y + 1 < n) {
                if (!visited[c.x][c.y+1]) {
                    if (heightMap[c.x][c.y+1] < minWall) {
                        totalVolume += minWall - heightMap[c.x][c.y+1];
                    }
                    pq.offer(new Cell(c.x, c.y+1, heightMap[c.x][c.y+1]));
                    visited[c.x][c.y+1] = true;
                }
            }
        }

        return totalVolume;
    }

    static class Cell implements Comparable<Cell> {
        int x;
        int y;
        int val;

        public Cell(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Cell o) {
            return this.val - o.val;
        }

        @Override
        public String toString() {
            return "(" + this.x + ", " + this.y + ")" + ", " + this.val;
        }
    }

    public static void main(String[] args) {
        int[][] heightMap2 = {
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}
        };

        int[][] heightMap = {
                {2, 2, 2},
                {2, 1, 2},
                {2, 1, 2},
                {2, 1, 2}
        };

        Solution sol = new Solution();
        int ans = sol.trapRainWater(heightMap);
        System.out.println(ans);
    }

}
