import java.util.Arrays;

public class Solution {

    public int findKthLargest(int[] nums, int k) {
        if (k<1 || k>nums.length)
            throw new IllegalArgumentException();
            
        return findKth(nums, 0, nums.length-1, k);
    }
    
    private int findKth(int[] nums, int start, int end,  int k) {
        int pivot = end;
        int left = start;
        int right = end - 1;
        
        while (left <= right) {
            if (nums[left] > nums[pivot]) {
                swap(nums, left, right);
                right--;
            }
            else {
                left++;
            }
        }
        
        // left is the final position where the pivot element should be placed
        swap(nums, left, pivot);
        
        int rank = nums.length - left;
        
        if (rank == k) {
            return nums[left];
        }
        else if (rank > k) {
            return findKth(nums, left+1, end, k);
        }
        else {
            return findKth(nums, start, left-1, k);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(Arrays.toString(nums));
        int ans = sol.findKthLargest(nums, 1);
        System.out.println(ans);
    }

}
