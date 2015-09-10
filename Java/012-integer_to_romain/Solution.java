
public class Solution {

    // 1 ~ 3999
    public String intToRoman(int num) {
        int divisor = 1000;
        
        StringBuffer sb = new StringBuffer();
        
        for (int i=4; i>0; i--) {
            
            int digit = num / divisor;
            
            if (digit > 0) {
                String toAdd = getRomainNumeral(digit, divisor);
                sb.append(toAdd);
                
                num = num - digit*divisor;
            }
            
            divisor = divisor / 10;
        }
        
        return sb.toString();
    }

    /**
     * I -    1
     * V -    5
     * X -   10
     * L -   50
     * C -  100
     * D -  500
     * M - 1000
     */
    private String getRomainNumeral(int digit, int divisor) {
        
        StringBuffer sb = new StringBuffer();
        
        switch (divisor) {
            case 1000:
                for (int i=0; i<digit; i++)
                    sb.append('M');
                break;
            case 100:
                if (digit == 4) {
                    sb.append("CD");
                }
                else if (digit == 9) {
                    sb.append("CM");
                }
                else {
                    if (digit >= 5) {
                        sb.append('D');
                        digit -= 5;
                    }
                    for (int i=0; i<digit; i++)
                        sb.append('C');
                }
                break;
            case 10:
                if (digit == 4) {
                    sb.append("XL");
                }
                else if (digit == 9) {
                    sb.append("XC");
                }
                else {
                    if (digit >= 5) {
                        sb.append("L");
                        digit -= 5;
                    }
                    for (int i=0; i<digit; i++)
                        sb.append('X');
                }
                break;
            case 1:
                if (digit == 4) {
                    sb.append("IV");
                }
                else if (digit == 9) {
                    sb.append("IX");
                }
                else {
                    if (digit >= 5) {
                        sb.append('V');
                        digit -=5;
                    }
                    for (int i=0; i<digit; i++)
                        sb.append('I');
                }
                break;
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        
        Solution sol = new Solution();
        int x = 99;
        String ans = sol.intToRoman(x);
        System.out.println(ans);
    }

}
