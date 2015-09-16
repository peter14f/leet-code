import java.util.Arrays;


public class Solution {

    /**
     * Use two pointers: end, j
     * elements in indices <= end do not have the value 'val'
     * 
     * 
     */
    public int removeElement(int[] nums, int val) {
        
        if (nums.length == 0)
            return 0;
        
        int end = -1;
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != val) {
                end++;
                if (end != i)
                    nums[end] = nums[i];
            }
        }
        
        return end+1;
    }
    
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 2};
        
        Solution sol = new Solution();
        int b = sol.removeElement(a, 1);
        System.out.println(b);
        System.out.println(Arrays.toString(a));
    }

}
