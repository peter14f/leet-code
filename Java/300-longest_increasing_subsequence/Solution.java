
public class Solution {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        
        if (n==0)
            return 0;
            
        /* here ith character
         * 
         * i=1 -> 1st number -> nums[0]
         * i=2 -> 2nd number -> nums[1]
         * 
         * length of the longest subsequence ending with ith character
         * 
         */
        int[] lenSubseqEnding = new int[n+1];
        
        lenSubseqEnding[0] = 0;
        lenSubseqEnding[1] = 1;
        
        for (int i=2; i<=n; i++) {
            // initialize to 1 since in the worst case the subsequence
            // contains the ith character only
            lenSubseqEnding[i] = 1;
            
            for (int j=1; j<i; j++) {
                if (nums[i-1] > nums[j-1]) {
                    lenSubseqEnding[i] = Math.max(lenSubseqEnding[i], lenSubseqEnding[j] + 1);
                }
                // else ith number not larger than jth number, 
                // cannot append ith num to this subsequence
            }
        }
        
        int ans = 0;
        
        for (int i=1; i<=n; i++) {
            ans = Math.max(ans, lenSubseqEnding[i]);
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Solution sol = new Solution();
        int longestSubseqLength = sol.lengthOfLIS(nums);
        System.out.println(longestSubseqLength);
    }

}
