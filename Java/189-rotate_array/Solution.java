import java.util.Arrays;


public class Solution {
    /* 
     * [1, 2, 3, 4, 5, 6, 7] 
     * [      ]
     * 
     */ 
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newNums = new int[n];
        
        for (int i=0; i<n; i++) {
            int from = i-k;
            
            while (from < 0)
                from += n;
            
            newNums[i] = nums[from];
        }
        
        for (int i=0; i<n; i++) {
            nums[i] = newNums[i];
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        Solution sol = new Solution();
        sol.rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

}
