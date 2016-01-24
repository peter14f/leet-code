import java.util.ArrayList;


public class SolutionBFS {

    class Cell {
        int x;
        int y;
        
        public Cell(int row, int col) {
            x = col;
            y = row;
        }
    }
    
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        int[][] island = new int[m][n];
        
        int nextLabel = 1;
        ArrayList<Cell> q = new ArrayList<Cell>();
        
        for (int row=0; row<m; row++) {
            for (int col=0; col<n; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    
                    q.add(new Cell(row, col));
                    visited[row][col] = true;
                    
                    int label = nextLabel;
                    nextLabel++;
                    
                    while (!q.isEmpty()) {
                        Cell c = q.remove(0);
                        island[c.y][c.x] = label;
                        
                        // up
                        if (c.y - 1 >= 0 && grid[c.y-1][c.x] == '1' && !visited[c.y-1][c.x]) {
                            visited[c.y-1][c.x] = true;
                            q.add(new Cell(c.y-1, c.x));
                        }
                        
                        // down
                        if (c.y + 1 < m && grid[c.y+1][c.x] == '1' && !visited[c.y+1][c.x]) {
                            visited[c.y+1][c.x] = true;
                            q.add(new Cell(c.y+1, c.x));
                        }
                        
                        // left
                        if (c.x - 1 >= 0 && grid[c.y][c.x-1] == '1' && !visited[c.y][c.x-1]) {
                            visited[c.y][c.x-1] = true;
                            q.add(new Cell(c.y, c.x-1));
                        }
                        
                        // right
                        if (c.x + 1 < n && grid[c.y][c.x+1] == '1' && !visited[c.y][c.x+1]) {
                            visited[c.y][c.x+1] = true;
                            q.add(new Cell(c.y, c.x+1));
                        }
                    }
                }
            }
        }
        
        return nextLabel - 1;
    }
    
    public static void main(String[] args) {
        String[] a = {"10110010111101011110",
                      "01001010111111011011",
                      "10010101011011100110",
                      "01100110111100100011",
                      "11010010001010111011",
                      "00001011001001011110",
                      "10111101101101110010",
                      "01100010010111001101",
                      "00001101001101001010",
                      "00111010101110111110",
                      "10101110111010101011",
                      "00111101110100011101",
                      "11100000110111011110",
                      "00111001001111110110",
                      "00011000011010011111",
                      "01110100111110111001",
                      "00001111000010000110",
                      "11111111110110111111",
                      "01001001111110101111",
                      "00111110001111110110"};
        
        char[][] grid = new char[a.length][];
        for (int i=0; i<grid.length; i++) {
            grid[i] = a[i].toCharArray();
        }
        
        Solution sol = new Solution();
        int num = sol.numIslands(grid);
        System.out.println(num);
    }

}
