import java.util.Stack;


public class Solution {

    public boolean isValid(String s) {
        
        if (s.length() == 0)
            return true;
        
        char[] s_arr = s.toCharArray();
        
        Stack<Character> stk = new Stack<Character>();
        
        for (int i=0; i<s_arr.length; i++) {
            char cur = s_arr[i];
            
            if (isOpening(cur)) {
                stk.push(cur);
            }
            else {
                if (stk.isEmpty()) {
                    return false;
                }
                else {
                    char lastOpen = stk.peek();
                    
                    if (openMatchesClose(lastOpen, cur)) {
                        stk.pop();
                    }
                    else {
                        return false;
                    }
                }
            }
        } // for
        
        if (stk.isEmpty())
            return true;
        else
            return false;
    }
    
    private boolean openMatchesClose(char open, char close) {
        
        boolean match = false;
        
        switch (open) {
            case '{':
                if (close == '}')
                    match = true;
                break;
            case '[':
                if (close == ']')
                    match = true;
                break;
            case '(':
                if (close == ')')
                    match = true;
                break;
            default:
                match = false;
        }
        
        return match;
    }
    
    private boolean isOpening(char c) {
        if (c=='[' || c=='{' || c=='(')
            return true;
        else
            return false;
    }
    
    public static void main(String[] args) {
        String s = "{}()[[]]";
        
        Solution sol = new Solution();
        boolean ans = sol.isValid(s);
        
        System.out.println(ans);
    }

}
