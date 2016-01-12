import java.util.Arrays;


public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int[] ans = {-1, -1};
        
        int r = numbers.length - 1;
        int l = 0;
        
        while (r > l) {
            int sum = numbers[l] + numbers[r];
            
            if (sum == target) {
                ans[0] = l + 1;
                ans[1] = r + 1;
                break;
            }
            else if (sum > target) {
                r--;
            }
            else {
                l++;
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        Solution sol = new Solution();
        int[] ans = sol.twoSum(nums, 9);
        System.out.println(Arrays.toString(ans));
    }

}
