
public class Solution {

    
    /*
     *  1, 1, 2, 3, 4, 5, 6, 7
     *  1, 2, 3, 4, 5, 6, 7, 1
     *  3, 4, 5, 6, 7, 1, 1, 2
     *  4, 5, 6, 7, 1, 1, 2, 3
     *  5, 6, 7, 1, 1, 2, 3, 4
     *  6, 7, 1, 1, 2, 3, 4, 5
     *  7, 1, 1, 2, 3, 4, 5, 6
     */
    public boolean search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        
        while (l<=h) {
            int m = l + (h-l)/2;
            System.out.println("l=" + l + " h=" + h + " m=" + m);
            
            if (nums[m] == target) {
                return true;
            }
            
            if (nums[l] < nums[m]) {
                // we're sure that l to m is sorted
                if (target >= nums[l] && target < nums[m]) {
                    // target lies within the sorted range
                    h = m -1;
                }
                else {
                    // if target exists, it's in the other half
                    l = m + 1;
                }
            }
            else if (nums[h] > nums[m]) {
                // we're sure that m to h is sorted
                if (target > nums[m] && target <= nums[h]) {
                    l = m + 1;
                }
                else {
                    // if target exists, it's in the other half
                    h = m - 1;
                }
            }
            else {
                // cannot determine which half is sorted
                if (nums[h]==target)
                    return true;
                // h is also not the answer, decrement h now
                // note that in this particular step, we're going
                // eliminating the input set by one element
                h--;
            }
        }
        
        return false;
    }
    
    /**
     * TC251: [1, 3]          3
     * TC269: [1, 3, 1, 1, 1] 3
     * 
     * l=0 h=4 m=2
     * 
     */
    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 1, 1};
        Solution sol = new Solution();
        boolean exists = sol.search(nums, 3);
        System.out.println(exists);
    }

}
