
public class Solution {

    public boolean isPalindrome(int x) {
        
        if (x < 0)
            return false;
        
        if (x == 0)
            return true;
        
        // find out how many digits
        int numDigits = getNumDigits(x);
        
        int left = numDigits - 1;
        int right = 0;
        int y = x;
        
        for (int i=0; i<numDigits; i++) {
            int leftNum = x / (int) Math.pow(10, left);
            int rightNum = y % 10;
            y = y/10;
            x = x - leftNum*(int) Math.pow(10, left);
            
            if (leftNum != rightNum) {
                return false;
            }
            
            left--;
        }
        
        return true;
    }
    
    
    private int getNumDigits(int x) {
        // 9 876 543 210
        // 4,000,000,000
        int ans = 1;
        for (int digit = 9; digit >=0; digit--) {
            int power_of_ten = (int) Math.pow(10, digit);
            if (x / power_of_ten > 0) {
                ans = digit + 1;
                break;
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        int x = 2223;
        Solution sol = new Solution();
        boolean isPalindrome = sol.isPalindrome(x);
        System.out.println(isPalindrome);
    }

}
