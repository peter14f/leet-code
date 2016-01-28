
public class SolutionLinearTime {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0)
            return 0;
        
        int start = 0;
        int end = 0;
        
        int sum = nums[start];
        int minLength = nums.length + 1;
        
        while (end < nums.length) {
            if (sum >= s) {
                int len = end - start + 1;
                if (len < minLength)
                    minLength = len;
                
                if (start < end) {
                    sum -= nums[start];
                    start++;
                }
            }
            else {
                end++;
                if (end < nums.length)
                    sum += nums[end];
            }
        }
        
        if (minLength == nums.length + 1)
            return 0;
        else
            return minLength;
        
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        SolutionLinearTime sol = new SolutionLinearTime();
        int len = sol.minSubArrayLen(7, nums);
        System.out.println(len);
    }

}
