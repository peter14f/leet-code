
public class Solution {

    /* every element appears three times except for one
     * {a, a, b, a}
     * 
     */
    public int singleNumber(int[] nums) {
       int[] bits = new int[32];
       int result = 0;
       
       for (int i=0; i<nums.length; i++) {
           for (int shift=0; shift<32; shift++) {
               bits[shift] += (nums[i] >> shift) & 1;
               if (bits[shift] == 3)
                   bits[shift] = 0;
           }
       }
       
       for (int shift=0; shift<32; shift++) {
           result = result | (bits[shift] << shift);
       }
       
       return result;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-1, -1, -1, 5, 4, 5, 5};
        
        System.out.println(sol.singleNumber(nums));
    }

}
