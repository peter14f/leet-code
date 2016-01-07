import java.util.Arrays;
import java.util.Stack;


public class Solution {

    // find the largest rectangle 
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null || matrix.length==0)
            return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] height = new int[m][n];
        
        for (int col=0; col < n; col++) {
            int cnt = 0;
            
            for (int row=0; row < m; row++) {
                if (matrix[row][col]=='1')
                    cnt++;
                else
                    cnt = 0;
                
                height[row][col] = cnt;
            }
        }
        
        System.out.println(Arrays.deepToString(height));
        
        int maxRectangle = 0;
        
        for (int row=0; row < m; row++) {
            int[] histogram = height[row];
            int area = getMaxRectangle(histogram);
            System.out.println("row " + row + " area=" + area);
            if (area > maxRectangle)
                maxRectangle = area;
        }
        
        return maxRectangle;
    }
    
    private int getMaxRectangle(int[] height) {
        if (height==null || height.length == 0)
            return 0;
        
        // stk stores the index, not the height
        Stack<Integer> stk = new Stack<Integer>();
        int i=0;
        int maxArea = 0;
        
        while (!stk.isEmpty() || i<height.length) {
            if (stk.isEmpty()) {
                stk.push(i);
                i++;
                continue;
            }
            
            if (i == height.length || height[i] < height[stk.peek()]) {
                int poppedIndex = stk.pop();
                
                int prevShorterIndex = -1;
                
                if (!stk.isEmpty()) {
                    prevShorterIndex = stk.peek();
                }
                
                int area = height[poppedIndex]*(i - (prevShorterIndex + 1));
                if (area > maxArea) {
                    maxArea = area;
                }
            }
            else {
                stk.push(i);
                i++;
                continue;
            }
        }
                
        return maxArea;
    }
    
    public static void main(String[] args) {
        char[][] matrix = {{'1'}};
                
                /*{
                {'1', '0', '1'},
                {'1', '1', '1'},
                {'0', '1', '1'}
        };*/
        
        Solution sol = new Solution();
        int maxRectangle = sol.maximalRectangle(matrix);
        System.out.println(maxRectangle);
    }

}
