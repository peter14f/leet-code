import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        
        for (int i=0; i<nums.length - 3; i++) {
            int smallNum = nums[i];
            
            if (i-1 >= 0 && smallNum == nums[i-1]) {
                continue;
            }
            
            int targetThreeSum = target - smallNum;
            
            List<List<Integer>> listThreeSum = threeSum(nums, targetThreeSum, i+1);
            
            if (!listThreeSum.isEmpty()) {
                for (List<Integer> list : listThreeSum) {
                    list.add(0, smallNum);
                    ans.add(list);
                }
            }
        }
        
        return ans;
    }
    
    
    // nums has been sorted already
    public List<List<Integer>> threeSum(int[] nums, int target, int start) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        for (int i=start; i<nums.length - 2; i++) {
            
            int smallNum = nums[i];
            
            if (i-1 >= start && smallNum == nums[i-1]) {
                continue;
            }
            
            int targetTwoSum = target - smallNum;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int twoSum = nums[left] + nums[right];
                
                if (twoSum == targetTwoSum) {
                    List<Integer> pair = new ArrayList<Integer>();
                    pair.add(smallNum);
                    pair.add(nums[left]);
                    pair.add(nums[right]);
                    ans.add(pair);
                    right--;
                    
                    while (right > i && nums[right] == pair.get(2)) {
                        right--;
                    }
                    
                    left++;
                    
                    while (left < nums.length && nums[left] == pair.get(1)) {
                        left++;
                    }
                }
                else if (twoSum > targetTwoSum) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        //[-9,4,0,-3,6,3,-3,-9,-7,1,0,-7,-8,7,1], -9
        
        Solution sol = new Solution();
        int[] nums = {-9,4,0,-3,6,3,-3,-9,-7,1,0,-7,-8,7,1};
        
        List<List<Integer>> ans = sol.fourSum(nums, -9);
        
        System.out.println(ans);
    }
    
}
