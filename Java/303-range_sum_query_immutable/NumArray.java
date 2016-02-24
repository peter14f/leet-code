import java.util.Arrays;


public class NumArray {

    int[] prefixSum;
    
    public NumArray(int[] nums) {
        int n = nums.length;
        
        prefixSum = new int[n];
        
        if (n==0)
            return;
        
        prefixSum[0] = nums[0];
        
        for (int i=1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        
        //System.out.println(Arrays.toString(prefixSum));
    }

    public int sumRange(int i, int j) {
        if (j < i)
            return 0;
        if (i < 0)
            i = 0;
        if (j >= prefixSum.length)
            j = prefixSum.length - 1;
        
        if (i==0)
            return prefixSum[j];
        
        return prefixSum[j] - prefixSum[i-1];
    }
    
    public static void main(String[] args) {
        int[] nums = {-2,0,3,-5,2,-1};
        NumArray sol = new NumArray(nums);
        
        System.out.println(sol.sumRange(0, 2));
        System.out.println(sol.sumRange(2, 5));
        System.out.println(sol.sumRange(0, 5));
    }

}
