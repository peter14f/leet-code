import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> workingList = new ArrayList<Integer>();
        int curSum = 0;
        
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, workingList, curSum, ans);
        
        return ans;
    }
    
    private void combinationSum2(int[] candidates, int target, int index, List<Integer> workingList, 
                                 int curSum, List<List<Integer>> ans) {
        
        int num = candidates[index];
        
        if (curSum + num == target) {
            workingList.add(num);
            ans.add(new ArrayList<Integer>(workingList));
            workingList.remove(workingList.size() - 1);
        }
        else if (curSum + num < target) {
            // choose not to include num
            int d = 1;
            
            while (index + d < candidates.length && candidates[index+d] == num) {
                d++;
            }
            if (index + d < candidates.length)
                combinationSum2(candidates, target, index + d, workingList, curSum, ans);
            
            // include num
            workingList.add(num);
            if (index + 1 < candidates.length)
                combinationSum2(candidates, target, index + 1, workingList, curSum + num, ans);
            workingList.remove(workingList.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2};
        int target = 3;
        Solution sol = new Solution();
        List<List<Integer>> ans = sol.combinationSum2(nums, target);
        System.out.println(ans);
    }

}
