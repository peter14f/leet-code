import java.util.ArrayList;
import java.util.List;

public class SolutionSwap {

public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        getPermutations(nums, 0, result);
        
        return result;
    }
    
    private void getPermutations(int[] nums, int start, List<List<Integer>> result) {
        
        if (start == nums.length) {
            List<Integer> permutation = toArrayList(nums);
            result.add(permutation);
            return;
        }
        
        for (int i=start; i<nums.length; i++) {
            swap(nums, start, i);
            getPermutations(nums, start+1, result);
            swap(nums, start, i);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private List<Integer> toArrayList(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<nums.length; i++)
            list.add(nums[i]);
        return list;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        SolutionSwap sol = new SolutionSwap();
        List<List<Integer>> permutations = sol.permute(nums);
        System.out.println(permutations);
    }
}
