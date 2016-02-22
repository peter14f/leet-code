import java.util.Arrays;


public class SolutionB {

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        
        for (int i=0; i<nums.length; i++) {
            if ((i % 2) == 0) {
                // even index
                if (i+1 < n && nums[i] > nums[i+1]) {
                    swap(nums, i, i+1);
                }
            }
            else {
                // odd index
                if (i+1 < n && nums[i] < nums[i+1]) {
                    swap(nums, i, i+1);
                }
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 6, 4};
        
        SolutionB sol = new SolutionB();
        sol.wiggleSort(nums);
        
        System.out.println(Arrays.toString(nums));
    }

}
