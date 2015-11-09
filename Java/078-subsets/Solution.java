import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        
        if (nums==null || nums.length==0) {
            return subsets;
        }
        
        Arrays.sort(nums);
        
        // empty set
        subsets.add(new ArrayList<Integer>());
        
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            int numSets = subsets.size();
            
            for (int j=0; j<numSets; j++) {
                List<Integer> includeNum = new ArrayList<Integer>(subsets.get(j));
                includeNum.add(num);
                subsets.add(includeNum);
            }
        }
        
        return subsets;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 1, 3};
        Solution sol = new Solution();
        List<List<Integer>> subsets = sol.subsets(nums);
        System.out.println(subsets);
    }

}
