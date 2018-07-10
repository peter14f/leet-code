import java.util.Arrays;

public class Solution {

    public int[][] transpose(int[][] A) {
        int m = A.length;
        
        if (m < 1) {
            return new int[0][0];
        }
        
        int n = A[0].length;
        
        int[][] B = new int[n][m];
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                B[j][i] = A[i][j];
            }
        }

        return B;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Solution sol = new Solution();
        int[][] B = sol.transpose(A);
        System.out.println(Arrays.deepToString(B));
    }

}
