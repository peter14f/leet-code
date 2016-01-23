
public class Solution {

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        
        // we're robbing the first house and not the last
        int[] profit1 = new int[nums.length-1];
        
        profit1[0] = nums[0];
        profit1[1] = nums[0];
        
        for (int i=2; i<profit1.length; i++) {
            int a = nums[i] + profit1[i-2];
            int b = profit1[i-1];
            profit1[i] = Math.max(a, b);
        }
        
        /* we're not robbing the first house, which means we may 
         * rob the last house
         */
        int[] profit2 = new int[nums.length];
        profit2[0] = 0;
        profit2[1] = nums[1];
        
        for (int i=2; i<profit2.length; i++) {
            int a = nums[i] + profit2[i-2];
            int b = profit2[i-1];
            profit2[i] = Math.max(a, b);
        }
        
        return Math.max(profit1[profit1.length-1], 
                        profit2[profit2.length-1]);
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 100, 1, 1, 1, 1, 1, 1};
        Solution sol = new Solution();
        int profit = sol.rob(nums);
        System.out.println(profit);
    }

}
