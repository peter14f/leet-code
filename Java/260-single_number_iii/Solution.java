import java.util.Arrays;


public class Solution {

    public int[] singleNumber(int[] nums) {
        int x = 0;
        
        for (int i=0; i<nums.length; i++) {
            x = x ^ nums[i];
        }
        
        /*  x = a ^ b
         *  
         *  a and b are different numbers so x must have some bit that's set
         */
        
        int mask = 1;
        while ((x & mask) == 0) {
            mask = mask << 1;
        }
        
        // mask now contains the bit where a and b are different
        
        int a = 0; // the number whose kth bit is not set
        int b = 0; // the number whose kth bit is set
        
        // find the first number in the array whose bit k is not set
        for (int i=0; i<nums.length; i++) {
            if ((nums[i] & mask) == 0) {
                a = a ^ nums[i];
            }
            else {
                b = b ^ nums[i];
            }
        }
                
        int[] ans = {a, b};
        return ans;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        Solution sol = new Solution();
        int[] ans = sol.singleNumber(nums);
        System.out.println(Arrays.toString(ans));
        
    }

}
