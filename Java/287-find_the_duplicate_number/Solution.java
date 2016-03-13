    import java.util.Arrays;


public class Solution {

    public int findDuplicate(int[] nums) {
        
        for (int i=0; i<nums.length; i++) {
            int index = nums[i] - 1;
            
            if (i != index) {
                
                if (nums[index] == nums[i])
                    return nums[i];
                else {
                    swap(nums, i, index);
                    i--; // decrement i because we want to check the new nums[i] again
                }
            }
        }
        
        return Integer.MIN_VALUE;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        
        Solution sol = new Solution();
        int dup = sol.findDuplicate(nums);
        
        System.out.println(dup);
    }

}
