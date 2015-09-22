import java.util.Arrays;


public class Solution {

    // 6 5 4 3 2 1
    // 5 1 1
    //   P       C
    // 6 1 5 4 3 2
    // 6 2 5 4 3 1
    // 6 2 1 3 4 5
    public void nextPermutation(int[] nums) {
        int partitionIndex = -1;
        
        for (int i=nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                partitionIndex = i;
                break;
            }
        }
        
        if (partitionIndex == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        int changeIndex = -1;
        
        for (int i=nums.length - 1; i > partitionIndex; i--) {
            if (nums[i] > nums[partitionIndex]) {
                changeIndex = i;
                break;
            }
        }
        
        int temp = nums[changeIndex];
        nums[changeIndex] = nums[partitionIndex];
        nums[partitionIndex] = temp;
        
        reverse(nums, partitionIndex + 1, nums.length - 1);
    }
    
    /* reverses a section of the array num
     * start marks the starting index of the section
     * end marks the ending index of the section
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {6, 1, 5, 4, 3, 2};
        Solution sol = new Solution();
        sol.nextPermutation(nums);
        
        System.out.println(Arrays.toString(nums));
    }
}
