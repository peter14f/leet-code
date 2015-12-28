import java.util.Stack;


public class Solution {

    private int isOperator(String s) {
        if (s.length() != 1)
            return 0;
        
        char op = s.toCharArray()[0];
        int operator = 0;
        
        switch(op) {
            case '+':
                operator = 1;
                break;
            case '-':
                operator = 2;
                break;
            case '*':
                operator = 3;
                break;
            case '/':
                operator = 4;
                break;
            default:
                operator=0;
        }
        
        return operator;
    }
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<Integer>();
        
        for (int i=0; i<tokens.length; i++) {
            String s = tokens[i];
            
            int op = isOperator(s);
            
            if (op > 0) {
                if (stk.size() < 2)
                    throw new IllegalArgumentException();
                
                int b = stk.pop();
                int a = stk.pop();
                
                int result = performOp(op, a, b);
                stk.push(result);
            }
            else {
                stk.push(Integer.parseInt(s));
            }
        }
        
        return stk.peek();
    }
    
    private int performOp(int op, int a, int b) {
        
        if (op==1)
            return a+b;
        else if (op==2)
            return a-b;
        else if (op==3)
            return a*b;
        else
            return a/b;
    }
    
    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        Solution sol = new Solution();
        
        int result = sol.evalRPN(tokens);
        System.out.println(result);
    }
}
