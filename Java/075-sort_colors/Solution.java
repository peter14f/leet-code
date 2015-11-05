import java.util.Arrays;


public class Solution {

    /* 0 - red
     * 1 - white
     * 2 - blue
     * 
     */
    public void sortColors(int[] nums) {
        
        int twoIndex = -1;
        int oneIndex = -1;
        int zeroIndex = -1;
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndex++;
                oneIndex++;
                twoIndex++;
            }
            else if (nums[i] == 1) {
                oneIndex++;
                twoIndex++;
            }
            else {
                // 2
                twoIndex++;
            }
            
            if (twoIndex >= 0 && nums[twoIndex] != 2)
                nums[twoIndex] = 2;
            
            if (oneIndex >= 0 && nums[oneIndex] != 1)
                nums[oneIndex] = 1;
                
            if (zeroIndex >= 0 && nums[zeroIndex] != 0) 
                nums[zeroIndex] = 0;
            
        }
    }
    
    /**
     * 1
     * 
     * zero -1
     * one 0
     * two 0
     * 
     * [1, 
     * 
     * 1
     * 
     * zero -1
     * one 1
     * two 1
     * 
     * [1, 1,
     * 
     * 0
     * zero 0
     * one 2
     * two 2
     * 
     * [0, 1, 1,
     * 
     * 1
     * zero 0
     * one 3
     * two 3
     * [0, 1, 1, 1,
     * 
     * 2
     * zero 0
     * one 3
     * two 4
     * [0, 1, 1, 1, 2,
     * 
     * 0
     * zero 1
     * one 4
     * two 5
     * [0, 0, 1, 1, 1, 2
     */
    
    public static void main(String[] args) {
        
        Solution sol = new Solution();
        int[] nums = {1, 1, 0, 1, 2, 0, 1, 2, 0, 2};
        sol.sortColors(nums);
        
        System.out.println(Arrays.toString(nums));
    }

}
