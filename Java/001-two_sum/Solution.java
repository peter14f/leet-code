import java.util.Arrays;
import java.util.HashMap;


public class Solution {
    
    // O(n) solution
    public int[] twoSum_2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // key is the number in the array
        // value is the index of the number in the array 
        
        /* If the same number appears multiple times in the array, what the
         * HashMap ends up saving is the highest index that contains the number 
         */
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i); // number, index
        }
        
        /* We traverse from index zero because the HashMap stores the highest
         * index in the array that contains the number
         * 
         * This way we make sure that the first number in the ans array is the 
         * smaller number. The second number is obtained from the HashMap
         */
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            
            if (map.containsKey(diff) && map.get(diff) != i) {
                int[] ans = new int[2];
                ans[0] = i + 1;
                ans[1] = map.get(diff) + 1;
                return ans;
            }
            
        }
        return new int[2];
    }
    
    // O(nlogn) solution
    public int[] twoSum(int[] nums, int target) {
        
        int[] copy = new int[nums.length];
        
        System.arraycopy(nums, 0, copy, 0, nums.length);
        
        Arrays.sort(copy);
        
        int left = 0;
        int right = nums.length - 1;
        int numA = 0;
        int numB = 0;
        
        int[] ans = new int[2];
        
        while (left < right) {
            int sum = copy[left] + copy[right];
            
            if (sum == target) {
                numA = copy[left];
                numB = copy[right];
                break;
            }
            else if (sum > target) {
                right--;
            }
            else {
                left++;
            }
        }
        
        for (int i=0; i< nums.length; i++) {
            if (nums[i] == numA && ans[0]==0)
                ans[0] = i+1;
            else if (nums[i] == numB && ans[1]==0)
                ans[1] = i+1;
        }
        
        if (ans[0] > ans[1]) {
            int temp = ans[0];
            ans[0] = ans[1];
            ans[1] = temp;
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        //int[] nums = {2, 7, 11, 15};
        int[] nums = {3, 2, 4}; //6
        //int[] nums = {0, 4, 3, 0}; // 1 2 3 4
        Solution sol = new Solution();
        
        int[] ans = sol.twoSum_2(nums, 6);
        
        System.out.println(Arrays.toString(ans));
        
    }

}
