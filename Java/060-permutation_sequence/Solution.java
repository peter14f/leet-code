import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {

    /*
     * 0 123 0 0 0
     * 1 132 0 1 0
     * 2 213 1 0 0
     * 3 231 1 1 0
     * 4 312 2 0 0
     * 5 321 2 1 0
     */
    public String getPermutation(int n, int k) {
        if (n<=0 || k <= 0)
            return "";
        
        int factorial = 1;
        List<Integer> choices = new ArrayList<Integer>();
        StringBuffer sb = new StringBuffer();
        
        for (int i=1; i<=n; i++) {
            factorial = factorial * i;
            choices.add(i);
        }
        
        k = k - 1;
        
        for (int i=n; i>0; i--) {
            factorial = factorial / i;
            int index = k / factorial;
            int digit = choices.remove(index);
            sb.append(digit);
            k = k % factorial;
        }
        
        return sb.toString();
    }
    
    // BIG TC: 8, 8590
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = sol.getPermutation(3,5);
        System.out.println(s);
    }

}
