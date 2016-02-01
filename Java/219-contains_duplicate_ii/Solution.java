import java.util.HashMap;


public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> lastIndex = new HashMap<Integer, Integer>();
        
        for (int i=0; i<nums.length; i++) {
            if (lastIndex.containsKey(nums[i])) {
                int lastSeen = lastIndex.get(nums[i]);
                if (i - lastSeen <= k)
                    return true;
            }
            
            lastIndex.put(nums[i], i);
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 4, 5, 6};
        Solution sol = new Solution();
        boolean dup = sol.containsNearbyDuplicate(nums, 1);
        System.out.println(dup);
    }

}
