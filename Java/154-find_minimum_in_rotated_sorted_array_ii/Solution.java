
public class Solution {

    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        int min = nums[0];
                
        while (h >= l) {
            if (h==l) {
                min = Math.min(min, nums[l]);
                break;
            }
            else if (h == l + 1) {
                min = Math.min(min, Math.min(nums[h], nums[l]));
                break;
            }
                
            
            if (nums[h] > nums[l]) {
                min = Math.min(min, nums[l]);
                break;
            }
            
            int m = l + (h-l)/2;
            
            if (nums[m] > nums[l]) {
                min = Math.min(min, nums[l]);
                l = m + 1;
            }
            else if (nums[m] == nums[l]) {
                l++;
            }
            else if (nums[h] > nums[m]) {
                min = Math.min(min, nums[m]);
                h = m - 1;
            }
            else if (nums[m] == nums[h]) {
                h--;
            }
        }
        
        return min;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 1, 3};
        Solution sol = new Solution();
        int min = sol.findMin(nums);
        System.out.println(min);
    }

}
