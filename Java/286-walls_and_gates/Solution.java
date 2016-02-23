import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {

    class Cell {
        int row;
        int col;
        int distance;
        
        public Cell(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.distance = dist;
        }
    }
    
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        
        if (m==0)
            return;
        
        int n = rooms[0].length;
        
        for (int row=0; row<m; row++) {
            for (int col=0; col<n; col++) {
                if (rooms[row][col] == 0) {
                    bfsFill(rooms, row, col);
                }
            }
        }
    }
    
    private void bfsFill(int[][] rooms, int row, int col) {
        int m = rooms.length;
        int n = rooms[0].length;
        
        Cell start = new Cell(row, col, 0);
        Queue<Cell> q = new LinkedList<Cell>();
        q.offer(start);
        
        while (!q.isEmpty()) {
            Cell c = q.poll();
            
            if (c.distance < rooms[c.row][c.col])
                rooms[c.row][c.col] = c.distance;
            
            // up
            if (c.row - 1 >= 0 && rooms[c.row-1][c.col] > c.distance + 1) {
                Cell up = new Cell(c.row-1, c.col, c.distance + 1);
                q.offer(up);
            }
            
            // down
            if (c.row + 1 < m && rooms[c.row+1][c.col] > c.distance + 1) {
                Cell down = new Cell(c.row+1, c.col, c.distance + 1);
                q.offer(down);
            }
            
            // left
            if (c.col - 1 >= 0 && rooms[c.row][c.col-1] > c.distance + 1) {
                Cell left = new Cell(c.row, c.col-1, c.distance + 1);
                q.offer(left);
            }
            
            // right
            if (c.col + 1 < n && rooms[c.row][c.col+1] > c.distance + 1) {
                Cell right = new Cell(c.row, c.col+1, c.distance + 1);
                q.offer(right);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] rooms = {
                {999,  -1,   0, 999},
                {999, 999, 999, -1},
                {999,  -1, 999, -1},
                {  0,  -1, 999, 999}
        };
        
        Solution sol = new Solution();
        sol.wallsAndGates(rooms);
        
        System.out.println(Arrays.deepToString(rooms));
    }

}
