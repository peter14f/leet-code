import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        if (m < 1) {
            return false;
        }
        int n = maze[0].length;
        Set<String> visited = new HashSet<>();
        
        return dfsCanReachDest(
                maze, m, n, start[0], start[1], destination[0], destination[1], visited);
    }

    // note that this method is only called once for each cell located at (x,y)
    private boolean dfsCanReachDest(
            int[][] maze, int m, int n, int x, int y, int destX, int destY, Set<String> visited) {

        if (x == destX && y == destY) {
            return true;
        }

        visited.add(formKey(x, y));

        // UP
        Cell up = destIfGoUp(maze, x, y);
        if (!visited.contains(formKey(up.x, up.y))) {
            boolean upResult = dfsCanReachDest(maze, m, n, up.x, up.y, destX, destY, visited);
            if (upResult) {
                return true;
            }
        }
        // RIGHT
        Cell right = destIfGoRight(maze, x, y, n);
        if (!visited.contains(formKey(right.x, right.y))) {
            boolean rightResult = dfsCanReachDest(maze, m, n, right.x, right.y, destX, destY, visited);
            if (rightResult) {
                return true;
            }
        }
        // DOWN
        Cell down = destIfGoDown(maze, x, y, m);
        if (!visited.contains(formKey(down.x, down.y))) {
            boolean downResult = dfsCanReachDest(maze, m, n, down.x, down.y, destX, destY, visited);
            if (downResult) {
                return true;
            }
        }
        // LEFT
        Cell left = destIfGoLeft(maze, x, y);
        if (!visited.contains(formKey(left.x, left.y))) {
            boolean leftResult = dfsCanReachDest(maze, m, n, left.x, left.y, destX, destY, visited);
            if (leftResult) {
                return true;
            }
        }
        return false;
    }

    private Cell destIfGoLeft(int[][] maze, int x, int y) {
        while (y-1 >=0 && maze[x][y-1] == 0) {
            y--;
        }
        return new Cell(x, y);
    }
    
    private Cell destIfGoDown(int[][] maze, int x, int y, int m) {
        while (x+1 < m && maze[x+1][y] == 0) {
            x++;
        }
        return new Cell(x, y);
    }
    
    private Cell destIfGoRight(int[][] maze, int x, int y, int n) {
        while (y+1 < n && maze[x][y+1] == 0) {
            y++;
        }
        return new Cell(x, y);
    }

    private Cell destIfGoUp(int[][] maze, int x, int y) {
        while (x-1 >=0 && maze[x-1][y] == 0) {
            x--;
        }
        return new Cell(x, y);
    }

    private String formKey(int x, int y) {
        return x + "," + y;
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
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        Solution sol = new Solution();
        boolean ans = sol.hasPath(maze, new int[]{0,4},new int[]{4,4});
        System.out.println(ans);
    }

}
