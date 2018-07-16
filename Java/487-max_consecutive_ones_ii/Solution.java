import java.util.Arrays;

public class Solution {

    
    //  1  0  1  1  0  1  1  1  1
    //
    //  1  2  3  4  3  4  5  6  7
    //  1  0  1  2  0  1  2  3  4
    //  
    //  
    public int findMaxConsecutiveOnes(int[] nums) {
        int beforeLatestZero = 0; // consecutive ones counted before encountering 
                                  // the latest zero
        int afterLatestZero = 0;  // consecutive ones counted after encountering 
                                  // the latest zero
        int max = 0;
        for (int num : nums) {
            if (num == 0) {
                afterLatestZero = beforeLatestZero + 1;
                beforeLatestZero = 0;
            } else {
                beforeLatestZero++;
                afterLatestZero++;
            }
            if (beforeLatestZero > max) {
                max = beforeLatestZero;
            }
            if (afterLatestZero > max) {
                max = afterLatestZero;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        Solution sol = new Solution();
        int ans = sol.findMaxConsecutiveOnes(nums);
        System.out.println(ans);
    }

}
