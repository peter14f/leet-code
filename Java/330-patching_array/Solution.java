

public class Solution {

    public int minPatches(int[] nums, int n) {
        
        // integers in range [0, miss) is covered
        long miss = 1;
        
        int i = 0;
        int numPatches = 0;
        
        while (miss <= n) {
            if (i < nums.length && nums[i]<=miss) {
                miss += nums[i];
                i++;
            }
            else {
                miss = miss + miss;
                numPatches++;
            }
        }
        
        return numPatches;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 31, 33};
        
        int numPatches = sol.minPatches(nums, 2147483647);
        
        System.out.println(numPatches);
        
    }

}
