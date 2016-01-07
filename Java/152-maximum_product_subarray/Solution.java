import java.util.Arrays;


public class Solution {

    /* the array may contain 0
     * the array may contain negative numbers
     */
    public int maxProduct(int[] nums) {
        if (nums==null || nums.length < 1)
            return 0;
        
        int max = nums[0];
        
        
        int[] maxProduct = new int[nums.length];
        int[] minProduct = new int[nums.length];
        
        /* maxProduct[i] is the largest product of some contiguous elements from [0, i] 
         * with the ith element included.
         * 
         * minProduct[i] is the smallest product of some contiguous elements from [0, i] 
         * with the ith element included.
         */
        
        maxProduct[0] = nums[0];
        minProduct[0] = nums[0];
        
        for (int i=1; i<nums.length; i++) {
            maxProduct[i] = Math.max(nums[i], Math.max(maxProduct[i-1]*nums[i], minProduct[i-1]*nums[i]));
            minProduct[i] = Math.min(nums[i], Math.min(maxProduct[i-1]*nums[i], minProduct[i-1]*nums[i]));
            
            if (maxProduct[i] > max)
                max = maxProduct[i];
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
