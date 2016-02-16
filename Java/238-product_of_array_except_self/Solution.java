import java.util.Arrays;


public class Solution {

    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0)
            return nums;
        int n = nums.length;
        // output array does not count toward memory constraint
        int[] output = new int[n];
        
        int[] forward = new int[n];
        int[] backward = new int[n];
        
        forward[0] = 1;
        backward[n-1] = 1;
        
        for (int i=1; i<n; i++) {
            forward[i] = forward[i-1] * nums[i-1];
            backward[n-1-i] = backward[n-i] * nums[n-i];
        }
        
        for (int i=0; i<n; i++) {
            output[i] = forward[i] * backward[i];
        }
        
        return output;
    }
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Solution sol = new Solution();
        int[] output = sol.productExceptSelf(nums);
        System.out.println(Arrays.toString(output));
    }

}
