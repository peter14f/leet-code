import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class Solution {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> curWorkingList = new ArrayList<Integer>();
        boolean[] tried = new boolean[nums.length];
        Arrays.sort(nums);
        
        permuteUnique(nums, tried, curWorkingList, ans);
        
        return ans;
    }
    
    private void permuteUnique(int[] nums, 
                               boolean[] tried, 
                               List<Integer> curWorkingList,
                               List<List<Integer>> ans) {
        
        if (curWorkingList.size() == nums.length) {
            ans.add(new ArrayList<Integer>(curWorkingList));
            return;
        }
        
        for (int i=0; i<nums.length; i++) {
            if (!tried[i]) {
                if (i-1 >= 0 && nums[i] == nums[i-1] && !tried[i-1]) {
                    continue;
                }
                tried[i] = true;
                curWorkingList.add(nums[i]);
                permuteUnique(nums, tried, curWorkingList, ans);
                curWorkingList.remove(curWorkingList.size() - 1);
                tried[i] = false;
            }
        }
    }
    
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 2};
        List<List<Integer>> ans = sol.permuteUnique(nums);
        System.out.println(ans);
    }

}
