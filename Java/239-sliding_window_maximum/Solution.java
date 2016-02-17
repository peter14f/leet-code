import java.util.Arrays;


public class Solution {

    // can assume k to be valid
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return nums;
        
        int[] output = new int[nums.length-k+1];
        
        for (int i=0; i+k-1 < nums.length; i++) {
            int max = nums[i];
            for (int j=1; j<k; j++) {
                if (nums[i+j] > max)
                    max = nums[i+j];
            }
            output[i] = max;
        }
        
        return output;
    }
    
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        Solution sol = new Solution();
        
        int[] output = sol.maxSlidingWindow(nums, 3);
        
        System.out.println(Arrays.toString(output));
    }

}
