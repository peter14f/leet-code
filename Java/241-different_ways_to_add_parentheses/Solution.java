import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    // the test cases assumes that the numbers are all one-digit itegers
    public List<Integer> diffWaysToCompute(String input) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        if (input == null || input.length() == 0)
            return result;
        
        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            
            if (c != '+' && c != '-' && c != '*')
                continue;
            
            List<Integer> leftResults = diffWaysToCompute(input.substring(0, i));
            List<Integer> rightResults = diffWaysToCompute(input.substring(i+1));
            
            for (int m: leftResults) {
                for (int n: rightResults) {
                    if (c == '+') {
                        result.add(m+n);
                    }
                    else if (c == '-') {
                        result.add(m-n);
                    }
                    else if (c == '*') {
                        result.add(m*n);
                    }
                }
            }
        } // for
        
        if (result.isEmpty()) {
            result.add(Integer.parseInt(input));
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "5+1*3";
        List<Integer> ans = sol.diffWaysToCompute(s);
        System.out.println("answer:");
        System.out.println(ans);
    }

}
