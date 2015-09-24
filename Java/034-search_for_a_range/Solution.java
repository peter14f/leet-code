import java.util.Arrays;


public class Solution {

    // algorithm's runtime complexity must be O(logn)
    // return {-1, -1} if target not found in nums
    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        
        int l = 0;
        int h = nums.length - 1;
        
        while (l<=h) {
            int m = l + (h-l)/2;
            
            if (target == nums[m]) {
                range[0] = m;
                range[1] = m;
                findLowIndex(nums, target, m, range);
                findHighIndex(nums, target, m, range);
                return range;
            }
            else if (target > nums[m]) {
                l = m + 1;
            }
            else {
                h = m - 1;
            }
        }
        
        return range;
    }
    
    private void findLowIndex(int[] nums, int target, int m, int[] range) {
        int h = m - 1;
        int l = 0;
        
        while (l <= h) {
            int middle = l + (h-l)/2;
            
            if (target == nums[middle]) {
                range[0] = middle;
                findLowIndex(nums, target, middle, range);
                return;
            }
            else if (target > nums[middle]) {
                l = middle + 1;
            }
            else {
                throw new AssertionError();
            }
        }
    }
    
    private void findHighIndex(int[] nums, int target, int m, int[] range) {
        int h = nums.length - 1;
        int l = m + 1;
        
        while (l <= h) {
            int middle = l + (h-l)/2;
            
            if (target == nums[middle]) {
                range[1] = middle;
                findHighIndex(nums, target, middle, range);
                return;
            }
            else if (target < nums[middle]) {
                h = middle - 1;
            }
            else {
                throw new AssertionError();
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution sol = new Solution();
        
        int[] range = sol.searchRange(nums, 1);
        
        System.out.println(Arrays.toString(range));
    }

}
