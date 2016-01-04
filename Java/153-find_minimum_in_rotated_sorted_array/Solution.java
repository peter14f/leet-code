
public class Solution {

    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        
        while (h >= l) {
            if (h==l)
                return nums[l];
            else if (h == l + 1) {
                if (nums[h] > nums[l])
                    return nums[l];
                else
                    return nums[h];
            }
                
            
            if (nums[h] > nums[l]) {
                return nums[l];
            }
            
            int m = l + (h-l)/2;
            
            if (nums[m] > nums[l]) {
                l = m + 1;
            }
            else {
                h = m;
            }
        }
        
        return Integer.MIN_VALUE;
    }
    
    public static void main(String[] args) {
        int[] nums = {7, 1, 2, 3, 4, 5, 6};
        Solution sol = new Solution();
        int min = sol.findMin(nums);
        System.out.println(min);
    }

}
