import java.util.Arrays;



public class Solution {

    public int firstMissingPositive(int[] nums) {
        
        // at most n numbers will be placed
        for (int i=0; i<nums.length; i++) {
            
            int num = nums[i];
            int newIndex = num - 1;
            
            while (num > 0 && newIndex >= 0 && newIndex < nums.length && nums[newIndex] != num) {
                int temp = nums[newIndex];
                nums[newIndex] = num;
                nums[i] = temp;
                
                num = temp;
                newIndex = num - 1;
            }
        }
        
        int ans = nums.length + 1;
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != i + 1) {
                ans = i + 1;
                break;
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        Solution sol = new Solution();
        int ans = sol.firstMissingPositive(nums);
        
        System.out.println(ans);
    }

}
