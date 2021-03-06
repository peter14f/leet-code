
public class Solution {


    public boolean isNumber(String s) {
        if (s==null || s.length() == 0)
            return false;
        
        char[] s_arr = s.trim().toCharArray();
        
        if (s_arr.length==0)
            return false;
        
        boolean signSeen = false;
        boolean exponentSeen = false;
        boolean decimalPointSeen = false;
        boolean numberSeen = false;
        int exponentBreak = -1;
        
        for (int i=0; i<s_arr.length; i++) {
            if (s_arr[i] == '+' || s_arr[i] == '-') {
                if (signSeen)
                    return false;
                
                if (i+1==s_arr.length)
                    return false;
                
                signSeen = true;
            }
            else if (isANumber(s_arr[i])) {
                if (!signSeen) 
                    signSeen = true;
                if (!numberSeen)
                    numberSeen = true;
            }
            else if (s_arr[i] == 'e') {
                if (!signSeen)
                    signSeen = true;
                if (exponentSeen)
                    return false;
                if (!numberSeen)
                    return false;
                
                if (i+1==s_arr.length)
                    return false;
                
                exponentSeen = true;
                exponentBreak = i+1;
                break;
            }
            else if (s_arr[i] == '.') {
                if (decimalPointSeen)
                    return false;
                if (!signSeen)
                    signSeen = true;
                
                if (!numberSeen) {
                    if (i+1==s_arr.length)
                        return false;
                    if (s_arr[i+1] == 'e')
                        return false;
                }
                
                decimalPointSeen = true;
            }
            else {
                return false;
            }
        }
        
        if (exponentBreak > -1) {
            return checkPower(s_arr, exponentBreak);
        }
        
        return true;
    }
    
    private boolean checkPower(char[] s_arr, int start) {
        if (start >= s_arr.length) {
            return false;
        }
        
        boolean signSeen = false;
        boolean decimalPointSeen = false;
        
        for (int i=start; i<s_arr.length; i++) {
            if (s_arr[i] == '-' || s_arr[i] == '+') {
                if (signSeen)
                    return false;
                
                if (i+1==s_arr.length)
                    return false;
                
                signSeen = true;
            }
            else if (s_arr[i] == '.') {
                return false;
            }
            else if (isANumber(s_arr[i])) {
                if (!signSeen)
                    signSeen = true;
            }
            else {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isANumber(char c) {
        return c >= '0' && c <='9';
    }
    
    /**
     * TC 1354: "e"
     * TC 1414: " "
     * TC 1415: "3."
     * TC 1469: "."
     * TC 1474: ".e1"
     * TC 1478: "6e6.5"
     * TC 1481: "-e58 "
     */
    public static void main(String[] args) {
        String s = "-e6.5";
        Solution sol = new Solution();
        boolean isNumber = sol.isNumber(s);
        System.out.println(isNumber);
    }

}
