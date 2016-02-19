
public class SolutionSwap {

    public int missingNumber(int[] nums) {
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == nums.length) {
                nums[i] = -1;
                i--;
            }
            else if (nums[i] != i && nums[i] >= 0) {
                swap(nums, nums[i], i);
                i--;
            }
        }
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        
        return nums.length;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] nums = {0, 3, 1};
        
        SolutionSwap sol = new SolutionSwap();
        
        int missing =  sol.missingNumber(nums);
        System.out.println(missing);
    }

}
