
public class Solution {

    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        int maxSize = 0;
        
        for (int i=0; i<n; i++) {
            int sum = nums[i];
            
            if (sum == k && 1 > maxSize)
                maxSize = 1;
            
            for (int j=i+1; j<n; j++) {
                sum = sum + nums[j];
                
                if (sum == k && (j-i+1) > maxSize) {
                    maxSize = j-i+1;
                }
                
            }
        }
        
        return maxSize;
    }
    
    public static void main(String[] args) {
        int[] nums = {-1};
        Solution sol = new Solution();
        int maxLen = sol.maxSubArrayLen(nums, -1);
        System.out.println("maxLen=" + maxLen);
    }

}
