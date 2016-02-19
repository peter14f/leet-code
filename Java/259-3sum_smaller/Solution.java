import java.util.Arrays;


public class Solution {

    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3)
            return 0;
        
        int cnt = 0;
        Arrays.sort(nums);
        
        for (int i=0; i<nums.length-2; i++) {
            int a = nums[i];
            //System.out.println("a=" + a);
            
            int j = i+1; 
            int k = nums.length - 1;
            
            int twoSumTarget = target - a;
            //System.out.println("twoSumTarget=" + twoSumTarget);
            
            while (j < k) {
                int sum = nums[j] + nums[k];
                //System.out.println("  sum=" + sum);
                if (sum >= twoSumTarget) {
                    // too big
                    k--;
                }
                else {
                    // if we fix j and decrement k until k = j+1
                    // each of these sum will be too small
                    cnt += (k-j);
                    
                    // too small
                    j++;
                }
                //System.out.println("  cnt=" + cnt);
            }
        }  // for
        
        return cnt;
    }
    
    public static void main(String[] args) {
        int[] nums = {-1, 1, -1, -1};
        
        Solution sol = new Solution();
        int cnt = sol.threeSumSmaller(nums, -1);
        
        System.out.println(cnt);
    }

}
