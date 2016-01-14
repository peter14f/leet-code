import java.util.HashMap;


public class Solution {

    public int majorityElement(int[] nums) {
        int threshold = nums.length/2;
        
        HashMap<Integer, Integer> histogram = new HashMap<Integer, Integer>();
        
        for (int i=0; i<nums.length; i++) {
            if (histogram.containsKey(nums[i])) {
                histogram.put(nums[i], histogram.get(nums[i])+1);
            }
            else {
                histogram.put(nums[i], 1);
            }
            
            if (histogram.get(nums[i]) > threshold)
                return nums[i];
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1};
        int ans = sol.majorityElement(nums);
        System.out.println(ans);
    }

}
