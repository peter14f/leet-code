import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {

    public int minArea(char[][] image, int x, int y) {
        if (image[x][y] == '0')
            return 0;
        
        int m = image.length;
        
        if (m==0) 
            return 0;
        
        int n = image[0].length;
        
        int minCol = y;
        int maxCol = y;
        
        int minRow = x;
        int maxRow = x;
        
        Queue<Cell> q = new LinkedList<Cell>();
        HashSet<Cell> visited = new HashSet<Cell>();
        Cell start = new Cell(x, y);
        q.add(start);
        visited.add(start);
        
        while (!q.isEmpty()) {
            Cell c = q.poll();
            
            //System.out.println("row=" + c.row + " col=" + c.col);
            
            minCol = Math.min(minCol, c.col);
            
            maxCol = Math.max(maxCol, c.col);
            
            minRow = Math.min(minRow, c.row);
            
            maxRow = Math.max(maxRow, c.row);
            
            // up
            if (c.row - 1 >= 0 && image[c.row-1][c.col] == '1') {
                Cell up = new Cell(c.row-1, c.col);
                if (!visited.contains(up)) {
                    visited.add(up);
                    q.offer(up);
                }
            }
            
            // down
            if (c.row + 1 < m && image[c.row+1][c.col] == '1') {
                Cell down = new Cell(c.row+1, c.col);
                if (!visited.contains(down)) {
                    visited.add(down);
                    q.offer(down);
                }
            }
            
            // left
            if (c.col - 1 >= 0 && image[c.row][c.col-1] == '1') {
                Cell left = new Cell(c.row, c.col-1);
                if (!visited.contains(left)) {
                    visited.add(left);
                    q.offer(left);
                }
            }
            
            // right
            if (c.col + 1 < n && image[c.row][c.col+1] == '1') {
                Cell right = new Cell(c.row, c.col+1);
                if (!visited.contains(right)) {
                    visited.add(right);
                    q.offer(right);
                }
            }
            
        }
        
        //System.out.println("minRow=" + minRow + " maxRow=" + maxRow);
        //System.out.println("minCol=" + minCol + " maxCol=" + maxCol);
        
        return (maxCol-minCol+1)*(maxRow-minRow+1);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] strs = {
                "0",
                "1"
        };
        
        char[][] image = new char[strs.length][];
        for (int i=0; i<strs.length; i++) {
            image[i] = strs[i].toCharArray();
        }
        
        int rectArea = sol.minArea(image, 1, 0);
        System.out.println(rectArea);
    }

}
