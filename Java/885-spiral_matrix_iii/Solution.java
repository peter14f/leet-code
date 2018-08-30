import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] ans = new int[R*C][2];
        
        int i=0;
        int x = r0;
        int y = c0;

        ans[i++] = new int[]{r0, c0};

        int dir = 0; // RIGHT
        int dist = 1;

        while (i < ans.length) {
            if (x == r0 - dist && y == c0 + dist) {
                dist++;
            }

            if (dir == 0) {
                // RIGHT
                if (y == c0 + dist) {
                    dir++;
                    x++;
                } else {
                    y++;
                }
            } else if (dir == 1) {
                // DOWN
                if (x == r0 + dist) {
                    dir++;
                    y--;
                } else {
                    x++;
                }
            } else if (dir == 2) {
                // LEFT
                if (y == c0 - dist) {
                    dir++;
                    x--;
                } else {
                    y--;
                }
            } else if (dir == 3) {
                // UP
                if (x == r0 - dist) {
                    dir=0;
                    y++;
                } else {
                    x--;
                }
            }

            if (x >= 0 && x < R && y >= 0 && y < C) {
                ans[i] = new int[] {x, y};
                i++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] ans = sol.spiralMatrixIII(5, 6, 1, 4);
        System.out.println(Arrays.deepToString(ans));
    }

}
