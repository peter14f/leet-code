import java.util.Stack;


public class Solution {

    public int largestRectangleArea(int[] height) {
        
        if (height==null || height.length == 0)
            return 0;
        
        int maxArea = 0;
        
        // stack stores the index
        Stack<Integer> stk = new Stack<Integer>();
        
        int i = 0;
        
        while (i < height.length || !stk.isEmpty()) {
            if (stk.isEmpty()) {
                stk.push(i);
                i++;
                continue;
            }
            
            if (i==height.length || height[i] < height[stk.peek()]) {
                int poppedIndex = stk.pop();
                int peepIndex = -1;
                
                if (!stk.isEmpty()) {
                    peepIndex = stk.peek();
                }
                
                // time to calculate the area
                int area = height[poppedIndex]*(i - (peepIndex+1));
                if (area > maxArea)
                    maxArea = area;
            }
            else {
                stk.push(i);
                i++;
            }
        }
        
        return maxArea;
    }
    
    public static void main(String[] args) {
        int[] height = {0};
        
        Solution sol = new Solution();
        int area = sol.largestRectangleArea(height);
        System.out.println(area);
    }

}
