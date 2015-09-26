import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> workingList = new ArrayList<Integer>();
        int curSum = 0; // current sum in working list
        
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, workingList, curSum, ans);
        
        return ans;
    }
    
    private void combinationSum(int[] candidates, int target, int index, 
                                List<Integer> workingList, int curSum,
                                List<List<Integer>> ans) {
        
        int num = candidates[index];
        
        if (curSum + num == target) {
            workingList.add(num);
            ans.add(new ArrayList<Integer>(workingList));
            workingList.remove(workingList.size() - 1);
        }
        else if (curSum + num < target) {
            
            // do not include num
            if (index + 1 < candidates.length)
                combinationSum(candidates, target, index + 1, workingList, curSum, ans);
            
            // include num up to n times
            int newSum = curSum + num;
            int cnt = 0;
            
            while (newSum < target) {
                cnt++;
                workingList.add(num);
                if (index + 1 < candidates.length)
                    combinationSum(candidates, target, index + 1, workingList, newSum, ans);
                
                newSum += num;
            }
            
            if (newSum == target) {
                workingList.add(num);
                ans.add(new ArrayList<Integer>(workingList));
                workingList.remove(workingList.size() - 1);
            }
            
            for (int i=0; i<cnt; i++) {
                workingList.remove(workingList.size() - 1);
            }
        }
        
    }
    
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 2;
        
        Solution sol = new Solution();
        List<List<Integer>> ans = sol.combinationSum(nums, target);
        
        System.out.println(ans);
    }

}
