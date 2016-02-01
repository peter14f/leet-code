import java.util.ArrayList;
import java.util.List;


public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if (k<=0)
            return ans;
        
        List<Integer> choices = new ArrayList<Integer>();
        
        for (int i=1; i<=9; i++)
            choices.add(i);
        
        combinationSum(choices, 0, n, k, new ArrayList<Integer>(), 0, ans);
        
        return ans;
    }
    
    private void combinationSum(List<Integer> choices, 
                                int index,
                                int target, int size, 
                                List<Integer> curList, int curSum,
                                List<List<Integer>> ans) {
        
        if (index==choices.size())
            return;
        
        // choose to include choice at index
        int choice = choices.get(index);
        int newSum = curSum + choice;
        int newSize = curList.size() + 1;
        
        if (newSum <= target && newSize <= size) {
            curList.add(choice);
            
            if (newSum == target && newSize == size) {
                ans.add(new ArrayList<Integer>(curList));
            }
            else {
                combinationSum(choices, index+1, target, size, curList, newSum, ans);
            }
            
            curList.remove(curList.size()-1);
        }
        
        // choose not to include choice at index
        combinationSum(choices, index+1, target, size, curList, curSum, ans);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> ans = sol.combinationSum3(4, 1);
        System.out.println(ans);
    }

}
