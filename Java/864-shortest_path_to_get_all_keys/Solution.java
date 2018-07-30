import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int shortestPathAllKeys(String[] grid) {
        
        // number of keys 1..6
        int m = grid.length;
        if (m < 1) {
            return 0;
        }
        int n = grid[0].length();

        char[][] charGrid = new char[m][];
        int numKeys = 0;
        Cell start = null;

        for (int i=0; i<m; i++) {
            String s = grid[i];
            charGrid[i] = s.toCharArray();
            for (int j=0; j<n; j++) {
                char c = charGrid[i][j];
                if (c >= 'a' && c <='f') {
                    numKeys++;
                } else if (c == '@') {
                    start = new Cell(i, j, 0);
                }
            }
        }

        int target = 0;
        for (int i=0; i<numKeys; i++) {
            target = target | (1 << i);
        }

        int state = 0;

        boolean[][][] visited = new boolean[m][n][(1<<6)];
        Queue<Cell> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y][state] = true;

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i=0; i<size; i++) {
                Cell cur = q.poll();
                if (cur.state == target) {
                    return step;
                }
                
                // up
                if (cur.x - 1 >= 0) {
                    int newState = canGoTo(charGrid, cur.x - 1, cur.y, cur.state);
                    if (newState > -1 && !visited[cur.x-1][cur.y][newState]) {
                        q.offer(new Cell(cur.x-1, cur.y, newState));
                        visited[cur.x-1][cur.y][newState] = true;
                    }
                }

                // right
                if (cur.y + 1 < n) {
                    int newState = canGoTo(charGrid, cur.x, cur.y + 1, cur.state);
                    if (newState > -1 && !visited[cur.x][cur.y+1][newState]) {
                        q.offer(new Cell(cur.x, cur.y+1, newState));
                        visited[cur.x][cur.y+1][newState] = true;
                    }
                }

                // down
                if (cur.x + 1 < m) {
                    int newState = canGoTo(charGrid, cur.x + 1, cur.y, cur.state);
                    if (newState > -1 && !visited[cur.x+1][cur.y][newState] ) {
                        q.offer(new Cell(cur.x+1, cur.y, newState));
                        visited[cur.x+1][cur.y][newState] = true;
                    }
                }
                
                // left
                if (cur.y - 1 >= 0) {
                    int newState = canGoTo(charGrid, cur.x, cur.y - 1, cur.state);
                    if (newState > -1 && !visited[cur.x][cur.y-1][newState]) {
                        q.offer(new Cell(cur.x, cur.y-1, newState));
                        visited[cur.x][cur.y-1][newState] = true;
                    }
                }
            }
            step++;
        }

        return -1;
    }
    
    private int canGoTo(char[][] charGrid, int x, int y, int curState) {
        if (charGrid[x][y] == '#') {
            return -1;
        }

        if (charGrid[x][y] == '.' || charGrid[x][y] == '@') {
            return curState;
        }
        
        if (charGrid[x][y] >= 'a' && charGrid[x][y] <= 'f') {
            // pick up key
            return curState | (1 << (charGrid[x][y] - 'a'));
        }
        
        if (charGrid[x][y] >= 'A' && charGrid[x][y] <= 'F') {
            if ((curState & (1 << (charGrid[x][y] - 'A'))) > 0) {
                return curState;
            }
        }
        return -1;
    }

    static class Cell {
        int x;
        int y;
        int state;
        public Cell(int x, int y, int state) {
            this.x = x;
            this.y = y;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] grid = {
                "@.a.#","###.#","b.A.B"      
        };
        String[] grid2 = {
                "@..aA","..B#.","....b"
        };
        String[] grid3 = {
                "@fedcbBCDEFaA"
        };
        String[] grid4 = {
                "@...a",".###A","b.BCc"
        };
        int ans = sol.shortestPathAllKeys(grid4);
        System.out.println(ans);
    }

}
