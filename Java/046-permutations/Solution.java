import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Solution {
    
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

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> f = sol.permute(nums);

        System.out.println(f);
    }

}
