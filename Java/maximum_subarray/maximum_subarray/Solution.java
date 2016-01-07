package maximum_subarray;

public class Solution {

    public int maxSubarray(int[] nums) {
        if (nums==null || nums.length==0)
            return 0;
        
        int maxSum = nums[0];
        int n = nums.length;
        int start = 0;
        int end = 0;
        int curSum = nums[0];
        
        for (int i=1; i<n; i++) {
            if (curSum < 0 && nums[i] >= curSum) {
                start = i;
                end = i;
                curSum = nums[i];
            }
            else {
                curSum += nums[i];
                end = i;
            }
            
            if (curSum > maxSum)
                maxSum = curSum;
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] nums = {-2, -1};
        Solution sol = new Solution();
        int s = sol.maxSubarray(nums);
        System.out.println(s);
    }

}
