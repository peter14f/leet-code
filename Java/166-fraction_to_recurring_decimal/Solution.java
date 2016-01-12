import java.util.HashMap;

public class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuffer sb = new StringBuffer();
        
        long remainder = numerator;
        long denom = denominator;
        boolean negative = false;
        boolean empty = true;
        boolean recurring = false;
        HashMap<Long, Integer> dict = new HashMap<Long, Integer>();
        StringBuffer decimalNum = new StringBuffer();
        int position = 0;
        
        if (remainder < 0 && denom > 0) {
            negative = true;
            remainder = -remainder;
        }
        else if (remainder > 0 && denom < 0) {
            negative = true;
            denom = -denom;
        }
        else if (remainder < 0 && denom < 0) {
            denom = -denom;
            remainder = -remainder;
        }
        
        do {
            long q = remainder / denom;
            remainder = remainder % denom;
            
            if (empty) {
                if (negative)
                    sb.append("-");
                
                sb.append(q);
                
                if (remainder == 0)
                    break;
                
                sb.append(".");
                empty = false;
            }
            else {
                decimalNum.append(q);
            }
            
            remainder = remainder * 10;
            position++;
            
            if (!dict.containsKey(remainder)) {
                dict.put(remainder, position);
            }
            else {
                position = dict.get(remainder);
                recurring = true;
                break;
            }
            
        } while (remainder > 0);
        
        if (!recurring)
            sb.append(decimalNum);
        else {
            for (int i=1; i<=decimalNum.length(); i++) {
                if (i == position) {
                    sb.append("(");
                }
                sb.append(decimalNum.charAt(i-1));
            }
            sb.append(")");
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        String ans = sol.fractionToDecimal(50, -10);
        System.out.println(ans);
    }

}
