import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * The trivial solution is O(n^3) time complexity.
 * 
 * A better solution is n*(n log n)
 * 
 * This problem is actually easiser than 3sum since we don't need to
 * worry about duplicates as there is a unique solution.
 * 
 * @author peter
 *
 */
public class Solution {
    
    public int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int closestSum = 0;
        
        Arrays.sort(nums);
        
        for (int i=0; i<nums.length-2; i++) {
            int smallNum = nums[i];
             
            int left = i+1;
            int right = nums.length - 1;
             
            // target for 2sum
            int targetTwo = target - smallNum;
             
            while (left < right) {
                int sum = nums[left] + nums[right];
                 
                if (sum == targetTwo) {
                    return target;
                }
                else if (sum > targetTwo) {
                    if (Math.abs(sum - targetTwo) < minDiff) {
                        closestSum = sum + smallNum;
                        minDiff = Math.abs(sum - targetTwo);
                    }
                    right--;
                }
                else {
                    if (Math.abs(sum - targetTwo) < minDiff) {
                        closestSum = sum + smallNum;
                        minDiff = Math.abs(sum - targetTwo);
                    }
                    left++;
                }
            }
        }
        return closestSum;
    }
    
    public static void main(String[] args) {
        //int[] arr = {-1, 2, 1, -4};
        // 1,1,1,0,  -100
        int[] arr = {1, 1, 0};
        Solution sol = new Solution();
        int closestSum = sol.threeSumClosest(arr, 100);
        System.out.println(closestSum);
    }

}
