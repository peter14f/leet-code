import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        
        int dupCnt = 0;
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        // empty set
        subsets.add(new ArrayList<Integer>());
        
        for (int i=0; i<nums.length; i++) {
            if (i==0 || nums[i] != nums[i-1]) {
                dupCnt = 1;
                int oldSize = subsets.size();
                
                for (int j=0; j<oldSize; j++) {
                    List<Integer> newSubset = new ArrayList<Integer>(subsets.get(j));
                    newSubset.add(nums[i]);
                    subsets.add(newSubset);
                }
            }
            else {
                dupCnt++;
                int oldSize = subsets.size();
                
                for (int j=0; j<oldSize; j++) {
                    List<Integer> oldSubset = subsets.get(j);
                    
                    if (oldSubset.size() >= dupCnt-1) {
                        boolean addCurNum = true;
                        
                        for (int k=1; k<dupCnt; k++) {
                            if (oldSubset.get(oldSubset.size() - k) != nums[i]) {
                                addCurNum = false;
                                break;
                            }
                        }
                        
                        if (addCurNum) {
                            List<Integer> newSubset = new ArrayList<Integer>(oldSubset);
                            newSubset.add(nums[i]);
                            subsets.add(newSubset);
                        }
                    }
                }
            }
        }
        
        return subsets;
    }
    
    public static void main(String[] args) {
        
        int[] nums = {2, 2, 2};
        Solution sol = new Solution();
        List<List<Integer>> subsets = sol.subsetsWithDup(nums);
        System.out.println(subsets);
    }

}
