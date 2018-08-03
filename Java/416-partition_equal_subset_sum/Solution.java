import java.util.Arrays;

public class Solution {

    public boolean canPartitionDp(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        // A + B = sum
        // A=B
        // 2A = sum
        // A = sum / 2 --> this has to be an whole number

        int n = nums.length;

        if (sum % 2 == 1) {
            return false;
        }

        Arrays.sort(nums);

        int target = sum / 2;

        // dp[i][j] is the maximum sum that can be achieved if the maximum sum is capped at j
        int[][] dp = new int[n][target + 1];

        // 1st column - maximum sum allowed is 0
        for (int i=0; i<n; i++) {
            dp[i][0] = 0;
        }

        // 1st row
        for (int i=1; i<=target; i++) {
            // if max sum allowed is greater than the smallest number
            if (i >= nums[0]) {
                dp[0][i] = nums[0];
            }
        }

        //System.out.println(Arrays.deepToString(dp));

        for (int i=1; i<n; i++) {
            for (int j=1; j<=target; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i] && j-nums[i] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-nums[i]] + nums[i]);
                }
                if (dp[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 == 1) {
            return false;
        }

        return canPartitionIntoTwoEqualSum(nums, 0, 0, totalSum);
    }

    private boolean canPartitionIntoTwoEqualSum(int[] nums, 
            int i, 
            int currentSetASum, 
            int totalSum) {

        if (i==nums.length) {
            int setBSum = totalSum - currentSetASum;
            if (setBSum == currentSetASum) {
                return true;
            } else {
                return false;
            }
        }

        // include nums[i] in set A
        int newSumA = currentSetASum + nums[i];
        boolean canPartitionA = canPartitionIntoTwoEqualSum(nums, i+1, newSumA, totalSum);
        
        if (canPartitionA) {
            return true;
        }

        // does not include nums[i] in set A
        return canPartitionIntoTwoEqualSum(nums, i+1, currentSetASum, totalSum);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3,3,3,4,5};
        boolean ans = sol.canPartitionDp(nums);
        System.out.println(ans);
    }

}
