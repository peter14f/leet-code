// [0, 1, 2]
public class Solution {

    public boolean canJump(int[] nums) {
        int maxReachableIndex = 0;
        
        for (int i=0; i<=maxReachableIndex; i++) {
            if (i >= nums.length)
                break;
            
            if (i + nums[i] > maxReachableIndex) {
                maxReachableIndex = i+nums[i];
            }
        }
        
        return maxReachableIndex >= nums.length - 1;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] nums = {1, 0, 2, 3, 4, 5, 6};
        boolean ans = sol.canJump(nums);
        
        System.out.println(ans);
    }

}
