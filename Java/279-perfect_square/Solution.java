import java.util.ArrayList;
import java.util.List;


public class Solution {

    public int numSquares(int n) {
        if (n<1)
            return 0;
        
        int sqrt = (int) Math.sqrt(n);
        
        if (sqrt*sqrt == n)
            return 1;
        
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        
        findCombinationSum(1, 0, new ArrayList<Integer>(), n, lists);
        
        //System.out.println(lists);
        
        if (lists.isEmpty())
            return 0;
        
        int min = lists.get(0).size();
        
        for (int i=1; i<lists.size(); i++) {
            if (lists.get(i).size() < min) {
                min = lists.get(i).size();
            }
        }
        
        return min;
    }
    
    private void findCombinationSum(int i, int curSum, List<Integer> curList, 
                                    int target, List<List<Integer>> ans) {
        int squared = i * i;
        
        if (curSum + squared > target)
            return;
        
        int oldCurSum = curSum;
        int toRemove = 0;
        
        while (curSum + squared <= target) {
            curSum += squared;
            curList.add(i);
            
            if (curSum == target) {
                ans.add(new ArrayList<Integer>(curList));
            }
            toRemove++;
            
            if (curSum < target)
                findCombinationSum(i+1, curSum, curList, target, ans);
        }
        
        while (toRemove > 0) {
            curList.remove(curList.size() - 1);
            toRemove--;
        }
        
        findCombinationSum(i+1, oldCurSum, curList, target, ans);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int min = sol.numSquares(210);
        System.out.println(min);
    }

}
