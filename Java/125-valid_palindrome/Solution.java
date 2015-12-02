
public class Solution {

    public boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;
        
        s = s.toLowerCase().trim();
        
        char[] sArr = s.toCharArray();
        
        int i=0;
        int j=sArr.length-1;
        
        while (i<sArr.length) {
            
            if (!isAlphaNumeric(sArr[i])) {
                i++;
                continue;
            }
            
            if (j < 0) {
                return false;
            }
            
            if (!isAlphaNumeric(sArr[j])) {
                j--;
                continue;
            }
            
            if (sArr[i] != sArr[j]) {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
    
    private boolean isAlphaNumeric(char c) {
        
        if ((c >= '0' && c <= '9') || (c >='a' && c <= 'z')) {
            return true;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        String s = "madddam";
        
        Solution sol = new Solution();
        
        boolean isP = sol.isPalindrome(s);
        System.out.println(isP);
    }

}
