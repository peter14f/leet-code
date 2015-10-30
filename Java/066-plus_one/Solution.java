import java.util.Arrays;


public class Solution {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        if (digits[n-1] != 9) {
            digits[n-1] +=1;
            return digits;
        }
        else {
            digits[n-1] = 0;
            
            int i = n-2;
            while (i >= 0) {
                if (digits[i] != 9) {
                    digits[i] += 1;
                    return digits;
                }
                i--;
            }
            
            int[] newDigits = new int[n+1];
            
            newDigits[0] = 1;
            return newDigits;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 9};
        Solution sol = new Solution();
        int[] newNums = sol.plusOne(nums);
        System.out.println(Arrays.toString(newNums));
    }

}
