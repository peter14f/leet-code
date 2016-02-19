
public class Solution {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        int expectedSum = (n+1)*n/2;
        
        int actualSum = 0;
        
        for (int i=0; i<nums.length; i++) {
            actualSum += nums[i];
        }
        
        int difference = expectedSum - actualSum;
        
        return difference;
    }
    
    public static void main(String[] args) {
        int[] nums = {0, 1, 3};
        Solution sol = new Solution();
        int missing = sol.missingNumber(nums);
        System.out.println(missing);
    }

}
