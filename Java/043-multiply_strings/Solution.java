import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    
    /**
     * TC129: "123456789" "987654321" -> "121932631112635269"
     * TC299: "0" "0" -> "0"
     * TC LONG:
     * "8364706555694632506241942061841807278055516979340976383589685785705700271160027216944215305094666159386415617"
     * "4815589832802040613226282551626238706601093398571913553809993718598371680031000194671"
     * 
     *     99
     *     99
     *     8
     *    811     
     */
    public String multiply(String num1, String num2) {
        
        int[] result = new int[num1.length() + num2.length()];
        
        StringBuffer number1 = new StringBuffer(num1);
        StringBuffer number2 = new StringBuffer(num2);
        
        number1.reverse();
        number2.reverse();
        
        for (int i=0; i<number1.length(); i++) {
            for (int j=0; j<number2.length(); j++) {
                int a = number1.charAt(i) - '0';
                int b = number2.charAt(j) - '0';
                
                result[i+j] += a*b;
            }
        }
        
        int carry = 0;
        for (int i=0; i<result.length; i++) {
            
            if (carry > 0) {
                result[i] += carry;
                carry = 0;
            }
            
            if (result[i] > 9) {
                carry = result[i] / 10;
                result[i] = result[i] % 10;
            }            
        }
        
        StringBuffer sb = new StringBuffer();
        boolean firstNonZeroFound = false;
        
        for (int i=result.length - 1; i>=0; i--) {
            if (firstNonZeroFound) {
                sb.append(result[i]);
            }
            else {
                if (result[i] > 0) {
                    firstNonZeroFound = true;
                    sb.append(result[i]);
                }
            }
        }
        
        if (!firstNonZeroFound)
            sb.append(0);
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String s1 = "123456789";
        String s2 = "987654321";
        
        Solution sol = new Solution();
        String ans = sol.multiply(s1, s2);
        System.out.println(ans);
    }

}
