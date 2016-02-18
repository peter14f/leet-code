import java.util.Stack;


public class SolutionC {

    public boolean verifyPreorder(int[] preorder) {
        if (preorder.length == 0)
            return true;
        
        int low = Integer.MIN_VALUE;
        Stack<Integer> stk = new Stack<Integer>();
        
        for (int i=0; i<preorder.length; i++) {
            
            if (preorder[i] < low)
                return false;
            
            while (!stk.isEmpty() && preorder[i] > stk.peek()) {
                low = stk.pop();
            }
            
            stk.push(preorder[i]);
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        int[] nums = {5, 3, 1, 4, 7, 8};
        SolutionC sol = new SolutionC();
        
        boolean ans = sol.verifyPreorder(nums);
        
        System.out.println(ans);
    }

}
