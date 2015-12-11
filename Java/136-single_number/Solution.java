
public class Solution {

    /* asked to do a O(n) time solution
     * every element appears twice except for one
     */
    public int singleNumber(int[] nums) {
        
        int single = 0;
        
        for (int i=0; i<nums.length; i++) {
            single = single ^ nums[i];
        }
        
        return single;
    }
    
    public static void main(String[] args) {
        
        int[] nums = {1, 1, 2};
        
        Solution sol = new Solution();
        
        int s = sol.singleNumber(nums);
        System.out.println(s);
    }

}
