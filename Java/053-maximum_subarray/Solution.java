
public class Solution {

    public int maxSubArray(int[] nums) {
        if (nums==null || nums.length==0)
            return 0;
        
        int sum = nums[0];
        int maxSum = nums[0];
        
        for (int i=1; i<nums.length; i++) {
            if (sum < 0 && nums[i] > sum) 
                sum = nums[i];
            else 
                sum += nums[i];
            
            if (sum > maxSum)
                maxSum = sum;
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] nums = {-2, -1, 2};
        Solution sol = new Solution();
        int maxContigSum = sol.maxSubArray(nums);
        System.out.println(maxContigSum);
    }

}
