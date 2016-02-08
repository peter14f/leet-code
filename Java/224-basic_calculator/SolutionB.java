import java.util.Stack;


public class SolutionB {

    public int calculate(String s) {
        char[] sArr = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        
        for (int i=0; i<sArr.length; i++) {
            if (sArr[i] != ' ') {
                sb.append(sArr[i]);
            }
        }
        
        return calculateNoSpace(sb.toString());
    }
    
    private int calculateNoSpace(String s) {
        char[] sArr = s.toCharArray();
        
        Stack<Character> ops = new Stack<Character>();
        Stack<Integer> nums = new Stack<Integer>();
        
        int num = 0;
        
        for (int i=0; i<sArr.length; i++) {
            if (isNum(sArr[i])) {
                if (i > 0 && isNum(sArr[i-1]))
                    num = num * 10 + (sArr[i] - '0');
                else
                    num = sArr[i] - '0';
                
                if (i==sArr.length-1 || !isNum(sArr[i+1])) {
                    nums.push(num);
                    num = 0;
                }
            }
            else {
                if (sArr[i] == ')') {
                    // got to evaluate what's inside the parentheses first
                    evaluateInsideParenthesis(nums, ops);
                }
                else {
                    ops.push(sArr[i]);
                }
            }
        }
        
        while (!ops.isEmpty()) {
            evaluate(nums, ops);
        }
        
        return nums.peek();
    }
    
    private void evaluate(Stack<Integer> nums, Stack<Character> ops) {
        Stack<Character> opsReversed = new Stack<Character>();
        Stack<Integer> numsReversed = new Stack<Integer>();
        
        while (!ops.isEmpty()) {
            numsReversed.push(nums.pop());
            opsReversed.push(ops.pop());
        }
        
        numsReversed.push(nums.pop());
        
        int a = numsReversed.pop();
        
        while (!opsReversed.isEmpty()) {
            char op = opsReversed.pop();
            int b = numsReversed.pop();
            if (op == '+')
                a = a + b;
            else
                a = a - b;
        }
        
        nums.push(a);
    }
    
    private void evaluateInsideParenthesis(Stack<Integer> nums, Stack<Character> ops) {
        Stack<Character> opsReversed = new Stack<Character>();
        Stack<Integer> numsReversed = new Stack<Integer>();
        
        while (ops.peek() != '(') {
            numsReversed.push(nums.pop());
            opsReversed.push(ops.pop());
        }
        
        ops.pop();
        numsReversed.push(nums.pop());
        
        int a = numsReversed.pop();
        
        while (!opsReversed.isEmpty()) {
            char op = opsReversed.pop();
            int b = numsReversed.pop();
            
            if (op == '+') {
                a = a + b;
            }
            else {
                a = a - b;
            }
        }
        
        nums.push(a);
    }
    
    private boolean isNum(char c) {
        return (c >= '0' && c <= '9');
    }
    
    public static void main(String[] args) {
        SolutionB sol = new SolutionB();
        int ans = sol.calculate(" 2-1 + 2 ");
        System.out.println(ans);
    }

}
