
public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxInARow = 0;

        int n = nums.length;
        if (n < 1) {
            return 0;
        }
        maxInARow = nums[0];

        for (int i=1; i<n; i++) {
            if (nums[i] == 1) {
                nums[i] = nums[i - 1] + 1;
                if (nums[i] > maxInARow) {
                    maxInARow = nums[i];
                }
            }
        }
        return maxInARow;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        Solution sol = new Solution();
        int ans = sol.findMaxConsecutiveOnes(nums);
        System.out.println(ans);
    }

}
