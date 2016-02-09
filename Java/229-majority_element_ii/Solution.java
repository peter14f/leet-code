import java.util.ArrayList;
import java.util.List;


public class Solution {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        
        Integer n1 = null;
        Integer n2 = null;
        
        int count1 = 0;
        int count2 = 0;
        
        for (int i=0; i<nums.length; i++) {
            if (n1==null) {
                n1 = nums[i];
                count1 = 1;
            }
            else if (nums[i] == n1) {
                count1++;
            }
            else if (n2 == null) {
                n2 = nums[i];
                count2 = 1;
            }
            else if (nums[i] == n2) {
                count2++;
            }
            else if (count1 == 0){
                n1 = nums[i];
                count1 = 1;
            }
            else if (count2 == 0) {
                n2 = nums[i];
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        
        int n = nums.length;
        int cnt1 = 0;
        int cnt2 = 0;
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == n1)
                cnt1++;
            else if (nums[i] == n2)
                cnt2++;
        }
        
        if (cnt1 > n/3)
            ans.add(n1);
        if (cnt2 > n/3)
            ans.add(n2);
        
        return ans;        
    }
    
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,3,4,5,6};
        Solution sol = new Solution();
        List<Integer> ans = sol.majorityElement(nums);
        System.out.println(ans);
    }

}
