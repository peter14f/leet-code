import java.util.Arrays;


public class Solution {

    public int findDuplicate(int[] nums) {
        
        int l = 1;
        int h = nums.length-1;
        
        while (l < h) {
            int m = l + (h-l)/2;
            
            int cnt = 0;
            
            for (int i=0; i<nums.length; i++) {
                if (nums[i] <= m)
                    cnt++;
            }
            
            if (cnt <= m) {
                // repeated value must be in [m+1, h]
                l = m + 1;
            }
            else {
                // repeated value must be in [l, m]
                h = m;
            }
                
        }
        
        return h;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        
        Solution sol = new Solution();
        int dup = sol.findDuplicate(nums);
        
        System.out.println(dup);
    }

}
