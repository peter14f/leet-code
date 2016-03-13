
public class SolutionSwap {

    public int missingNumber(int[] nums) {
        
        for (int i=0; i<nums.length; i++) {
            int index = nums[i]; // this is the index nums[i] should be placed
            
            if (index !=i && index < nums.length) {
                swap(nums, i, index);
                i--; // decrement i because we want to check if the new nums[i] is at its
                     // bucket as well
            }
        }
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        
        // means that from for i in 0... nums.length-1, nums[i] = i
        // the missing number must be nums.length
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
