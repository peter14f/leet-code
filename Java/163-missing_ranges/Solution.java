import java.util.ArrayList;
import java.util.List;


public class Solution {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        int l = lower;
        List<String> ranges = new ArrayList<String>();
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == l) {
                l++;
            }
            else if (nums[i] > l) {
                insertRanges(l, Math.min(nums[i], upper)-1, ranges);
                l = nums[i]+1;
            }
        }
        
        if (l <= upper)
            insertRanges(l, upper, ranges);
        
        return ranges;
    }
    
    private void insertRanges(int a, int b, List<String> ranges) {
        StringBuffer sb = new StringBuffer();
        
        sb.append(a);
        
        if (a < b) {
            sb.append("->");
            sb.append(b);
        }
        
        ranges.add(sb.toString());
    }
    
    public static void main(String[] args) {
        int[] nums = {2};
        Solution sol = new Solution();
        List<String> ans = sol.findMissingRanges(nums, 1, 2);
        System.out.println(ans);
    }

}
