import java.util.Arrays;


public class SolutionB {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        
        if (k > n)
            k = k%n;
        
        if (k==0)
            return;
        
        int l = 0;
        int r = n-1;
        
        while (r > l) {
            int tmp = nums[r];
            nums[r] = nums[l];
            nums[l] = tmp;
            
            r--;
            l++;
        }
        
        rotate(nums, 0, k-1);
        rotate(nums, k, n-1);
    }
    
    private void rotate(int[] nums, int low, int high) {
        while (high > low) {
            int tmp = nums[high];
            nums[high] = nums[low];
            nums[low] = tmp;
            
            high--;
            low++;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        Solution sol = new Solution();
        
        sol.rotate(nums, 3);
        
        System.out.println(Arrays.toString(nums));
    }

}
