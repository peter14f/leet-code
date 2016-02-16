import java.util.Arrays;


public class SolutionB {

    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0)
            return nums;
        int n = nums.length;
        // output array does not count toward memory constraint
        int[] output = new int[n];
        
        output[0] = 1;
        // going forward
        for (int i=1; i<n; i++) {
            output[i] = output[i-1] * nums[i-1];
        }
        
        int p = 1;
        output[n-1] = p * output[n-1];
        
        for (int i=n-2; i>=0; i--) {
            p = p*nums[i+1];
            output[i] = p * output[i];
        }
        
        return output;
    }
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        SolutionB sol = new SolutionB();
        int[] output = sol.productExceptSelf(nums);
        System.out.println(Arrays.toString(output));
    }

}
