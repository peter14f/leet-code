
public class Solution {

    public int searchInsert(int[] nums, int target) {
        
        int l = 0;
        int h = nums.length - 1;
        
        int m = 0;
        
        while (l <= h) {
            m = l + (h-l)/2;
            
            if (nums[m] == target) {
                return m;
            }
            else if (nums[m] > target) {
                h = m - 1;
            }
            else {
                l = m + 1;
            }
        }
        
        if (nums[m] < target) {
            return m + 1;
        }
        else {
            return m;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        
        Solution sol = new Solution();
        
        int index = sol.searchInsert(nums, 7);
        
        System.out.println(index);
    }

}
