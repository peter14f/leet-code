public class Solution {

    public int findUnsortedSubarray(int[] nums) {
        if (nums.length <= 1) return 0;

        int end = nums.length - 1;
        int start = 0;

        while (end - 1 >= 0 && nums[end] >= nums[end-1]) {
            end--;
        }

        while (start + 1 < nums.length && nums[start+1] >= nums[start]) {
            start++;
        }

        if (end <= start) {
            return 0;
        }

        int max = nums[start];
        int min = nums[start];

        for (int i=start+1; i<=end; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }

        for (int i=start-1; i >= 0; i--) {
            if (nums[i] > min) {
                start = i;
            }
        }

        for (int i=end+1; i < nums.length; i++) {
            if (nums[i] < max) {
                end = i;
            }
        }

        return end - start + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,3,3};
        // 1, 3, 2, 2, 2
        // 1, 3, 2, 2, 4
        // 1, 3, 2, 3, 3
        
        Solution sol = new Solution();
        int ans = sol.findUnsortedSubarray(arr);
        System.out.println(ans);
    }

}
