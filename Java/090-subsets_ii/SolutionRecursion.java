import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SolutionRecursion {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if (nums.length == 0) {
            ans.add(new ArrayList<Integer>());
            return ans;
        }
        
        Arrays.sort(nums);
        List<Integer> curList = new ArrayList<Integer>();
        getSubsetsWithDup(nums, 0, curList, ans);
        
        return ans;
    }
    
    private void getSubsetsWithDup(
            int[] nums, 
            int index, 
            List<Integer> curList, 
            List<List<Integer>> ans) {
        
        // choose not to include index
        if (index == nums.length - 1) {
            ans.add(new ArrayList<Integer>(curList));
        }
        else {
            int d = 1;
            while (index+d < nums.length && nums[index + d] == nums[index]) {
                d++;
            }
            
            if (index+d < nums.length) {
                getSubsetsWithDup(nums, index+d, curList, ans);
            }
            else {
                ans.add(new ArrayList<Integer>(curList));
            }
        }
        
        // choose to include index
        curList.add(nums[index]);
        
        if (index == nums.length - 1) {
            ans.add(new ArrayList<Integer>(curList));
        }
        else {
            getSubsetsWithDup(nums, index+1, curList, ans);
        }
        
        curList.remove(curList.size() - 1);
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 1, 1};
        SolutionRecursion sol = new SolutionRecursion();
        List<List<Integer>> subsets = sol.subsetsWithDup(nums);
        System.out.println(subsets);
    }

}
