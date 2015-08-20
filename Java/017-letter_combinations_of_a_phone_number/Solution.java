import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Not a very interesting problem.
 * I was wonder if '0' and '1' will be used in the input.
 * But it turns out the input string does not contain either number.
 */
public class Solution {
    public static final int[][] TABLE = 
                                  {{},                    // 0
                                   {},                    // 1
                                   {'a', 'b', 'c'},       // 2
                                   {'d', 'e', 'f'},       // 3
                                   {'g', 'h', 'i'},       // 4
                                   {'j', 'k', 'l'},       // 5
                                   {'m', 'n', 'o'},       // 6
                                   {'p', 'q', 'r', 's'},  // 7
                                   {'t', 'u', 'v'},       // 8
                                   {'w', 'x', 'y', 'z'},  // 9
    };
    
    public List<String> letterCombinations(String digits) {
        ArrayList<StringBuffer> list = new ArrayList<StringBuffer>();
        char[] c = digits.toCharArray();
        
        for (int i=0; i<c.length; i++) {
            int digit = c[i] - '0';
            expandWithDigit(list, digit);
        }
        
        ArrayList<String> ans = new ArrayList<String>();
        
        for (StringBuffer sb : list) {
            ans.add(sb.toString());
        }
        
        return ans;
    }
    
    private void expandWithDigit(ArrayList<StringBuffer> list, int digit) {
        if (digit < 0 || digit > 9)
            throw new IllegalArgumentException();
        
        int[] choices = TABLE[digit];
        
        if (list.isEmpty()) {
            for (int choice: choices) {
                StringBuffer sb = new StringBuffer();
                sb.append((char)choice);
                list.add(sb);
            }
        }
        else {
            int size = list.size();
            for (int i=0; i<size; i++) {
                StringBuffer sb = list.remove(0);
                for (int choice: choices) {
                    StringBuffer expendedStrBuf = new StringBuffer(sb);
                    expendedStrBuf.append((char)choice);
                    list.add(expendedStrBuf);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        String s = "23";
        Solution sol = new Solution();
        List<String> ans = sol.letterCombinations(s);
        System.out.println(ans);
    }

}
