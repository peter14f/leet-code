import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Solution {
    
    // insert the current number at all possible positions given the answer to the n-1 problem
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0, nums.length - 1);
    }
    
    private List<List<Integer>> permute(int[] nums, int l, int h) {
        
        if (nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        else if (h-l + 1 == 1) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[l]);
            ans.add(list);
            return ans;
        }
        else {
            int myNumber = nums[l];
            List<List<Integer>> lists = permute(nums, l+1, h);
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            
            for (List<Integer> list : lists) {
                int oldSize = list.size();
                int newSize = oldSize + 1;
                
                for (int j=0; j<newSize; j++) {
                    List<Integer> newList = new ArrayList<Integer>();
                    Iterator<Integer> iter = list.iterator();
                    
                    while (newList.size() < newSize) {
                        if (newList.size() == j) {
                            newList.add(myNumber);
                        }
                        else {
                            newList.add(iter.next());
                        }
                    }
                    
                    ans.add(newList);
                }
            }
            
            return ans;
        }
        
    }

    public List<List<Integer>> permute2(int[] nums) {
        
        List<Integer> choices = new ArrayList<Integer>();
        List<Integer> curWorkingList = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        for (int i=0; i<nums.length; i++) {
            choices.add(nums[i]);
        }
        
        permute2(choices, curWorkingList, ans);
        
        return ans;
    }
    
    private void permute2(List<Integer> choices, 
                          List<Integer> curWorkingList, 
                          List<List<Integer>> ans) {
        
        if (choices.isEmpty()) {
            ans.add(new ArrayList<Integer>(curWorkingList));
        }
        else {
            for (int i=0; i<choices.size(); i++) {
                int myNumber = choices.remove(i);
                
                curWorkingList.add(myNumber);
                permute2(choices, curWorkingList, ans);
                curWorkingList.remove(curWorkingList.size() - 1);
                
                choices.add(i, myNumber);
            }
        }
    }
    
    public List<List<Integer>> permute3(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(num==null || num.length==0)
            return res;
        
        helper(num, new boolean[num.length], new ArrayList<Integer>(), res);
        
        return res;
    }
    
    private void helper(int[] num, 
                        boolean[] used, 
                        List<Integer> item, 
                        List<List<Integer>> res) {
        
        if (item.size() == num.length) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        
        for (int i=0;i<num.length;i++) {
            
            if (!used[i]) {
                used[i] = true;
                item.add(num[i]);
                helper(num, used, item, res);
                item.remove(item.size()-1);
                used[i] = false;
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2};
        List<List<Integer>> f = sol.permute3(nums);

        System.out.println(f);
    }

}
