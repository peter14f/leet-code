import java.util.Arrays;


public class Solution {

    /* the array may contain 0
     * the array may contain negative numbers
     */
    public int maxProduct(int[] nums) {
        if (nums==null || nums.length < 1)
            return 0;
        
        int max = nums[0];
        int[] maxP = new int[nums.length];
        int[] minP = new int[nums.length];
        maxP[0] = nums[0];
        minP[0] = nums[0];
        
        for (int i=1; i<nums.length; i++) {
            maxP[i] = Math.max(nums[i], Math.max(maxP[i-1]*nums[i], minP[i-1]*nums[i]));
            minP[i] = Math.min(nums[i], Math.min(maxP[i-1]*nums[i], minP[i-1]*nums[i]));
            
            if (maxP[i] > max)
                max = maxP[i];
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-2};
        int m = sol.maxProduct(nums);
        System.out.println(m);
    }

}
