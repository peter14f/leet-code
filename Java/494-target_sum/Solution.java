import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int findTargetSumWaysDP3(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (S < -sum || S > sum) {
            return 0;
        }

        int[] waysToReachSum = new int[sum+sum+1];

        waysToReachSum[sum+nums[0]]++;
        waysToReachSum[sum-nums[0]]++;

        for (int i=1; i<nums.length; i++) {

            int[] next = new int[sum+sum+1];
            for (int curSum=-sum; curSum<=sum; curSum++) {
                int index = curSum + sum;

                if (waysToReachSum[index] > 0) {
                    int newSumA = curSum + nums[i];

                    next[newSumA + sum] += waysToReachSum[index];

                    int newSumB = curSum - nums[i];
                    next[newSumB + sum] += waysToReachSum[index];
                }
            }
            waysToReachSum = next;
        }

        return waysToReachSum[sum + S];
    }
    
    public int findTargetSumWaysDP2(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (S < -sum || S > sum) {
            return 0;
        }

        int[] waysToReachSum = new int[sum+sum+1];
        int[] waysToReachSumOld = new int[sum+sum+1];

        waysToReachSumOld[sum+nums[0]]++;
        waysToReachSumOld[sum-nums[0]]++;

        for (int i=1; i<nums.length; i++) {

            for (int curSum=-sum; curSum<=sum; curSum++) {
                int index = curSum + sum;

                if (waysToReachSumOld[index] > 0) {
                    int newSumA = curSum + nums[i];

                    waysToReachSum[newSumA + sum] += waysToReachSumOld[index];

                    int newSumB = curSum - nums[i];
                    waysToReachSum[newSumB + sum] += waysToReachSumOld[index];
                }
            }

            for (int curSum=-sum; curSum<=sum; curSum++) {
                waysToReachSumOld[curSum + sum] = waysToReachSum[curSum + sum];
                waysToReachSum[curSum + sum] = 0;
            }

        }

        return waysToReachSumOld[sum + S];
    }

    public int findTargetSumWaysDP(int[] nums, int S) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (S < -sum || S > sum) {
            return 0;
        }

        int[][] dp = new int[n+1][2*sum + 1];

        dp[1][nums[0] + sum]++;
        dp[1][-nums[0] + sum]++;

        for (int i=2; i<=n; i++) {
            for (int curSum=-sum; curSum<=sum; curSum++) {
                int index = curSum + sum;
                
                if (dp[i-1][index] > 0) {
                    int a = curSum + nums[i-1];
                    dp[i][a + sum] += dp[i-1][index];
                    
                    
                    int b = curSum - nums[i-1];
                    dp[i][b + sum] += dp[i-1][index];
                }
            }
        }

        //System.out.println(Arrays.deepToString(dp));

        return dp[n][S + sum];
    }

    public int findTargetSumWays(int[] nums, int S) {
        // 2 ^ n total possible choices
        return numWaysSumToTarget(nums, 0, 0, S);
    }

    private int numWaysSumToTarget(int[] nums, int i, int curSum, int target) {
        if (i >= nums.length) {
            if (curSum == target) {
                return 1;
            } else {
                return 0;
            }
        } else {
            int a = numWaysSumToTarget(nums, i+1, curSum+nums[i], target);
            int b = numWaysSumToTarget(nums, i+1, curSum-nums[i], target);
            return a + b;
        }
    }

    private void findAllWaysSumToTarget(int[] nums, int i, int target, List<String> ways, int curSum, StringBuilder sb) {
        if (i == nums.length) {
            if (curSum == target) {
                ways.add(sb.toString());
            }
            return;
        }

        int newSumA = curSum + nums[i];
        sb.append('+');
        findAllWaysSumToTarget(nums, i+1, target, ways, newSumA, sb);
        sb.deleteCharAt(sb.length() - 1);

        int newSumB = curSum - nums[i];
        sb.append('-');
        findAllWaysSumToTarget(nums, i+1, target, ways, newSumB, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        Solution sol = new Solution();
        int ans = sol.findTargetSumWaysDP3(nums, 3);
        System.out.println(ans);

    }

}
