import java.util.Stack;


public class Solution {

    private void evaluateAddSubtract(Stack<Integer> nums, Stack<Character> ops) {
        Stack<Integer> numsReversed = new Stack<Integer>();
        
        while (!nums.isEmpty())
            numsReversed.push(nums.pop());
        
        
        Stack<Character> opsReversed = new Stack<Character>();
        
        while (!ops.isEmpty())
            opsReversed.push(ops.pop());
        
        int a = numsReversed.pop();
        while (!opsReversed.isEmpty()) {
            char op = opsReversed.pop();
            int b = numsReversed.pop();
            
            if (op == '+')
                a = a+b;
            else
                a = a-b;
        }
        
        nums.push(a);
    }
    
    private void evaluateMultDiv(Stack<Integer> nums, Stack<Character> ops) {
        int b = nums.pop();
        char op = ops.pop();
        int a = nums.pop();
        
        if (op == '*')
            nums.push(a*b);
        else
            nums.push(a/b);
    }
    
    private boolean isNum(char c) {
        return (c >= '0' && c <= '9');
    }
    
    private int calculateNoSpace(String s) {
        char[] sArr = s.toCharArray();
        
        if (sArr.length == 0)
            return 0;
        
        Stack<Integer> nums = new Stack<Integer>();
        Stack<Character> ops = new Stack<Character>();
        
        int num = 0;
        for (int i=0; i<sArr.length; i++) {
            if (isNum(sArr[i])) {
                if (i > 0 && isNum(sArr[i-1]))
                    num = num * 10 + (sArr[i] - '0');
                else
                    num = sArr[i] - '0';
                
                if (i == sArr.length - 1 || !isNum(sArr[i+1])) {
                    nums.push(num);
                    if (!ops.isEmpty() && 
                            (ops.peek() == '*' || ops.peek() == '/'))
                           evaluateMultDiv(nums, ops);
                }
                
                
            }
            else
                ops.push(sArr[i]);
        }
        
        if (!ops.isEmpty())
            evaluateAddSubtract(nums, ops);
        
        return nums.peek();
    }
    
    public int calculate(String s) {
        StringBuffer sb = new StringBuffer();
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ')
                sb.append(c);
        }
        
        return calculateNoSpace(sb.toString());
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = sol.calculate("1*2*3*4*5*6*7*8*9*10");
        System.out.println(ans);
    }

}
