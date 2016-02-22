import java.util.Arrays;


public class Solution {

    public void moveZeroes(int[] nums) {
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                int r = i+1;
                int l = i;
                
                while (r < nums.length) {
                    if (nums[r] != 0) {
                        int t = nums[r];
                        nums[r] = 0;
                        nums[l] = t;
                        
                        r++;
                        l++;
                        
                    }
                    else {
                        // skip this for now, it will be processed later anyways
                        r++;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 2, 3};
        
        Solution sol = new Solution();
        
        sol.moveZeroes(nums);
        
        System.out.println(Arrays.toString(nums));
    }

}
