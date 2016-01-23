
public class Solution {

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
        
        int[] moneyRobbed = new int[nums.length];        
        moneyRobbed[0] = nums[0];
        moneyRobbed[1] = Math.max(nums[0], nums[1]);
        
        for (int i=2; i<nums.length; i++) {
            int a = moneyRobbed[i-2] + nums[i];
            int b = moneyRobbed[i-1];
            
            moneyRobbed[i] = Math.max(a, b);
        }
        
        return moneyRobbed[nums.length-1];
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        Solution sol = new Solution();
        int totalMoney = sol.rob(nums);
        System.out.println(totalMoney);
    }

}
