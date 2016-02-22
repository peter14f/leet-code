import java.util.Arrays;


public class Solution {

    public void wiggleSort(int[] nums) {
        
        for (int i=0; i<nums.length; i++) {
            if (i%2 == 0) {
                // find small
                replaceLWithSmallest(nums, i);
            }
            else {
                // find big
                replaceLWithBiggest(nums, i);
            }
        }
    }
    
    private void replaceLWithSmallest(int[] nums, int l) {
        int min = nums[l];
        int minIndex = l;
        
        for (int i=l; i<nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }
        
        int t = nums[l];
        nums[l] = min;
        nums[minIndex] = t;
    }
    
    private void replaceLWithBiggest(int[] nums, int l) {
        int max = nums[l];
        int maxIndex = l;
        
        for (int i=l; i<nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        
        int t = nums[l];
        nums[l] = max;
        nums[maxIndex] = t;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 6, 4};
        Solution sol = new Solution();
        sol.wiggleSort(nums);
        
        System.out.println(Arrays.toString(nums));
    }

}
