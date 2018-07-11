import java.util.Arrays;
import java.util.Stack;

public class Solution {

    // a more elegant solution uses a stack

    
    public int[] dailyTemperatures2(int[] temperatures) {
        Stack<Integer> stk = new Stack<Integer>(); // stores the index
        int[] ans = new int[temperatures.length];
        int i=0; 
        while (!stk.isEmpty() || i<temperatures.length) {
            if (stk.isEmpty()) {
                stk.push(i);
                i++;
                continue;
            }

            if (i >= temperatures.length || temperatures[i] > temperatures[stk.peek()]) {
                int index = stk.pop();
                if (i >= temperatures.length) {
                    ans[index] = 0;
                } else {
                    ans[index] = i-index;
                }
            } else {
                stk.push(i);
                i++;
            }
        }
        return ans;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        // trivial solution will take O(n^2) time
        return null;
    }

    public static void main(String[] args) {
        int[] temp = {73, 74, 75, 72, 69, 73, 76, 73};
        Solution sol = new Solution();
        int[] ans = sol.dailyTemperatures2(temp);
        System.out.println(Arrays.toString(ans));
    }

}
