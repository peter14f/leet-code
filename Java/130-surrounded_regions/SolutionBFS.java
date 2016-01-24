import java.util.ArrayList;
import java.util.Arrays;


public class SolutionBFS {

    class Cell {
        int x;
        int y;
        
        public Cell(int row, int col) {
            y = row;
            x = col;
        }
    }
    
    public void solve(char[][] board) {
        int m = board.length;
        
        if (m==0)
            return;
        
        int n = board[0].length;
        
        if (m==1 || n==1)
            return;
        
        boolean[][] visited = new boolean[m][n];
        
        ArrayList<Cell> q = new ArrayList<Cell>();
        
        // first row, last row
        for (int row=0; row < m; row=row+m-1) {
            
            for (int col=0; col<n; col++) {
                if (board[row][col] == 'O' && !visited[row][col]) {
                    process(board, row, col, visited, q);
                }
            }
        }
        
        // first col, last col
        for (int col=0; col < n; col=col+n-1) {
            for (int row=0; row<m; row++) {
                if (board[row][col] == 'O' && !visited[row][col]) {
                    process(board, row, col, visited, q);
                }
            }
        }
        
        for (int row=0; row<m; row++) {
            for (int col=0; col<n; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
                else if (board[row][col] == 'P') {
                    board[row][col] = 'O';
                }
            }
        }
    }
    
    private void process(char[][]board, int row, int col, boolean[][] visited, ArrayList<Cell> q) {
        int m = board.length;
        int n = board[0].length;
        
        visited[row][col] = true;
        
        q.add(new Cell(row, col));
        
        while (!q.isEmpty()) {
            Cell c = q.remove(0);
            board[c.y][c.x] = 'P';
            
            // up
            if (c.y-1 >= 0 && board[c.y-1][c.x] == 'O' && !visited[c.y-1][c.x]) {
                visited[c.y-1][c.x] = true;
                q.add(new Cell(c.y-1, c.x));
            }
            
            // down
            if (c.y+1 < m && board[c.y+1][c.x] == 'O' && !visited[c.y+1][c.x]) {
                visited[c.y+1][c.x] = true;
                q.add(new Cell(c.y+1, c.x));
            }
            
            // left
            if (c.x-1 >= 0 && board[c.y][c.x-1] == 'O' && !visited[c.y][c.x-1]) {
                visited[c.y][c.x-1] = true;
                q.add(new Cell(c.y, c.x-1));
            }
            
            // right
            if (c.x + 1 < n && board[c.y][c.x+1] == 'O' && !visited[c.y][c.x+1]) {
                visited[c.y][c.x+1] = true;
                q.add(new Cell(c.y, c.x+1));
            }
        }
    }
    
    public static void main(String[] args) {
        String[] a = {
                "X"
        };
        
        char[][] board = new char[a.length][];
        for (int i=0; i<a.length; i++) {
            board[i] = a[i].toCharArray();
        }
        
        SolutionBFS sol = new SolutionBFS();
        
        sol.solve(board);
        
        System.out.println(Arrays.deepToString(board));
    }

}
