import java.util.LinkedList;
import java.util.Queue;

public class SolutionBFSBetter {

    class Cell {
        int row;
        int col;
        
        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m==0)
            return 0;
        
        int n = grid[0].length;
        
        int numIslands = 0;
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        boolean[][] visited = new boolean[m][n];
        
        for (int row=0; row<m; row++) {
            for (int col=0; col<n; col++) {
                
                if (grid[row][col] == '1' && !visited[row][col]) {
                    //System.out.println("row=" + row + " col=" + col);
                    
                    numIslands++;
                    // start BFS from here mark all cells connected to this
                    // cell to numIslands
                    
                    Queue<Cell> q = new LinkedList<Cell>();
                    
                    q.offer(new Cell(row, col));
                    
                    while (!q.isEmpty()) {
                        Cell c = q.poll();
                        
                        for (int[] dir: dirs) {
                            int neighborRow = c.row + dir[0];
                            int neighborCol = c.col + dir[1];
                            
                            //System.out.println(neighborRow + " " + neighborCol);
                            
                            if (neighborRow >= 0 && 
                                    neighborRow < m &&
                                    neighborCol >=0 &&
                                    neighborCol < n &&
                                    grid[neighborRow][neighborCol] == '1' && 
                                    !visited[neighborRow][neighborCol]) {
                                visited[neighborRow][neighborCol] = true;
                                q.offer(new Cell(neighborRow, neighborCol));
                            }
                        }
                    }
                }
            }
        }
        
        return numIslands;
    }
    
    public static void main(String[] args) {
        SolutionBFSBetter sol = new SolutionBFSBetter();
        String[] strs = {
                "11111011111111101011","01111111111110111110","10111001101111111111","11110111111111111111","10011111111111111111","10111111011101110111","01111111111101101111","11111111111101111011","11111111110111111111","11111111111111111111","01111111011111111111","11111111111111111111","11111111111111111111","11111011111110111111","10111110111011110111","11111111111101111110","11111111111110111100","11111111111111111111","11111111111111111111","11111111111111111111"};
        
        char[][] grid = new char[strs.length][];
        
        for (int i=0; i<strs.length; i++) {
            grid[i] = strs[i].toCharArray();
        }
        
        int numIslands = sol.numIslands(grid);
        
        System.out.println(numIslands);
    }

}
