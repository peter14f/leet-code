import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SolutionRecursion {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> curList = new ArrayList<Integer>();
        
        Arrays.sort(nums);
        
        if (nums.length==0) {
            ans.add(new ArrayList<Integer>()); // empty set
            return ans;
        }
        
        getSubsets(nums, 0, curList, ans);
        return ans;
    }
    
    private void getSubsets(int[] nums, 
                            int index, 
                            List<Integer> curList, 
                            List<List<Integer>> ans) {
        
        curList.add(nums[index]);
        
        if (index==nums.length-1) {
            ans.add(new ArrayList<Integer>(curList));
        }
        else {
            getSubsets(nums, index+1, curList, ans);
        }
        
        curList.remove(curList.size() - 1);
        
        if (index==nums.length-1) {
            ans.add(new ArrayList<Integer>(curList));
        }
        else {
            getSubsets(nums, index+1, curList, ans);
        }
    }
    
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        Solution sol = new Solution();
        List<List<Integer>> subsets = sol.subsets(nums);
        System.out.println(subsets);
    }

}
