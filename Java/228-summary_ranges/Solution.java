import java.util.ArrayList;
import java.util.List;


public class Solution {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<String>();
        
        if (nums.length == 0)
            return ans;
        
        StringBuffer sb = new StringBuffer();
        int begin = nums[0];
        int prev = begin;
        sb.append(prev);
        
        for (int i=1; i<nums.length; i++) {
            if (nums[i] > prev + 1) {
                if (prev != begin) {
                    sb.append("->");
                    sb.append(prev);
                    ans.add(sb.toString());
                    sb.setLength(0);
                }
                else {
                    ans.add(sb.toString());
                    sb.setLength(0);
                }
                begin = nums[i];
                prev = begin;
                sb.append(prev);
            }
            else
                prev = nums[i];
        }
        
        if (sb.length() > 0) {
            if (prev != begin) {
                sb.append("->");
                sb.append(prev);
            }
            ans.add(sb.toString());
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        Solution sol = new Solution();
        List<String> ans = sol.summaryRanges(nums);
        System.out.println(ans);
    }

}
