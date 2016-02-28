import java.util.Arrays;


public class Solution {

    public static int maxCoins(int[] nums) {
        
        int[] numbers = new int[nums.length + 2];
        int n = numbers.length;
        numbers[0] = 1;
        numbers[n-1] = 1;
        
        for (int i=1; i<=nums.length; i++)
            numbers[i] = nums[i-1];
        
        int[][] dp = new int[n][n];
        
        // start is the leftmost choice when we consider 1 choice
        for (int start=1; start<=nums.length; start++) {
            dp[start-1][start+1] = numbers[start-1]*numbers[start]*numbers[start+1];
        }
        
        
        // think of l as the number of choices
        for (int l=2; l<=nums.length; l++) {
            
            // start is the leftmost choice when we consider l choicess
            for (int start=1; start<=nums.length; start++) {
                
                int left = start-1;
                int right = start+l;
                
                if (right >= n) {
                    // cannot write to dp[left][right]
                    continue;
                }
                
                int max = 0;
                
                // k is the last balloon to burst, again given l choices starting at start
                for (int k=start; k<start+l; k++) {
                    
                    int lastBurstCredits = numbers[left]*numbers[k]*numbers[right];
                    
                    int leftMostCredits = 0;
                    
                    if (k-1 > left) {
                        leftMostCredits = dp[left][k];
                    }
                    
                    int rightMostCredits = 0;
                    
                    if (k+1 < right) {
                        rightMostCredits=dp[k][right];
                    }
                    
                    int totalCredits = lastBurstCredits + leftMostCredits + rightMostCredits;
                    
                    max = Math.max(max, totalCredits);
                }
                
                dp[left][right] = max;
            }
            
        }
        
        // System.out.println(Arrays.deepToString(dp));
        
        return dp[0][n-1];
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3, 1, 5, 8};
        
        int max = sol.getMaxNum(nums);
        System.out.println(max);
    }

}
