
public class Solution {

    public int findPeakElement(int[] nums) {
        int peakIndex = -1;
        
        for (int i=0; i<nums.length; i++) {
            boolean left = false;
            boolean right = false;
            
            if (i==0 || nums[i] > nums[i-1])
                left = true;
            
            if (i==nums.length-1 || nums[i] > nums[i+1])
                right = true;
            
            if (left && right) {
                peakIndex = i;
            }
        }
        
        return peakIndex;
    }
    
    public static void main(String[] args) {
        int[] nums = {1};
        Solution sol = new Solution();
        
        int peakIndex = sol.findPeakElement(nums);
        System.out.println(peakIndex);
    }

}
