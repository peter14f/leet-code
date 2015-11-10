
public class Solution {

    // nums already sorted
    public int removeDuplicates(int[] nums) {
        if (nums==null)
            return 0;
        if (nums.length < 3) {
            return nums.length;
        }
        
        int lastNum = nums[0];
        int cnt = 1;
        int index = 1;
        // 1 1 1
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == lastNum) {
                cnt++;
            }
            else {
                cnt = 1;
            }
            
            lastNum = nums[i];
            
            if (cnt < 3) {
                nums[index] = lastNum;
                index++;
            }
        }
        
        return index;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 1, 1, 1,1 ,2, 2, 2, 3, 3, 3, 4, 4, 4};
        int len = sol.removeDuplicates(nums);
        for (int i=0; i<len; i++)
            System.out.println(nums[i]);
    }

}
