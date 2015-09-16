import java.util.Arrays;


public class Solution {
    
    /**
     * have two pointers: end, i
     * elements at indices <= end are sorted and are all unique
     * 
     */
    public int removeDuplicates(int[] nums) {
        int end = 0;
        
        for (int i = 1; i<nums.length; i++) {
            
            if (nums[i] != nums[end]) {
                end++;
                if (end != i)
                    nums[end] = nums[i];
            }
        }
        
        return end + 1;
    }
    
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1};
        
        Solution sol = new Solution();
        int len = sol.removeDuplicates(a);
        
        System.out.println(len);
        System.out.println(Arrays.toString(a));
    }

}
