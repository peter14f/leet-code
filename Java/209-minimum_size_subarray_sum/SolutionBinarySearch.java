import java.util.Arrays;


public class SolutionBinarySearch {

    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int[] sum = new int[n+1];
        
        for (int i=1; i<n+1; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        //System.out.println(Arrays.toString(nums));
        //System.out.println(Arrays.toString(sum));
        
        /*  now sum[a] - sum[b]
         *    = sum( nums[b], ..., nums[a-1] )
         *  as long as x > i
         *  
         *  sum[n] - sum[0] = sum (nums[0], ..., nums[n-1]) = sum of n values
         */
        
        int len = n + 1;
        
        for (int i=0; i<n; i++) {
            if (sum[n] - sum[i] < s)
                break;
            int end = binarySearch(i+1, n, sum[i]+s, sum);
            
            len = Math.min(len, end - i);
        }
        
        if (len == n + 1)
            return 0;
        else
            return len;
    }
    
    private int binarySearch(int low, int high, int key, int[] sum) {
        if (low == high)
            return low;
        
        int index = 0;
        int lastValidIndex = high;
        
        while (low < high) {
            index = low + (high-low)/2;
            
            if (sum[index] == key) {
                return index;
            }
            else if (sum[index] > key) {
                // too big
                lastValidIndex = index;
                high--;
            }
            else {
                // too small
                low++;
            }
        }
        
        return lastValidIndex;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        
        SolutionBinarySearch sol = new SolutionBinarySearch();
        int minLen = sol.minSubArrayLen(7, nums);
        
        System.out.println(minLen);
    }

}
