import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (k == 0)
            return ans;
        if (k < 0)
            throw new IllegalArgumentException();
        
        LinkedList<Integer> choices = new LinkedList<Integer>();
        
        for (int i=1; i<=n; i++) {
            choices.add(i);
        }
        
        
        List<Integer> curList = new ArrayList<Integer>();
        
        combine(choices, curList, ans, k);
        
        return ans;
    }
    
    private void combine(
            LinkedList<Integer> choices, 
            List<Integer> curList,
            List<List<Integer>> ans, 
            int k) {

        int numChoices = choices.size();
        Stack<Integer> removed = new Stack<Integer>();
        
        if (numChoices + curList.size() < k)
            return;
        
        for (int i=0; i<numChoices; i++) {
            int choice = choices.removeFirst();
            
            curList.add(choice);
            if (curList.size() == k) {
                ans.add(new ArrayList<Integer>(curList));
            }
            
            if (!choices.isEmpty())
                combine(choices, curList, ans, k);
            
            curList.remove(curList.size() - 1);
            removed.push(choice);
        }
        
        while (!removed.isEmpty()) {
            choices.addFirst(removed.pop());
        }
    }



    public static void main(String[] args) {
        Solution sol = new Solution();
        
        List<List<Integer>> ans = sol.combine(4, 3);
        
        System.out.println(ans);
    }

}
