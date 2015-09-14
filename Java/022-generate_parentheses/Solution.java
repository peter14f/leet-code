import java.util.ArrayList;
import java.util.List;


public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        
        if (n < 1)
            return ans;
                    
        int openNum = n;
        int closeNum = n;
        StringBuffer sb = new StringBuffer();
        generateParenthesis(openNum, closeNum, 0, sb, ans);
        return ans;
    }
    
    private void generateParenthesis(int openNum, 
                                     int closeNum,
                                     int unclosedNum, 
                                     StringBuffer curStr, 
                                     List<String> ans) {
        
        if (openNum == 0 && closeNum == 0) {
            ans.add(curStr.toString());
            return;
        }
        
        if (openNum > 0) {
            // has at least 1 open parenthesis
            curStr.append('(');
            int newLength = curStr.length();
            
            generateParenthesis(openNum-1, 
                                closeNum, 
                                unclosedNum + 1, 
                                curStr, 
                                ans);
            
            curStr.deleteCharAt(newLength - 1);
        }
        
        if (closeNum > 0 && unclosedNum > 0) {
            curStr.append(')');
            int newLength = curStr.length();
            
            generateParenthesis(openNum,
                                closeNum - 1,
                                unclosedNum - 1,
                                curStr,
                                ans);
            
            curStr.deleteCharAt(newLength - 1);
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> list = sol.generateParenthesis(3);
        
        System.out.println(list);
    }

}
