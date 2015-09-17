
public class Solution {

    int divide(int dividend, int divisor) {
        int sum = 0;
        
        if (divisor == 0) {
            throw new IllegalArgumentException("cannot divide by 0");
        }
        
        if (dividend == 0)
            return 0;
        if (divisor == 1)
            return dividend;
        
        boolean negative = false;
        boolean overflow = false;
        
        long dividend_long = dividend;
        long divisor_long = divisor;
        
        if (dividend < 0 && divisor > 0) {
            negative = true;
            dividend_long = Math.abs(dividend_long);
        }
        else if (dividend > 0 && divisor < 0) {
            negative = true;
            divisor_long = Math.abs(divisor_long);
        }
        else if (dividend < 0 && divisor < 0) {
            dividend_long = Math.abs(dividend_long);
            divisor_long = Math.abs(divisor_long);
        }
        
        while (dividend_long >= divisor_long) {
            
            long div = divisor_long;
            
            long mult = 1;
            
            if (dividend_long > divisor_long) {
                while (div < dividend_long) {
                    div = div << 1;
                    mult = mult << 1;
                }
            
                div = div >> 1;
                mult = mult >> 1;
            }
            
            sum += mult;
            
            if (sum < 0)
                overflow = true;
            
            dividend_long -= div;
        }
        
        if (negative) {
            if (overflow)
                return Integer.MIN_VALUE;
            return -sum;
        }
        else {
            if (overflow)
                return Integer.MAX_VALUE;
            return sum;
        }
    }
    
    public static void main(String[] args) {
        // 2147483647, 1
        // 2147483647, 3
        //-2147483648, -1
        int dividend = -2147483648;
        int divisor = -1;
        Solution sol = new Solution();
        int ans = sol.divide(dividend, divisor);
        System.out.println(ans);
    }

}
