import java.util.Arrays;



public class Solution {

    public int firstMissingPositive(int[] nums) {
        
        // the ideal input array would look like this
        // 
        // [0] [1] [2] [3] [4]
        //  1   2   3   4   5
        //
        // The positive integer x should be put in 
        // index (x - 1)
        // 
        // So we could try to place all the positive integers
        // into the ideal location if possible
        for (int i=0; i<nums.length; i++) {
            // nums[i] is already in its ideal location
            if (nums[i] == i+1)
                continue;
            
            // the ideal location
            int index = nums[i] - 1;
            
            if (index >= 0 &&                /* the ideal index is actually  *
                  index < nums.length &&      * valid                        */
                  nums[i] != nums[index]) {  // swapping doesn't make a difference (duplicate)
                
                swap(nums, i, index);
                i--; // decrement i because we want to examine nums[i] again after the swap
            
            }
        }
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        
        return nums.length+1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        Solution sol = new Solution();
        int ans = sol.firstMissingPositive(nums);
        
        System.out.println(ans);
    }

}
