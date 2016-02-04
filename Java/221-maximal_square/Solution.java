import java.util.Arrays;


public class Solution {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        
        if (m < 1)
            return 0;
        
        int n = matrix[0].length;
        
        int maxArea = 0;
        
        for (int col=0; col<n; col++) {
            int h = 0;
            for (int row=0; row<m; row++) {
                if (matrix[row][col] == '0') 
                    h = 0;
                else
                    h++;
                
                matrix[row][col] = (char)h;
            }
        }
        
        
        for (int row=m-1; row>=0; row--) {
            char[] heights = matrix[row];
            
            for (int i=0; i<heights.length; i++) {
                int h = heights[i];
                
                while (h > 0 && h*h > maxArea) {
                    if (i+h-1 < n) {
                        boolean allTaller = true;
                        
                        for (int j=i+1; j<=i+h-1; j++) {
                            //System.out.println("  j=" + j + "  " + heights[j]);
                            if (heights[j] < h) {
                                allTaller = false;
                                break;
                            }
                        }
                        
                        if (allTaller) {
                            maxArea = h*h;
                            /*
                            System.out.println("row=" + row + 
                                    " col=" + i + 
                                    " maxArea=" + maxArea);*/
                        }
                    }
                    h--;
                }
            }
        }
        
        return maxArea;
    }
    
    public static void main(String[] args) {
        
        
        String[] strs = {
                "1010",
                "1011",
                "1011",
                "1111"
                /*"10100",
                "10111",
                "11111",
                "10010"*/
        };

        char[][] matrix = new char[strs.length][];
        
        for (int i=0; i<matrix.length; i++) {
            matrix[i] = strs[i].toCharArray();
        }
        
        Solution sol = new Solution();
        int maxArea = sol.maximalSquare(matrix);
        System.out.println(maxArea);
    }
}
