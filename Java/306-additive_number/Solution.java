public class Solution {

    // Given a string containing only digits '0'-'9'
    // write a function to determine if it's an additive number.
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        if (n < 3)
            return false;
        
        for (int i=0; i<n/3; i++) {
            String prevPrev = num.substring(0, i+1);
            
            if (i+1 > 1 && prevPrev.charAt(0) == '0') {
                // first number cannot end here
                continue;
            }
            
            for (int j=i+1; j<n; j++) {
                
                String prev = num.substring(i+1, j+1);
                
                if (j-i > 1 && prev.charAt(0) == '0') {
                    // second number cannot end here
                    continue;
                }
                
                if (isValid(num.substring(j+1), prevPrev, prev))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean isValid(String num, String prevPrev, String prev) {
        int n = num.length();
        
        for (int i=0; i<n; i++) {
            String str = num.substring(0, i+1);
            
            if (i+1 > 1 && str.charAt(0) == '0') {
                continue;
            }
            
            long a = Long.parseLong(prevPrev);
            long b = Long.parseLong(prev);
            long c = Long.parseLong(str);
            
            if (c == a+b) {
                if (i+1 == n)
                    return true;
                else
                    return isValid(num.substring(i+1), prev, str);
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean isAdditive = sol.isAdditiveNumber("000");
        System.out.println(isAdditive);
    }

}
